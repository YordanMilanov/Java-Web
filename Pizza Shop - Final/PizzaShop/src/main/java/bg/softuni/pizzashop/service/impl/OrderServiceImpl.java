package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Order;
import bg.softuni.pizzashop.model.entity.Product;
import bg.softuni.pizzashop.model.entity.enums.OrderStatusEnum;
import bg.softuni.pizzashop.model.service.OrderServiceModel;
import bg.softuni.pizzashop.model.service.ProductServiceModel;
import bg.softuni.pizzashop.model.view.OrderViewModel;
import bg.softuni.pizzashop.repository.OrderRepository;
import bg.softuni.pizzashop.repository.ProductRepository;
import bg.softuni.pizzashop.service.OrderService;
import bg.softuni.pizzashop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public ProductServiceModel addToCart(Long id) {
        Product product = productRepository.findById(id).get();
        if (currentUser.getCurrentOrder().getProductNameQuantity().containsKey(product.getName())) {
            Integer quantity = currentUser.getCurrentOrder().getProductNameQuantity().get(product.getName()) + 1;
            currentUser.getCurrentOrder().getProductNameQuantity().put(product.getName(), quantity);
        } else {
            currentUser.getCurrentOrder().getProductNameQuantity().put(product.getName(), 1);
        }
        currentUser.getCurrentOrder().getProducts().add(product);
        return modelMapper.map(productRepository.findById(id).get(), ProductServiceModel.class);
    }

    @Override
    public void removeItemFromCart(Long id) {
        //list of user products
        List<Product> userProducts = currentUser.getCurrentOrder().getProducts();

        //new instance of product which we will use to keep the product which we want to remove
        Product productToRemove = null;

        //find the product which we want to remove
        for (Product product : userProducts) {
            if (product.getId() == id) {
                // set the product to remove
                productToRemove = product;
                break;
            }
        }

        //iterate over the list and map to remove the product from the list and reduce the quantity by one in the map of the same product
        for (int i = userProducts.size() - 1; i >= 0; i--) {
            if (userProducts.get(i).getId() == productToRemove.getId()) {
                String name = userProducts.remove(i).getName();

                for (Map.Entry<String, Integer> entry : currentUser.getCurrentOrder().getProductNameQuantity().entrySet()) {
                    if (entry.getKey().equals(name)) {
                        currentUser.getCurrentOrder().getProductNameQuantity().put(entry.getKey(), entry.getValue() - 1);
                        if (currentUser.getCurrentOrder().getProductNameQuantity().get(entry.getKey()) <= 0) {
                            currentUser.getCurrentOrder().getProductNameQuantity().remove(entry.getKey());
                        }
                        break;
                    }
                }

                currentUser.setOrderSum(currentUser.getOrderSum() - productToRemove.getPrice());
                break;
            }
        }
    }

    @Override
    public void addOrder(OrderServiceModel currentOrder) {
        Order orderToSave = modelMapper.map(currentUser.getCurrentOrder(), Order.class);
        orderToSave.setProductQuantity(new HashMap<>());
        orderToSave.setOrderTime(LocalDateTime.now());
        orderToSave.setOrderStatus(OrderStatusEnum.IN_PROCESS);

        for (Map.Entry<String, Integer> entry : currentOrder.getProductNameQuantity().entrySet()) {
            Product product = productRepository.findByName(entry.getKey()).get();
            orderToSave.getProductQuantity().put(product, entry.getValue());
        }


        double total = 0;
        for (Product product : currentUser.getCurrentOrder().getProducts()) {
            total += product.getPrice();
        }


        orderToSave.setPrice(total);
        if (currentUser.getUsername() != null) {
            orderRepository.save(orderToSave);
        }
        currentOrder.setProducts(new ArrayList<>());
        currentOrder.setProductNameQuantity(new HashMap<>());
        currentOrder.setDescription(null);
        currentOrder.setOrderTime(null);
        currentOrder.setPrice(null);
        currentUser.setCurrentOrder(currentOrder);
    }

    @Override
    public double OrderTotalSum(OrderServiceModel currentOrder) {
        double totalSum = 0;
        for (Map.Entry<String, Integer> entry : currentOrder.getProductNameQuantity().entrySet()) {
            double productPrice = productRepository.findByName(entry.getKey()).get().getPrice();
            totalSum += productPrice * entry.getValue();
        }
        return totalSum;
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
        return modelMapper.map(orderRepository.findById(id).get(), OrderViewModel.class);
    }
}
