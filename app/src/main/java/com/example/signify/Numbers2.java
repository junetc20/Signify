package com.example.signify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Numbers2 extends AppCompatActivity {


    // Fields
    VideoView noVideo3;
    ImageView exitButton9;
    ImageView nextArrow8;
    ImageView backArrow5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers2);

        // Constructor
        exitButton9 = findViewById(R.id.exitButton9);
        nextArrow8 = findViewById(R.id.nextArrow8);
        backArrow5 = findViewById(R.id.backArrow5);

        // Make third number video playable
        noVideo3 = findViewById(R.id.videoView3);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.no_video_three;
        Uri uri = Uri.parse(videoPath);
        noVideo3.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        noVideo3.setMediaController(mediaController);
        mediaController.setAnchorView(noVideo3);
        noVideo3.seekTo(3);


        // Exit button - returns to home page
        exitButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers2.this, Home.class));
            }
        });

        // Next arrow - takes user to Numbers 3 screen
        nextArrow8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers2.this, Numbers3.class));
            }
        });

        // Back arrow - takes user to Numbers 1 screen
        backArrow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers2.this, Numbers1.class));
            }
        });
    }
}
