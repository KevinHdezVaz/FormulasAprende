package app.wena.formulasaprende.Matematicas_children.Trigonometria_children;

import app.wena.formulasaprende.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class relacionTrigonometria_children extends AppCompatActivity {
    ImageView imagen,ima2,ima3;
    PhotoViewAttacher photo,po2,po3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relacion_trigonometria_children);

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

        imagen =(ImageView)findViewById(R.id.tri1);
        photo = new PhotoViewAttacher(imagen);
        ima2 =(ImageView)findViewById(R.id.tri2);
        po2 = new PhotoViewAttacher(ima2);
        ima3 =(ImageView)findViewById(R.id.tri3);
        po3 = new PhotoViewAttacher(ima3);

    }
}
