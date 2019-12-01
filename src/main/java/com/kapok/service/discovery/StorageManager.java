package com.kapok.service.discovery;

import com.kapok.service.query.QueryCondition;
import com.kapok.service.store.HyperEdge;
import com.kapok.service.store.HyperGraph;
import com.kapok.service.store.HyperVertex;
import com.kapok.service.store.RDF;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
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

    public HyperGraph readRdfInfo() {
        return readRdfInfo(DEFAULT_FILE_NAME);
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
        //System.out.println(hyperGraph);
        return hyperGraph;
    }

    public synchronized void saveRdfInfo(RDF rdf) {
        if (!savedRdfs.contains(rdf.getId())) {
            String resourcesPath = ClassLoader.getSystemResource(DEFAULT_FILE_NAME).getPath();
            resourcesPath = resourcesPath.substring(0, resourcesPath.lastIndexOf(DEFAULT_FILE_NAME));
            String outputFileName = DEFAULT_FILE_NAME;
            try (PrintWriter out = new PrintWriter(new FileOutputStream(new File(resourcesPath, outputFileName), true))) {
                out.println(rdf.getId() + ":" + rdf.getSubject() + " " + rdf.getPredicate() + " " + rdf.getObject());
                savedRdfs.add(rdf.getId());
            } catch (Exception e) {
                e.printStackTrace();
                savedRdfs.remove(rdf.getId());
            }
        }
    }

}
