package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Ingredient;
import bg.softuni.pizzashop.model.entity.Product;
import bg.softuni.pizzashop.model.entity.enums.ProductTypeEnum;
import bg.softuni.pizzashop.model.service.ProductServiceModel;
import bg.softuni.pizzashop.model.view.ProductViewModel;
import bg.softuni.pizzashop.repository.IngredientRepository;
import bg.softuni.pizzashop.repository.ProductRepository;
import bg.softuni.pizzashop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    private final IngredientRepository ingredientRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, IngredientRepository ingredientRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public ProductServiceModel saveProduct(ProductServiceModel productServiceModel) {
        Product productToSave = modelMapper.map(productServiceModel, Product.class);
        productRepository.save(productToSave);
        return modelMapper.map(productToSave, ProductServiceModel.class);
    }

    @Override
    public ProductServiceModel findProductById(Long id) {
        ProductServiceModel productServiceModel = productRepository
                .findById(id)
                .map(product -> modelMapper.map(product, ProductServiceModel.class))
                .orElse(null);

        //sort the required products
        Map<Ingredient, Integer> unsortedMap = productServiceModel.getRequiredProducts();
        Map<Ingredient, Integer> sortedMap = new TreeMap<>(Comparator.comparingInt(ingredient -> Math.toIntExact(ingredient.getId())));
        sortedMap.putAll(unsortedMap);

        //save the required products
        productServiceModel.setRequiredProducts(sortedMap);
        return productServiceModel;
    }

    @Override
    public ProductServiceModel findLastAddedProduct() {
        return productRepository
                .findTopByOrderByIdDesc()
                .map(product -> modelMapper.map(product, ProductServiceModel.class))
                .orElse(null);
    }

    @Override
    public void UpdateIngredientToProductById(Long id, String ingredientName, Integer ingredientGrams) {
        Product product = productRepository.findById(id).get();
        Ingredient ingredient = ingredientRepository.findByName(ingredientName).orElse(null);

        product.getRequiredProducts().put(ingredient, ingredientGrams);
        productRepository.save(product);
    }

    @Override
    public List<ProductViewModel> allProductsByType(ProductTypeEnum productTypeEnum) {

        List<Product> products = productRepository.findAllByProductTypeEnumOrderById(productTypeEnum.toString()).get();
        List<ProductViewModel> collect = products.stream()
                .map(product -> {
                    ProductViewModel map = modelMapper.map(product, ProductViewModel.class);
                    map.setPictureData(product.getPicture().getData());
                    return map;
                        }
                )
                .collect(Collectors.toList());
        return collect;
    }
}
