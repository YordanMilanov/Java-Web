package com.plannerapp.service.impl;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.enums.PriorityName;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.service.PriorityService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PriorityServiceImpl implements PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void initCategories() {
        if (priorityRepository.count() != 0) {
            return;
        }
        Arrays.stream(PriorityName.values())
                .forEach(priorityNameEnum -> {
                    Priority priority = new Priority();
                    priority.setName(priorityNameEnum);
                    switch (priorityNameEnum) {
                        case URGENT ->
                                priority.setDescription("An urgent problem that blocks the system use until the issue is resolved.");
                        case IMPORTANT ->
                                priority.setDescription("A core functionality that your product is explicitly supposed to perform is compromised.");
                        case LOW ->
                                priority.setDescription("Should be fixed if time permits but can be postponed.");
                    }

                    priorityRepository.save(priority);
                });
    }
}
