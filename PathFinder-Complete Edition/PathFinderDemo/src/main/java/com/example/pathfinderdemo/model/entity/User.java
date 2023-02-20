package com.example.pathfinderdemo.model.entity;

import com.example.pathfinderdemo.model.entity.enums.LevelEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String fullName;

    @Column
    private String password;

    @Column
    private Integer age;

    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    //relations
    @ManyToMany
    private Set<Role> roles;
}
