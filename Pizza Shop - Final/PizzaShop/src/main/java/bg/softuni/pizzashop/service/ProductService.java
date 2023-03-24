package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.service.ProductServiceModel;

public interface ProductService {
    ProductServiceModel saveProduct(ProductServiceModel productServiceModel);
    ProductServiceModel findProductById(Long id);

    ProductServiceModel findLastAddedProduct();
}
