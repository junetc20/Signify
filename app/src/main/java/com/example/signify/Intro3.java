package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Intro3 extends AppCompatActivity {

    //Fields
    ImageView exitButton6;
    ImageView nextArrow5;
    ImageView backArrow3;
    TextView prog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro3);

        // Constructor
        exitButton6 = findViewById(R.id.exitButton6);
        nextArrow5 = findViewById(R.id.nextArrow5);
        backArrow3 = findViewById(R.id.backArrow3);
        prog1 = findViewById(R.id.prog1);
        prog1.setText(R.string.Sixty);

        // Exit button - returns to home page
        exitButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro3.this, Home.class));
            }
        });

        // Next arrow - takes user to Intro 4
        nextArrow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro3.this, Intro4.class));
            }
        });

        // Back arrow - takes user to Intro 2
        backArrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro3.this, Intro2.class));
            }
        });
    }
}
