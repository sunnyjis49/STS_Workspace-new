package com.sun.microservices.paymentservice.api.service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.microservices.paymentservice.api.entity.Payment;
import com.sun.microservices.paymentservice.api.repositary.PaymentRepositary;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepositary paymentRepositary;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepositary.save(payment);
	}
	
	private String paymentProcessing() {
		//api should be 3rd party payment gateway(paytm, paypal etc)
		return new Random().nextBoolean() ? "success" : "false";
	}
	
	public List<Payment> findPaymentHistoryByOrderId(int orderId) {
		return paymentRepositary.findAllByOrderId(orderId);
	}

}
