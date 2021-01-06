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

public class trigonometria_ejer extends AppCompatActivity {
    private Adapter2 adaptador;

    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigonometria_ejer);
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
        listItems.add(new Spacecraft((R.drawable.anguloss), getString(R.string.anguloo)));
        listItems.add(new Spacecraft((R.drawable.teorema_pitagoras), getString(R.string.teorema_pitagora)));
        listItems.add(new Spacecraft((R.drawable.longitud), getString(R.string.razones_trigono)));
        listItems.add(new Spacecraft((R.drawable.angle_2),  getString(R.string.seno)));
        listItems.add(new Spacecraft((R.drawable.angle_2),  getString(R.string.coseno)));
        listItems.add(new Spacecraft((R.drawable.angle_2),  getString(R.string.tangente)));






        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1AI2HNNAKZW7shhHQOVndxChmxGmz1JO4");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 1) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1voewaTSiPVsRjTuu62PYxE1zsWDNbOxt");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 2) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1ReiFzabIPuVG7tuNLanTi7fvKZakjxcM");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 3) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1nvQCNEOX4SeWGppGJO8hbIRDrknEIxhu");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 4) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1DvEAjqJrKBkEVu2RKxdnEiJMmSO_WlrA");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 5) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1sI8TERIklrjEmi900U8vbF_uH0L8__AC");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

            }
        });
    }
}