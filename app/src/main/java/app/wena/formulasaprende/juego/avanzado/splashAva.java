package app.wena.formulasaprende.juego.avanzado;

import app.wena.formulasaprende.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

 import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.Random;

import app.wena.formulasaprende.juego.LauncherActivity2;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class splashAva extends AppCompatActivity {
    private Button button0, button1, button2, button3;
    private TextView questionText, scoreView, winningMessage, scoreMessage, iqMessage;
    private int locationOfCorrectAnswer, score = 0,scoreincorrecta =0, numberOfQuestions = 0, musicLength = 0;
    private ArrayList<Integer> answers = new ArrayList<Integer>();
    private ConstraintLayout bg;
    private Animation buttonsInit;
    private Dialog scorePopUp;
    private Chronometer chronometer;
    private Chronometer scoreChronometer;
    private Boolean sqrt,sqr,cube,addition,subtraction,addmult,submult,adddiv,subdiv, mute, kidsmode, flashingText;
     private SharedPreferences scorePreference;
    SharedPreferences sharedPref;
    ImageButton muteButton;
    Boolean sonidox;

    private long pauseOffset;
    private InterstitialAd mInterstitialAd;
    Dialog epicDialog2;
    Button salir,seguir;
    private boolean running = true;
    private MediaPlayer mediaPlayer;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_ava);


        scorePreference = getSharedPreferences("highScore",MODE_PRIVATE);
        scoreChronometer = new Chronometer(this);
        scoreChronometer.setBase(SystemClock.elapsedRealtime());
        scoreChronometer.start();
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        questionText = findViewById(R.id.quiestionsView);
        scoreView = findViewById(R.id.scoreView);
        scorePopUp = new Dialog(this);
        scorePopUp.setContentView(R.layout.score_popup);
      scorePopUp.getWindow().getAttributes().windowAnimations = R.style.ScorePopUpAnimation;
        scorePopUp.getWindow().setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);
        winningMessage = scorePopUp.findViewById(R.id.winningMessage);
        scoreMessage = scorePopUp.findViewById(R.id.scoreMessage);
        iqMessage = scorePopUp.findViewById(R.id.iqMessage);
        chronometer = findViewById(R.id.simpleChronometer);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        chronometer.start();
         buttonsInit = AnimationUtils.loadAnimation(this,R.anim.advanced_init);
        muteButton = findViewById(R.id.muteButton);
        mute = sharedPref.getBoolean(SettingActivity.KEY_MUTE_MUSIC,false);

         //evento de sonido
         mediaPlayer = MediaPlayer.create(this,R.raw.retrosou);
         mediaPlayer.setLooping(true);

         if(!mute) {
             mediaPlayer.start();
         }else{
         }


         mInterstitialAd = new InterstitialAd(this);
         mInterstitialAd.setAdUnitId(getString(R.string.interstic_juego));
         mInterstitialAd.loadAd(new AdRequest.Builder().build());

         mInterstitialAd.setAdListener(new AdListener() {
             @Override
             public void onAdClosed() {
                 // Load the next interstitial.
                 mInterstitialAd.loadAd(new AdRequest.Builder().build());
             }

         });


        ImageButton pausaBoton = findViewById(R.id.pauseButton);

        sqr = sharedPref.getBoolean(SettingActivity.KEY_SQUARE,true);
        sqrt = sharedPref.getBoolean(SettingActivity.KEY_SQUARE_ROOT,true);
        cube = sharedPref.getBoolean(SettingActivity.KEY_CUBE,true);
        addition = sharedPref.getBoolean(SettingActivity.KEY_ADDITION_ADVANCED, true);
        subtraction = sharedPref.getBoolean(SettingActivity.KEY_SUBTRACTION_ADVANCED,true);
        addmult = sharedPref.getBoolean(SettingActivity.KEY_ADDITION_X_MULTIPLICATION,true);
        adddiv = sharedPref.getBoolean(SettingActivity.KEY_ADDITION_BY_DIVISION,true);
        submult = sharedPref.getBoolean(SettingActivity.KEY_SUBTRACTION_X_MULTIPLICATION,true);
        subdiv = sharedPref.getBoolean(SettingActivity.KEY_SUBTRACTION_BY_DIVISION,true);
        kidsmode = sharedPref.getBoolean(SettingActivity.KEY_KIDS_MODE_SWITCH,false);
        flashingText = sharedPref.getBoolean(SettingActivity.KEY_FLASHING_TEXT,true);
/*
        mediaPlayer = MediaPlayer.create(this,R.raw.the_duel);
        mediaPlayer.setLooping(true);
        if(!mute) {
            mediaPlayer.start();
            muteButton.setImageResource(R.drawable.ic_volume_up_black_24dp);
        }else{
            muteButton.setImageResource(R.drawable.ic_volume_off_black_24dp);
        }


         */


        //Generate the starting question
        generateQuestion();


        if(isFirstTime()){

            ShowcaseConfig config = new ShowcaseConfig();
            final MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, "advancedOnBoarding");
            config.setMaskColor(getResources().getColor(R.color.colorAccent50));
            config.setRenderOverNavigationBar(true);
            config.setShapePadding(50);
            config.setDelay(500);
            sequence.setConfig(config);

            chronometer.post(new Runnable() {
                @Override
                public void run() {
                    sequence.addSequenceItem(chronometer,getString(R.string.welcomeGame),getString(R.string.siguient));
                    sequence.addSequenceItem(questionText,getString(R.string.part2),getString(R.string.siguient));

                    switch (locationOfCorrectAnswer){
                        case 0: sequence.addSequenceItem(
                                new MaterialShowcaseView.Builder(splashAva.this)
                                        .setTarget(button0)
                                        .setContentText(getString(R.string.part3) + button0.getText() + getString(R.string.part4))
                                        .setMaskColour(getResources().getColor(R.color.colorAccent50))
                                        .withRectangleShape()
                                        .setDismissOnTargetTouch(true)
                                        .setTargetTouchable(true)
                                        .build()
                        );
                            break;
                        case 1: sequence.addSequenceItem(
                                new MaterialShowcaseView.Builder(splashAva.this)
                                        .setTarget(button1)
                                        .setContentText(getString(R.string.part3) + " "+button1.getText() + "\n"+getString(R.string.part4))
                                        .setMaskColour(getResources().getColor(R.color.colorAccent50))
                                        .withRectangleShape()
                                        .setDismissOnTargetTouch(true)
                                        .setTargetTouchable(true)
                                        .build()
                        );
                            break;
                        case 2: sequence.addSequenceItem(
                                new MaterialShowcaseView.Builder(splashAva.this)
                                        .setTarget(button2)
                                        .setContentText(getString(R.string.part3) + button2.getText() + getString(R.string.part4))
                                        .setMaskColour(getResources().getColor(R.color.colorAccent50))
                                        .withRectangleShape()
                                        .setDismissOnTargetTouch(true)
                                        .setTargetTouchable(true)
                                        .build()
                        );
                            break;
                        case 3: sequence.addSequenceItem(
                                new MaterialShowcaseView.Builder(splashAva.this)
                                        .setTarget(button3)
                                        .setContentText(getString(R.string.part3) + button3.getText() + getString(R.string.part4))
                                        .setMaskColour(getResources().getColor(R.color.colorAccent50))
                                        .withRectangleShape()
                                        .setDismissOnTargetTouch(true)
                                        .setTargetTouchable(true)
                                        .build()
                        );
                            break;
                    }
                    sequence.addSequenceItem(scoreView,getString(R.string.part5),getString(R.string.part6));
                    sequence.start();
                    chronometer.stop();
                    chronometer.start();
                    //reiniciar el conotrmeotr
                }
            });
        }
    }



    public void muteTemp(View view){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            sharedPref.edit().putBoolean(SettingActivity.KEY_MUTE_MUSIC,true).apply();
        }else{
            mediaPlayer.start();
            sharedPref.edit().putBoolean(SettingActivity.KEY_MUTE_MUSIC,false).apply();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer.isPlaying() && !mute) {
            musicLength = mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
        }
        if(addition && subtraction && adddiv && addmult && subdiv && submult && sqr && sqrt && cube && !kidsmode) {
            finish();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(!mediaPlayer.isPlaying() && mute) {
            mediaPlayer.seekTo(musicLength);
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();

        mediaPlayer.release();
    }
public void showPopUp(View view){

        boolean newHigh = false;
        if(addition && subtraction && adddiv && addmult && subdiv && submult && sqr && sqrt && cube && !kidsmode) {
            SharedPreferences.Editor editor = scorePreference.edit();
            int largest = scorePreference.getInt("advancedHighScore", 0);
            int largestDifference = scorePreference.getInt("advancedDifference",100);
            int difference = numberOfQuestions - score;
            int largestTimeTaken = scorePreference.getInt("madvancedTimeTaken",1200);
            long elapsedMillis = SystemClock.elapsedRealtime() - scoreChronometer.getBase();
            int timeTaken = (int) elapsedMillis / 1000;
            if (score >= largest && difference <= largestDifference && timeTaken <= largestTimeTaken) {
                largest = score;
                editor.putInt("advancedDifference", difference).apply();
                editor.putInt("advancedHighScore", largest).apply();
                editor.putInt("madvancedTimeTaken", timeTaken).apply();
                editor.putInt("advancedHighScoreTotal", numberOfQuestions).apply();
                scoreChronometer.stop();
                newHigh = true;
            }
        }

        if(newHigh){
            winningMessage.setText(getString(R.string.part9));
        }else {
            if (numberOfQuestions - score < 4 && numberOfQuestions > 10) {
                winningMessage.setText(getString(R.string.part7));
            } else if (numberOfQuestions - score > 0 && numberOfQuestions - score < 5) {
                winningMessage.setText(getString(R.string.part8));
            } else if (numberOfQuestions < 10 && numberOfQuestions > 1) {
                winningMessage.setText(getString(R.string.part11));
            } else if (numberOfQuestions == 0) {
                winningMessage.setText(getString(R.string.part12));
            } else {
                winningMessage.setText(getString(R.string.part10));
            }
            //        if(numberOfQuestions >= 10) {
//            if (numberOfQuestions - score >= 0 && numberOfQuestions - score < 2) {
//                iqMessage.setText(getString(R.string.exceptional_math_skill));
//            } else if (numberOfQuestions - score >= 0 && numberOfQuestions - score <= 3) {
//                iqMessage.setText(getString(R.string.above_average_math_skill));
//            } else if (numberOfQuestions - score >= 3 && numberOfQuestions - score <= 5) {
//                iqMessage.setText(getString(R.string.average_math_skill));
//            } else{
//                iqMessage.setText(getString(R.string.below_average_math_skill));
//            }
//        }else{
//            iqMessage.setText(getString(R.string.number_too_low_10));
//        }
        }
        scoreMessage.setText(Integer.toString(score));

        iqMessage.setText(Integer.toString(scoreincorrecta));
        scorePopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        scorePopUp.setCanceledOnTouchOutside(false);
        scorePopUp.show();
        chronometer.stop();
        scorePopUp.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                finish();
            }
        });
    }
    public void playAgain(View view){
         startActivity(new Intent(this, splashAva.class));
        finish();

    }

    //Pop up quit button
    public  void quit(View view){
        
        startActivity(new Intent(this, LauncherActivity2.class));
        finish();

         if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    public void choose(View view){
        //if statement connects the tapped answer to the correct answer
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {
            score++;
            numberOfQuestions++;
            generateQuestion();




        }else {
           //scoreView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.correct_animation));
            numberOfQuestions++;
            scoreincorrecta++;
            if(locationOfCorrectAnswer == 0){
               button0.startAnimation(AnimationUtils.loadAnimation(this,R.anim.correct_animation));

            }
            else if (locationOfCorrectAnswer == 1){
                 button1.startAnimation(AnimationUtils.loadAnimation(this, R.anim.correct_animation));
             } else if (locationOfCorrectAnswer == 2){

                button2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.correct_animation));
             } else if (locationOfCorrectAnswer == 3){
                 button3.startAnimation(AnimationUtils.loadAnimation(this, R.anim.correct_animation));
             }
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    generateQuestion();


                }
            }, 1000);
        }
        scoreView.setText(getString(R.string.advanced_score,score,numberOfQuestions));
        if(flashingText) {

            questionText.startAnimation(AnimationUtils.loadAnimation(this, R.anim.question_flicker));
        }
        answers.clear();


    }
    public void generateQuestion(){
        Random rd = new Random();
        int a = rd.nextInt(9);
        if(a == 0) {
            if(sqr)
                squareQuestions();
            else{
                if(sqrt)
                    sqrtQuestions();
                else{
                    if(cube)
                        cubeQuestions();
                    else{
                        if(subtraction)
                            tripleSubtractQuestions();
                        else{
                            if(addition){
                                tripleSumQuestions();
                            }else{
                                if(submult)
                                    tripleSubMultiplyQuestions();
                                else{
                                    if(subdiv)
                                        tripleSubDivisionQuestions();
                                    else{
                                        if(addmult)
                                            tripleSumMultiplyQuestions();
                                        else{
                                            if(adddiv)
                                                tripleSumDivisionQuestions();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else if(a == 1){
            if(cube)
                cubeQuestions();
            else{
                if(sqrt)
                    sqrtQuestions();
                else{
                    if(sqr)
                        squareQuestions();
                    else{
                        if(subtraction)
                            tripleSubtractQuestions();
                        else{
                            if(addition){
                                tripleSumQuestions();
                            }else{
                                if(submult)
                                    tripleSubMultiplyQuestions();
                                else{
                                    if(subdiv)
                                        tripleSubDivisionQuestions();
                                    else{
                                        if(addmult)
                                            tripleSumMultiplyQuestions();
                                        else{
                                            if(adddiv)
                                                tripleSumDivisionQuestions();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else if(a == 2){
            if(sqrt)
                sqrtQuestions();
            else{
                if(cube)
                    cubeQuestions();
                else{
                    if(sqr)
                        squareQuestions();
                    else{
                        if(subtraction)
                            tripleSubtractQuestions();
                        else{
                            if(addition){
                                tripleSumQuestions();
                            }else{
                                if(submult)
                                    tripleSubMultiplyQuestions();
                                else{
                                    if(subdiv)
                                        tripleSubDivisionQuestions();
                                    else{
                                        if(addmult)
                                            tripleSumMultiplyQuestions();
                                        else{
                                            if(adddiv)
                                                tripleSumDivisionQuestions();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else if(a == 3){
            if(subtraction)
                tripleSubtractQuestions();
            else{
                if(sqrt)
                    sqrtQuestions();
                else{
                    if(sqr)
                        squareQuestions();
                    else{
                        if(cube)
                            cubeQuestions();
                        else{
                            if(addition){
                                tripleSumQuestions();
                            }else{
                                if(submult)
                                    tripleSubMultiplyQuestions();
                                else{
                                    if(subdiv)
                                        tripleSubDivisionQuestions();
                                    else{
                                        if(addmult)
                                            tripleSumMultiplyQuestions();
                                        else{
                                            if(adddiv)
                                                tripleSumDivisionQuestions();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else if(a == 4){
            if(addition)
                tripleSumQuestions();
            else{
                if(sqrt)
                    sqrtQuestions();
                else{
                    if(sqr)
                        squareQuestions();
                    else{
                        if(cube)
                            cubeQuestions();
                        else{
                            if(subtraction){
                                tripleSubtractQuestions();
                            }else{
                                if(submult)
                                    tripleSubMultiplyQuestions();
                                else{
                                    if(subdiv)
                                        tripleSubDivisionQuestions();
                                    else{
                                        if(addmult)
                                            tripleSumMultiplyQuestions();
                                        else{
                                            if(adddiv)
                                                tripleSumDivisionQuestions();
                                        }
                                    }
                                }
                            }
                        }
                   }
                }
            }
        }else if(a == 5){
            if(addmult)
                tripleSumMultiplyQuestions();
            else{
                if(sqrt)
                    sqrtQuestions();
                else{
                    if(sqr)
                        squareQuestions();
                    else{
                        if(cube)
                            cubeQuestions();
                        else{
                            if(subtraction){
                                tripleSubtractQuestions();
                            }else{
                                if(submult)
                                    tripleSubMultiplyQuestions();
                                else{
                                    if(subdiv)
                                        tripleSubDivisionQuestions();
                                    else{
                                        if(addition)
                                            tripleSumQuestions();
                                        else{
                                            if(adddiv)
                                                tripleSumDivisionQuestions();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else if(a == 6){
            if(adddiv)
                tripleSumDivisionQuestions();
            else{
                if(sqrt)
                    sqrtQuestions();
                else{
                    if(sqr)
                        squareQuestions();
                    else{
                        if(cube)
                            cubeQuestions();
                        else{
                            if(subtraction){
                                tripleSubtractQuestions();
                            }else{
                                if(submult)
                                    tripleSubMultiplyQuestions();
                                else{
                                    if(subdiv)
                                        tripleSubDivisionQuestions();
                                    else{
                                        if(addition)
                                            tripleSumQuestions();
                                        else{
                                            if(addmult)
                                                tripleSumMultiplyQuestions();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else if(a == 7){
            if(submult)
                tripleSubMultiplyQuestions();
            else{
                if(sqrt)
                    sqrtQuestions();
                else{
                    if(sqr)
                        squareQuestions();
                    else{
                        if(cube)
                            cubeQuestions();
                        else{
                            if(subtraction){
                                tripleSubtractQuestions();
                            }else{
                                if(adddiv)
                                    tripleSumDivisionQuestions();
                                else{
                                    if(subdiv)
                                        tripleSubDivisionQuestions();
                                    else{
                                        if(addition)
                                            tripleSumQuestions();
                                        else{
                                            if(addmult)
                                                tripleSumMultiplyQuestions();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else if(a == 8){
            if(subdiv)
                tripleSubMultiplyQuestions();
            else{
                if(sqrt)
                    sqrtQuestions();
                else{
                    if(sqr)
                        squareQuestions();
                    else{
                        if(cube)
                            cubeQuestions();
                        else{
                            if(subtraction){
                                tripleSubtractQuestions();
                            }else{
                                if(adddiv)
                                    tripleSumDivisionQuestions();
                                else{
                                    if(submult)
                                        tripleSubMultiplyQuestions();
                                    else{
                                        if(addition)
                                            tripleSumQuestions();
                                        else{
                                            if(addmult)
                                                tripleSumMultiplyQuestions();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        answers.clear();
        button0.startAnimation(buttonsInit);
        button1.startAnimation(AnimationUtils.loadAnimation(this, R.anim.advanced_init_1));
        button2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.advanced_init_2));
        button3.startAnimation(AnimationUtils.loadAnimation(this,R.anim.advanced_init_3));
    }

    //Generates question with format - x^2
    public void squareQuestions(){
        Random rd = new Random();
        int[] arr = {2,3,4,5,6,7,8,9,10,11,12};
        int a = arr[rd.nextInt(11)];
        int incorrectAnswer;
        locationOfCorrectAnswer = rd.nextInt(4);
        questionText.setText(getString(R.string.square,a));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add((int)Math.pow(a,2));
            }else{
                incorrectAnswer = rd.nextInt(80)+4;
                while(incorrectAnswer == (int)Math.pow(a,2)){
                    incorrectAnswer = rd.nextInt(80)+4;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }

    //Generates question with format - x^3
    public void cubeQuestions(){
        Random rd = new Random();
        int[] arr = {2,3,4,5};
        int a = arr[rd.nextInt(4)];
        int incorrectAnswer;
        locationOfCorrectAnswer = rd.nextInt(4);
        questionText.setText(getString(R.string.cube,a));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add((int)Math.pow(a,3));
            }else{
                incorrectAnswer = rd.nextInt(90)+30;
                while(incorrectAnswer == (int)Math.pow(a,3)){
                    incorrectAnswer = rd.nextInt(90)+30;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }

    //Generates question with format - sqrt(x)
    public void sqrtQuestions(){
        Random rd = new Random();
        int a = rd.nextInt(100)+1;
        int incorrectAnswer;
        locationOfCorrectAnswer = rd.nextInt(4);
        while(Math.sqrt(a) % 1 != 0){
            a = rd.nextInt(100)+1;
        }
        questionText.setText(getString(R.string.sqrt,a));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add((int)Math.sqrt(a));
            }else{
                incorrectAnswer = rd.nextInt(14)+2;
                while(incorrectAnswer == (int)Math.sqrt(a)){
                    incorrectAnswer = rd.nextInt(14)+2;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }

    //This is redundant until I set min API to be 21
    public void cbrtQuestions(){
        Random rd = new Random();
        int a = rd.nextInt(100)+1;
        int incorrectAnswer;
        locationOfCorrectAnswer = rd.nextInt(4);
        while(Math.cbrt(a) % 1 != 0){
            a = rd.nextInt(100)+1;
        }
        questionText.setText(getString(R.string.cbrt,a));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add((int)Math.cbrt(a));
            }else{
                incorrectAnswer = rd.nextInt(10)+2;
                while(incorrectAnswer == (int)Math.cbrt(a)){
                    incorrectAnswer = rd.nextInt(10)+2;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }
    //Generates question with format - a + b + c
    public void tripleSumQuestions(){
        Random rd = new Random();
        int a = rd.nextInt(25)+20;
        int b = rd.nextInt(15)+10;
        int c = rd.nextInt(10)+5;
        int incorrectAnswer;
        locationOfCorrectAnswer = rd.nextInt(4);
        questionText.setText(getString(R.string.triple_sum,a,b,c));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add(a+b+c);
            }else{
                incorrectAnswer = rd.nextInt(50)+35;
                while(incorrectAnswer == a+b+c){
                    incorrectAnswer = rd.nextInt(50)+35;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }


    //Generates question with format - a - b - c
    public void tripleSubtractQuestions(){
        Random rd = new Random();
        int a = rd.nextInt((50-25)+1)+25;
        int b = rd.nextInt((15-10)+1)+10;
        int c = rd.nextInt((10-5)+1)+5;
        int incorrectAnswer;
        locationOfCorrectAnswer = rd.nextInt(4);
        questionText.setText(getString(R.string.triple_sub,a,b,c));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add(a-b-c);
            }else{
                incorrectAnswer = rd.nextInt(25)+10;
                while(incorrectAnswer == a-b-c){
                    incorrectAnswer = rd.nextInt(25)+10;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }


    //Generates question with format - (a - b) x c
    public void tripleSubMultiplyQuestions(){
        Random rd = new Random();
        int a = rd.nextInt((50-25)+1)+25;
        int b = rd.nextInt((15-10)+1)+10;
        int c = rd.nextInt((5-1)+1)+1;
        int incorrectAnswer;
        locationOfCorrectAnswer = rd.nextInt(4);
        questionText.setText(getString(R.string.triple_sub_multiply,a,b,c));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add((a-b)*c);
            }else{
                incorrectAnswer = rd.nextInt((80-20)+1)+20;
                while(incorrectAnswer == (a-b)*c){
                    incorrectAnswer = rd.nextInt((80-20)+1)+20;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }

    //Generates question with format - (a + b) x c

    public void tripleSumMultiplyQuestions(){
        Random rd = new Random();
        int a = rd.nextInt((25-20)+1)+20;
        int b = rd.nextInt((15-10)+1)+10;
        int c = rd.nextInt((5-1)+1)+1;
        int incorrectAnswer;
        locationOfCorrectAnswer = rd.nextInt(4);
        questionText.setText(getString(R.string.triple_sum_multiply,a,b,c));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add((a+b)*c);
            }else{
                incorrectAnswer = rd.nextInt((150-80)+1)+80;
                while(incorrectAnswer == (a+b)*c){
                    incorrectAnswer = rd.nextInt((150-80)+1)+80;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }


    //Generates question with format - (a - b) / c
    public void tripleSubDivisionQuestions(){
        Random rd = new Random();
        int a = rd.nextInt((50-25)+1)+25;
        int b = rd.nextInt((15-10)+1)+10;
        int c = rd.nextInt((10-1)+1)+1;
        int incorrectAnswer;
        while((a-b) % c != 0){
            a = rd.nextInt((50-25)+1)+25;
            b = rd.nextInt((15-10)+1)+10;
            c = rd.nextInt((10-1)+1)+1;
        }
        locationOfCorrectAnswer = rd.nextInt(4);
        questionText.setText(getString(R.string.triple_sub_div,a,b,c));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add((a-b)/c);
            }else{
                incorrectAnswer = rd.nextInt((40-15)+1)+15;
                while(incorrectAnswer == (a-b)/c){
                    incorrectAnswer = rd.nextInt((40-15)+1)+15;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }

    //Generates question with format - (a + b) / c

    public void tripleSumDivisionQuestions(){
        Random rd = new Random();
        int a = rd.nextInt((25-20)+1)+20;
        int b = rd.nextInt((15-10)+1)+10;
        int c = rd.nextInt((10-1)+1)+1;
        int incorrectAnswer;

        //Checks for remainder.
        while((a+b) % c != 0){
            a = rd.nextInt((50-25)+1)+25;
            b = rd.nextInt((15-10)+1)+10;
            c = rd.nextInt((10-1)+1)+1;
        }
        locationOfCorrectAnswer = rd.nextInt(4);
        questionText.setText(getString(R.string.triple_sum_div,a,b,c));
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add((a+b)/c);
            }else{
                incorrectAnswer = rd.nextInt((40-10)+1)+10;
                while(incorrectAnswer == (a+b)/c){
                    incorrectAnswer = rd.nextInt((40-10)+1)+10;
                }
                answers.add(incorrectAnswer);
            }
        }
        button0.setText(getString(R.string.box,answers.get(0)));
        button1.setText(getString(R.string.box,answers.get(1)));
        button2.setText(getString(R.string.box,answers.get(2)));
        button3.setText(getString(R.string.box,answers.get(3)));
    }

    private boolean isFirstTime()
    {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {
            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
        }
        return !ranBefore;
    }

    public void onBackPressed() {
        mostrarSalir();
        // countDownTimer.cancel();

        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }
    public void mostrarSalir() {
        epicDialog2 = new Dialog(this);
        epicDialog2.setContentView(R.layout.custom_salir);

        seguir = (Button) epicDialog2.findViewById(R.id.seguir);
        salir = (Button) epicDialog2.findViewById(R.id.salir);
        seguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                epicDialog2.dismiss();
                if (!running) {
                    chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    chronometer.start();
                    running = true;
                }

            }
        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(splashAva.this, LauncherActivity2.class);
                startActivity(intent);
                 finish();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });
        epicDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        epicDialog2.setCancelable(false);
        epicDialog2.setCanceledOnTouchOutside(false);
        epicDialog2.show();


    }
}

