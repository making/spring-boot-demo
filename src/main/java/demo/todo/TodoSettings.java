package demo.todo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.inject.Named;

@Named
@ConfigurationProperties(name = "todo")
@Data
public class TodoSettings {
    private int maxCount;
}
