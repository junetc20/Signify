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

    // Fields
    private Button falseButton;
    private Button trueButton;
    private ImageView exitButtonQuiz2;
    private ImageView quizImage1;
    private ImageView resultImage;
    private TextView resultText;
    private TextView questionCountDisplay2;
    private TextView questionText;
    private int currentQuestionIndex = 0;
    private Button nextButton;
    private Button completeButton;

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
        resultImage = findViewById(R.id.resultImage);
        resultText = findViewById(R.id.resultText);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        exitButtonQuiz2 = findViewById(R.id.exitButtonQuiz2);
        questionCountDisplay2 = findViewById(R.id.questionCountDisplay2);
        questionText = findViewById(R.id.questionText);
        nextButton = findViewById(R.id.nextButton);
        completeButton = findViewById(R.id.completeButton);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        // Exit button - returns to home page
        exitButtonQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz2.this, Home.class));
            }
        });

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz2.this, Home.class));
            }
        });
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.trueButton:
                checkAnswer(true);
                trueButton.setVisibility(View.INVISIBLE);
                falseButton.setVisibility(View.INVISIBLE);
                break;

            case R.id.falseButton:
                checkAnswer(false);
                trueButton.setVisibility(View.INVISIBLE);
                falseButton.setVisibility(View.INVISIBLE);
                break;

            case R.id.nextButton:
                if (currentQuestionIndex < 7) {
                    nextButton.setVisibility(View.INVISIBLE);
                    trueButton.setVisibility(View.VISIBLE);
                    falseButton.setVisibility(View.VISIBLE);
                    currentQuestionIndex++;
                    updateQuestion();
                }
                else {
                    nextButton.setVisibility(View.INVISIBLE);
                    trueButton.setVisibility(View.INVISIBLE);
                    falseButton.setVisibility(View.INVISIBLE);
                    resultImage.setVisibility(View.VISIBLE);
                    resultText.setVisibility(View.VISIBLE);
                    completeButton.setVisibility(View.VISIBLE);
                    resultText.setText(correct + "/8");
                }
                break;
            }
        }

    @SuppressLint("SetTextI18n")
    private void updateQuestion() {
        questionText.setText(questionBank[currentQuestionIndex].getAnswerResId());
        // setting the textview with new question
        switch (currentQuestionIndex) {
            case 0:
                quizImage1.setImageResource(R.drawable.r);
                questionCountDisplay2.setText("Question 1 / 8");
                break;
            case 1:
                quizImage1.setImageResource(R.drawable.h);
                questionCountDisplay2.setText("Question 2 / 8");
                break;
            case 2:
                quizImage1.setImageResource(R.drawable.g);
                questionCountDisplay2.setText("Question 3 / 8");
                break;
            case 3:
                quizImage1.setImageResource(R.drawable.u);
                questionCountDisplay2.setText("Question 4 / 8");
                break;
            case 4:
                quizImage1.setImageResource(R.drawable.x);
                questionCountDisplay2.setText("Question 5 / 8");
                break;
            case 5:
                quizImage1.setImageResource(R.drawable.q);
                questionCountDisplay2.setText("Question 6 / 8");
                break;
            case 6:
                quizImage1.setImageResource(R.drawable.j);
                questionCountDisplay2.setText("Question 7 / 8");
                break;
            case 7:
                quizImage1.setImageResource(R.drawable.n);
                questionCountDisplay2.setText("Question 8 / 8");
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