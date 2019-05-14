package com.spendster.presentation.addExpenses.chooseCategory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.spendster.APIClient;
import com.spendster.R;
import com.spendster.data.entity.Category;

import java.util.List;

public class ChooseCategoryActivity extends AppCompatActivity implements CategoryView, View.OnClickListener {

    private CategoryRecyclerViewAdapter categoryRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
        initUI();
        ChooseCategoryPresenter chooseCategoryPresenter = new ChooseCategoryPresenter(this,
                new ServerCategoryModel(APIClient.getClient().create(APICategories.class)));
        chooseCategoryPresenter.fetchCategories();
    }

    private void initUI() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(
                this, new OnCategoryClickListener() {
            @Override
            public void onCategoryClick(Category item) {
                putCategoryToIntent(item);
            }
        });
        recyclerView.setAdapter(categoryRecyclerViewAdapter);
        Button btnCancel = findViewById(R.id.btnCancelCategory);
        btnCancel.setOnClickListener(this);
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
        categoryRecyclerViewAdapter.bind(categories);
    }

    @Override
    public void backToPreviousScreen() {
        finish();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideError() {
        //        TODO: https://trello.com/c/qWVqupHK/137-error-interface
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCancelCategory:
                backToPreviousScreen();
                break;
        }
    }
}
