package app.wena.formulasaprende.juego.avanzado;


import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import app.wena.formulasaprende.R;


public class score extends AppCompatActivity {
    private TextView aScore, tScore, qScore,intento1;
    private TextView advancedScore, quickMathScore;
    private TextView timesPlayed, timeTaken, aTimeTaken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);


        aScore = findViewById(R.id.aScore);
        qScore = findViewById(R.id.qScore);
        advancedScore = findViewById(R.id.advancedScore);
        quickMathScore = findViewById(R.id.quickMathHigh);

        intento1 = findViewById(R.id.intento1);

        timesPlayed = findViewById(R.id.timesPlayed);
        aTimeTaken = findViewById(R.id.aTimeTaken);

        //preferencia par recivir la puntuacion
        SharedPreferences preferences = getSharedPreferences("highScore",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        int quickTimeHighScore = preferences.getInt("quickMathHighScore",0);
        int quickTimeHighScoreTotal = preferences.getInt("quickMathHighScoreWrong",0);


        int timesPlayedText = preferences.getInt("timesPlayed",0);
         int advancedHighScore = preferences.getInt("advancedHighScore",0);
        int advancedHighScoreTotal = preferences.getInt("advancedHighScoreTotal",0);
        int advancedTimeTaken = preferences.getInt("madvancedTimeTaken",1200);
         qScore.setText(getString(R.string.qScore,quickTimeHighScore,quickTimeHighScoreTotal));
        timesPlayed.setText(getString(R.string.timesPlayed,timesPlayedText));
//        tScore.setText(getString(R.string.tScore,timeTrialsHighScore));
       // timeTaken.setText(getString(R.string.timeTaken,timeTrialsTimeTaken));

        aScore.setText(getString(R.string.aScore,advancedHighScore,advancedHighScoreTotal));
        aTimeTaken.setText(getString(R.string.aTimeTaken,advancedTimeTaken));


/*
        if(timeTrialsTimeTaken == 1200){
            timeTaken.setText(getString(R.string.timeTaken,0));
        }

 */
intento1.setText(preferences.getString("highScore",getString(R.string.intentoPlayed)).toString());

        if(advancedTimeTaken == 1200){
            aTimeTaken.setText(getString(R.string.aTimeTaken,0));
        }

        touchToReset(quickMathScore,editor,quickMathScore,"quickMathDifference","quickMathHighScore","quickMathHighScoreWrong", "Quick Math Stats");
        touchToReset(advancedScore,editor,advancedScore,"advancedDifference","advancedHighScore","advancedHighScoreTotal", "Advanced Stats");
    }

    private void touchToReset(TextView viewToBeListened, final SharedPreferences.Editor edit, final TextView title, final String difference, final String highScore, final String total, final String titleText){
        viewToBeListened.setOnClickListener(new View.OnClickListener() {
            int touchFive = 5;
            @Override
            public void onClick(View v) {
                --touchFive;
                if(touchFive >= 0) {
                    title.setText("Tap " + Integer.toString(touchFive) + " more time to reset");
                }
                if(touchFive == 0){
                    if(titleText.equals("Advanced Stats")){
                        edit.putInt("madvancedTimeTaken",1200).apply();
                    }else if(titleText.equals("Timetrials Stats")){
                        edit.putInt("tTimeTaken",1200).apply();
                        edit.putFloat("hiddenElo",0).apply();
                    }
                    if(!titleText.equals("Timetrials Stats")) {
                        edit.putInt(difference, 100).apply();
                        edit.putInt(total,0).apply();
                    }
                    edit.putInt(highScore,0).apply();
                    title.setText(titleText);
                    Toast.makeText(score.this, "Tiempo reiniciadp", Toast.LENGTH_SHORT).show();
                    recreate();
                }
            }
        });
    }



}


