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
 * A class that represents the sixth screen within the third learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Numbers6 extends AppCompatActivity {

    private VideoView noVideo10;
    private VideoView noVideo11;
    private ImageView exitButton13;
    private ImageView nextArrow11;
    private ImageView backArrow9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers6);

        /**
         * Constructor for objects of class Numbers6.
         */
        exitButton13 = findViewById(R.id.exitButton13);
        nextArrow11 = findViewById(R.id.nextArrow11);
        backArrow9 = findViewById(R.id.backArrow9);

        noVideo10 = findViewById(R.id.videoView10);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.no_video_ten;
        Uri uri = Uri.parse(videoPath);
        noVideo10.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        noVideo10.setMediaController(mediaController);
        mediaController.setAnchorView(noVideo10);
        noVideo10.seekTo(3);

        noVideo11 = findViewById(R.id.videoView11);
        String videoPath2 = "android.resource://" + getPackageName() + "/" + R.raw.no_video_eleven;
        Uri uri2 = Uri.parse(videoPath2);
        noVideo11.setVideoURI(uri2);
        MediaController mediaController2 = new MediaController(this);
        noVideo11.setMediaController(mediaController2);
        mediaController2.setAnchorView(noVideo11);
        noVideo11.seekTo(3);

        /**
         * Set the view from clicking exitButton13.
         * @param v the onClickListener View.
         */
        exitButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers6.this, Home.class));
                DataHolder.setActivityCount3(6);
            }
        });

        /**
         * Set the view from clicking nextArrow11.
         * @param v the onClickListener View.
         */
        nextArrow11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers6.this, Quiz3.class));
                if (DataHolder.getPercentageComplete3() < 70) {
                    DataHolder.setPercentageComplete3(70);
                }
            }
        });

        /**
         * Set the view from clicking backArrow9.
         * @param v the onClickListener View.
         */
        backArrow9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Numbers6.this, Numbers5.class));
            }
        });
    }
}
