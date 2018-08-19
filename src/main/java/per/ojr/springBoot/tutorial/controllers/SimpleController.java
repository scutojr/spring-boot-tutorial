package per.ojr.springBoot.tutorial.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import per.ojr.springBoot.tutorial.beans.ComplexBean;
import per.ojr.springBoot.tutorial.beans.SimpleBean;
import per.ojr.springBoot.tutorial.services.SimpleService;

@RestController
@Scope("prototype")
public class SimpleController {

    @Autowired
    private ComplexBean complexBean;

    @Autowired
    private SimpleService simpleService;

    @Qualifier("multiSimpleBean")
    @Autowired
    private SimpleBean multiSimpleBean;
    private SimpleBean simpleBean;

    public SimpleController(@Qualifier("simpleBean") SimpleBean simpleBean) {
        // It's better to use @Autowired
        System.out.println(String.format("==== constructing %s ====", SimpleController.class.getName()));
        this.simpleBean = simpleBean;
    }

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "HelloWorld";
    }
}
