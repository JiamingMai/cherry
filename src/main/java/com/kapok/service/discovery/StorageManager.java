package com.kapok.service.discovery;

import com.kapok.service.query.QueryCondition;
import com.kapok.service.store.HyperEdge;
import com.kapok.service.store.HyperGraph;
import com.kapok.service.store.HyperVertex;
import com.kapok.service.store.RDF;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class StorageManager {

    private final String DEFAULT_FILE_NAME = "local_data.rdf";

    private Set<String> savedRdfs = new HashSet<>();

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

    public HyperGraph readRdfInfoFromText(String text) {
        HyperGraph hyperGraph = new HyperGraph();
        String[] lines = text.split("\n");
        for (String line : lines) {
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
        return hyperGraph;
    }

    public HyperGraph readRdfInfo() {
        return readRdfInfo(DEFAULT_FILE_NAME);
    }

    public HyperGraph readRdfInfo(String rdfFileName) {
        try {
            InputStream inputStream = new FileInputStream(this.getClass().getClassLoader().getResource(rdfFileName).getFile());
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
            //System.out.println(hyperGraph);
            return hyperGraph;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized void saveRdfInfo(RDF rdf) {
        if (!savedRdfs.contains(rdf.getId())) {
            String outputFileName = this.getClass().getClassLoader().getResource(DEFAULT_FILE_NAME).getFile();
            try (PrintWriter out = new PrintWriter(new FileOutputStream(new File(outputFileName), true))) {
                out.println(rdf.getId() + ":" + rdf.getSubject() + " " + rdf.getPredicate() + " " + rdf.getObject());
                savedRdfs.add(rdf.getId());
            } catch (Exception e) {
                e.printStackTrace();
                savedRdfs.remove(rdf.getId());
            }
        }
    }

}
