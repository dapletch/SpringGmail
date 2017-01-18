package com.spring.email;

import com.spring.email.messagebody.MessageBody;
import com.spring.email.properties.SmtpProperties;
import com.spring.email.properties.SmtpPropertiesConfig;
import com.spring.email.sendemail.EmailConfig;
import com.spring.email.sendemail.SendEmail;
import com.spring.email.utils.EmailUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.util.Arrays;

/**
 * Hello world!
 */
public class App {

    private static Logger logger = Logger.getLogger(App.class);
    private static MessageBody messageBody = new MessageBody();

    public static void main(String[] args) {
        // Need to validate arguments
        if (args.length >= 3) {
            // The bare minimum to be able to use this program to, subject, and message
            if (EmailUtils.isMessageBodyValid(args[0], args[1], args[2]) && EmailUtils.isEmailValid(args[1])) {
                File attachment = null;
                if (args.length == 4) {
                    attachment = new File(args[3]);
                }
                ApplicationContext context = new AnnotationConfigApplicationContext(EmailConfig.class);
                SendEmail sendEmail = context.getBean(SendEmail.class);
                if (EmailUtils.isFileValid(attachment)) {
                    messageBody = new MessageBody(args[0], args[1], args[2], attachment);
                    sendEmail.sendEmailWithAttachment(messageBody);
                } else {
                    messageBody = new MessageBody(args[0], args[1], args[2]);
                    sendEmail.sendEmailNoAttachment(messageBody);
                }
            } else {
                logger.error("One of the arguments you have entered is invalid. Please check them and try again: \n" + Arrays.toString(args));
                System.exit(1);
            }
        } else {
            logger.error("In order to run this program, please enter the following arguments: \n" +
                    "Argument 1: to - the person you are emailing\n" +
                    "Argument 2: subject - subject for the email\n" +
                    "Argument 3: message - the message the email will contain\n" +
                    "Argument 4: attachment - the file you wish to send (optional)");
            System.exit(1);
        }
    }
}