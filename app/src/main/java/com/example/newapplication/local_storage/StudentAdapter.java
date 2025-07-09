package com.example.newapplication.local_storage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.newapplication.R;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private ArrayList<Student> studentArrayList;

    public StudentAdapter(@NonNull Context context, ArrayList<Student> studentArrayList) {
        super(context, R.layout.item_student, studentArrayList);
        this.studentArrayList = studentArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);

        TextView textViewId = view.findViewById(R.id.textViewStudentId);
        TextView textViewFullName = view.findViewById(R.id.textViewStudentFullName);
        TextView textViewSubject = view.findViewById(R.id.textViewStudentSubject);

        textViewId.setText(String.valueOf(studentArrayList.get(position).getId()));
        textViewFullName.setText(studentArrayList.get(position).getFullName());
        textViewSubject.setText(studentArrayList.get(position).getSubject());

        return view;
    }
}
