package com.spendster.presentation.addExpenses;

import com.spendster.data.entity.Expense;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIPostExpenses {
    @Headers({"Content-Type: application/json", "Authorization: 1234"})
    @POST("expenses/save")
    Single<Expense> save(@Body Expense expense);
}
