package com.example.avtoapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.ArrayList;
import java.util.Currency;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(@Nullable Context context) {
        super(context, Contacts.DATABASE_NAME, null, Contacts.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Contacts.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Contacts.TABLE_NAME); // Удаление таблицы если она существует
        onCreate(db); // заново передаем таблицу

    }

    // метод для заполнеия таблицы текущеми данными в базу данных

    public long insertContact(String image, String name, String phone, String email, String note, String addedtime, String updatedTime) {

        // установление соединение с базой данных
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues(); // перенос каждого элемента через этот опреатор
        contentValues.put(Contacts.C_IMAGE, image);
        contentValues.put(Contacts.C_NAME, name);
        contentValues.put(Contacts.C_PHONE, phone);
        contentValues.put(Contacts.C_EMAIL, email);
        contentValues.put(Contacts.C_NOTE, note);
        contentValues.put(Contacts.C_ADDED_TIME, addedtime);
        contentValues.put(Contacts.C_UPDATED_TIME, updatedTime);

        long id = db.insert(Contacts.TABLE_NAME, null, contentValues);
        db.close();
        return id;


    }
    // метод который получает все данные  в виде списка и возвращать список всех существующих контактов

    public ArrayList<ModelContact> getAllData() {

        ArrayList<ModelContact> arrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + Contacts.TABLE_NAME;

        SQLiteDatabase db = getReadableDatabase();
        // открываем соединение с базой данных через
        Cursor cursor = db.rawQuery(selectQuery, null);

// перемешенние к первому элементу если он есть  Исключение

// что выводится
        if (cursor.moveToFirst()) {
            do {
                ModelContact modelContact = new ModelContact(
                        "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_ID)),
                        "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_NAME)),
                        "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_IMAGE)),
                        "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_PHONE)),
                        "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_EMAIL)),
                        "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_NOTE)),
                        "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_ADDED_TIME)),
                        "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_UPDATED_TIME))


                );
                arrayList.add(modelContact);

            } while (cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }

    // метод добавление контактов

    public void updateContact(String id, String image, String name, String phone, String email, String note, String addedtime, String updatedTime) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Contacts.C_IMAGE, image);
        contentValues.put(Contacts.C_NAME, name);
        contentValues.put(Contacts.C_PHONE, phone);
        contentValues.put(Contacts.C_EMAIL, email);
        contentValues.put(Contacts.C_NOTE, note);
        contentValues.put(Contacts.C_ADDED_TIME, addedtime);
        contentValues.put(Contacts.C_UPDATED_TIME, updatedTime);

        db.update(Contacts.TABLE_NAME, contentValues, Contacts.C_ID + " = ?", new String[]{id}); // обновление  при условии что свой id по подет в свое поле
        db.close();
    }

    // метод удаление контакта из базы
    public void deleteContact(String id) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete(Contacts.TABLE_NAME, Contacts.C_ID + " = ?", new String[]{id});
        db.close();
    }
    // метод для удаления всеъх контактов
    public void deleteAllContacts(){
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("DELETE FROM " + Contacts.TABLE_NAME);
        db.close();



    }
}
