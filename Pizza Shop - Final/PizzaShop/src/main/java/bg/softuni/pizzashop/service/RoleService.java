package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.service.RoleServiceModel;

import java.util.Set;

public interface RoleService {

    void initRoles();

    RoleServiceModel highestRole(Set<Role> roles);

}
