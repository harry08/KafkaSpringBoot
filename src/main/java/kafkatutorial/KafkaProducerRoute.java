package kafkatutorial;

import kafkatutorial.model.Message;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/**
 * Simple Camel REST service.
 * Offers a POST operation to publish the content of the provided message object to Kafka.
 */
@Component
public class KafkaProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true");

        rest("/kafka/publish")
                .post().type(Message.class)
                .to("direct:sendkafka");

        from("direct:sendkafka")
                .to("bean:messageService?method=extractMessageText")
                .log(LoggingLevel.INFO, "Producing Kafka message -> ${body}")
                .to("kafka:users");
    }
}
