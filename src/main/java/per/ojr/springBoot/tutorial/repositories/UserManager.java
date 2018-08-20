package per.ojr.springBoot.tutorial.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * suppose this is a Class for reading/writing from/to a database
 */
@Repository
public class UserManager {

    private static Map<String, User> userTable = new ConcurrentHashMap<String, User>();

    /**
     * @param user
     * @return true if user doesn't exist
     */
    public boolean insert(User user) {
        if (!userTable.containsKey(user.getName())) {
            userTable.put(user.getName(), user);
            return true;
        } else {
            return false;
        }
    }

    public User select(String name) {
        return userTable.get(name);
    }

}
