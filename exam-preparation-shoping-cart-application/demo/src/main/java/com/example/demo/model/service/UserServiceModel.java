package com.example.demo.model.service;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserServiceModel {

    private Long id;

    private String username;

    private String password;

    private String email;

}
