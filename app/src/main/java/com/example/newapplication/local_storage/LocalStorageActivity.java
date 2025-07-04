package com.example.newapplication.local_storage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newapplication.R;

public class LocalStorageActivity extends AppCompatActivity {
    EditText editTextName, editTextAge;
    Button buttonSave;

    TextView textViewResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_storage);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        buttonSave = findViewById(R.id.buttonSave);
        textViewResult = findViewById(R.id.textViewResult);

        fetchSharedPrerenceData();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String age = editTextAge.getText().toString();

                if (name.isEmpty()) {
                    editTextName.setError("Enter your name");
                } else if (age.isEmpty()) {
                    editTextAge.setError("Enter your age");
                } else {
                    int convertedAge = Integer.parseInt(age);
                    saveDataInSharedPreference(name, convertedAge);
                }
            }
        });
    }

    private void fetchSharedPrerenceData() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPref", MODE_PRIVATE);
        String savedName = sharedPreferences.getString("user_name", "");
        int savedAge = sharedPreferences.getInt("user_age", 0);

        Log.i("TAG", "fetchSharedPrerenceData: save name " + savedName);
        Log.i("TAG", "fetchSharedPrerenceData: save age" + savedAge);

        if (!savedName.isEmpty() && savedAge != 0) {
            textViewResult.setText("Saved name = " + savedName + " Saved Age = " + savedAge);
        }
    }

    /**
     * Method to save data in shared preference
     */
    private void saveDataInSharedPreference(String name, int age) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("user_name", name);
        editor.putInt("user_age", age);

        editor.apply();

        fetchSharedPrerenceData();
    }
}
