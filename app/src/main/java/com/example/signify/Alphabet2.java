package com.example.signify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class Alphabet2 extends AppCompatActivity {

    // Fields
    ImageView exitButton4;
    ImageView nextArrow2;
    ImageView backArrow;
    VideoView alphabetVid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet2);

        // Constructor
        exitButton4 = findViewById(R.id.exitButton4);
        nextArrow2 = findViewById(R.id.nextArrow2);
        backArrow = findViewById(R.id.backArrow);

        // Make alphabet video playable
        alphabetVid = findViewById(R.id.alphabetVid);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.alphabet_video;
        Uri uri = Uri.parse(videoPath);
        alphabetVid.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        alphabetVid.setMediaController(mediaController);
        mediaController.setAnchorView(alphabetVid);
        alphabetVid.seekTo(3);

        // Exit button - returns to home page
        exitButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alphabet2.this, Home.class));
            }
        });

        // Next arrow - takes user to Quiz 2
        nextArrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alphabet2.this, Quiz2.class));
            }
        });

        // Back arrow - takes user to Alphabet 1
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alphabet2.this, Alphabet1.class));
            }
        });
    }
}