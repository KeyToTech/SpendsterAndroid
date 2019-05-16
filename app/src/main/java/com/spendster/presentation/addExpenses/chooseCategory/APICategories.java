package com.spendster.presentation.addExpenses.chooseCategory;

import com.spendster.data.entity.Category;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APICategories {
    @Headers({"Content-Type: application/json", "Authorization: 1234"})
    @GET("categories")
    Single<List<Category>> getCategories();
}
