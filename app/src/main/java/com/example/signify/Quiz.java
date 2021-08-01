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

public class Quiz extends AppCompatActivity {

    // quiz for section 1

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
    private TextView resultText2;
    private ImageView resultImage2;
    Button level1Button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Constructor
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        questionCountDisplay = findViewById(R.id.questionCountDisplay);
        nextButton2 = findViewById(R.id.nextButton2);
        exitButtonQuiz = findViewById(R.id.exitButtonQuiz);
        completeButton2 = findViewById(R.id.completeButton2);
        questionText2 = findViewById(R.id.questionText2);
        resultText2 = findViewById(R.id.resultText2);
        resultImage2 = findViewById(R.id.resultImage2);
        level1Button = findViewById(R.id.level1Button);

        //Setting initial question up when quiz is opened
        questionText2.setText(MultipleChoiceQ.getQuestion(currentQuestionNumber));
        answer1.setText(MultipleChoiceQ.getChoice1(currentQuestionNumber));
        answer2.setText(MultipleChoiceQ.getChoice2(currentQuestionNumber));
        answer3.setText(MultipleChoiceQ.getChoice3(currentQuestionNumber));

        // Exit button returns user to home when clicked
        exitButtonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz.this, Home.class));
            }
        });

        // Exit button returns user to home when clicked
        completeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz.this, Home.class));
            }
        });

        // Next button updates text views so that the next question appears
        nextButton2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "ResourceAsColor"})
            @Override
            public void onClick(View v) {
                if (currentQuestionNumber < 4) {
                    updateQuestion();
                    nextButton2.setVisibility(View.INVISIBLE);
                    answer1.setVisibility(View.VISIBLE);
                    answer2.setVisibility(View.VISIBLE);
                    answer3.setVisibility(View.VISIBLE);
                }
                else {
                    nextButton2.setVisibility(View.INVISIBLE);
                    answer1.setVisibility(View.INVISIBLE);
                    answer2.setVisibility(View.INVISIBLE);
                    answer3.setVisibility(View.INVISIBLE);
                    questionText2.setVisibility(View.INVISIBLE);
                    resultImage2.setVisibility(View.VISIBLE);
                    completeButton2.setVisibility(View.VISIBLE);
                    resultText2.setVisibility(View.VISIBLE);
                    resultText2.setText(score + "/5");
                    level1Button.setText(R.string.revisit);
                    level1Button.setBackgroundColor(R.color.purple);
                }
            }
        });

        // Making answer 1 clickable
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getText() == answer) {
                    score++;
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
                    score++;
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
                    score++;
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

    //
    int score = 0;
    private void updateQuestion() {
        currentQuestionNumber++;
        questionText2.setText(MultipleChoiceQ.getQuestion(currentQuestionNumber));
        answer1.setText(MultipleChoiceQ.getChoice1(currentQuestionNumber));
        answer2.setText(MultipleChoiceQ.getChoice2(currentQuestionNumber));
        answer3.setText(MultipleChoiceQ.getChoice3(currentQuestionNumber));

        answer = MultipleChoiceQ.getCorrectAns(currentQuestionNumber);
    }
}