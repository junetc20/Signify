package com.example.signify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Intro2 extends AppCompatActivity {

    //Fields
    ImageView exitButton5;
    ImageView nextArrow4;
    ImageView backArrow2;
    TextView prog1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);

        // Constructor
        exitButton5 = findViewById(R.id.exitButton5);
        nextArrow4 = findViewById(R.id.nextArrow4);
        backArrow2 = findViewById(R.id.backArrow2);
        prog1 = findViewById(R.id.prog1);
        prog1.setText(R.string.Forty);

        // Exit button - returns to home page
        exitButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro2.this, Home.class));
            }
        });

        // Next arrow - takes user to Intro 3
        nextArrow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro2.this, Intro3.class));
            }
        });

        // Back arrow - takes user to Intro 1
        backArrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro2.this, Intro1.class));
            }
        });
    }
}
