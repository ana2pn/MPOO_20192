package com.example.pizza.pizza.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pizza.R;

public class RecyclerViewPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_pizza);
        getSupportActionBar().hide();

    }
}
