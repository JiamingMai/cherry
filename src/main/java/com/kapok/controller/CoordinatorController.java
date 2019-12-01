package com.kapok.controller;

import com.kapok.service.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CoordinatorController {

    @Autowired
    private ServerConfig serverConfig;

    /**
     * this API is used for querying data
     */
    @RequestMapping(method = RequestMethod.GET, value = "/query")
    public void query() {
        if (!serverConfig.getRole().equals("coordinator")) {
            System.out.println("Unsupported operation.");
        }
        System.out.println("query");
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
    }

}
