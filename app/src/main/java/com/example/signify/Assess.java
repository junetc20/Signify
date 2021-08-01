package com.example.signify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Assess extends AppCompatActivity {

    ImageView exitButton;
    EditText inputOne;
    EditText inputTwo;
    EditText inputThree;
    EditText inputFour;
    EditText inputFive;
    Button finish;
    ImageView resultNeg;
    ImageView resultPos;
    Button resultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assess);

        exitButton = findViewById(R.id.exitButton);
        inputOne = findViewById(R.id.inputOne);
        inputTwo = findViewById(R.id.inputTwo);
        inputThree = findViewById(R.id.inputThree);
        inputFour = findViewById(R.id.inputFour);
        inputFive = findViewById(R.id.inputFive);
        finish = findViewById(R.id.finish);
        resultNeg = findViewById(R.id.resultNeg);
        resultPos = findViewById(R.id.resultPos);
        resultButton = findViewById(R.id.resultButton);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Assess.this, Home.class));
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputOne.getText().toString().equals("") || inputTwo.getText().toString().equals("") || (inputThree.getText().toString().equals("") ||
                        (inputFour.getText().toString().equals("") || (inputFive.getText().toString().equals(""))))){
                    Toast.makeText(Assess.this, "Please enter a value for each skill.", Toast.LENGTH_SHORT).show();
                }
                else if (inputOne.getText().toString().equals("4") || inputTwo.getText().toString().equals("4") || (inputThree.getText().toString().equals("4") ||
                        (inputFour.getText().toString().equals("4") || (inputFive.getText().toString().equals("4"))))){
                    resultNeg.setVisibility(View.VISIBLE);
                    resultButton.setVisibility(View.VISIBLE);
                    resultButton.setClickable(true);
                }
                else {
                    resultPos.setVisibility(View.VISIBLE);
                    resultButton.setVisibility(View.VISIBLE);
                    resultButton.setClickable(true);
                }
            }
        });

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Assess.this, Home.class));
                resultPos.setVisibility(View.INVISIBLE);
                resultNeg.setVisibility(View.INVISIBLE);
                resultButton.setVisibility(View.GONE);
                resultButton.setClickable(false);
            }
        });
    }
}
