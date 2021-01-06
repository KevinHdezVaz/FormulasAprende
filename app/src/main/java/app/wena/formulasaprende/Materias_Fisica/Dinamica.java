package app.wena.formulasaprende.Materias_Fisica;

import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.Fisica_children.dinamica_children.centro_gravedad_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.descomposicion_regular_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.ley_hooke_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.leyes_newton_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.plano_inclinado_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.principio_bernoulli_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.teorema_lamy_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.vectores_children;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.listview_children.CustomAdapter3;

import app.wena.formulasaprende.listview_children.lista2;
import app.wena.formulasaprende.resolver.dinamica.Dinamica_menu;


import android.content.Intent;

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
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class Dinamica extends AppCompatActivity {
     private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamica);
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
        mInterstitialAd.setAdUnitId(getString(R.string.interstic_ori));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




        list = (ListView) findViewById(R.id.item2_2);

        final ArrayList<lista2> listItems = new ArrayList<>();
        listItems.add(new lista2((R.drawable.gravity), getString(R.string.leyes_newton)));
        listItems.add(new lista2((R.drawable.gravity), getString(R.string.ley_hooke)));
        listItems.add(new lista2((R.drawable.gravity), getString(R.string.principio_bernoulli)));
        listItems.add(new lista2((R.drawable.gravity), getString(R.string.plano_inclinado)));
        listItems.add(new lista2((R.drawable.gravity), getString(R.string.vectores)));
        listItems.add(new lista2((R.drawable.gravity), getString(R.string.descomposicion_rectangular)));
        listItems.add(new lista2((R.drawable.gravity), getString(R.string.centro_gravedad)));

        listItems.add(new lista2((R.drawable.gravity), getString(R.string.teorema_lamy)));
//modulo de un vector


        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Dinamica.this, leyes_newton_children.class);
                    startActivity(intent);
                } else if (i == 1) {
                    Intent intent = new Intent(Dinamica.this, ley_hooke_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }  startActivity(intent);
                } else if (i == 2) {
                    Intent intent = new Intent(Dinamica.this, principio_bernoulli_children.class);
                    startActivity(intent);
                } else if (i == 3) {
                    Intent intent = new Intent(Dinamica.this, plano_inclinado_children.class);
                    startActivity(intent);
                } else if (i == 4) {
                    Intent intent = new Intent(Dinamica.this, vectores_children.class);
                    startActivity(intent);
                } else if (i == 5) {
                    Intent intent = new Intent(Dinamica.this, descomposicion_regular_children.class);
                    startActivity(intent);
                } else if (i == 6) {
                    Intent intent = new Intent(Dinamica.this, centro_gravedad_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }  startActivity(intent);
                }
                else if (i == 7) {
                    Intent intent = new Intent(Dinamica.this, teorema_lamy_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }   startActivity(intent);
                }
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Dinamica.this, Menu_principal.class);

                startActivity(intent);
                finish();
            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Dinamica.this, Dinamica_menu.class);

                startActivity(intent);

            }
        });
    }

   }

