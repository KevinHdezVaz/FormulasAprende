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


public class Trapecio extends AppCompatActivity {
    private TextInputLayout altura;
    private TextInputLayout baseMayor;
    private TextInputLayout baseMenor;

    Dialog epicDialog;
    ImageView cerrar;
    private EditText res;
    private Button btn;
    public double resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapecio);
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
        altura = (TextInputLayout) findViewById(R.id.altuar2);

        baseMenor = (TextInputLayout) findViewById(R.id.basemenor2);
        baseMayor = (TextInputLayout) findViewById(R.id.basemayor2);

        btn = (Button) findViewById(R.id.btnCalcular);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (altura.getEditText().getText().toString().trim().isEmpty() || baseMayor.getEditText().getText().toString().trim().isEmpty()
                || baseMenor.getEditText().getText().toString().trim().isEmpty()){

                    res.setText("0");
                } else {
                    double var1 = Double.parseDouble(altura.getEditText().getText().toString());
                    double var2 = Double.parseDouble(baseMenor.getEditText().getText().toString());
                    double var3 = Double.parseDouble(baseMayor.getEditText().getText().toString());

                    resultado = (((var2+var3) / 2) *var1);


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
        epicDialog.setContentView(R.layout.area_trapecio);
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
