package app.wena.formulasaprende.TercerFragmento;
import app.wena.formulasaprende.R;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


public class glosario_matematico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glosario_matematico);



            Uri uri = Uri.parse("https://drive.google.com/open?id=1wbxSrsP5nUTsl7yNK2HZojNTJ1AjME6x");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        finish();
    }
}
