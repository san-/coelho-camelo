package br.com.radix.coelhocamelo.consumer.one;

import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoelhoConsumerOneRouteBuilder extends RouteBuilder {

    private final CoelhoConsumerOne coelhoConsumerOne;

    @Override
    public void configure() throws Exception {
        from("{{from.camelo1}}")
                .id("camelo-consumer1")
                .log("${body}")
                .unmarshal().json(JsonLibrary.Gson)
                .process(coelhoConsumerOne);
    }
}
