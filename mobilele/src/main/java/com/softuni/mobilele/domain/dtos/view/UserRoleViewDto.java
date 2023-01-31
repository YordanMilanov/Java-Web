package com.softuni.mobilele.domain.dtos.view;

import com.softuni.mobilele.domain.enums.Role;

public class UserRoleViewDto {

    private Role role;

    public Role getRole() {
        return role;
    }

    public UserRoleViewDto setRole(Role role) {
        this.role = role;
        return this;
    }
}
