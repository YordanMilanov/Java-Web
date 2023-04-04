package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Product;
import bg.softuni.pizzashop.model.service.OrderServiceModel;
import bg.softuni.pizzashop.model.service.ProductServiceModel;
import bg.softuni.pizzashop.repository.OrderRepository;
import bg.softuni.pizzashop.repository.ProductRepository;
import bg.softuni.pizzashop.service.OrderService;
import bg.softuni.pizzashop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    private final CurrentUser currentUser;

    @Autowired
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

    @Override
    public void removeItemFromCart(Long id) {
        //list of user products
        List<Product> userProducts = currentUser.getCurrentOrder().getProducts();

        //new instance of product
        Product productToRemove = null;

        for (Product product : userProducts) {
            if(product.getId() == id) {
                // set the product to remove
                productToRemove = product;
                break;
            }
        }

        for (int i = userProducts.size() - 1; i >= 0; i--) {
            if(userProducts.get(i).getId() == productToRemove.getId()) {
                userProducts.remove(i);
                break;
            }
        }
    }
}
