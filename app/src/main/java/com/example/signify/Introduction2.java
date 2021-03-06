package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the second screen within the first learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Introduction2 extends AppCompatActivity {

    private ImageView exitButton5;
    private ImageView nextArrow4;
    private ImageView backArrow2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);

        /**
         * Constructor for objects of class Introduction2.
         */
        exitButton5 = findViewById(R.id.exitButton5);
        nextArrow4 = findViewById(R.id.nextArrow4);
        backArrow2 = findViewById(R.id.backArrow2);

        /**
         * Set the view from clicking exitButton5.
         * @param v the onClickListener View.
         */
        exitButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Introduction2.this, Home.class));
                DataHolder.setActivityCount1(2);
            }
        });

        /**
         * Set the view from clicking nextArrow4.
         * @param v the onClickListener View.
         */
        nextArrow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Introduction2.this, Introduction3.class));
                if (DataHolder.getPercentageComplete1() < 30) {
                    DataHolder.setPercentageComplete1(30);
                }
            }
        });

        /**
         * Set the view from clicking backArrow2.
         * @param v the onClickListener View.
         */
        backArrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Introduction2.this, Introduction1.class));
            }
        });
    }
}
