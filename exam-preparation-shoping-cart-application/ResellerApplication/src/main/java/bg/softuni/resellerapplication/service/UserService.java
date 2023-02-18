package bg.softuni.resellerapplication.service;

import bg.softuni.resellerapplication.model.service.UserServiceModel;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id);
    void logout();
}
