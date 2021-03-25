package br.com.radix.coelhocamelo.consumer.all;

import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoelhoConsumerAllRouteBuilder extends RouteBuilder {

    private final CoelhoConsumerAll coelhoConsumerAll;

    @Override
    public void configure() throws Exception {
        from("{{from.camelo.all}}")
                .id("camelo-consumer-all")
                .log("${body}")
                .unmarshal().json(JsonLibrary.Gson)
                .process(coelhoConsumerAll);
    }
}
