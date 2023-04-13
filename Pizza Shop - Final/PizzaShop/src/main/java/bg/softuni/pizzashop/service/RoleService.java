package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.entity.Role;

public interface RoleService {

    void initRoles();

    Role findByName(String name);
}
