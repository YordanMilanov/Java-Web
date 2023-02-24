package com.example.pathfinderdemo.model.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterBindingModel {

    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 symbols")
    private String username;

    @Size(min = 5, max = 50, message = "Username must be between 5 and 50 symbols")
    private String fullName;

    @Email(message = "invalid email")
    private String email;

    @Min(value = 10, message = "Age cannot be under 10")
    private Integer age;

    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 symbols")
    private String password;

    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 symbols")
    private String confirmPassword;
}
