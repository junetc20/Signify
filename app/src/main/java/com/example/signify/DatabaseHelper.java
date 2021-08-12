package com.example.signify;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * A subclass of the SQLiteOpenHelper class.
 * It represents the SQLite database for the Signify app.
 *
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    /**
     * Create the SQLite database.
     * @param db the SQLiteDatabase.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key, firstName text, lastName text, password text)");
    }

    /**
     * Upgrade the SQLite database.
     * @param db the SQLiteDatabase.
     * @param oldVersion the number of the old version.
     * @param newVersion the number of the new version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    /**
     * Insert data into the SQLite database.
     * @return has data been inserted into the database?
     * @param emailAdd the user's email.
     * @param firstName the user's first name.
     * @param lastName the user's last name.
     * @param password the user's password.
     */
    public boolean insert(String emailAdd, String firstName, String lastName, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", emailAdd);
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        contentValues.put("password", password);
        long res = db.insert("user", null, contentValues);
        if(res == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Update data in the SQLite database.
     * @return has data been updated in the database?
     * @param emailAdd the user's email.
     */
    public Boolean updateUserData(String emailAdd, String firstName, String lastName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        contentValues.put("email", emailAdd);
        /* db.update("user", contentValues, "firstName=?", new String[]{originalFirstName});
        db.update("user", contentValues, "lastName=?", new String[]{originalLastName});
        db.update("user", contentValues, "email=?", new String[]{originalEmailAdd}); */
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{emailAdd});
        if (cursor.getCount() > 0) {
            long res = db.update("user", contentValues, "email=?", new String[]{emailAdd});
            return res > -1;
        } else {
            return false;
        }
    }

    /**
     * Delete user data from the SQLite database.
     * @return has data been deleted from the database?
     * @param password the user's password.
     */
  
    public Boolean updateUserPassword(String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("Select * from user where password=?", new String[]{password});
        if (cursor.getCount() > 0) {
            long res = db.update("user", contentValues, "password=?", new String[]{password});
            return res > -1;
        } else {
            return false;
        }
    }

    /**
     * Collect all user data from database.
     * @return all user data from cursor.
     */
    public Cursor getUserData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from user", null);
        return cursor;
    }

    /**
     * Collect user first name from database.
     * @return user first name from cursor.
     */
    public Cursor firstName() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select firstName from user", null);
        return cursor;
    }

    /**
     * Check if email exists in database.
     * @return does email already exist in database?
     * @param email the user's email.
     */
    public boolean checkEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{email});
        if (cursor.getCount() > 0) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Check if email and password exist in database.
     * @return does this user already exist in database?
     * @param email the user's email.
     * @param password the user's password.
     */
    // Check email and password input at login screen
    public boolean checkLoginDetails(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}