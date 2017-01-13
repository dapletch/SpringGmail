package com.spring.sendemail.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by Seth on 1/12/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.spring.sendemail.*")
@PropertySource("file:src/resources/stmp.properties")
public class StmpPropertiesConfig {

    @Autowired
    Environment env;

    @Bean
    public StmpProperties getStmpProperties() {
        return new StmpProperties(env.getProperty("smtp.host"), env.getProperty("smtp.host")
                , env.getProperty("smtp.username"), env.getProperty("smtp.password"));
    }
}
