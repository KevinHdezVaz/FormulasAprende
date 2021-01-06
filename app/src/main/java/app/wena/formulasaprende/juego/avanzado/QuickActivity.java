package app.wena.formulasaprende.juego.avanzado;
import app.wena.formulasaprende.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


 import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardedVideoAd;

import java.util.Random;

import app.wena.formulasaprende.juego.LauncherActivity2;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class QuickActivity extends AppCompatActivity {
    private TextView timerText, quickMathQuestion, quickMathScore, winningMessage;
    private TextView scoreMessage, iqMessage, userFeedback;
    private ImageButton correctButton, wrongButton;
    private int correctAnswer, score, scoreincorrecta,wrongOrCorrect, numberOfQuestions, feedBackNum, musicLength, timesPlayed;
    private Dialog scorePopUp;
    private Vibrator vibrator;
    private Animation correctAnimation;
    private Boolean addition;
    private Boolean subtraction;
    private Boolean multiplication;
    private Boolean division, kidsmode,timer, mute, flashingText,vibracion;
     private CountDownTimer countDownTimer;
    SharedPreferences audio;
    private Button playAgainButton;
    private RewardedVideoAd mRewardedVideoAd;   Boolean correcto = false;
     int vida = 1;
    private MediaPlayer mediaPlayer;
    private SharedPreferences scorePreference;
    SharedPreferences sharedPref;
    ImageButton muteButton;
    private InterstitialAd mInterstitialAd;
    private static final String PRF_COUNTDOWN_FILE = "cdt-preferences";
    SharedPreferences prefs;
Boolean valorVida = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick);


        scorePreference = getSharedPreferences("highScore",MODE_PRIVATE);


        timesPlayed = scorePreference.getInt("timesPlayed",0);


        timesPlayed++;
        timerText = findViewById(R.id.stopwatchText);
        quickMathQuestion = findViewById(R.id.quickMathQuestion);
        quickMathScore = findViewById(R.id.quickMathsScore);
        correctButton = findViewById(R.id.correctButton);
        wrongButton = findViewById(R.id.wrongButton);
        scorePopUp = new Dialog(this);
        scorePopUp.setContentView(R.layout.score_popup);
        scorePopUp.getWindow().getAttributes().windowAnimations = R.style.ScorePopUpAnimation;
        scorePopUp.getWindow().setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);
        winningMessage = scorePopUp.findViewById(R.id.winningMessage);
        scoreMessage = scorePopUp.findViewById(R.id.scoreMessage);
        iqMessage = scorePopUp.findViewById(R.id.iqMessage);
        userFeedback = findViewById(R.id.plusOne);
        playAgainButton = findViewById(R.id.playAgainButton);
       muteButton = findViewById(R.id.muteButton);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        correctAnimation = AnimationUtils.loadAnimation(this, R.anim.correct_animation);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        ImageButton pausaBoton = findViewById(R.id.pauseButton);

        muteButton = findViewById(R.id.muteButton);

        audio =  getSharedPreferences(SettingActivity.KEY_MUTE_MUSIC,Context.MODE_PRIVATE);
        mute = sharedPref.getBoolean(SettingActivity.KEY_MUTE_MUSIC,false);

        addition = sharedPref.getBoolean(SettingActivity.KEY_ADDITION_ONLY_QUICKMATH,true);
        subtraction = sharedPref.getBoolean(SettingActivity.KEY_SUBTRACTION_ONLY_QUICKMATH,true);
        multiplication = sharedPref.getBoolean(SettingActivity.KEY_MULTIPLICATION_ONLY_QUICKMATH,true);
        division = sharedPref.getBoolean(SettingActivity.KEY_DIVISION_ONLY_QUICKMATH,true);
        kidsmode = sharedPref.getBoolean(SettingActivity.KEY_KIDS_MODE_SWITCH, false);
        timer = sharedPref.getBoolean(SettingActivity.KEY_TIMER, true);
        flashingText = sharedPref.getBoolean(SettingActivity.KEY_FLASHING_TEXT,true);


        mediaPlayer = MediaPlayer.create(this,R.raw.littleide);
        mediaPlayer.setLooping(true);

        if(!mute) {
            mediaPlayer.start();
        }else{
        }

         generateQuestion();
        timer();

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

        if(isFirstTime()){
           countDownTimer.cancel();
            timerText.setText("30s");
            ShowcaseConfig config = new ShowcaseConfig();
            config.setMaskColor(getResources().getColor(R.color.colorAccent50));
            config.setRenderOverNavigationBar(true);
            config.setDelay(500);
            final MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(QuickActivity.this, "quickMathOnBoarding");
            sequence.setConfig(config);
            timerText.post(new Runnable() {
                @Override
                public void run() {
                    sequence.addSequenceItem(timerText,getString(R.string.saludo1),getString(R.string.next));
                    sequence.addSequenceItem(quickMathQuestion,getString(R.string.saludo2),getString(R.string.next));
                    if(wrongOrCorrect == 0)
                        sequence.addSequenceItem(
                                new MaterialShowcaseView.Builder(QuickActivity.this)
                                        .setTarget(correctButton)
                                        .setContentText(getString(R.string.saludo3))
                                        .setMaskColour(getResources().getColor(R.color.colorAccent50))
                                        .withRectangleShape()
                                        .setDismissOnTargetTouch(true)
                                        .setTargetTouchable(true)
                                        .build()
                        );
                    else
                        sequence.addSequenceItem(
                                new MaterialShowcaseView.Builder(QuickActivity.this)
                                        .setTarget(wrongButton)
                                        .setContentText(getString(R.string.saludo5))
                                        .setMaskColour(getResources().getColor(R.color.colorAccent50))
                                        .withRectangleShape()
                                        .setDismissOnTargetTouch(true)
                                        .setTargetTouchable(true)
                                        .build()
                        );
                    sequence.addSequenceItem(
                            new MaterialShowcaseView.Builder(QuickActivity.this)
                                    .setTarget(userFeedback)
                                    .setMaskColour(getResources().getColor(R.color.colorAccent50))
                                    .setContentText(getString(R.string.saludo4))
                                    .setDismissOnTargetTouch(true)
                                    .setTargetTouchable(true)
                                    .build()
                    );
                    sequence.addSequenceItem(
                            new MaterialShowcaseView.Builder(QuickActivity.this)
                                    .setTarget(quickMathQuestion)
                                    .setContentText(getString(R.string.saludo6))
                                    .setMaskColour(getResources().getColor(R.color.colorAccent50))
                                    .setDismissOnTargetTouch(true)
                                    .setTargetTouchable(true)
                                    .withRectangleShape()
                                    .build()


                    );

                    sequence.addSequenceItem(
                            new MaterialShowcaseView.Builder(QuickActivity.this)
                                    .setTarget(timerText)
                                    .setContentText(getString(R.string.kota2))
                                    .setMaskColour(getResources().getColor(R.color.colorAccent50))
                                    .setDismissOnTargetTouch(true)
                                    .setTargetTouchable(true)
                                    .withRectangleShape()
                                    .build()
                    );
                     sequence.start();

                     //reiniciar esta vaina
                 }
            });



        }


    }



    @Override
    protected void onPause() {
        super.onPause();


        if(mediaPlayer.isPlaying() && !mute) {
            musicLength = mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
        }

        if(timer){
            finish();
        }
        scorePopUp.dismiss();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(!mediaPlayer.isPlaying() && !mute) {
            mediaPlayer.seekTo(musicLength);
            mediaPlayer.start();
        }
        scorePopUp.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        scorePopUp.dismiss();
    }





    public void showPopUp(View view){
        if(timer) {
            countDownTimer.cancel();
        }
        boolean newHigh = false;
        if(addition && subtraction && multiplication && division && !kidsmode && timer){
            SharedPreferences.Editor editor = scorePreference.edit();
            int largest = scorePreference.getInt("quickMathHighScore",0);

            int totalAnswered = scorePreference.getInt("quickMathHighScoreWrong",0);
            int largestDifference = scorePreference.getInt("quickMathDifference",100);
            int difference = numberOfQuestions - score;
            if(score > largest && difference <= largestDifference){
                totalAnswered = numberOfQuestions;
                largest = score;
                editor.putInt("quickMathDifference",difference);
                editor.putInt("quickMathHighScore",largest);
                editor.putInt("quickMathHighScoreWrong",totalAnswered);
                editor.apply();
                newHigh = true;
            }
            editor.putInt("timesPlayed",timesPlayed).apply();
        }
        if(newHigh){
            winningMessage.setText(getString(R.string.record));
        }else {
            if (numberOfQuestions - score < 4 && numberOfQuestions > 10) {
                winningMessage.setText(getString(R.string.part8));
            } else if (numberOfQuestions - score > 0 && numberOfQuestions - score < 5) {
                winningMessage.setText(getString(R.string.unbelievable));
            } else if (numberOfQuestions < 10 && numberOfQuestions > 1) {
                winningMessage.setText(getString(R.string.part9));
            } else if (numberOfQuestions == 0) {
                winningMessage.setText(getString(R.string.part11));
            } else {
                winningMessage.setText(getString(R.string.part10));
            }
        }




        scoreMessage.setText(Integer.toString(score));
        iqMessage.setText(Integer.toString(scoreincorrecta));
        scorePopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        scorePopUp.setCanceledOnTouchOutside(false);
        if(!QuickActivity.this.isFinishing()) {
            scorePopUp.show();
        }
        scorePopUp.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                finish();
             }
        });
    }

    public void showPopUp(){
        boolean newHigh = false;
        if(addition && subtraction && multiplication && division && !kidsmode){
            SharedPreferences.Editor editor = scorePreference.edit();
            int largest = scorePreference.getInt("quickMathHighScore",0);
            int totalAnswered = scorePreference.getInt("quickMathHighScoreWrong",0);
            int largestDifference = scorePreference.getInt("quickMathDifference",100);
            int difference = numberOfQuestions - score;
            if(score > largest && difference <= largestDifference){
                totalAnswered = numberOfQuestions;
                largest = score;
                editor.putInt("quickMathDifference",difference);
                editor.putInt("quickMathHighScore",largest);
                editor.putInt("quickMathHighScoreWrong",totalAnswered);
                editor.apply();
                newHigh = true;
            }
            editor.putInt("timesPlayed",timesPlayed).apply();
        }

        if(newHigh){
            winningMessage.setText("NEW HIGH SCORE!");
        }else {
            if (numberOfQuestions - score < 4 && numberOfQuestions > 10) {
                winningMessage.setText(getString(R.string.part7));
            } else if (numberOfQuestions - score > 0 && numberOfQuestions - score < 5) {
                winningMessage.setText(getString(R.string.unbelievable));
            } else if (numberOfQuestions < 10 && numberOfQuestions > 1) {
                winningMessage.setText(getString(R.string.part8));
            } else if (numberOfQuestions == 0) {
                winningMessage.setText(getString(R.string.part10));
            } else {
                winningMessage.setText(getString(R.string.part11));
            }
        }
        scoreMessage.setText(Integer.toString(score));
         
        iqMessage.setText(Integer.toString(scoreincorrecta));

        scorePopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        scorePopUp.setCanceledOnTouchOutside(false);
        if(!QuickActivity.this.isFinishing()) {
            scorePopUp.show();
        }
        scorePopUp.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                finish();
            }
        });

    }

    //Pop up Play again button
    public void playAgain(View view){

        finish();
        startActivity(new Intent(getApplicationContext(), QuickActivity.class));
    }

    //Pop up quit button
    public  void quit(View view){

        startActivity(new Intent(getApplicationContext(), LauncherActivity2.class));
        finish();
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }


    /**The answer button
     * if user answers correct score increases by one
     * number of questions increases by one
     * score text updates
     * Feeds feedback to user depending on right or wrong answer
     * */
    public void choose(final View view){
        if(flashingText) {
            userFeedback.startAnimation(AnimationUtils.loadAnimation(this, R.anim.flicker_animation));
        }
        if(view.getTag().toString().equals(Integer.toString(wrongOrCorrect))){
            score++;
            correcto = true;
            generateQuestion();
            //esto pasa cuando la respuesta es correcta
            if(flashingText) {
                quickMathQuestion.startAnimation(AnimationUtils.loadAnimation(this, R.anim.question_flicker));
            }
          quickMathScore.setText(getString(R.string.score,score));





            numberOfQuestions++;

             if(feedBackNum == 0 || numberOfQuestions == 1){
                userFeedback.setText(getString(R.string.good_job));
            }else if(feedBackNum == 1){
                userFeedback.setText(getString(R.string.amazing));
            }else if(feedBackNum == 2){
                userFeedback.setText(getString(R.string.fantastic));
            }else if(feedBackNum == 3){
                userFeedback.setText(getString(R.string.damn));
            }else if(feedBackNum == 4){
                userFeedback.setText(getString(R.string.genius));
            }else if(feedBackNum == 5){
                userFeedback.setText(getString(R.string.sweet));
            }else if(feedBackNum == 6){
                userFeedback.setText(getString(R.string.crazy));
            }else if(feedBackNum == 7){
                userFeedback.setText(getString(R.string.keep));
            }else if(feedBackNum == 8){
                userFeedback.setText(getString(R.string.unbelievable));
            }else if(feedBackNum == 9){
                userFeedback.setText(getString(R.string.surprised));
            }else if(feedBackNum == 10){
                userFeedback.setText(getString(R.string.brilliant));
            }
        }else{
            //qui se colocara un contador que cuente las malas
            scoreincorrecta++;
            quickMathScore.startAnimation(AnimationUtils.loadAnimation(this,R.anim.correct_animation));
            vibrator.vibrate(500);
            if(wrongOrCorrect == 1){
                wrongButton.startAnimation(correctAnimation);

            }else{
                correctButton.startAnimation(correctAnimation);
            }
            Random rd = new Random();
            switch (rd.nextInt(3)) {
                case 0:
                    userFeedback.setText(getString(R.string.ohno));
                    break;
                case 1:
                    userFeedback.setText(getString(R.string.next));
                    break;
                case 2:
                    userFeedback.setText(getString(R.string.sad));
                    break;
            }
            generateQuestion();
            numberOfQuestions++;

        }
        view.setEnabled(false);
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.setEnabled(true);
            }
        },500);
    }

    //Generates write or wrong question randomly depending on user preference
    public void generateQuestion(){
        Random rd = new Random();
        int questionType = rd.nextInt(4);
        feedBackNum = rd.nextInt(12);
        if(questionType == 0){
            if(addition) {
                sumQuestion();
            }else{
                if(subtraction) {
                    subtractQuestion();
                }else{
                    if(multiplication)
                        multiplyQuestions();
                    else{
                        if(division)
                            divisionQuestion();
                    }
                }
            }
        }else if(questionType == 1){
            if(subtraction) {
                subtractQuestion();
            }else{
                if(addition) {
                    sumQuestion();
                }else{
                    if(multiplication)
                        multiplyQuestions();
                    else{
                        if(division)
                            divisionQuestion();
                    }
                }
            }

        }else if(questionType == 2){
            if(multiplication) {
                multiplyQuestions();
            }else{
                if(addition) {
                    sumQuestion();
                }else{
                    if(subtraction)
                        subtractQuestion();
                    else{
                        if(division)
                            divisionQuestion();
                    }
                }
            }
        }else if(questionType == 3){
            if(division) {
                divisionQuestion();
            }else{
                if(addition) {
                    sumQuestion();
                }else{
                    if(subtraction)
                        subtractQuestion();
                    else{
                        if(multiplication)
                            multiplyQuestions();
                    }
                }
            }
        }
    }
    //Creates a sum questions
    public void sumQuestion(){
        Random rd = new Random();
        int a,b;
        if(!kidsmode) {
            a = rd.nextInt((25 - 10) + 1) + 10;
            b = rd.nextInt((25 - 10) + 1) + 10;
        }else {
            a = rd.nextInt((12 - 1) + 1) + 1;
            b = rd.nextInt((12 - 1) + 1) + 1;
        }
        wrongOrCorrect = rd.nextInt(2);
        int incorrectAnswer;
        if(wrongOrCorrect == 0){
            correctAnswer = a + b;
            quickMathQuestion.setText(getString(R.string.sum,a,b,correctAnswer));
        }else{
            incorrectAnswer = rd.nextInt((50-12)+1)+12;
            while(incorrectAnswer == correctAnswer){
                incorrectAnswer = rd.nextInt((50-12)+1)+12;
            }
            quickMathQuestion.setText(getString(R.string.sum,a,b,incorrectAnswer));
        }
    }

    //Creates a subtract question
    public void subtractQuestion(){
        Random rd = new Random();
        int c,d;
        if(!kidsmode) {
            c = rd.nextInt(25) + 1;
            d = rd.nextInt(10) + c;
        }else{
            c = rd.nextInt(12) + 1;
            d = rd.nextInt(1) + c;
        }
        int incorrectAnswer;
        wrongOrCorrect = rd.nextInt(2);
        if(wrongOrCorrect == 0 ) {
            quickMathQuestion.setText(getString(R.string.sub,d,c,d-c));
        }else{
            correctAnswer = d - c;
            incorrectAnswer = rd.nextInt(20)+1;
            while(incorrectAnswer == correctAnswer){
                incorrectAnswer = rd.nextInt(20)+1;
            }
            quickMathQuestion.setText(getString(R.string.sub,d,c,incorrectAnswer));
        }
    }

    //Creates a multiply question
    public void multiplyQuestions(){
        Random rd = new Random();
        int a,b;
        if(!kidsmode) {
            a = rd.nextInt((12 - 1) + 1) + 1;
            b = rd.nextInt((12 - 1) + 1) + 1;
        }else{
            a = rd.nextInt((9 - 1) + 1) + 1;
            b = rd.nextInt((9 - 1) + 1) + 1;
        }
        correctAnswer = a * b;
        wrongOrCorrect = rd.nextInt(2);
        int incorrectAnswer;
        if(wrongOrCorrect == 0){
            quickMathQuestion.setText(getString(R.string.mult,a,b,correctAnswer));
        }else{
            incorrectAnswer = rd.nextInt((100-20)+1)+20;
            while(incorrectAnswer == correctAnswer){
                incorrectAnswer = rd.nextInt((100-20)+1)+20;
            }
            quickMathQuestion.setText(getString(R.string.mult,a,b,incorrectAnswer));
        }
    }

    //Creates a division question
    public void divisionQuestion(){
        Random rd = new Random();
        int a,b;
        if(!kidsmode) {
            a = rd.nextInt((25 - 10) + 1) + 10;
            b = rd.nextInt((25 - 10) + 1) + 10;
        }else{
            a = rd.nextInt((12 - 1) + 1) + 1;
            b = rd.nextInt((12 - 1) + 1) + 1;
        }
        int incorrectAnswer;
        wrongOrCorrect = rd.nextInt(2);
        if(wrongOrCorrect == 0){
            while(b % a != 0){
                a = rd.nextInt(10)+1;
                b = rd.nextInt(10)+a;
            }
            correctAnswer = b / a;
            quickMathQuestion.setText(getString(R.string.div,b,a,correctAnswer));
        }else{
            incorrectAnswer = rd.nextInt(24)+1;
            correctAnswer = b / a;
            while(b % a != 0 || incorrectAnswer == correctAnswer){
                a = rd.nextInt(10)+1;
                b = rd.nextInt(10)+a;
            }
            quickMathQuestion.setText(getString(R.string.div,b,a,incorrectAnswer));
        }
    }

    //Timer that keeps track of time
    public void timer(){
//        int time = Integer.parseInt(timerDuration) * 1000;
        countDownTimer = new CountDownTimer(30000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                if(millisUntilFinished > 10000)


                        timerText.setText(getString(R.string.timer_quick_math,(int) millisUntilFinished /1000 ));



                else if(millisUntilFinished < 10000 && millisUntilFinished > 5000){


                        timerText.setText(getString(R.string.timer_quick_math_ten_less,(int) millisUntilFinished / 1000));


                    //propiedad booleana que didga si es correcta o nel
                    //Timer flickering gets faster as time runs out
                    //Adds a 0 before last digit
                     //Flickers only if its enabled in the settings.
                    if(flashingText) {
                        timerText.startAnimation(AnimationUtils.loadAnimation(QuickActivity.this, R.anim.flicker_animation_2));
                    }
                }else if(millisUntilFinished < 5000 && millisUntilFinished > 3000){
                    timerText.setText(getString(R.string.timer_quick_math_ten_less,(int) millisUntilFinished / 1000));
                    if(flashingText) {
                        timerText.startAnimation(AnimationUtils.loadAnimation(QuickActivity.this, R.anim.flicker_animation_1));
                    }
                }else {
                    timerText.setText(getString(R.string.timer_quick_math_ten_less,(int) millisUntilFinished / 1000));
                    if(flashingText) {
                        timerText.startAnimation(AnimationUtils.loadAnimation(QuickActivity.this, R.anim.flicker_animation));
                    }
                }
            }
            @Override
            public void onFinish() {
                //Shows user results
                showPopUp();
            }
        }.start();
    }

    //Resets everything to zero
    public void reset(){
        numberOfQuestions = 0;
        score = 0;
        timer();
        generateQuestion();
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
        Intent intent = new Intent(QuickActivity.this, LauncherActivity2.class);
        startActivity(intent);


        finish();
    }
}
