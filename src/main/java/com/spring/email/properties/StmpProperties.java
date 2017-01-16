package com.spring.email.properties;

/**
 * Created by Seth on 1/12/2017.
 */
public class StmpProperties {

    private String host;
    private String port;
    private String username;
    private String password;
    private String auth;
    private String starttlsEnable;

    public StmpProperties() {
        super();
    }

    public StmpProperties(String host, String port, String username, String password, String auth, String starttlsEnable) {
        this.host = host;
        this.port = port;
        // The username and password will act as the from portion in the email the to portion will need to be changed on the fly
        this.username = username;
        this.password = password;
        this.auth = auth;
        this.starttlsEnable = starttlsEnable;
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

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getStarttlsEnable() {
        return starttlsEnable;
    }

    public void setStarttlsEnable(String starttlsEnable) {
        this.starttlsEnable = starttlsEnable;
    }

    @Override
    public String toString() {
        return "StmpProperties{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", auth=" + auth +
                ", starttlsEnable=" + starttlsEnable +
                '}';
    }
}
