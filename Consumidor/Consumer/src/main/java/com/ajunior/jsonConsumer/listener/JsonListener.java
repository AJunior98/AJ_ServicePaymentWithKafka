package com.ajunior.jsonConsumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ajunior.jsonConsumer.entities.Payment;

@Component
public class JsonListener {
	
	private static Logger logger = LoggerFactory.getLogger(JsonListener.class);

	@KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
	public void antiFraude(@Payload Payment payment ) {
		logger.info("Recebi o pagamento {}", payment.toString());
		logger.info("Validando fraude...");
		logger.info("Compra aprovada...");
	}
	
	@KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
	public void pdfGenerator(@Payload Payment payment) {
		logger.info("Gerando PDF do produto de id {}...", payment.getId());
	}
	
	@KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
	public void sendGenerator() {
		logger.info("Enviando e-mail de confirmação...");
	}
}
