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

    MultipleChoiceQ questionLibrary = new MultipleChoiceQ();

    // Fields
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private TextView questionCountDisplay;
    private Button nextButton2;
    private ImageView exitButtonQuiz;
    private Button completeButton2;
    private TextView questionText2;
    private String answer;
    private int currentQuestionNumber = 0;
    private int score = 0;
    private TextView resultText2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        questionCountDisplay = findViewById(R.id.questionCountDisplay);
        nextButton2 = findViewById(R.id.nextButton2);
        exitButtonQuiz = findViewById(R.id.exitButtonQuiz);
        completeButton2 = findViewById(R.id.completeButton2);
        questionText2 = findViewById(R.id.questionText2);
        resultText2 = findViewById(R.id.resultText2);

        exitButtonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz.this, Home.class));
            }
        });

        nextButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
                nextButton2.setVisibility(View.INVISIBLE);
                answer1.setVisibility(View.VISIBLE);
                answer2.setVisibility(View.VISIBLE);
                answer3.setVisibility(View.VISIBLE);
            }
        });

        // Making answer 1 clickable
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getText() == answer) {
                    score = score + 1;
                    updateScore(score);
                    Toast.makeText(Quiz.this, "correct!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Quiz.this, "incorrect!", Toast.LENGTH_SHORT).show();
                }
                answer1.setVisibility(View.INVISIBLE);
                answer2.setVisibility(View.INVISIBLE);
                answer3.setVisibility(View.INVISIBLE);
                nextButton2.setVisibility(View.VISIBLE);
            }
        });

        // Making answer 2 clickable
        answer2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (answer2.getText() == answer) {
                    score = score + 1;
                    updateScore(score);
                    Toast.makeText(Quiz.this, "correct!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Quiz.this, "incorrect!", Toast.LENGTH_SHORT).show();
                }
                answer1.setVisibility(View.INVISIBLE);
                answer2.setVisibility(View.INVISIBLE);
                answer3.setVisibility(View.INVISIBLE);
                nextButton2.setVisibility(View.VISIBLE);
            }
        });

        // Making answer 3 clickable
        answer3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (answer3.getText() == answer) {
                    score = score + 1;
                    updateScore(score);
                    Toast.makeText(Quiz.this, "correct!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Quiz.this, "incorrect!", Toast.LENGTH_SHORT).show();
                }
                answer1.setVisibility(View.INVISIBLE);
                answer2.setVisibility(View.INVISIBLE);
                answer3.setVisibility(View.INVISIBLE);
                nextButton2.setVisibility(View.VISIBLE);
            }
        });
    }

    private void updateQuestion() {
        questionText2.setText(MultipleChoiceQ.getQuestion(currentQuestionNumber));
        answer1.setText(MultipleChoiceQ.getChoice1(currentQuestionNumber));
        answer2.setText(MultipleChoiceQ.getChoice2(currentQuestionNumber));
        answer3.setText(MultipleChoiceQ.getChoice3(currentQuestionNumber));

        answer = MultipleChoiceQ.getCorrectAns(currentQuestionNumber);
        currentQuestionNumber++;
    }

    private void updateScore(int score) {
        resultText2.setText(score);
    }
}