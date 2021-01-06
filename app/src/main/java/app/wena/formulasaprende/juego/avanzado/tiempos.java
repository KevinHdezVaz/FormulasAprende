package app.wena.formulasaprende.juego.avanzado;

import app.wena.formulasaprende.R;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;


import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class tiempos extends AppCompatActivity {
    private static final String PRF_COUNTDOWN_FILE = "cdt-preferences";
    private static final String PRF_CDT_LAST_RECORDED = "prf-cdt-last-recorded";
    private static final String PRF_CDT_LAST_VALUE = "prf-cdt-last-value";
    CountDownTimer cdt = null;
    SharedPreferences prefs;
    TextView tvHora, tvMsg;
    volatile long tiempo;
    Boolean QuickActivit;

    static final String FORMAT = "%02d:%02d:%02d";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempos);

        tvHora = findViewById(R.id.tvHora);
        tvMsg = findViewById(R.id.tvMsg);


         prefs = getSharedPreferences(PRF_COUNTDOWN_FILE,MODE_PRIVATE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        long lastRecorded = prefs.getLong(PRF_CDT_LAST_RECORDED, -1);
        long lastValue = prefs.getLong(PRF_CDT_LAST_VALUE, -1);
        setupCDT(lastRecorded, lastValue);
        if(cdt != null){
            cdt.start();
        }
    }

    @SuppressLint("ApplySharedPref")
    @Override
    protected void onPause() {
        if(cdt != null){
            cdt.cancel();
        }
        SharedPreferences.Editor editor = prefs.edit();

        if(tiempo > 0){
            editor.putLong(PRF_CDT_LAST_RECORDED, System.currentTimeMillis());
            editor.putLong(PRF_CDT_LAST_VALUE, tiempo);
        }

        editor.commit();
        super.onPause();
    }

    private void setupCDT(long lastRecorded, long lastValue){
        long countFrom;
        if(lastRecorded == -1){
            countFrom = 900000;
        }else{
            long now = System.currentTimeMillis();
            long diff = now - lastRecorded;
            countFrom = lastValue - diff;
        }

        if(countFrom > 0 ) {  // Si es menor a cero es que ya pasó un día.
            cdt = new CountDownTimer(countFrom, 1000) {
                @Override
                public void onTick(long l) {
                    onCount1Sec(l);
                }

                @Override
                public void onFinish() {
                    timeUp();
                }
            };
        }else{
            timeUp();
        }
    }

    private void onCount1Sec(long l){
        tiempo = l;
        updateUi();
    }

    @SuppressLint("ApplySharedPref")
    private void timeUp(){
        cdt = null;
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(PRF_CDT_LAST_RECORDED, -1);
        editor.putLong(PRF_CDT_LAST_VALUE, -1);
        editor.commit();
        tiempo = 0;
        updateUi();
    }

    private void updateUi(){
        if(tiempo > 0) {
            String strTiempo = String.format(new Locale("es"), FORMAT,
                    TimeUnit.MILLISECONDS.toHours(tiempo),
                    TimeUnit.MILLISECONDS.toMinutes(tiempo) - TimeUnit.HOURS.toMinutes(
                            TimeUnit.MILLISECONDS.toHours(tiempo)),
                    TimeUnit.MILLISECONDS.toSeconds(tiempo) - TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes(tiempo)
                    ));
            tvHora.setText(strTiempo);
        }else{
            tvHora.setText("00:00:00");
            tvMsg.setText("Finalizado");
            startActivity(new Intent(tiempos.this,QuickActivity.class));
            finish();
        }
    }

}

