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
 * A class that represents the sixth screen within the fourth learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Convo6 extends AppCompatActivity {

    ImageView exitButton19;
    VideoView videoView17;
    VideoView videoView18;
    ImageView nextArrow18;
    ImageView backArrow14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_6);

        /**
         * Constructor for objects of class Convo6.
         */
        exitButton19 = findViewById(R.id.exitButton19);
        nextArrow18 = findViewById(R.id.nextArrow18);
        backArrow14 = findViewById(R.id.backArrow14);

        videoView17 = findViewById(R.id.videoView17);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_six;
        Uri uri = Uri.parse(videoPath);
        videoView17.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView17.setMediaController(mediaController);
        mediaController.setAnchorView(videoView17);
        videoView17.seekTo(3);

        videoView18 = findViewById(R.id.videoView18);
        String videoPath1 = "android.resource://" + getPackageName() + "/" + R.raw.intro_video_seven;
        Uri uri1 = Uri.parse(videoPath1);
        videoView18.setVideoURI(uri1);
        MediaController mediaController1 = new MediaController(this);
        videoView18.setMediaController(mediaController1);
        mediaController1.setAnchorView(videoView18);
        videoView18.seekTo(3);

        /**
         * Set the view from clicking exitButton19.
         * @param v the onClickListener View.
         */
        exitButton19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo6.this, Home.class));
            }
        });

        /**
         * Set the view from clicking nextArrow18.
         * @param v the onClickListener View.
         */
        nextArrow18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo6.this, Convo7.class));
            }
        });

        /**
         * Set the view from clicking backArrow14.
         * @param v the onClickListener View.
         */
        backArrow14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo6.this, Convo5.class));
            }
        });
    }
}
