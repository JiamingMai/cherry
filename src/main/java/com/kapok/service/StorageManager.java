package com.kapok.service;

import com.kapok.query.QueryCondition;
import com.kapok.store.HyperEdge;
import com.kapok.store.HyperGraph;
import com.kapok.store.HyperVertex;
import com.kapok.store.RDF;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StorageManager {

    public List<RDF> filter(HyperGraph hyperGraph, QueryCondition queryCondition) {
        List<RDF> rdfs = new ArrayList<>();
        // this indicates that there is no WHERE condition
        for (HyperEdge hyperEdge : hyperGraph.getSubjectEdges().values()) {
            for (HyperVertex hyperVertex : hyperEdge.getVertices()) {
                rdfs.add(hyperVertex.getRdf());
            }
        }
        return rdfs;

        // do filtering here
        /*
        Map<String, HyperEdge> subjectEdges = hyperGraph.getSubjectEdges();
        HyperEdge hyperEdge = subjectEdges.get(queryCondition.getSubject());
        for ( HyperVertex hyperVertex : hyperEdge.getVertices()) {
            RDF rdf = hyperVertex.getRdf();
            if (hyperVertex.getRdf().getPredicate().equals(queryCondition.getPredicate()) &&
                    hyperVertex.getRdf().getObject().equals(queryCondition.getObject())) {
                rdfs.add(rdf);
            }
        }
        return rdfs;
        */
    }

    public HyperGraph readRdfInfo(String rdfFileName) {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(rdfFileName);
        HyperGraph hyperGraph = new HyperGraph();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(":");
            String id = fields[0];
            String content = fields[1];
            String[] rdfElements = content.split(" ");
            String subject = rdfElements[0];
            String predicate = rdfElements[1];
            String object = rdfElements[2];
            RDF rdf = new RDF(id, subject, predicate, object);
            hyperGraph.addVertex(new HyperVertex(rdf));
        }
        System.out.println(hyperGraph);
        return hyperGraph;
    }

}
