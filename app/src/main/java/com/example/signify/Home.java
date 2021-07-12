package com.example.signify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView userFirstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        /*
        userFirstName = findViewById(R.id.userFirstName);

        Bundle extras = getIntent().getExtras();
        String firstName = null;
        if (extras != null){
            firstName = extras.getString("username"); // insert string name for first name input on login page
            userFirstName.setText(firstName);
        }*/
    }
}