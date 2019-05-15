package com.spendster.presentation.addExpenses;

import android.content.res.Resources;

import com.spendster.R;
import com.spendster.data.entity.Expense;

import java.text.DecimalFormat;
import java.util.HashMap;

public class AddExpensesPresenter {
    private final AddExpensesView addExpensesView;
    private HashMap<String, Object> expense;
    private final static String DATE = "Date";
    private final static String CATEGORY_ID = "CategoryId";

    public AddExpensesPresenter(AddExpensesView addExpensesView) {
        this.addExpensesView = addExpensesView;
    }

    public void save(double amount, String title, String note, String categoryId, long date) {
        // validation
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        amount = Double.valueOf(decimalFormat.format(amount));
        if (title.equals(Resources.getSystem().getString(R.string.expenses)) && categoryId.isEmpty()){
            addExpensesView.showError("Category is not selected");
        }
        if (note.isEmpty()){
            addExpensesView.showError("Write some notes");
        }
        Expense expense = new Expense(amount, date, note, categoryId);
        // request
        // handle on View
    }
}
