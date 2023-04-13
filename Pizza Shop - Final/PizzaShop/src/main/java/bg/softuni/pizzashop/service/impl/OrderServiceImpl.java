package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.errorHandling.ObjectNotFoundException;
import bg.softuni.pizzashop.model.entity.Order;
import bg.softuni.pizzashop.model.entity.Product;
import bg.softuni.pizzashop.model.entity.enums.OrderStatusEnum;
import bg.softuni.pizzashop.model.view.OrderViewModel;
import bg.softuni.pizzashop.repository.OrderRepository;
import bg.softuni.pizzashop.repository.ProductRepository;
import bg.softuni.pizzashop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrderViewModel> allOrdersByOrderStatus(OrderStatusEnum orderStatusEnum) {
        return orderRepository.findAllByOrderStatus(orderStatusEnum).get()
                .stream()
                .map(o -> modelMapper.map(o, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderViewModel findByIdViewModel(Long id) {
        boolean present = orderRepository.findById(id).isPresent();
        if(!present) {
            throw new ObjectNotFoundException(id, "Order");
        }
        return modelMapper.map(orderRepository.findById(id).get(), OrderViewModel.class);
    }

    @Override
    public void sortProductsInOrder(OrderViewModel orderView) {
        Map<Product, Integer> sortedMap = new TreeMap<>(Comparator.comparing(Product::getId));
        sortedMap.putAll(orderView.getProductQuantity());
        orderView.setProductQuantity(sortedMap);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void finishOrder(Order byId) {
        byId.setOrderStatus(OrderStatusEnum.FINISHED);
        orderRepository.save(byId);
    }


}
