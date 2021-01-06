package app.wena.formulasaprende.resolver.mecanica_fluidos;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import app.wena.formulasaprende.GridView_segundoFragment.Spacecraft;
import app.wena.formulasaprende.R;

import app.wena.formulasaprende.AreayVolumen.Adapter2;
import java.util.ArrayList;

public class mecanica_fluidos extends AppCompatActivity {
    private Adapter2 adaptador;

    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecanica_fluidos2);


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
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

        grid = (GridView) findViewById(R.id.item3);

        final ArrayList<Spacecraft> listItems = new ArrayList<>();
        listItems.add(new Spacecraft((R.drawable.peso_icon), "Densidad y Peso Específico"));
        listItems.add(new Spacecraft((R.drawable.pascall), getString(R.string.principio_pascal)));
        listItems.add(new Spacecraft((R.drawable.arquimedes), getString(R.string.principio_arquimedes)));
        listItems.add(new Spacecraft((R.drawable.machx), getString(R.string.numero_mach)));




        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

     grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             if (i == 0) {
                 Uri uri = Uri.parse("https://drive.google.com/open?id=1vwA6jk6U8vOc7qyZQ1rgP-kAj13ZTugT");

                 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                 startActivity(intent);
             }
             else if (i == 1) {
                 Uri uri = Uri.parse("https://drive.google.com/open?id=1Rd2vN3FqYmqSzGNlDmpraeiM8GlLTUxP");

                 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                 startActivity(intent);
             }
             else if (i == 2) {
                 Uri uri = Uri.parse("https://drive.google.com/open?id=14h33QCtTM3QFoX22uAG3VOHtkt6QTjQf");

                 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                 startActivity(intent);
             }
             else if (i == 3) {
                 Uri uri = Uri.parse("https://drive.google.com/open?id=1lBud60qGznBz1dVazfHVZuZRtaBx8nwL");

                 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                 startActivity(intent);
             }
         }
     });
    }
}
