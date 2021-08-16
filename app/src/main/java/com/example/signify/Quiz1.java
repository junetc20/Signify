package com.example.signify;

  import com.example.signify.Home;

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
 * A class that represents the quiz for the first learning section of Signify.
 * Users can use this screen to test knowledge of learned concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Quiz1 extends AppCompatActivity {

    MultipleChoiceQ questionLibrary = new MultipleChoiceQ();

    private Button answer1;
    private Button answer2;
    private Button answer3;
    private TextView questionCountDisplay;
    private Button nextButton2;
    private ImageView exitButtonQuiz;
    private Button completeButton2;
    private TextView questionText2;
    private String answer;
    private int questionCount = 1;
    private int currentQuestionNumber = 0;
    private TextView resultText2;
    private ImageView resultImage2;
    int score = 0;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_1);

        /**
         * Constructor for objects of class Quiz1.
         */
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

        // Setting initial question up when quiz is opened
        questionText2.setText(MultipleChoiceQ.getQuestion(currentQuestionNumber));
        answer1.setText(MultipleChoiceQ.getChoice1(currentQuestionNumber));
        answer2.setText(MultipleChoiceQ.getChoice2(currentQuestionNumber));
        answer3.setText(MultipleChoiceQ.getChoice3(currentQuestionNumber));
        questionCountDisplay.setText("QuizQuestions " + questionCount + "/5");

        /**
         * Set the view from clicking exitButtonQuiz.
         * @param v the onClickListener View.
         */
        exitButtonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz1.this, Home.class));
                DataHolder.setActivityCount1(5);
            }
        });

        /**
         * Set the view from clicking completeButton2.
         * @param v the onClickListener View.
         */
        completeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quiz1.this, Home.class));
                DataHolder.setCompleteButton2Clicked(true);
                DataHolder.setLevel2ButtonClickable(true);
                if (DataHolder.getPercentageComplete1() < 100) {
                    DataHolder.setPercentageComplete1(100);
                }
                DataHolder.setActivityCount1(0);
            }
        });

        /**
         * Set the view from clicking nextButton2.
         * @param v the onClickListener View.
         */
        nextButton2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
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
                }
            }
        });

        /**
         * Set the view from clicking answer1.
         * @param v the onClickListener View.
         */
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getText() == answer) {
                    score++;
                    Toast.makeText(Quiz1.this, "correct!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Quiz1.this, "incorrect!", Toast.LENGTH_SHORT).show();
                }
                answer1.setVisibility(View.INVISIBLE);
                answer2.setVisibility(View.INVISIBLE);
                answer3.setVisibility(View.INVISIBLE);
                nextButton2.setVisibility(View.VISIBLE);
            }
        });

        /**
         * Set the view from clicking answer2.
         * @param v the onClickListener View.
         */
        answer2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (answer2.getText() == answer) {
                    score++;
                    Toast.makeText(Quiz1.this, "correct!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Quiz1.this, "incorrect!", Toast.LENGTH_SHORT).show();
                }
                answer1.setVisibility(View.INVISIBLE);
                answer2.setVisibility(View.INVISIBLE);
                answer3.setVisibility(View.INVISIBLE);
                nextButton2.setVisibility(View.VISIBLE);
            }
        });

        /**
         * Set the view from clicking answer3.
         * @param v the onClickListener View.
         */
        answer3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (answer3.getText() == answer) {
                    score++;
                    Toast.makeText(Quiz1.this, "correct!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Quiz1.this, "incorrect!", Toast.LENGTH_SHORT).show();
                }
                answer1.setVisibility(View.INVISIBLE);
                answer2.setVisibility(View.INVISIBLE);
                answer3.setVisibility(View.INVISIBLE);
                nextButton2.setVisibility(View.VISIBLE);
            }
        });
    }

    /**
     * Update fields for quiz layout when this function is called.
     */
    @SuppressLint("SetTextI18n")
    public void updateQuestion() {
        currentQuestionNumber++;
        questionCount++;
        questionCountDisplay.setText("QuizQuestions " + questionCount + "/5");
        questionText2.setText(MultipleChoiceQ.getQuestion(currentQuestionNumber));
        answer1.setText(MultipleChoiceQ.getChoice1(currentQuestionNumber));
        answer2.setText(MultipleChoiceQ.getChoice2(currentQuestionNumber));
        answer3.setText(MultipleChoiceQ.getChoice3(currentQuestionNumber));
        answer = MultipleChoiceQ.getCorrectAns(currentQuestionNumber);
    }
}