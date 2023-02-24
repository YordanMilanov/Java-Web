package com.example.pathfinderdemo.service;

import com.example.pathfinderdemo.model.entity.Category;
import com.example.pathfinderdemo.model.entity.enums.CategoryNameEnum;

import java.util.Optional;

public interface CategoryService {

    Category findCategoryByName(CategoryNameEnum categoryNameEnum);
}
