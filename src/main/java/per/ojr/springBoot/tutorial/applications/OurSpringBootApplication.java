package per.ojr.springBoot.tutorial.applications;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import per.ojr.springBoot.tutorial.beans.ComplexBean;
import per.ojr.springBoot.tutorial.beans.DynamicBean;
import per.ojr.springBoot.tutorial.beans.SimpleBean;
import per.ojr.springBoot.tutorial.configurations.DownStreamService;

@SpringBootApplication(scanBasePackages = {"per.ojr.springBoot.tutorial"})
@PropertySource(value = {
        "classpath:my_first.properties",
        "classpath:my_second.properties",
        "classpath:downStreamService.properties"
}, encoding = "utf-8")
public class OurSpringBootApplication implements ApplicationRunner {

    /**
     * According to my test, the following two bean will be constructed on spring-boot startup and
     * you can see log print from their constructor.
     * <p>
     * Because spring-boot use their type as default qualifier(I guess), it will fail to inject them into
     * SimpleController because of conflict. I solve it by applying @Qualifier on @Bean and (@Autowired or
     * constructor parameter). By default, the name of the method annotated by @Bean is the bean's qualifier
     */

//    @Qualifier("simpleBean") // customize your bean name instead of the default name
//    @Bean(initMethod = "init", destroyMethod = "destroy") // specify the init and destroy method
    @Bean
    public SimpleBean simpleBean() {
        return new SimpleBean("singleton");
    }

    @Scope("prototype")
    @Bean
    public SimpleBean multiSimpleBean() {
        return new SimpleBean("multi-case");
    }

    @Bean
    public ComplexBean complexBean() {
        return new ComplexBean();
    }

    @Bean
    @ConfigurationProperties(prefix = "down-stream-service")
    public DownStreamService downStreamService() {
        return new DownStreamService();
    }

    /**
     * ApplicationContext --> BeanFacotory --> BeanDefinitionBuilder
     *
     * @param context
     */
    public static void registerDynamicBean(ConfigurableApplicationContext context) {
        DefaultListableBeanFactory factory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
        String[][] args = {
                {"name-1", "value-1"},
                {"name-2", "value-2"},
                {"name-3", "value-3"},
        };
        for (String[] arg : args) {
            BeanDefinitionBuilder beanBuilder = BeanDefinitionBuilder.genericBeanDefinition(DynamicBean.class);
            beanBuilder.addConstructorArgValue(arg[0]);
            beanBuilder.addConstructorArgValue(arg[1]);
            factory.registerBeanDefinition(arg[0], beanBuilder.getBeanDefinition());
        }
    }

    public static void getDynamicBean(ConfigurableApplicationContext context) {
        for (String beanName : new String[]{"name-1", "name-2", "name-3"}) {
            DynamicBean bean = (DynamicBean) context.getBean(beanName);
            System.out.println(bean.value);
        }
    }

    /**
     * this method inherited from ApplicationRunner, SpringApplication will run this method after
     * all the bean has been ready. By the way, you only need to inherit ApplicationRunner if
     * necessary
     * @param args
     */
    public void run(ApplicationArguments args) {
        System.out.println("Hello friends on the mountain!!!");
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OurSpringBootApplication.class);
        registerDynamicBean(context);
        getDynamicBean(context);
    }

}
