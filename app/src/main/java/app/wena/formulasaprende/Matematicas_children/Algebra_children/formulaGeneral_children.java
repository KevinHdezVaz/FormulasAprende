package app.wena.formulasaprende.Matematicas_children.Algebra_children;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import app.wena.formulasaprende.R;

import uk.co.senab.photoview.PhotoViewAttacher;

public class formulaGeneral_children extends AppCompatActivity {
    ImageView imagen,imagen2;
    PhotoViewAttacher photo,photo2;
    Button detalles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula_general_children);

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
        imagen =(ImageView)findViewById(R.id.formulagral_zoom);
        photo = new PhotoViewAttacher(imagen);
        imagen2 =(ImageView)findViewById(R.id.formulagral_zoom2);
        photo2 = new PhotoViewAttacher(imagen2);

        detalles =(Button) findViewById(R.id.gral_detalles);

        detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://drive.google.com/open?id=1XTM_mAu0qODWi3BMX3vSrbx0QONSKWR3");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
