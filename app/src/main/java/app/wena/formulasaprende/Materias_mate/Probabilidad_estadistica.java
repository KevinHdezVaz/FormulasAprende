package app.wena.formulasaprende.Materias_mate;

import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.Mediana;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.compatible_incopatible;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.desviacion_estandar;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.distribucionBinomial_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.esperanzaMatematica_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.laplace_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.modaDatosAgrupados_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.operacionesConjuntos_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.ordenaciones_combinacion_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.permutaciones_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.probabilidadCondicional_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.promedio_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.varianza_children;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;
import app.wena.formulasaprende.resolver.matematicas.probabilidad_ejer;

import android.content.Intent;

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
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class Probabilidad_estadistica extends AppCompatActivity {
    ExpandableListView expandableListView;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probabilidad_estadistica);


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
        listItems.add(new lista2((R.drawable.bar_chart),"Moda"));
        listItems.add(new lista2((R.drawable.bar_chart),getString(R.string.media_aritmetica)));
        listItems.add(new lista2((R.drawable.bar_chart), getString(R.string.desviacion_estandar)));
        listItems.add(new lista2((R.drawable.bar_chart), getString(R.string.varianza)));
        listItems.add(new lista2((R.drawable.bar_chart), "Distribucion Binomial"));

        listItems.add(new lista2((R.drawable.bar_chart), getString(R.string.operaciones_conjuntos)));
        listItems.add(new lista2((R.drawable.bar_chart), getString(R.string.probabilidad_condicional)));
        listItems.add(new lista2((R.drawable.bar_chart), getString(R.string.esperanza_matematica)));
        listItems.add(new lista2((R.drawable.bar_chart), getString(R.string.permutaciones)));
        listItems.add(new lista2((R.drawable.bar_chart), getString(R.string.ordenaciones_combinaciones)));
        listItems.add(new lista2((R.drawable.bar_chart), "Mediana"));
        listItems.add(new lista2((R.drawable.bar_chart), "Ley de Laplace"));
        listItems.add(new lista2((R.drawable.bar_chart), "Sucesos Compatibles e Incompatibles"));



        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Probabilidad_estadistica.this, modaDatosAgrupados_children.class);
                    startActivity(intent);
                }
                else if (i == 1) {
                    Intent intent = new Intent(Probabilidad_estadistica.this, promedio_children.class);
                    startActivity(intent);
                }
                else if (i == 2) {
                    Intent intent = new Intent(Probabilidad_estadistica.this, desviacion_estandar.class);
                    startActivity(intent);
                }
                else if (i == 3) {
                    Intent intent = new Intent(Probabilidad_estadistica.this, varianza_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                    startActivity(intent);
                }
                else if (i == 4) {
                    Intent intent = new Intent(Probabilidad_estadistica.this, distribucionBinomial_children.class);
                    startActivity(intent);
                }
                else if (i == 5) {
                    Intent intent = new Intent(Probabilidad_estadistica.this, operacionesConjuntos_children.class);
                    startActivity(intent);
                }
                else if (i == 6) {
                    Intent intent = new Intent(Probabilidad_estadistica.this, probabilidadCondicional_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                    startActivity(intent);
                }
                else if (i == 7) {
                    Intent intent = new Intent(Probabilidad_estadistica.this, esperanzaMatematica_children.class);
                    startActivity(intent);
                }
                else if (i == 8) {
                    Intent intent = new Intent(Probabilidad_estadistica.this, permutaciones_children.class);
                    startActivity(intent);
                }
                else if (i == 9) {
                    Intent intent = new Intent(Probabilidad_estadistica.this, ordenaciones_combinacion_children.class);
                    startActivity(intent);
                }
                else if (i == 10) {
                    Intent intent = new Intent(Probabilidad_estadistica.this, Mediana.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                    startActivity(intent);
                }
                else if (i == 11) {

                    Intent intent = new Intent(Probabilidad_estadistica.this, laplace_children.class);
                    startActivity(intent);
                }
                else if (i == 12) {

                    Intent intent = new Intent(Probabilidad_estadistica.this, compatible_incopatible.class);
                    startActivity(intent);
                }
            }
        });




        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Probabilidad_estadistica.this, probabilidad_ejer.class);

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }

                else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                startActivity(intent);

            }
        });


//boton flotante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Probabilidad_estadistica.this, Menu_principal.class);

                startActivity(intent);
                finish();

            }
        });
    }
}