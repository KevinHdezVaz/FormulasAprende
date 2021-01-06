package app.wena.formulasaprende.Fisica_children.Mecanica_children;
import app.wena.formulasaprende.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

 import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class movimiento_rectilineo_uniforme_children extends AppCompatActivity {
    ImageView imagen,imagen2;
    PhotoViewAttacher photo,photo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimiento_rectilineo_uniforme_children);
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
        imagen =(ImageView)findViewById(R.id.rectilineo1);
        photo = new PhotoViewAttacher(imagen);

        imagen2= (ImageView)findViewById(R.id.rectilineo2);
        photo2 = new PhotoViewAttacher(imagen2);


    }
}
