package com.spendster.presentation.welcomeScreen;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.spendster.R;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Button btnSkip, btnNext;
    private Button btnSignUp, btnLogin;
    private List<Fragment> slideFragments;
    private ImageView[] dots;
    private View dotsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initUI();
    }

    private void initViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), slideFragments);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
    }

    private void initUI() {
        viewPager = findViewById(R.id.view_pager);
        btnSkip = findViewById(R.id.btnSkip);
        btnNext = findViewById(R.id.btnNext);
        dotsLayout = findViewById(R.id.bottom_nav_dots);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);
        initSlideFragments();
        initBottomNavDots();
        selectActivePageDot(0);
        initViewPager();
        initSkipNextButtons();
    }

    private void initSkipNextButtons() {
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
                if (current < slideFragments.size()) {
                    viewPager.setCurrentItem(current);
                } else {
                    launchThirdScreen();
                }
            }
        });
    }

    private void initSlideFragments(){
        slideFragments = new ArrayList<>();
        slideFragments.add(SlideLayuot.newInstance(R.layout.welcome_slide_1));
        slideFragments.add(SlideLayuot.newInstance(R.layout.welcome_slide_2));
        slideFragments.add(SlideLayuot.newInstance(R.layout.welcome_slide_3));
    }

    private void initBottomNavDots() {
        dots = new ImageView[slideFragments.size()];
        dots[0] = dotsLayout.findViewById(R.id.bottom_nav_dot_1);
        dots[1] = dotsLayout.findViewById(R.id.bottom_nav_dot_2);
        dots[2] = dotsLayout.findViewById(R.id.bottom_nav_dot_3);
    }

    private void selectActivePageDot(int currentPage) {
        for (int i = 0; i < slideFragments.size(); i++){
            if(currentPage == i){
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
            int skipNextVisibility;
            int loginSignUpVisibility;
            if (isLastSlide(position)) {
                skipNextVisibility = View.GONE;
                loginSignUpVisibility = View.VISIBLE;
            } else {
                skipNextVisibility = View.VISIBLE;
                loginSignUpVisibility = View.GONE;
            }
            btnNext.setVisibility(skipNextVisibility);
            btnSkip.setVisibility(skipNextVisibility);
            btnSignUp.setVisibility(loginSignUpVisibility);
            btnLogin.setVisibility(loginSignUpVisibility);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) { }

        @Override
        public void onPageScrollStateChanged(int arg0) { }
    };

    private boolean isLastSlide(int position) {
        return position == slideFragments.size() - 1;
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void launchThirdScreen() {
        viewPager.setCurrentItem(2);
    }
}
