package com.spendster.presentation.addExpenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.spendster.APIClient;
import com.spendster.BuildConfig;
import com.spendster.R;
import com.spendster.data.entity.Category;
import com.spendster.presentation.addExpenses.chooseCategory.ChooseCategoryActivity;
import com.spendster.presentation.authentication.SharedPreferencesUserStorage;
import com.spendster.presentation.utils.SDate;
import com.spendster.presentation.utils.TextDate;

import java.util.Calendar;

import ru.slybeaver.slycalendarview.SlyCalendarDialog;

public class AddExpensesActivity extends AppCompatActivity implements View.OnClickListener, SlyCalendarDialog.Callback, AddExpensesView {

    private final static int REQUEST_CODE_CATEGORY = 1;
    private final static int REQUEST_CODE_CURRENCY = 2;
    private final static String CATEGORY = "Category";
    private final static String RE_SELECT_CATEGORY = "Re-select category";
    private String categoryID;
    private AddExpensesPresenter addExpensesPresenter;
    private TextView tvTitle;
    private TextView tvCategory;
    private EditText etAmount;
    private TextView tvToday;
    private EditText etNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenses);
        this.addExpensesPresenter = new AddExpensesPresenter(this,
                new ServerAddExpensesModel(APIClient.getClient().create(APIPostExpenses.class)),
                new SharedPreferencesUserStorage(getBaseContext()));
        initUI();
    }

    private void initUI() {
        this.etNote = findViewById(R.id.etNote);
        this.tvTitle = findViewById(R.id.tvTitle);
        this.tvCategory = findViewById(R.id.tvCategory);
        this.etAmount = findViewById(R.id.etAmount);
        this.tvToday = findViewById(R.id.tvToday);
        findViewById(R.id.btnAddTransaction).setOnClickListener(this);
        findViewById(R.id.incToday).setOnClickListener(this);
        findViewById(R.id.incCategory).setOnClickListener(this);
        findViewById(R.id.incCurrency).setOnClickListener(this);
        findViewById(R.id.btnCancelExpenses).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCancelExpenses:
                backToPreviousScreen();
                break;
            case R.id.btnAddTransaction:
                this.addExpenses();
                break;
            case R.id.incToday:
                this.launchCalendar();
                break;
            case R.id.incCategory:
                this.launchCategoryScreen();
                break;
            case R.id.incCurrency:
                this.launchCurrencyScreen();
                break;
        }
    }

    private void addExpenses() {
        this.addExpensesPresenter.save(
                this.amount(),
                this.title(),
                this.note(),
                this.categoryID,
                new TextDate(this.date())
        );
    }

    private String date() {
        return tvToday.getText().toString();
    }

    private String title() {
        return this.tvTitle.getText().toString();
    }

    public String amount() {
        return etAmount.getText().toString();
    }

    public String note() {
        return etNote.getText().toString();
    }

    private void launchCalendar() {
        new SlyCalendarDialog()
                .setSingle(false)
                .setFirstMonday(false)
                .setCallback(this)
                .show(getSupportFragmentManager(), "TAG_SLYCALENDAR");
    }

    private void launchCategoryScreen() {
        startActivityForResult(new Intent(this, ChooseCategoryActivity.class),
                REQUEST_CODE_CATEGORY);
    }

    private void launchCurrencyScreen() {
        Toast.makeText(this, "Currency", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancelled() {

    }

    @Override
    public void onDataSelected(Calendar firstDate, Calendar secondDate, int hours, int minutes) {
        if (firstDate != null) {
            firstDate.set(Calendar.HOUR_OF_DAY, hours);
            firstDate.set(Calendar.MINUTE, minutes);
            this.tvToday.setText(new SDate(firstDate.getTime()).dateFormatted());
        }
    }

    private void backToPreviousScreen() {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            if (resultCode == RESULT_OK) {
                switch (requestCode) {
                    case REQUEST_CODE_CATEGORY:
                        String json = data.getStringExtra(CATEGORY);
                        Gson gson = new Gson();
                        Category category = gson.fromJson(json, Category.class);
                        showCategorySelected(category);
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

    private void showCategorySelected(Category category) {
        this.tvTitle.setText(category.getName());
        this.tvCategory.setText(RE_SELECT_CATEGORY);
        this.categoryID = category.getId();
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
    public void successFinish() {
        Toast.makeText(this, "Expense saved", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        addExpensesPresenter.dispose();
    }
}

