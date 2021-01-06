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
import app.wena.formulasaprende.Materias_Fisica.Dinamica;
import app.wena.formulasaprende.Materias_Fisica.Electricidad_Mag;
import app.wena.formulasaprende.Materias_Fisica.Mecanica_fluidos;
import app.wena.formulasaprende.Materias_Fisica.Mecanicaa;
import app.wena.formulasaprende.Materias_Fisica.Optica;
import app.wena.formulasaprende.Materias_Fisica.Termodinamica_fisi;
import app.wena.formulasaprende.R;

public class Fisica_Activity extends AppCompatActivity {
    private ListView list;
    private CustomAdapter2 adaptador;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica_);



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

        listItems.add(new lista((R.drawable.gravity),  getString(R.string.dinamica) ));
        listItems.add(new lista((R.drawable.innovacion), getString(R.string.mecanica)));
        listItems.add(new lista((R.drawable.eyedropper),  getString(R.string.mecanica_fluidos)));

        listItems.add(new lista((R.drawable.termometro),getString(R.string.termodinamica)));
        listItems.add(new lista((R.drawable.magnet),  getString(R.string.Electricidad)));
        listItems.add(new lista((R.drawable.dispersion),  getString(R.string.optica)));

        adaptador = new CustomAdapter2(this, listItems);
        list.setAdapter(adaptador);

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i == 4){
                    Intent intent = new Intent(Fisica_Activity.this, Electricidad_Mag.class);
                    startActivity(intent);
                }
               else if(i == 2){
                    Intent intent = new Intent(Fisica_Activity.this, Mecanica_fluidos.class);

                         if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }

                     else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
               startActivity(intent);

                }
                else if(i == 1){
                    Intent intent = new Intent(Fisica_Activity.this, Mecanicaa.class);
                         if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }

                    startActivity(intent);

                }
                else if(i == 0){
                    Intent intent = new Intent(Fisica_Activity.this, Dinamica.class);
                    startActivity(intent);
                }
                else if(i == 5){
                    Intent intent = new Intent(Fisica_Activity.this, Optica.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                    startActivity(intent);
                }
                else if(i == 3){
                    Intent intent = new Intent(Fisica_Activity.this, Termodinamica_fisi.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }

                  startActivity(intent);

                }
            }
        });


    }
}
