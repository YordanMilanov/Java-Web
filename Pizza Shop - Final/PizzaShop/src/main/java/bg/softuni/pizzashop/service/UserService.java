package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.service.UserServiceModel;

import java.util.Set;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username, Set<Role> roles);
}
