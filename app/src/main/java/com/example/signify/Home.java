package com.example.signify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    // Fields
    DatabaseHelper db;
    ImageView userAccount;
    ImageButton menu;
    TextView userFirstName;
    Button level1Button;
    Button level2Button;
    Button level3Button;
    Button level4Button;
    TextView prog1;
    TextView prog2;
    TextView prog3;
    TextView prog4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Constructor
        db = new DatabaseHelper(this);
        userAccount = findViewById(R.id.userAccount);
        menu = findViewById(R.id.menu);
        userFirstName = findViewById(R.id.userFirstName);
        level1Button = findViewById(R.id.level1Button);
        level2Button = findViewById(R.id.level2Button);
        level3Button = findViewById(R.id.level3Button);
        level4Button = findViewById(R.id.level4Button);
        prog1 = findViewById(R.id.prog1);
        prog2 = findViewById(R.id.prog2);
        prog3 = findViewById(R.id.prog3);
        prog4 = findViewById(R.id.prog4);

        // When account icon is clicked, it will take user to Account activity
        userAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Account.class));
            }
        });

        // When menu icon is clicked, it will take user to Menu activity
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Menu.class));
            }
        });

        // When level 2 button is clicked, user will be taken to level 2 section
        level2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Alphabet1.class));
            }
        });

        // When level 1 button is clicked, user will be taken to level 1 section
        level1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Intro1.class));
            }
        });

        // Sets first name at top of screen
            String name = userFirstName.getText().toString();
            db.getUserFName(name);
            userFirstName.setText(name);

            /*
            Cursor cursor = cursor.toString();
            cursor.moveToFirst();
            userFirstName.setText(cursor.getString(0)); */
    }
}