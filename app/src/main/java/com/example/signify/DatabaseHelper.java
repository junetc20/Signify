package com.example.signify;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key, firstName text, lastName text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    // inserting in database
    public boolean insert(String emailAdd, String firstName, String lastName, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", emailAdd);
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        contentValues.put("password", password);
        long res = db.insert("user", null, contentValues);
        return res != -1;
    }

    public Boolean updateUserData(String emailAdd, String firstName, String lastName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        Cursor cursor = db.rawQuery("Select * from user where email = ?", new String[] {emailAdd});
        if(cursor.getCount()>0) {
            long res = db.update("user", contentValues, "email=?", new String[]{emailAdd});
            if (res == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public Boolean deleteUserData(String emailAdd, String firstName, String lastName, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email = ?", new String[] {emailAdd});
        if(cursor.getCount()>0) {
            long res = db.delete("user", "email=?", new String[]{emailAdd});
            return res != -1;
        } else {
            return false;
        }
    }

    public Cursor getUserData(String emailAdd, String firstName, String lastName, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from user", null);
        return cursor;
    }

    // Check if email exists already
    public Boolean checkEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{email});
        return cursor.getCount() <= 0;
    }
    // Check email and password input at login screen
    public boolean checkLoginDetails(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?", new String[]{email, password});
        if (cursor.getCount()>0) {
            return true;
        }
        else {
            return false;
        }
    }
}
