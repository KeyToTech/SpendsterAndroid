package com.spendster.presentation.addExpenses.chooseCategory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.spendster.R;
import com.spendster.data.entity.Category;

import java.util.List;

public class ChooseCategoryActivity extends AppCompatActivity implements CategoryView {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
        initUI();
    }

    private void initUI(){
        recyclerView = findViewById(R.id.recyclerView);
        ChooseCategoryPresenter chooseCategoryPresenter = new ChooseCategoryPresenter(this,
                new MockedCategoryModel());
        chooseCategoryPresenter.fetchCategories();
    }

    private void putCategoryToIntent(Category item) {
        Gson gson = new Gson();
        String json = gson.toJson(item);
        Intent intent = new Intent();
        intent.putExtra("Category", json);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void bindCategories(List<Category> categories) {
        CategoryRecyclerViewAdapter categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(
                this, categories, new OnCategoryClickListener() {
            @Override
            public void onCategoryClick(Category item) {
                putCategoryToIntent(item);
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(categoryRecyclerViewAdapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideError() {
        //        TODO: https://trello.com/c/qWVqupHK/137-error-interface
    }
}
