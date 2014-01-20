package demo;

import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.SimpleHealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

//    @Bean(destroyMethod = "shutdown")
//    DataSource dataSource() {
//        EmbeddedDatabase db = new EmbeddedDatabaseBuilder()
//                .setName("demo")
//                .setType(EmbeddedDatabaseType.HSQL)
//                .addScript("schema.sql")
//                .addScript("data.sql")
//                .build();
//        return db;
//    }

    @ConditionalOnClass(name = "org.hsqldb.jdbcDriver")
    @Bean
    HealthIndicator<?> healthIndicator(DataSource dataSource) {
        // http://javasplitter.blogspot.jp/2011/01/keep-alive-query-in-hsqldb.html
        SimpleHealthIndicator healthIndicator = new SimpleHealthIndicator();
        healthIndicator.setDataSource(dataSource);
        healthIndicator.setQuery("SELECT now() FROM INFORMATION_SCHEMA.SYSTEM_TABLES LIMIT 1");
        return healthIndicator;
    }
}
