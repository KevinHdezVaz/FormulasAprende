package app.wena.formulasaprende.Materias_Fisica;
import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.biot_savart_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.campo_electrico_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.capacitor_paralelo_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.capacitor_serie_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.circuito_paralelo_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.circuito_serie_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.energia_campo_electrico_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.ley_coulomb_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.ley_ohm_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.movimiento_cargainterior_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.principio_superposicion_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.resistividad_electrica_children;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;
import app.wena.formulasaprende.resolver.fisica.electricidad;

import android.content.Intent;

 import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
 import android.widget.AdapterView;

import android.widget.ListView;

 import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class Electricidad_Mag extends AppCompatActivity {
     private AdView mAdView;
    private InterstitialAd mInterstitialAd; private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricidad__mag);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradiente));
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
        mInterstitialAd.setAdUnitId("ca-app-pub-8882667917768463/3391564183");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);





        list = (ListView) findViewById(R.id.item2_2);

        final ArrayList<lista2> listItems = new ArrayList<>();
        listItems.add(new lista2((R.drawable.magnet), getString(R.string.ley_coulomb)));
        listItems.add(new lista2((R.drawable.magnet), getString(R.string.principio_superposicion)));
        listItems.add(new lista2((R.drawable.magnet), getString(R.string.campo_electrico)));
        listItems.add(new lista2((R.drawable.magnet), getString(R.string.movimiento_cargainterior)));
        listItems.add(new lista2((R.drawable.magnet), getString(R.string.capacitor_serie)));
        listItems.add(new lista2((R.drawable.magnet), getString(R.string.capacitor_paralelo)));
        listItems.add(new lista2((R.drawable.magnet), getString(R.string.energia_campo_electrico)));

        listItems.add(new lista2((R.drawable.magnet), getString(R.string.ley_ohm)));
//modulo de un vector

        listItems.add(new lista2((R.drawable.magnet), getString(R.string.resistividad_electrica)));
        listItems.add(new lista2((R.drawable.magnet), getString(R.string.circuito_serie)));

        listItems.add(new lista2((R.drawable.magnet), getString(R.string.circuito_paralelo)));
        listItems.add(new lista2((R.drawable.magnet), getString(R.string.biot_savart)));

        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Electricidad_Mag.this, ley_coulomb_children.class);
                    startActivity(intent);
                } else if (i == 1) {
                    Intent intent = new Intent(Electricidad_Mag.this, principio_superposicion_children.class);
                    startActivity(intent);
                } else if (i == 2) {
                    Intent intent = new Intent(Electricidad_Mag.this, campo_electrico_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    } startActivity(intent);
                } else if (i == 3) {
                    Intent intent = new Intent(Electricidad_Mag.this, movimiento_cargainterior_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    } startActivity(intent);
                } else if (i == 4) {
                    Intent intent = new Intent(Electricidad_Mag.this, capacitor_serie_children.class);
                    startActivity(intent);
                } else if (i == 5) {
                    Intent intent = new Intent(Electricidad_Mag.this, capacitor_paralelo_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }startActivity(intent);
                } else if (i == 6) {
                    Intent intent = new Intent(Electricidad_Mag.this, energia_campo_electrico_children.class);
                    startActivity(intent);
                }
                else if (i == 7) {
                    Intent intent = new Intent(Electricidad_Mag.this, ley_ohm_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    } startActivity(intent);
                }
                else if (i == 8) {
                    Intent intent = new Intent(Electricidad_Mag.this, resistividad_electrica_children.class);
                    startActivity(intent);
                }
                else if (i == 9) {
                    Intent intent = new Intent(Electricidad_Mag.this, circuito_serie_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    } startActivity(intent);
                }
                else if (i == 10) {
                    Intent intent = new Intent(Electricidad_Mag.this, circuito_paralelo_children.class);
                    startActivity(intent);
                }
                else if (i == 11) {
                    Intent intent = new Intent(Electricidad_Mag.this, biot_savart_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    } startActivity(intent);
                }
            }
        });
        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Electricidad_Mag.this, electricidad.class);

                startActivity(intent);

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Electricidad_Mag.this, Menu_principal.class);

                startActivity(intent);

            }
        });

    }

    }
