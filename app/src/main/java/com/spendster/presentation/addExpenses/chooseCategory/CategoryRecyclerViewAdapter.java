package com.spendster.presentation.addExpenses.chooseCategory;

import android.content.Context;
import android.net.Uri;
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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        private TextView tvCategoryTitle;
        private ImageView imCategoryIcon;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategoryTitle = itemView.findViewById(R.id.categoryTitle);
            imCategoryIcon = itemView.findViewById(R.id.categoryIcon);
        }

        public void bind(final Category item) {
            tvCategoryTitle.setText(item.getName());
            imCategoryIcon.setImageURI(Uri.parse(item.getIcon()));
        }
    }
}
