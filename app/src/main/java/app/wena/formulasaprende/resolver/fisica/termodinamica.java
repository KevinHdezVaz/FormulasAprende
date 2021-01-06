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

public class termodinamica extends AppCompatActivity {
    private Adapter2 adaptador;

    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termodinamica);



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
        listItems.add(new Spacecraft((R.drawable.termometro), getString(R.string.calor)));
        listItems.add(new Spacecraft((R.drawable.gasesx), getString(R.string.gas_idel)));
        listItems.add(new Spacecraft((R.drawable.frascos), getString(R.string.boyle_mariotte)));
        listItems.add(new Spacecraft((R.drawable.frasco_quimica), getString(R.string.principio_termodinamica)));
        listItems.add(new Spacecraft((R.drawable.dilatacion), getString(R.string.dilatacion_lineal)));
        listItems.add(new Spacecraft((R.drawable.dilatacion), getString(R.string.dilatacion_superficial)));
        listItems.add(new Spacecraft((R.drawable.dilatacion), getString(R.string.dilatacion_volumetrica)));





        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1GQKuJ0h27n9Cmz91aCe9KPRZMLenSHeN");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 1) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1iu4CGotjyx9rKYMYrt2qW3S0RIB2nZvG");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 2) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1UZDmYYrBHfJFBBhtoN2uNFs6Hyh56udU");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 3) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1_06A1_3Hn5wZqtqxD_rDXhpiN4cZIJY3");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 4) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=12Nx22SPo_0AxkvfNKvybOT2nKSbsXAPX");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }else if (i == 5) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1ewOHRLPuGQfzjxWwYeaVYtFZvpFetgr0");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 6) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1WyRFQA-7xDoiFP7ytObyo_Wyby77FLz2");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });
    }
}
