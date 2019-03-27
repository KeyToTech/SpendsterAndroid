package com.spendster.presentation.welcomeScreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> slideFragments;

    public ViewPagerAdapter(FragmentManager fragmentManager, List<Fragment> slideFragments) {
        super(fragmentManager);
        this.slideFragments = slideFragments;
    }

    @Override
    public int getCount() {
        if (this.slideFragments == null){
            return 0;
        }
        return slideFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return slideFragments.get(position);
    }
}
