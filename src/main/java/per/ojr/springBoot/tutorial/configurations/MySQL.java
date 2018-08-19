package per.ojr.springBoot.tutorial.configurations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // make it scanned by spring-boot, you can use @Bean on method alternatively
@ConfigurationProperties(prefix = "mysql")
public class MySQL {
    private String host;
    private String port;
    private String user;
    private String password;
    private List<String> tables;
    private List<String> dbs;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTables(List<String> tables) {
        this.tables = tables;
    }

    public void setDbs(List<String> dbs) {
        this.dbs = dbs;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getTables() {
        return tables;
    }

    public List<String> getDbs() {
        return dbs;
    }
}
