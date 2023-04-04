package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.service.OrderServiceModel;

import java.util.List;

public interface OrderService {
    List<OrderServiceModel> allOrders();
}
