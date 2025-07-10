package com.example.newapplication.local_storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student.db";
    private static final int DATABASE_VERSION = 1;
    public static final String STUDENT_TABLE = "student";
    public static final String FULL_NAME = "full_name";
    public static final String SUBJECT = "subject";

    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE student ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "full_name Text, subject Text )";

    private static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS student";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);
    }

    /**
     * Insert data in sqlite database.
     * values are stored in content values in form of key value method
     */
    public long insert(Student student) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(FULL_NAME, student.getFullName());
        contentValues.put(SUBJECT, student.getSubject());

        return sqLiteDatabase.insert(STUDENT_TABLE, null, contentValues);
    }

    public ArrayList<Student> getAllData() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase
                .rawQuery("SELECT * FROM " + STUDENT_TABLE, null);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                Student student = new Student();

                student.setId(cursor.getInt(0));
                student.setFullName(cursor.getString(1));
                student.setSubject(cursor.getString(2));

                studentArrayList.add(student);
            }
        }
        cursor.close();
        return studentArrayList;
    }

    public int updateStudent(Student student) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(FULL_NAME, student.getFullName());
        contentValues.put(SUBJECT, student.getSubject());

        int rowId = sqLiteDatabase.update(STUDENT_TABLE, contentValues,
                "id=?", new String[]{String.valueOf(student.getId())});

        sqLiteDatabase.close();
        return rowId;
    }
}
