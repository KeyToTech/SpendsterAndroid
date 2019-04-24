package com.spendster.data.entity;

import java.util.Date;

public class User {
    private final int userId;
    private final String email;
    private final String username;
    private final String password;
    private final double balance;
    private final Date createdDate;

    public User(String email, String password){
        this(0,email, null, password, 0.0, new Date());
    }

    public User(String email, String username, String password){
        this(0,email, username, password, 0.0, new Date());
    }


    public User(int userId, String email, String username, String password, double balance, Date createdDate) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", createdDate=" + createdDate +
                '}';
    }
}
