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

public class Quiz4 extends AppCompatActivity
        implements View.OnClickListener {

    // Quiz for section 4

    // Fields
    private Button falseButton3;
    private Button trueButton3;
    private ImageView exitButtonQuiz4;
    private VideoView quizVideo1;
    private ImageView resultImage4;
    private TextView resultText3;
    private TextView questionCountDisplay4;
    private TextView questionText4;
    private int currentQuestionIndex = 0;
    private Button nextButton4;
    private Button completeButton4;
    Button level4Button;

    // Array to hold questions
    public Question[] questionBank = new Question[]{
            new Question(R.string.not_good, false),
            new Question(R.string.please, true),
            new Question(R.string.meet, true),
            new Question(R.string.good, true),
            new Question(R.string.thank_you, false),
            new Question(R.string.How, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_4);

        // Constructor
        quizVideo1 = findViewById(R.id.quizVideo1);
        resultImage4 = findViewById(R.id.resultImage4);
        resultText3 = findViewById(R.id.resultText3);
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

        // Exit button - returns to home page
        exitButtonQuiz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz4.this, Home.class));
            }
        });

        // Complete button - returns to home page
        completeButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz4.this, Home.class));
            }
        });
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n", "ResourceAsColor"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.trueButton:
                checkAnswer(true);
                trueButton3.setVisibility(View.INVISIBLE);
                falseButton3.setVisibility(View.INVISIBLE);
                break;

            case R.id.falseButton:
                checkAnswer(false);
                trueButton3.setVisibility(View.INVISIBLE);
                falseButton3.setVisibility(View.INVISIBLE);
                break;

            case R.id.nextButton:
                if (currentQuestionIndex < 5) {
                    nextButton4.setVisibility(View.INVISIBLE);
                    trueButton3.setVisibility(View.VISIBLE);
                    falseButton3.setVisibility(View.VISIBLE);
                    currentQuestionIndex++;
                    updateQuestion();
                }
                else {
                    nextButton4.setVisibility(View.INVISIBLE);
                    trueButton3.setVisibility(View.INVISIBLE);
                    falseButton3.setVisibility(View.INVISIBLE);
                    resultImage4.setVisibility(View.VISIBLE);
                    resultText3.setVisibility(View.VISIBLE);
                    completeButton4.setVisibility(View.VISIBLE);
                    resultText3.setText(correct + "/6");
                    level4Button.setText(R.string.revisit);
                    level4Button.setBackgroundColor(R.color.purple);
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
                String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_four;
                Uri uri = Uri.parse(videoPath);
                quizVideo1.setVideoURI(uri);
                MediaController mediaController = new MediaController(this);
                quizVideo1.setMediaController(mediaController);
                mediaController.setAnchorView(quizVideo1);
                quizVideo1.seekTo(3);
                questionCountDisplay4.setText("Question 1 / 6");
                break;
            case 1:
                String videoPath1 = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_six;
                Uri uri1 = Uri.parse(videoPath1);
                quizVideo1.setVideoURI(uri1);
                MediaController mediaController1 = new MediaController(this);
                quizVideo1.setMediaController(mediaController1);
                mediaController1.setAnchorView(quizVideo1);
                quizVideo1.seekTo(3);
                questionCountDisplay4.setText("Question 2 / 6");
                break;
            case 2:
                String videoPath2 = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_eight;
                Uri uri2 = Uri.parse(videoPath2);
                quizVideo1.setVideoURI(uri2);
                MediaController mediaController2 = new MediaController(this);
                quizVideo1.setMediaController(mediaController2);
                mediaController2.setAnchorView(quizVideo1);
                quizVideo1.seekTo(3);
                questionCountDisplay4.setText("Question 3 / 6");
                break;
            case 3:
                String videoPath3 = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_four;
                Uri uri3 = Uri.parse(videoPath3);
                quizVideo1.setVideoURI(uri3);
                MediaController mediaController3 = new MediaController(this);
                quizVideo1.setMediaController(mediaController3);
                mediaController3.setAnchorView(quizVideo1);
                quizVideo1.seekTo(3);
                questionCountDisplay4.setText("Question 4 / 6");
                break;
            case 4:
                String videoPath4 = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_six;
                Uri uri4 = Uri.parse(videoPath4);
                quizVideo1.setVideoURI(uri4);
                MediaController mediaController4 = new MediaController(this);
                quizVideo1.setMediaController(mediaController4);
                mediaController4.setAnchorView(quizVideo1);
                quizVideo1.seekTo(3);
                questionCountDisplay4.setText("Question 5 / 6");
                break;
            case 5:
                String videoPath5 = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_three;
                Uri uri5 = Uri.parse(videoPath5);
                quizVideo1.setVideoURI(uri5);
                MediaController mediaController5 = new MediaController(this);
                quizVideo1.setMediaController(mediaController5);
                mediaController5.setAnchorView(quizVideo1);
                quizVideo1.seekTo(3);
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
        }
        else {
            toastMessageId = R.string.wrong_answer;
        }
        Toast.makeText(Quiz4.this, toastMessageId, Toast.LENGTH_SHORT).show();
        nextButton4.setVisibility(View.VISIBLE);
    }
}
