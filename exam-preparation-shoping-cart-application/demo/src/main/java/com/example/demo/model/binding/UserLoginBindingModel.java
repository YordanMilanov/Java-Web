package com.example.demo.model.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginBindingModel {

    @NotBlank(message = "username cannot be empty")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 character")
    private String username;

    @NotBlank(message = "username cannot be empty")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 character")
    private String password;
}
