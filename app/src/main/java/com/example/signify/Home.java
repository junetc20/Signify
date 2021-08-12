package com.example.signify;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
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
    ImageView exitButton20;
    TextView prog1;
    TextView prog2;
    TextView prog3;
    TextView prog4;

    @SuppressLint({"ResourceAsColor", "Range", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /**
         * Constructor for objects of class Home.
         */
        db = new DatabaseHelper(this);
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
        exitButton20 = findViewById(R.id.exitButton20);
        prog1 = findViewById(R.id.prog1);
        prog2 = findViewById(R.id.prog2);
        prog3 = findViewById(R.id.prog3);
        prog4 = findViewById(R.id.prog4);

        showFirstName();

        // Checks if userGuide has been viewed previously
        // Hides if true
        if(DataHolder.isUserGuideViewed()) {
            howTo1.setVisibility(View.GONE);
            howTo2.setVisibility(View.GONE);
            nextButtonHelp.setVisibility(View.GONE);
            doneButtonHelp.setVisibility(View.GONE);
            exitButton20.setVisibility(View.GONE);
            level1Button.setVisibility(View.VISIBLE);
            level2Button.setVisibility(View.VISIBLE);
            level3Button.setVisibility(View.VISIBLE);
            level4Button.setVisibility(View.VISIBLE);
        }

        // Sets prog1 text from DataHolder method
        String s = String.valueOf(DataHolder.getPercentageComplete1());
        prog1.setText("Progress: " + s + "%"); // TODO change this setup if all hell breaks loose

        // Sets prog2 text from DataHolder method
        String e = String.valueOf(DataHolder.getPercentageComplete2());
        prog2.setText("Progress: " + e + "%"); // TODO change this setup if all hell breaks loose

        // Sets prog3 text from DataHolder method
        String i = String.valueOf(DataHolder.getPercentageComplete3());
        prog3.setText("Progress: " + i + "%"); // TODO change this setup if all hell breaks loose

        // Sets prog4 text from DataHolder method
        String o = String.valueOf(DataHolder.getPercentageComplete4());
        prog4.setText("Progress: " + o + "%"); // TODO change this setup if all hell breaks loose

        // Makes level2Button clickable
        if(DataHolder.isLevel2ButtonClickable()) {
            level2Button.setEnabled(true);
        }

        // Makes level3Button clickable
        if(DataHolder.isLevel3ButtonClickable()) {
            level3Button.setEnabled(true);
        }

        // Makes level4Button clickable
        if(DataHolder.isLevel4ButtonClickable()) {
            level4Button.setEnabled(true);
        }

        // Changes text and color of level1Button on create
        if (DataHolder.isCompleteButton2Clicked()) {
            level1Button.setText(R.string.revisit);
            level1Button.setBackgroundColor(R.color.purple);
        }
        else if (DataHolder.isLevel1ButtonClicked()) {
            level1Button.setText(R.string.cont);
            level1Button.setBackgroundColor(R.color.BSL_blue);
        }
        else {
            level1Button.setText(R.string.start);
            level1Button.setBackgroundColor(R.color.BSL_blue);
        }

        // Changes text and color of level2Button on create
        if (DataHolder.isCompleteButtonClicked()) {
            level2Button.setText(R.string.revisit);
            level2Button.setBackgroundColor(R.color.purple);
        }
        else if (DataHolder.isLevel2ButtonClicked()) {
            level2Button.setText(R.string.cont);
            level2Button.setBackgroundColor(R.color.BSL_blue);
        }
        else if (DataHolder.isCompleteButton2Clicked()) {
            level2Button.setText(R.string.start);
            level2Button.setBackgroundColor(R.color.BSL_blue);
        }
        else {
            level2Button.setText(R.string.locked);
            level2Button.setBackgroundColor(R.color.background_blue);
        }

        // Changes text and color of level3Button on create
        if (DataHolder.isCompleteButton3Clicked()) {
            level3Button.setText(R.string.revisit);
            level3Button.setBackgroundColor(R.color.purple);
        }
        else if (DataHolder.isLevel3ButtonClicked()) {
            level3Button.setText(R.string.cont);
            level3Button.setBackgroundColor(R.color.BSL_blue);
        }
        else if (DataHolder.isCompleteButtonClicked()) {
            level3Button.setText(R.string.start);
            level3Button.setBackgroundColor(R.color.BSL_blue);
        }
        else {
            level3Button.setText(R.string.locked);
            level3Button.setBackgroundColor(R.color.background_blue);
        }

        // Changes text and color of level4Button on create
        if (DataHolder.isCompleteButton4Clicked()) {
            level4Button.setText(R.string.revisit);
            level4Button.setBackgroundColor(R.color.purple);
        }
        else if (DataHolder.isLevel4ButtonClicked()) {
            level4Button.setText(R.string.cont);
            level4Button.setBackgroundColor(R.color.BSL_blue);
        }
        else if (DataHolder.isCompleteButton3Clicked()) {
            level4Button.setText(R.string.start);
            level4Button.setBackgroundColor(R.color.BSL_blue);
        }
        else {
            level4Button.setText(R.string.locked);
            level4Button.setBackgroundColor(R.color.background_blue);
        }

        /**
         * Set the view from clicking exitButtonHelp.
         * @param v the onClickListener View.
         */
        exitButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setUserGuideViewed(true);
                howTo1.setVisibility(View.GONE);
                howTo2.setVisibility(View.GONE);
                nextButtonHelp.setVisibility(View.GONE);
                doneButtonHelp.setVisibility(View.GONE);
                exitButton20.setVisibility(View.GONE);
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
                exitButton20.setVisibility(View.VISIBLE);
                nextButtonHelp.setVisibility(View.GONE);
                doneButtonHelp.setVisibility(View.VISIBLE);
                doneButtonHelp.setEnabled(true);
            }
        });

        /**
         * Set the view from clicking doneButtonHelp.
         * @param v the onClickListener View.
         */
        doneButtonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setUserGuideViewed(true);
                howTo1.setVisibility(View.GONE);
                howTo2.setVisibility(View.GONE);
                nextButtonHelp.setVisibility(View.GONE);
                doneButtonHelp.setVisibility(View.GONE);
                exitButton20.setVisibility(View.GONE);
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
                DataHolder.setLevel1ButtonClicked(true);
                if (DataHolder.getPercentageComplete1() < 10) {
                    DataHolder.setPercentageComplete1(10);
                }
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
                DataHolder.setLevel2ButtonClicked(true);
                if (DataHolder.getPercentageComplete2() < 20) {
                    DataHolder.setPercentageComplete2(20);
                }
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
                DataHolder.setLevel3ButtonClicked(true);
                if (DataHolder.getPercentageComplete3() < 10) {
                    DataHolder.setPercentageComplete3(10);
                }
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
                DataHolder.setLevel4ButtonClicked(true);
                if (DataHolder.getPercentageComplete4() < 5) {
                    DataHolder.setPercentageComplete4(5);
                }
            }
        });
    }

    /**
     * Retrieves data from the firstName column of the database login.db.
     * Inserts this retrieved data into the TextView firstName.
     */
    public void showFirstName() {
        Cursor cursor = db.firstName();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                firstName.setText(cursor.getString(cursor.getColumnIndex("firstName")));
            }
        } else {
            Toast.makeText(getApplicationContext(), "NO DATA", Toast.LENGTH_LONG).show();
        }
    }
}



