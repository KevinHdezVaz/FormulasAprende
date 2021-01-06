package app.wena.formulasaprende.Materias_Quimica.quimicaOrganica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import app.wena.formulasaprende.R;
import uk.co.senab.photoview.PhotoViewAttacher;

public class alcano_alqueno_alquino extends AppCompatActivity {
    ImageView imagen,imagen2,imagen3;
    PhotoViewAttacher photo,photo2,photo3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcano_alqueno_alquino);


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradiente));
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
        imagen = (ImageView) findViewById(R.id.alca1);
        photo = new PhotoViewAttacher(imagen);

        imagen2 = (ImageView) findViewById(R.id.alque1);
        photo2 = new PhotoViewAttacher(imagen2);

        imagen3 = (ImageView) findViewById(R.id.alqui1);
        photo3 = new PhotoViewAttacher(imagen3);


    }
}