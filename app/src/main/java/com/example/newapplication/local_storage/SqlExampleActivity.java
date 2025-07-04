package com.example.newapplication.local_storage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newapplication.R;

public class SqlExampleActivity extends AppCompatActivity {
    EditText editTextName, editTextSubject;
    Button buttonSubmit;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_example);

        editTextName = findViewById(R.id.editTextName);
        editTextSubject = findViewById(R.id.editTextSubject);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        listView = findViewById(R.id.listView);
    }
}
