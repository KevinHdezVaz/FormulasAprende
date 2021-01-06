package app.wena.formulasaprende.GridView_segundoFragment;
import app.wena.formulasaprende.R;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class Volumen_activity extends AppCompatActivity {
    private Spinner spinner1 ;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,punto;
    private EditText editText;
    private TextView res;
    private EditText  edNumeros, ed_l, ed_ml, ed_gal,ed_m3,ed_p3,ed_pulg3, ed_cuarto,ed_pinta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_activity);
        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradiente));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar...
                finish();
            }
        });

        ed_l = (EditText) findViewById(R.id.texto_l);
        ed_ml = (EditText) findViewById(R.id.texto_ml);

        ed_gal = (EditText) findViewById(R.id.texto_gal);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);


        punto = (Button) findViewById(R.id.punto);

        ed_m3 =(EditText)findViewById(R.id.texto_m3);
        ed_p3 = (EditText)findViewById(R.id.texto_pi3);
        ed_pulg3 = (EditText)findViewById(R.id.texto_pul3);
        ed_cuarto = (EditText) findViewById(R.id.texto_cuartogal);
        ed_pinta = (EditText) findViewById(R.id.texto_pinta);
        edNumeros = (EditText) findViewById(R.id.numero);
        spinner1 = (Spinner) findViewById(R.id.spinner1);



        String[] opciones = {getString(R.string.vol_litro),
                getString(R.string.vol_milimetro),getString(R.string.vol_galon),
                getString(R.string.vol_metro3),getString(R.string.vol_pie3)
                ,getString(R.string.vol_pulgada3),
                getString(R.string.vol_cuartogalo),getString(R.string.vol_pinta)};




        // Ocultar teclado virtual
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edNumeros.getWindowToken(), 0);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.spinner_item,opciones);




        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                edNumeros.setText("");
                limpiar();            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        edNumeros.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //el primero es el kilometro
                final String seleccion = spinner1.getSelectedItem().toString();

                if(!charSequence.toString().isEmpty()) {


                    if (seleccion.equals(getString(R.string.vol_litro))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 1;
                        ed_l.setText("" + op);

                        double op2 = valor1 * 1000;//mililitro
                        ed_ml.setText("" + op2);

                        double op3 = valor1 / 3.785;//galon
                        ed_gal.setText("" + op3);

                        double op4 = valor1 / 1000;//metro c
                        ed_m3.setText("" + op4);

                        double op5 = valor1 / 28.317;//pie c
                        ed_p3.setText("" + op5);

                        double op6 = valor1 * 61.024;//pulg c
                        ed_pulg3.setText("" + op6);

                        double op7 = valor1 * 1.057;//cuarto
                        ed_cuarto.setText("" + op7);

                        double op8 = valor1 * 2.113;//pinta
                        ed_pinta.setText("" + op8);


                    } else if (seleccion.equals(getString(R.string.vol_milimetro))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 1000;
                        ed_l.setText("" + op);

                        double op2 = valor1 * 1;//mililitro
                        ed_ml.setText("" + op2);

                        double op3 = valor1 / 3785.412;//galon
                        ed_gal.setText("" + op3);

                        double op4 = valor1 / 1000000;//metro c
                        ed_m3.setText("" + op4);

                        double op5 = valor1 / 28316.847;//pie c
                        ed_p3.setText("" + op5);

                        double op6 = valor1 / 16.387;//pulg c
                        ed_pulg3.setText("" + op6);

                        double op7 = valor1 / 946.353;//cuarto
                        ed_cuarto.setText("" + op7);

                        double op8 = valor1 / 473.176;//pinta
                        ed_pinta.setText("" + op8);


                    } else if (seleccion.equals(getString(R.string.vol_galon))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 3.785;
                        ed_l.setText("" + op);

                        double op2 = valor1 * 3785.412;//mililitro
                        ed_ml.setText("" + op2);

                        double op3 = valor1 / 1;//galon
                        ed_gal.setText("" + op3);

                        double op4 = valor1 / 264.172;//metro c
                        ed_m3.setText("" + op4);

                        double op5 = valor1 / 7.481;//pie c
                        ed_p3.setText("" + op5);

                        double op6 = valor1 * 231;//pulg c
                        ed_pulg3.setText("" + op6);

                        double op7 = valor1 * 4;//cuarto
                        ed_cuarto.setText("" + op7);

                        double op8 = valor1 * 8;//pinta
                        ed_pinta.setText("" + op8);


                    } else if (seleccion.equals(getString(R.string.vol_metro3))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 1000;
                        ed_l.setText("" + op);

                        double op2 = valor1 * 1000000;//mililitro
                        ed_ml.setText("" + op2);

                        double op3 = valor1 / 264.172;//galon
                        ed_gal.setText("" + op3);

                        double op4 = valor1 / 1;//metro c
                        ed_m3.setText("" + op4);

                        double op5 = valor1 / 35.315;//pie c
                        ed_p3.setText("" + op5);

                        double op6 = valor1 * 61023.744;//pulg c
                        ed_pulg3.setText("" + op6);

                        double op7 = valor1 * 1056.688;//cuarto
                        ed_cuarto.setText("" + op7);

                        double op8 = valor1 * 2113.376;//pinta
                        ed_pinta.setText("" + op8);


                    } else if (seleccion.equals(getString(R.string.vol_pie3))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 28.317;
                        ed_l.setText("" + op);

                        double op2 = valor1 * 28316.847;//mililitro
                        ed_ml.setText("" + op2);

                        double op3 = valor1 / 7.481;//galon
                        ed_gal.setText("" + op3);

                        double op4 = valor1 / 35.315;//metro c
                        ed_m3.setText("" + op4);

                        double op5 = valor1 / 1;//pie c
                        ed_p3.setText("" + op5);

                        double op6 = valor1 * 1728;//pulg c
                        ed_pulg3.setText("" + op6);

                        double op7 = valor1 * 29.922;//cuarto
                        ed_cuarto.setText("" + op7);

                        double op8 = valor1 * 59.844;//pinta
                        ed_pinta.setText("" + op8);


                    } else if (seleccion.equals(getString(R.string.vol_pulgada3))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 61.024;
                        ed_l.setText("" + op);

                        double op2 = valor1 * 16.387;//mililitro
                        ed_ml.setText("" + op2);

                        double op3 = valor1 / 231;//galon
                        ed_gal.setText("" + op3);

                        double op4 = valor1 / 61023.744;//metro c
                        ed_m3.setText("" + op4);

                        double op5 = valor1 / 1728;//pie c
                        ed_p3.setText("" + op5);

                        double op6 = valor1 * 1;//pulg c
                        ed_pulg3.setText("" + op6);

                        double op7 = valor1 * 57.75;//cuarto
                        ed_cuarto.setText("" + op7);

                        double op8 = valor1 * 28.875;//pinta
                        ed_pinta.setText("" + op8);

                    } else if (seleccion.equals(getString(R.string.vol_cuartogalo))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 1.057;
                        ed_l.setText("" + op);

                        double op2 = valor1 * 946.353;//mililitro
                        ed_ml.setText("" + op2);

                        double op3 = valor1 / 4;//galon
                        ed_gal.setText("" + op3);

                        double op4 = valor1 / 1056.688;//metro c
                        ed_m3.setText("" + op4);

                        double op5 = valor1 / 29.922;//pie c
                        ed_p3.setText("" + op5);

                        double op6 = valor1 * 57.75;//pulg c
                        ed_pulg3.setText("" + op6);

                        double op7 = valor1 * 1;//cuarto
                        ed_cuarto.setText("" + op7);

                        double op8 = valor1 * 2;//pinta
                        ed_pinta.setText("" + op8);

                    } else if (seleccion.equals(getString(R.string.vol_pinta))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 2.113;
                        ed_l.setText("" + op);

                        double op2 = valor1 * 473.176;//mililitro
                        ed_ml.setText("" + op2);

                        double op3 = valor1 / 8;//galon
                        ed_gal.setText("" + op3);

                        double op4 = valor1 / 2113.376;//metro c
                        ed_m3.setText("" + op4);

                        double op5 = valor1 / 59.844;//pie c
                        ed_p3.setText("" + op5);

                        double op6 = valor1 * 28.875;//pulg c
                        ed_pulg3.setText("" + op6);

                        double op7 = valor1 * 2;//cuarto
                        ed_cuarto.setText("" + op7);

                        double op8 = valor1 * 1;//pinta
                        ed_pinta.setText("" + op8);

                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }


    public void punto(View view){
        int length = edNumeros.getText().length();
        if (length == 0) {
            edNumeros.setText(edNumeros.getText() + "0.");

        }else if(length > 0 && !edNumeros.getText().toString().contains(".")){
            edNumeros.setText(edNumeros.getText() + ".");

        }
    }


    public void onClick1(View view) {
        edNumeros.setText(edNumeros.getText() + "1");
    }

    public void onClick2(View view) {
        edNumeros.setText(edNumeros.getText() + "2");
    }    public void onClick3(View view) {
        edNumeros.setText(edNumeros.getText() + "3");
    }    public void onClick4(View view) {
        edNumeros.setText(edNumeros.getText() + "4");
    }    public void onClick5(View view) {
        edNumeros.setText(edNumeros.getText() + "5");
    }    public void onClick6(View view) {
        edNumeros.setText(edNumeros.getText() + "6");
    }
    public void onClick7(View view) {
        edNumeros.setText(edNumeros.getText() + "7");
    }
    public void onClick8(View view) {
        edNumeros.setText(edNumeros.getText() + "8");
    }
    public void onClick9(View view) {
        edNumeros.setText(edNumeros.getText() + "9");
    }
    public void onClick0(View view) {
        edNumeros.setText(edNumeros.getText() + "0");
    }
    public void borrar(View view){
        int length = edNumeros.getText().length();
        if (length > 0) {
            edNumeros.getText().delete(length - 1, length);


        }
        else if(length==0){
            limpiar();
        }
    }
    public void borrarTodo(View view){
        int length = edNumeros.getText().length();
        if (length > 0) {
            edNumeros.getText().delete(length - length,length);
            edNumeros.setText("");
            limpiar();

        }
    }

    public void limpiar(){
        ed_l.setText("0" );

        ed_ml.setText("0" );

        ed_gal.setText("0" );

        ed_m3.setText("0" );

        ed_pulg3.setText("0" );

        ed_p3.setText("0" );

        ed_pinta.setText("0" );

        ed_cuarto.setText("0" );

    }

}
