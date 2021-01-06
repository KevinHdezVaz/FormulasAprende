package app.wena.formulasaprende.Ventanas_menú;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

import app.wena.formulasaprende.ListView_primerFragment.CustomAdapter2;
import app.wena.formulasaprende.ListView_primerFragment.lista;
import app.wena.formulasaprende.Materias_Quimica.Estequiometria;
import app.wena.formulasaprende.Materias_Quimica.gases;
import app.wena.formulasaprende.Materias_Quimica.quimica_organica;
import app.wena.formulasaprende.R;

public class Quimica_Activity extends AppCompatActivity {
    private ListView list;
    private CustomAdapter2 adaptador;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quimica_);

        //METODO DEL TOOLBAR PARA QUE REGRESE AL MENU PRINCIPAL
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar...
                finish();
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstic_ori));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        list = (ListView) findViewById(R.id.item2);

        final ArrayList<lista> listItems = new ArrayList<>();
        listItems.add(new lista((R.drawable.chemistry), getString(R.string.quimica_analitica)));
        listItems.add(new lista((R.drawable.gasesx), getString(R.string.gase)));
        listItems.add(new lista((R.drawable.quimico_sd), getString(R.string.quimica_organica)));



        adaptador = new CustomAdapter2(this, listItems);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent intent = new Intent(Quimica_Activity.this, Estequiometria.class);
                    startActivity(intent);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                }
               else  if(i == 1){
                    Intent intent = new Intent(Quimica_Activity.this, gases.class);

                    startActivity(intent);
                }
                else  if(i == 2){
                    Intent intent = new Intent(Quimica_Activity.this, quimica_organica.class);

                    startActivity(intent);
                }
            }
        });

    }
}
