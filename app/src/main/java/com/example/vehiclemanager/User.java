package com.example.vehiclemanager;

public class User {
    private String success;
    private String message;
    private String token;
    private String username;
    private String password;
    private String createTime;

    public User(String success, String message, String token, String username, String password, String createTime) {
        this.success = success;
        this.message = message;
        this.token = token;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
