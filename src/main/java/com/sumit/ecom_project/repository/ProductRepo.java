package com.sumit.ecom_project.repository;

import com.sumit.ecom_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE "+
            "LOWER(p.name) LIKE(CONCAT('%', :keyword, '%')) OR "+
            "LOWER(p.brand) LIKE(CONCAT('%', :keyword, '%')) OR "+
            "LOWER(p.category) LIKE(CONCAT('%', :keyword, '%'))"
    )
    List<Product> searchProducts(String keyword);
}
