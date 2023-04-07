package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.entity.enums.OrderStatusEnum;
import bg.softuni.pizzashop.model.service.OrderServiceModel;
import bg.softuni.pizzashop.model.service.ProductServiceModel;
import bg.softuni.pizzashop.model.view.OrderViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    ProductServiceModel addToCart(Long id);

    void removeItemFromCart(Long id);

    void addOrder(OrderServiceModel currentOrder);

    double OrderTotalSum(OrderServiceModel currentOrder);

    List<OrderViewModel> allOrdersByOrderStatus(OrderStatusEnum inProcess);


    OrderViewModel findByIdViewModel(Long id);
}
