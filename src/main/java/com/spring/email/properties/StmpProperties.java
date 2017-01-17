package com.spring.email.properties;

import java.util.Properties;

/**
 * Created by Seth on 1/12/2017.
 */
public class StmpProperties {

    private String host;
    private String port;
    private String username;
    private String password;
    private String authentication;
    private String startTlsEnable;
    private String transportProtocol;
    private String mailDebug;

    public StmpProperties() {
        super();
    }

    public StmpProperties(String host, String port
            , String username, String password
            , String authentication, String startTlsEnable
            , String transportProtocol, String mailDebug) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.authentication = authentication;
        this.startTlsEnable = startTlsEnable;
        this.transportProtocol = transportProtocol;
        this.mailDebug = mailDebug;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public String getStartTlsEnable() {
        return startTlsEnable;
    }

    public void setStartTlsEnable(String startTlsEnable) {
        this.startTlsEnable = startTlsEnable;
    }

    public String getTransportProtocol() {
        return transportProtocol;
    }

    public void setTransportProtocol(String transportProtocol) {
        this.transportProtocol = transportProtocol;
    }

    public String getMailDebug() {
        return mailDebug;
    }

    public void setMailDebug(String mailDebug) {
        this.mailDebug = mailDebug;
    }

    @Override
    public String toString() {
        return "StmpProperties{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authentication='" + authentication + '\'' +
                ", startTlsEnable='" + startTlsEnable + '\'' +
                ", transportProtocol='" + transportProtocol + '\'' +
                ", mailDebug='" + mailDebug + '\'' +
                '}';
    }
}
