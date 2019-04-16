package com.spendster.presentation.mainScreen;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MainPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> pageFragments;

    public MainPagerAdapter(FragmentManager fm, List<Fragment> pageFragments) {
        super(fm);
        this.pageFragments = pageFragments;
    }

    @Override
    public Fragment getItem(int position) { return pageFragments.get(position); }

    @Override
    public int getCount() {
        int result = 0;
        if (this.pageFragments != null) {
            result = this.pageFragments.size();
        }
        return result;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Title " + (position + 1);
    }
}
