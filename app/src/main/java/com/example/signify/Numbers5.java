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
 * A class that represents the fifth screen within the third learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Numbers5 extends AppCompatActivity {

    private VideoView noVideo8;
    private VideoView noVideo9;
    private ImageView exitButton12;
    private ImageView nextArrow12;
    private ImageView backArrow8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers5);

        /**
         * Constructor for objects of class Numbers5.
         */
        exitButton12 = findViewById(R.id.exitButton12);
        nextArrow12 = findViewById(R.id.nextArrow12);
        backArrow8 = findViewById(R.id.backArrow8);

        noVideo8 = findViewById(R.id.videoView8);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.no_video_eight;
        Uri uri = Uri.parse(videoPath);
        noVideo8.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        noVideo8.setMediaController(mediaController);
        mediaController.setAnchorView(noVideo8);
        noVideo8.seekTo(3);

        noVideo9 = findViewById(R.id.videoView9);
        String videoPath2 = "android.resource://" + getPackageName() + "/" + R.raw.no_video_nine;
        Uri uri2 = Uri.parse(videoPath2);
        noVideo9.setVideoURI(uri2);
        MediaController mediaController2 = new MediaController(this);
        noVideo9.setMediaController(mediaController2);
        mediaController2.setAnchorView(noVideo9);
        noVideo9.seekTo(3);

        /**
         * Set the view from clicking exitButton12.
         * @param v the onClickListener View.
         */
        exitButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers5.this, Home.class));
                DataHolder.setActivityCount3(5);
            }
        });

        /**
         * Set the view from clicking nextArrow12.
         * @param v the onClickListener View.
         */
        nextArrow12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers5.this, Numbers6.class));
                if (DataHolder.getPercentageComplete3() < 60) {
                    DataHolder.setPercentageComplete3(60);
                }
            }
        });

        /**
         * Set the view from clicking backArrow8.
         * @param v the onClickListener View.
         */
        backArrow8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers5.this, Numbers4.class));
            }
        });
    }
}
