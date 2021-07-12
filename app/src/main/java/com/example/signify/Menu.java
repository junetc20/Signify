package com.example.signify;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Constructor
        exitButtonMenu = (ImageView) findViewById(R.id.exitButtonMenu);
        userGuideLink = (TextView) findViewById(R.id.userGuideLink);
        bslLink = (TextView) findViewById(R.id.bslLink);
        logoutLink = (TextView) findViewById(R.id.logoutLink);

        exitButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Home.class));
            }
        });
    }
}
