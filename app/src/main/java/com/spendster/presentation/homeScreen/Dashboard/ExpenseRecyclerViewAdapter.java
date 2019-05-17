package com.spendster.presentation.homeScreen.Dashboard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spendster.BuildConfig;
import com.spendster.R;
import com.spendster.data.entity.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private List<Expense> expenses;

    public ExpenseRecyclerViewAdapter(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public ExpenseRecyclerViewAdapter() {
        this(new ArrayList<Expense>());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder;
        if (i == TYPE_HEADER) {
            View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_layout,
                    viewGroup, false);
            viewHolder = new HeaderViewHolder(layoutView);
        } else  {
            View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.expense_layout,
                    viewGroup, false);
            viewHolder = new ExpenseViewHolder(layoutView);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Expense expense = this.expenses.get(i);
        if(viewHolder instanceof HeaderViewHolder){
            ((HeaderViewHolder) viewHolder).bind(expense);
        }else if(viewHolder instanceof ExpenseViewHolder){
            ((ExpenseViewHolder) viewHolder).bind(expense);
        }
    }

    @Override
    public int getItemCount() {
        int size;
        if (this.expenses == null) {
            size = 0;
        } else {
            size = this.expenses.size();
        }
        return size;
    }

    @Override
    public int getItemViewType(int position) {
        int type;
        if (this.isPositionHeader(position))
            type = TYPE_HEADER;
        else {
            type = TYPE_ITEM;
        }
        return type;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    public void bind(List<Expense> expenses) {
        this.expenses = expenses;
        if (expenses == null) {
            Log.d(BuildConfig.MY_LOGS, "Expenses equal to null");
        }
        notifyItemRangeInserted(0, getItemCount());
    }
}
