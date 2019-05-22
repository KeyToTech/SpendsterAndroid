package com.spendster.presentation.homeScreen.Dashboard;

import com.spendster.data.entity.Expense;

import java.util.List;

import io.reactivex.Flowable;

public interface DashboardModel {
    Flowable<List<Expense>> getExpenses();
}
