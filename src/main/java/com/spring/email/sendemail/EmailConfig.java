package com.spring.email.sendemail;

import com.spring.email.properties.SmtpProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by Seth on 1/16/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.spring.email.*")
public class EmailConfig {

    @Autowired
    private SmtpProperties smtpProperties;

    @Bean
    public JavaMailSender javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(smtpProperties.getHost());
        javaMailSender.setPort(Integer.parseInt(smtpProperties.getPort()));
        javaMailSender.setUsername(smtpProperties.getUsername());
        javaMailSender.setPassword(smtpProperties.getPassword());

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", smtpProperties.getAuthentication());
        javaMailProperties.put("mail.smtp.starttls.enable", smtpProperties.getStartTlsEnable());
        javaMailProperties.put("mail.transport.protocol", smtpProperties.getTransportProtocol());
        javaMailProperties.put("mail.debug", smtpProperties.getMailDebug());
        javaMailSender.setJavaMailProperties(javaMailProperties);
        return javaMailSender;
    }
}
