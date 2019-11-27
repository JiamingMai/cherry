package com.kapok.service;

import com.kapok.store.RDF;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class NodeManager {

    private int nodeNum = 3;

    public NodeManager() {
    }

    public NodeManager(int nodeNum) {
        this.nodeNum = nodeNum;
    }

    /**
     * mapping node to a set of RDF records
     *  TODO: use concurrent hash map to improve the performance
     */
    private final Map<Node, Set<String>> nodeTable = new HashMap<>();

    /**
     * mapping RDF record to a set of nodes
     * TODO: use concurrent hash map to improve the performance
     */
    private final Map<String, Set<Node>> rdfTable = new HashMap<>();

    public void addNode(Node node) {
        nodeTable.put(node, new HashSet<>());
    }

    public synchronized void addRDF(int nodeId, RDF rdf) {
        Node node = new Node(nodeId, "localhost");
        Set<String> rdfs = nodeTable.get(node);
        if (null == rdfs) {
            rdfs = new HashSet<>();
        }
        rdfs.add(rdf.getId());
        nodeTable.put(node, rdfs);

        Set<Node> nodes = rdfTable.get(rdf.getId());
        if (null == nodes) {
            nodes = new HashSet<>();
        }
        nodes.add(node);
        rdfTable.put(rdf.getId(), nodes);

        // TODO: we should create a Node class to do this work later
        if (!nodeTable.get(node).contains(rdf)) {
            String resourcesPath = ClassLoader.getSystemResource("data.rdf").getPath();
            resourcesPath = resourcesPath.substring(0, resourcesPath.lastIndexOf("data.rdf"));
            String outputFileName = nodeId + ".rdf";
            try (PrintWriter out = new PrintWriter(new FileOutputStream(new File(resourcesPath, outputFileName), true))) {
                out.println(rdf.getId() + ":" + rdf.getSubject() + " " + rdf.getPredicate() + " " + rdf.getObject());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized boolean contains(int nodeId, RDF rdf) {
        return nodeTable.get(nodeId).contains(rdf);
    }

    public synchronized Optional<Integer> getNodeIdByRDF(RDF rdf) {
        Set<Node> nodes = rdfTable.get(rdf.getId());
        if (null == nodes || nodes.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(nodes.stream().findFirst().get().getNodeId());
    }

    public int getNodeNum() {
        return nodeNum;
    }

    public Map<Node, Set<String>> getNodeTable() {
        // TODO: use a copied map (snapshot) to avoid modifying
        return nodeTable;
    }

    public Map<String, Set<Node>> getRdfTable() {
        // TODO: use a copied map (snapshot) to avoid modifying
        return rdfTable;
    }
}
