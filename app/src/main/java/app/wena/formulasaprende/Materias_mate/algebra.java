package app.wena.formulasaprende.Materias_mate;


import android.content.Intent;

 import com.google.android.gms.ads.AdListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.binomioNewton_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.conjugadoComplejo_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.factorizacion_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.formulaGeneral_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.leyExponentes_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.leySignos_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.numerosComplejos_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.numerosReales_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.operacionesComplejos_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.productosnotables_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.sumatoria_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.valorAbsoluto_children;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;
import app.wena.formulasaprende.resolver.matematicas.algebra_ejer;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class algebra extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private ListView list;
    private CustomAdapter3 adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algebra);




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

        listItems.add(new lista2((R.drawable.parabolic),getString(R.string.ley_exponentes)));
        listItems.add(new lista2((R.drawable.parabolic),getString(R.string.producto_notable)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.valor_absoluto)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.binomio_newton)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.numeros_reales)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.numeros_complejos)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.ley_signos)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.formula_general)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.formula_sumatoria)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.operaciones_numeros)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.conjugado_numero_complejos)));
        listItems.add(new lista2((R.drawable.parabolic), getString(R.string.factorizacion)));



        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   if (i == 0) {
                    Intent intent = new Intent(algebra.this, leyExponentes_children.class);
                       if (mInterstitialAd.isLoaded()) {
                           mInterstitialAd.show();
                       }
                       else   {
                           Log.d("TAG", "The interstitial wasn't loaded yet.");

                       }
                    startActivity(intent);
                }
                    else if (i == 1) {
                    Intent intent = new Intent(algebra.this, productosnotables_children.class);
                     startActivity(intent);
                }
                   else if (i == 2) {
                       Intent intent = new Intent(algebra.this, valorAbsoluto_children.class);
                       startActivity(intent);
                   }
                   else if (i == 3) {
                       Intent intent = new Intent(algebra.this, binomioNewton_children.class);
                       startActivity(intent);
                   }
                   else if (i == 4) {
                       Intent intent = new Intent(algebra.this, numerosReales_children.class);
                       startActivity(intent);
                   }
                   else if (i == 5) {
                       Intent intent = new Intent(algebra.this, numerosComplejos_children.class);
                       startActivity(intent);
                   }
                   else if (i == 6) {
                       Intent intent = new Intent(algebra.this, leySignos_children.class);
                       if (mInterstitialAd.isLoaded()) {
                           mInterstitialAd.show();
                       }
                       else   {
                           Log.d("TAG", "The interstitial wasn't loaded yet.");

                       }
                       startActivity(intent);
                   }
                   else if (i == 7) {
                       Intent intent = new Intent(algebra.this, formulaGeneral_children.class);
                       if (mInterstitialAd.isLoaded()) {
                           mInterstitialAd.show();
                       }
                       else   {
                           Log.d("TAG", "The interstitial wasn't loaded yet.");

                       }
                       startActivity(intent);
                   }
                   else if (i == 8) {
                       Intent intent = new Intent(algebra.this, sumatoria_children.class);
                       startActivity(intent);
                   }
                   else if (i == 9) {
                       Intent intent = new Intent(algebra.this, operacionesComplejos_children.class);

                       if (mInterstitialAd.isLoaded()) {
                           mInterstitialAd.show();
                       }
                       else   {
                           Log.d("TAG", "The interstitial wasn't loaded yet.");

                       } startActivity(intent);
                   }
                   else if (i == 10) {
                       Intent intent = new Intent(algebra.this, conjugadoComplejo_children.class);
                       startActivity(intent);
                   }

                   else if (i == 11) {
                       Intent intent = new Intent(algebra.this, factorizacion_children.class);
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


                Intent intent = new Intent(algebra.this, algebra_ejer.class);

                startActivity(intent);

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(algebra.this, Menu_principal.class);

                startActivity(intent);
                finish();

            }
        });

    }

}
