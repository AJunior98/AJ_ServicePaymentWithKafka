package com.ajunior.paymentservice.services.impl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ajunior.paymentservice.entities.Payment;
import com.ajunior.paymentservice.services.PaymentService;

import lombok.SneakyThrows;

@Service
public class PaymentServiceImpl implements PaymentService{

	private static Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	@Autowired
	private KafkaTemplate<String, Serializable> kafkaTemplate;
	
	@SneakyThrows
	@Override
	public void sendPayment(Payment payment) {
		logger.info("Recebi o pagamento {}", payment);
		logger.info("Enviando pagamento...");
		kafkaTemplate.send("payment-topic", payment);
	}
}
