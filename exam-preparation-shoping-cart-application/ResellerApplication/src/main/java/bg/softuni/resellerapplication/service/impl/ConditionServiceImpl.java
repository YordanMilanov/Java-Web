package bg.softuni.resellerapplication.service.impl;

import bg.softuni.resellerapplication.model.entity.Condition;
import bg.softuni.resellerapplication.model.enums.ConditionName;
import bg.softuni.resellerapplication.repository.ConditionRepository;
import bg.softuni.resellerapplication.service.ConditionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConditionServiceImpl implements ConditionService {

    private final ConditionRepository conditionRepository;

    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void initializeConditions() {
        if (conditionRepository.count() != 0) {
            return;
        }
            Arrays.stream(ConditionName.values())
                    .forEach(conditionName -> {
                        Condition condition = new Condition(conditionName);
                        switch (conditionName) {
                            case EXCELLENT -> condition.setDescription("In perfect condition");
                            case GOOD -> condition.setDescription("Some signs of wear and tear or minor defects");
                            case ACCEPTABLE -> condition.setDescription("The item is fairly worn but continues to function properly");
                        }
                        conditionRepository.save(condition);
                    });
    }
}
