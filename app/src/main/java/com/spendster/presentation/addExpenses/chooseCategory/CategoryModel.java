package com.spendster.presentation.addExpenses.chooseCategory;

import com.spendster.data.entity.Category;

import java.util.List;

import io.reactivex.Single;

public interface CategoryModel {
    Single<List<Category>> getCategories();
}
