package com.lhleonardo.apisales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lhleonardo.apisales.entity.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

}