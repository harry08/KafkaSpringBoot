package kafkatutorial.controller;

import kafkatutorial.model.SimpleStringMessage;
import kafkatutorial.service.SpringProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Simple REST service.
 * Offers a POST operation to publish the content of the provided message object to Kafka.
 */
@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerController.class);
    private final SpringProducer producer;

    KafkaProducerController(SpringProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendSimpleStringMessageToKafkaTopic(@RequestBody SimpleStringMessage message) {
        logger.info("Producing simple String Kafka message -> " + message.getMessageText());
        this.producer.sendMessage(message.getMessageText());
    }
}
