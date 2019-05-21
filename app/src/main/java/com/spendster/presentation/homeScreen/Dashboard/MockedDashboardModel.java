package com.spendster.presentation.homeScreen.Dashboard;

import com.spendster.data.entity.Expense;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import io.reactivex.Observable;

public class MockedDashboardModel implements DashboardModel {

    @Override
    public Observable<List<Expense>> getExpenses() {
        List<Expense> data = new ArrayList<>();
        data.add(new Expense("1", 100, new Date().getTime(), "Bread", "76"));
        data.add(new Expense("6", 600, new Date().getTime() - 86400000, "Food for cat", "21"));
        data.add(new Expense("2", 200, new Date().getTime(), "Car", "50"));
        data.add(new Expense("3", 300, new Date().getTime(), "Ice cream", "54"));
        data.add(new Expense("8", 200, new Date().getTime() - 86400000, "Car", "55"));
        data.add(new Expense("4", 400, new Date().getTime(), "House", "38"));
        data.add(new Expense("5", 500, new Date().getTime(), "Bora-Bora", "23"));
        data.add(new Expense("7", 100, new Date().getTime() - 86400000, "Bread", "67"));
        data.add(new Expense("13", 100, new Date().getTime() - 86400000*2, "Bread", "6"));
        data.add(new Expense("8", 300, new Date().getTime() - 86400000, "Ice cream", "44"));
        data.add(new Expense("10", 400, new Date().getTime() - 86400000*2, "House", "34"));
        data.add(new Expense("11", 500, new Date().getTime() - 86400000*2, "Bora-Bora", "25"));
        data.add(new Expense("12", 600, new Date().getTime() - 86400000*2, "Food for cat", "9"));
        data.add(new Expense("14", 200, new Date().getTime() - 86400000*3, "Car", "5"));
        data.add(new Expense("18", 600, new Date().getTime() - 86400000*4, "Food for cat", "1"));
        data.add(new Expense("15", 300, new Date().getTime() - 86400000*3, "Ice cream", "4"));
        data.add(new Expense("16", 400, new Date().getTime() - 86400000*3, "House", "3"));
        data.add(new Expense("17", 500, new Date().getTime() - 86400000*3, "Bora-Bora", "2"));
        Comparator<Expense> expenseComparator = (o1, o2) -> (int) (o2.getCreatedDate() - o1.getCreatedDate());
        Collections.sort(data, expenseComparator);
        return Observable.just(data);
    }
}
