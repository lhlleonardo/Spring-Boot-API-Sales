package com.lhleonardo.apisales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lhleonardo.apisales.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}