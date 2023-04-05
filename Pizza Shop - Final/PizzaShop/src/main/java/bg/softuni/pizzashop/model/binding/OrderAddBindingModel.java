package bg.softuni.pizzashop.model.binding;

import bg.softuni.pizzashop.model.entity.Product;
import bg.softuni.pizzashop.model.entity.User;
import bg.softuni.pizzashop.model.entity.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderAddBindingModel {

    private OrderStatusEnum orderStatus;

    private String description;

    private BigDecimal price;

    private LocalDateTime orderTime;

    private List<Product> products;

    private User user;
}
