package br.com.radix.coelhocamelo.producer.one;

import br.com.radix.coelhocamelo.consumer.one.CoelhoConsumerOne;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoelhoProducerOneRouteBuilder extends RouteBuilder {

    private final CoelhoConsumerOne coelhoConsumerOne;

    @Override
    public void configure() throws Exception {
        from("direct:coelhoProducer1")
                .id("camelo-producer1")
                .marshal().json(JsonLibrary.Gson)
                .log("${body}")
                .to("{{to.camelo1}}")
                .end();
    }
}
