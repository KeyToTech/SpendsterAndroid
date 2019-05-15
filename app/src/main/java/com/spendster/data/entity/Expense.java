package com.spendster.data.entity;

public class Expense {
    private final String expensesId;
    private final double amount;
    private final long createdDate;
    private final String note;
    private final String categoryId;

    public Expense(String expensesId, double amount, long createdDate, String note, String categoryId) {
        this.expensesId = expensesId;
        this.amount = amount;
        this.createdDate = createdDate;
        this.note = note;
        this.categoryId = categoryId;
    }

    public Expense(double amount, long createdDate, String note, String categoryId){
        this("", amount, createdDate, note, categoryId);
    }

    public Expense(double amount, String note, String categoryId){
        this("", amount, 0, note, categoryId);
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
