package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    Button signInButton;
    EditText emailInput;
    EditText password;
    TextView register;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInButton = (Button) findViewById(R.id.signInButton);
        emailInput = (EditText) findViewById(R.id.emailInput);
        password = (EditText) findViewById(R.id.password);
        register = (TextView) findViewById(R.id.register);
        db = new DatabaseHelper(this);

        // makes registration link clickable
        // once clicked, user is sent to sign up page
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });

        // Check that user input matches details within db
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String pass = password.getText().toString();
                Boolean checkLoginDetails = db.checkLoginDetails(email, pass);

                if(emailInput.getText().toString().equals("") || password.getText().toString().equals("")) {
                    Toast.makeText(Login.this, "Please enter both your email and password.", Toast.LENGTH_SHORT).show();
                } else {
                    if(checkLoginDetails==true) {
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
