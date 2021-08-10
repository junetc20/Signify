package com.example.signify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Intro1 extends AppCompatActivity {

    //Fields
    ImageView exitButton2;
    ImageView nextArrow3;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro1);

        // Constructor
        exitButton2 = findViewById(R.id.exitButton2);
        nextArrow3 = findViewById(R.id.nextArrow3);

        // Exit button - returns to home page
        exitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro1.this, Home.class));
            }
        });

        // Next arrow - takes user to Intro 2
        nextArrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro1.this, Intro2.class));
            }
        });
    }
}
