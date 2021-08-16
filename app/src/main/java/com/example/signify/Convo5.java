package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the fifth screen within the fourth learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Convo5 extends AppCompatActivity {

    private ImageView exitButton18;
    private ImageView nextArrow17;
    private ImageView backArrow13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_5);

        /**
         * Constructor for objects of class Convo5.
         */
        exitButton18 = findViewById(R.id.exitButton18);
        nextArrow17 = findViewById(R.id.nextArrow17);
        backArrow13 = findViewById(R.id.backArrow13);

        /**
         * Set the view from clicking exitButton18.
         * @param v the onClickListener View.
         */
        exitButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo5.this, Home.class));
                DataHolder.setActivityCount4(5);
            }
        });

        /**
         * Set the view from clicking nextArrow17.
         * @param v the onClickListener View.
         */
        nextArrow17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo5.this, Convo6.class));
                if (DataHolder.getPercentageComplete4() < 30) {
                    DataHolder.setPercentageComplete4(30);
                }
            }
        });

        /**
         * Set the view from clicking backArrow13.
         * @param v the onClickListener View.
         */
        backArrow13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo5.this, Convo4.class));
            }
        });
    }
}
