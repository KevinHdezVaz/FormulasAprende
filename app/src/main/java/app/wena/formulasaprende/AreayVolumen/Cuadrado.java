package app.wena.formulasaprende.AreayVolumen;

import app.wena.formulasaprende.R;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class Cuadrado extends AppCompatActivity {
    private TextInputLayout lado;
    private EditText res;
    private Button btn;
    public double resultado;
    Dialog epicDialog;
    ImageView cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradiente));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        res = (EditText) findViewById(R.id.editTextRes);
        lado = (TextInputLayout) findViewById(R.id.editLado);
        btn = (Button) findViewById(R.id.btnCalcular);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.area2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mostrarInfo();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lado.getEditText().getText().toString().trim().isEmpty()) {
                    res.setText("0");
                } else {
                    double var1 = Double.parseDouble(lado.getEditText().getText().toString());
                    resultado = (var1 * var1);


                    res.setText("" + resultado);
                }
            }


        });

    }         public void mostrarInfo(){

        epicDialog = new Dialog(this);
        epicDialog.setContentView(R.layout.area_cuadrado);
        cerrar = (ImageView)epicDialog.findViewById(R.id.cerrarVentana2);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();



    }
}