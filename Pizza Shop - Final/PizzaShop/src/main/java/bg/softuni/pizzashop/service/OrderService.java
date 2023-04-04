package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.service.OrderServiceModel;
import bg.softuni.pizzashop.model.service.ProductServiceModel;

import java.util.List;

public interface OrderService {
    List<OrderServiceModel> allOrders();

    ProductServiceModel addToCart(Long id);

    void removeItemFromCart(Long id);
}
