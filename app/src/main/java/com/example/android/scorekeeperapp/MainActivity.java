package com.example.android.scorekeeperapp;

import android.content.Context;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int scoreTeamA, scoreTeamB;
    Chronometer gametimer, penalityTeamA,penalityTeamB;
    Button start, pause, reset, startA, startB, resetA, resetB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gametimer = (Chronometer) findViewById(R.id.gametimer);
        penalityTeamA = (Chronometer) findViewById(R.id.penalityTeamA);
        penalityTeamB = (Chronometer) findViewById(R.id.penalityTeamB);
        start = (Button) findViewById(R.id.startButton);
        pause = (Button) findViewById(R.id.pauseButton);
        reset = (Button) findViewById(R.id.resetButton);
        startA = (Button) findViewById(R.id.startAButton);
        startB = (Button) findViewById(R.id.startBButton);
        resetA = (Button) findViewById(R.id.resetAButton);
        resetB = (Button) findViewById(R.id.resetBButton);


        /**
         *perform click event on start button to start the game timer
         */
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gametimer.start();
            }
        });

        /**
         *perform click event on pause button to pause the game timer
         */
        pause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gametimer.stop();
            }
        });

        /**
         *perform click event on reset button to reset the game timer to 00:00
         */
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gametimer.setBase(SystemClock.elapsedRealtime());
            }
        });


        /**
         *perform click event on startA button to start the teamA's penality timer
         */
        penalityTeamA.setBase(SystemClock.elapsedRealtime());
        startA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                penalityTeamA.setBase(SystemClock.elapsedRealtime());
                penalityTeamA.start();
            }
        });

        /**
        *perform click event on startB button to start the teamB's penality timer
        */
        startB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                penalityTeamB.setBase(SystemClock.elapsedRealtime());
                penalityTeamB.start();
            }
        });

        /**
         *perform click event on reset teamA button to reset the teamA's penality timer to 00:00
         */
        resetA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                penalityTeamA.setBase(SystemClock.elapsedRealtime());

            }
        });

        /**
         *perform click event on reset teamB button to reset the teamB's penality timer to 00:00
         */
        resetB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                penalityTeamB.setBase(SystemClock.elapsedRealtime());

            }
        });


    }


    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1 ;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1 ;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Reset the score to both teams back to O points.
     */
    public void resetScore(View v) {
        scoreTeamA = 0 ;
        scoreTeamB = 0 ;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));

    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

}
