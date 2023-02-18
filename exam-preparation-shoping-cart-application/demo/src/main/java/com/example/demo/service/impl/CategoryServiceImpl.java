package com.example.demo.service.impl;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.CategoryNameEnum;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void databaseInit() {
        if (categoryRepository.count() != 0) {
            return;
        }

        List<Category> categories = Arrays.stream(CategoryNameEnum.values())
                .map(categoryNameEnum -> {
                    Category cat = new Category();
                    cat.setName(categoryNameEnum);
                    return cat;
                }).toList();

        categoryRepository.saveAll(categories);
    }
}
