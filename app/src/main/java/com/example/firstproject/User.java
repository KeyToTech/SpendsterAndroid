package com.example.firstproject;

import java.util.Date;

public class User {
    private int userId;
    private String userName;
    private String password;
    private int balance;
    private Date createdDate;

    public User(int userId, String userName, String password, int balance, Date createdDate) {
        this.userId = userId;
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
