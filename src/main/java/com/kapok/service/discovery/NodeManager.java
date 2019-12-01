package com.kapok.service.discovery;

import com.kapok.service.store.RDF;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class NodeManager {

    private int nodeNum = 3;

    private HttpCommandHandler httpCommandHandler = new HttpCommandHandler();

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

        // send a HTTP POST request to save the rdf on the concrete node
        httpCommandHandler.sendSaveRdfsCommand(node, rdf);
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
