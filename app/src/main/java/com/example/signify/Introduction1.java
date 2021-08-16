package com.example.signify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the first screen within the first learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Introduction1 extends AppCompatActivity {

    private ImageView exitButton2;
    private ImageView nextArrow3;
    private ImageView learningOutcomes1;
    private Button beginButton2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro1);

        /**
         * Constructor for objects of class Introduction1.
         */
        exitButton2 = findViewById(R.id.exitButton2);
        nextArrow3 = findViewById(R.id.nextArrow3);
        learningOutcomes1 = findViewById(R.id.learningOutcomes1);
        beginButton2 = findViewById(R.id.beginButton4);

        /**
         * Set the view from clicking exitButton2.
         * @param v the onClickListener View.
         */
        exitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Introduction1.this, Home.class));
                DataHolder.setActivityCount1(1);

            }
        });

        /**
         * Set the view from clicking nextArrow3.
         * @param v the onClickListener View.
         */
        nextArrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Introduction1.this, Introduction2.class));
                if (DataHolder.getPercentageComplete1() < 20) {
                    DataHolder.setPercentageComplete1(20);
                }
            }
        });

        /**
         * Set the view from clicking beginButton2.
         * @param v the onClickListener View.
         */
        beginButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                learningOutcomes1.setVisibility(View.INVISIBLE);
                beginButton2.setVisibility(View.INVISIBLE);
            }
        });
    }
}
