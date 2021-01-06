package app.wena.formulasaprende.Materias_mate;

import android.content.Intent;

import com.google.android.gms.ads.AdListener;
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

import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.angulos_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.matrizCuadrada_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.matrizDiagonal_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.matrizOrtogonal_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.matrizSimetrica_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.matrizTranspuesta_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.multiplicacion_matrices;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.reglaCramer_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.reglaSarrus_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.suma_matrices;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.traza_children;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;

public class algebra_lineal extends AppCompatActivity {
    private ListView list;
    private CustomAdapter3 adaptador;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algebra_lineal2);




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
        //original  ca-app-pub-8882667917768463/3391564183

        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        list = (ListView) findViewById(R.id.item2_2);

        final ArrayList<lista2> listItems = new ArrayList<>();
        listItems.add(new lista2((R.drawable.parabolic),"Simbologia"));
        listItems.add(new lista2((R.drawable.parabolic),getString(R.string.matriz_transpuesta)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.regla_cramer)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.regla_sarrus)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.matriz_cuadrada)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.matriz_diagonal)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.matriz_simetrica)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.traza)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.matriz_ortogonal)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.suma_ma)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.multipli_ma)));




        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);
//boton flotante


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                 if (i == 0) {
                    Intent intent = new Intent(algebra_lineal.this, angulos_children.class);
                    startActivity(intent);
                }else if (i == 1) {
                    Intent intent = new Intent(algebra_lineal.this, matrizTranspuesta_children.class);
                    startActivity(intent);
                }
                 else if (i == 2) {
                     Intent intent = new Intent(algebra_lineal.this, reglaCramer_children.class);
                     startActivity(intent);
                 }
                else if (i == 3) {
                    Intent intent = new Intent(algebra_lineal.this, reglaSarrus_children.class);
                     if (mInterstitialAd.isLoaded()) {
                         mInterstitialAd.show();
                     }
                     else   {
                         Log.d("TAG", "The interstitial wasn't loaded yet.");

                     }
                    startActivity(intent);
                }
                 else if (i == 4) {
                     Intent intent = new Intent(algebra_lineal.this, matrizCuadrada_children.class);
                     if (mInterstitialAd.isLoaded()) {
                         mInterstitialAd.show();
                     }
                     else   {
                         Log.d("TAG", "The interstitial wasn't loaded yet.");

                     }
                     startActivity(intent);
                 }
                 else if (i == 5) {
                     Intent intent = new Intent(algebra_lineal.this, matrizDiagonal_children.class);
                     startActivity(intent);
                 }
                 else if (i == 6) {
                     Intent intent = new Intent(algebra_lineal.this, matrizSimetrica_children.class);
                     startActivity(intent);
                 }
                 else if (i == 7) {
                     Intent intent = new Intent(algebra_lineal.this, traza_children.class);
                     startActivity(intent);
                 }

                 else if (i ==8) {
                     Intent intent = new Intent(algebra_lineal.this, matrizOrtogonal_children.class);
                     startActivity(intent);
                 }

                 else if (i ==9) {
                     Intent intent = new Intent(algebra_lineal.this, suma_matrices.class);
                     if (mInterstitialAd.isLoaded()) {
                         mInterstitialAd.show();
                     }
                     else   {
                         Log.d("TAG", "The interstitial wasn't loaded yet.");

                     }
                     startActivity(intent);
                 }
                 else if (i ==10) {
                     Intent intent = new Intent(algebra_lineal.this, multiplicacion_matrices.class);
                     startActivity(intent);
                 }




            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(algebra_lineal.this, Menu_principal.class);

                startActivity(intent);
                finish();

            }
        });
    }

    }

