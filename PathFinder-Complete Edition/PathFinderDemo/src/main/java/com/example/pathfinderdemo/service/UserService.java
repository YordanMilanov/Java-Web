package com.example.pathfinderdemo.service;

import com.example.pathfinderdemo.model.entity.User;
import com.example.pathfinderdemo.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

    UserServiceModel findById(Long id);

    boolean isNameExists(String username);

    User findCurrentLoginUserEntity();
}
