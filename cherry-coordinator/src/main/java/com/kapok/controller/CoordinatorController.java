package com.kapok.controller;

import com.kapok.model.discovery.Node;
import com.kapok.model.query.QueryParam;
import com.kapok.model.store.HyperGraph;
import com.kapok.model.discovery.ServerConfig;
import com.kapok.model.store.StoreParam;
import com.kapok.model.store.StoreResult;
import com.kapok.service.query.QueryEngine;
import com.kapok.model.query.QueryResult;
import com.kapok.service.store.HyperGraphConvertor;
import com.kapok.service.store.Splitter;
import com.kapok.service.store.StorageManager;
import com.kapok.service.store.RdfXmlParser;
import org.apache.jena.rdf.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/coordinator")
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
    @RequestMapping(method = RequestMethod.POST, value = "/query")
    @ResponseBody
    public QueryResult query(@RequestBody QueryParam queryParam) {
        // have a role validation first
        if (!serverConfig.getRole().equals("coordinator")) {
            System.out.println("Unsupported operation.");
        }
        System.out.println("query");
        try {
            QueryResult queryResult = queryEngine.query(queryParam.getSparql());
            // TODO: parse the result in front-end codes instead
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
    @ResponseBody
    public StoreResult insert(@RequestBody StoreParam storeParam) {
        // have a role validation first
        if (!serverConfig.getRole().equals("coordinator")) {
            System.out.println("Unsupported operation.");
        }
        System.out.println("insert");
        StorageManager storageManager = splitter.getNodeManager().getCoortinatorNode().getStorageManager();
        HyperGraph hyperGraph = storageManager.readRdfInfoFromText(storeParam.getRdfsText());
        Set<String> predicates = hyperGraph.getPredicateEdges().keySet();
        for (String predicate : predicates) {
            splitter.split(hyperGraph, predicate);
        }
        return new StoreResult();
    }

    /**
     * this API is used for inserting data
     */
    @RequestMapping(method = RequestMethod.POST, value = "/store")
    @ResponseBody
    public StoreResult store(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {
        // have a role validation first
        if (!serverConfig.getRole().equals("coordinator")) {
            System.out.println("Unsupported operation.");
        }
        String tmpFilePath = null;
        try {
            if (!file.isEmpty()) {
                String path = request.getServletContext().getRealPath("/tmp");
                String filename = file.getOriginalFilename();
                File filepath = new File(path, filename);
                if (!filepath.getParentFile().exists()) {
                    filepath.getParentFile().mkdirs();
                }
                file.transferTo(new File(path + File.separator + filename));
                tmpFilePath = path + File.separator + filename;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        RdfXmlParser rdfXmlParser = new RdfXmlParser();
        Model model = rdfXmlParser.parse(tmpFilePath);
        HyperGraphConvertor hyperGraphConvertor = new HyperGraphConvertor();
        HyperGraph hyperGraph = hyperGraphConvertor.convert(model);
        Set<String> predicates = hyperGraph.getPredicateEdges().keySet();
        for (String predicate : predicates) {
            splitter.split(hyperGraph, predicate);
        }

        File tmpFileToBeDeleted = new File(tmpFilePath);
        tmpFileToBeDeleted.delete();
        return new StoreResult();
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

    @RequestMapping(method = RequestMethod.POST, value = "/clearAllData")
    @ResponseBody
    public String clearAllData() {
        splitter.clearAllData();
        return "success";
    }

}
