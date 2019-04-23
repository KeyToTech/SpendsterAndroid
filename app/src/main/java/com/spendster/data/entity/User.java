package com.spendster.data.entity;

import java.util.Date;

public class User {
    private final int userId;
    private final String email;
    private final String userName;
    private final String password;
    private final double balance;
    private final Date createdDate;

    public User(String email, String password){
        this.userId = 0;
        this.email = email;
        this.userName = null;
        this.balance = 0;
        this.password = password;
        this.createdDate = new Date();
    }


    public User(int userId, String email, String userName, String password, double balance, Date createdDate) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.balance = balance;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", createdDate=" + createdDate +
                '}';
    }
}
