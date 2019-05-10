package com.spendster.presentation.addExpenses.chooseCategory;

import com.spendster.data.entity.Category;
import com.spendster.presentation.ErrorsView;

import java.util.List;

public interface CategoryView extends ErrorsView {
    void bindCategories(List<Category> categories);
}
