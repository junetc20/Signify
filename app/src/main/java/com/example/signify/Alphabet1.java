package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the first screen within the second learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Alphabet1 extends AppCompatActivity {

    ImageView exitButton3;
    ImageView nextArrow;
    Button beginButton2;
    ImageView learningOutcomes2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet1);

        /**
         * Constructor for objects of class Alphabet1.
         */
        exitButton3 = findViewById(R.id.exitButton3);
        nextArrow = findViewById(R.id.nextArrow);
        beginButton2 = findViewById(R.id.beginButton4);
        learningOutcomes2 = findViewById(R.id.learningOutcomes2);

        /**
         * Set the view from clicking exitButton3.
         * @param v the onClickListener View.
         */
        exitButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alphabet1.this, Home.class));
            }
        });

        /**
         * Set the view from clicking nextArrow.
         * @param v the onClickListener View.
         */
            nextArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alphabet1.this, Alphabet2.class));
            }
        });

        /**
         * Set the view from clicking beginButton2.
         * @param v the onClickListener View.
         */
        beginButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginButton2.setVisibility(View.INVISIBLE);
                learningOutcomes2.setVisibility(View.INVISIBLE);
            }
        });
    }
}