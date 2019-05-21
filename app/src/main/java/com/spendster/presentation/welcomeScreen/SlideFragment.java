package com.spendster.presentation.welcomeScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class SlideFragment extends Fragment {
    private int slide;

    public static SlideFragment newInstance(int slide){
        SlideFragment slideFragment = new SlideFragment();
        slideFragment.slide = slide;
        return slideFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(this.slide , container, false);
    }
}
