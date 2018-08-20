package per.ojr.springBoot.tutorial.applications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import per.ojr.springBoot.tutorial.beans.SimpleBean;

@SpringBootApplication(scanBasePackages = "per.ojr.springBoot.tutorial.listeners")
public class SimpleApplication {

    @RestController
    public static class InternalController {
        @GetMapping("/")
        public String helloWorld() {
            return "";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class);
    }

}
