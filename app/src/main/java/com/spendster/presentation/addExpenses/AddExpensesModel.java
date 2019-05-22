package com.spendster.presentation.addExpenses;

import com.spendster.data.entity.Expense;

import io.reactivex.Single;

public interface AddExpensesModel {
    Single<Expense> save(Expense expense);
}
