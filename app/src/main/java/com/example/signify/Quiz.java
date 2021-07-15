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

public class Quiz extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    public void onClick(View v) {

        // Fields
        private Button answer1;
        private Button answer2;
        private Button answer3;
        private Button answer4;
        private ImageView quizImage;
        private TextView questionCountDisplay;
        private Button nextButton;

        // Array to hold questions (UPDATE)
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




        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        quizImage = findViewById(R.id.quizImage);
        questionCountDisplay = findViewById(R.id.questionCountDisplay);
        nextButton = findViewById(R.id.nextButton);

    }
}
