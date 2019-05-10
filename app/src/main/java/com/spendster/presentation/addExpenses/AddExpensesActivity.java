package com.spendster.presentation.addExpenses;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.spendster.R;

public class AddExpensesActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenses);
        initUI();
    }

    private void initUI(){
        ConstraintLayout incToday = findViewById(R.id.incToday);
        ConstraintLayout incCategory = findViewById(R.id.incCategory);
        ConstraintLayout incNote = findViewById(R.id.incNote);
        ConstraintLayout incCurrency = findViewById(R.id.incCurrency);
        incToday.setOnClickListener(this);
        incCategory.setOnClickListener(this);
        incCurrency.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
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

    private void launchCalendar(){
        startActivity(new Intent(this, CalendarActivity.class));
    }

    private void launchCategoryScreen(){
        Toast.makeText(this,"Category", Toast.LENGTH_SHORT).show();
    }

    private void launchCurrencyScreen(){
        Toast.makeText(this,"Currency", Toast.LENGTH_SHORT).show();
    }
}
