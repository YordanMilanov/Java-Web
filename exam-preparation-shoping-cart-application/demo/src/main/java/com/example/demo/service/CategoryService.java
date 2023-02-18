package com.example.demo.service;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.CategoryNameEnum;

public interface CategoryService {
    void databaseInit();

    Category findByName(CategoryNameEnum categoryNameEnum);
}
