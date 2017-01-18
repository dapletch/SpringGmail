package com.spring.email.utils;

import org.apache.commons.validator.routines.EmailValidator;
import java.io.File;

/**
 * Created by Seth on 1/15/2017.
 */
public class EmailUtils {

    public static Boolean isStringValid(String str) {
        return str.length() > 0;
    }

    public static Boolean isFileValid(File file) {
        return file != null
                && file.exists()
                && !file.isDirectory()
                && file.isFile();
    }

    public static Boolean isMessageBodyValid(String to, String subject, String message) {
        return isStringValid(to)
                && isStringValid(subject)
                && isStringValid(message);
    }

    public static Boolean isEmailValid(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}
