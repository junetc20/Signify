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
 * A class that represents the second screen within the second learning section of Signify.
 * Users can use this screen to view learning concepts.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Alphabet2 extends AppCompatActivity {

    ImageView exitButton4;
    ImageView nextArrow2;
    ImageView backArrow;
    VideoView alphabetVid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet2);

        /**
         * Constructor for objects of class Alphabet2.
         */
        exitButton4 = findViewById(R.id.exitButton4);
        nextArrow2 = findViewById(R.id.nextArrow2);
        backArrow = findViewById(R.id.backArrow);

        // Make alphabet video playable
        alphabetVid = findViewById(R.id.alphabetVid);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.alphabet_video;
        Uri uri = Uri.parse(videoPath);
        alphabetVid.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        alphabetVid.setMediaController(mediaController);
        mediaController.setAnchorView(alphabetVid);
        alphabetVid.seekTo(3);

        /**
         * Set the view from clicking exitButton4.
         * @param v the onClickListener View.
         */
        exitButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alphabet2.this, Home.class));
            }
        });

        /**
         * Set the view from clicking nextArrow2.
         * @param v the onClickListener View.
         */
        nextArrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alphabet2.this, Quiz2.class));
                if (DataHolder.getPercentageComplete2() < 60) {
                    DataHolder.setPercentageComplete2(60);
                }
            }
        });

        /**
         * Set the view from clicking backArrow.
         * @param v the onClickListener View.
         */
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Alphabet2.this, Alphabet1.class));
            }
        });
    }
}