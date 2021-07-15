package com.example.signify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Quiz2 extends AppCompatActivity
        implements View.OnClickListener {

    // Fields
    private Button falseButton;
    private Button trueButton;
    private ImageView exitButtonQuiz2;
    private ImageView quizImage1;
    private TextView questionCountDisplay2;
    private TextView questionText;
    private int currentQuestionIndex = 0;
    private Button nextButton;

    // Array to hold questions
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

    // Linking this class with an activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_2);

        // Constructor
        quizImage1 = findViewById(R.id.quizImage1);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        exitButtonQuiz2 = findViewById(R.id.exitButtonQuiz2);
        questionCountDisplay2 = findViewById(R.id.questionCountDisplay2);
        questionText = findViewById(R.id.questionText);
        nextButton = findViewById(R.id.nextButton);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);

        // Makes the next button invisible after being clicked
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButton.setVisibility(View.INVISIBLE);
                currentQuestionIndex++;
                updateQuestion();
            }
        });

        // Exit button - returns to home page
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
                checkAnswer(true);
                break;

            case R.id.falseButton:
                checkAnswer(false);
                break;

            case R.id.nextButton:
                if (currentQuestionIndex < 8) {
                    updateQuestion();
                } else if (currentQuestionIndex == 8) {
                    nextButton.setVisibility(View.INVISIBLE);
                    trueButton.setVisibility(View.INVISIBLE);
                    falseButton.setVisibility(View.INVISIBLE);
                }
                break;
            }
        }

    @SuppressLint("SetTextI18n")
    private void updateQuestion() {
        questionText.setText(questionBank[currentQuestionIndex].getAnswerResId());
        questionCountDisplay2.setText("Question " + currentQuestionIndex + " / 8");
        // setting the textview with new question
        switch (currentQuestionIndex) {
            case 0:
                quizImage1.setImageResource(R.drawable.r);
                break;
            case 1:
                quizImage1.setImageResource(R.drawable.h);
                break;
            case 2:
                quizImage1.setImageResource(R.drawable.g);
                break;
            case 3:
                quizImage1.setImageResource(R.drawable.u);
                break;
            case 4:
                quizImage1.setImageResource(R.drawable.x);
                break;
            case 5:
                quizImage1.setImageResource(R.drawable.q);
                break;
            case 6:
                quizImage1.setImageResource(R.drawable.j);
                break;
            case 7:
                quizImage1.setImageResource(R.drawable.n);
                break;
        }
    }

    int correct = 0;
    private void checkAnswer(boolean userChooseCorrect) {
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
        int toastMessageId;
        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
            correct++;
        }
        else {
            toastMessageId = R.string.wrong_answer;
        }
        Toast.makeText(Quiz2.this, toastMessageId, Toast.LENGTH_SHORT).show();
        nextButton.setVisibility(View.VISIBLE);
    }
}