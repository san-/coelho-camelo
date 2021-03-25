package br.com.radix.coelhocamelo;

import br.com.radix.coelhocamelo.producer.one.CoelhoProducerOne;
import br.com.radix.coelhocamelo.producer.two.CoelhoProducerTwo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
@RequiredArgsConstructor
public class Console implements CommandLineRunner {

    private final CoelhoProducerTwo producer2;
    private final CoelhoProducerOne producer1;

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Write anything (quit to exit): ");
            var line = br.readLine();
            if (line.toLowerCase().equals("quit"))
                break;
            if (line.startsWith("1:"))
                producer1.send(line);
            else if (line.startsWith("2:"))
                producer2.send(line);
            else
                System.out.println("Use this format: [1|2]:[text]");
            Thread.sleep(200);
        }
        System.out.println("Fim!");
        System.exit(0);
    }
}
