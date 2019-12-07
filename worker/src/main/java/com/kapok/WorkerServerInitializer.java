package com.kapok;

import com.kapok.model.discovery.Node;
import com.kapok.model.discovery.RoleType;
import com.kapok.model.discovery.ServerConfig;
import com.kapok.service.discovery.HttpCommandUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerServerInitializer extends ServerInitializer implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        loadConfig();
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
