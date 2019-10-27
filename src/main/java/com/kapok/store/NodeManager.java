package com.kapok.store;

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
     * mapping node id to a set of RDF records
     */
    Map<Integer, Set<String>> nodeTable = new HashMap<>();

    /**
     * mapping RDF record to a set of node ids
     */
    Map<String, Set<Integer>> rdfTable = new HashMap<>();

    public synchronized void addRDF(int nodeId, RDF rdf) {
        Set<String> rdfs = nodeTable.get(nodeId);
        if (null == rdfs) {
            rdfs = new HashSet<>();
        }
        rdfs.add(rdf.getId());
        nodeTable.put(nodeId, rdfs);

        Set<Integer> nodeIds = rdfTable.get(rdf.getId());
        if (null == nodeIds) {
            nodeIds = new HashSet<>();
        }
        nodeIds.add(nodeId);
        rdfTable.put(rdf.getId(), nodeIds);

        // TODO: we should create a Node class to do this work later
        //String resourcesPath = ClassLoader.getSystemResource("output").getPath();
        String outputFileName = nodeId + ".rdf";
        try (PrintWriter out = new PrintWriter(new FileOutputStream(new File(outputFileName), true))) {
            out.println(rdf.getId() + ":" + rdf.getSubject() + " " + rdf.getPredicate() + " " + rdf.getObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized Optional<Integer> getNodeIdByRDF(RDF rdf) {
        Set<Integer> nodeIds = rdfTable.get(rdf.getId());
        if (null == nodeIds || nodeIds.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(nodeIds.stream().findFirst().get());
    }

    public int getNodeNum() {
        return nodeNum;
    }
}
