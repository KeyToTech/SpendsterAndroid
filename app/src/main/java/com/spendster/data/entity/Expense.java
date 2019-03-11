package com.spendster.data.entity;

import java.util.Date;

public class Expense {
    private final int expensesId;
    private final double amount;
    private final Date createdDate;

    public Expense(int expensesId, double amount, Date createdDate) {
        this.expensesId = expensesId;
        this.amount = amount;
        this.createdDate = createdDate;
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
