package com.example.signify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Quiz2 extends AppCompatActivity
        implements View.OnClickListener {

    private Button falseButton;
    private Button trueButton;
    private ImageView exitButtonQuiz2;
    private TextView questionCountDisplay2;
    private TextView questionText;
    private int questionCount = 0;
    private int currentQuestionIndex = 0;
    private Button nextButton;

    public Question[] questionBank = new Question[]{
            new Question(R.string.R, true),
            new Question(R.string.T, false),
            new Question(R.string.G, true),
            new Question(R.string.U, true),
            new Question(R.string.Z, false),
            new Question(R.string.Q, true),
            new Question(R.string.Y, false),
            new Question(R.string.L, false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_2);

        // Constructor
        // Fields
        ImageView quizImage1 = findViewById(R.id.quizImage1);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        exitButtonQuiz2 = findViewById(R.id.exitButtonQuiz2);
        questionCountDisplay2 = findViewById(R.id.questionCountDisplay2);
        questionText = findViewById(R.id.questionText);
        nextButton = findViewById(R.id.nextButton);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);

        // Exit button
        exitButtonQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz2.this, Home.class));
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.trueButton:
                Toast.makeText(Quiz2.this, "True", Toast.LENGTH_SHORT).show();
                break;

            case R.id.falseButton:
                Toast.makeText(Quiz2.this, "False", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nextButton:
                currentQuestionIndex++;
                questionText.setText(questionBank [currentQuestionIndex].getAnswerResId());
                break;
        }

    }
}