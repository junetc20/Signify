package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Convo4 extends AppCompatActivity {

    // Fields
    ImageView exitButton17;
    ImageView nextArrow16;
    ImageView backArrow12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_4);

        // Constructor
        exitButton17 = findViewById(R.id.exitButton17);
        nextArrow16 = findViewById(R.id.nextArrow16);
        backArrow12 = findViewById(R.id.backArrow12);

        exitButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo4.this, Home.class));
            }
        });

        nextArrow16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo4.this, Convo5.class));
            }
        });

        backArrow12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo4.this, Convo3.class));
            }
        });
    }
}
