package com.spendster.presentation.welcomeScreen;


import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

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
