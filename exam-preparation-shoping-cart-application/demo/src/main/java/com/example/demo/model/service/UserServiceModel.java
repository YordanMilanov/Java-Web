package com.example.demo.model.service;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserServiceModel {

    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String email;

}
