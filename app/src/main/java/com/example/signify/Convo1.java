package com.example.signify;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Convo1 extends AppCompatActivity {

    // Fields
    ImageView exitButton14;
    VideoView videoView12;
    VideoView videoView13;
    ImageView nextArrow13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_1);

        // Constructor
        exitButton14 = findViewById(R.id.exitButton14);
        nextArrow13 = findViewById(R.id.nextArrow13);

        videoView12 = findViewById(R.id.videoView12);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_one;
        Uri uri = Uri.parse(videoPath);
        videoView12.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView12.setMediaController(mediaController);
        mediaController.setAnchorView(videoView12);
        videoView12.seekTo(3);

        videoView13 = findViewById(R.id.videoView13);
        String videoPath1 = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_two;
        Uri uri1 = Uri.parse(videoPath1);
        videoView13.setVideoURI(uri1);
        MediaController mediaController1 = new MediaController(this);
        videoView13.setMediaController(mediaController1);
        mediaController1.setAnchorView(videoView13);
        videoView13.seekTo(3);

        exitButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo1.this, Home.class));
            }
        });

        nextArrow13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo1.this, Convo2.class));
            }
        });
    }

}
