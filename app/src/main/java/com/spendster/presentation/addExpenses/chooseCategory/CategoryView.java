package com.spendster.presentation.addExpenses.chooseCategory;

import com.spendster.data.entity.Category;
import com.spendster.presentation.ErrorsView;
import com.spendster.presentation.LoadingView;

import java.util.List;

public interface CategoryView extends ErrorsView, LoadingView {
    void bindCategories(List<Category> categories);
    void backToPreviousScreen();
}
