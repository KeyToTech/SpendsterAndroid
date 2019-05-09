package com.spendster.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.spendster.R;

import java.util.List;

public class ChooseCategoryActivity extends AppCompatActivity {

    private List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
    }
}
