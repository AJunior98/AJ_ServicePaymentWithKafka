package com.ajunior.paymentservice.services;

import com.ajunior.paymentservice.entities.Payment;

public interface PaymentService {

	void sendPayment(Payment payment);
	
}
