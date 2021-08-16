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
 * A class that represents the third screen within the fourth learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Convo3 extends AppCompatActivity {

    private ImageView exitButton16;
    private VideoView videoView14;
    private ImageView nextArrow15;
    private ImageView backArrow11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo_3);

        /**
         * Constructor for objects of class Convo3.
         */
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

        /**
         * Set the view from clicking exitButton16.
         * @param v the onClickListener View.
         */
        exitButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo3.this, Home.class));
                DataHolder.setActivityCount4(3);
            }
        });

        /**
         * Set the view from clicking nextArrow15.
         * @param v the onClickListener View.
         */
        nextArrow15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo3.this, Convo4.class));
                if (DataHolder.getPercentageComplete4() < 20) {
                    DataHolder.setPercentageComplete4(20);
                }
            }
        });

        /**
         * Set the view from clicking backArrow11.
         * @param v the onClickListener View.
         */
        backArrow11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Convo3.this, Convo2.class));
            }
        });
    }
}
