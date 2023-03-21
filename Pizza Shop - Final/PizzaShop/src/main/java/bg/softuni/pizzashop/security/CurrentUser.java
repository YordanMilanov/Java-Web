package bg.softuni.pizzashop.security;

import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.entity.enums.RoleNameEnum;
import bg.softuni.pizzashop.model.entity.enums.UserLevelEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Set;

@Component
@SessionScope
@NoArgsConstructor
@Getter
@Setter
public class CurrentUser {

    private Long id;

    //not needed
    private String username;

    private Set<Role> roles;

    private UserLevelEnum level;
}