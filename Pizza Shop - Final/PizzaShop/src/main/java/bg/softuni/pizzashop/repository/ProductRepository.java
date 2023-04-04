package bg.softuni.pizzashop.repository;

import bg.softuni.pizzashop.model.entity.Product;
import bg.softuni.pizzashop.model.entity.enums.ProductTypeEnum;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findTopByOrderByIdDesc();

    Optional<List<Product>> findAllByProductTypeEnumOrderById(ProductTypeEnum productTypeEnum);
}
