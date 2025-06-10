package com.example.newapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChildActivity extends AppCompatActivity {
    Button buttonSendData;

    EditText editTextName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        editTextName = findViewById(R.id.editTextName);
        buttonSendData = findViewById(R.id.buttonSendData);

        buttonSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // To fetch the text from edittext
                String name = editTextName.getText().toString();

                if (name.isEmpty()) {
                    editTextName.setError("Enter your name");
                } else {
                    /**
                     * Pass the name back to the parent activity
                     * Create a simple return intent: since parent activity is alive we don't need to redirect to parent activity
                     * To set the data, we use putExtra() method & it can be of multiple datatypes.
                     * setResult: sets the result and pass the data to the parent activity
                     * finish(): It closes the current activity
                     */
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("resultName", name);
                    setResult(Activity.RESULT_CANCELED, returnIntent);
                    finish();

                    /**
                     * To compose failed result, you set result as RESULT_CANCELED
                     * In-case of failed result, data pass is optional
                     */
//                    Intent returnIntent = new Intent();
//                    setResult(Activity.RESULT_CANCELED, returnIntent);
//                    finish();
                }
            }
        });
    }
}
