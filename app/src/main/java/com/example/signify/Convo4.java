package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the fourth screen within the fourth learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Convo4 extends AppCompatActivity {

    ImageView exitButton17;
    ImageView nextArrow16;
    ImageView backArrow12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_4);

        /**
         * Constructor for objects of class Convo4.
         */
        exitButton17 = findViewById(R.id.exitButton17);
        nextArrow16 = findViewById(R.id.nextArrow16);
        backArrow12 = findViewById(R.id.backArrow12);

        /**
         * Set the view from clicking exitButton17.
         * @param v the onClickListener View.
         */
        exitButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo4.this, Home.class));
                DataHolder.setActivityCount4(4);
            }
        });

        /**
         * Set the view from clicking nextArrow16.
         * @param v the onClickListener View.
         */
        nextArrow16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo4.this, Convo5.class));
                if (DataHolder.getPercentageComplete4() < 25) {
                    DataHolder.setPercentageComplete4(25);
                }
            }
        });

        /**
         * Set the view from clicking backArrow12.
         * @param v the onClickListener View.
         */
        backArrow12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo4.this, Convo3.class));
            }
        });
    }
}
