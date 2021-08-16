package com.example.signify;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A class that represents the first screen within the fourth learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Conversation1 extends AppCompatActivity {

    private ImageView exitButton14;
    private VideoView videoView12;
    private VideoView videoView13;
    private ImageView nextArrow13;
    private Button beginButton4;
    private ImageView learningOutcomes4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_1);

        /**
         * Constructor for objects of class Conversation1.
         */
        exitButton14 = findViewById(R.id.exitButton14);
        nextArrow13 = findViewById(R.id.nextArrow13);
        beginButton4 = findViewById(R.id.beginButton4);
        learningOutcomes4 = findViewById(R.id.learningOutcomes4);

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

        /**
         * Set the view from clicking exitButton14.
         * @param v the onClickListener View.
         */
        exitButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Conversation1.this, Home.class));
                DataHolder.setActivityCount4(1);
            }
        });

        /**
         * Set the view from clicking nextArrow13.
         * @param v the onClickListener View.
         */
        nextArrow13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Conversation1.this, Conversation2.class));
                if (DataHolder.getPercentageComplete4() < 10) {
                    DataHolder.setPercentageComplete4(10);
                }
            }
        });

        /**
         * Set the view from clicking beginButton4.
         * @param v the onClickListener View.
         */
        beginButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                learningOutcomes4.setVisibility(View.INVISIBLE);
                beginButton4.setVisibility(View.INVISIBLE);
            }
        });
    }

}
