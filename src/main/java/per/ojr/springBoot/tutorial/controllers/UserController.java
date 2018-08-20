package per.ojr.springBoot.tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.ojr.springBoot.tutorial.repositories.User;
import per.ojr.springBoot.tutorial.repositories.UserManager;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserManager userManager;

    @PostMapping("/{userName}")
    public boolean upsertUser(@PathVariable("userName") String userName) {
        Boolean status = userManager.insert(new User(userName, userName.hashCode()));
        return status;
    }

    @GetMapping("/{userName}")
    public User selectUser(@PathVariable("userName") String userName) {
        return userManager.select(userName);
    }
}
