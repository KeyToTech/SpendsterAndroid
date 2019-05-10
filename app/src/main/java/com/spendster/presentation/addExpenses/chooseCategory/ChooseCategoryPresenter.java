package com.spendster.presentation.addExpenses.chooseCategory;

public class ChooseCategoryPresenter {
    private final CategoryView categoryView;
    private final CategoryModel categoryModel;

    public ChooseCategoryPresenter(CategoryView categoryView, CategoryModel categoryModel) {
        this.categoryView = categoryView;
        this.categoryModel = categoryModel;
    }

    public void fetchCategories() {
        if (categoryModel.storeCategories() != null) {
            categoryView.bindCategories(categoryModel.storeCategories());
        } else {
            categoryView.showError("Bad server connection");
        }
    }
}
