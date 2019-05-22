package com.spendster.presentation.homeScreen.Dashboard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.spendster.R;
import com.spendster.data.entity.Expense;

import androidx.recyclerview.widget.RecyclerView;

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

    public void bind(Expense expense){
        expenseAmount.setText(Double.toString(expense.getAmount()));
        expenseNote.setText(expense.getNote());
    }
}
