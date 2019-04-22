package com.spendster.presentation.homeScreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PageFragment extends Fragment {
    private int slide;
    private String month;
    private String year;

    public static PageFragment newInstance(int slide, String month, String year) {
        PageFragment pageFragment = new PageFragment();
        pageFragment.slide = slide;
        pageFragment.month = month;
        pageFragment.year = year;
        return pageFragment;
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

