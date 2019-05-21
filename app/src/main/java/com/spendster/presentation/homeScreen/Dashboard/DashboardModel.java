package com.spendster.presentation.homeScreen.Dashboard;

import com.spendster.data.entity.Expense;

import java.util.List;

import io.reactivex.Observable;

public interface DashboardModel {
    Observable<List<Expense>> getExpenses();
}
