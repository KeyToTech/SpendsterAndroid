package com.spendster.presentation.homeScreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spendster.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityFragment extends Fragment {

    private List<Fragment> pageFragments;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    public static ActivityFragment newInstance(){
        ActivityFragment activityFragment = new ActivityFragment();
        return activityFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity, container, false);
        viewPager = view.findViewById(R.id.view_pager_main);
        tabLayout = view.findViewById(R.id.sliding_tabs);
        initPageFragments();
        initViewPager();
        return view;
    }

    private void initPageFragments(){
        final String[] months = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        final String year = "2019";
        pageFragments = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            pageFragments.add(DashboardPageFragment.newInstance(R.layout.activity_home_slide1, months[i], year));
        }
    }

    private void initViewPager() {
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getChildFragmentManager(), pageFragments);
        viewPager.setAdapter(mainPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        tabLayout.setupWithViewPager(viewPager);
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
