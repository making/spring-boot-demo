package demo.welcome;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Foo {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate birthDay;

    @DateTimeFormat(pattern = "yyy-mm-dd HH:mm:ss")
    LocalDateTime lastUpdatedAt;
}




