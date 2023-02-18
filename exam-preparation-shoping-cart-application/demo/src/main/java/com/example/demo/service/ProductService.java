package com.example.demo.service;

import com.example.demo.model.entity.CategoryNameEnum;
import com.example.demo.model.service.ProductServiceModel;
import com.example.demo.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    public BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryNameEnum categoryNameEnum);
}
