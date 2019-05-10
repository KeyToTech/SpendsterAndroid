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

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryViewHolder> {

    private Context context;
    private List<Category> categories;
    private OnCategoryClickListener onCategoryClickListener;

    public CategoryRecyclerViewAdapter(Context context, List<Category> categories, OnCategoryClickListener onCategoryClickListener) {
        this.context = context;
        this.categories = categories;
        this.onCategoryClickListener = onCategoryClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.category, viewGroup, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        categoryViewHolder.bind(categories.get(i), onCategoryClickListener);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        int size;
        if (categories == null){
            size = 0;
        }else {
            size = categories.size();
        }
        return size;
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
        public void bind(final Category item, final OnCategoryClickListener onCategoryClickListener){
            categoryTitle.setText(item.getNameOfCategory());
            categoryIcon.setImageResource(item.getIcon());
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    onCategoryClickListener.onCategoryClick(item);
                }
            });
        }
    }




}
