package com.kapok.service;

public enum RoleType {

    COORDINATOR("coordinator"),
    WORKER("worker");

    private String type;

    RoleType(String type) {
        this.type = type;
    }

    public static RoleType getRoleByType(String type) {
        if (null == type || type.equals("")) {
            return null;
        }
        for (RoleType roleType : RoleType.values()) {
            if (roleType.type.equals(type)) {
                return roleType;
            }
        }
        return null;
    }

}
