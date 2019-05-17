package com.spendster.presentation.homeScreen.Dashboard;

import com.spendster.data.entity.Expense;

import java.util.List;

public interface DashboardModel {
    List<Expense> getExpenses();
}
