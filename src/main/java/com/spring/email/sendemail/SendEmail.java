package com.spring.email.sendemail;

import com.spring.email.messagebody.MessageBody;
import com.spring.email.properties.StmpProperties;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Seth on 1/15/2017.
 */

@Service("mailSender")
@ComponentScan(basePackages = "com.spring.email.*")
public class SendEmail {

    private Logger logger = Logger.getLogger(SendEmail.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private StmpProperties stmpProperties;

    public void sendEmailNoAttachment(MessageBody messageBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(messageBody.getTo());
        message.setSubject(messageBody.getSubject());
        message.setText(messageBody.getMessage());
        mailSender.send(message);
    }

    public void sendEmailWithAttachment(MessageBody messageBody) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(stmpProperties.getUsername());
            helper.setTo(messageBody.getTo());
            helper.setSubject(messageBody.getSubject());
            helper.setText(messageBody.getMessage());
            // Adding the attachment
            FileSystemResource attachment = new FileSystemResource(messageBody.getAttachment());
            helper.addAttachment(attachment.getFilename(), attachment);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.error("There was an error sending the email: ", e);
        }
    }
}
