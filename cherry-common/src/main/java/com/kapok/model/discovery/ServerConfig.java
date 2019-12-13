package com.kapok.model.discovery;

import org.springframework.stereotype.Component;

@Component
public class ServerConfig {

    private static String role;

    private static String address;

    private static String coordinatorAddress;

    public static Node getLocalNode() {
        if (null != address && !address.isEmpty()) {
            String[] hostAndPort = address.split(":");
            String host = hostAndPort[0];
            int port = Integer.valueOf(hostAndPort[1]);
            Node node = new Node(1, host, port);
            return node;
        }
        return null;
    }

    public static Node getCoordinatorNode() {
        if (null != coordinatorAddress && !coordinatorAddress.isEmpty()) {
            String[] coordinatorHostAndPort = coordinatorAddress.split(":");
            String coordinatorHost = coordinatorHostAndPort[0];
            int coordinatorPort = Integer.valueOf(coordinatorHostAndPort[1]);
            Node coordinatorNode = new Node(1, coordinatorHost, coordinatorPort);
            return coordinatorNode;
        }
        return null;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        ServerConfig.role = role;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        ServerConfig.address = address;
    }

    public static String getCoordinatorAddress() {
        return coordinatorAddress;
    }

    public static void setCoordinatorAddress(String coordinatorAddress) {
        ServerConfig.coordinatorAddress = coordinatorAddress;
    }
}
