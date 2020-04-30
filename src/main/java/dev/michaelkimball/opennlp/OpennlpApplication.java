package dev.michaelkimball.opennlp;

import dev.michaelkimball.opennlp.services.NLPProcessingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OpennlpApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OpennlpApplication.class, args);
        run.getBean(NLPProcessingService.class).bootstrap();
    }

}
