package com.spendster.presentation.addExpenses;

import android.content.Context;
import android.content.res.Resources;

import com.spendster.R;
import com.spendster.data.entity.Expense;
import com.spendster.presentation.authentication.SharedPreferencesUserStorage;

import java.text.DecimalFormat;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class AddExpensesPresenter {
    private final Context context;
    private final AddExpensesView addExpensesView;
    private final ServerAddExpensesModel serverAddExpensesModel;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public AddExpensesPresenter(AddExpensesView addExpensesView, ServerAddExpensesModel
            serverAddExpensesModel, Context contex) {
        this.addExpensesView = addExpensesView;
        this.serverAddExpensesModel = serverAddExpensesModel;
        this.context = contex;
    }

    public void save(double amount, String title, String note, String categoryId, long date) {
        // validation
        SharedPreferencesUserStorage sharedPreferencesUserStorage = new SharedPreferencesUserStorage(context);
        String userId = sharedPreferencesUserStorage.read().getUserId();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        amount = Double.valueOf(decimalFormat.format(amount));
        if (title.equals(Resources.getSystem().getString(R.string.expenses)) && categoryId.isEmpty()) {
            addExpensesView.showError("Category is not selected");
        }
        if (note.isEmpty()) {
            addExpensesView.showError("Write some notes");
        }
        // request
        Expense expense = new Expense(userId, amount, date, note, categoryId);
        if (serverAddExpensesModel != null) {
            compositeDisposable.add(serverAddExpensesModel.save(expense)
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
        // handle on View
    }

    public void dispose(){
        compositeDisposable.dispose();
    }
}
