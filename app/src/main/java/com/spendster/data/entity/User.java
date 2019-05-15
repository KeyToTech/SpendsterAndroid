package com.spendster.data.entity;

import java.util.Date;

public class User {
    private final String userId;
    private final String email;
    private final String username;
    private final String password;
    private final double balance;
    private final Date createdDate;

    public User() {
        this.userId = "";
        this.email = "";
        this.username = "";
        this.password = "";
        this.balance = 0.0;
        this.createdDate = new Date();
    }

    public User(String email, String password){
        this("",email, null, password, 0.0, new Date());
    }

    public User(String email, String username, String password){
        this("",email, username, password, 0.0, new Date());
    }


    public User(String userId, String email, String username, String password, double balance, Date createdDate) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.createdDate = createdDate;
    }
}
