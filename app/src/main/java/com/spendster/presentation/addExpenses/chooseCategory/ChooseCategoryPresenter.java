package com.spendster.presentation.addExpenses.chooseCategory;

import com.spendster.data.entity.Category;

import java.util.List;

public class ChooseCategoryPresenter {
    private final CategoryView categoryView;
    private final CategoryModel categoryModel;

    public ChooseCategoryPresenter(CategoryView categoryView, CategoryModel categoryModel) {
        this.categoryView = categoryView;
        this.categoryModel = categoryModel;
    }

    public void fetchCategories() {
        List<Category> categories = categoryModel.getCategories();
        if (categories != null) {
            categoryView.bindCategories(categories);
        } else {
            categoryView.showError("Bad server connection");
        }
    }
}
