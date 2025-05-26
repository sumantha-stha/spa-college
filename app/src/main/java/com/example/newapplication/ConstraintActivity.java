package com.example.newapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ConstraintActivity extends AppCompatActivity {
    TextView textViewCenter, textViewTop, textViewLeft, textViewBottom, textViewRight;

    String name ;

    Button buttonClick;

    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        textViewCenter = findViewById(R.id.textViewCenter);
        textViewTop = findViewById(R.id.textViewTop);
        buttonClick = findViewById(R.id.buttonClick);
        textViewLeft = findViewById(R.id.textViewLeft);
        textViewBottom = findViewById(R.id.textViewBottom);

        textViewCenter.setText("Center Text");
        textViewTop.setText("Top Text");

        editText = findViewById(R.id.editTextName);

        name = "Mobile Programming class";

        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ConstraintActivity.this, "Button Clicked",
                        Toast.LENGTH_LONG).show();

                textViewLeft.setText("Left Text");
                textViewBottom.setText("Bottom Text");
            }
        });

        buttonClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String editTextText = editText.getText().toString();
                Toast.makeText(ConstraintActivity.this, editTextText, Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
