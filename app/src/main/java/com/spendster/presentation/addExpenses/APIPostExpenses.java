package com.spendster.presentation.addExpenses;

import com.spendster.data.entity.Expense;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIPostExpenses {
    @Headers({"Content-Type: application/json"})
    @POST("expenses/save")
    Single<Expense> save(@Header("Authorization") String token, @Body Expense expense);
}
