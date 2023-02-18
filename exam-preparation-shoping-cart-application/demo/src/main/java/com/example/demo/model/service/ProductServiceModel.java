package com.example.demo.model.service;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.CategoryNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ProductServiceModel {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime neededBefore;
    private CategoryNameEnum category;
}
