package com.example.pathfinderdemo.model.service;

import com.example.pathfinderdemo.model.entity.Role;
import com.example.pathfinderdemo.model.entity.enums.LevelEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserServiceModel {

    private Long id;

    private String username;

    private String fullName;

    private String password;

    private Integer age;

    private String email;

    private LevelEnum level;

    private Set<Role> roles;
}
