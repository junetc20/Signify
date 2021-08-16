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

/**
 * A class that represents the quiz for the second learning section of Signify.
 * Users can use this screen to test knowledge of learned concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Quiz2 extends AppCompatActivity
        implements View.OnClickListener {

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
    public QuizQuestions[] quizQuestionsBank = new QuizQuestions[]{
            new QuizQuestions(R.string.R, true),
            new QuizQuestions(R.string.T, false),
            new QuizQuestions(R.string.G, true),
            new QuizQuestions(R.string.U, true),
            new QuizQuestions(R.string.Z, false),
            new QuizQuestions(R.string.Q, true),
            new QuizQuestions(R.string.Y, false),
            new QuizQuestions(R.string.L, false),
            new QuizQuestions(R.string.O, true),
            new QuizQuestions(R.string.S, true),
            new QuizQuestions(R.string.I, false),
            new QuizQuestions(R.string.K, true),
            new QuizQuestions(R.string.H, false),
            new QuizQuestions(R.string.A, false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_2);

        /**
         * Constructor for objects of class Quiz2.
         */
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

        /**
         * Set the view from clicking exitButtonQuiz2.
         * @param v the onClickListener View.
         */
        exitButtonQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz2.this, Home.class));
                DataHolder.setActivityCount2(3);
            }
        });

        /**
         * Set the view from clicking completeButton.
         * @param v the onClickListener View.
         */
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz2.this, Home.class));
                DataHolder.setCompleteButtonClicked(true);
                DataHolder.setLevel3ButtonClickable(true);
                if (DataHolder.getPercentageComplete2() < 100) {
                    DataHolder.setPercentageComplete2(100);
                }
                DataHolder.setActivityCount2(0);
            }
        });
    }

    /**
     * Set the view from clicking trueButton, falseButton or nextButton.
     * @param v the onClickListener View.
     */
    @SuppressLint({"NonConstantResourceId", "SetTextI18n", "ResourceAsColor"})
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
                if (currentQuestionIndex < 13) {
                    nextButton.setVisibility(View.INVISIBLE);
                    trueButton.setVisibility(View.VISIBLE);
                    falseButton.setVisibility(View.VISIBLE);
                    currentQuestionIndex++;
                    updateQuestion();
                } else {
                    nextButton.setVisibility(View.INVISIBLE);
                    trueButton.setVisibility(View.INVISIBLE);
                    falseButton.setVisibility(View.INVISIBLE);
                    resultImage.setVisibility(View.VISIBLE);
                    resultText.setVisibility(View.VISIBLE);
                    completeButton.setVisibility(View.VISIBLE);
                    resultText.setText(correct + "/14");
                }
                break;
        }
    }

    /**
     * Update fields as currentQuestionIndex increases.
     */
    @SuppressLint("SetTextI18n")
    public void updateQuestion() {
        questionText.setText(quizQuestionsBank[currentQuestionIndex].getAnswerResId());
        // setting the textview with new question
        switch (currentQuestionIndex) {
            case 0:
                quizImage1.setImageResource(R.drawable.r);
                questionCountDisplay2.setText("QuizQuestions 1 / 14");
                break;
            case 1:
                quizImage1.setImageResource(R.drawable.h);
                questionCountDisplay2.setText("QuizQuestions 2 / 14");
                break;
            case 2:
                quizImage1.setImageResource(R.drawable.g);
                questionCountDisplay2.setText("QuizQuestions 3 / 14");
                break;
            case 3:
                quizImage1.setImageResource(R.drawable.u);
                questionCountDisplay2.setText("QuizQuestions 4 / 14");
                break;
            case 4:
                quizImage1.setImageResource(R.drawable.x);
                questionCountDisplay2.setText("QuizQuestions 5 / 14");
                break;
            case 5:
                quizImage1.setImageResource(R.drawable.q);
                questionCountDisplay2.setText("QuizQuestions 6 / 14");
                break;
            case 6:
                quizImage1.setImageResource(R.drawable.j);
                questionCountDisplay2.setText("QuizQuestions 7 / 14");
                break;
            case 7:
                quizImage1.setImageResource(R.drawable.n);
                questionCountDisplay2.setText("QuizQuestions 8 / 14");
                break;
            case 8:
                quizImage1.setImageResource(R.drawable.o);
                questionCountDisplay2.setText("QuizQuestions 9 / 14");
                break;
            case 9:
                quizImage1.setImageResource(R.drawable.s);
                questionCountDisplay2.setText("QuizQuestions 10 / 14");
                break;
            case 10:
                quizImage1.setImageResource(R.drawable.u);
                questionCountDisplay2.setText("QuizQuestions 11 / 14");
                break;
            case 11:
                quizImage1.setImageResource(R.drawable.k);
                questionCountDisplay2.setText("QuizQuestions 12 / 14");
                break;
            case 12:
                quizImage1.setImageResource(R.drawable.t);
                questionCountDisplay2.setText("QuizQuestions 13 / 14");
                break;
            case 13:
                quizImage1.setImageResource(R.drawable.p);
                questionCountDisplay2.setText("QuizQuestions 14 / 14");
                break;
        }
    }

    /**
     * Check the boolean value of userChooseCorrect.
     * @param userChooseCorrect The boolean value of userChooseCorrect.
     */
    int correct = 0;
    public void checkAnswer(boolean userChooseCorrect) {
        boolean answerIsTrue = quizQuestionsBank[currentQuestionIndex].isAnswerTrue();
        int toastMessageId;
        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
            correct++;
        } else {
            toastMessageId = R.string.wrong_answer;
        }
        Toast.makeText(Quiz2.this, toastMessageId, Toast.LENGTH_SHORT).show();
        nextButton.setVisibility(View.VISIBLE);
    }
}