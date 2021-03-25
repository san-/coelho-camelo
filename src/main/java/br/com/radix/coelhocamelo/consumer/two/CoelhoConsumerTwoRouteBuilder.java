package br.com.radix.coelhocamelo.consumer.two;

import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoelhoConsumerTwoRouteBuilder extends RouteBuilder {

    private final CoelhoConsumerTwo coelhoConsumerTwo;

    @Override
    public void configure() throws Exception {
        from("{{from.camelo2}}")
                .id("camelo-consumer2")
                .log("${body}")
                .unmarshal().json(JsonLibrary.Gson)
                .process(coelhoConsumerTwo);
    }
}
