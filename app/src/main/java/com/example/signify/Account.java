package com.example.signify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the account screen of Signify.
 * Users can use this screen to view and update their account details.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Account extends AppCompatActivity {

    DatabaseHelper db;
    ImageView exitButtonAcc;
    EditText firstNameAcc;
    EditText lastNameAcc;
    EditText emailAcc;
    EditText currentPassAcc;
    EditText newPassAcc;
    EditText reNewPassAcc;
    Button saveChangesAcc;
    Button saveChangesPass;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        /**
         * Constructor for objects of class Account.
         */
        db = new DatabaseHelper(this);
        Cursor cursor = db.getUserData();
        exitButtonAcc = findViewById(R.id.exitButtonAcc);
        firstNameAcc = findViewById(R.id.firstNameAcc);
        lastNameAcc = findViewById(R.id.lastNameAcc);
        emailAcc = findViewById(R.id.emailAcc);
        currentPassAcc = findViewById(R.id.currentPassAcc);
        newPassAcc = findViewById(R.id.newPassAcc);
        reNewPassAcc = findViewById(R.id.reNewPassAcc);
        saveChangesAcc = findViewById(R.id.saveChangesAcc);
        saveChangesPass = findViewById(R.id.saveChangesPass);

        if(cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
        firstNameAcc.setText(cursor.getString(cursor.getColumnIndex("firstName")));
        lastNameAcc.setText(cursor.getString(cursor.getColumnIndex("lastName")));
        emailAcc.setText(cursor.getString(cursor.getColumnIndex("email")));
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "NO DATA", Toast.LENGTH_LONG).show();
        }

        /**
         * Set the view from clicking exitButtonAcc.
         * @param v the onClickListener View.
         */
        exitButtonAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this, Home.class));
            }
        });

        /**
         * Set the view from clicking saveChangesAcc.
         * @param v the onClickListener View.
         */
        // Updates first name, last name and email data
        saveChangesAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newFName = firstNameAcc.getText().toString();
                String newLName = lastNameAcc.getText().toString();
                String newEmail = emailAcc.getText().toString();

               /* Boolean updateData = db.updateUserData(newFName, newLName, newEmail);
                if (updateData) {
                    firstNameAcc.setText(newFName);
                    lastNameAcc.setText(newLName);
                    emailAcc.setText(newEmail);
                    Toast.makeText(Account.this, "Details updated successfully.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Account.this, "No changes made.", Toast.LENGTH_SHORT).show();
                }
            } */
            }

        /*
        // Checks that passwords match
        saveChangesPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newPassAcc.equals(reNewPassAcc)) {
                }
            }
        }); */
        });
    }
}
