package com.spendster.presentation.homeScreen.Dashboard;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spendster.R;
import com.spendster.data.entity.Expense;

import java.util.List;

public class DashboardFragment extends Fragment implements DashboardView {

    private ExpenseRecyclerViewAdapter expenseRecyclerViewAdapter;

    public static DashboardFragment newInstance(){
        return new DashboardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard_fragment, container, false);
        initRecyclerView(view);
        new DashboardPresenter(this, new MockedDashboardModel()).fetchExpenses();
        return view;
    }

    private void initRecyclerView(View view){
        RecyclerView recyclerView = view.findViewById(R.id.expensesRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setHasFixedSize(true);
        this.expenseRecyclerViewAdapter = new ExpenseRecyclerViewAdapter();
        recyclerView.setAdapter(this.expenseRecyclerViewAdapter);
    }

    @Override
    public void bindExpenses(List<Expense> expenses) {
        this.expenseRecyclerViewAdapter.bind(expenses);
    }
}
