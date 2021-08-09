package com.example.signify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
                startActivity(new Intent(Menu.this, Login.class));
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

            }
        });

        /**
         * Set the view from clicking bslLink.
         * @param v the onClickListener View.
         */
        bslLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.british-sign.co.uk/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
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
