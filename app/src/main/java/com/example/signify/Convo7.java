package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the seventh screen within the fourth learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Convo7 extends AppCompatActivity {

    ImageView exitButton20;
    ImageView nextArrow19;
    ImageView backArrow15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_7);

        /**
         * Constructor for objects of class Convo7.
         */
        exitButton20 = findViewById(R.id.exitButton20);
        nextArrow19 = findViewById(R.id.nextArrow19);
        backArrow15 = findViewById(R.id.backArrow15);

        /**
         * Set the view from clicking exitButton20.
         * @param v the onClickListener View.
         */
        exitButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo7.this, Home.class));
            }
        });

        /**
         * Set the view from clicking nextArrow19.
         * @param v the onClickListener View.
         */
        nextArrow19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo7.this, Convo8.class));
                if (DataHolder.getPercentageComplete4() < 40) {
                    DataHolder.setPercentageComplete4(40);
                }
            }
        });

        /**
         * Set the view from clicking backArrow15.
         * @param v the onClickListener View.
         */
        backArrow15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo7.this, Convo6.class));
            }
        });
    }

}
