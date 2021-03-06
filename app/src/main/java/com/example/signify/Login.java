package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the login screen of Signify.
 * Users can use this screen to login to their Signify account.
 * This is the first screen shown to users.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Login extends AppCompatActivity {

    private Button signInButton;
    private EditText emailInput;
    private EditText password;
    private TextView register;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /**
         * Constructor for objects of class Login.
         */
        signInButton = findViewById(R.id.signInButton);
        emailInput = findViewById(R.id.emailInput);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        db = new DatabaseHelper(this);

        /**
         * Set the view from clicking register.
         * @param v the onClickListener View.
         */
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });

        /**
         * Set the view from clicking signInButton.
         * @param v the onClickListener View.
         */
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String pass = password.getText().toString();
                boolean checkLoginDetails = db.checkLoginDetails(email, pass);

                if(emailInput.getText().toString().equals("") || password.getText().toString().equals("")) {
                    Toast.makeText(Login.this, "Please enter both your email and password.", Toast.LENGTH_SHORT).show();
                }
                else {
                     if(checkLoginDetails == true) {
                        Toast.makeText(Login.this, "Successful login.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, Home.class));
                    }
                    else {
                        Toast.makeText(Login.this, "Incorrect email or password. Please try again.", Toast.LENGTH_SHORT).show();
                        emailInput.setText(null);
                        password.setText(null);
                    }
                }
            }
        });
    }
}