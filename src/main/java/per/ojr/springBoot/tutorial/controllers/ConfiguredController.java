package per.ojr.springBoot.tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.ojr.springBoot.tutorial.configurations.MySQL;

@RestController
@RequestMapping("/configuration")
public class ConfiguredController {

    @Autowired
    private MySQL mysqlConfig;

    @Value("${blog.author}")
    String author;

    @Value("${blog.desc}")
    String desc;

    @Value("${blog.number}")
    Integer magic;

    @Value("${my.first.db}")
    String db1;

    @Value("${my.second.db}")
    String db2;

    @GetMapping("/author")
    public String author() {
        return author;
    }

    @GetMapping("/description")
    public String description() {
        return desc;
    }

    @GetMapping("/magic")
    public Integer magic() {
        return magic;
    }

    @GetMapping("/dbs")
    public String dbs() {
        return db1 + "," + db2;
    }

    @GetMapping("/mysql")
    public MySQL mySQLConfig() {
        return mysqlConfig;
    }
}
