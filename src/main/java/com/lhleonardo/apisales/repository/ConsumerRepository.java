package com.lhleonardo.apisales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhleonardo.apisales.entity.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long>{

}