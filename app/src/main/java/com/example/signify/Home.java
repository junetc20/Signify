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

/**
 * A class that represents the home screen of Signify.
 * Users can use this screen to access all other sections of the app.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Home extends AppCompatActivity {

    DatabaseHelper db;
    ImageView userAccount;
    ImageButton menu;
    Button level1Button;
    Button level2Button;
    Button level3Button;
    Button level4Button;
    TextView firstName;
    ImageView howTo1;
    ImageView howTo2;
    Button nextButtonHelp;
    Button doneButtonHelp;
    ImageView exitButtonHelp;


    @SuppressLint({"ResourceAsColor", "Range"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /**
         * Constructor for objects of class Home.
         */
        db = new DatabaseHelper(this);
        Cursor cursor = db.firstName();
        userAccount = findViewById(R.id.userAccount);
        menu = findViewById(R.id.menu);
        level1Button = findViewById(R.id.level1Button);
        level2Button = findViewById(R.id.level2Button);
        level3Button = findViewById(R.id.level3Button);
        level4Button = findViewById(R.id.level4Button);
        firstName = findViewById(R.id.textView4);
        howTo1 = findViewById(R.id.howTo1);
        howTo2 = findViewById(R.id.howTo2);
        nextButtonHelp = findViewById(R.id.nextButtonHelp);
        doneButtonHelp = findViewById(R.id.doneButtonHelp);
        exitButtonHelp = findViewById(R.id.exitButton20);
/*
        if (level1Button.getText().toString().equals("REVISIT")) {
            level2Button.setClickable(true);
            level2Button.setText(R.string.start);
            level2Button.setBackgroundColor(R.color.BSL_blue);
        }

        if (level2Button.getText().toString().equals("REVISIT")) {
            level3Button.setClickable(true);
            level3Button.setText(R.string.start);
            level3Button.setBackgroundColor(R.color.BSL_blue);
        }

        if (level3Button.getText().toString().equals("REVISIT")) {
            level4Button.setClickable(true);
            level4Button.setText(R.string.start);
            level4Button.setBackgroundColor(R.color.BSL_blue);
        }
 */
        if(cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                firstName.setText(cursor.getString(cursor.getColumnIndex("firstName")));
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "NO DATA", Toast.LENGTH_LONG).show();
        }

        /**
         * Set the view from clicking exitButtonHelp.
         * @param v the onClickListener View.
         */
        exitButtonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                howTo1.setVisibility(View.GONE);
                howTo2.setVisibility(View.GONE);
                nextButtonHelp.setVisibility(View.GONE);
                doneButtonHelp.setVisibility(View.GONE);
                exitButtonHelp.setVisibility(View.GONE);
                level1Button.setVisibility(View.VISIBLE);
                level2Button.setVisibility(View.VISIBLE);
                level3Button.setVisibility(View.VISIBLE);
                level4Button.setVisibility(View.VISIBLE);
            }
        });

        /**
         * Set the view from clicking nextButtonHelp.
         * @param v the onClickListener View.
         */
        nextButtonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                howTo1.setVisibility(View.GONE);
                howTo2.setVisibility(View.VISIBLE);
                nextButtonHelp.setVisibility(View.GONE);
                doneButtonHelp.setVisibility(View.VISIBLE);
            }
        });

        /**
         * Set the view from clicking doneButtonHelp.
         * @param v the onClickListener View.
         */
        doneButtonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                howTo1.setVisibility(View.GONE);
                howTo2.setVisibility(View.GONE);
                nextButtonHelp.setVisibility(View.GONE);
                doneButtonHelp.setVisibility(View.GONE);
                exitButtonHelp.setVisibility(View.GONE);
                level1Button.setVisibility(View.VISIBLE);
                level2Button.setVisibility(View.VISIBLE);
                level3Button.setVisibility(View.VISIBLE);
                level4Button.setVisibility(View.VISIBLE);
            }
        });

        /**
         * Set the view from clicking userAccount.
         * @param v the onClickListener View.
         */
        userAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Account.class));
            }
        });

        /**
         * Set the view from clicking menu.
         * @param v the onClickListener View.
         */
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Menu.class));
            }
        });

        /**
         * Set the view from clicking level1Button.
         * @param v the onClickListener View.
         */
        level1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Intro1.class));
                level1Button.setText(R.string.cont);
            }
        });

        /**
         * Set the view from clicking level2Button.
         * @param v the onClickListener View.
         */
        level2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Alphabet1.class));
                level2Button.setText(R.string.cont);
            }
        });

        /**
         * Set the view from clicking level3Button.
         * @param v the onClickListener View.
         */
        level3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Numbers1.class));
                level3Button.setText(R.string.cont);
            }
        });

        /**
         * Set the view from clicking level4Button.
         * @param v the onClickListener View.
         */
        level4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Convo1.class));
                level4Button.setText(R.string.cont);
            }
        });
    }
}


