package app.wena.formulasaprende.Materias_Fisica;
import android.content.Intent;


import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.boyle_mariotte_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.calor_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.capacidad_calorifica_childrne;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.dilatacion_lineal_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.dilatacion_liquidos_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.dilatacion_superficial_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.dilatacion_volumetrica_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.ecuacion_estado_gases_ideales_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.maquina_termica_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.presiones_parciales_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.primer_principio_termodinamica_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.procesos_termodinamicos_isotermico_children;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;
import app.wena.formulasaprende.resolver.fisica.termodinamica;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

 import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class Termodinamica_fisi extends AppCompatActivity {
     private AdView mAdView;
    private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termodinamica_fisi);

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


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




        list = (ListView) findViewById(R.id.item2_2);

        final ArrayList<lista2> listItems = new ArrayList<>();
        listItems.add(new lista2((R.drawable.termometro), getString(R.string.calor)));
        listItems.add(new lista2((R.drawable.termometro), getString(R.string.ley_presiones_parciales)));
        listItems.add(new lista2((R.drawable.termometro), getString(R.string.capacidad_calorifica)));
        listItems.add(new lista2((R.drawable.termometro), getString(R.string.ecuacion_gases_ideales)));
        listItems.add(new lista2((R.drawable.termometro), getString(R.string.ley_boyleMariotte)));
        listItems.add(new lista2((R.drawable.termometro), getString(R.string.principio_termodinamica)));
        listItems.add(new lista2((R.drawable.termometro), getString(R.string.dilatacion_lineal)));

        listItems.add(new lista2((R.drawable.termometro), getString(R.string.dilatacion_volumetrica)));
        listItems.add(new lista2((R.drawable.termometro), getString(R.string.dilatacion_superficial)));
        listItems.add(new lista2((R.drawable.termometro), getString(R.string.dilatacion_liquidos)));
        listItems.add(new lista2((R.drawable.termometro), getString(R.string.maquiana_termica)));
        listItems.add(new lista2((R.drawable.termometro), getString(R.string.procesos_termodinamicos_isotermicos)));

        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Termodinamica_fisi.this, calor_children.class);
                    startActivity(intent);
                } else if (i == 1) {
                    Intent intent = new Intent(Termodinamica_fisi.this, presiones_parciales_children.class);
                    startActivity(intent);
                } else if (i == 2) {
                    Intent intent = new Intent(Termodinamica_fisi.this, capacidad_calorifica_childrne.class);
                    startActivity(intent);
                } else if (i == 3) {
                    Intent intent = new Intent(Termodinamica_fisi.this, ecuacion_estado_gases_ideales_children.class);
                    startActivity(intent);
                } else if (i == 4) {
                    Intent intent = new Intent(Termodinamica_fisi.this, boyle_mariotte_children.class);
                    startActivity(intent);
                } else if (i == 5) {
                    Intent intent = new Intent(Termodinamica_fisi.this, primer_principio_termodinamica_children.class);
                    startActivity(intent);
                } else if (i == 6) {
                    Intent intent = new Intent(Termodinamica_fisi.this, dilatacion_lineal_children.class);
                    startActivity(intent);
                }
                else if (i == 7) {
                    Intent intent = new Intent(Termodinamica_fisi.this, dilatacion_volumetrica_children.class);
                    startActivity(intent);
                }

                else if (i == 8) {
                    Intent intent = new Intent(Termodinamica_fisi.this, dilatacion_superficial_children.class);
                    startActivity(intent);
                }
                else if (i == 9) {
                    Intent intent = new Intent(Termodinamica_fisi.this, dilatacion_liquidos_children.class);
                    startActivity(intent);
                }
                else if (i == 10) {
                    Intent intent = new Intent(Termodinamica_fisi.this, maquina_termica_children.class);
                    startActivity(intent);
                }
                else if (i == 11) {
                    Intent intent = new Intent(Termodinamica_fisi.this, procesos_termodinamicos_isotermico_children.class);
                    startActivity(intent);
                }
            }
        });


        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Termodinamica_fisi.this, termodinamica.class);

                startActivity(intent);

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Termodinamica_fisi.this, Menu_principal.class);

                startActivity(intent);
                finish();
            }
        });
    }

    
}