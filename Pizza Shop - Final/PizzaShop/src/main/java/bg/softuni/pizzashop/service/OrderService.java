package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.entity.Order;
import bg.softuni.pizzashop.model.entity.enums.OrderStatusEnum;
import bg.softuni.pizzashop.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {

    List<OrderViewModel> allOrdersByOrderStatus(OrderStatusEnum inProcess);


    OrderViewModel findByIdViewModel(Long id);

    void sortProductsInOrder(OrderViewModel orderView);

    Order findById(Long id);

    void finishOrder(Order byId);
}
