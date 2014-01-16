package demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.SpringBootServletInitializer;

public class WebConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}