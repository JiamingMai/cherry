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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

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
    public void insert() {
        if (!serverConfig.getRole().equals("coordinator")) {
            System.out.println("Unsupported operation.");
        }
        System.out.println("insert");
        // TODO: we need to improve this logic
        String rdfFileName = "data.rdf";
        StorageManager storageManager = splitter.getNodeManager().getCoortinatorNode().getStorageManager();
        HyperGraph hyperGraph = storageManager.readRdfInfo(rdfFileName);
        String[] predicates = {"isNamed", "livesIn", "isFriendof", "hasAuthor", "hasCitation"};
        for (String predicate : predicates) {
            splitter.split(hyperGraph, predicate);
        }
    }

    /**
     * this API is used for registering worker dynamically
     * @param node the node to be registered
     */
    @RequestMapping(method = RequestMethod.POST, value = "/registerWorker")
    public void registerWorker(@RequestBody Node node) {
        splitter.getNodeManager().addNode(node);
    }

}
