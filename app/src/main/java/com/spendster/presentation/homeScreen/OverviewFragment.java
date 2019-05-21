package com.spendster.presentation.homeScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spendster.R;

import androidx.fragment.app.Fragment;

public class OverviewFragment extends Fragment {

    public static OverviewFragment newInstance(){
        OverviewFragment overviewFragment = new OverviewFragment();
        return overviewFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.overview_fragment, null);
    }
}
