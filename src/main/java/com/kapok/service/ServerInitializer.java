package com.kapok.service;

import com.kapok.service.discovery.Node;
import com.kapok.service.store.Splitter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@Service
public class ServerInitializer implements InitializingBean {

    private final String CONFIG_FILE_NAME = "config.properties";

    @Autowired
    private Splitter splitter;

    @Autowired
    private ServerConfig serverConfig;

    @Override
    public void afterPropertiesSet() throws Exception {
        // set configuration for this server
        String configFile = this.getClass().getClassLoader().getResource(CONFIG_FILE_NAME).getFile();
        try {
            Properties props = new Properties();
            props.load(new InputStreamReader(new FileInputStream(configFile), "UTF-8"));
            serverConfig.setRole(props.getProperty("role"));
            serverConfig.setAddress(props.getProperty("address"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // register all the nodes on the coordinator
        if (serverConfig.getRole().equals(RoleType.COORDINATOR.name())) {
            // initialize coordinator
            String[] hostAndPort = serverConfig.getAddress().split(":");
            String host = hostAndPort[0];
            int port = Integer.valueOf(hostAndPort[1]);
            Node coordinatorNode = new Node(1, host, port);
            splitter.getNodeManager().setCoortinatorNode(coordinatorNode);
        }
    }

}
