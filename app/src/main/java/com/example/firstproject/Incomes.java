package com.example.firstproject;

import java.util.Date;

public class Incomes {
    private final int incomesId;
    private final double amount;
    private final Date createdDate;

    public Incomes(int incomesId, double amount, Date createdDate) {
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
