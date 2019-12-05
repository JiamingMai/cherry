package com.kapok.service;

import com.kapok.service.discovery.HttpCommandUtil;
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
            serverConfig.setCoordinatorAddress(props.getProperty("coordinator.address"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // register itself to the coordinator
        if (serverConfig.getRole().equalsIgnoreCase(RoleType.COORDINATOR.name())) {
            // initialize coordinator
            String[] hostAndPort = serverConfig.getAddress().split(":");
            String host = hostAndPort[0];
            int port = Integer.valueOf(hostAndPort[1]);
            Node coordinatorNode = new Node(1, host, port);
            splitter.getNodeManager().setCoortinatorNode(coordinatorNode);
        }

        // register worker node to the coordinator
        if (serverConfig.getRole().equalsIgnoreCase(RoleType.WORKER.name())) {
            String[] hostAndPort = serverConfig.getAddress().split(":");
            String host = hostAndPort[0];
            int port = Integer.valueOf(hostAndPort[1]);
            Node workerNode = new Node(1, host, port);
            // send a register command to coordinator
            String[] coordinatorHostAndPort = serverConfig.getCoordinatorAddress().split(":");
            String coordinatorHost = coordinatorHostAndPort[0];
            int coordinatorPort = Integer.valueOf(coordinatorHostAndPort[1]);
            Node coordinatorNode = new Node(1, coordinatorHost, coordinatorPort);
            HttpCommandUtil.sendRegisterWorkerCommand(coordinatorNode, workerNode);
        }
    }

}
