package com.spendster.presentation.mainScreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spendster.R;
import com.spendster.presentation.welcomeScreen.SlideFragment;

import java.util.ArrayList;
import java.util.List;

public class ActivityFragment extends Fragment {

    private List<Fragment> pageFragments;
    private ViewPager viewPager;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity, container, false);

        viewPager = view.findViewById(R.id.view_pager_main);
        initPageFragments();
        initViewPager();
        return view;
    }

    private void initPageFragments(){
        pageFragments = new ArrayList<>();
        pageFragments.add(SlideFragment.newInstance(R.layout.activity_home_slide1));
        pageFragments.add(SlideFragment.newInstance(R.layout.activity_home_slide1));
        pageFragments.add(SlideFragment.newInstance(R.layout.activity_home_slide1));
    }

    private void initViewPager() {
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getChildFragmentManager(), pageFragments);
        viewPager.setAdapter(mainPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
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
