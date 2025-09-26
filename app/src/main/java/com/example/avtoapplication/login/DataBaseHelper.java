package com.example.avtoapplication.login;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;






import org.jetbrains.annotations.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "user_record.db";
    public static final String TABLE_NAME = "user_data";
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

    public DataBaseHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EMAIL + " TEXT, " + PASSWORD + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // метод регистрации
    public boolean registerUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EMAIL, email);
        values.put(PASSWORD, password);

        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result != -1; // озвращает  -1 если будит ошибка


    }

    // метод проверяет уникальность email
    public boolean checkEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_NAME + " WHERE email = ?", new
                String[]{email});

        return cursor.getCount() > 0;
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_NAME + " WHERE email = ? AND " +
                PASSWORD + " = ?", new String[]{email, password});

        return cursor.getCount() > 0;
    }
}
