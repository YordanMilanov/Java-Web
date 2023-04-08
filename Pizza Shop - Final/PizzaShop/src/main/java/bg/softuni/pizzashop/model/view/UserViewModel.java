package bg.softuni.pizzashop.model.view;

import bg.softuni.pizzashop.model.entity.Address;
import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.entity.enums.UserLevelEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserViewModel {

    private Long id;
    private String username;
    private String fullName;
    private String password;
    private String email;
    private String phone;
    private UserLevelEnum level;
    private Set<Role> roles;
    private Address address;
}
