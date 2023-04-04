package bg.softuni.pizzashop.model.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
}
