package app.wena.formulasaprende.juego;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


import app.wena.formulasaprende.Activitis.MainActivity;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.juego.avanzado.QuickActivity;
import app.wena.formulasaprende.juego.avanzado.SettingActivity;
import app.wena.formulasaprende.juego.avanzado.score;
import app.wena.formulasaprende.juego.avanzado.splashAva;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LauncherActivity2 extends AppCompatActivity {
    private Menu menu;
    private Boolean mute;
     SharedPreferences sharedPref;
    public int musicLength;
    int totalCount, length;
    private MediaPlayer mediaPlayer;
    ImageView cerrar;
    public static Boolean sonido = true;
     Button botonvam,btnvam2;
    ImageButton muteButton;
    CardView card1,card2,card3,card4,card5,card6,card7;
     Dialog epicDialog;
    Toolbar toolbar;
 FloatingActionButton fab2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_juego);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
          fab2 = findViewById(R.id.fab2);
        mute = sharedPref.getBoolean(SettingActivity.KEY_MUTE_MUSIC,true);

        if(!isTablet(this)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        epicDialog = new Dialog(this);
        muteButton = findViewById(R.id.muteButton);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        card7 = findViewById(R.id.card7);
        final ImageButton addButton = (ImageButton) findViewById(R.id.add);
        final ImageButton subButton = (ImageButton) findViewById(R.id.sub);
        final ImageButton mulButton = (ImageButton) findViewById(R.id.mul);
        final ImageButton adivinaNumer = (ImageButton) findViewById(R.id.adivinaNumero);
        final ImageButton adivinaNumer2 = (ImageButton) findViewById(R.id.pregunta);
        final ImageButton adivinaNumer3 = (ImageButton) findViewById(R.id.ultimoGame);
        card1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_right_0));
        card2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_advanced));
        card3.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_right_0));
        card4.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_advanced));
        card5.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_right_0));
        card6.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_advanced));
        card7.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_right_0));
         toolbar = (Toolbar) findViewById(R.id.my_toolbar);
         setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar...
                Intent intent = new Intent (LauncherActivity2.this, MainActivity.class);
                startActivity(intent);

            }
        });





        mediaPlayer = MediaPlayer.create(this,R.raw.up_your_stree);
        mediaPlayer.setLooping(true);

        if(!mute) {
            mediaPlayer.start();
            muteButton.setImageResource(R.drawable.ic_volume_up_black_24dp);
        }else{
            muteButton.setImageResource(R.drawable.ic_volume_off_black_24dp);
        }









    }
    public void suma(View view )
    {

        Intent intent = new Intent(LauncherActivity2.this, QuizActivity.class);
        intent.putExtra("operation", "add");
        startActivity(intent);

    }


    public void resta(View view )
    {
        Intent intent = new Intent(LauncherActivity2.this, QuizActivity.class);
        intent.putExtra("operation", "sub");
        startActivity(intent);
    }


    public void multi(View view )
    {
        Intent intent = new Intent(LauncherActivity2.this, QuizActivity.class);
        intent.putExtra("operation", "mul");
        startActivity(intent);
    }


    public void adivina(View view )
    {
        mostrarInfoPRO();
    }

    public void splash(View view )
    {
        Intent intent = new Intent(LauncherActivity2.this, splashAva.class);
        startActivity(intent);

    }

    public void quick(View view ) {
        Intent intent = new Intent(LauncherActivity2.this, QuickActivity.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {

        Intent intentnn = new Intent(LauncherActivity2.this,MainActivity.class);
        startActivity(intentnn);
        finish();
    }

    public void tiempo(View view )
    {

        mostrarInfoPRO();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu3, menu);
        return true;
     }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == R.id.puntaje) {

            startActivity(new Intent(LauncherActivity2.this, score.class));

        }

        return super.onOptionsItemSelected(item);
    }









    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public void muteTemp(View view){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            sonido = true;
            sharedPref.edit().putBoolean(SettingActivity.KEY_MUTE_MUSIC,true).apply();
            muteButton.setImageResource(R.drawable.ic_volume_off_black_24dp);
        }else{
            mediaPlayer.start();
            sonido = false;
            sharedPref.edit().putBoolean(SettingActivity.KEY_MUTE_MUSIC,false).apply();
            muteButton.setImageResource(R.drawable.ic_volume_up_black_24dp);
        }
    }
    public void mostrarInfoPRO() {


        epicDialog.setContentView(R.layout.custompro2);
        cerrar = (ImageView) epicDialog.findViewById(R.id.cerrarVentana);
        botonvam = (Button) epicDialog.findViewById(R.id.botonvamo2);
        btnvam2 = (Button) epicDialog.findViewById(R.id.botonvamo3);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();

        botonvam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://play.google.com/store/apps/details?id=app.tercer.juegofinal";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        btnvam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://appgallery.huawei.com/#/app/C103448627";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    //Estos metodos se encargaran del sonido al salirse de la app.
    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer.isPlaying() && !mute){
            mediaPlayer.pause();
            length = mediaPlayer.getCurrentPosition();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (!mediaPlayer.isPlaying() && !mute) {
            mediaPlayer.seekTo(length);
            mediaPlayer.pause();
        }

    }
}