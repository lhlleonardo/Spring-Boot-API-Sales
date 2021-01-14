package com.lhleonardo.apisales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhleonardo.apisales.entity.OrderSales;

@Repository
public interface OrderSalesRepository extends JpaRepository<OrderSales, Long>{

	OrderSales save(OrderSales order);
}
