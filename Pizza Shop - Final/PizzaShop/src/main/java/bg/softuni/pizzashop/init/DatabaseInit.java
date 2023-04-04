package bg.softuni.pizzashop.init;

import bg.softuni.pizzashop.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final RoleService roleService;


    public DatabaseInit(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        //This is the other way to initialize the database on first launch
        //     roleService.initRoles();
    }
}
