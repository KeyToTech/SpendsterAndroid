package com.spendster.presentation.addExpenses.chooseCategory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.spendster.R;
import com.spendster.data.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class ChooseCategoryActivity extends AppCompatActivity {

    private List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);

        initCategories();
        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, categories, new OnItemClickListener() {
            @Override
            public void onItemClick(Category item) {
                Gson gson = new Gson();
                String json = gson.toJson(item);
                Intent intent = new Intent();
                intent.putExtra("Category", json);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void initCategories(){
        categories = new ArrayList<>();
        categories.add(new Category("Education", R.drawable.user_light_theme));
        categories.add(new Category("House", R.drawable.activity));
        categories.add(new Category("Food & Drink", R.drawable.budget_light_theme));
        categories.add(new Category("Travel", R.drawable.calendar_for_light_theme));
        categories.add(new Category("Bills & Fees", R.drawable.camera));
        categories.add(new Category("Shopping", R.drawable.overview_light_theme));
        categories.add(new Category("Sport", R.drawable.oval));
        categories.add(new Category("Utilities", R.drawable.icons_check_input));
        categories.add(new Category("Healths", R.drawable.user_light_theme));
        categories.add(new Category("Presents", R.drawable.overview_light_theme));
        categories.add(new Category("Hobby", R.drawable.budget_light_theme));
        categories.add(new Category("Love", R.drawable.camera));
        categories.add(new Category("Relatives", R.drawable.icons_check_input));
        categories.add(new Category("Clubs", R.drawable.user_light_theme));
        categories.add(new Category("Lost", R.drawable.budget_light_theme));
        categories.add(new Category("Education", R.drawable.user_light_theme));
        categories.add(new Category("House", R.drawable.activity));
        categories.add(new Category("Food & Drink", R.drawable.budget_light_theme));
        categories.add(new Category("Travel", R.drawable.calendar_for_light_theme));
        categories.add(new Category("Bills & Fees", R.drawable.camera));
        categories.add(new Category("Shopping", R.drawable.overview_light_theme));
        categories.add(new Category("Sport", R.drawable.oval));
        categories.add(new Category("Utilities", R.drawable.icons_check_input));
        categories.add(new Category("Healths", R.drawable.user_light_theme));
        categories.add(new Category("Presents", R.drawable.overview_light_theme));
        categories.add(new Category("Hobby", R.drawable.budget_light_theme));
        categories.add(new Category("Love", R.drawable.camera));
        categories.add(new Category("Relatives", R.drawable.icons_check_input));
        categories.add(new Category("Clubs", R.drawable.user_light_theme));
        categories.add(new Category("Lost", R.drawable.budget_light_theme));
    }
}
