package com.shao.bean;

/**
 * Created by shaozhuquan on 2018/10/9.
 */
public class Email {
    private String serverAddress;
    private String sendAddress;
    private String[] acceptAddress;
    private String sendPort;
    private String userName;
    private String password;

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public String[] getAcceptAddress() {
        return acceptAddress;
    }

    public void setAcceptAddress(String[] acceptAddress) {
        this.acceptAddress = acceptAddress;
    }

    public String getSendPort() {
        return sendPort;
    }

    public void setSendPort(String sendPort) {
        this.sendPort = sendPort;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
