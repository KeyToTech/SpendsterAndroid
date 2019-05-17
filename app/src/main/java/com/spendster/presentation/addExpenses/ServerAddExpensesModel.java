package com.spendster.presentation.addExpenses;

import com.spendster.data.entity.Expense;

import io.reactivex.Single;

public class ServerAddExpensesModel implements AddExpensesModel {

    private APIPostExpenses apiPostExpenses;

    public ServerAddExpensesModel(APIPostExpenses apiPostExpenses) {
        this.apiPostExpenses = apiPostExpenses;
    }

    @Override
    public Single<Expense> save(Expense expense) {
        return apiPostExpenses.save(expense);
    }
}
