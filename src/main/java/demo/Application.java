package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "demo")
@ConfigurationProperties("app")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
