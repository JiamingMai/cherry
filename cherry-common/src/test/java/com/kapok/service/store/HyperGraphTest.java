package com.kapok.service.store;

import com.kapok.model.store.HyperGraph;
import com.kapok.model.store.HyperVertex;
import com.kapok.model.store.RDF;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

public class HyperGraphTest {

    @Test
    public void testHyperGraph() throws Exception {
        String rdfFileName = "data.rdf";
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
    }

}
