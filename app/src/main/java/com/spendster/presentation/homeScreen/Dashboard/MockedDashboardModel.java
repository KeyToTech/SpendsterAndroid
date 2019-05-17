package com.spendster.presentation.homeScreen.Dashboard;

import com.spendster.data.entity.Expense;

import java.util.ArrayList;
import java.util.List;

public class MockedDashboardModel implements DashboardModel {
    @Override
    public List<Expense> getExpenses() {
        List<Expense> data = new ArrayList<>();
        data.add(new Expense("1", 100, 1557964800, "Bread", "76"));
        data.add(new Expense("2", 200, 1557878400, "Car", "50"));
        data.add(new Expense("3", 300, 1558051200, "Ice cream", "54"));
        data.add(new Expense("4", 400, 1557964800, "House", "38"));
        data.add(new Expense("5", 500, 1558051200, "Bora-Bora", "23"));
        data.add(new Expense("6", 600, 1558051200, "Food for cat", "21"));
        data.add(new Expense("7", 100, 1557964800, "Bread", "67"));
        data.add(new Expense("8", 200, 1557878400, "Car", "55"));
        data.add(new Expense("8", 300, 1558051200, "Ice cream", "44"));
        data.add(new Expense("10", 400, 1557964800, "House", "34"));
        data.add(new Expense("11", 500, 1558051200, "Bora-Bora", "25"));
        data.add(new Expense("12", 600, 1558051200, "Food for cat", "9"));
        data.add(new Expense("13", 100, 1557964800, "Bread", "6"));
        data.add(new Expense("14", 200, 1557878400, "Car", "5"));
        data.add(new Expense("15", 300, 1558051200, "Ice cream", "4"));
        data.add(new Expense("16", 400, 1557964800, "House", "3"));
        data.add(new Expense("17", 500, 1558051200, "Bora-Bora", "2"));
        data.add(new Expense("18", 600, 1558051200, "Food for cat", "1"));
        return data;
    }
}
