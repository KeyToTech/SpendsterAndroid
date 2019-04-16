package com.spendster.presentation.mainScreen;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.spendster.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Fragment> pageFragments;
    private ViewPager viewPager;
    private Button btnAdd, btnActivity, btnOverview, btnBudget, btnProfile;
    private ArrayList<TextView> textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        initUI();
    }

    private void initUI() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.view_pager_main);
        initPageFragments();
        initViewPager();
        initTextView();
        setColors(0);
        initButtons();
    }

    private void initViewPager() {
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), pageFragments);
        viewPager.setAdapter(mainPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
    }

    private void initPageFragments(){
        pageFragments = new ArrayList<>();
        pageFragments.add(PageFragment.newInstance(R.layout.activity_activity_slide1));
        pageFragments.add(PageFragment.newInstance(R.layout.activity_activity_slide1));
        pageFragments.add(PageFragment.newInstance(R.layout.activity_activity_slide1));
    }

    private void initButtons(){
        btnActivity = findViewById(R.id.btnActivity);
        btnOverview = findViewById(R.id.btnOverview);
        btnBudget = findViewById(R.id.btnBudget);
        btnProfile = findViewById(R.id.btnProfile);
        btnActivity.setOnClickListener(this);
        btnOverview.setOnClickListener(this);
        btnBudget.setOnClickListener(this);
        btnProfile.setOnClickListener(this);
    }

    private void initTextView(){
        TextView tvActivity = findViewById(R.id.tvActivity);
        TextView tvOverView = findViewById(R.id.tvOverview);
        TextView tvBudget = findViewById(R.id.tvBudget);
        TextView tvProfile = findViewById(R.id.tvProfile);
        textViews = new ArrayList<>();
        textViews.add(tvActivity);
        textViews.add(tvOverView);
        textViews.add(tvBudget);
        textViews.add(tvProfile);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnActivity:
                setColors(0);
                break;
            case R.id.btnOverview:
                setColors(1);
                break;
            case R.id.btnBudget:
                setColors(2);
                break;
            case R.id.btnProfile:
                setColors(3);
                break;
        }
    }

    public void setColors(int number){
        String active = "#31d19e";
        String inActive = "#979797";
        for (int i = 0; i < textViews.size(); i++){
            if (i == number){
                textViews.get(i).setTextColor(Color.parseColor(active));
            }
            else {
                textViews.get(i).setTextColor(Color.parseColor(inActive));
            }
        }
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) { }
    };
}
