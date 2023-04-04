package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Product;
import bg.softuni.pizzashop.model.service.OrderServiceModel;
import bg.softuni.pizzashop.model.service.ProductServiceModel;
import bg.softuni.pizzashop.repository.OrderRepository;
import bg.softuni.pizzashop.repository.ProductRepository;
import bg.softuni.pizzashop.service.OrderService;
import bg.softuni.pizzashop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    private final CurrentUser currentUser;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    @Override
    public List<OrderServiceModel> allOrders() {
        return null;
    }

    @Override
    public ProductServiceModel addToCart(Long id) {
        Product product = productRepository.findById(id).get();
        currentUser.getCurrentOrder().getProducts().add(product);
        return modelMapper.map(productRepository.findById(id).get(), ProductServiceModel.class);
    }
}
