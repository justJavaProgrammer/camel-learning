package edu.odeyalo.sample.camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public final class FileContentPublisherRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("file:folder1?delete=false")
                .log("Read file ${body}")
                .process(exchange -> exchange.getIn().setHeader(KafkaConstants.KEY, "odeyalo+" + UUID.randomUUID().toString()))
                .to("kafka:camel-test");
    }
}
