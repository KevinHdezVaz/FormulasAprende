package app.wena.formulasaprende.Matematicas_children.Trigonometria_children;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import app.wena.formulasaprende.R;
import uk.co.senab.photoview.PhotoViewAttacher;

public class anguloOpuesto_children extends AppCompatActivity {
    ImageView imagen,ima2;
    PhotoViewAttacher photo,pto2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angulo_opuesto_children);
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
        imagen =(ImageView)findViewById(R.id.opuesto);
        photo = new PhotoViewAttacher(imagen);

        ima2 =(ImageView)findViewById(R.id.opuesto2);
        pto2 = new PhotoViewAttacher(ima2);
    }
}
