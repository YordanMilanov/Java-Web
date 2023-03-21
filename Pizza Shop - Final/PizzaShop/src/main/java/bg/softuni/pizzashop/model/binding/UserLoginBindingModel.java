package bg.softuni.pizzashop.model.binding;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginBindingModel {

    @Size(min = 5, max = 20)
    private String username;

    @Size(min = 5)
    private String password;
}
