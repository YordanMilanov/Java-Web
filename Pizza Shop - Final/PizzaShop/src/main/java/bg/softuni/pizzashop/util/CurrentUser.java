package bg.softuni.pizzashop.util;

import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.entity.User;
import bg.softuni.pizzashop.model.entity.enums.UserLevelEnum;
import bg.softuni.pizzashop.model.service.OrderServiceModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Set;


@Component
//@SessionScope
@Getter
@Setter
@NoArgsConstructor
public class CurrentUser {

    private Long id;

    private String username;

    private Set<Role> roles;

    private UserLevelEnum level;

    private double orderSum;

    private OrderServiceModel currentOrder;

    private User user;
}