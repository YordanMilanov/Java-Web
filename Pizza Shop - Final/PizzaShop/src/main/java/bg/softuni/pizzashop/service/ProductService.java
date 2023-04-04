package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.entity.enums.ProductTypeEnum;
import bg.softuni.pizzashop.model.service.ProductServiceModel;
import bg.softuni.pizzashop.model.view.ProductViewModel;

import java.util.List;

public interface ProductService {
    ProductServiceModel saveProduct(ProductServiceModel productServiceModel);
    ProductServiceModel findProductById(Long id);

    ProductServiceModel findLastAddedProduct();

    void UpdateIngredientToProductById(Long id, String ingredientNames,Integer ingredientGrams);

    List<ProductViewModel> allProductsByType(ProductTypeEnum productTypeEnum);
}
