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
    EditText email;
    EditText password;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInButton = (Button) findViewById(R.id.signInButton);
        email = (EditText) findViewById(R.id.emailInput);
        password = (EditText) findViewById(R.id.password);
        register = (TextView) findViewById(R.id.register);

        // makes registration link clickable
        // once clicked, user is sent to sign up page
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });

        //Intent intent = new Intent(this, SignUp.class);
        //startActivity(intent);

        // makes login button clickable
        // once clicked, user is sent to home page
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if (email and password are stored on database) {
                if(email.getText().toString().equals("") || password.getText().toString().equals("")) {
                    Toast.makeText(Login.this, "Please enter both your email and password.", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(Login.this, Home.class));
                    // else { show a toast saying login details are not registered }
                }
            }
        });
    }
}
