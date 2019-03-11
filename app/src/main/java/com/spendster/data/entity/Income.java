package com.spendster.data.entity;

import java.util.Date;

public class Income {
    private final int incomesId;
    private final double amount;
    private final Date createdDate;

    public Income(int incomesId, double amount, Date createdDate) {
        this.incomesId = incomesId;
        this.amount = amount;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Incomes{" +
                "incomesId=" + incomesId +
                ", amount=" + amount +
                ", createdDate=" + createdDate +
                '}';
    }
}
