package com.spendster.presentation.homeScreen.Dashboard;

import com.spendster.data.entity.Expense;

import java.util.List;

public interface DashboardView {
    void bindExpenses(List<Expense> expenses);
}
