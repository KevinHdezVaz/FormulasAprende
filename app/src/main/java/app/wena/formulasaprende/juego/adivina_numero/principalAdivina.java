package app.wena.formulasaprende.juego.adivina_numero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

 import com.mrntlu.toastie.Toastie;
import com.scwang.wave.MultiWaveHeader;

import app.wena.formulasaprende.R;

public class principalAdivina extends AppCompatActivity {
    static EditText et_num_maximo;
    Button btn_jugar;

       Button botonvamo;
    private int musicLength;
    SharedPreferences sharedPref;
    SharedPreferences preferences;
    Boolean mute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_adivina);
        et_num_maximo=findViewById(R.id.et_num_maximo);
        btn_jugar=findViewById(R.id.btn_jugar);
        MultiWaveHeader waveHeader,waveHeader2;





        waveHeader = findViewById(R.id.wave_header);

        waveHeader.setVelocity(6);
        waveHeader.setProgress(1);
        waveHeader.isRunning();
        waveHeader.setGradientAngle(340);
        waveHeader.setWaveHeight(70);
        waveHeader.setStartColor(Color.argb(100,61,126,254));
        waveHeader.setCloseColor(Color.argb(100,97,200,180));

        waveHeader2 = findViewById(R.id.wave_header2);

        waveHeader2.setVelocity(6);
        waveHeader2.setProgress(1);
        waveHeader2.isRunning();

          waveHeader2.setGradientAngle(340);
        waveHeader2.setWaveHeight(70);
        waveHeader2.setStartColor(Color.argb(100,61,126,254));
        waveHeader2.setCloseColor(Color.argb(100,97,200,180));


        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);



    }

    public static int darNumMaximo() {
        String numero = et_num_maximo.getText().toString();
        int numero_maximo = Integer.parseInt(numero);
        return numero_maximo;
    }


    public void jugar(View v){


        if (et_num_maximo.getText().toString().equals(""))
        {
            Toastie.topError(this, "Introduzca un número máximo, y luego pulse jugar", Toast.LENGTH_SHORT).show();
        }
        else
        {
            int n_maximo =  darNumMaximo();

            if(darNumMaximo()>200)
            {
                Toastie.topError(this, "Tampoco te hagas sufrir así, que sea un número menor de 200.", Toast.LENGTH_SHORT).show();
                et_num_maximo.setText("");
            }
            else
            {
                Intent i = new Intent(this, juegoPrincipal.class);
                startActivity(i);
            }

        }
    }




}
