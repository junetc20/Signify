package com.example.signify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the quiz for the fourth learning section of Signify.
 * Users can use this screen to test knowledge of learned concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Quiz4 extends AppCompatActivity
        implements View.OnClickListener {

    private Button falseButton3;
    private Button trueButton3;
    private ImageView exitButtonQuiz4;
    private VideoView quizVideo1;
    private ImageView resultImage4;
    private TextView resultText4;
    private TextView questionCountDisplay4;
    private TextView questionText4;
    private int currentQuestionIndex = 0;
    private Button nextButton4;
    private Button completeButton4;
    private Button level4Button;

    // Array to hold questions
    public Question[] questionBank = new Question[]{
            new Question(R.string.not_good, false),
            new Question(R.string.please, true),
            new Question(R.string.meet, false),
            new Question(R.string.good, true),
            new Question(R.string.thank_you, false),
            new Question(R.string.How, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_4);

        /**
         * Constructor for objects of class Quiz4.
         */
        resultImage4 = findViewById(R.id.resultImage4);
        resultText4 = findViewById(R.id.resultText4);
        trueButton3 = findViewById(R.id.trueButton3);
        falseButton3 = findViewById(R.id.falseButton3);
        exitButtonQuiz4 = findViewById(R.id.exitButtonQuiz4);
        questionCountDisplay4 = findViewById(R.id.questionCountDisplay4);
        questionText4 = findViewById(R.id.questionText4);
        nextButton4 = findViewById(R.id.nextButton4);
        completeButton4 = findViewById(R.id.completeButton4);
        level4Button = findViewById(R.id.level4Button);

        trueButton3.setOnClickListener(this);
        falseButton3.setOnClickListener(this);
        nextButton4.setOnClickListener(this);

        quizVideo1 = findViewById(R.id.quizVideo1);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.convo_good;
        Uri uri = Uri.parse(videoPath);
        quizVideo1.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        quizVideo1.setMediaController(mediaController);
        mediaController.setAnchorView(quizVideo1);
        quizVideo1.seekTo(3);

        /**
         * Set the view from clicking exitButtonQuiz4.
         * @param v the onClickListener View.
         */
        exitButtonQuiz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz4.this, Home.class));
                DataHolder.setActivityCount4(9);
            }
        });

        /**
         * Set the view from clicking completeButton4.
         * @param v the onClickListener View.
         */
        completeButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz4.this, Home.class));
                DataHolder.setCompleteButton4Clicked(true);
                if (DataHolder.getPercentageComplete4() < 100) {
                    DataHolder.setPercentageComplete4(100);
                }
                DataHolder.setActivityCount4(0);
            }
        });
    }

    /**
     * Set the view from clicking trueButton3, falseButton3 or nextButton4.
     * @param v the onClickListener View.
     */
    @SuppressLint({"NonConstantResourceId", "SetTextI18n", "ResourceAsColor"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.trueButton3:
                checkAnswer(true);
                trueButton3.setVisibility(View.INVISIBLE);
                falseButton3.setVisibility(View.INVISIBLE);
                break;

            case R.id.falseButton3:
                checkAnswer(false);
                trueButton3.setVisibility(View.INVISIBLE);
                falseButton3.setVisibility(View.INVISIBLE);
                break;

            case R.id.nextButton4:
                if (currentQuestionIndex < 5) {
                    nextButton4.setVisibility(View.INVISIBLE);
                    trueButton3.setVisibility(View.VISIBLE);
                    falseButton3.setVisibility(View.VISIBLE);
                    currentQuestionIndex++;
                    updateQuestion();
                } else {
                    nextButton4.setVisibility(View.INVISIBLE);
                    trueButton3.setVisibility(View.INVISIBLE);
                    falseButton3.setVisibility(View.INVISIBLE);
                    resultImage4.setVisibility(View.VISIBLE);
                    resultText4.setVisibility(View.VISIBLE);
                    completeButton4.setVisibility(View.VISIBLE);
                    resultText4.setText(correct + "/6");
                }
                break;
        }
    }

    // Update question
    @SuppressLint("SetTextI18n")
    private void updateQuestion() {
        // setting the textview with new question
        questionText4.setText(questionBank[currentQuestionIndex].getAnswerResId());
        switch (currentQuestionIndex) {
            // Updating video content and question count display when the question changes
            case 0:
                quizVideo1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.convo_good));
                quizVideo1.start();
                questionCountDisplay4.setText("Question 1 / 6");
                break;
            case 1:
                quizVideo1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.convo_please));
                quizVideo1.start();
                questionCountDisplay4.setText("Question 2 / 6");
                break;
            case 2:
                quizVideo1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.convo_how_you));
                quizVideo1.start();
                questionCountDisplay4.setText("Question 3 / 6");
                break;
            case 3:
                quizVideo1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.convo_good));
                quizVideo1.start();
                questionCountDisplay4.setText("Question 4 / 6");
                break;
            case 4:
                quizVideo1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.convo_please));
                quizVideo1.start();
                questionCountDisplay4.setText("Question 5 / 6");
                break;
            case 5:
                quizVideo1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.convo_how_you));
                quizVideo1.start();
                questionCountDisplay4.setText("Question 6 / 6");
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
        } else {
            toastMessageId = R.string.wrong_answer;
        }
        Toast.makeText(Quiz4.this, toastMessageId, Toast.LENGTH_SHORT).show();
        nextButton4.setVisibility(View.VISIBLE);
    }
}
