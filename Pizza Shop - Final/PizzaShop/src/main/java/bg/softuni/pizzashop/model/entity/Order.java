package bg.softuni.pizzashop.model.entity;

import bg.softuni.pizzashop.model.entity.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(precision = 19, scale = 2)
    private BigDecimal price;

    @Column
    private LocalDateTime orderTime;

    @OneToMany
    private List<Product> products;

    @ManyToOne
    private User user;
}
