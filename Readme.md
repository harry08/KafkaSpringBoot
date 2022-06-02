# Kafka example with Spring Boot

## Prerequisites

Kafka needs to be installed locally and started.

### Local Windows environment

- Start Zookeeper: `bin\windows\zookeeper-server-start.bat config/zookeeper.properties`
- Start Kafka: `bin\windows\kafka-server-start.bat config/server.properties`

With the default installation Kafka is started on `localhost:9092`

Run the console-consumer on topic test: `bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning` 

## Example

### Spring Boot

- KafkaProducerController (Kafka Message producer) - `http://localhost:8080/spring/kafka/publish`
- SpringLoggingConsumer - Consume Kafka message and log

Message body for publishing a message:

`{
    "messageText": "Sample message"
}`

## Documentation

### General
* [Kafka Architecture overview](https://dzone.com/articles/kafka-architecture)
* [Kafka Topic Architecture](https://dzone.com/articles/kafka-topic-architecture-replication-failover-and)
* [Kafka Producer Architecture](https://dzone.com/articles/kafka-producer-architecture-picking-the-partition)
* [Kafka Consumer Architecture](https://dzone.com/articles/kafka-consumer-architecture-consumer-groups-and-su)
* [Sending an object as a message](https://blog.knoldus.com/kafka-sending-object-as-a-message/)

### Spring Boot
* [Creating a Spring Boot Application for Kafka](https://www.confluent.io/blog/apache-kafka-spring-boot-application/#one)
