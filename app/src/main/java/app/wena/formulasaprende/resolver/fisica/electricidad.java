package app.wena.formulasaprende.resolver.fisica;

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

public class electricidad extends AppCompatActivity {
    private Adapter2 adaptador;

    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricidad);



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
        listItems.add(new Spacecraft((R.drawable.coulomb), getString(R.string.ley_coulomb)));
        listItems.add(new Spacecraft((R.drawable.resistividad2), getString(R.string.principio_superposicion)));
        listItems.add(new Spacecraft((R.drawable.dilatacion), getString(R.string.campo_electrico)));
        listItems.add(new Spacecraft((R.drawable.circuito_electrico), getString(R.string.ley_ohm)));
        listItems.add(new Spacecraft((R.drawable.resistividad2), getString(R.string.resistividad_electrica)));





        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1SWWwRHtwmfHHbyqoD8apUPVlnbhvaJbP");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
               else  if (i == 1) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=16nJ_qySsca5W4ZDYfnXtyreY3wvDhYaR");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else  if (i == 2) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1ski4EafXxq_lVPe8eAJXawguxMVoXsWv");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else  if (i == 3) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1s_ebnFzEp-_ZLbSX89MKWJuUQcUzF9yT");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else  if (i == 4) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1aov71PZGNubknOvkgZKe4_1sbpx2z2W2");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });
    }
}
