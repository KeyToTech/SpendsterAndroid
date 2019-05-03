package com.spendster.presentation.homeScreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spendster.R;

public class BudgetFragment extends Fragment {

    public static BudgetFragment newInstance(){
        BudgetFragment budgetFragment = new BudgetFragment();
        return budgetFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.budget_fragment, container, false);
    }
}
