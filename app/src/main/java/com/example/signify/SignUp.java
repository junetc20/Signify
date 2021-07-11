package com.example.signify;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity{

    //fields
    EditText inputFirstName;
    EditText inputLastName;
    EditText inputEmail;
    EditText createPassword;
    EditText reEnterPassword;
    Button createAccount;
    TextView signInClick;
    ImageView exitButton;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //constructor
        inputFirstName = (EditText) findViewById(R.id.inputFirstName);
        inputLastName = (EditText) findViewById(R.id.inputLastName);
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        createPassword = (EditText) findViewById(R.id.createPassword);
        reEnterPassword = (EditText) findViewById(R.id.reEnterPassword);
        createAccount = (Button) findViewById(R.id.createAccount);
        signInClick = (TextView) findViewById(R.id.signInClick);
        exitButton = (ImageView) findViewById(R.id.exitButton);

        // Create account if all conditions are met
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputFirstName.getText().toString().equals("")){
                    Toast.makeText(SignUp.this, "Please enter your first name.", Toast.LENGTH_SHORT).show();
                }
                if (inputLastName.getText().toString().equals("")){
                    Toast.makeText(SignUp.this, "Please enter your last name.", Toast.LENGTH_SHORT).show();
                }
                if (inputEmail.getText().toString().equals("")){
                    Toast.makeText(SignUp.this, "Please enter your email address.", Toast.LENGTH_SHORT).show();
                }
                if (!inputEmail.getText().toString().contains("@")){
                    Toast.makeText(SignUp.this, "Please enter a valid email address.", Toast.LENGTH_SHORT).show();
                }
                if (createPassword.getText().toString().equals("")){
                    Toast.makeText(SignUp.this, "Please enter your password twice.", Toast.LENGTH_SHORT).show();
                }
                if (reEnterPassword.getText().toString().equals("")){
                    Toast.makeText(SignUp.this, "Please enter your password twice.", Toast.LENGTH_SHORT).show();
                }
                if (!createPassword.equals(reEnterPassword)){
                    Toast.makeText(SignUp.this, "Passwords do not match. Please try again.", Toast.LENGTH_SHORT).show();
                    createPassword.setText(null);
                    reEnterPassword.setText(null);
                }
                else {
                    startActivity(new Intent(SignUp.this, Assess.class));
                }
            }
        });

        // Open login screen if user already has an account
        signInClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Login.class));
            }
        });

        // Open login screen if user wants to exit signUp screen
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Login.class));
            }
        });
    } // Need to link this user data to database
}
