package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Ingredient;
import bg.softuni.pizzashop.model.entity.Order;
import bg.softuni.pizzashop.model.entity.Product;
import bg.softuni.pizzashop.model.entity.User;
import bg.softuni.pizzashop.model.entity.enums.OrderStatusEnum;
import bg.softuni.pizzashop.repository.IngredientRepository;
import bg.softuni.pizzashop.repository.OrderRepository;
import bg.softuni.pizzashop.repository.ProductRepository;
import bg.softuni.pizzashop.repository.UserRepository;
import bg.softuni.pizzashop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    private final IngredientRepository ingredientRepository;

    private Map<Product, Integer> products = new TreeMap<>(Comparator.comparing(Product::getId));

    @Autowired
    public ShoppingCartServiceImpl(ProductRepository productRepository, OrderRepository orderRepository, UserRepository userRepository, IngredientRepository ingredientRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.ingredientRepository = ingredientRepository;
    }


//     If product is in the map just increment quantity by 1.
//     If product is not in the map with, add it with quantity 1

    @Override
    public void addProduct(Long id) {
        Product product = productRepository.findById(id).get();
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }


//     If product is in the map with quantity > 1, just decrement quantity by 1.
//     If product is in the map with quantity 1, remove it from map

    @Override
    public void removeProduct(Long id) {

        Product product = productRepository.findById(id).get();
        if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }
    }


//      return unmodifiable copy of the map
    @Override
    public Map<Product, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }


//     Checkout will rollback if there is not enough of some product in stock


    public void buyCart(String description) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userRepository.findByUsername(username).get();

        // product - quantity
        for (Map.Entry<Product, Integer> productEntry : products.entrySet()) {
            Integer orderedProductQuantity = productEntry.getValue();
            // product's -> ingredients-required quantity
            for (Map.Entry<Ingredient, Integer> ingredientEntry : productEntry.getKey().getRequiredProducts().entrySet()) {
                Ingredient currentIngredientOfTheProduct = ingredientEntry.getKey();
                Integer requiredQuantityOfIngredientForTheProduct = ingredientEntry.getValue();
                Ingredient ingredient = ingredientRepository.findByName(currentIngredientOfTheProduct.getName()).get();
                double currentStock = ingredient.getStockInKg();
                double updateIngredientQuantity = currentStock - ((requiredQuantityOfIngredientForTheProduct * 1.000 / 1000) * orderedProductQuantity);
                ingredient.setStockInKg(0);
                ingredient.setStockInKg(updateIngredientQuantity);
                ingredientRepository.save(ingredient);
            }
        }

        Order order = new Order();
        order.setOrderStatus(OrderStatusEnum.IN_PROCESS);
        order.setProductQuantity(products);
        order.setOrderTime(LocalDateTime.now());
        order.setPrice(getTotal());
        order.setUser(user);
        order.setDescription(description);
        orderRepository.save(order);
        products.clear();
    }

    @Override
    public double getTotal() {
        double total = 0;

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
