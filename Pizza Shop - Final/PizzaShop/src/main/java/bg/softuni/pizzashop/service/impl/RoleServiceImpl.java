package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.entity.enums.RoleNameEnum;
import bg.softuni.pizzashop.model.service.RoleServiceModel;
import bg.softuni.pizzashop.repository.RoleRepository;
import bg.softuni.pizzashop.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
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
    public Role findByName(String name) {
        return roleRepository.findByRole(name).get();
    }


//    @Override
//    public RoleServiceModel highestRole(Set<Role> roles) {
//        Long roleId = Long.MAX_VALUE;
//        for (Role role : roles) {
//            if(role.getId() < roleId) {
//           roleId = role.getId();
//            }
//        }
//        Role roleToMap = roleRepository.findById(roleId).orElse(null);
//        return modelMapper.map(roleToMap, RoleServiceModel.class);
//    }

}
