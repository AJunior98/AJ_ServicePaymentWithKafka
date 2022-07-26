package com.ajunior.paymentservice.resources.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajunior.paymentservice.entities.Payment;
import com.ajunior.paymentservice.resources.PaymentResource;
import com.ajunior.paymentservice.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource{

	@Autowired
	private PaymentService paymentService;
	
	@Override
	public ResponseEntity<Payment> payment(Payment payment) {
		paymentService.sendPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
