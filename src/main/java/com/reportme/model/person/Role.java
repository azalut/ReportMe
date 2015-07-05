package com.reportme.model.person;

public enum Role {
    ROLE_OCCUPANT("ROLE_OCCUPANT"), ROLE_ADMIN("ROLE_ADMIN"), ROLE_WORKER("ROLE_WORKER");
    private String roleString;

    Role(String roleString) {
        this.roleString = roleString;
    }

    public String getRoleString() {
        return roleString;
    }

    public void setRoleString(String roleString) {
        this.roleString = roleString;
    }
}
