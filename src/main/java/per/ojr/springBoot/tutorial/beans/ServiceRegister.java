package per.ojr.springBoot.tutorial.beans;

import org.springframework.stereotype.Component;
import per.ojr.springBoot.tutorial.configurations.DownStreamService;

@Component
public class ServiceRegister {
    public void register(DownStreamService downStreamService) {
        String host = downStreamService.getHost();
        String port = downStreamService.getPort();
        System.out.println(String.format("==== register service %s:%s", host, port));
    }
}
