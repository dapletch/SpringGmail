package com.spring.sendemail;

import com.spring.sendemail.properties.StmpProperties;
import com.spring.sendemail.properties.StmpPropertiesConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    //private static  Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StmpPropertiesConfig.class);
        StmpProperties stmpProperties = context.getBean(StmpProperties.class);
        System.out.println(stmpProperties.toString());
    }
}