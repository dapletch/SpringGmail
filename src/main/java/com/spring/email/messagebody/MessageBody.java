package com.spring.email.messagebody;

import java.io.File;

/**
 * Created by Seth on 1/15/2017.
 */
public class MessageBody {

    private String to;
    private String subject;
    private String message;
    private File attachment;

    public MessageBody() {
        super();
    }

    public MessageBody(String to, String subject, String message) {
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public MessageBody(String to, String subject, String message, File attachment) {
        this.to = to;
        this.subject = subject;
        this.message = message;
        this.attachment = attachment;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public File getAttachment() {
        return attachment;
    }

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "MessageBody{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", attachment=" + attachment +
                '}';
    }
}
