package com.spring.email.sendemail;

import com.spring.email.properties.StmpProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Created by Seth on 1/16/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.spring.email.*")
public class EmailConfig {

    @Autowired
    private StmpProperties stmpProperties;

    @Bean
    public JavaMailSender javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(stmpProperties.getHost());
        javaMailSender.setPort(Integer.parseInt(stmpProperties.getPort()));
        javaMailSender.setUsername(stmpProperties.getUsername());
        javaMailSender.setPassword(stmpProperties.getPassword());

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", stmpProperties.getAuthentication());
        javaMailProperties.put("mail.smtp.starttls.enable", stmpProperties.getStartTlsEnable());
        javaMailProperties.put("mail.transport.protocol", stmpProperties.getTransportProtocol());
        javaMailProperties.put("mail.debug", stmpProperties.getMailDebug());
        javaMailSender.setJavaMailProperties(javaMailProperties);
        javaMailSender.setJavaMailProperties(javaMailProperties);
        return javaMailSender;
    }
}
