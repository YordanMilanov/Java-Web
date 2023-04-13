package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.entity.User;
import bg.softuni.pizzashop.model.entity.enums.UserLevelEnum;
import bg.softuni.pizzashop.model.service.UserServiceModel;

import java.util.Set;

public interface AuthService {

    void loginUser(Long id, String username, Set<Role> roles, UserLevelEnum level);

    public UserServiceModel registerUser(UserServiceModel userServiceModel);

    public User getUserByUsername(String username);
}
