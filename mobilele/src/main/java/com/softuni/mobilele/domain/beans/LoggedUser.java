package com.softuni.mobilele.domain.beans;

import com.softuni.mobilele.domain.dtos.model.UserRoleModel;

public class LoggedUser {

    private String id;
    private String username;
    private UserRoleModel roleModel;

    public LoggedUser() {
    }

    public String getId() {
        return id;
    }

    public LoggedUser setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserRoleModel getRoleModel() {
        return roleModel;
    }

    public LoggedUser setRoleModel(UserRoleModel roleModel) {
        this.roleModel = roleModel;
        return this;
    }
}
