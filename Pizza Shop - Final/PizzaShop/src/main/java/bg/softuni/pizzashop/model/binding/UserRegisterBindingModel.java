package bg.softuni.pizzashop.model.binding;

import javax.persistence.Column;
import javax.validation.constraints.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterBindingModel {

    @Size(min = 5, max = 20)
    private String username;

    @Size(min = 5, max = 50)
    private String fullName;

    @Email
    @NotNull
    @Size(min = 5, max = 50)
    private String email;

    @Size(min = 5, max = 20)
    private String phone;

    @Size(min = 5)
    private String password;

    @Size(min = 5)
    private String confirmPassword;

    @Size(min = 2, message = "City name must be at least 2 or more symbols")
    private String city;

    @Size(min = 2, message = "Neighborhood name must be at least 2 or more symbols")
    private String neighborhood;

    @Size(min = 2, message = "Street name must be at least 2 or more symbols")
    private String street;

    @Positive(message = "Street number must be positive")
    @NotNull(message = "You must select number")
    private int streetNumber;
}
