package com.example.signify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    // Fields
    DatabaseHelper db;
    ImageView userAccount;
    ImageButton menu;
    Button level1Button;
    Button level2Button;
    Button level3Button;
    Button level4Button;
    TextView firstName;
    TextView prog1;
    TextView prog2;
    TextView prog3;
    TextView prog4;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Constructor
        db = new DatabaseHelper(this);
        Cursor cursor = db.firstName();
        userAccount = findViewById(R.id.userAccount);
        menu = findViewById(R.id.menu);
        level1Button = findViewById(R.id.level1Button);
        level2Button = findViewById(R.id.level2Button);
        level3Button = findViewById(R.id.level3Button);
        level4Button = findViewById(R.id.level4Button);
        prog1 = findViewById(R.id.prog1);
        prog2 = findViewById(R.id.prog2);
        prog3 = findViewById(R.id.prog3);
        prog4 = findViewById(R.id.prog4);
        firstName = findViewById(R.id.textView4);

        // Setting textview to show first name from database
        // DOESN'T WORK
        if(cursor.getCount() == 1) {
            firstName.setText(cursor.getString(cursor.getColumnIndex("firstName")));
        }
        else{
            Toast.makeText(getApplicationContext(), "NO DATA", Toast.LENGTH_LONG).show();
        }

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

        // When level 1 button is clicked, user will be taken to level 1 section
        level1Button.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Intro1.class));
            }
        });

            if (level1Button.getText().toString().equals("REVISIT")) {
                level2Button.setClickable(true);
                level2Button.setText(R.string.start);
                level2Button.setBackgroundColor(R.color.BSL_blue);
            }

            if (level1Button.isPressed()) {
                level1Button.setText(R.string.cont);
            }

        // When level 2 button is clicked, user will be taken to level 2 section
        level2Button.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Alphabet1.class));
            }
        });

        if (level2Button.getText().toString().equals("REVISIT")) {
            level3Button.setClickable(true);
            level3Button.setText(R.string.start);
            level3Button.setBackgroundColor(R.color.BSL_blue);
        }

        if (level2Button.isPressed()) {
            level2Button.setText(R.string.cont);
        }

        // When level 3 button is clicked, user will be taken to level 3 section
        level3Button.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(Home.this, Alphabet1.class)); //change class
                }
        });

        if (level3Button.getText().toString().equals("REVISIT")) {
            level4Button.setClickable(true);
            level4Button.setText(R.string.start);
            level4Button.setBackgroundColor(R.color.BSL_blue);
        }

        if (level3Button.isPressed()) {
            level3Button.setText(R.string.cont);
        }

        // When level 4 button is clicked, user will be taken to level 4 section
        level4Button.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(Home.this, Alphabet1.class)); //change class
                }
        });

        if (level4Button.isPressed()) {
            level4Button.setText(R.string.cont);
        }

    }
}