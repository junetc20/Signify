package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Login extends AppCompatActivity {

    Button login;
    EditText username;
    EditText password;
    DatabaseHelp databaseHelp;
    TextView register;

    
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        register = (TextView) findViewById(R.id.register);

        databaseHelp = new DatabaseHelp(Login.this);

        // This checks if user login details are held within Signify database
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isExist = databaseHelp.checkUserExist(username.getText().toString(), password.getText().toString());

                if(isExist){
                    Intent intent = new Intent(Login.this, Home.class);
                    intent.putExtra("username", username.getText().toString());
                    startActivity(intent);
                }
                else{
                    password.setText(null);
                    Toast.makeText(Login.this, "Invalid login details. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // When register TextView is clicked, Sign Up activity is opened
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });
    }
}
