package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Ingredient;
import bg.softuni.pizzashop.model.entity.Product;
import bg.softuni.pizzashop.model.service.ProductServiceModel;
import bg.softuni.pizzashop.repository.ProductRepository;
import bg.softuni.pizzashop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductServiceModel saveProduct(ProductServiceModel productServiceModel) {
        Product productToSave = modelMapper.map(productServiceModel, Product.class);

        productRepository.save(productToSave);
        return modelMapper.map(productToSave, ProductServiceModel.class);
    }

    @Override
    public ProductServiceModel findProductById(Long id) {
        return productRepository
                .findById(id)
                .map(product -> modelMapper.map(product, ProductServiceModel.class))
                .orElse(null);
    }

    @Override
    public ProductServiceModel findLastAddedProduct() {
        return productRepository
                .findTopByOrderByIdDesc()
                .map(product -> modelMapper.map(product, ProductServiceModel.class))
                .orElse(null);
    }
}
