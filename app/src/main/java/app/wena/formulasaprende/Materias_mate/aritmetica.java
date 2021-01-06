package app.wena.formulasaprende.Materias_mate;


import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.Matematicas_children.Aritmetica_children.numeromixto_children;
import app.wena.formulasaprende.Matematicas_children.Aritmetica_children.operacionesFracciones_children;
import app.wena.formulasaprende.Matematicas_children.Aritmetica_children.potenciaFracciones_children;
import app.wena.formulasaprende.Matematicas_children.Aritmetica_children.reglaTres_children;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;
import app.wena.formulasaprende.resolver.matematicas.Aritmetica_ejer;

import android.content.Intent;

 import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
 import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class aritmetica extends AppCompatActivity {
     private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private ListView list;
    private CustomAdapter3 adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmetica);



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

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        list = (ListView) findViewById(R.id.item2_2);

        final ArrayList<lista2> listItems = new ArrayList<>();
        listItems.add(new lista2((R.drawable.longitud),getString(R.string.regla3)));
        listItems.add(new lista2((R.drawable.longitud),getString(R.string.num_mix)));
        listItems.add(new lista2((R.drawable.longitud), getString(R.string.potencia_fracc)));
        listItems.add(new lista2((R.drawable.longitud), getString(R.string.operaciones_fracc)));


        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);

    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if (i == 0) {
                Intent intent = new Intent(aritmetica.this, reglaTres_children.class);
                startActivity(intent);
            }
           else if (i == 1) {
                Intent intent = new Intent(aritmetica.this, numeromixto_children.class);
                startActivity(intent);
            }
            else if (i == 2) {
                Intent intent = new Intent(aritmetica.this, potenciaFracciones_children.class);
                startActivity(intent);
            }
            else if (i == 3) {
                Intent intent = new Intent(aritmetica.this, operacionesFracciones_children.class);
                startActivity(intent);
            }
        }
    });


        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(aritmetica.this, Aritmetica_ejer.class);
                startActivity(intent);

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(aritmetica.this, Menu_principal.class);

                startActivity(intent);
            finish();
            }
        });
    }

}