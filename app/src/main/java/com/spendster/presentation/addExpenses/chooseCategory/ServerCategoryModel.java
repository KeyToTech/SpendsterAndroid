package com.spendster.presentation.addExpenses.chooseCategory;

import com.spendster.data.entity.Category;

import java.util.List;

import io.reactivex.Single;

public class ServerCategoryModel implements CategoryModel {
    private APICategories apiCategories;

    public ServerCategoryModel(APICategories apiCategories) {
        this.apiCategories = apiCategories;
    }

    @Override
    public Single<List<Category>> getCategories(String token) {
        return apiCategories.getCategories(token);
    }
}
