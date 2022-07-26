package com.ajunior.paymentservice.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ajunior.paymentservice.entities.Payment;

public interface PaymentResource {
	
	@PostMapping
	ResponseEntity<Payment> payment(@RequestBody Payment payment);
	
}
