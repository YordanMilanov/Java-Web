package com.softuni.mobilele.services.user;

import com.softuni.mobilele.domain.dtos.banding.UserRegisterFormDto;
import com.softuni.mobilele.domain.dtos.model.UserModel;
import org.springframework.stereotype.Service;

public interface UserService{
    UserModel registerUser(UserRegisterFormDto userRegister);
}
