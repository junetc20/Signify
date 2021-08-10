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
 * A class that represents the first screen within the third learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Numbers1 extends AppCompatActivity {

    VideoView noVideo1;
    VideoView noVideo2;
    ImageView exitButton8;
    ImageView nextArrow7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers1);

        /**
         * Constructor for objects of class Numbers1.
         */
        exitButton8 = findViewById(R.id.exitButton8);
        nextArrow7 = findViewById(R.id.nextArrow7);

        noVideo1 = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.no_video_one;
        Uri uri = Uri.parse(videoPath);
        noVideo1.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        noVideo1.setMediaController(mediaController);
        mediaController.setAnchorView(noVideo1);
        noVideo1.seekTo(3);

        noVideo2 = findViewById(R.id.videoView2);
        String videoPath2 = "android.resource://" + getPackageName() + "/" + R.raw.no_video_two;
        Uri uri2 = Uri.parse(videoPath2);
        noVideo2.setVideoURI(uri2);
        MediaController mediaController2 = new MediaController(this);
        noVideo2.setMediaController(mediaController2);
        mediaController2.setAnchorView(noVideo2);
        noVideo2.seekTo(3);

        /**
         * Set the view from clicking exitButton8.
         * @param v the onClickListener View.
         */
        exitButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers1.this, Home.class));
            }
        });

        /**
         * Set the view from clicking nextArrow7.
         * @param v the onClickListener View.
         */
        nextArrow7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers1.this, Numbers2.class));
            }
        });
    }
}
