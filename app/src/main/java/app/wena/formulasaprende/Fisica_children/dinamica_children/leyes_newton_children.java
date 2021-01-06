package app.wena.formulasaprende.Fisica_children.dinamica_children;
import app.wena.formulasaprende.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class leyes_newton_children extends AppCompatActivity {

    ImageView imagen,imagen2,imagen3;
    PhotoViewAttacher photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leyes_newton_children);
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
        imagen =(ImageView)findViewById(R.id.newtoon);
        photo = new PhotoViewAttacher(imagen);

        imagen2 =(ImageView)findViewById(R.id.newtoon2);
        photo = new PhotoViewAttacher(imagen2);

        imagen3 =(ImageView)findViewById(R.id.newtoon3);
        photo = new PhotoViewAttacher(imagen3);
    }
}
