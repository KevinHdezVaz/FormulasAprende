package app.wena.formulasaprende.resolver.dinamica;

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

public class Dinamica_menu extends AppCompatActivity {
    private Adapter2 adaptador;

     private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiwis);

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

        listItems.add(new Spacecraft((R.drawable.gravity), getString(R.string.leyes_newton)));
        listItems.add(new Spacecraft((R.drawable.vector_icon), getString(R.string.vectores)));
        listItems.add(new Spacecraft((R.drawable.centro_gravedad_icon), getString(R.string.centro_gravedad)));
        listItems.add(new Spacecraft((R.drawable.hooke_ley), getString(R.string.ley_hooke)));
        listItems.add(new Spacecraft((R.drawable.plano_inclinado1), getString(R.string.plano_inclinado)));


        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if  (i == 0){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1Sze3nXscPnILa4kuMJ-eRFm_LZJF1pU-");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if  (i == 1){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1FMtXItJB8JpZTj1AyCGepKHS_JHHr3xu");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if  (i == 2){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1NePew-T9uh0FyaFZ1hDOyFY9kKiviFMX");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if  (i == 3){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1QVakpmYpcqWQEWd7sBI4Ci3W6kZnj8HJ");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if  (i == 4){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1FWmd_fOoIbEwCcTWGKgjKycaKqn_WVGW");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

            }
        });

    }
}

