package com.example.signify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Convo3 extends AppCompatActivity {

    // Fields
    ImageView exitButton16;
    VideoView videoView14;
    ImageView nextArrow15;
    ImageView backArrow11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_3);

        // Constructor
        exitButton16 = findViewById(R.id.exitButton16);
        nextArrow15 = findViewById(R.id.nextArrow15);
        backArrow11 = findViewById(R.id.backArrow11);

        videoView14 = findViewById(R.id.videoView14);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_five;
        Uri uri = Uri.parse(videoPath);
        videoView14.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView14.setMediaController(mediaController);
        mediaController.setAnchorView(videoView14);
        videoView14.seekTo(3);

        exitButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo3.this, Home.class));
            }
        });

        nextArrow15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo3.this, Convo4.class));
            }
        });

        backArrow11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo3.this, Convo2.class));
            }
        });
    }
}
