package app.wena.formulasaprende.Materias_Calculo;

import android.content.Intent;


import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.angulo_dos_vectores_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.cosenos_directores_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.norma_vector_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.producto_escalar_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.producto_vectorial_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.q_plano_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.teorema_stokes_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.vector_unitario_children;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;
import app.wena.formulasaprende.resolver.calculo.calculo_vectorial;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

 import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class Vectorial extends AppCompatActivity {
    ExpandableListView expandableListView;
    private AdView mAdView;
    private ListView list;
    private CustomAdapter3 adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vectorial);

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
        listItems.add(new lista2((R.drawable.vector_icon), getString(R.string.norma_vector)));
        listItems.add(new lista2((R.drawable.vector_icon), getString(R.string.vector_unitario)));
        listItems.add(new lista2((R.drawable.vector_icon), getString(R.string.angulo_dos_vectores)));
        listItems.add(new lista2((R.drawable.vector_icon), getString(R.string.cosenos_directores)));
        listItems.add(new lista2((R.drawable.vector_icon), getString(R.string.producto_escalar)));
        listItems.add(new lista2((R.drawable.vector_icon), getString(R.string.producto_vectorial)));
        listItems.add(new lista2((R.drawable.vector_icon), getString(R.string.q_plano)));

        listItems.add(new lista2((R.drawable.vector_icon), getString(R.string.teorema_stokes)));
//modulo de un vector


        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Vectorial.this, norma_vector_children.class);
                    startActivity(intent);
                } else if (i == 1) {
                    Intent intent = new Intent(Vectorial.this, vector_unitario_children.class);
                    startActivity(intent);
                } else if (i == 2) {
                    Intent intent = new Intent(Vectorial.this, angulo_dos_vectores_children.class);
                    startActivity(intent);
                } else if (i == 3) {
                    Intent intent = new Intent(Vectorial.this, cosenos_directores_children.class);
                    startActivity(intent);
                } else if (i == 4) {
                    Intent intent = new Intent(Vectorial.this, producto_escalar_children.class);
                    startActivity(intent);
                } else if (i == 5) {
                    Intent intent = new Intent(Vectorial.this, producto_vectorial_children.class);
                    startActivity(intent);
                } else if (i == 6) {
                    Intent intent = new Intent(Vectorial.this, q_plano_children.class);
                    startActivity(intent);
                }
                  else if (i == 7) {
                    Intent intent = new Intent(Vectorial.this, teorema_stokes_children.class);
                    startActivity(intent);
                }
            }
        });


        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Vectorial.this, calculo_vectorial.class);

                startActivity(intent);

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Vectorial.this, Menu_principal.class);

                startActivity(intent);
                finish();
            }
        });
    }

}
