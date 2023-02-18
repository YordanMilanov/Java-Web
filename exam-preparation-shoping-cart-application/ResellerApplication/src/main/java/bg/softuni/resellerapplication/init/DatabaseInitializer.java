package bg.softuni.resellerapplication.init;

import bg.softuni.resellerapplication.service.ConditionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final ConditionService conditionService;

    public DatabaseInitializer(ConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @Override
    public void run(String... args) throws Exception {
        conditionService.initializeConditions();
    }
}
