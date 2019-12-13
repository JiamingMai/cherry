package com.kapok.controller;

import com.kapok.model.store.RDF;
import com.kapok.model.store.HyperGraph;
import com.kapok.service.store.StorageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private StorageManager storageManager;

    @RequestMapping(method = RequestMethod.POST, value = "/saveRdfs")
    @ResponseBody
    public void saveRdfs(@RequestBody RDF rdf) {
        System.out.println("saveRdfs is called.");
        storageManager.saveRdfInfo(rdf);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loadRdfs")
    @ResponseBody
    public HyperGraph loadRdfs() {
        System.out.println("loadRdfs is called.");
        HyperGraph hyperGraph = storageManager.readRdfInfo();
        return hyperGraph;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loadRdfsAsString")
    @ResponseBody
    public String loadRdfsAsString() {
        System.out.println("loadRdfs is called.");
        HyperGraph hyperGraph = storageManager.readRdfInfo();
        return hyperGraph.toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteRdfs")
    @ResponseBody
    public String deleteRdfs() {
        storageManager.deleteRdfs();
        return "success";
    }

}
