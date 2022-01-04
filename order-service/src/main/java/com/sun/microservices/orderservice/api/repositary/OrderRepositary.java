package com.sun.microservices.orderservice.api.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.microservices.orderservice.api.entity.Order;

@Repository
public interface OrderRepositary extends JpaRepository<Order, Integer>{

}
