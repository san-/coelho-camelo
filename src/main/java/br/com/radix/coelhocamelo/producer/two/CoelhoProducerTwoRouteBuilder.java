package br.com.radix.coelhocamelo.producer.two;

import br.com.radix.coelhocamelo.consumer.one.CoelhoConsumerOne;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoelhoProducerTwoRouteBuilder extends RouteBuilder {

    private final CoelhoConsumerOne coelhoConsumerOne;

    @Override
    public void configure() throws Exception {
        from("direct:coelhoProducer2")
                .id("camelo-producer2")
                .marshal().json(JsonLibrary.Gson)
                .log("${body}")
                .to("{{to.camelo2}}")
                .end();
    }
}
