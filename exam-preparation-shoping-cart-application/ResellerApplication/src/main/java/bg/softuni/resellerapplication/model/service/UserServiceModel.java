package bg.softuni.resellerapplication.model.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserServiceModel {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
}
