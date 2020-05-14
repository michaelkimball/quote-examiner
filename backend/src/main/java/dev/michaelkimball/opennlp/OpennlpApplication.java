package dev.michaelkimball.opennlp;

import dev.michaelkimball.opennlp.services.NLPProcessingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan("dev.michaelkimball.opennlp.config")
public class OpennlpApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OpennlpApplication.class);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OpennlpApplication.class, args);
        run.getBean(NLPProcessingService.class).bootstrap();
    }

}
