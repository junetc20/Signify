package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity{

    //fields
    DatabaseHelper db;
    EditText inputFirstName;
    EditText inputLastName;
    EditText inputEmail;
    EditText createPassword;
    EditText reEnterPassword;
    Button createAccount;
    TextView signInClick;
    ImageView exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //constructor
        db = new DatabaseHelper(this);
        inputFirstName = findViewById(R.id.inputFirstName);
        inputLastName = findViewById(R.id.inputLastName);
        inputEmail = findViewById(R.id.inputEmail);
        createPassword = findViewById(R.id.createPassword);
        reEnterPassword = findViewById(R.id.reEnterPassword);
        createAccount = findViewById(R.id.createAccount);
        signInClick = findViewById(R.id.signInClick);
        exitButton = findViewById(R.id.exitButton);

        // Create account if all conditions are met
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = inputFirstName.getText().toString();
                String lastName = inputLastName.getText().toString();
                String emailAdd = inputEmail.getText().toString();
                String password = createPassword.getText().toString();
                String reNewPassword = reEnterPassword.getText().toString();
                if (firstName.equals("") || lastName.equals("") || emailAdd.equals("") || password.equals("") || reNewPassword.equals("")) {
                    Toast.makeText(SignUp.this, "Please fill in all details.", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.equals(reNewPassword)) {
                        boolean checkEmail = db.checkEmail(emailAdd);
                        if (checkEmail) {
                            db.insert(emailAdd, firstName, lastName, password);
                                Toast.makeText(SignUp.this, "You have registered successfully.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUp.this, Home.class));
                        }
                        else {
                            Toast.makeText(SignUp.this, "This email already exists in this system. Please try logging in.", Toast.LENGTH_SHORT).show();
                            inputFirstName.setText(null);
                            inputLastName.setText(null);
                            inputEmail.setText(null);
                            createPassword.setText(null);
                            reEnterPassword.setText(null);
                        }
                    }
                    else {
                        Toast.makeText(SignUp.this, "Passwords do not match. Please try again.", Toast.LENGTH_SHORT).show();
                        createPassword.setText(null);
                        reEnterPassword.setText(null);
                    }
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
    }
}
