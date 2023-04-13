package bg.softuni.pizzashop.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
