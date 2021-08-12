package com.example.signify;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the menu screen of Signify.
 * Users can use this screen to access app functions and logout.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Menu extends AppCompatActivity {

    ImageView exitButtonMenu;
    TextView userGuideLink;
    TextView bslLink;
    TextView logoutLink;
    TextView surveyLink;
    View howTo1;
    View howTo2;
    View nextButtonHelp;
    View doneButtonHelp;
    View exitButton20;
    View level1Button;
    View level2Button;
    View level3Button;
    View level4Button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        /**
         * Constructor for objects of class Menu.
         */
        exitButtonMenu = findViewById(R.id.exitButtonMenu);
        userGuideLink = findViewById(R.id.userGuideLink);
        bslLink = findViewById(R.id.bslLink);
        logoutLink = findViewById(R.id.logoutLink);
        surveyLink = findViewById(R.id.surveyLink);
        howTo1 = findViewById(R.id.howTo1);
        howTo2 = findViewById(R.id.howTo2);
        nextButtonHelp = findViewById(R.id.nextButtonHelp);
        doneButtonHelp = findViewById(R.id.doneButtonHelp);
        exitButton20 = findViewById(R.id.exitButton20);
        level1Button = findViewById(R.id.level1Button);
        level2Button = findViewById(R.id.level2Button);
        level3Button = findViewById(R.id.level3Button);
        level4Button = findViewById(R.id.level4Button);

        /**
         * Set the view from clicking exitButtonMenu.
         * @param v the onClickListener View.
         */
        exitButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Home.class));
            }
        });

        /**
         * Set the view from clicking logoutLink.
         * @param v the onClickListener View.
         */
        logoutLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sets alert dialog for user to confirm action
                AlertDialog.Builder builder = new AlertDialog.Builder(Menu.this);
                builder.setMessage("Are you sure you want to log out of your account?");
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(Menu.this, Login.class));
                                dialog.cancel();
                            }
                        });

                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        /**
         * Set the view from clicking userGuideLink.
         * @param v the onClickListener View.
         */
        userGuideLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Home.class));
                DataHolder.setUserGuideViewed(false);
            }
        });

        /**
         * Set the view from clicking bslLink.
         * @param v the onClickListener View.
         */
        bslLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sets alert dialog for user to confirm action
                AlertDialog.Builder builder = new AlertDialog.Builder(Menu.this);
                builder.setMessage("This will take you to an external website. Do you want to open this?");
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Uri uri = Uri.parse("https://www.british-sign.co.uk/");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                                dialog.cancel();
                            }
                        });

                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });

        /**
         * Set the view from clicking surveyLink.
         * @param v the onClickListener View.
         */
        surveyLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, Assess.class));
            }
        });

    }
}
