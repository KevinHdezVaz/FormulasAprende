package app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import app.wena.formulasaprende.AreayVolumen.Adapter2;
import app.wena.formulasaprende.GridView_segundoFragment.Spacecraft;
import app.wena.formulasaprende.R;

import java.util.ArrayList;


public class ecuacionesEjer extends AppCompatActivity {
    private Adapter2 adaptador;

    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuaciones_ejer);
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
        listItems.add(new Spacecraft((R.drawable.ecuaciondf), "Ecuación Diferencial Homogenea"));
        listItems.add(new Spacecraft((R.drawable.ecuaciondf), "Ecuación Diferencial Ricatti"));
        listItems.add(new Spacecraft((R.drawable.ecuaciondf), "Ecuación Variables Separadas"));
        listItems.add(new Spacecraft((R.drawable.ecuaciondf), "Aplicaciones Crecimiento Poblacional"));
        listItems.add(new Spacecraft((R.drawable.ecuaciondf), "Aplicaciones Enfriamiento Newton"));


        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Uri uri = Uri.parse("https://drive.google.com/file/d/1ei0_d2wCCGbsRYrMfGOQokasESW1jgfe/view?usp=sharing");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 1) {
                    Uri uri = Uri.parse("https://drive.google.com/file/d/1LYpgpfzZfFWt6ubEDYJKjUmYwManaxt6/view?usp=sharing");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 2) {
                    Uri uri = Uri.parse("https://drive.google.com/file/d/1SqWO8z4vJJaaZ7s6NT4vPFseCGis0j5b/view?usp=sharing");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 3) {
                    Uri uri = Uri.parse("https://drive.google.com/file/d/12QLlFfxFiwWAtBYp7g2lNHflEKUnopwU/view?usp=sharing"); //le falta el link

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 4) {
                    Uri uri = Uri.parse("https://drive.google.com/file/d/1NXtbnlrX3OX5cSj-7S9LSI14uB_wOYU-/view?usp=sharing"); //le falta el link

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

            }
        });
    }
}