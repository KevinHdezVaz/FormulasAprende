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


public class Cilindro extends AppCompatActivity {
    private TextInputLayout altura;
    private TextInputLayout radio;
    private EditText res;
    Dialog epicDialog;
    ImageView cerrar;
    private Button btn;
    public double resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);


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
        radio = (TextInputLayout) findViewById(R.id.radioCili);
        altura = (TextInputLayout) findViewById(R.id.alturaCili);
        btn = (Button) findViewById(R.id.btnCalcular);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (altura.getEditText().getText().toString().trim().isEmpty() || radio.getEditText().getText().toString().trim().isEmpty()) {
                    res.setText("0");
                } else {
                    double var1 = Double.parseDouble(altura.getEditText().getText().toString());
                    double var2 = Double.parseDouble(radio.getEditText().getText().toString());
                    resultado = (3.1416 *Math.pow(var2,2)*var1);


                    res.setText("" + resultado);
                }
            }


        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.area2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mostrarInfo();


            }
        });
    }
    public void mostrarInfo(){

        epicDialog = new Dialog(this);
        epicDialog.setContentView(R.layout.cilindro);
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
