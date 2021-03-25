package br.com.radix.coelhocamelo.producer.two;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@Component
public class CoelhoProducerTwo {

    @Produce("direct:coelhoProducer2")
    private ProducerTemplate template;

    public void send(Object message){
        template.asyncSendBody(template.getDefaultEndpoint(), message);
    }

}
