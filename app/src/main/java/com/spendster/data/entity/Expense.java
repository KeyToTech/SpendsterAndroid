package com.spendster.data.entity;

import java.util.Date;

public class Expense {
    private final int expensesId;
    private final double amount;
    private final Date createdDate;
    private final String note;
    private final int categoryId;

    public Expense(int expensesId, double amount, Date createdDate, String note, int categoryId) {
        this.expensesId = expensesId;
        this.amount = amount;
        this.createdDate = createdDate;
        this.note = note;
        this.categoryId = categoryId;
    }

    public Expense(double amount, Date createdDate, String note, int categoryId){
        this(0, amount, createdDate, note, categoryId);
    }

    public Expense(double amount, String note, int categoryId){
        this(0, amount, new Date(), note, categoryId);
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "expensesId=" + expensesId +
                ", amount=" + amount +
                ", createdDate=" + createdDate +
                '}';
    }
}
