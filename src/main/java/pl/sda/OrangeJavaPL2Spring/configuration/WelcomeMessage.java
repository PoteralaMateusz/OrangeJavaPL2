package pl.sda.OrangeJavaPL2Spring.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties("message")
// @Value od data różni się ze dane są niemutowalne
public class WelcomeMessage {

    private String value;
}
