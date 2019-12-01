package com.kapok.service.store;

import com.kapok.service.discovery.NodeManager;
import com.kapok.service.discovery.StorageManager;
import org.junit.jupiter.api.Test;

public class SplitterTest {

    @Test
    public void testSplitter() {
        String rdfFileName = "data.rdf";
        StorageManager storageManager = new StorageManager();
        HyperGraph hyperGraph = storageManager.readRdfInfo(rdfFileName);
        Splitter splitter = new Splitter(new NodeManager());
        String[] predicates = {"isNamed", "livesIn", "isFriendof", "hasAuthor", "hasCitation"};
        for (String predicate : predicates) {
            splitter.split(hyperGraph, predicate);
        }
    }

}
