package com.spendster.presentation.welcomeScreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> slideFragments;

    public ViewPagerAdapter(FragmentManager fragmentManager, List<Fragment> slideFragments) {
        super(fragmentManager);
        this.slideFragments = slideFragments;
    }

    @Override
    public int getCount() {
        int result = 0;
        if (this.slideFragments != null){
            result = this.slideFragments.size();
        }
        return result;
    }

    @Override
    public Fragment getItem(int position) {
        return slideFragments.get(position);
    }
}
