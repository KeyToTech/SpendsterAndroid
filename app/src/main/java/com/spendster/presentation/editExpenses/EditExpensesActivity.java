package com.spendster.presentation.editExpenses;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.spendster.R;
import com.spendster.data.entity.Expense;
import com.spendster.presentation.utils.SDate;

import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

public class EditExpensesActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTitle;
    private TextView tvCategory;
    private EditText etAmount;
    private TextView tvToday;
    private EditText etNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenses);
        unitUI();
        setValues();
    }

    private void unitUI() {
        this.etNote = findViewById(R.id.etNote);
        this.tvTitle = findViewById(R.id.tvTitle);
        this.tvCategory = findViewById(R.id.tvCategory);
        this.etAmount = findViewById(R.id.etAmount);
        this.tvToday = findViewById(R.id.tvToday);
    }

    private void setValues(){
        Expense expense = getExpense();
        tvTitle.setText(expense.getCategoryId());
        tvToday.setText((new SDate(new Date(expense.getCreatedDate())).dateFormatted()));
        etAmount.setText(Double.toString(expense.getAmount()));
        etNote.setText(expense.getNote());
    }

    private Expense getExpense() {
        String json = getIntent().getStringExtra("Expense");
        Gson gson = new Gson();
        return gson.fromJson(json, Expense.class);
    }


    @Override
    public void onClick(View view) {

    }
}
