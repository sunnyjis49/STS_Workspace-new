package com.sun.microservices.orderservice.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sun.microservices.orderservice.api.dto.Payment;
import com.sun.microservices.orderservice.api.dto.TransactionRequest;
import com.sun.microservices.orderservice.api.dto.TransactionResponse;
import com.sun.microservices.orderservice.api.entity.Order;
import com.sun.microservices.orderservice.api.repositary.OrderRepositary;

@Service
public class OrderService {
	@Autowired
	private OrderRepositary orderRepositary;

	@Autowired
	private RestTemplate restTemplate;

	public TransactionResponse saveOrder(TransactionRequest request) {
		String message = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		// Rest call
		Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment,
				Payment.class);

		message = paymentResponse.getPaymentStatus().equalsIgnoreCase("success")
				? "Payment processing successful and order is placed"
				: "Sorry for the inconvenience. Pelase try after sometime";

		orderRepositary.save(order);

		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), message);

	}

}
