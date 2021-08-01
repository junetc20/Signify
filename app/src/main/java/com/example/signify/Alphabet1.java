package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Alphabet1 extends AppCompatActivity {

    // Fields
    ImageView exitButton3;
    ImageView nextArrow;
    Button beginButton2;
    ImageView learningOutcomes2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet1);

        // Constructor
        exitButton3 = findViewById(R.id.exitButton3);
        nextArrow = findViewById(R.id.nextArrow);
        beginButton2 = findViewById(R.id.beginButton2);
        learningOutcomes2 = findViewById(R.id.learningOutcomes2);

        // Exit button - returns to home page
        exitButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alphabet1.this, Home.class));
            }
        });

        // Next arrow - takes user to Alphabet 2
            nextArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alphabet1.this, Alphabet2.class));
            }
        });

        // Begin button - closes learning outcomes
        beginButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginButton2.setVisibility(View.INVISIBLE);
                learningOutcomes2.setVisibility(View.INVISIBLE);
            }
        });
    }
}