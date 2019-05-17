package com.spendster.presentation.homeScreen.Dashboard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.spendster.R;
import com.spendster.data.entity.Expense;
import com.spendster.presentation.utils.DayComparator;
import com.spendster.presentation.utils.SDate;

import java.util.Date;

public class HeaderViewHolder extends RecyclerView.ViewHolder {
    private TextView headerTitle;
    private static final String TODAY = "Today";
    private static final String YESTERDAY = "Yesterday";

    public HeaderViewHolder(View itemView) {
        super(itemView);
        headerTitle = itemView.findViewById(R.id.header_id);
    }

    public void bind(Expense expense){
        Date date = new Date(expense.getCreatedDate());
        DayComparator dayComparator = new DayComparator(date);
        if (dayComparator.isToday()){
            headerTitle.setText(TODAY);
        } else if (dayComparator.isYesterday()){
            headerTitle.setText(YESTERDAY);
        } else {
            headerTitle.setText(new SDate(date).dateFormatted());
        }
    }
}