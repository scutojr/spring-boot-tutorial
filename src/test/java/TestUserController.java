import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.BDDMockito.*;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import per.ojr.springBoot.tutorial.controllers.UserController;
import per.ojr.springBoot.tutorial.repositories.User;
import per.ojr.springBoot.tutorial.repositories.UserManager;


/**
 * Reference: https://thepracticaldeveloper.com/2017/07/31/guide-spring-boot-controller-tests/
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = per.ojr.springBoot.tutorial.applications.OurSpringBootApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class TestUserController {

    @Autowired
    UserController userController;

    /**
     * when userController call method from UserManager, Mock will intercept it and
     * the method call will redirect to that interceptor of Mockito
     */
    @MockBean
    UserManager userManager;

    /**
     * you need "webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT" in @SpringBootTest
     * while injecting TestRestTemplate
     */
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void simpleTest() {
        String name = "ojr";

        User testUser = new User(name, name.hashCode());

        //given
        given(userManager.insert(testUser))
                .willReturn(true);
        //when
        Boolean result = restTemplate.postForObject("/users/" + name, null, Boolean.class);
        //then
        assertTrue(result);

        // given
        given(userManager.insert(testUser))
                .willReturn(false);
        // when
        result = restTemplate.postForObject("/users/" + name, null, Boolean.class);
        // then
        assertFalse(result);
    }
}
