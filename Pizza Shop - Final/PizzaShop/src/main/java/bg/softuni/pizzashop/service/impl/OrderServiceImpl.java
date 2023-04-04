package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.service.OrderServiceModel;
import bg.softuni.pizzashop.repository.OrderRepository;
import bg.softuni.pizzashop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<OrderServiceModel> allOrders() {
        return null;
    }
}
