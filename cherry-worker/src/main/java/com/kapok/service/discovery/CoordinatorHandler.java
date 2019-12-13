package com.kapok.service.discovery;

import com.kapok.model.discovery.Node;
import com.kapok.model.discovery.ServerConfig;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class CoordinatorHandler {

    private final ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(10);

    public void start() {
        detectCoordinator();
    }

    private void detectCoordinator() {
        // register worker node to the coordinator
        Node workNode = ServerConfig.getLocalNode();
        Node coordinatorNode = ServerConfig.getCoordinatorNode();
        // send a register command to coordinator at fixed rate
        threadPool.scheduleAtFixedRate(() -> HttpCommandUtil.sendRegisterWorkerCommand(coordinatorNode, workNode),
                0L, 30L , TimeUnit.SECONDS);
    }

}
