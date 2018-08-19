package per.ojr.springBoot.tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.ojr.springBoot.tutorial.listeners.SimpleEvent;

@RestController
@RequestMapping("/events")
public class EventPlayer {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping("/{msg}")
    public String receiveMsg(@PathVariable("msg") String msg) {
        eventPublisher.publishEvent(new SimpleEvent(this, msg));
        return msg;
    }
}
