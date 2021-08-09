package com.example.signify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the second screen within the fourth learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Convo2 extends AppCompatActivity {

    ImageView exitButton15;
    VideoView videoView15;
    VideoView videoView16;
    ImageView nextArrow14;
    ImageView backArrow10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_2);

        /**
         * Constructor for objects of class Convo2.
         */
        exitButton15 = findViewById(R.id.exitButton15);
        nextArrow14 = findViewById(R.id.nextArrow14);
        backArrow10 = findViewById(R.id.backArrow10);

        videoView15 = findViewById(R.id.videoView15);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_three;
        Uri uri = Uri.parse(videoPath);
        videoView15.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView15.setMediaController(mediaController);
        mediaController.setAnchorView(videoView15);
        videoView15.seekTo(3);

        videoView16 = findViewById(R.id.videoView16);
        String videoPath1 = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_four;
        Uri uri1 = Uri.parse(videoPath1);
        videoView16.setVideoURI(uri1);
        MediaController mediaController1 = new MediaController(this);
        videoView16.setMediaController(mediaController1);
        mediaController1.setAnchorView(videoView16);
        videoView16.seekTo(3);

        /**
         * Set the view from clicking exitButton15.
         * @param v the onClickListener View.
         */
        exitButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo2.this, Home.class));
            }
        });

        /**
         * Set the view from clicking nextArrow14.
         * @param v the onClickListener View.
         */
        nextArrow14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo2.this, Convo3.class));
            }
        });

        /**
         * Set the view from clicking backArrow10.
         * @param v the onClickListener View.
         */
        backArrow10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo2.this, Convo1.class));
            }
        });
    }
}
