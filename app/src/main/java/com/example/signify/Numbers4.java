package com.example.signify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Numbers4 extends AppCompatActivity {

    // Fields
    VideoView noVideo6;
    VideoView noVideo7;
    ImageView exitButton11;
    ImageView nextArrow10;
    ImageView backArrow7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers4);

        // Constructor
        exitButton11 = findViewById(R.id.exitButton11);
        nextArrow10 = findViewById(R.id.nextArrow10);
        backArrow7 = findViewById(R.id.backArrow7);

        // Make sixth number video playable
        noVideo6 = findViewById(R.id.videoView6);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.no_video_six;
        Uri uri = Uri.parse(videoPath);
        noVideo6.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        noVideo6.setMediaController(mediaController);
        mediaController.setAnchorView(noVideo6);
        noVideo6.seekTo(3);

        // Make seventh number video playable
        noVideo7 = findViewById(R.id.videoView7);
        String videoPath2 = "android.resource://" + getPackageName() + "/" + R.raw.no_video_seven;
        Uri uri2 = Uri.parse(videoPath2);
        noVideo7.setVideoURI(uri2);
        MediaController mediaController2 = new MediaController(this);
        noVideo7.setMediaController(mediaController2);
        mediaController2.setAnchorView(noVideo7);
        noVideo7.seekTo(3);


        // Exit button - returns to home page
        exitButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers4.this, Home.class));
            }
        });

        // Next arrow - takes user to Numbers 5 screen
        nextArrow10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers4.this, Numbers5.class));
            }
        });

        // Back arrow - takes user to Numbers 3 screen
        backArrow7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers4.this, Numbers3.class));
            }
        });
    }
}
