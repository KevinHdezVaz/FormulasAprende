package app.wena.formulasaprende.resolver.matematicas;

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

public class Geometria_ejer extends AppCompatActivity {
    private Adapter2 adaptador;

    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometria_ejer);
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
        listItems.add(new Spacecraft((R.drawable.anguloss), getString(R.string.distancia_entre_dos)));
        listItems.add(new Spacecraft((R.drawable.random), getString(R.string.punto_pendiente)));
        listItems.add(new Spacecraft((R.drawable.centro_gravedad_icon), getString(R.string.distancia_punto_recta)));
        listItems.add(new Spacecraft((R.drawable.librro), getString(R.string.hiperbola)));
        listItems.add(new Spacecraft((R.drawable.parabolic), getString(R.string.parabola_origen)));
        listItems.add(new Spacecraft((R.drawable.parabola), getString(R.string.parabola_fuera_origen)));
        listItems.add(new Spacecraft((R.drawable.parabola), getString(R.string.circunferencia_centro_origen)));
        listItems.add(new Spacecraft((R.drawable.parabola), getString(R.string.circunferencia_fuera_origen)));
        listItems.add(new Spacecraft((R.drawable.random), getString(R.string.parabola_origen)));
        listItems.add(new Spacecraft((R.drawable.centro_gravedad_icon), getString(R.string.parabola_fuera_origen)));





        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1hfLffQIWMtPz7kxjlYs2qO_N_uQLsI26");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 1) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1ks-PXpilnrxv9ypTePMn10NMidK74gUz");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (i == 2) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=17_97BtJRTvsHRIWD11YW5srlEf-a2v1p");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (i == 3) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1f_hIS9V12eKUVYYAS2Pn9uhzHl1cPC3t");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 4) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1A_eLIqahbcj5ezPORqvotTpI_OGzfaIz");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 5) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1N8EiyLTYZYPVVnIZLgRdXLrqvQf6h6Dl");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 6) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1DBPI10_pi9Yi_hOXsqK_oVacKNoTBk8a");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 7) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1serV7kzb3DJotCOnQRrHQwk5obEFhzQZ");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 8) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1xBwCB9GL7n2WVsN3XG90uXGKtkuDvlRn");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 9) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1QUGVksCd2jW0S30yluwb8QDKfQibfOzd");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });
    }
}
