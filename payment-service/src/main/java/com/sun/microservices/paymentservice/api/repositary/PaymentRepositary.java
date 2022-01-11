package com.sun.microservices.paymentservice.api.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sun.microservices.paymentservice.api.entity.Payment;

@Repository
public interface PaymentRepositary extends JpaRepository<Payment, Integer>{

	@Query("SELECT p FROM Payment p WHERE p.orderId = ?1")
	List<Payment> findAllByOrderId(int orderId);

}
