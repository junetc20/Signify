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
 * A class that represents the second screen within the third learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Numbers2 extends AppCompatActivity {

    VideoView noVideo3;
    ImageView exitButton9;
    ImageView nextArrow8;
    ImageView backArrow5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers2);

        /**
         * Constructor for objects of class Numbers2.
         */
        exitButton9 = findViewById(R.id.exitButton9);
        nextArrow8 = findViewById(R.id.nextArrow8);
        backArrow5 = findViewById(R.id.backArrow5);

        /*
        noVideo3 = findViewById(R.id.videoView3);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.no_video_three;
        Uri uri = Uri.parse(videoPath);
        noVideo3.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        noVideo3.setMediaController(mediaController);
        mediaController.setAnchorView(noVideo3);
        noVideo3.seekTo(3);
        */

        /**
         * Set the view from clicking exitButton9.
         * @param v the onClickListener View.
         */
        exitButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers2.this, Home.class));
            }
        });

        /**
         * Set the view from clicking nextArrow8.
         * @param v the onClickListener View.
         */
        nextArrow8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers2.this, Numbers3.class));
                if (DataHolder.getPercentageComplete3() < 30) {
                    DataHolder.setPercentageComplete3(30);
                }
            }
        });

        /**
         * Set the view from clicking backArrow5.
         * @param v the onClickListener View.
         */
        backArrow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers2.this, Numbers1.class));
            }
        });
    }
}
