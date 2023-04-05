package bg.softuni.pizzashop.repository;

import bg.softuni.pizzashop.model.entity.Product;
import bg.softuni.pizzashop.model.entity.enums.ProductTypeEnum;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findTopByOrderByIdDesc();

    @Query("SELECT p FROM Product p WHERE UPPER(p.productTypeEnum) = UPPER(:productTypeEnum)")
    Optional<List<Product>> findAllByProductTypeEnumOrderById(@Param("productTypeEnum") String productTypeEnum);

    Optional<Product> findProductByName(String name);
}
