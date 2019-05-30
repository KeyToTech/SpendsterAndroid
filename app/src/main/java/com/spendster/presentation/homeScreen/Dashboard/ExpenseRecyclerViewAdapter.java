package com.spendster.presentation.homeScreen.Dashboard;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spendster.R;
import com.spendster.data.entity.Expense;
import com.spendster.presentation.utils.DayComparator;
import com.zhukic.sectionedrecyclerview.SectionedRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseRecyclerViewAdapter extends
        SectionedRecyclerViewAdapter<HeaderViewHolder, ExpenseViewHolder> {
    private List<Expense> expenses;
    private final OnExpenseClickListener onExpenseClickListener;
    private static final String LOG = "Expenses";

    public ExpenseRecyclerViewAdapter(List<Expense> expenses, OnExpenseClickListener onExpenseClickListener) {
        this.expenses = expenses;
        this.onExpenseClickListener = onExpenseClickListener;
    }

    public ExpenseRecyclerViewAdapter(OnExpenseClickListener onExpenseClickListener) {
        this(new ArrayList<>(), onExpenseClickListener);
    }

    @Override
    public ExpenseViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        final ExpenseViewHolder expenseViewHolder = new ExpenseViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_layout, parent, false));
        expenseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onExpenseClickListener.onExpenseClick(expenses.get(expenseViewHolder.getLayoutPosition()));
            }
        });
        return expenseViewHolder;
    }

    @Override
    public HeaderViewHolder onCreateSubheaderViewHolder(ViewGroup parent, int viewType) {
        return new HeaderViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.header_layout, parent, false));
    }

    @Override
    public void onBindItemViewHolder(ExpenseViewHolder holder, int itemPosition) {
        holder.bind(expenses.get(itemPosition));
    }

    @Override
    public void onBindSubheaderViewHolder(HeaderViewHolder subheaderHolder, int nextItemPosition) {
        subheaderHolder.bind(expenses.get(nextItemPosition));
    }


    @Override
    public int getItemSize() {
        int size;
        if (this.expenses == null) {
            size = 0;
        } else {
            size = this.expenses.size();
        }
        return size;
    }


    @Override
    public boolean onPlaceSubheaderBetweenItems(int position) {
        final int expenseDate = new DayComparator(new Date(expenses.get(position).getCreatedDate())).day();
        final int nextExpenseDate = new DayComparator(new Date(expenses.get(position + 1).getCreatedDate())).day();
        return expenseDate != nextExpenseDate;
    }



    public void bind(List<Expense> expenses) {
        this.expenses = expenses;
        if (expenses == null) {
            Log.d(LOG, "Expenses equal to null");
        }
        notifyDataChanged();
    }
}
