package com.spendster.presentation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> slideFragments;

    public ViewPagerAdapter(FragmentManager fragmentManager, ArrayList<Fragment> slideFragments) {
        super(fragmentManager);
        this.slideFragments = slideFragments;
    }

    @Override
    public int getCount() {
        return slideFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return slideFragments.get(position);
    }
}
