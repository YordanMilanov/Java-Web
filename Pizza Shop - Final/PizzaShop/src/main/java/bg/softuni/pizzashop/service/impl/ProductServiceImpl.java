package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Product;
import bg.softuni.pizzashop.model.service.ProductServiceModel;
import bg.softuni.pizzashop.repository.ProductRepository;
import bg.softuni.pizzashop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
//        Product productToSave = modelMapper.map()
        return null;
    }
}
