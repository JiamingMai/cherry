package com.kapok.service.query;

import com.kapok.model.store.HyperGraph;
import com.kapok.service.discovery.NodeManager;
import com.kapok.service.store.Splitter;
import com.kapok.service.store.StorageManager;
import org.junit.jupiter.api.Test;

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
        String sparql1 = "SELECT ?s FROM <http://www.kapok.com> WHERE {?s ?p ?o .}";
        QueryResult queryResult1 = queryEngine.query(sparql1);
        System.out.println(queryResult1);

        String sparql2 = "SELECT ?s FROM <http://www.kapok.com> WHERE {?s livesIn ?o .}";
        QueryResult queryResult2 = queryEngine.query(sparql2);
        System.out.println(queryResult2);
    }

}
