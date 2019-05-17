package com.spendster.presentation.homeScreen.Dashboard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.spendster.R;

public class ExpenseViewHolder extends RecyclerView.ViewHolder{
    private ImageView expenseIcon;
    private TextView expenseTitle;
    private TextView expenseNote;
    private TextView expenseAmount;

    public ExpenseViewHolder(View itemView) {
        super(itemView);
        expenseIcon = itemView.findViewById(R.id.expenseIcon);
        expenseTitle = itemView.findViewById(R.id.expenseTitle);
        expenseNote = itemView.findViewById(R.id.expenseNote);
        expenseAmount = itemView.findViewById(R.id.expenseAmount);
    }
}
