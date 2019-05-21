package com.spendster.presentation.homeScreen;


import com.spendster.presentation.welcomeScreen.ViewPagerAdapter;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainPagerAdapter extends ViewPagerAdapter {
    private List<Fragment> pageFragments;

    public MainPagerAdapter(FragmentManager fm, List<Fragment> pageFragments) {
        super(fm, pageFragments);
        this.pageFragments = pageFragments;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  pageFragments.get(position).toString();
    }
}
