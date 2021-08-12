package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the fourth screen within the first learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Intro4 extends AppCompatActivity {

    ImageView exitButton7;
    ImageView nextArrow6;
    ImageView backArrow4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro4);

        /**
         * Constructor for objects of class Intro4.
         */
        exitButton7 = findViewById(R.id.exitButton7);
        nextArrow6 = findViewById(R.id.nextArrow6);
        backArrow4 = findViewById(R.id.backArrow4);

        /**
         * Set the view from clicking exitButton7.
         * @param v the onClickListener View.
         */
        exitButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro4.this, Home.class));
                DataHolder.setActivityCount1(4);
            }
        });

        /**
         * Set the view from clicking nextArrow6.
         * @param v the onClickListener View.
         */
        nextArrow6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro4.this, Quiz1.class));
                if (DataHolder.getPercentageComplete1() < 50) {
                    DataHolder.setPercentageComplete1(50);
                }
            }
        });

        /**
         * Set the view from clicking backArrow4.
         * @param v the onClickListener View.
         */
        backArrow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro4.this, Intro3.class));
            }
        });
    }
}