package app.wena.formulasaprende.TercerFragmento.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.animation.Animator;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Layout;
import android.util.Log;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

 import com.facebook.stetho.Stetho;

import org.mariuszgromada.math.mxparser.Expression;

import java.text.DecimalFormat;

import app.wena.formulasaprende.R;
import io.codetail.animation.ViewAnimationUtils;
import io.codetail.widget.RevealFrameLayout;

public class calculadora_cientifica extends AppCompatActivity {
    public static String currentCalculation;
    public static String previousCalculation;
    public static String displayCalculation;
    public static String finalCalculation;
    public static String previousAns;
    public static Boolean exponentOn;
    public static Boolean firstExponent;
    public static Boolean pVisible;
    public static Boolean binPressed;
    public static Boolean angle;
    public static final String defaultMethod = "rad";
    public static int LOW_IMPORTANCE_KEY_VIBRATE = 50;
    public static int MED_IMPORTANCE_KEY_VIBRATE = 80;
    public static int HIGH_IMPORTANCE_KEY_VIBRATE = 120;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_cientifica);



        //initialize stetho
        Stetho.initializeWithDefaults(this);

        //Hide the action bar


        //Initialize widgets
        final TextView calculationView = (TextView)findViewById(R.id.instantCalcluationView);
        final TextView pView = (TextView)findViewById(R.id.primeView);
        final Button angleB = (Button)findViewById(R.id.angleButton);
        final Button exponentB = (Button) findViewById(R.id.exponentButton);
        final TextView instantCalcView = (TextView)findViewById(R.id.calcView);
        final LinearLayout myLinear = (LinearLayout)findViewById(R.id.linearLayout);
        final ConstraintLayout myLayout = (ConstraintLayout)findViewById(R.id.myBackLayout);
        final RevealFrameLayout myReveal = (RevealFrameLayout)findViewById(R.id.revealFrameLayout);
        final View mvv = findViewById(R.id.awesome_card);

        final Button zeroB = (Button)findViewById(R.id.zeroButton);
        final Button oneB = (Button)findViewById(R.id.oneButton);
        final Button twoB = (Button)findViewById(R.id.twoButton);
        final Button threeB = (Button)findViewById(R.id.threeButton);
        final Button fourB = (Button)findViewById(R.id.fourButton);
        final Button fiveB = (Button)findViewById(R.id.fiveButton);
        final Button sixB = (Button)findViewById(R.id.sixButton);
        final Button sevenB = (Button)findViewById(R.id.sevenButton);
        final Button eightB = (Button)findViewById(R.id.eightButton);
        final Button nineB = (Button)findViewById(R.id.nineButton);
        final Button decimalB = (Button)findViewById(R.id.decimalButton);
        final Button ansB = (Button)findViewById(R.id.ansButton);
        final Button multB = (Button)findViewById(R.id.multiplyButton);
        final Button minusB = (Button)findViewById(R.id.minusButton);
        final Button divB = (Button)findViewById(R.id.divideButton);
        final Button equalsB = (Button)findViewById(R.id.equalsButton);
        final Button plusB = (Button)findViewById(R.id.plusButton);
        final Button sinB = (Button)findViewById(R.id.sinButton);
        final Button tanB = (Button)findViewById(R.id.tanButton);
        final Button cosB = (Button)findViewById(R.id.cosButton);
        Button delB = (Button)findViewById(R.id.deleteButton);
        Button clrB = (Button)findViewById(R.id.clearButton);
        final Button bracketB = (Button) findViewById(R.id.bracketButton);
        final Button logB = (Button)findViewById(R.id.logButton);
        final Button lnB = (Button)findViewById(R.id.lnButton);
        final Button binButton = (Button)findViewById(R.id.bbb);
        final Button sqrtB = (Button)findViewById(R.id.sqrtButton);



        //instantCalcView
        currentCalculation = " ";
        displayCalculation = " ";
        pVisible = false;
        exponentOn = false;
        pView.setVisibility(TextView.INVISIBLE);
        myReveal.setBackgroundColor(Color.TRANSPARENT);
        //android.support.v7.app.ActionBar bar = getSupportActionBar();
        //bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33B5E5")));

        try{
            previousAns = loadAnswer();
        }
        catch(Exception ff){

        }

        int numButtonColor = Color.WHITE;
        int cardBackgroundColor = getResources().getColor(R.color.lightRed);
        int backgroundColor = getResources().getColor(R.color.naturalBlack);
        int functionButtonColor = getResources().getColor(R.color.grayC);
        int equalsButtonColor = R.color.equalsButtonOriginal;
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        if(loadAngle().equals("rad")){
            angleB.setText("RAD");
            angle = false;
        }
        else{
            angleB.setText("DEG");
            //angleB.setTextColor(getResources().getColor(R.color.degree));
            angle = true;
        }


        sqrtB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("square root", "Button pressed");
                currentCalculation += "sqrt(";
                displayCalculation += "√(";
                calculationView.setText(displayCalculation);
                onAllClicks();
                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(LOW_IMPORTANCE_KEY_VIBRATE);
            }
        });



        fiveB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });



        zeroB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCalculation += "0";
                displayCalculation += "0";
                calculationView.setText(displayCalculation);


                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(LOW_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();


                calculationView.startAnimation(AnimationUtils.loadAnimation(calculadora_cientifica.this, R.anim.slide_out_right));
            }
        });

        zeroB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                currentCalculation += "!";
                displayCalculation += "!";
                calculationView.setText(displayCalculation);
                equalsMethod();
                onAllClicks();
                return true;
            }
        });

        oneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentCalculation += "1";
                displayCalculation += "1";
                calculationView.setText(displayCalculation);

                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(LOW_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();

            }
        });

        oneB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onVarClicks();
                currentCalculation += "e";
                displayCalculation += "e";
                calculationView.setText(displayCalculation);
                equalsMethod();
                onAllClicks();
                return true;
            }
        });

        twoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentCalculation += "2";
                displayCalculation += "2";
                calculationView.setText(displayCalculation);

                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(LOW_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();
            }
        });

        twoB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onVarClicks();
                currentCalculation += "[phi]";
                displayCalculation += "φ";
                calculationView.setText(displayCalculation);
                equalsMethod();
                onAllClicks();
                return true;
            }
        });

        threeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCalculation += "3";
                displayCalculation += "3";
                calculationView.setText(displayCalculation);

                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(LOW_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();
            }
        });

        threeB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                currentCalculation += "#";
                displayCalculation += "%";
                calculationView.setText(displayCalculation);
                equalsMethod();
                onAllClicks();
                return true;
            }
        });



        fourB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentCalculation += "4";
                displayCalculation += "4";
                calculationView.setText(displayCalculation);

                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(LOW_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();
            }
        });

        fiveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentCalculation += "5";
                displayCalculation += "5";
                calculationView.setText(displayCalculation);

                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(LOW_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();
            }
        });

        sixB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentCalculation += "6";
                displayCalculation += "6";
                calculationView.setText(displayCalculation);

                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(LOW_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();

            }
        });

        sevenB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentCalculation += "7";
                displayCalculation += "7";
                calculationView.setText(displayCalculation);

                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(LOW_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();
            }
        });

        sevenB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                currentCalculation += "lcm(";
                displayCalculation += "LCM(";
                calculationView.setText(displayCalculation);
                equalsMethod();
                return true;
            }
        });

        eightB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCalculation += "8";
                displayCalculation += "8";
                calculationView.setText(displayCalculation);

                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(LOW_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();
            }
        });

        eightB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                currentCalculation += "gcd(";
                displayCalculation += "GCD(";
                calculationView.setText(displayCalculation);
                equalsMethod();
                return true;
            }
        });

        nineB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(exponentOn == true){
                    if (firstExponent == true){
                        currentCalculation += "^(9";
                        displayCalculation += "^(9";
                        calculationView.setText(displayCalculation);
                        firstExponent = false;
                    }
                    else {
                        currentCalculation += "9";
                        displayCalculation += "9";
                        calculationView.setText(displayCalculation);
                    }

                }
                else{
                    currentCalculation += "9";
                    displayCalculation += "9";
                    calculationView.setText(displayCalculation);
                }
                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(LOW_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();
            }
        });

        logB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onVarClicks();
                currentCalculation += "log(10,";
                displayCalculation += "log(";
                calculationView.setText(displayCalculation);
                equalsMethod();
                onAllClicks();
            }
        });

        lnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onVarClicks();
                currentCalculation += "ln(";
                displayCalculation += "ln(";
                calculationView.setText(displayCalculation);
                equalsMethod();
                onAllClicks();
            }
        });

        bracketB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentCalculation.endsWith("*") || currentCalculation.endsWith("+") || currentCalculation.endsWith("-") || currentCalculation.endsWith("/") || !(currentCalculation.contains("("))){
                    currentCalculation += "(";
                    displayCalculation += "(";
                    calculationView.setText(displayCalculation);
                    equalsMethod();
                    onAllClicks();
                }
                else{
                    currentCalculation += ")";
                    displayCalculation += ")";
                    calculationView.setText(displayCalculation);
                    equalsMethod();
                    onAllClicks();
                }

            }
        });

        bracketB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                currentCalculation += "(";
                displayCalculation += "(";
                calculationView.setText(displayCalculation);
                equalsMethod();
                return true;
            }
        });

        sinB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onVarClicks();
                if(angle == true){
                    currentCalculation += "sin([deg]*";
                    displayCalculation += "sin(";
                    calculationView.setText(displayCalculation);

                }
                else{
                    currentCalculation += "sin([rad]*";
                    displayCalculation += "sin(";
                    calculationView.setText(displayCalculation);
                }
                equalsMethod();
                onAllClicks();

            }
        });

        sinB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onVarClicks();
                if(angle == true){
                    currentCalculation += "asin([deg]*";
                    displayCalculation += "arcsin(";
                    calculationView.setText(displayCalculation);
                    equalsMethod();
                    onAllClicks();
                    return true;
                }
                else {
                    currentCalculation += "asin([rad]*";
                    displayCalculation += "arcsin(";
                    calculationView.setText(displayCalculation);
                    equalsMethod();
                    onAllClicks();
                    return true;
                }

            }
        });

        cosB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onVarClicks();
                if(angle == true){
                    currentCalculation += "cos([deg]*";
                    displayCalculation += "cos(";
                    calculationView.setText(displayCalculation);
                }
                else{
                    currentCalculation += "cos([rad]*";
                    displayCalculation += "cos(";
                    calculationView.setText(displayCalculation);
                }
                equalsMethod();
                onAllClicks();
            }
        });

        cosB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onVarClicks();
                if(angle == true){
                    currentCalculation += "acos([deg]*";
                    displayCalculation += "arccos(";
                    calculationView.setText(displayCalculation);
                    equalsMethod();
                    onAllClicks();
                    return true;
                }
                else{
                    currentCalculation += "acos([rad]*";
                    displayCalculation += "arccos(";
                    calculationView.setText(displayCalculation);
                    equalsMethod();
                    onAllClicks();
                    return true;
                }

            }
        });

        tanB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onVarClicks();
                if(angle == true){
                    currentCalculation += "tan([deg]*";
                    displayCalculation += "tan(";
                    calculationView.setText(displayCalculation);
                }
                else {
                    currentCalculation += "tan([rad]*";
                    displayCalculation += "tan(";
                    calculationView.setText(displayCalculation);
                }
                equalsMethod();
                onAllClicks();

            }
        });

        tanB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onVarClicks();
                if(angle == true){
                    currentCalculation += "atan([deg]*";
                    displayCalculation += "arctan(";
                    calculationView.setText(displayCalculation);
                    equalsMethod();
                    onAllClicks();
                    return true;
                }
                else{
                    currentCalculation += "atan([rad]*";
                    displayCalculation += "arctan(";
                    calculationView.setText(displayCalculation);
                    equalsMethod();
                    onAllClicks();
                    return true;
                }
            }
        });

        exponentB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCalculation += "^(";
                displayCalculation += "^(";
                calculationView.setText(displayCalculation);
                equalsMethod();
                /*if(exponentOn == true){
                    exponentOn = false;
                    currentCalculation += ")";
                    exponentB.setTextColor(getResources().getColor(R.color.myGray));
                }
                else{
                    exponentOn = true;
                    firstExponent = true;
                    exponentB.setTextColor(getResources().getColor(R.color.colorAccent));

                }*/
            }
        });

        multB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(calculadora_cientifica.this, R.anim.rotate_around_center_point);
                multB.startAnimation(animation);
                currentCalculation += "*";
                displayCalculation += "×";
                calculationView.setText(displayCalculation);
                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(MED_IMPORTANCE_KEY_VIBRATE);
                onAllClicks();
                equalsMethod();
            }
        });

        plusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(calculadora_cientifica.this, R.anim.rotate_around_center_point);
                plusB.startAnimation(animation);

                currentCalculation += "+";
                displayCalculation += "+";
                calculationView.setText(displayCalculation);
                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(MED_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();
            }
        });

        plusB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(pVisible == false){
                    Expression e = new Expression("ispr(" + previousAns + ")");
                    String result = String.valueOf(e.calculate());
                    if(result.equals("0.0")){
                        result = "false";
                    }
                    else{
                        result = "true";
                    }
                    pView.setText(result);
                    pView.setVisibility(TextView.VISIBLE);
                    pVisible = true;
                    return true;
                }
                else{
                    pVisible = false;
                    pView.setVisibility(TextView.INVISIBLE);
                    return true;
                }
            }
        });

        divB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(calculadora_cientifica.this, R.anim.rotate2);
                divB.startAnimation(animation);
                currentCalculation += "/";
                displayCalculation += "÷";
                calculationView.setText(displayCalculation);
                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(MED_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();
            }
        });

        divB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                currentCalculation += "C(";
                displayCalculation += "C(";
                calculationView.setText(displayCalculation);
                equalsMethod();
                onAllClicks();
                return true;

            }
        });

        minusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(calculadora_cientifica.this, R.anim.rotate_around_center_point);
                minusB.startAnimation(animation);
                currentCalculation += "-";
                displayCalculation += "-";
                calculationView.setText(displayCalculation);
                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(MED_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();
            }
        });

        minusB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                currentCalculation += ",";
                displayCalculation += ",";
                calculationView.setText(displayCalculation);
                equalsMethod();
                onAllClicks();
                return true;
            }
        });

        delB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(MED_IMPORTANCE_KEY_VIBRATE);

                if(displayCalculation.length() < 1){
                    int a = 1;
                    Log.e("limiting", "now");
                }
                else{
                    if(currentCalculation.endsWith("asin([rad]*") || currentCalculation.endsWith("asin([deg]*") || currentCalculation.endsWith("acos([rad]*")
                            || currentCalculation.endsWith("acos([deg]*") || currentCalculation.endsWith("atan([rad]*") || currentCalculation.endsWith("atan([deg]*")){
                        currentCalculation = currentCalculation.substring(0, currentCalculation.length() - 11);
                        displayCalculation = displayCalculation.substring(0, displayCalculation.length() - 7);
                        calculationView.setText(displayCalculation);
                    }
                    else if(currentCalculation.endsWith("sin([rad]*") || currentCalculation.endsWith("cos([rad]*") || currentCalculation.endsWith("tan([rad]*")
                            || currentCalculation.endsWith("sin[deg]*") || currentCalculation.endsWith("cos[deg]*") || currentCalculation.endsWith("tan([deg]*")){
                        currentCalculation = currentCalculation.substring(0, currentCalculation.length() - 10);
                        displayCalculation = displayCalculation.substring(0, displayCalculation.length() - 4);
                        calculationView.setText(displayCalculation);
                    }
                    else if(currentCalculation.endsWith("ln(")){
                        currentCalculation = currentCalculation.substring(0, currentCalculation.length() - 3);
                        displayCalculation = displayCalculation.substring(0, displayCalculation.length() - 3);
                        calculationView.setText(displayCalculation);
                    }
                    else if(currentCalculation.endsWith("log(10,") || currentCalculation.endsWith("lcm(") || currentCalculation.endsWith("gcd(")){
                        currentCalculation = currentCalculation.substring(0, currentCalculation.length() - 4);
                        displayCalculation = displayCalculation.substring(0, displayCalculation.length() - 4);
                        calculationView.setText(displayCalculation);
                    }
                    else if(currentCalculation.endsWith("c(")){
                        currentCalculation = currentCalculation.substring(0, currentCalculation.length() - 2);
                        displayCalculation = displayCalculation.substring(0, displayCalculation.length() - 2);
                        calculationView.setText(displayCalculation);
                    }
                    else if(currentCalculation.endsWith("Error")){
                        currentCalculation = currentCalculation.substring(0, currentCalculation.length() - 5);
                        displayCalculation = displayCalculation.substring(0, displayCalculation.length() - 5);
                        calculationView.setText(displayCalculation);
                    }
                    else if(currentCalculation.endsWith("pi")){
                        currentCalculation = currentCalculation.substring(0, currentCalculation.length() - 2);
                        displayCalculation = displayCalculation.substring(0, displayCalculation.length() - 1);
                        calculationView.setText(displayCalculation);
                    }
                    else if(currentCalculation.endsWith("[phi]")){
                        currentCalculation = currentCalculation.substring(0, currentCalculation.length() - 5);
                        displayCalculation = displayCalculation.substring(0, displayCalculation.length() - 1);
                        calculationView.setText(displayCalculation);
                    }
                    else if(displayCalculation.endsWith("Ans")){
                        currentCalculation = currentCalculation.substring(0, currentCalculation.length() - previousAns.length());
                        displayCalculation = displayCalculation.substring(0, displayCalculation.length() - 3);
                        calculationView.setText(displayCalculation);
                    }
                    else{
                        currentCalculation = currentCalculation.substring(0, currentCalculation.length() - 1);
                        displayCalculation = displayCalculation.substring(0, displayCalculation.length() - 1);
                        calculationView.setText(displayCalculation);
                    }
                }
                equalsMethod();
                onAllClicks();

            }
        });

        clrB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(HIGH_IMPORTANCE_KEY_VIBRATE);

                Animation fadeOut = new AlphaAnimation(1, 0);
                fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
                fadeOut.setStartOffset(200);
                fadeOut.setDuration(400);


                // previously invisible view
                final View mv = findViewById(R.id.awesome_card);

                // get the center for the clipping circle
                int centerX = (mv.getRight());
                int centerY = (mv.getBottom());

                int startRadius = 0;
                // get the final radius for the clipping circle
                int endRadius = Math.max(mv.getWidth(), mv.getHeight());

                // create the animator for this view (the start radius is zero)
                Animator anim =
                        ViewAnimationUtils.createCircularReveal(mv, centerX, centerY, startRadius, endRadius);


                AnimationSet animation = new AnimationSet(false); //change to false
                animation.addAnimation(fadeOut);
                mv.setAnimation(animation);

                pView.setVisibility(View.INVISIBLE);
                pVisible = false;


                anim.setDuration(300);
                // make the view visible and start the animation
                anim.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mv.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                mv.setVisibility(View.VISIBLE);
                anim.start();

                currentCalculation = " ";
                displayCalculation = " ";
                calculationView.setText(displayCalculation);
                if(exponentOn == true){
                    exponentOn = false;
                    firstExponent = true;
                    //exponentB.setTextColor(getResources().getColor(R.color.black));
                }
                instantCalcView.setText("");
                scrollOnClear();
                calculationView.startAnimation(AnimationUtils.loadAnimation(calculadora_cientifica.this, R.anim.slide_in_left));

                //calculationView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_out_right));


            }
        });

        decimalB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(exponentOn == true){
                    if (firstExponent == true){
                        currentCalculation += "^(0.";
                        displayCalculation += "0.";
                        calculationView.setText(displayCalculation);
                        firstExponent = false;
                    }
                    else {
                        if (currentCalculation.endsWith("*") || currentCalculation.endsWith("-") || currentCalculation.endsWith("+") || currentCalculation.endsWith("/") || (currentCalculation.trim().length() == 0)){
                            currentCalculation += "0";
                            displayCalculation += "0";
                        }
                        currentCalculation += ".";
                        displayCalculation += ".";
                        calculationView.setText(displayCalculation);
                    }

                }
                else{
                    if (currentCalculation.endsWith("*") || currentCalculation.endsWith("-") || currentCalculation.endsWith("+") || currentCalculation.endsWith("/") || (currentCalculation.trim().length() == 0)){
                        currentCalculation += "0";
                        displayCalculation += "0";
                    }
                    currentCalculation += ".";
                    displayCalculation += ".";
                    calculationView.setText(displayCalculation);
                }
                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(LOW_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();
            }
        });

        decimalB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onVarClicks();
                if(exponentOn == true){
                    if (firstExponent == true){
                        currentCalculation += "^(pi";
                        displayCalculation += "π";
                        calculationView.setText(displayCalculation);
                        firstExponent = false;
                    }
                    else {
                        currentCalculation += "pi";
                        displayCalculation += "π";
                        calculationView.setText(displayCalculation);
                    }

                }
                else{
                    currentCalculation += "pi";
                    displayCalculation += "π";
                    calculationView.setText(displayCalculation);
                }
                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(LOW_IMPORTANCE_KEY_VIBRATE);
                equalsMethod();
                onAllClicks();
                return true;
            }
        });

        ansB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onVarClicks();
                if(previousAns != null){
                    currentCalculation += previousAns;
                    displayCalculation += "Ans";
                    calculationView.setText(displayCalculation);
                }
                equalsMethod();
                onAllClicks();

            }
        });

        ansB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Answer", previousAns);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "Answer copied to clipboard", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        equalsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                v.playSoundEffect(SoundEffectConstants.CLICK);

                Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vv.vibrate(MED_IMPORTANCE_KEY_VIBRATE);


                if(currentCalculation.equals("") || currentCalculation.equals(" ") || currentCalculation.equals("   ")){
                    return;
                }

                if(exponentOn == true){
                    currentCalculation += ")";
                    exponentOn = false;
                    firstExponent = true;
                    //exponentB.setTextColor(getResources().getColor(R.color.black));
                }

                //Log.e("backgroundC", currentCalculation);
                //Log.e("displayC", displayCalculation);

/*                if(currentCalculation.contains("pi")){
                    String xx = currentCalculation;
                    xx = xx.substring(0, 4) + "." + xx.substring(4, xx.length());
                }*/

                Expression e = new Expression(currentCalculation);
                String result = String.valueOf(e.calculate());
                if (result.equals("NaN")){
                    e = new Expression(currentCalculation + ")");
                    result = String.valueOf(e.calculate());
                }
                if(result.endsWith("E-16") || result.endsWith("E-15") || result.endsWith("E-14")){
                    result = "0";
                }
                if (result.endsWith(".0")){
                    result = result.substring(0, result.length() - 2);
                }

                try{
                    double dd = Double.parseDouble(result);
                    if(!result.contains("E")){
                        String df = new DecimalFormat("#######################.############").format(dd);
                        result = df;
                    }


                }
                catch (Exception f){

                }


                if (pVisible == true){
                    //pView.setVisibility(View.INVISIBLE);
                    //pVisible = false;
                }

                if(!(result.equals("NaN") && !(result.equals("∞")))){
                    previousAns = result;
                    saveAnswer(result);
                }
                else if (result.equals("NaN")){
                    result = "Error";
                    //result = "";
                }
                else if (result.equals("∞")){
                    result = "∞";
                }


                //instantCalcView.setText(" " + result);
                if(result.equals("Error")){
                    instantCalcView.setText(" " + result);
                    result = "";
                }
                else{
                    instantCalcView.setText(" " + result);
                    instantCalcView.setTextColor(getResources().getColor(R.color.clearView3));
                    calculationView.setText(" " + "Ans");
                    displayCalculation = (" " + "Ans");
                    currentCalculation = result;
                }
                binPressed = false;
                scrollOnClear();





            }
        });

        binButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String newR = previousAns.replaceAll("\\s+","");;
                if(binPressed == true){
                    return;
                }
                String ccv = String.valueOf(instantCalcView.getText());
                Log.e("INBIN", ccv);
                try{
                    ccv = ccv.replaceAll("\\s+","");;
                    Integer newR2 = Integer.parseInt(ccv);
                    instantCalcView.setText(Integer.toBinaryString(newR2));
                    //equalsMethod();
                }
                catch (Exception e){}
                binPressed = true;

            }

        });

        binButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //String newR = previousAns.replaceAll("\\s+","");
                if(binPressed == true){
                    return true;
                }
                String ccv = String.valueOf(instantCalcView.getText());
                try{
                    ccv = ccv.replaceAll("\\s+","");;
                    Integer newR2 = Integer.parseInt(ccv);
                    instantCalcView.setText(Integer.toHexString(newR2));
                    //equalsMethod();
                }
                catch (Exception e){}
                binPressed = true;
                return true;
            }
        });

        equalsB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                    Rational fraction = new Rational(Double.valueOf(String.valueOf(instantCalcView.getText())));
                    instantCalcView.setText(" " + fraction.simple());
                } catch (Exception ea) {
                    ea.printStackTrace();
                }
                return true;
            }
        });


        angleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(angle == true){
                    angleB.setText("RAD");
                    //angleB.setTextColor(Color.RED);
                    saveAngle("rad");
                    angle = false;
                    String ccv = String.valueOf(currentCalculation);
                    Log.e("CCV", ccv);
                    ccv = ccv.replace("deg", "rad");
                    Log.e("CCV2", ccv);
                    currentCalculation = ccv;
                    equalsMethod();
                    //currentCalculation.replaceAll("rad", "deg");
                }
                else{
                    angleB.setText("DEG");
                    //angleB.setTextColor(getResources().getColor(R.color.degree));
                    saveAngle("deg");
                    angle = true;
                    String ccv = String.valueOf(currentCalculation);
                    ccv = ccv.replace("rad", "deg");
                    currentCalculation = ccv;
                    equalsMethod();
                    //currentCalculation.replaceAll("deg", "rad");
                }
            }
        });





    }



    public void onAllClicks(){
        TextView instantC = (TextView)findViewById(R.id.instantCalcluationView);
        TextView calculationView = (TextView)findViewById(R.id.calcView);
        HorizontalScrollView mSV = (HorizontalScrollView)findViewById(R.id.myScrollView);
        Layout layout = instantC.getLayout();
        mSV.smoothScrollTo(mSV.getRight(), 0);
        calculationView.setTextColor(getResources().getColor(R.color.basic_text));

    }

    public void onVarClicks(){
        if (!(currentCalculation.endsWith("*") || currentCalculation.endsWith("-") || currentCalculation.endsWith("+") || currentCalculation.endsWith("/") || currentCalculation.endsWith("(") || currentCalculation.endsWith("#") || (currentCalculation.trim().length() == 0))){
            currentCalculation += "*";
            displayCalculation += "×";
        }


    }


    public void scrollOnClear(){
        TextView instantC = (TextView)findViewById(R.id.instantCalcluationView);
        HorizontalScrollView mSV = (HorizontalScrollView)findViewById(R.id.myScrollView);
        Layout layout = instantC.getLayout();
        mSV.smoothScrollTo(-1000, 0);

    }


    public void equalsMethod(){
        TextView calculationView = (TextView)findViewById(R.id.calcView);
        TextView instantCalcView = (TextView)findViewById(R.id.instantCalcluationView);
        TextView pView = (TextView)findViewById(R.id.primeView);
        instantCalcView.setTextColor(getResources().getColor(R.color.basic_text));

        //Catch for international users - turn commas into decimals
        if(currentCalculation.contains(",") && (!(currentCalculation.contains("lcm")) && !(currentCalculation.contains("gcd"))) && (!(currentCalculation.contains("C")))){
            currentCalculation = currentCalculation.replace(",", ".");
        }

        try {
            //currentCalculation = currentCalculation.replace("Ans", previousAns);
            //displayCalculation = displayCalculation.replace("Ans", previousAns);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(currentCalculation.equals("") || currentCalculation.equals(" ") || currentCalculation.equals("   ")){
            return;
        }

        if(exponentOn == true){
            currentCalculation += ")";
            exponentOn = false;
            firstExponent = true;
            //exponentB.setTextColor(getResources().getColor(R.color.black));
        }
        //abc
        Log.e("backgroundC", currentCalculation);
        Log.e("displayC", displayCalculation);

        if(currentCalculation.contains("+.")) {
            Log.e("DECIMAL","DETECTED");
            for(int i = 0; i < currentCalculation.length(); i++){
                if(currentCalculation.substring(i, i+1).equals("+.")){
                    currentCalculation = currentCalculation.substring(0, i) + "0" + currentCalculation.substring(i, currentCalculation.length());
                    Log.e(currentCalculation, "DECIMAL");

                }
            }

        }
        Expression e = new Expression(currentCalculation);
        String result = String.valueOf(e.calculate());
        if (result.equals("NaN")){
            e = new Expression(currentCalculation + ")");
            result = String.valueOf(e.calculate());

        }
        if(result.endsWith("E-16") || result.endsWith("E-15") || result.endsWith("E-14")){
            result = "0";
        }
        if (result.endsWith(".0")){
            result = result.substring(0, result.length() - 2);
        }

        try{
            double dd = Double.parseDouble(result);
            if(!result.contains("E")){
                String df = new DecimalFormat("#######################.############").format(dd);
                result = df;
            }


        }
        catch (Exception f){

        }

        if(!(result.equals("NaN"))){
            //previousAns = result;
        }
        else{
            result = "Error";
        }
        if(!result.equals("Error")){
            //currentCalculation = currentCalculation.replace(previousAns, "Ans");
            //displayCalculation = displayCalculation.replace(previousAns, "Ans");
            calculationView.setText(" " + result);
        }
        //
        if(pVisible == true){
            Expression ex = new Expression("ispr(" + calculationView.getText()  + ")");
            String result2 = String.valueOf(ex.calculate());
            if(result2.equals("0.0")){
                result2 = "false";
            }
            else{
                result2 = "true";
            }
            pView.setText(result2);
            pView.setVisibility(TextView.VISIBLE);
        }

        if(calculationView.getText().length() > 17){
            calculationView.setTextSize(30);
        }
        else{
            calculationView.setTextSize(34);
        }
        binPressed = false;
        //displayCalculation = " " + result;
        //currentCalculation = result;
    }



    public void saveAnswer(String meth){
        //Local data storage
        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("answer", meth);
        editor.commit();
    }

    public String loadAnswer(){
        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        String myMethod = sharedPreferences.getString("answer", defaultMethod);
        return (myMethod);
    }

    public void saveTheme(String meth){
        //Local data storage
        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("theme", meth);
        editor.commit();
    }

    public String loadTheme(){
        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        String myMethod = sharedPreferences.getString("theme", defaultMethod);
        return (myMethod);
    }

    public void saveAngle(String meth){
        //Local data storage
        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("angle", meth);
        editor.commit();
    }

    public String loadAngle(){
        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        String myMethod = sharedPreferences.getString("angle", defaultMethod);
        return (myMethod);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Initialize widgets
        final Button zeroB = (Button)findViewById(R.id.zeroButton);
        final Button oneB = (Button)findViewById(R.id.oneButton);
        final Button twoB = (Button)findViewById(R.id.twoButton);
        final Button threeB = (Button)findViewById(R.id.threeButton);
        final Button fourB = (Button)findViewById(R.id.fourButton);
        final Button fiveB = (Button)findViewById(R.id.fiveButton);
        final Button sixB = (Button)findViewById(R.id.sixButton);
        final Button sevenB = (Button)findViewById(R.id.sevenButton);
        final Button eightB = (Button)findViewById(R.id.eightButton);
        final Button nineB = (Button)findViewById(R.id.nineButton);
        final Button decimalB = (Button)findViewById(R.id.decimalButton);
        final Button ansB = (Button)findViewById(R.id.ansButton);
        final Button multB = (Button)findViewById(R.id.multiplyButton);
        final Button minusB = (Button)findViewById(R.id.minusButton);
        final Button divB = (Button)findViewById(R.id.divideButton);
        final Button equalsB = (Button)findViewById(R.id.equalsButton);
        final Button plusB = (Button)findViewById(R.id.plusButton);
        final Button sinB = (Button)findViewById(R.id.sinButton);
        final Button tanB = (Button)findViewById(R.id.tanButton);
        final Button cosB = (Button)findViewById(R.id.cosButton);
        Button delB = (Button)findViewById(R.id.deleteButton);
        Button clrB = (Button)findViewById(R.id.clearButton);
        final Button bracketB = (Button) findViewById(R.id.bracketButton);
        final Button logB = (Button)findViewById(R.id.logButton);
        final Button lnB = (Button)findViewById(R.id.lnButton);
        final Button binButton = (Button)findViewById(R.id.bbb);
        final Button sqrtB = (Button)findViewById(R.id.sqrtButton);

        final TextView calculationView = (TextView)findViewById(R.id.instantCalcluationView);
        final TextView pView = (TextView)findViewById(R.id.primeView);
        final Button angleB = (Button)findViewById(R.id.angleButton);
        final Button exponentB = (Button) findViewById(R.id.exponentButton);
        final TextView instantCalcView = (TextView)findViewById(R.id.calcView);
        final LinearLayout myLinear = (LinearLayout)findViewById(R.id.linearLayout);
        final ConstraintLayout myLayout = (ConstraintLayout)findViewById(R.id.myBackLayout);
        final RevealFrameLayout myReveal = (RevealFrameLayout)findViewById(R.id.revealFrameLayout);
        final View mvv = findViewById(R.id.awesome_card);




        int numButtonColor = Color.WHITE;
        int cardBackgroundColor = getResources().getColor(R.color.lightRed);
        int backgroundColor = getResources().getColor(R.color.naturalBlack);
        int functionButtonColor = getResources().getColor(R.color.grayC);
        int equalsButtonColor = R.color.equalsButtonOriginalx;


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            equalsB.setBackgroundTintList(ContextCompat.getColorStateList(calculadora_cientifica.this, equalsButtonColor));
        }


    }

}