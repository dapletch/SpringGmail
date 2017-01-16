package com.spring.email.utils;

import java.io.File;

/**
 * Created by Seth on 1/15/2017.
 */
public class EmailUtils {

    public static Boolean isStringValid(String str) {
        return str.length() > 0;
    }

    public static Boolean isFileValid(File file) {
        return file.exists()
                && !file.isDirectory()
                && file.isFile();
    }

    public static Boolean isMessageBodyValid(String to, String subject, String message) {
        return isStringValid(to)
                && isStringValid(subject)
                && isStringValid(message);
    }
}
