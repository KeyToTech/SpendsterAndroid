package com.spendster.presentation.homeScreen.Dashboard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.spendster.R;

public class HeaderViewHolder extends RecyclerView.ViewHolder {
    private TextView headerTitle;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        headerTitle = itemView.findViewById(R.id.header_id);
    }
}