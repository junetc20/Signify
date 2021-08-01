package com.example.signify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Intro1 extends AppCompatActivity {

    //Fields
    ImageView exitButton2;
    ImageView nextArrow3;
    TextView prog1;
    // int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro1);

        // Constructor
        exitButton2 = findViewById(R.id.exitButton2);
        nextArrow3 = findViewById(R.id.nextArrow3);
        prog1 = findViewById(R.id.prog1);

        // Exit button - returns to home page
        exitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro1.this, Home.class));
            }
        });

        // Next arrow - takes user to Intro 2
        nextArrow3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro1.this, Intro2.class));
                /* count++;
                if(count == 1) {
                    prog1.setText("Progress: 20%");
                } */
            }
        });
    }
}
