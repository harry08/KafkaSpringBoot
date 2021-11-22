package kafkatutorial.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Simple Spring Boot Kafka Consumer
 */
@Service
public class SpringLoggingConsumer {
    private final Logger logger = LoggerFactory.getLogger(SpringLoggingConsumer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("Consumed message -> %s", message));
    }
}
