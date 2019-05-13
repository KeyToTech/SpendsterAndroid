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
import android.widget.TextView;

import com.spendster.R;
import com.spendster.presentation.homeScreen.Profile.ProfileFragment;
import com.spendster.presentation.addExpenses.AddExpensesActivity;
import com.spendster.presentation.welcomeScreen.WelcomeActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener,
        BottomNavigationView.OnNavigationItemSelectedListener, HomeView {
    private HomePresenter homePresenter;

    private TextView toolbarCaption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initUI();
    }

    private void initUI() {
        final Toolbar toolbar = findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);
        homePresenter = new HomePresenter(this, getBaseContext());
        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationMenu);
        toolbarCaption = findViewById(R.id.toolbarCaption);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new DashboardFragment());
        initButtons();
    }

    private void initButtons() {
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnLogOut = findViewById(R.id.btnLogOut);
        btnAdd.setOnClickListener(this);
        btnLogOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAdd:
                addExpenses();
                break;
            case R.id.btnLogOut:
                homePresenter.logOut();
                break;
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.activityItem:
                setToolbarCaption(R.string.activity);
                fragment = DashboardFragment.newInstance();
                break;
            case R.id.overviewItem:
                setToolbarCaption(R.string.overview);
                fragment = OverviewFragment.newInstance();
                break;
            case R.id.budgetItem:
                setToolbarCaption(R.string.budget);
                fragment = BudgetFragment.newInstance();
                break;
            case R.id.profileItem:
                setToolbarCaption(R.string.profile);
                fragment = ProfileFragment.newInstance();
                break;
        }

        return loadFragment(fragment);
    }

    @Override
    public void goToWelcomeScreen(){
        finish();
        startActivity(new Intent(HomeActivity.this, WelcomeActivity.class));
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public void setToolbarCaption(int caption) {
        toolbarCaption.setText(caption);
    }

    @Override
    public void addExpenses() {
        startActivity(new Intent(this, AddExpensesActivity.class));
    }
}
