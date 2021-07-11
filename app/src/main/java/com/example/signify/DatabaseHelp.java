package com.example.signify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.contentcapture.DataShareWriteAdapter;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelp extends SQLiteOpenHelper {

    private static final String DB_NAME = "signify.db";
    private static final int DB_VERSION = 1;
    private final Context context;
    SQLiteDatabase db;
    private static final String DB_PATH = "data/data/com.example.signify/databases";
    private final String USER_TABLE = "login";

    public DatabaseHelp(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        createDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void createDatabase(){
        boolean dbExist = checkDbExist();

        if(!dbExist){
            this.getReadableDatabase();
            copyDb();
        }
    }

    private boolean checkDbExist(){
        SQLiteDatabase sqLiteDatabase = null;
        String pathway = DB_PATH + DB_NAME;
        sqLiteDatabase = sqLiteDatabase.openDatabase(pathway, null, SQLiteDatabase.OPEN_READONLY);

        if(sqLiteDatabase != null){
            sqLiteDatabase.close();
            return true;
        }
        return false;
    }

    private void copyDb() {
        try {
            InputStream inputStream = context.getAssets().open(DB_NAME);

            String outFileName = DB_PATH + DB_NAME;

            OutputStream outputStream = new FileOutputStream(outFileName);

            byte[] b = new byte[1024];
            int length;

            while((length = inputStream.read(b)) > 0) {
                outputStream.write(b, 0, length);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SQLiteDatabase openDatabase(){
        String path = DB_PATH + DB_NAME;
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        return db;
    }

    public void close(){
        if (db != null){
            db.close();
        }
    }

    public boolean checkUserExist(String email, String password){
        String[] columns = {"email"};
        db = openDatabase();

        String selection = "email = ? and password = ?";
        String[] selectionArgs = {email, password};

        Cursor cursor = db.query(USER_TABLE, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0){
            return true;
        }
        else{
            return false;
        }
    }
    //inserting data into SQLite database - does this link to sign up details?
    public boolean insertData(EditText inputFirstName, EditText inputLastName, EditText inputEmail, EditText createPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_name", String.valueOf(inputFirstName));
        contentValues.put("last_name", String.valueOf(inputLastName));
        contentValues.put("email", String.valueOf(inputEmail));
        contentValues.put("password", String.valueOf(createPassword));

        long result = db.insert("userLogin", null, contentValues);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }
}
