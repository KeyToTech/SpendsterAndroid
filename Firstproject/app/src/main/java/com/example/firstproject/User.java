package com.example.firstproject;

import java.util.Date;

public class User {
    private int user_id;
    private String user_name;
    private String password;
    private int balance;
    private Date created_date;

    public User(int user_id, String user_name, String password, int balance, Date created_date) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.balance = balance;
        this.created_date = created_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", created_date=" + created_date +
                '}';
    }
}
