package com.spendster.presentation.welcomeScreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SlideLayuot extends Fragment {
    private int slide;

    public static SlideLayuot newInstance(int slide){
        SlideLayuot slideLayuot = new SlideLayuot();
        slideLayuot.slide = slide;
        return slideLayuot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(this.slide , container, false);
    }
}
