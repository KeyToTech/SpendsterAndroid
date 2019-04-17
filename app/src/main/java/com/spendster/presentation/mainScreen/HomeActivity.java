package com.spendster.presentation.mainScreen;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.spendster.R;
import com.spendster.presentation.welcomeScreen.SlideFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Fragment> pageFragments;
    private ViewPager viewPager;
    private ArrayList<ImageView> imageViews;
    private ArrayList<TextView> textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initUI();
    }

    private void initUI() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.view_pager_main);
        initPageFragments();
        initTextView();
        initImageView();
        initViewPager();
        setColors(0);
        initConstraintLayouts();
        initButtons();
    }

    private void initImageView(){
        ImageView imgActivity = findViewById(R.id.imgActivity);
        ImageView imgOverview = findViewById(R.id.imgOverview);
        ImageView imgBudget = findViewById(R.id.imgBudget);
        ImageView imgProfile = findViewById(R.id.imgProfile);
        imageViews = new ArrayList<>();
        imageViews.add(imgActivity);
        imageViews.add(imgOverview);
        imageViews.add(imgBudget);
        imageViews.add(imgProfile);
    }

    private void initViewPager() {
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), pageFragments);
        viewPager.setAdapter(mainPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
    }

    private void initPageFragments(){
        pageFragments = new ArrayList<>();
        pageFragments.add(SlideFragment.newInstance(R.layout.activity_home_slide1));
        pageFragments.add(SlideFragment.newInstance(R.layout.activity_home_slide1));
        pageFragments.add(SlideFragment.newInstance(R.layout.activity_home_slide1));
    }

    private void initConstraintLayouts(){
        ConstraintLayout clActivity = findViewById(R.id.clActivity);
        ConstraintLayout clOverview = findViewById(R.id.clOverview);
        ConstraintLayout clBudget = findViewById(R.id.clBudget);
        ConstraintLayout clProfile = findViewById(R.id.clProfile);
        clActivity.setOnClickListener(this);
        clOverview.setOnClickListener(this);
        clBudget.setOnClickListener(this);
        clProfile.setOnClickListener(this);
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

    private void initButtons(){
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.clActivity:
                setColors(0);
                break;
            case R.id.clOverview:
                setColors(1);
                break;
            case R.id.clBudget:
                setColors(2);
                break;
            case R.id.clProfile:
                setColors(3);
                break;
            case R.id.btnAdd:
                Toast.makeText(this,"Add expenses", Toast.LENGTH_SHORT).show();
        }
    }

    public void setColors(int number){
        String active = "#31d19e";
        String inActive = "#979797";
        for (int i = 0; i < textViews.size(); i++){
            if (i == number){
                textViews.get(i).setTextColor(Color.parseColor(active));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageViews.get(i).setImageTintList(ColorStateList.valueOf(Color.parseColor(active)));
                }else {
                    ViewCompat.setBackgroundTintList(imageViews.get(i), ColorStateList.valueOf(Color.parseColor(active)));
                }
            }
            else {
                textViews.get(i).setTextColor(Color.parseColor(inActive));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageViews.get(i).setImageTintList(ColorStateList.valueOf(Color.parseColor(inActive)));
                }else {
                    ViewCompat.setBackgroundTintList(imageViews.get(i), ColorStateList.valueOf(Color.parseColor(inActive)));
                }
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
