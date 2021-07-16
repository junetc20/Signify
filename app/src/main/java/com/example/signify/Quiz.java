package com.example.signify;

  import android.content.Intent;
  import android.os.Bundle;
  import android.view.View;
  import android.widget.Button;
  import android.widget.ImageView;
  import android.widget.TextView;
  import android.widget.Toast;
  import androidx.appcompat.app.AppCompatActivity;

public class Quiz extends AppCompatActivity {

    // Fields
    Button answer1;
    Button answer2;
    Button answer3;
    Button answer4;
    ImageView quizImage;
    TextView questionCountDisplay;
    Button nextButton;
    ImageView exitButtonQuiz;
    Button completeButton2;

/*
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
    }; */

    // Linking this class with an activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Constructor
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        quizImage = findViewById(R.id.quizImage);
        questionCountDisplay = findViewById(R.id.questionCountDisplay);
        nextButton = findViewById(R.id.nextButton);
        exitButtonQuiz = findViewById(R.id.exitButtonQuiz);
        completeButton2 = findViewById(R.id.completeButton2);

        // Exit button - returns to home page
        exitButtonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz.this, Home.class));
            }
        });

        // Complete button - returns to home page at end of quiz
        completeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz.this, Home.class));
            }
        });
    }
}