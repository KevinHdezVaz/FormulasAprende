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

public class Aritmetica_ejer extends AppCompatActivity {
    private Adapter2 adaptador;
    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmetica_ejer);
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
        listItems.add(new Spacecraft((R.drawable.librro), getString(R.string.regla3)));
        listItems.add(new Spacecraft((R.drawable.librro), getString(R.string.potencia_fracc)));





        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1IHFvMLIIm5J1wXId37T3rRp9KWj64An_");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 1) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=10n130CzOJuDv5uhrb0Ej_oWxJ6tWeTLh");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

            }
        });
    }
}
