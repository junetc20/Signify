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
 * A class that represents the third screen within the second learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Numbers3 extends AppCompatActivity {

    VideoView noVideo4;
    VideoView noVideo5;
    ImageView exitButton10;
    ImageView nextArrow9;
    ImageView backArrow6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers3);

        /**
         * Constructor for objects of class Numbers3.
         */
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


        /**
         * Set the view from clicking exitButton10.
         * @param v the onClickListener View.
         */
        exitButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers3.this, Home.class));
            }
        });

        /**
         * Set the view from clicking nextArrow9.
         * @param v the onClickListener View.
         */
        nextArrow9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers3.this, Numbers4.class));
            }
        });

        /**
         * Set the view from clicking backArrow6.
         * @param v the onClickListener View.
         */
        backArrow6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers3.this, Numbers2.class));
            }
        });
    }
}
