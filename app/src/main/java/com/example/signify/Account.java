package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Account extends AppCompatActivity {

    // Fields
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        // Constructor
        db = new DatabaseHelper(this);
        exitButtonAcc = (ImageView) findViewById(R.id.exitButtonAcc);
        firstNameAcc = (EditText) findViewById(R.id.firstNameAcc);
        lastNameAcc = (EditText) findViewById(R.id.lastNameAcc);
        emailAcc = (EditText) findViewById(R.id.emailAcc);
        currentPassAcc = (EditText) findViewById(R.id.currentPassAcc);
        newPassAcc = (EditText) findViewById(R.id.newPassAcc);
        reNewPassAcc = (EditText) findViewById(R.id.reNewPassAcc);
        saveChangesAcc = (Button) findViewById(R.id.saveChangesAcc);
        saveChangesPass = (Button) findViewById(R.id.saveChangesPass);

        exitButtonAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account.this, Home.class));
            }
        });

        saveChangesAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newFName = firstNameAcc.getText().toString();
                String newLName = lastNameAcc.getText().toString();
                String newEmail = emailAcc.getText().toString();

                Boolean updateData = db.updateUserData(newFName, newLName, newEmail);
                if (updateData == true) {

                }
            }
        });
    }
}
