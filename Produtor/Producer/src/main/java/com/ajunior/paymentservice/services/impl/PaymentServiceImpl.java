package com.ajunior.paymentservice.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ajunior.paymentservice.entities.Payment;
import com.ajunior.paymentservice.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	private static Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	@Override
	public void sendPayment(Payment payment) {
		logger.info("PAYMENT_SERVICE_IMPL ::: Recebi o pagamento {}", payment);
	}

}
