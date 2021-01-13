package com.lhleonardo.apisales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhleonardo.apisales.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Product save(Product product);

}