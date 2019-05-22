package com.spendster.presentation.addExpenses.chooseCategory;

import com.spendster.data.entity.Category;
import com.spendster.presentation.authentication.SUserStorage;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ChooseCategoryPresenter {
    private final CategoryView categoryView;
    private final CategoryModel categoryModel;
    private final CompositeDisposable compositeDisposable;
    private final SUserStorage sUserStorage;

    public ChooseCategoryPresenter(CategoryView categoryView, CategoryModel categoryModel, SUserStorage sUserStorage) {
        this.categoryView = categoryView;
        this.categoryModel = categoryModel;
        this.compositeDisposable = new CompositeDisposable();
        this.sUserStorage = sUserStorage;
    }

    public void fetchCategories() {
        categoryView.showLoading();
        compositeDisposable.add(categoryModel.getCategories(sUserStorage.read().getToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Category>>(){
                    @Override
                    public void onSuccess(List<Category> categories) {
                        categoryView.hideLoading();
                        categoryView.bindCategories(categories);
                    }

                    @Override
                    public void onError(Throwable e) {
                        categoryView.showError(e.getMessage());
                    }
                }));
    }
}
