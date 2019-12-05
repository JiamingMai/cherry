package com.kapok.service.discovery;

import java.util.Objects;

public class Node {

    private Integer nodeId;

    /**
     * host name or ip address of the node
     */
    private String host;

    /**
     * port of the node
     */
    private Integer port;

    private StorageManager storageManager = new StorageManager();

    public Node(int nodeId, String host, int port) {
        this.nodeId = nodeId;
        this.host = host;
        this.port = port;
    }

    public int getNodeId() {
        return nodeId;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public StorageManager getStorageManager() {
        return storageManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(nodeId, node.nodeId) &&
                Objects.equals(host, node.host) &&
                Objects.equals(port, node.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeId, host, port);
    }
}
