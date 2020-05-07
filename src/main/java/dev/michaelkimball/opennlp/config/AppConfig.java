package dev.michaelkimball.opennlp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    private final boolean bootstrap;

    public AppConfig(boolean bootstrap) {
        this.bootstrap = bootstrap;
    }

    public boolean hasBootstrap() {
        return bootstrap;
    }

}
