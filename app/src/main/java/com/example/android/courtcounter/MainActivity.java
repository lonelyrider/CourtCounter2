package com.example.android.courtcounter;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    /**
     * Creates a bridge between MainActitivity.java and XML file "activity_main.xml".
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connects Java with the toolbar from the XML
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Sets the basketball icon.
        getSupportActionBar().setIcon(R.drawable.icon_basketball);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Sets the Title and Subtitle in the toolbar
        getSupportActionBar().setTitle("Basketball Score");
        toolbar.setSubtitle("Never lose track again");

    }
    /** Creates options in the menu toolbar*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Creates the sharing button.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.share: // id of the item in menu_main.xml
                Intent shareIntent = new Intent(Intent.ACTION_SEND); //type of action send/receive
                shareIntent.setType("text/plain"); // This is the type of content shared text, video, audio
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "BASKETBALL SCORE COUNTER APP");
                /*We changed the methods for Display Score For Team A and Display Score For Team B into "public int" so it can retrieved as an integer.
                  We chose to "return score" at the end of those methods.*/

                /* HERE!!!*/
                int v1 = displayForTeamA(scoreTeamA); // returns score for Team A from the method displayForTeamA()
                /* HERE!!!*/
                int v2 = displayForTeamB(scoreTeamB); // returns score for Team B from the method displayForTeamB()

                /*  Next line writes the sharing content*/
                shareIntent.putExtra(Intent.EXTRA_TEXT, "BASKETBALL SCORE SHARING\nNever lose track again!\nOur score is\n" + "Team A: " + v1 + "\nvs.\n" + "Team B: " + v2 );
                startActivity(Intent.createChooser(shareIntent, "Share Via"));/*  When you choose where to share it e.g. gmail, Messenger, Whatsapp
                                                                                        it shows the message Share Via above the sharing layout*/
                break;
            default:
                break;

        }
        return true;
    }

    /**
     * Displays the given score for Team A. We use it in the next methods for displaying score.
     */
    public int displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
        return score; // you can call this method in a variable e.g. int v1 and int v2 !!!LOOK UP!!!
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void threePointsA (View view) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void twoPointsA (View view) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void onePointA (View view) {
        scoreTeamA = scoreTeamA +1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team B. We use it in the next methods for displaying score.
     */
    public int displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
        return score;
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void threePointsB (View view) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void twoPointsB (View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void onePointB (View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A. We use it in resetButton method.
     */
    public void resetScoreTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B. We use it in resetButton method.
     */
    public void resetScoreTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Resets score for Team A and Team B to zero.
     */
    public void resetButton (View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        resetScoreTeamA(scoreTeamA);
        resetScoreTeamB(scoreTeamB);
    }

    //onSaveInstanceState()
    //onRestoreInstanceState()

}