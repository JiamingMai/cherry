package com.kapok;

import com.kapok.model.discovery.Node;
import com.kapok.model.discovery.RoleType;
import com.kapok.model.discovery.ServerConfig;
import com.kapok.service.discovery.CoordinatorHandler;
import com.kapok.service.discovery.HttpCommandUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerServerInitializer extends ServerInitializer implements InitializingBean {

    @Autowired
    private CoordinatorHandler coordinatorHandler;

    @Override
    public void afterPropertiesSet() throws Exception {
        loadConfig();
        // register worker node to the coordinator
        if (ServerConfig.getRole().equalsIgnoreCase(RoleType.WORKER.name())) {
            coordinatorHandler.start();
        }
    }

}
