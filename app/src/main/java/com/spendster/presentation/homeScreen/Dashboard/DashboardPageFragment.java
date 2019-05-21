package com.spendster.presentation.homeScreen.Dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class DashboardPageFragment extends Fragment {
    private int slide;
    private String month;
    private String year;

    public static DashboardPageFragment newInstance(int slide, String month, String year) {
        DashboardPageFragment dashboardPageFragment = new DashboardPageFragment();
        dashboardPageFragment.slide = slide;
        dashboardPageFragment.month = month;
        dashboardPageFragment.year = year;
        return dashboardPageFragment;
    }

    @Override
    public String toString() {
        return month + " " + year;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(this.slide, container, false);
    }
}

