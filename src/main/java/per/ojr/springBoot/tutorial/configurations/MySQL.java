package per.ojr.springBoot.tutorial.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component // make it scanned by spring-boot, you can use @Bean on method alternatively
@ConfigurationProperties(prefix = "mysql")
public class MySQL {
    private String host;
    private String port;
    private String user;
    private String password;
    private List<String> tables;
    private List<String> dbs;
}
