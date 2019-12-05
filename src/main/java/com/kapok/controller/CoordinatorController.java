package com.kapok.controller;

import com.kapok.model.vo.QueryParam;
import com.kapok.service.ServerConfig;
import com.kapok.service.discovery.Node;
import com.kapok.service.discovery.StorageManager;
import com.kapok.service.query.QueryEngine;
import com.kapok.service.query.QueryResult;
import com.kapok.service.store.HyperGraph;
import com.kapok.service.store.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Controller
public class CoordinatorController {

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private Splitter splitter;

    @Autowired
    private QueryEngine queryEngine;

    /**
     * this API is used for querying data
     */
    @RequestMapping(method = RequestMethod.GET, value = "/query")
    @ResponseBody
    public QueryResult query(@RequestBody QueryParam queryParam) {
        // have a role validation first
        if (!serverConfig.getRole().equals("coordinator")) {
            System.out.println("Unsupported operation.");
        }
        System.out.println("query");
        try {
            QueryResult queryResult = queryEngine.query(queryParam.getSparql());
            return queryResult;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * this API is used for inserting data
     */
    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    public void insert(String rdfsText) {
        // have a role validation first
        if (!serverConfig.getRole().equals("coordinator")) {
            System.out.println("Unsupported operation.");
        }
        System.out.println("insert");
        StorageManager storageManager = splitter.getNodeManager().getCoortinatorNode().getStorageManager();
        HyperGraph hyperGraph = storageManager.readRdfInfoFromText(rdfsText);
        Set<String> predicates = hyperGraph.getPredicateEdges().keySet();
        for (String predicate : predicates) {
            splitter.split(hyperGraph, predicate);
        }
    }

    /**
     * this API is used for inserting data
     */
    public void insertFromLocalData() {
        if (!serverConfig.getRole().equals("coordinator")) {
            System.out.println("Unsupported operation.");
        }
        System.out.println("insert");
        // TODO: we need to improve this logic
        String rdfFileName = "data.rdf";
        StorageManager storageManager = splitter.getNodeManager().getCoortinatorNode().getStorageManager();
        HyperGraph hyperGraph = storageManager.readRdfInfo(rdfFileName);
        Set<String> predicates = hyperGraph.getPredicateEdges().keySet();
        for (String predicate : predicates) {
            splitter.split(hyperGraph, predicate);
        }
    }

    /**
     * this API is used for registering worker dynamically
     * @param nodes the nodes to be registered
     */
    @RequestMapping(method = RequestMethod.POST, value = "/registerWorker")
    @ResponseBody
    public void registerWorker(@RequestBody List<Node> nodes) {
        for (Node node : nodes) {
            splitter.getNodeManager().addNode(node);
        }
    }

}
