package com.kapok;

import com.kapok.model.discovery.Node;
import com.kapok.model.discovery.RoleType;
import com.kapok.model.discovery.ServerConfig;
import com.kapok.service.discovery.HttpCommandUtil;
import com.kapok.service.store.Splitter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@Service
public class CoordinatorServerInitializer extends ServerInitializer implements InitializingBean {

    @Autowired
    private Splitter splitter;

    @Override
    public void afterPropertiesSet() throws Exception {
        loadConfig();
        // register itself to the coordinator
        if (ServerConfig.getRole().equalsIgnoreCase(RoleType.COORDINATOR.name())) {
            // initialize coordinator
            Node coordinatorNode = ServerConfig.getCoordinatorNode();
            splitter.getNodeManager().setCoortinatorNode(coordinatorNode);
        }

        // register worker node to the coordinator
        if (ServerConfig.getRole().equalsIgnoreCase(RoleType.WORKER.name())) {
            Node workerNode = ServerConfig.getLocalNode();
            // send a register command to coordinator
            Node coordinatorNode = ServerConfig.getCoordinatorNode();
            HttpCommandUtil.sendRegisterWorkerCommand(coordinatorNode, workerNode);
        }
    }

}
