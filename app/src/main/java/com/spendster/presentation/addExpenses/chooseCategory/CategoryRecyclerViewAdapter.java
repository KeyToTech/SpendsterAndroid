package com.spendster.presentation.addExpenses.chooseCategory;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.spendster.BuildConfig;
import com.spendster.R;
import com.spendster.data.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryViewHolder> {

    private final Context context;
    private List<Category> categories;
    private final OnCategoryClickListener onCategoryClickListener;

    public CategoryRecyclerViewAdapter(Context context, List<Category> categories, OnCategoryClickListener onCategoryClickListener) {
        this.context = context;
        this.categories = categories;
        this.onCategoryClickListener = onCategoryClickListener;
    }

    public CategoryRecyclerViewAdapter(Context context, OnCategoryClickListener onCategoryClickListener) {
        this(context, new ArrayList<Category>(), onCategoryClickListener);
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.category, viewGroup, false);
        final CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCategoryClickListener.onCategoryClick(categories.get(categoryViewHolder.getLayoutPosition()));
            }
        });
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.bind(categories.get(i));
    }

    @Override
    public int getItemCount() {
        int size;
        if (categories == null) {
            size = 0;
        } else {
            size = categories.size();
        }
        return size;
    }

    public void bind(List<Category> categories) {
        this.categories = categories;
        if (categories == null) {
            Log.d(BuildConfig.MY_LOGS, "Categories equal to null");
        }
        notifyItemRangeInserted(0, getItemCount());
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTitle;
        ImageView categoryIcon;
        CardView cardView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.categoryTitle);
            categoryIcon = itemView.findViewById(R.id.categoryIcon);
            cardView = itemView.findViewById(R.id.cvCategory);
        }

        public void bind(final Category item) {
            categoryTitle.setText(item.getName());
            categoryIcon.setImageURI(Uri.parse(item.getIcon()));
        }
    }
}
