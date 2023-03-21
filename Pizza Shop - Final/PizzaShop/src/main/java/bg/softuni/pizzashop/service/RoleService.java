package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.entity.Role;

import java.util.Set;

public interface RoleService {

    void initRoles();

    boolean isEmployee(Set<Role> roles);
    boolean isManager(Set<Role> roles);
    boolean isCustomer(Set<Role> roles);
}
