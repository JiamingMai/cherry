package com.kapok.store;

import java.util.*;

public class Splitter {

    public void findSubjectSetByPredicate(HyperGraph hyperGraph, String predicate) {
        // Step 1. Select subject subset
        Map<String, HyperEdge> subjectSet = findSubjectSetByPredicate(hyperGraph.getSubjectEdges(), predicate);
        // TODO: Step 2. Divide subject set into smaller block set
        while (true) {
            // TODO: Step 3. Select object set by predicate and subject
            for (String subject : subjectSet.keySet()) {
                Map<String, HyperEdge> objectSet = findObjectSetByPredicateAndSubject(hyperGraph.getObjectEdge(), subject, predicate);
                // Step 4. Choose slave node to store data
                int nodeIndex = chooseSlave();
                // Step 5. Place the triples in slave i
                saveTriples(objectSet.values(), nodeIndex);
            }
            // TODO: do swapping here
        }
        // TODO: do some post-processing here
    }

    private void saveTriples(Collection<HyperEdge> hyperEdges, int nodeIndex) {
        Set<HyperVertex> triples = new HashSet<>();
        for (HyperEdge hyperEdge : hyperEdges) {
            triples.addAll(hyperEdge.getVertices());
        }
        // TODO: save triples in slave i
    }

    private int chooseSlave() {
        // TODO: implement this method here
        return -1;
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
            if (!vertices.isEmpty()) {
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
            if (!vertices.isEmpty()) {
                subjectSet.put(entry.getKey(), edge);
            }
        }
        return subjectSet;
    }

}
