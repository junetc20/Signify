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
 * A class that represents the quiz for the third learning section of Signify.
 * Users can use this screen to test knowledge of learned concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Quiz3 extends AppCompatActivity
        implements View.OnClickListener {

    private Button falseButton2;
    private Button trueButton2;
    private ImageView exitButtonQuiz3;
    private VideoView quizVideo;
    private ImageView resultImage3;
    private TextView resultText3;
    private TextView questionCountDisplay3;
    private TextView questionText3;
    private int currentQuestionIndex = 0;
    private Button nextButton3;
    private Button completeButton3;
    private Button level3Button;

    // Array to hold questions
    public Question[] questionBank = new Question[]{
            new Question(R.string.fifteen, true),
            new Question(R.string.eleven, true),
            new Question(R.string.thirty_three, false),
            new Question(R.string.fifty, true),
            new Question(R.string.twelve, false),
            new Question(R.string.forty_two, true),
            new Question(R.string.thirty_two, false),
            new Question(R.string.twenty_six, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_3);

        /**
         * Constructor for objects of class Quiz3.
         */
        resultImage3 = findViewById(R.id.resultImage3);
        resultText3 = findViewById(R.id.resultText3);
        trueButton2 = findViewById(R.id.trueButton2);
        falseButton2 = findViewById(R.id.falseButton2);
        exitButtonQuiz3 = findViewById(R.id.exitButtonQuiz3);
        questionCountDisplay3 = findViewById(R.id.questionCountDisplay3);
        questionText3 = findViewById(R.id.questionText3);
        nextButton3 = findViewById(R.id.nextButton3);
        completeButton3 = findViewById(R.id.completeButton3);
        level3Button = findViewById(R.id.level3Button);

        trueButton2.setOnClickListener(this);
        falseButton2.setOnClickListener(this);
        nextButton3.setOnClickListener(this);

        quizVideo = findViewById(R.id.quizVideo);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.no_assess_one;
        Uri uri = Uri.parse(videoPath);
        quizVideo.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        quizVideo.setMediaController(mediaController);
        mediaController.setAnchorView(quizVideo);
        quizVideo.seekTo(3);

        /**
         * Set the view from clicking exitButtonQuiz3.
         * @param v the onClickListener View.
         */
        exitButtonQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz3.this, Home.class));
                DataHolder.setActivityCount3(7);
            }
        });

        /**
         * Set the view from clicking completeButton3.
         * @param v the onClickListener View.
         */
        completeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz3.this, Home.class));
                DataHolder.setCompleteButton3Clicked(true);
                DataHolder.setLevel4ButtonClickable(true);
                if (DataHolder.getPercentageComplete3() < 100) {
                    DataHolder.setPercentageComplete3(100);
                }
                DataHolder.setActivityCount3(0);
            }
        });
    }

    /**
     * Set the view from clicking trueButton2, falseButton2 or nextButton3.
     * @param v the onClickListener View.
     */
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.trueButton2:
                checkAnswer(true);
                trueButton2.setVisibility(View.INVISIBLE);
                falseButton2.setVisibility(View.INVISIBLE);
                break;

            case R.id.falseButton2:
                checkAnswer(false);
                trueButton2.setVisibility(View.INVISIBLE);
                falseButton2.setVisibility(View.INVISIBLE);
                break;

            case R.id.nextButton3:
                if (currentQuestionIndex < 7) {
                    nextButton3.setVisibility(View.INVISIBLE);
                    trueButton2.setVisibility(View.VISIBLE);
                    falseButton2.setVisibility(View.VISIBLE);
                    currentQuestionIndex++;
                    updateQuestion();
                } else {
                    nextButton3.setVisibility(View.INVISIBLE);
                    trueButton2.setVisibility(View.INVISIBLE);
                    falseButton2.setVisibility(View.INVISIBLE);
                    resultImage3.setVisibility(View.VISIBLE);
                    resultText3.setVisibility(View.VISIBLE);
                    completeButton3.setVisibility(View.VISIBLE);
                    resultText3.setText(correct + "/8");
                }
                break;
        }
    }

    /**
     * Update fields as currentQuestionIndex increases.
     */
    @SuppressLint("SetTextI18n")
    private void updateQuestion() {
        // setting the textview with new question
        questionText3.setText(questionBank[currentQuestionIndex].getAnswerResId());
        switch (currentQuestionIndex) {
            // Updating video content and question count display when the question changes
            case 0:
                quizVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.no_assess_one));
                quizVideo.start();
                questionCountDisplay3.setText("Question 1 / 8");
                break;
            case 1:
                quizVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.no_assess_two));
                quizVideo.start();
                questionCountDisplay3.setText("Question 2 / 8");
                break;
            case 2:
                quizVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.no_assess_three));
                quizVideo.start();
                questionCountDisplay3.setText("Question 3 / 8");
                break;
            case 3:
                quizVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.no_assess_four));
                quizVideo.start();
                questionCountDisplay3.setText("Question 4 / 8");
                break;
            case 4:
                quizVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.no_assess_five));
                quizVideo.start();
                questionCountDisplay3.setText("Question 5 / 8");
                break;
            case 5:
                quizVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.no_assess_six));
                quizVideo.start();
                questionCountDisplay3.setText("Question 6 / 8");
                break;
            case 6:
                quizVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.no_assess_seven));
                quizVideo.start();
                questionCountDisplay3.setText("Question 7 / 8");
                break;
            case 7:
                quizVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.no_assess_eight));
                quizVideo.start();
                questionCountDisplay3.setText("Question 8 / 8");
                break;
        }
    }

    /**
     * Check the boolean value of userChooseCorrect.
     * @param userChooseCorrect The boolean value of userChooseCorrect.
     */
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
        Toast.makeText(Quiz3.this, toastMessageId, Toast.LENGTH_SHORT).show();
        nextButton3.setVisibility(View.VISIBLE);
    }
}
