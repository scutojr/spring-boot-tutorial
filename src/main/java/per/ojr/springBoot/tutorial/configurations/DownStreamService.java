package per.ojr.springBoot.tutorial.configurations;

public class DownStreamService {
    String host;
    String port;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }
}
