package com.example.pathfinderdemo.service.impl;

import com.example.pathfinderdemo.model.entity.Category;
import com.example.pathfinderdemo.model.entity.enums.CategoryNameEnum;
import com.example.pathfinderdemo.repository.CategoryRepository;
import com.example.pathfinderdemo.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findCategoryByName(CategoryNameEnum categoryNameEnum) {
        return categoryRepository
                .findByName(categoryNameEnum)
                .orElse(null);
    }
}
