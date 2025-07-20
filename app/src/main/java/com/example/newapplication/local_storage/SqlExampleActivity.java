package com.example.newapplication.local_storage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newapplication.R;

import java.util.ArrayList;

public class SqlExampleActivity extends AppCompatActivity {
    EditText editTextName, editTextSubject;
    Button buttonSubmit, buttonUpdate;
    ListView listView;

    private DatabaseHelper databaseHelper;
    private ArrayList<Student> studentArrayList;
    private StudentAdapter studentAdapter;

    private int savedStudentId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_example);

        editTextName = findViewById(R.id.editTextName);
        editTextSubject = findViewById(R.id.editTextSubject);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        listView = findViewById(R.id.listView);

        databaseHelper = new DatabaseHelper(SqlExampleActivity.this);

        fetchSavedData();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = editTextName.getText().toString();
                String subject = editTextSubject.getText().toString();

                if (fullName.isEmpty()) {
                    editTextName.setError("Enter your name");
                } else if (subject.isEmpty()) {
                    editTextSubject.setError("Enter your subject");
                } else {
                    saveDataInDatabase(fullName, subject);
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = studentArrayList.get(position);

                editTextName.setText(student.getFullName());
                editTextSubject.setText(student.getSubject());

                savedStudentId = student.getId();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = editTextName.getText().toString();
                String subject = editTextSubject.getText().toString();

                if (fullName.isEmpty()) {
                    editTextName.setError("Enter your name");
                } else if (subject.isEmpty()) {
                    editTextSubject.setError("Enter your subject");
                } else {
                    updateData(fullName, subject, savedStudentId);
                }
            }
        });
    }

    private void updateData(String fullName, String subject, int savedStudentId) {
        Student student = new Student();
        student.setId(savedStudentId);
        student.setFullName(fullName);
        student.setSubject(subject);

        int rowId = databaseHelper.updateStudent(student);
        if (rowId != -1) {
            editTextName.setText("");
            editTextSubject.setText("");

            fetchSavedData();
        }
    }

    private void fetchSavedData() {
        Log.i("TAG", "fetchSavedData: fetch data called ");

        Log.w("TAG", "fetchSavedData: ");

//        Log.e("TAG", "fetchSavedData: ", new NullPointerException());

        studentArrayList = databaseHelper.getAllData();
        studentAdapter = new StudentAdapter(SqlExampleActivity.this, studentArrayList);
        listView.setAdapter(studentAdapter);
    }

    private void saveDataInDatabase(String fullName, String subject) {
        Student studentModel = new Student();
        studentModel.setFullName(fullName);
        studentModel.setSubject(subject);

        long rowId = databaseHelper.insert(studentModel);

        /**
         * insert method returns long as an response
         * if failed to save data in sqlite it return value -1
         */
        if (rowId != -1) {
            editTextName.setText("");
            editTextSubject.setText("");

            /**
             * show studentArrayList data in listview using custom listview adapter
             */
            studentArrayList = databaseHelper.getAllData();

            Log.i("TAG", "saveDataInDatabase: saved data = "
                    + studentArrayList);

            studentAdapter = new StudentAdapter(SqlExampleActivity.this, studentArrayList);
            listView.setAdapter(studentAdapter);

        } else {
            Toast.makeText(this, "Error inserting data in database",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
