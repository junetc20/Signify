package com.example.signify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    // Fields
    ImageView exitButtonMenu;
    TextView userGuideLink;
    TextView bslLink;
    TextView logoutLink;
    TextView surveyLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Constructor
        exitButtonMenu = findViewById(R.id.exitButtonMenu);
        userGuideLink = findViewById(R.id.userGuideLink);
        bslLink = findViewById(R.id.bslLink);
        logoutLink = findViewById(R.id.logoutLink);
        surveyLink = findViewById(R.id.surveyLink);

        // Exits user from this activity and back to home page
        exitButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Home.class));
            }
        });

        // Logs user out of account
        // Needs pop up warning (use yes/no switch)
        logoutLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Login.class));
            }
        });

        // Returns user to home page
        // Opens user guide
        userGuideLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Home.class));

            }
        });

        // Clicking the BSL link will open external BSL website
        // Needs pop up warning (use yes/no switch)
        bslLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.british-sign.co.uk/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        // Clicking survey link will open Assess activity
        surveyLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, Assess.class));
            }
        });
    }
}
