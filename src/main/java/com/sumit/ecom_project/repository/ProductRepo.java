package com.sumit.ecom_project.repository;

import com.sumit.ecom_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repositoryw
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
