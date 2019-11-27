package com.kapok.service;

import java.util.Objects;

public class Node {

    private int nodeId;

    /**
     * host name or ip address of the node
     */
    private String host;

    private StorageManager storageManager = new StorageManager();

    public Node(int nodeId, String host) {
        this.nodeId = nodeId;
        this.host = host;
    }

    public int getNodeId() {
        return nodeId;
    }

    public String getHost() {
        return host;
    }

    public StorageManager getStorageManager() {
        return storageManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return nodeId == node.nodeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeId);
    }
}
