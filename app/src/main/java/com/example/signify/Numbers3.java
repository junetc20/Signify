package com.example.signify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Numbers3 extends AppCompatActivity {

    // Fields
    VideoView noVideo4;
    VideoView noVideo5;
    ImageView exitButton10;
    ImageView nextArrow9;
    ImageView backArrow6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers2);

        // Constructor
        exitButton10 = findViewById(R.id.exitButton10);
        nextArrow9 = findViewById(R.id.nextArrow9);
        backArrow6 = findViewById(R.id.backArrow6);

        // Make fourth number video playable
        noVideo4 = findViewById(R.id.videoView4);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.no_video_four;
        Uri uri = Uri.parse(videoPath);
        noVideo4.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        noVideo4.setMediaController(mediaController);
        mediaController.setAnchorView(noVideo4);
        noVideo4.seekTo(3);

        // Make fifth number video playable
        noVideo5 = findViewById(R.id.videoView5);
        String videoPath2 = "android.resource://" + getPackageName() + "/" + R.raw.no_video_five;
        Uri uri2 = Uri.parse(videoPath2);
        noVideo5.setVideoURI(uri2);
        MediaController mediaController2 = new MediaController(this);
        noVideo5.setMediaController(mediaController2);
        mediaController2.setAnchorView(noVideo5);
        noVideo5.seekTo(3);

        // Exit button - returns to home page
        exitButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers3.this, Home.class));
            }
        });

        // Next arrow - takes user to Numbers 4 screen
        nextArrow9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers3.this, Numbers4.class));
            }
        });

        // Back arrow - takes user to Numbers 2 screen
        backArrow6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers3.this, Numbers2.class));
            }
        });
    }
}
