package com.spendster.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {
    private final String userId;
    private final String email;
    private final String username;
    private final String password;
    private final double balance;
    private final Date createdDate;

    @SerializedName("token")
    private final String authToken;

    public User() {
        this.userId = "";
        this.email = "";
        this.username = "";
        this.password = "";
        this.balance = 0.0;
        this.createdDate = new Date();
        this.authToken = "";
    }

    public User(String email, String password) {
        this("", email, null, password, 0.0, new Date(), "");
    }

    public User(String email, String username, String password) {
        this("", email, username, password, 0.0, new Date(), "");
    }


    public User(String userId, String email, String username, String password, double balance, Date createdDate, String authToken) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.createdDate = createdDate;
        this.authToken = authToken;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return userId;
    }

    public String getAuthToken() {
        return authToken;
    }
}
