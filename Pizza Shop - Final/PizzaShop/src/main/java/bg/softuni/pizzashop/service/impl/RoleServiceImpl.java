package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.entity.enums.RoleNameEnum;
import bg.softuni.pizzashop.repository.RoleRepository;
import bg.softuni.pizzashop.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void initRoles() {
        if(roleRepository.count() != 0) {
            return;
        }

        Arrays.stream(RoleNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Role role = new Role();
                    role.setRole(categoryNameEnum);
                    switch (categoryNameEnum) {
                        case CUSTOMER -> role.setDescription("customer description");
                        case STAFF -> role.setDescription("staff description");
                        case MANAGER -> role.setDescription("manager description");
                    }
                    roleRepository.save(role);
                });
    }

    @Override
    public boolean isEmployee(Set<Role> roles) {
        boolean isEmployee = false;
        for (Role role : roles) {
            isEmployee = role.getRole().equals(RoleNameEnum.STAFF);
        }
        return isEmployee;
    }

    public boolean isStaff(Set<Role> roles) {
        boolean isStaff = false;
        for (Role role : roles) {
            isStaff = role.getRole().equals(RoleNameEnum.STAFF);
        }
        return isStaff;
    }

    public boolean isManager(Set<Role> roles) {
        boolean isManager = false;
        for (Role role : roles) {
            isManager = role.getRole().equals(RoleNameEnum.MANAGER);
        }
        return isManager;
    }

    public boolean isCustomer(Set<Role> roles) {
        boolean isCustomer = false;
        for (Role role : roles) {
            isCustomer = role.getRole().equals(RoleNameEnum.CUSTOMER);
        }
        return isCustomer;
    }
}
