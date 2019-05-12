package com.spendster.presentation.addExpenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.spendster.BuildConfig;
import com.spendster.R;
import com.spendster.data.entity.Category;
import com.spendster.presentation.addExpenses.chooseCategory.ChooseCategoryActivity;

public class AddExpensesActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int REQUEST_CODE_CALENDAR = 1;
    private final static int REQUEST_CODE_CATEGORY = 2;
    private final static int REQUEST_CODE_CURRENCY = 3;
    private TextView tvTitle;
    private TextView tvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenses);
        initUI();
    }

    private void initUI() {
        tvTitle = findViewById(R.id.tvTitle);
        tvCategory = findViewById(R.id.tvCategory);
        Button btnCancelExpenses = findViewById(R.id.btnCancelExpenses);
        ConstraintLayout incToday = findViewById(R.id.incToday);
        ConstraintLayout incCategory = findViewById(R.id.incCategory);
        ConstraintLayout incNote = findViewById(R.id.incNote);
        ConstraintLayout incCurrency = findViewById(R.id.incCurrency);
        btnCancelExpenses.setOnClickListener(this);
        incToday.setOnClickListener(this);
        incCategory.setOnClickListener(this);
        incCurrency.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCancelExpenses:
                backToPreviousScreen();
                break;
            case R.id.incToday:
                launchCalendar();
                break;
            case R.id.incCategory:
                launchCategoryScreen();
                break;
            case R.id.incCurrency:
                launchCurrencyScreen();
                break;
        }
    }

    private void backToPreviousScreen() {
        finish();
    }

    private void launchCalendar() {
        Toast.makeText(this, "Calendar", Toast.LENGTH_SHORT).show();
    }

    private void launchCategoryScreen() {
            startActivityForResult(new Intent(this, ChooseCategoryActivity.class),
                    REQUEST_CODE_CATEGORY);
    }

    private void launchCurrencyScreen() {
        Toast.makeText(this, "Currency", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            if (resultCode == RESULT_OK) {
                switch (requestCode) {
                    case REQUEST_CODE_CALENDAR:
                        break;
                    case REQUEST_CODE_CATEGORY:
                        String json = data.getStringExtra("Category");
                        Gson gson = new Gson();
                        Category category = gson.fromJson(json, Category.class);
                        tvTitle.setText(category.getNameOfCategory());
                        tvCategory.setText("Re-select category");

                        break;
                    case REQUEST_CODE_CURRENCY:
                        break;
                }
            } else {
                Log.d(BuildConfig.MY_LOGS, "Wrong result");
            }
        } else {
            Log.d(BuildConfig.MY_LOGS, "Empty Data");
        }
    }
}
