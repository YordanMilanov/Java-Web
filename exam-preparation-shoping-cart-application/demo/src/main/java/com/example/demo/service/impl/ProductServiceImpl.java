package com.example.demo.service.impl;

import com.example.demo.model.entity.CategoryNameEnum;
import com.example.demo.model.entity.Product;
import com.example.demo.model.service.ProductServiceModel;
import com.example.demo.model.view.ProductViewModel;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel, Product.class);
        product.setCategory(categoryService.findByName(productServiceModel.getCategory()));

        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {
        return productRepository.findTotalProductsSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryNameEnum categoryNameEnum) {
        return productRepository
                .findAllByCategory_Name(categoryNameEnum)
                .stream().map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }
}
