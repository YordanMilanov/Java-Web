package softuni.examprepbattleships.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.examprepbattleships.validations.validateLoginForm.ValidateLoginForm;

@Getter
@Setter
@NoArgsConstructor
@ValidateLoginForm
public class UserLoginModel {
    private String username;
    private String password;

}
