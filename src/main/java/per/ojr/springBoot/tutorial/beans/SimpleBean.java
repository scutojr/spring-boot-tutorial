package per.ojr.springBoot.tutorial.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SimpleBean {
    private String name;

    public SimpleBean(String mode) {
        System.out.println("==== I am constructing SimpleBean in " + mode + " mode! ====");
    }

    @PostConstruct
    public void myInit() {
        System.out.println("initialize the simpleBean");
    }

    @PreDestroy
    public void myDestory() {
        System.out.println("destroy the simpleBean");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
