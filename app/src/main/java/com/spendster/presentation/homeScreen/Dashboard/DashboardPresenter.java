package com.spendster.presentation.homeScreen.Dashboard;

import android.util.Log;

import com.spendster.data.entity.Expense;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class DashboardPresenter {
    private final static String LOG = "Expenses list";
    private final DashboardView dashboardView;
    private final DashboardModel dashboardModel;
    private final CompositeDisposable compositeDisposable;

    public DashboardPresenter(DashboardView dashboardView, DashboardModel dashboardModel) {
        this.dashboardView = dashboardView;
        this.dashboardModel = dashboardModel;
        this.compositeDisposable = new CompositeDisposable();
    }

    public void fetchExpenses(){
        if (dashboardView != null){
            if (dashboardModel != null){
                compositeDisposable.add(dashboardModel.getExpenses()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<List<Expense>>() {

                            @Override
                            public void onNext(List<Expense> expenses) {
                                dashboardView.bindExpenses(expenses);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d(LOG, "Empty Data");
                            }

                            @Override
                            public void onComplete() {

                            }
                        }));
            }
        }
    }
}
