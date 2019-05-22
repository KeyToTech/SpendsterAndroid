package com.spendster.data.entity;

import java.util.Date;

public class Expense {
    private final String id;
    private final String userId;
    private final double amount;
    private final long createdDate;
    private final String note;
    private final String categoryId;

    public Expense(String id, String userId, double amount, long createdDate, String note, String categoryId) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.createdDate = createdDate;
        this.note = note;
        this.categoryId = categoryId;
    }

    public Expense(String userId, double amount, long createdDate, String note, String categoryId) {
        this("", userId, amount, createdDate, note, categoryId);
    }

    public Expense(String userId, double amount, String note, String categoryId) {
        this("", userId, amount, new Date().getTime(), note, categoryId);
    }


    public double getAmount() {
        return amount;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public String getNote() {
        return note;
    }

    public String getCategoryId() {
        return categoryId;
    }
}
