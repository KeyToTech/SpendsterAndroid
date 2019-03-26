package com.spendster.presentation;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.spendster.R;

public class WelcomeActivity extends AppCompatActivity {

    private static int FRAGMENT_AMOUNT = 3;
    private ViewPager viewPager;
    private Button btnSkip, btnNext;
    private Button btnSignUp, btnLogin;
    private ImageView[] dots;
    private View dotsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        viewPager = findViewById(R.id.view_pager);
        btnSkip = findViewById(R.id.btnSkip);
        btnNext = findViewById(R.id.btnNext);
        dotsLayout = findViewById(R.id.bottom_nav_dots);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);

        initBottomNavDots();
        selectActivePageDot(0);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchThirdScreen();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = getItem(1);
                if (current < FRAGMENT_AMOUNT) {
                    viewPager.setCurrentItem(current);
                } else {
                    launchThirdScreen();
                }
            }
        });
    }

    private void initBottomNavDots() {
        dots = new ImageView[FRAGMENT_AMOUNT];
        dots[0] = dotsLayout.findViewById(R.id.bottom_nav_dot_1);
        dots[1] = dotsLayout.findViewById(R.id.bottom_nav_dot_2);
        dots[2] = dotsLayout.findViewById(R.id.bottom_nav_dot_3);
    }

    private void selectActivePageDot(int currentPage) {
        for (int i = 0; i < FRAGMENT_AMOUNT; i++){
            if(i == currentPage){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.selected_dot));
            }
            else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dot));
            }
        }
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            selectActivePageDot(position);
            if (position == 3 - 1) {
                btnNext.setVisibility(View.GONE);
                btnSkip.setVisibility(View.GONE);
                btnSignUp.setVisibility(View.VISIBLE);
                btnLogin.setVisibility(View.VISIBLE);

            } else {
                btnNext.setVisibility(View.VISIBLE);
                btnSkip.setVisibility(View.VISIBLE);
                btnSignUp.setVisibility(View.GONE);
                btnLogin.setVisibility(View.GONE);
            }

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) { }

        @Override
        public void onPageScrollStateChanged(int arg0) { }
    };

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void launchThirdScreen() {
        viewPager.setCurrentItem(2);
    }
}
