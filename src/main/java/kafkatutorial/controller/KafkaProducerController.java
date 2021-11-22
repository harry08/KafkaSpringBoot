package kafkatutorial.controller;

import kafkatutorial.model.Message;
import kafkatutorial.service.SpringProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Simple REST service.
 * Offers a POST operation to publish the content of the provided message object to Kafka.
 */
@RestController
@RequestMapping(value = "/spring/kafka")
public class KafkaProducerController {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerController.class);
    private final SpringProducer producer;

    KafkaProducerController(SpringProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopicWithSpring(@RequestBody Message message) {
        logger.info("Producing Kafka message -> " + message.getMessageText());
        this.producer.sendMessage(message.getMessageText());
    }
}
