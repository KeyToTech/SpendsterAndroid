package com.spendster.presentation.addExpenses.chooseCategory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.spendster.R;
import com.spendster.data.entity.Category;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CategoryViewHolder> {

    private Context context;
    private List<Category> categories;
    private OnItemClickListener onItemClickListener;

    public RecyclerViewAdapter(Context context, List<Category> categories, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.categories = categories;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.category, viewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.bind(categories.get(i), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView categoryTitle;
        ImageView categoryIcon;
        CardView cardView;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.categoryTitle);
            categoryIcon = itemView.findViewById(R.id.categoryIcon);
            cardView = itemView.findViewById(R.id.cvCategory);
        }
        public void bind(final Category item, final OnItemClickListener onItemClickListener){
            categoryTitle.setText(item.getNameOfCategory());
            categoryIcon.setImageResource(item.getIcon());
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(item);
                }
            });
        }
    }




}
