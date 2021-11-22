package kafkatutorial;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Simple Camel route.
 * Kafka Consumer. Listens on the topic users.
 */
@Component
public class LoggingConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:users")
                .log(LoggingLevel.INFO, "Kafka message received on the topic ${headers[kafka.TOPIC]} -> ${body}, Key ${headers[kafka.KEY]}");
    }
}
