package com.spring.email;

import com.spring.email.messagebody.MessageBody;
import com.spring.email.properties.StmpProperties;
import com.spring.email.properties.StmpPropertiesConfig;
import com.spring.email.utils.EmailUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App {

    private static Logger logger = Logger.getLogger(App.class);

    private static MessageBody messageBody;

    public static void main(String[] args) {
        // Need to validate arguments
        ApplicationContext context = new AnnotationConfigApplicationContext(StmpPropertiesConfig.class);
        StmpProperties stmpProperties = context.getBean(StmpProperties.class);
        logger.info(stmpProperties.toString());

        // The bare minimum to be able to use this program to, subject, and message
        if (EmailUtils.isMessageBodyValid(args[0], args[1], args[2])) {
            if (EmailUtils.isFileValid(new File(args[3]))) {
                messageBody = new MessageBody(args[0], args[1], args[2], new File(args[3]));
            } else {
                messageBody = new MessageBody(args[0], args[1], args[2]);
            }
        } else {
            logger.error("In order to run this program, please enter the following arguments: \n" +
                    "Argument 1: to - the person you are emailing\n" +
                    "Argument 2: subject - subject for the email\n" +
                    "Argument 3: message - the message the email will contain\n" +
                    "Argument 4: attachment - the file you wish to send (optional)");
            System.exit(0);
        }
    }
}