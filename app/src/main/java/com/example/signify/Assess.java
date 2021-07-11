package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Assess extends AppCompatActivity {

    ImageView exitButton;
    EditText inputOne;
    EditText inputTwo;
    EditText inputThree;
    EditText inputFour;
    EditText inputFive;
    Button finish;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assess);

        exitButton = (ImageView) findViewById(R.id.exitButton);
        inputOne = (EditText) findViewById(R.id.inputOne);
        inputTwo = (EditText) findViewById(R.id.inputTwo);
        inputThree = (EditText) findViewById(R.id.inputThree);
        inputFour = (EditText) findViewById(R.id.inputFour);
        inputFive = (EditText) findViewById(R.id.inputFive);
        finish = (Button) findViewById(R.id.finish);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Assess.this, Home.class));
            }
        });
        /*

        finish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(inputOne.getText().toString().equals("") || inputOne. {
                    Toast.makeText(Assess.this, "Please enter a value for the first skill.", Toast.LENGTH_SHORT).show();
                }
                if(inputTwo.getText().toString().equals("")) {
                    Toast.makeText(Assess.this, "Please enter a value for the second skill.", Toast.LENGTH_SHORT).show();
                }
                if(inputThree.getText().toString().equals("")) {
                    Toast.makeText(Assess.this, "Please enter a value for the third skill.", Toast.LENGTH_SHORT).show();
                }
                if(inputFour.getText().toString().equals("")) {
                    Toast.makeText(Assess.this, "Please enter a value for the fourth skill.", Toast.LENGTH_SHORT).show();
                }
                if(inputFive.getText().toString().equals("")) {
                    Toast.makeText(Assess.this, "Please enter a value for the fifth skill.", Toast.LENGTH_SHORT).show();
                }
            }
        }); */
    }
}
