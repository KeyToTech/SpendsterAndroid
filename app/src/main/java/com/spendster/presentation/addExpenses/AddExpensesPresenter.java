package com.spendster.presentation.addExpenses;

import com.spendster.data.entity.Expense;
import com.spendster.presentation.authentication.SUserStorage;
import com.spendster.presentation.utils.TextDate;
import com.spendster.presentation.validation.ValidationResource;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class AddExpensesPresenter {
    private final SUserStorage sUserStorage;
    private final AddExpensesView addExpensesView;
    private final ServerAddExpensesModel serverAddExpensesModel;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final static String EXPENSE = "Expenses";

    public AddExpensesPresenter(AddExpensesView addExpensesView, ServerAddExpensesModel
            serverAddExpensesModel, SUserStorage sUserStorage) {
        this.addExpensesView = addExpensesView;
        this.serverAddExpensesModel = serverAddExpensesModel;
        this.sUserStorage = sUserStorage;
    }

    public void save(String amount, String title, String note, String categoryId, TextDate textDate) {
        long date;
        try {
            date = textDate.date().getTime();
        } catch (ParseException pe) {
            addExpensesView.showError("Date is not valid. That's why current date is set");
            date = new Date().getTime();
        }
        String userId = this.sUserStorage.read().getUserId();
        ValidationResource validationResource = validation(amount, title, note, categoryId);
        if (!validationResource.isValid()) {
            addExpensesView.showError(validationResource.message());
            return;
        }
        double expenseAmount = formattingAmount(amount);
        Expense expense = new Expense(userId, expenseAmount, date, note, categoryId);
        if (this.serverAddExpensesModel != null) {
            this.compositeDisposable.add(this.serverAddExpensesModel.save(sUserStorage.read().getToken(), expense)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSingleObserver<Expense>() {
                        @Override
                        public void onSuccess(Expense expense) {
                            addExpensesView.successFinish();
                        }

                        @Override
                        public void onError(Throwable e) {
                            addExpensesView.showError(e.getMessage());
                        }
                    }));
        }
    }

    private ValidationResource validation(String amount, String title, String note, String categoryId) {
        boolean isValid = true;
        String message = "";
        if (title.equals(EXPENSE) && categoryId == null) {
            message = "Category is not selected";
            isValid = false;
        }
        if (note.isEmpty()) {
            message = "Write some notes";
            isValid = false;
        }
        if (amount.equals("")) {
            message = "Input amount of Expense";
            isValid = false;
        }
        return new ValidationResource(message, isValid);
    }

    private double formattingAmount(String amount){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.valueOf(decimalFormat.format(parseAmount(amount)));
    }

    private double parseAmount(String amount) {
        return Double.parseDouble(amount);
    }

    public void dispose() {
        this.compositeDisposable.dispose();
    }
}
