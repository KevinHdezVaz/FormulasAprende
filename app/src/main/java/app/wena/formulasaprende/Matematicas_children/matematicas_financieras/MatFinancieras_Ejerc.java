package app.wena.formulasaprende.Matematicas_children.matematicas_financieras;

import app.wena.formulasaprende.AreayVolumen.Adapter2;
import app.wena.formulasaprende.GridView_segundoFragment.Spacecraft;
import app.wena.formulasaprende.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

  import java.util.ArrayList;


public class MatFinancieras_Ejerc extends AppCompatActivity {
    private Adapter2 adaptador;

    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat_financieras__ejerc);

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
        listItems.add(new Spacecraft((R.drawable.calculadora), "Interes Simple "));
        listItems.add(new Spacecraft((R.drawable.calculadora), "Interes Simple 2"));
        listItems.add(new Spacecraft((R.drawable.calculadora), "Interes Compuesto"));
        listItems.add(new Spacecraft((R.drawable.calculadora), "Interes Compuesto 2"));
        listItems.add(new Spacecraft((R.drawable.calculadora), "Anualidad Simple"));
        listItems.add(new Spacecraft((R.drawable.calculadora), "Descuento Simple"));
        listItems.add(new Spacecraft((R.drawable.calculadora), "Descuento Simple 2"));


        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Uri uri = Uri.parse("https://drive.google.com/file/d/1ltyrheiZi0-OSU71FyIQ_oUkBIHGMKul/view?usp=sharing");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 1) {
                    Uri uri = Uri.parse("https://drive.google.com/file/d/1dQ-BbrprYZZIP38Zb0aQugAntmV52FBI/view?usp=sharing");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 2) {
                    Uri uri = Uri.parse("https://drive.google.com/file/d/1M-yzTwEnO0EkXlNgWoU4lTibcsWWKWl5/view?usp=sharing");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 3) {
                    Uri uri = Uri.parse("https://drive.google.com/file/d/15YvuyDkGHUQig_3hBmbsb6OLz5csmg5G/view?usp=sharing"); //le falta el link

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 4) {
                    Uri uri = Uri.parse("https://drive.google.com/file/d/1WKTPeMziDNqsVdeBxFoKL2UmCRaHLX2W/view?usp=sharing"); //le falta el link

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 5) {
                    Uri uri = Uri.parse("https://drive.google.com/file/d/1RcCLiUe3prHkSU2rHP_seaDZUWXsQlKq/view?usp=sharing"); //le falta el link

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 6) {
                    Uri uri = Uri.parse("https://drive.google.com/file/d/1ivINZ-oks73LIUevqLNXQK0UZ8otp2fZ/view?usp=sharing"); //le falta el link

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });
    }
}


