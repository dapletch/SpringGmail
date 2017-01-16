package com.spring.email.properties;

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
@ComponentScan(basePackages = "com.spring.email.*")
@PropertySource("file:src/main/resources/stmp.properties")
public class StmpPropertiesConfig {

    private Environment env;

    @Autowired
    public StmpPropertiesConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public StmpProperties getStmpProperties() {
        return new StmpProperties(env.getProperty("smtp.host"), env.getProperty("smtp.port")
                , env.getProperty("smtp.username"), env.getProperty("smtp.password")
                , env.getProperty("smtp.auth"), env.getProperty("smtp.starttls.enable"));
    }
}
