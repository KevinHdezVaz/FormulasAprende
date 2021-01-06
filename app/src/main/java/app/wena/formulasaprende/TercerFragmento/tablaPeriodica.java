package app.wena.formulasaprende.TercerFragmento;
import app.wena.formulasaprende.R;
import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;


import uk.co.senab.photoview.PhotoViewAttacher;

public class tablaPeriodica extends AppCompatActivity {
ImageView imageView;
PhotoViewAttacher photoViewAttacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //codigo para que abarque toda la pantalla
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_tabla_periodica);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        imageView =(ImageView) findViewById(R.id.periodica);
        photoViewAttacher = new PhotoViewAttacher(imageView);

    }
}
