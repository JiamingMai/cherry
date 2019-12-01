package com.kapok.service.store;

import com.kapok.service.discovery.NodeManager;

import java.util.*;

public class Splitter {

    private NodeManager nodeManager;

    private final int DEFAULT_BLOCK_SIZE = 64;

    private final int DEFAULT_CHUNK_SIZE_PER_NODE = 10;

    public Splitter(NodeManager nodeManager) {
        this.nodeManager = nodeManager;
    }

    public void split(HyperGraph hyperGraph, String predicate) {
        // Step 1. Select subject subset
        Map<String, HyperEdge> subjectSet = findSubjectSetByPredicate(hyperGraph.getSubjectEdges(), predicate);
        // Step 2. Divide subject set into smaller block set
        List<Map<String, HyperEdge>> blockSet = divide(subjectSet);

        Map<String, HyperEdge> predecessorSet = new HashMap<>();
        for (Map<String, HyperEdge> subjectBlock : blockSet) {
            while (true) {
                // Step 3. Select object set by predicate and subject
                Map<String, HyperEdge> objectFullSet = new HashMap<>();
                for (String subject : subjectBlock.keySet()) {
                    Map<String, HyperEdge> objectSet = findObjectSetByPredicateAndSubject(hyperGraph.getObjectEdge(), subject, predicate);
                    // Step 4. Choose slave node to store data
                    Optional<Integer> nodeIndex = chooseSlave(subject, objectSet, predecessorSet);
                    // Step 5. Place the triples in slave i
                    if (null == nodeIndex.get()) {
                        // TODO: divide object set into k sub object sets
                    } else {
                        saveTriples(objectSet.values(), nodeIndex.get());
                    }
                    // save this object set to the object full set
                    for (Map.Entry<String, HyperEdge> entry : objectSet.entrySet()) {
                        objectFullSet.put(entry.getKey(), entry.getValue());
                    }
                }
                // do swapping here
                if (objectFullSet.isEmpty()) {
                    break;
                }
                predecessorSet = subjectBlock;
                subjectBlock = findSubjectSetFromSubjectBlock(subjectBlock, objectFullSet);
            }
            // TODO: do some post-processing here
        }
    }

    private Map<String, HyperEdge> findSubjectSetFromSubjectBlock(Map<String, HyperEdge> subjectBlock, Map<String, HyperEdge> objectSet) {
        // extract all the object names from the given object set
        Set<String> objectNameSet = new HashSet<>();
        for (HyperEdge hyperEdge : objectSet.values()) {
            for (HyperVertex hyperVertex : hyperEdge.getVertices()) {
                objectNameSet.add(hyperVertex.getRdf().getObject());
            }
        }
        // select a new subject set with the extracted object names
        Map<String, HyperEdge> newSubjectSet = new HashMap<>();
        for (HyperEdge hyperEdge : subjectBlock.values()) {
            for (HyperVertex hyperVertex : hyperEdge.getVertices()) {
                String subjectName = hyperVertex.getRdf().getSubject();
                if (objectNameSet.contains(subjectName)) {
                    newSubjectSet.put(subjectName, hyperEdge);
                }
            }
        }
        return newSubjectSet;
    }

    /**
     * This method is used for dividing subject set into smaller block set
     *
     * @param subjectSet the subject set
     * @return a list of smaller blocks
     */
    private List<Map<String, HyperEdge>> divide(Map<String, HyperEdge> subjectSet) {
        List<Map<String, HyperEdge>> blockSet = new ArrayList<>();
        if (subjectSet.size() < DEFAULT_BLOCK_SIZE) {
            blockSet.add(subjectSet);
            return blockSet;
        }
        // notice the fact that blockNum = subjectSet.size() / DEFAULT_BLOCK_SIZE + 1;
        int entryIndex = 0;
        int blockIndex = 0;
        Map<String, HyperEdge> block = new HashMap<>();
        for (Map.Entry<String, HyperEdge> entry : subjectSet.entrySet()) {
            if (entryIndex >= (blockIndex + 1) * DEFAULT_BLOCK_SIZE) {
                blockSet.add(block);
                block = new HashMap<>();
                blockIndex++;
            }
            block.put(entry.getKey(), entry.getValue());
            entryIndex++;
        }
        return blockSet;
    }

    private void saveTriples(Collection<HyperEdge> hyperEdges, int nodeId) {
        Set<HyperVertex> triples = new HashSet<>();
        for (HyperEdge hyperEdge : hyperEdges) {
            triples.addAll(hyperEdge.getVertices());
        }
        // save triples in slave i
        for (HyperVertex hyperVertex : triples) {
            nodeManager.addRDF(nodeId, hyperVertex.getRdf());
        }
    }

    private Optional<Integer> chooseSlave(String subject, Map<String, HyperEdge> objectSet, Map<String, HyperEdge> predecessorSet) {
        if (objectSet.size() > DEFAULT_CHUNK_SIZE_PER_NODE) {
            return Optional.empty();
        }
        // get one predecessor
        for (HyperEdge hyperEdge : predecessorSet.values()) {
            for (HyperVertex hyperVertex : hyperEdge.getVertices()) {
                if (hyperVertex.getRdf().getObject().equals(subject)) {
                    // here we need a map to record the relation from vertex to nodeId
                    // vertex --> nodeId
                    Optional<Integer> nodeId = nodeManager.getNodeIdByRDF(hyperVertex.getRdf());
                    if (null != nodeId.get()) {
                        return nodeId;
                    }
                }
            }
        }
        // no related predecessor found, we find the node with maximal space instead
        // TODO: now we use random policy for debugging temporarily
        int selectedNodeId = (int) (Math.random() * nodeManager.getNodeNum());
        return Optional.of(selectedNodeId);
    }

    private Map<String, HyperEdge> findObjectSetByPredicateAndSubject(
            Map<String, HyperEdge> objectEdges,
            String subject,
            String predicate) {
        Map<String, HyperEdge> objectSet = new HashMap<>();
        for (Map.Entry<String, HyperEdge> entry : objectEdges.entrySet()) {
            HyperEdge edge = new HyperEdge();
            Set<HyperVertex> vertices = entry.getValue().getVertices();
            for (HyperVertex vertex : vertices) {
                if (vertex.getRdf().getSubject().equals(subject) && vertex.getRdf().getPredicate().equals(predicate)) {
                    edge.addVertex(vertex);
                }
            }
            if (!edge.getVertices().isEmpty()) {
                objectSet.put(entry.getKey(), edge);
            }
        }
        return objectSet;
    }

    private Map<String, HyperEdge> findSubjectSetByPredicate(Map<String, HyperEdge> subjectEdges, String predicate) {
        Map<String, HyperEdge> subjectSet = new HashMap<>();
        for (Map.Entry<String, HyperEdge> entry : subjectEdges.entrySet()) {
            HyperEdge edge = new HyperEdge();
            Set<HyperVertex> vertices = entry.getValue().getVertices();
            for (HyperVertex vertex : vertices) {
                if (vertex.getRdf().getPredicate().equals(predicate)) {
                    edge.addVertex(vertex);
                }
            }
            if (!edge.getVertices().isEmpty()) {
                subjectSet.put(entry.getKey(), edge);
            }
        }
        return subjectSet;
    }

}
