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
import android.widget.ExpandableListView;
import android.widget.ListView;

 import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.AreayVolumen.Principales;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.circunferenciaCentroOrigen_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.circunferenciaFueraOrigen_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.distanciaDosPuntos_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.distanciaPuntorec_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.ecuacionGralConi_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.formaPuntoPendiente_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.hiperbola_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.modulo_vector_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.parabolaFueraOrigen_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.parabolaOrigen_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.puntoMedio_children;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;
import app.wena.formulasaprende.resolver.matematicas.Geometria_ejer;

public class geometria extends AppCompatActivity {
    ExpandableListView expandableListView;
    private AdView mAdView;
    private ListView list;
    private CustomAdapter3 adaptador;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometria);



        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstic_ori));
        //original  ca-app-pub-8882667917768463/3391564183
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });



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



        list = (ListView) findViewById(R.id.item2_2);

        final ArrayList<lista2> listItems = new ArrayList<>();
        listItems.add(new lista2((R.drawable.longitud),getString(R.string.calcular_area)));

        listItems.add(new lista2((R.drawable.cuboo),getString(R.string.distancia_entre_dos)));
        listItems.add(new lista2((R.drawable.cuboo),getString(R.string.punto_medio)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.punto_pendiente)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.distancia_punto_recta)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.ecuacion_general_conica)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.circunferencia_centro_origen)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.circunferencia_fuera_origen)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.hiperbola)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.modulo_vector)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.parabola_origen)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.parabola_fuera_origen)));



        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(geometria.this, Principales.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(geometria.this, distanciaDosPuntos_children.class);
                    startActivity(intent);
                }
                else if (i == 2) {
                    Intent intent = new Intent(geometria.this, puntoMedio_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                  startActivity(intent);
                }
                else if (i == 3) {
                    Intent intent = new Intent(geometria.this, formaPuntoPendiente_children.class);
                    startActivity(intent);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }  }
                else if (i == 4) {
                     Intent intent = new Intent(geometria.this, distanciaPuntorec_children.class);
                  startActivity(intent);
                }
                else if (i == 5) {
                    Intent intent = new Intent(geometria.this, ecuacionGralConi_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                    startActivity(intent);
                }
                else if (i == 6) {
                    Intent intent = new Intent(geometria.this, circunferenciaCentroOrigen_children.class);
                    startActivity(intent);
                }
                else if (i == 7) {
                     Intent intent = new Intent(geometria.this, circunferenciaFueraOrigen_children.class);
                    startActivity(intent);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }}
                else if (i == 8) {
                    Intent intent = new Intent(geometria.this, hiperbola_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();

                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                    startActivity(intent);
                }
                else if (i == 9) {
                    Intent intent = new Intent(geometria.this, modulo_vector_children.class);
                    startActivity(intent);
                }   else if (i == 10) {
                    Intent intent = new Intent(geometria.this, parabolaOrigen_children.class);
                    startActivity(intent);
                }
                else if (i == 11) {
                    Intent intent = new Intent(geometria.this, parabolaFueraOrigen_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                    startActivity(intent);
                }

            }
        });
        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(geometria.this, Geometria_ejer.class);

                startActivity(intent);

            }
        });

//boton flotante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(geometria.this, Menu_principal.class);

                startActivity(intent);
                finish();

            }
        });
    }
}

