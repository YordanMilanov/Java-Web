package com.example.demo.repository;

import com.example.demo.model.entity.CategoryNameEnum;
import com.example.demo.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT SUM(p.price) FROM Product p ")
    BigDecimal findTotalProductsSum();

    List<Product> findAllByCategory_Name(CategoryNameEnum categoryNameEnum);
}
