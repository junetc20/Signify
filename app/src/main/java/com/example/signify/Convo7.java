package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Convo7 extends AppCompatActivity {

    // Fields
    ImageView exitButton20;
    ImageView nextArrow19;
    ImageView backArrow15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_7);

        // Constructor
        exitButton20 = findViewById(R.id.exitButton20);
        nextArrow19 = findViewById(R.id.nextArrow19);
        backArrow15 = findViewById(R.id.backArrow15);

        exitButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo7.this, Home.class));
            }
        });

        nextArrow19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo7.this, Convo8.class));
            }
        });

        backArrow15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo7.this, Convo6.class));
            }
        });
    }

}
