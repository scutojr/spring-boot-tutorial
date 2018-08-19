package per.ojr.springBoot.tutorial.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleListener implements ApplicationListener<SimpleEvent> {

    public void onApplicationEvent(SimpleEvent simpleEvent) {
        System.out.println("==== handling simpleEvent: " + simpleEvent.getMessage());
        try {
            Thread.currentThread().sleep(50 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
