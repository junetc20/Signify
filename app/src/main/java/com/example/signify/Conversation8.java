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
 * A class that represents the eighth screen within the fourth learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Conversation8 extends AppCompatActivity {

    private ImageView exitButton21;
    private VideoView videoView19;
    private ImageView nextArrow20;
    private ImageView backArrow16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_8);

        /**
         * Constructor for objects of class Conversation8.
         */
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

        /**
         * Set the view from clicking exitButton21.
         * @param v the onClickListener View.
         */
        exitButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Conversation8.this, Home.class));
                DataHolder.setActivityCount4(8);
            }
        });

        /**
         * Set the view from clicking nextArrow20.
         * @param v the onClickListener View.
         */
        nextArrow20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Conversation8.this, Quiz4.class));
                if (DataHolder.getPercentageComplete4() < 45) {
                    DataHolder.setPercentageComplete4(45);
                }
            }
        });

        /**
         * Set the view from clicking backArrow16.
         * @param v the onClickListener View.
         */
        backArrow16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Conversation8.this, Conversation7.class));
            }
        });
    }
}
