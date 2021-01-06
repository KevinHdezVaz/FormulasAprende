package app.wena.formulasaprende.Materias_Fisica;

import android.content.Intent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.caudal_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.densidad_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.numero_mach_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.numero_reynolds_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.peso_especifico_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.presion_esfuerzo_childrne;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.principio_arquimedes_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.principio_pascal_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.volumen_especifico_children;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;
import app.wena.formulasaprende.resolver.mecanica_fluidos.mecanica_fluidos;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;


public class Mecanica_fluidos extends AppCompatActivity {
     private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecanica_fluidos);



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
        listItems.add(new lista2((R.drawable.eyedropper), getString(R.string.densidad)));
        listItems.add(new lista2((R.drawable.eyedropper), getString(R.string.peso_especifico)));
        listItems.add(new lista2((R.drawable.eyedropper), getString(R.string.volumen_especifico)));
        listItems.add(new lista2((R.drawable.eyedropper), getString(R.string.presion_esfuerzo)));
        listItems.add(new lista2((R.drawable.eyedropper), getString(R.string.principio_pascal)));
        listItems.add(new lista2((R.drawable.eyedropper), getString(R.string.principio_arquimedes)));
        listItems.add(new lista2((R.drawable.eyedropper), getString(R.string.numero_mach)));

        listItems.add(new lista2((R.drawable.eyedropper), getString(R.string.caudal)));
        listItems.add(new lista2((R.drawable.eyedropper), getString(R.string.numero_reynolds)));

        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Mecanica_fluidos.this, densidad_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }  startActivity(intent);
                } else if (i == 1) {
                    Intent intent = new Intent(Mecanica_fluidos.this, peso_especifico_children.class);
                    startActivity(intent);
                } else if (i == 2) {
                    Intent intent = new Intent(Mecanica_fluidos.this, volumen_especifico_children.class);
                    startActivity(intent);
                } else if (i == 3) {
                    Intent intent = new Intent(Mecanica_fluidos.this, presion_esfuerzo_childrne.class);
                    startActivity(intent);
                } else if (i == 4) {
                    Intent intent = new Intent(Mecanica_fluidos.this, principio_pascal_children.class);
                    startActivity(intent);
                } else if (i == 5) {
                    Intent intent = new Intent(Mecanica_fluidos.this, principio_arquimedes_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }    startActivity(intent);
                } else if (i == 6) {
                    Intent intent = new Intent(Mecanica_fluidos.this, numero_mach_children.class);
                    startActivity(intent);
                }
                else if (i == 7) {
                    Intent intent = new Intent(Mecanica_fluidos.this, caudal_children.class);
                    startActivity(intent);
                }

                else if (i == 8) {
                    Intent intent = new Intent(Mecanica_fluidos.this, numero_reynolds_children.class);
                    startActivity(intent);
                }

            }
        });


        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Mecanica_fluidos.this, mecanica_fluidos.class);


                startActivity(intent);

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Mecanica_fluidos.this, Menu_principal.class);

                startActivity(intent);
                finish();
            }
        });
    }

}