package com.example.signify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    // Fields
    ImageView userAccount;
    ImageButton menu;
    TextView userFirstName;
    Button level1Button;
    Button level2Button;
    Button level3Button;
    Button level4Button;
    Button level5Button;
    TextView prog1;
    TextView prog2;
    TextView prog3;
    TextView prog4;
    TextView prog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Constructor
        userAccount = (ImageView) findViewById(R.id.userAccount);
        menu = (ImageButton) findViewById(R.id.menu);
        userFirstName = (TextView) findViewById(R.id.userFirstName);
        level1Button = (Button) findViewById(R.id.level1Button);
        level2Button = (Button) findViewById(R.id.level2Button);
        level3Button = (Button) findViewById(R.id.level3Button);
        level4Button = (Button) findViewById(R.id.level4Button);
        level5Button = (Button) findViewById(R.id.level5Button);
        prog1 = (TextView) findViewById(R.id.prog1);
        prog2 = (TextView) findViewById(R.id.prog2);
        prog3 = (TextView) findViewById(R.id.prog3);
        prog4 = (TextView) findViewById(R.id.prog4);
        prog5 = (TextView) findViewById(R.id.prog5);

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
    }
}