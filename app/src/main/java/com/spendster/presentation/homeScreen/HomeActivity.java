package com.spendster.presentation.homeScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.spendster.R;
import com.spendster.presentation.addExpenses.AddExpensesActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initUI();
    }

    private void initUI() {
        final Toolbar toolbar = findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);
        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new DashboardFragment());
        initButtons();
    }

    private void initButtons(){
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAdd:
                addExpenses();
        }

    }

    private void addExpenses() {
        startActivity(new Intent(this, AddExpensesActivity.class));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.activityItem:
                fragment = DashboardFragment.newInstance();
                break;
            case R.id.overviewItem:
                fragment = OverviewFragment.newInstance();
                break;
            case R.id.budgetItem:
                fragment = BudgetFragment.newInstance();
                break;
            case R.id.profileItem:
                fragment = ProfileFragment.newInstance();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
