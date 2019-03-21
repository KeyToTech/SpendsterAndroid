package com.spendster.presentation;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.spendster.R;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private int[] layouts;
    private Button btnSkip, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        btnSkip = (Button) findViewById(R.id.btnSkip);
        btnNext = (Button) findViewById(R.id.btnNext);

        layouts = new int[]{
                R.layout.slide1,
                R.layout.slide2,
                R.layout.slide3};

        myViewPagerAdapter = new MyViewPagerAdapter(layouts, this);
        viewPager.setAdapter(myViewPagerAdapter);

    }

}
