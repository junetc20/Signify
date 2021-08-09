package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Intro4 extends AppCompatActivity {

    //Fields
    ImageView exitButton7;
    ImageView nextArrow6;
    ImageView backArrow4;
    TextView prog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro4);

        // Constructor
        exitButton7 = findViewById(R.id.exitButton7);
        nextArrow6 = findViewById(R.id.nextArrow6);
        backArrow4 = findViewById(R.id.backArrow4);
        prog1 = findViewById(R.id.prog1);
        prog1.setText(R.string.Eighty);

        // Exit button - returns to home page
        exitButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro4.this, Home.class));
            }
        });

        // Next arrow - takes user to Intro 4
        nextArrow6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro4.this, Quiz1.class));
            }
        });

        // Back arrow - takes user to Intro 2
        backArrow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro4.this, Intro3.class));
            }
        });
    }
}