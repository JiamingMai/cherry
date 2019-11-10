package com.kapok;

import com.kapok.query.QueryEngine;
import com.kapok.query.QueryResult;
import com.kapok.service.Node;
import com.kapok.service.NodeManager;
import com.kapok.service.StorageManager;
import com.kapok.store.*;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

public class QueryEngineTest {

    @Test
    public void testQueryEngine() throws Exception {
        NodeManager nodeManager = new NodeManager();

        String rdfFileName = "data.rdf";
        StorageManager storageManager = new StorageManager();
        HyperGraph hyperGraph = storageManager.readRdfInfo(rdfFileName);
        Splitter splitter = new Splitter(nodeManager);
        String[] predicates = {"isNamed", "livesIn", "isFriendof", "hasAuthor", "hasCitation"};
        for (String predicate : predicates) {
            splitter.split(hyperGraph, predicate);
        }

        QueryEngine queryEngine = new QueryEngine(nodeManager);
        String sparql = "SELECT ?s FROM <http://www.kapok.com> WHERE {?s ?p ?o}";
        QueryResult queryResult = queryEngine.query(sparql);
        System.out.println(queryResult);
    }

}
