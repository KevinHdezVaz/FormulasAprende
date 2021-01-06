package app.wena.formulasaprende.TercerFragmento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;


import app.wena.formulasaprende.R;
import uk.co.senab.photoview.PhotoViewAttacher;

public class constantes extends AppCompatActivity {
    ImageView imageView;
    PhotoViewAttacher photoViewAttacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_constantes);

        imageView =(ImageView) findViewById(R.id.consta);
        photoViewAttacher = new PhotoViewAttacher(imageView);



    }
}
