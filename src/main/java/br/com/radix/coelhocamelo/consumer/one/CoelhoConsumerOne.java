package br.com.radix.coelhocamelo.consumer.one;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CoelhoConsumerOne implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Object message = exchange.getIn().getBody();
        log.debug(message.toString());
    }
}
