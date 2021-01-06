package app.wena.formulasaprende.AreayVolumen;

import app.wena.formulasaprende.GridView_segundoFragment.Spacecraft;
import app.wena.formulasaprende.R;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class Principales extends AppCompatActivity {
    private Adapter2 adaptador;
    private InterstitialAd mInterstitialAd;

    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradiente));
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

        grid = (GridView) findViewById(R.id.item2);

        final ArrayList<Spacecraft> listItems = new ArrayList<>();
        listItems.add(new Spacecraft((R.drawable.triangulo), getString(R.string.triángulo)));
        listItems.add(new Spacecraft((R.drawable.cuadrado), getString(R.string.cuadrado)));
        listItems.add(new Spacecraft((R.drawable.recta),  getString(R.string.rectangulo)));
        listItems.add(new Spacecraft((R.drawable.paralelogramo),  getString(R.string.paralelogramo)));
        listItems.add(new Spacecraft((R.drawable.trapezoide),  getString(R.string.trapecio)));
        listItems.add(new Spacecraft((R.drawable.rombo),  getString(R.string.rombo)));
        listItems.add(new Spacecraft((R.drawable.hexa), getString(R.string.hexagono)));
        listItems.add(new Spacecraft((R.drawable.circ), getString(R.string.circulo)));
        listItems.add(new Spacecraft((R.drawable.elipse), getString(R.string.elipse)));
        listItems.add(new Spacecraft((R.drawable.piramide) , getString(R.string.piramide)));
        listItems.add(new Spacecraft((R.drawable.cubo),  getString(R.string.cubo)));

        listItems.add(new Spacecraft((R.drawable.cilindro),  getString(R.string.cilindro)));
        listItems.add(new Spacecraft((R.drawable.esfera),  getString(R.string.esfera)));
        listItems.add(new Spacecraft((R.drawable.cono),  getString(R.string.cono)));
        listItems.add(new Spacecraft((R.drawable.toro),  getString(R.string.toro)));

        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(Principales.this, Triangulo.class);
                         if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }

                 else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                    startActivity(intent);

                }
                else if (position == 1) {
                    Intent intent = new Intent(Principales.this, Cuadrado.class);
                    startActivity(intent);

                }
                else if (position == 2) {
                    Intent intent = new Intent(Principales.this, Rectangulo.class);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Intent intent = new Intent(Principales.this, Paralelogramo.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }

                    else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }                startActivity(intent);

                }
                else if (position == 4) {
                    Intent intent = new Intent(Principales.this, Trapecio.class);
                    startActivity(intent);
                }
                else if (position == 5) {
                    Intent intent = new Intent(Principales.this, Rombo.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }

                    else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }               startActivity(intent);

                }
                else if (position == 6) {
                    Intent intent = new Intent(Principales.this, Hexagono.class);
                    startActivity(intent);
                }
                else if (position == 7) {
                    Intent intent = new Intent(Principales.this, Circullo.class);
                    startActivity(intent);
                }
                else if (position == 8) {
                    Intent intent = new Intent(Principales.this, Elipse.class);
                    startActivity(intent);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }

                    else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                }
                else if (position == 9) {
                    Intent intent = new Intent(Principales.this, Piramide.class);
                    startActivity(intent);
                }
                else if (position == 10) {
                    Intent intent = new Intent(Principales.this, Cubo.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }

                    else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                    startActivity(intent);

                }
                else if (position == 11) {
                    Intent intent = new Intent(Principales.this, Cilindro.class);
                    startActivity(intent);
                }
                else if (position == 12) {
                    Intent intent = new Intent(Principales.this, Esfera.class);
                    startActivity(intent);
                }
                else if (position == 13) {
                    Intent intent = new Intent(Principales.this, Cono.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }

                    else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }                startActivity(intent);

                }
                else if (position == 14) {
                    Intent intent = new Intent(Principales.this, Toro.class);
                    startActivity(intent);
                }
            }
        });
    }
}