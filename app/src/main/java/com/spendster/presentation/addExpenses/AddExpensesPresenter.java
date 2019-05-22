package com.spendster.presentation.addExpenses;

import android.content.res.Resources;

import com.spendster.R;
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

    public AddExpensesPresenter(AddExpensesView addExpensesView, ServerAddExpensesModel
            serverAddExpensesModel, SUserStorage sUserStorage) {
        this.addExpensesView = addExpensesView;
        this.serverAddExpensesModel = serverAddExpensesModel;
        this.sUserStorage = sUserStorage;
    }

    public void save(double amount, String title, String note, String categoryId, TextDate textDate) {
        long date = convertDate(textDate);
        String userId = this.sUserStorage.read().getUserId();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        amount = Double.valueOf(decimalFormat.format(amount));
        ValidationResource validationResource = validation(title, note, categoryId);
        if (!validationResource.isValid()) {
            addExpensesView.showError(validationResource.message());
        } else {
            if (this.serverAddExpensesModel != null) {
                this.compositeDisposable.add(this.serverAddExpensesModel.save(new
                        Expense(userId, amount, date, note, categoryId))
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
    }

    private ValidationResource validation(String title, String note, String categoryId) {
        boolean isValid = true;
        String message = "";
        if (title.equals(Resources.getSystem().getString(R.string.expenses)) && categoryId.isEmpty()) {
            message = "Category is not selected";
            isValid = false;
        }
        if (note.isEmpty()) {
            message = "Write some notes";
            isValid = false;
        }
        return new ValidationResource(message, isValid);
    }

    private long convertDate(TextDate textDate){
        long date;
        try {
            date = textDate.date().getTime();
        } catch (ParseException pe) {
            addExpensesView.showError("Date is not valid. That's why current date is set");
            date = new Date().getTime();
        }
        return date;
    }

    public void dispose() {
        this.compositeDisposable.dispose();
    }
}
