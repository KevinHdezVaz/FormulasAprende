package app.wena.formulasaprende.resolver.calculo;
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

public class calculo_vectorial extends AppCompatActivity {
    private Adapter2 adaptador;
    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_vectorial);
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

        listItems.add(new Spacecraft((R.drawable.vector_icon), getString(R.string.producto_escalar_dos)));
        listItems.add(new Spacecraft((R.drawable.vector_icon), getString(R.string.cosenos_directores)));
        listItems.add(new Spacecraft((R.drawable.vector_icon), getString(R.string.producto_vectorial_dos)));



        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if  (i == 0){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1_zXv3Yn6DkKNE7yfUts1Q20OtNXq5etE");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if  (i == 1){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1FzYPr_gIK9Mx5hQiU1DSjgNfJpFI9bnk");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if  (i == 2){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1KVmQUCy1CbgTD2Tcjf6bwQoYvHsPJLEL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

            }
        });

    }
}


