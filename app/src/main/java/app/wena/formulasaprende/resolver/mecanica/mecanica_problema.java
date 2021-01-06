package app.wena.formulasaprende.resolver.mecanica;

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

public class mecanica_problema extends AppCompatActivity {
    private Adapter2 adaptador;

    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecanica_problema);


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
        listItems.add(new Spacecraft((R.drawable.cinetica_pte), getString(R.string.energia_cinetica_potencial)));

        listItems.add(new Spacecraft((R.drawable.circular_uni), getString(R.string.movimiento_circular_uniforme)));
        listItems.add(new Spacecraft((R.drawable.mov_rectilineo ), getString(R.string.movimiento_rectilineo)));
        listItems.add(new Spacecraft((R.drawable.gravedad), getString(R.string.movimiento_caida_libre)));
        listItems.add(new Spacecraft((R.drawable.parabola), getString(R.string.movimiento_parabolico)));
        listItems.add(new Spacecraft((R.drawable.gravitacion_universal1), getString(R.string.gravitacion_universal)));
        listItems.add(new Spacecraft((R.drawable.proyectiles_icon), getString(R.string.movimiento_proyectiles)));



        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if  (i == 0){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1fhDseO9-lfuJ8HFBr6uYMdU6mH0AchzY");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
               else if  (i == 1){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1syv6zrrFDDGV69vn2rOzu_4NjW23R21y");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if  (i == 2){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1c1xHPVUKLQHUixz-RsjqGUsb9f4UtWJ3");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if  (i == 3){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1qubpRyKJW83VHs_rwuXb7O1MspiJca_c");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if  (i == 4){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1JTvagB_PbN-W18son-dfI2_3OPkdLiQI");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if  (i == 5){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1g5WuHhTQi8fzuihP1kowFE4i0tDocEdP");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }else if  (i == 6){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1c2M2p7zbP7TLRP0YHufAEYutnxm2koM4");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });
    }
}
