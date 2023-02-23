package com.example.pathfinderdemo.model.binding;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterBindingModel {

    private String username;
    private String fullName;
    private String email;

    @Min(value = 10)
    private Integer age;
    private String password;
    private String confirmPassword;
}
