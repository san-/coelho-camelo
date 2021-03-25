package br.com.radix.coelhocamelo.producer.one;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@Component
public class CoelhoProducerOne {

    @Produce("direct:coelhoProducer1")
    private ProducerTemplate template;

    public void send(Object message){
        template.asyncSendBody(template.getDefaultEndpoint(), message);
    }

}
