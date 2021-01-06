package app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children;

import app.wena.formulasaprende.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import uk.co.senab.photoview.PhotoViewAttacher;

public class matrizSimetrica_children extends AppCompatActivity {
    ImageView imagen,ima2;
    PhotoViewAttacher photo,poto2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriz_simetrica_children);
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
        imagen =(ImageView)findViewById(R.id.simetricaa);
        photo = new PhotoViewAttacher(imagen);

        ima2 =(ImageView)findViewById(R.id.matrizs);
        poto2 = new PhotoViewAttacher(ima2);
    }
}
