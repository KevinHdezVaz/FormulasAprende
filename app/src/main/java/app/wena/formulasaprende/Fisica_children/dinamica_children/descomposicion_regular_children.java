package app.wena.formulasaprende.Fisica_children.dinamica_children;
import app.wena.formulasaprende.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class descomposicion_regular_children extends AppCompatActivity {

    ImageView imagen,ima2;
    PhotoViewAttacher photo,poto2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descomposicion_regular_children);
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
        imagen =(ImageView)findViewById(R.id.desc);
        photo = new PhotoViewAttacher(imagen);

        ima2 =(ImageView)findViewById(R.id.desc2);
        poto2 = new PhotoViewAttacher(ima2);
    }
}
