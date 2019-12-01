package com.kapok.service;

import org.springframework.stereotype.Component;

@Component
public class ServerConfig {

    private String role;

    private String address;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
