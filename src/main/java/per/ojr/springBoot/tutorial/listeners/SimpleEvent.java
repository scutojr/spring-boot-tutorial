package per.ojr.springBoot.tutorial.listeners;

import org.springframework.context.ApplicationEvent;

public class SimpleEvent extends ApplicationEvent {
    private String message;

    public SimpleEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
