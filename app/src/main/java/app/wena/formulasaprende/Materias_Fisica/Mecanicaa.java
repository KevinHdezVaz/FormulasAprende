package app.wena.formulasaprende.Materias_Fisica;

import android.content.Intent;

 import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.caida_libre_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.energia_cinetica_potencial_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.fuerza_centripeta_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.fuerza_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.ley_gravitacion_universal_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.movimiento_circular_uniforme_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.movimiento_horizontal_proyectiles_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.movimiento_parabolico_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.movimiento_proyectiles_angulo_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.movimiento_rectilineo_uniforme_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.movimiento_vertical_proyectiles_children;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;
import app.wena.formulasaprende.resolver.mecanica.mecanica_problema;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;


public class Mecanicaa extends AppCompatActivity {
     private AdView mAdView;
    private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mecanicaa);


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
        listItems.add(new lista2((R.drawable.innovacion), getString(R.string.energia_cinetica_potencial)));
        listItems.add(new lista2((R.drawable.innovacion),"Trabajo, Energia y Potencia"));
        listItems.add(new lista2((R.drawable.innovacion), getString(R.string.movimiento_parabolico)));
        listItems.add(new lista2((R.drawable.innovacion), getString(R.string.fuerza_centripeta)));
        listItems.add(new lista2((R.drawable.innovacion), getString(R.string.caida_libre)));
        listItems.add(new lista2((R.drawable.innovacion), getString(R.string.movimiento_proyectiles_angulo)));
        listItems.add(new lista2((R.drawable.innovacion), getString(R.string.movimiento_horizontal_proyectiles)));

        listItems.add(new lista2((R.drawable.innovacion), getString(R.string.movimiento_vertical_proyectiles)));
        listItems.add(new lista2((R.drawable.innovacion), getString(R.string.movimiento_rectilineo)));
        listItems.add(new lista2((R.drawable.innovacion), getString(R.string.movimiento_circular_uniforme)));
        listItems.add(new lista2((R.drawable.innovacion), getString(R.string.ley_gravitacion_universal)));

        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Mecanicaa.this, energia_cinetica_potencial_children.class);
                    startActivity(intent);
                } else if (i == 1) {
                    Intent intent = new Intent(Mecanicaa.this, fuerza_children.class);
                    startActivity(intent);
                } else if (i == 2) {
                    Intent intent = new Intent(Mecanicaa.this, movimiento_parabolico_children.class);
                    startActivity(intent);
                } else if (i == 3) {
                    Intent intent = new Intent(Mecanicaa.this, fuerza_centripeta_children.class);
                    startActivity(intent);
                } else if (i == 4) {
                    Intent intent = new Intent(Mecanicaa.this, caida_libre_children.class);
                    startActivity(intent);
                } else if (i == 5) {
                    Intent intent = new Intent(Mecanicaa.this, movimiento_proyectiles_angulo_children.class);
                    startActivity(intent);
                } else if (i == 6) {
                    Intent intent = new Intent(Mecanicaa.this, movimiento_horizontal_proyectiles_children.class);
                    startActivity(intent);
                }
                else if (i == 7) {
                    Intent intent = new Intent(Mecanicaa.this, movimiento_vertical_proyectiles_children.class);
                    startActivity(intent);
                }
                else if (i == 8) {
                    Intent intent = new Intent(Mecanicaa.this, movimiento_rectilineo_uniforme_children.class);
                    startActivity(intent);
                }
                else if (i == 9) {
                    Intent intent = new Intent(Mecanicaa.this, movimiento_circular_uniforme_children.class);
                    startActivity(intent);
                }
                else if (i == 10) {
                    Intent intent = new Intent(Mecanicaa.this, ley_gravitacion_universal_children.class);
                    startActivity(intent);
                }
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Mecanicaa.this, Menu_principal.class);

                startActivity(intent);
                finish();
            }
        });


         FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Mecanicaa.this, mecanica_problema.class);

                startActivity(intent);

            }
        });

    }

}

