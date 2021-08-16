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

/**
 * A class that represents the sign up screen within Signify.
 * Users can use this screen to create an account.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class SignUp extends AppCompatActivity{

    private DatabaseHelper db;
    private EditText inputFirstName;
    private EditText inputLastName;
    private EditText inputEmail;
    private EditText createPassword;
    private EditText reEnterPassword;
    private Button createAccount;
    private TextView signInClick;
    private ImageView exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        /**
         * Constructor for objects of class SignUp.
         */
        db = new DatabaseHelper(this);
        inputFirstName = findViewById(R.id.inputFirstName);
        inputLastName = findViewById(R.id.inputLastName);
        inputEmail = findViewById(R.id.inputEmail);
        createPassword = findViewById(R.id.createPassword);
        reEnterPassword = findViewById(R.id.reEnterPassword);
        createAccount = findViewById(R.id.createAccount);
        signInClick = findViewById(R.id.signInClick);
        exitButton = findViewById(R.id.exitButton);

        /**
         * Set the view from clicking createAccount.
         * Add user details into database.
         * @param v the onClickListener View.
         */
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
                        if (checkEmail == true) {
                            db.insert(emailAdd, firstName, lastName, password);
                                Toast.makeText(SignUp.this, "You have registered successfully.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUp.this, Assess.class));
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

        /**
         * Set the view from clicking signInClick.
         * @param v the onClickListener View.
         */
        signInClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Login.class));
            }
        });

        /**
         * Set the view from clicking exitButton.
         * @param v the onClickListener View.
         */
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Login.class));
            }
        });
    }
}
