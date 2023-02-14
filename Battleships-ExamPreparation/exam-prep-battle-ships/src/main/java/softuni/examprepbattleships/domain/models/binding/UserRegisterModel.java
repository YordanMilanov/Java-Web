package softuni.examprepbattleships.domain.models.binding;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterModel {

    @Size(min = 3, max = 10)
    @NotBlank
    @NotNull
    private String username;

    @Size(min = 5, max = 20)
    @NotBlank
    @NotNull
    private String fullName;

    @Size(min = 3)
    @NotBlank
    @NotNull
    private String password;

    @NotNull
    @NotBlank
    private String confirmPassword;

    @Email
    @NotNull
    @NotBlank
    private String email;
}
