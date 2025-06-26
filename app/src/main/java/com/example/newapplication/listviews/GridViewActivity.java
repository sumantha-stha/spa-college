package com.example.newapplication.listviews;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newapplication.R;

public class GridViewActivity extends AppCompatActivity {
    private GridView gridView;

    private String[] data = {"MBBS", "MBA", "BBA", "BBS", "BIM", "BIT", "BCA", "BCIS", "B. Pharmacy"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = findViewById(R.id.gridView);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, data);
        gridView.setAdapter(arrayAdapter);
    }
}
