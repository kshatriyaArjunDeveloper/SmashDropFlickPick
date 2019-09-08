package com.example.android.smashdropflickpick;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        posnAEService();
    }


    // Checks which team got the current point.
    boolean gotPointTeamA;

    // Tells the game status
    String winningStatus;

    // Tracks the score for Team A
    int scoreTeamA = 0;

    // Tracks the score for Team B
    int scoreTeamB = 0;

    // Tracks the score continuously for Team A
    int rallyScoreTeamA = 0;

    // Tracks the score continuously for Team B
    int rallyScoreTeamB = 0;

    // Tracks the position of A1.
    String posnAEA1="A1";

    // Tracks the position of B1.
    String posnBEB1="B1";

    /**
     * Increase the score for Team A by 1 point.
     */
    public void pointForTeamA(View v) {
        if (scoreTeamA < 30) {
            scoreTeamA++;
            rallyScoreTeamA++;
            rallyScoreTeamB = 0;
            gotPointTeamA = true;
            displayScoreTeamA(scoreTeamA);
            displayWinningStatus();
            displayServiceSide();
            displayPlayerPosition();
            displayServiceStats();
        }
    }


    /**
     * Increase the score for Team B by 1 point.
     */
    public void pointForTeamB(View v) {
        if (scoreTeamB < 30) {
            scoreTeamB++;
            gotPointTeamA = false;
            rallyScoreTeamB++;
            rallyScoreTeamA = 0;
            displayScoreTeamB(scoreTeamB);
            displayWinningStatus();
            displayServiceSide();
            displayPlayerPosition();
            displayServiceStats();
        }
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void newGame(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        // Tracks the score continuously for Team A
         rallyScoreTeamA = 0;
        // Tracks the score continuously for Team B
         rallyScoreTeamB = 0;
        displayScoreTeamA(scoreTeamA);
        displayScoreTeamB(scoreTeamB);
        displayWinningStatus();
        displayServiceSide();
        displayPlayerPosition();
        displayServiceStats();
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayScoreTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.textView_teamAScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayScoreTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.textView_teamBScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the game status.
     */
    public void displayWinningStatus() {
        TextView winningStatusView = (TextView) findViewById(R.id.textView_winningStats);

        //  neither team is winning.
        if (((scoreTeamA - scoreTeamB) == 0) && (scoreTeamA > 0) && (scoreTeamB > 0)) {
            winningStatus = "Both teams are playing equally well !!!";
        }
        //  If game  has started.
        else if ((scoreTeamA - scoreTeamB) == 0) {
            winningStatus = "new game has started";
        }
        // team A won
        else if (((scoreTeamA > 20) && ((scoreTeamA - scoreTeamB) > 1)) || (scoreTeamA == 30)) {
            winningStatus = "congratulations team A won by score: " + scoreTeamA + "-" + scoreTeamB;
        }
        // team B won
        else if (((scoreTeamB > 20) && ((scoreTeamB - scoreTeamA) > 1)) || (scoreTeamB == 30)) {
            winningStatus = "congratulations team b won by score: " + scoreTeamB + "-" + scoreTeamA;
        }
        //  team A is winning.
        else if (((scoreTeamA - scoreTeamB) > 0)) {
            winningStatus = "team A is winning by : " + (scoreTeamA - scoreTeamB) + " points";
        }
        //  team B is winning.
        else if (((scoreTeamB - scoreTeamA) > 0)) {
            winningStatus = "team B is winning by : " + (scoreTeamB - scoreTeamA) + " points";
        }

        winningStatusView.setText(winningStatus);
    }

    /*
     * Displays the service FOR posnAE.
     */
    public void posnAEService() {
        TextView posnAE = (TextView) findViewById(R.id.textView_AE);
        TextView posnAO = (TextView) findViewById(R.id.tv_AO);
        TextView posnBE = (TextView) findViewById(R.id.tv_BE);
        TextView posnBO = (TextView) findViewById(R.id.tv_BO);

        // FOR GREEN COLOURING posnAE
        posnAE.setBackgroundColor(Color.parseColor("#4db6ac"));
        posnAE.setTextColor(Color.parseColor("#ffffff"));

        // FOR RED COLOURING posnBE
        posnBE.setBackgroundColor(Color.parseColor("#e57373"));
        posnBE.setTextColor(Color.parseColor("#ffffff"));

        // FOR DEFAULT COLOURING
        posnAO.setBackgroundColor(Color.parseColor("#ffffff"));
        posnAO.setTextColor(Color.parseColor("#546e7a"));
        posnBO.setBackgroundColor(Color.parseColor("#ffffff"));
        posnBO.setTextColor(Color.parseColor("#546e7a"));
    }

    /*
     * Displays the service FOR posnAO.
     */
    public void posnAOService() {
        TextView posnAE = (TextView) findViewById(R.id.textView_AE);
        TextView posnAO = (TextView) findViewById(R.id.tv_AO);
        TextView posnBE = (TextView) findViewById(R.id.tv_BE);
        TextView posnBO = (TextView) findViewById(R.id.tv_BO);

        // FOR GREEN COLOURING posnAO
        posnAO.setBackgroundColor(Color.parseColor("#4db6ac"));
        posnAO.setTextColor(Color.parseColor("#ffffff"));

        // FOR RED COLOURING posnBO
        posnBO.setBackgroundColor(Color.parseColor("#e57373"));
        posnBO.setTextColor(Color.parseColor("#ffffff"));

        // FOR DEFAULT COLOURING
        posnAE.setBackgroundColor(Color.parseColor("#ffffff"));
        posnAE.setTextColor(Color.parseColor("#546e7a"));
        posnBE.setBackgroundColor(Color.parseColor("#ffffff"));
        posnBE.setTextColor(Color.parseColor("#546e7a"));
    }

    /*
     * Displays the service FOR posnBE.
     */
    public void posnBEService() {
        TextView posnAE = (TextView) findViewById(R.id.textView_AE);
        TextView posnAO = (TextView) findViewById(R.id.tv_AO);
        TextView posnBE = (TextView) findViewById(R.id.tv_BE);
        TextView posnBO = (TextView) findViewById(R.id.tv_BO);

        // FOR GREEN COLOURING posnAE
        posnBE.setBackgroundColor(Color.parseColor("#4db6ac"));
        posnBE.setTextColor(Color.parseColor("#ffffff"));

        // FOR RED COLOURING posnBE
        posnAE.setBackgroundColor(Color.parseColor("#e57373"));
        posnAE.setTextColor(Color.parseColor("#ffffff"));

        // FOR DEFAULT COLOURING
        posnAO.setBackgroundColor(Color.parseColor("#ffffff"));
        posnAO.setTextColor(Color.parseColor("#546e7a"));
        posnBO.setBackgroundColor(Color.parseColor("#ffffff"));
        posnBO.setTextColor(Color.parseColor("#546e7a"));
    }

    /*
     * Displays the service FOR posnBO.
     */
    public void posnBOService() {
        TextView posnAE = (TextView) findViewById(R.id.textView_AE);
        TextView posnAO = (TextView) findViewById(R.id.tv_AO);
        TextView posnBE = (TextView) findViewById(R.id.tv_BE);
        TextView posnBO = (TextView) findViewById(R.id.tv_BO);

        // FOR GREEN COLOURING posnAO
        posnBO.setBackgroundColor(Color.parseColor("#4db6ac"));
        posnBO.setTextColor(Color.parseColor("#ffffff"));

        // FOR RED COLOURING posnBO
        posnAO.setBackgroundColor(Color.parseColor("#e57373"));
        posnAO.setTextColor(Color.parseColor("#ffffff"));

        // FOR DEFAULT COLOURING
        posnAE.setBackgroundColor(Color.parseColor("#ffffff"));
        posnAE.setTextColor(Color.parseColor("#546e7a"));
        posnBE.setBackgroundColor(Color.parseColor("#ffffff"));
        posnBE.setTextColor(Color.parseColor("#546e7a"));
    }

    /*
     * Displays the service Side.
     */
    public void displayServiceSide() {

        // FOR NEW GAME.
        if (scoreTeamA == 0 && scoreTeamB == 0) {
            posnAEService();
        }

        // Tells the service side if team A has to serve.
        else if (gotPointTeamA) {

            if (scoreTeamA > 0) {
                if ((scoreTeamA % 2) == 0) {// FOR EVEN SCORE.
                    // posnAE WILL BE USED FOR SERVING.
                    posnAEService();
                } else {
                    // posnAO WILL BE USED FOR SERVING.
                    posnAOService();
                }
            }
        }

        // Tells the service side if team B has to serve.
        else {

            if (scoreTeamB > 0) {
                if ((scoreTeamB % 2) == 0) {// FOR EVEN SCORE.
                    // posnBE WILL BE USED FOR SERVING.
                    posnBEService();
                } else {// FOR ODD SCORE.
                    // posnBO WILL BE USED FOR SERVING.
                    posnBOService();
                }
            }
        }
    }

    /*
     * Displays the player position.
     */
    public void displayPlayerPosition() {
        TextView posnAE = (TextView) findViewById(R.id.textView_AE);
        TextView posnAO = (TextView) findViewById(R.id.tv_AO);
        TextView posnBE = (TextView) findViewById(R.id.tv_BE);
        TextView posnBO = (TextView) findViewById(R.id.tv_BO);

        // FOR NEW GAME.
        if (scoreTeamA == 0 && scoreTeamB == 0) {
            posnAE.setText("A1");
            posnBE.setText("B1");
            posnAO.setText("A2");
            posnBO.setText("B2");
        }

        // Tells the player position if team A has to serve.
        else if (gotPointTeamA) {

            // FOR TEAM B=0 AND A=1.
            if (scoreTeamA == 1 && scoreTeamB == 0) {
                posnAE.setText("A2");
                posnAO.setText("A1");
            } else if (rallyScoreTeamA > 1) {
                if (posnAE.getText().equals(posnAEA1)) {
                    posnAE.setText("A2");
                    posnAO.setText("A1");
                } else {
                    posnAE.setText("A1");
                    posnAO.setText("A2");
                }
            }
        }

        // Tells the player position if team B has to serve.
        else {

            if (rallyScoreTeamB > 1) {
                if (posnBE.getText().equals(posnBEB1)) {
                    posnBE.setText("B2");
                    posnBO.setText("B1");
                } else {
                    posnBE.setText("B1");
                    posnBO.setText("B2");
                }
            }
        }
    }

    /*
     * Displays the service and pick for players.
     */
    public void displayServiceStats() {
        TextView posnAE = (TextView) findViewById(R.id.textView_AE);
        TextView posnAO = (TextView) findViewById(R.id.tv_AO);
        TextView posnBE = (TextView) findViewById(R.id.tv_BE);
        TextView posnBO = (TextView) findViewById(R.id.tv_BO);

        TextView textViewServiceStats = (TextView) findViewById(R.id.textView_serviceStats);

        // FOR NEW GAME.
        if (scoreTeamA == 0 && scoreTeamB == 0) {
            textViewServiceStats.setText("A1 will serve the first service\nB1 will pick the first service.  ");
        }

        else if (gotPointTeamA) {

            // FOR TEAM A IS TAKING POINT.
            if ((posnAE.getCurrentTextColor()==Color.parseColor("#ffffff") && posnAE.getText().equals(posnAEA1)) || (posnAO.getCurrentTextColor()==Color.parseColor("#ffffff") && posnAO.getText().equals(posnAEA1))){
                textViewServiceStats.setText("service by A1.");
            }
            else {
                textViewServiceStats.setText("service by A2.");
            }
                }

        else {

            // FOR TEAM B IS TAKING POINT.
            if ((posnBE.getCurrentTextColor()==Color.parseColor("#ffffff") && posnBE.getText().equals(posnBEB1)) || (posnBO.getCurrentTextColor()==Color.parseColor("#ffffff") && posnBO.getText().equals(posnBEB1))){
                textViewServiceStats.setText("service by B1.");
            }
            else {
                textViewServiceStats.setText("service by B2.");
            }
            }
        }
    }