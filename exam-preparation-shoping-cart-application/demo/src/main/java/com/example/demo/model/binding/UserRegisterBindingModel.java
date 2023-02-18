package com.example.demo.model.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterBindingModel {

    @Size(min = 3, max = 20)
    private String username;

    @Email
    private String email;

    @Size(min = 3, max = 20)
    private String password;

    @Size(min = 3, max = 20)
    private String confirmPassword;
}
