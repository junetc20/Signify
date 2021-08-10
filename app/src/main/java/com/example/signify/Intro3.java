package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the third screen within the first learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Intro3 extends AppCompatActivity {

    ImageView exitButton6;
    ImageView nextArrow5;
    ImageView backArrow3;
    TextView prog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro3);

        /**
         * Constructor for objects of class Intro3.
         */
        exitButton6 = findViewById(R.id.exitButton6);
        nextArrow5 = findViewById(R.id.nextArrow5);
        backArrow3 = findViewById(R.id.backArrow3);
        prog1 = findViewById(R.id.prog1);
        prog1.setText(R.string.Sixty);

        /**
         * Set the view from clicking exitButton6.
         * @param v the onClickListener View.
         */
        exitButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro3.this, Home.class));
            }
        });

        /**
         * Set the view from clicking nextArrow5.
         * @param v the onClickListener View.
         */
        nextArrow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro3.this, Intro4.class));
            }
        });

        /**
         * Set the view from clicking backArrow3.
         * @param v the onClickListener View.
         */
        backArrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro3.this, Intro2.class));
            }
        });
    }
}
