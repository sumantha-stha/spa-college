package com.example.newapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * extends AppCompatActivity to Make Java class an Activity
 * every activity must be declared in Manifest file
 *
 */
public class MainActivity extends AppCompatActivity {

    // Create Object on widget, widget should be same as on layout:
    // i.e. if used TextView in layout, you should use TextView in activity as well otherwise it will show error.
    TextView textViewExample;

    EditText editTextUserName, editTextPassword;
    Button buttonRandom, buttonNextScreen;
    Spinner spinnerCourses;

    String selectedCourse = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //To set layout in activity class
        setContentView(R.layout.example_constraintlayout);

        // findViewById: Bind the widget object created inside java class and layout
        // while binding id should always match from the layout id
        // every widget used in activity class should be bind (findViewById)
        textViewExample = findViewById(R.id.textViewExample);
        textViewExample.setText("This is example JAVA");

        editTextUserName = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonNextScreen = findViewById(R.id.buttonNextScreen);

        /**
         * ClickListener Event for an Button click
         * Every click is registered/Listen in onClick(View v)
         * So, action after button click is done in onClick override method
         */
        buttonNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Context, New Activity Class
                /**
                 * To open new activity we need Intent.
                 * Intent needs 1. context: currentActivity.this, 2. New Activity class
                 * startActivity: starts the new activity which is state on the intent
                 */

                /**
                 * To parse the data, we use intent
                 * we set data in intent using .putExtra()
                 * data is set using key value method
                 * while fetching data from another activity, same key should be used
                 */
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("myName", "Suman Tha Shrestha");
                intent.putExtra("isAvailable", true);
                startActivity(intent);
            }
        });

        /**
         * Spinner: should be provided data/ arraylist through array adapter
         * android.R.layout.simple_spinner_item : default layout provided by android
         * spinner needs to adapter, which is set by .setAdapter(adapter)
         */
        spinnerCourses = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                MainActivity.this, R.array.Courses, android.R.layout.simple_spinner_item);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCourses.setAdapter(arrayAdapter);


        /**
         * Spinner ItemSelectListener: when user select item from dropdown onItemSelected method is triggered
         * Position: it provided the current position of provided array-list i.e. 0, 1, 2
         * To extract value of selected item: parent.getItemAtPosition(position).toString()
         *
         */
        spinnerCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("TAG", "onItemSelected: position " + position);

                selectedCourse = parent.getItemAtPosition(position).toString();
                Log.i("TAG", "onItemSelected: selected Item " + selectedCourse);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        buttonRandom = findViewById(R.id.buttonClickMe);
        buttonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * to get string from editText: editText.getText().toString();
                 */
                String username = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                if (username.isEmpty()) {
                    editTextUserName.setError("Please enter your username");
                } else if (password.isEmpty()) {
                    editTextPassword.setError("Please enter your password");
                } else if (selectedCourse.isEmpty() || selectedCourse.equals("Select the courses")) {
                    Toast.makeText(MainActivity.this, "Please select your course", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Validation Successful....",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}