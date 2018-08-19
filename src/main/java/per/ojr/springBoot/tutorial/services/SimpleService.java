package per.ojr.springBoot.tutorial.services;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import per.ojr.springBoot.tutorial.beans.DynamicBean;
import per.ojr.springBoot.tutorial.beans.ServiceRegister;
import per.ojr.springBoot.tutorial.configurations.DownStreamService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class SimpleService {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private ServiceRegister register;

    @Autowired
    void discover(DownStreamService downStreamService) {
        register.register(downStreamService);
    }

    @PostConstruct
    public void myInit() {
        System.out.println("initialize!!!");
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println("destroy!!!");
    }
}
