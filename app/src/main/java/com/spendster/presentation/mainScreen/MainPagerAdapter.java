package com.spendster.presentation.mainScreen;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.spendster.presentation.welcomeScreen.ViewPagerAdapter;

import java.util.List;

public class MainPagerAdapter extends ViewPagerAdapter {
    private List<Fragment> pageFragments;

    public MainPagerAdapter(FragmentManager fm, List<Fragment> pageFragments) {
        super(fm, pageFragments);
        this.pageFragments = pageFragments;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Title " + (position + 1);
    }
}
