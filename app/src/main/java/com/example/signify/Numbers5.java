package com.example.signify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Numbers5 extends AppCompatActivity {

    // Fields
    VideoView noVideo8;
    VideoView noVideo9;
    ImageView exitButton12;
    ImageView nextArrow12;
    ImageView backArrow8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers2);

        // Constructor
        exitButton12 = findViewById(R.id.exitButton12);
        nextArrow12 = findViewById(R.id.nextArrow12);
        backArrow8 = findViewById(R.id.backArrow8);

        // Make eighth number video playable
        noVideo8 = findViewById(R.id.videoView8);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.no_video_eight;
        Uri uri = Uri.parse(videoPath);
        noVideo8.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        noVideo8.setMediaController(mediaController);
        mediaController.setAnchorView(noVideo8);
        noVideo8.seekTo(3);

        // Make ninth number video playable
        noVideo9 = findViewById(R.id.videoView9);
        String videoPath2 = "android.resource://" + getPackageName() + "/" + R.raw.no_video_nine;
        Uri uri2 = Uri.parse(videoPath2);
        noVideo9.setVideoURI(uri2);
        MediaController mediaController2 = new MediaController(this);
        noVideo9.setMediaController(mediaController2);
        mediaController2.setAnchorView(noVideo9);
        noVideo9.seekTo(3);

        // Exit button - returns to home page
        exitButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers5.this, Home.class));
            }
        });

        // Next arrow - takes user to Numbers 6 screen
        nextArrow12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers5.this, Numbers6.class));
            }
        });

        // Back arrow - takes user to Numbers 4 screen
        backArrow8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers5.this, Numbers4.class));
            }
        });
    }
}
