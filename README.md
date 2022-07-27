# Serviço de pagamento com Kafka e Docker Compose
Esté é um projeto que fiz para aplicar os conceitos de microserviços, nele utilizo o a linguagem Java na versão 17, Apache Kafka para aplicar os conceitos de Mensageria e o Docker Compose.

## Link das imagens no DockerHub

- xunnin98/json-consumer: https://hub.docker.com/r/xunnin98/json-consumer
- xunnin98/json-consumer: https://hub.docker.com/r/xunnin98/payment-service

## Instância do Kafka, Zookeper, Kafdrop e imagens do projeto

Abaixo as três imagens das tecnologias utilizadas para aplicação do projeto e as imagens geradas após a finalização do produtor (payment-service) e consumidor (json-consumer) utilizando docker compose.
```
version: '3'

services:
  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    networks:
      - broker-kafka
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000

  kafka:
    image: confluentinc/cp-kafka:latest
    networks:
      - broker-kafka
    depends_on:
      - zookeeper
    ports:
      - "9092:9092"
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:29092,PLAINTEXT_HOST://localhost:9092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1

  kafdrop:
    image: obsidiandynamics/kafdrop:latest
    networks:
      - broker-kafka
    depends_on:
      - kafka
    ports:
      - "19000:9000"
    environment:
      KAFKA_BROKERCONNECT: kafka:29092

  payment:
    image: xunnin98/payment-service:1.0.1
    networks:
      - broker-kafka
    depends_on:
      - kafka
    ports:
      - "8000:8000"
    environment:
      KAFKA_HOST: kafka:29092
  
  consumer:
    image: xunnin98/json-consumer:1.0.1
    networks:
      - broker-kafka
    depends_on:
      - kafka
      - payment
    environment:
      KAFKA_HOST: kafka:29092
    

networks:
  broker-kafka:
    driver: bridge
```
# Configurações do application.yml
Configurações da porta que o projeto irá rodar.

## Produtor
```
server:
  port: ${PORT:8000}
spring:
  kafka:
    bootstrap-servers: ${KAFKA_HOST:localhost:29092} 
```

## Consumidor
```
server:
  port: ${PORT:8100}
spring:
  kafka:
    bootstrap-servers: ${KAFKA_HOST:localhost:29092} 
```

## Collection do Postman

Link da collection do postman: https://www.getpostman.com/collections/fc0d6c26953d14bbb9c2
