package app.wena.formulasaprende.Matematicas_children.Aritmetica_children;

import app.wena.formulasaprende.R;import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import uk.co.senab.photoview.PhotoViewAttacher;

public class reglaTres_children extends AppCompatActivity {
     Button detalle;
    ImageView imagen,ima2;
    PhotoViewAttacher photo,photo2;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regla_tres_children);

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
         imagen =(ImageView)findViewById(R.id.regla31);
         photo = new PhotoViewAttacher(imagen);

         ima2 =(ImageView)findViewById(R.id.regla32);
         photo2 = new PhotoViewAttacher(ima2);

         detalle =(Button) findViewById(R.id.reglabtn);

        detalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://drive.google.com/open?id=1i5Ud3ASxT0VPru0Kv_n6ki535kKuyotA");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
