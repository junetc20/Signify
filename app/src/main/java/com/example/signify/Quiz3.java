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

public class Quiz3 extends AppCompatActivity
    implements View.OnClickListener {

    // Quiz for section 3

    // Fields
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
    Button level3Button;

    // Array to hold questions
    public Question[] questionBank = new Question[]{
            new Question(R.string.fifteen, true),
            new Question(R.string.eleven, true),
            new Question(R.string.thirty_three, false),
            new Question(R.string.fifty, true),
            new Question(R.string.twelve, false),
            new Question(R.string.forty_two, false),
            new Question(R.string.thirty_two, false),
            new Question(R.string.twenty_six, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_3);

        // Constructor
        quizVideo = findViewById(R.id.quizVideo);
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

        // Exit button - returns to home page
        exitButtonQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz3.this, Home.class));
            }
        });

        // Complete button - returns to home page
        completeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz3.this, Home.class));
            }
        });
    }

        @SuppressLint({"NonConstantResourceId", "SetTextI18n", "ResourceAsColor"})
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.trueButton:
                    checkAnswer(true);
                    trueButton2.setVisibility(View.INVISIBLE);
                    falseButton2.setVisibility(View.INVISIBLE);
                    break;

                case R.id.falseButton:
                    checkAnswer(false);
                    trueButton2.setVisibility(View.INVISIBLE);
                    falseButton2.setVisibility(View.INVISIBLE);
                    break;

                case R.id.nextButton:
                    if (currentQuestionIndex < 7) {
                        nextButton3.setVisibility(View.INVISIBLE);
                        trueButton2.setVisibility(View.VISIBLE);
                        falseButton2.setVisibility(View.VISIBLE);
                        currentQuestionIndex++;
                        updateQuestion();
                    }
                    else {
                        nextButton3.setVisibility(View.INVISIBLE);
                        trueButton2.setVisibility(View.INVISIBLE);
                        falseButton2.setVisibility(View.INVISIBLE);
                        resultImage3.setVisibility(View.VISIBLE);
                        resultText3.setVisibility(View.VISIBLE);
                        completeButton3.setVisibility(View.VISIBLE);
                        resultText3.setText(correct + "/8");
                        level3Button.setText(R.string.revisit);
                        level3Button.setBackgroundColor(R.color.purple);
                    }
                    break;
            }
        }

        // Update question
        @SuppressLint("SetTextI18n")
        private void updateQuestion() {
            // setting the textview with new question
            questionText3.setText(questionBank[currentQuestionIndex].getAnswerResId());
            switch (currentQuestionIndex) {
                // Updating video content and question count display when the question changes
                case 0:
                    String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.no_assess_one;
                    Uri uri = Uri.parse(videoPath);
                    quizVideo.setVideoURI(uri);
                    MediaController mediaController = new MediaController(this);
                    quizVideo.setMediaController(mediaController);
                    mediaController.setAnchorView(quizVideo);
                    quizVideo.seekTo(3);
                    questionCountDisplay3.setText("Question 1 / 8");
                    break;
                case 1:
                    String videoPath1 = "android.resource://" + getPackageName() + "/" + R.raw.no_assess_two;
                    Uri uri1 = Uri.parse(videoPath1);
                    quizVideo.setVideoURI(uri1);
                    MediaController mediaController1 = new MediaController(this);
                    quizVideo.setMediaController(mediaController1);
                    mediaController1.setAnchorView(quizVideo);
                    quizVideo.seekTo(3);
                    questionCountDisplay3.setText("Question 2 / 8");
                    break;
                case 2:
                    String videoPath2 = "android.resource://" + getPackageName() + "/" + R.raw.no_assess_three;
                    Uri uri2 = Uri.parse(videoPath2);
                    quizVideo.setVideoURI(uri2);
                    MediaController mediaController2 = new MediaController(this);
                    quizVideo.setMediaController(mediaController2);
                    mediaController2.setAnchorView(quizVideo);
                    quizVideo.seekTo(3);
                    questionCountDisplay3.setText("Question 3 / 8");
                    break;
                case 3:
                    String videoPath3 = "android.resource://" + getPackageName() + "/" + R.raw.no_assess_four;
                    Uri uri3 = Uri.parse(videoPath3);
                    quizVideo.setVideoURI(uri3);
                    MediaController mediaController3 = new MediaController(this);
                    quizVideo.setMediaController(mediaController3);
                    mediaController3.setAnchorView(quizVideo);
                    quizVideo.seekTo(3);
                    questionCountDisplay3.setText("Question 4 / 8");
                    break;
                case 4:
                    String videoPath4 = "android.resource://" + getPackageName() + "/" + R.raw.no_assess_five;
                    Uri uri4 = Uri.parse(videoPath4);
                    quizVideo.setVideoURI(uri4);
                    MediaController mediaController4 = new MediaController(this);
                    quizVideo.setMediaController(mediaController4);
                    mediaController4.setAnchorView(quizVideo);
                    quizVideo.seekTo(3);
                    questionCountDisplay3.setText("Question 5 / 8");
                    break;
                case 5:
                    String videoPath5 = "android.resource://" + getPackageName() + "/" + R.raw.no_assess_six;
                    Uri uri5 = Uri.parse(videoPath5);
                    quizVideo.setVideoURI(uri5);
                    MediaController mediaController5 = new MediaController(this);
                    quizVideo.setMediaController(mediaController5);
                    mediaController5.setAnchorView(quizVideo);
                    quizVideo.seekTo(3);
                    questionCountDisplay3.setText("Question 6 / 8");
                    break;
                case 6:
                    String videoPath6 = "android.resource://" + getPackageName() + "/" + R.raw.no_assess_seven;
                    Uri uri6 = Uri.parse(videoPath6);
                    quizVideo.setVideoURI(uri6);
                    MediaController mediaController6 = new MediaController(this);
                    quizVideo.setMediaController(mediaController6);
                    mediaController6.setAnchorView(quizVideo);
                    quizVideo.seekTo(3);
                    questionCountDisplay3.setText("Question 7 / 8");
                    break;
                case 7:
                    String videoPath7 = "android.resource://" + getPackageName() + "/" + R.raw.no_assess_eight;
                    Uri uri7 = Uri.parse(videoPath7);
                    quizVideo.setVideoURI(uri7);
                    MediaController mediaController7 = new MediaController(this);
                    quizVideo.setMediaController(mediaController7);
                    mediaController7.setAnchorView(quizVideo);
                    quizVideo.seekTo(3);
                    questionCountDisplay3.setText("Question 8 / 8");
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
            Toast.makeText(Quiz3.this, toastMessageId, Toast.LENGTH_SHORT).show();
            nextButton3.setVisibility(View.VISIBLE);
        }
    }
