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


public class Paralelogramo extends AppCompatActivity {
    private TextInputLayout altura;
    private TextInputLayout base;
    private EditText res;
    private Button btn;
    public double resultado;
    Dialog epicDialog;
    ImageView cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paralelogramo);


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
        altura = (TextInputLayout) findViewById(R.id.editAltura2);
        base = (TextInputLayout) findViewById(R.id.editBase2);
        btn = (Button) findViewById(R.id.btnCalcular);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (altura.getEditText().getText().toString().trim().isEmpty() || base.getEditText().getText().toString().trim().isEmpty()) {
                    res.setText("0");
                } else {
                    double var1 = Double.parseDouble(altura.getEditText().getText().toString());
                    double var2 = Double.parseDouble(base.getEditText().getText().toString());
                    resultado = (var1 * var2) ;


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
        epicDialog.setContentView(R.layout.area_paralel);
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
