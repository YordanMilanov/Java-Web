package com.softuni.mobilele.services.role;

import com.softuni.mobilele.domain.dtos.model.UserRoleModel;
import com.softuni.mobilele.domain.dtos.view.UserRoleViewDto;
import com.softuni.mobilele.services.init.DataBaseInitService;

import java.util.List;


public interface UserRoleService extends DataBaseInitService {
    public List<UserRoleViewDto> getAll();

    List<UserRoleModel> findAllRoles();

    UserRoleModel findRoleByName(String name);
}
