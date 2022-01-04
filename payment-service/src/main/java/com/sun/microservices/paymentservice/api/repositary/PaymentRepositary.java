package com.sun.microservices.paymentservice.api.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.microservices.paymentservice.api.entity.Payment;

@Repository
public interface PaymentRepositary extends JpaRepository<Payment, Integer>{

}
