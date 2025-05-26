package com.example.newapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_layout);

        /**
         * To fetch the sent data: we use getIntent() method
         */
        Intent intent = getIntent();
        String name = intent.getStringExtra("myName");
        boolean isAvailable = intent.getBooleanExtra("isAvailable",false);

        Log.i("TAG", "onCreate: myName "+name +"isAvailable "+isAvailable);
    }
}
