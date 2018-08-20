package per.ojr.springBoot.tutorial.repositories;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(exclude = "id")
public class User {
    String name;
    int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
