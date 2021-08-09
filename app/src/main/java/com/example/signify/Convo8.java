package com.example.signify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Convo8 extends AppCompatActivity {

    // Fields
    ImageView exitButton21;
    VideoView videoView19;
    ImageView nextArrow20;
    ImageView backArrow16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_8);

        // Constructor
        exitButton21 = findViewById(R.id.exitButton21);
        nextArrow20 = findViewById(R.id.nextArrow20);
        backArrow16 = findViewById(R.id.backArrow16);

        videoView19 = findViewById(R.id.videoView19);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_eight;
        Uri uri = Uri.parse(videoPath);
        videoView19.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView19.setMediaController(mediaController);
        mediaController.setAnchorView(videoView19);
        videoView19.seekTo(3);

        exitButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo8.this, Home.class));
            }
        });

        nextArrow20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo8.this, Quiz4.class));
            }
        });

        backArrow16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo8.this, Convo7.class));
            }
        });
    }
}
