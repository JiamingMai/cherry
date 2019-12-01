package com.kapok.service;

import org.springframework.stereotype.Component;

@Component
public class ServerConfig {

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
