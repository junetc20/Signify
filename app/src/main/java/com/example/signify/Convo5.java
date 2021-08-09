package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Convo5 extends AppCompatActivity {

    // Fields
    ImageView exitButton18;
    ImageView nextArrow17;
    ImageView backArrow13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_5);

        // Constructor
        exitButton18 = findViewById(R.id.exitButton18);
        nextArrow17 = findViewById(R.id.nextArrow17);
        backArrow13 = findViewById(R.id.backArrow13);

        exitButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo5.this, Home.class));
            }
        });

        nextArrow17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo5.this, Convo6.class));
            }
        });

        backArrow13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo5.this, Convo4.class));
            }
        });
    }
}
