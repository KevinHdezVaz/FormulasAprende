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


public class Longitud_activity extends AppCompatActivity {
    private Spinner spinner1 ;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,punto;
    private EditText editText;
    private TextView res;
    private EditText ed1, edNumeros, ed_m, ed_cm, ed_milim,ed_decim,ed_mill,ed_yarda, ed_pulg,ed_pie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longitud_activity);
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

        ed_cm = (EditText) findViewById(R.id.texto_cm);
        ed_m = (EditText) findViewById(R.id.texto_m);

        ed1 = (EditText) findViewById(R.id.texto_km);
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

        ed_milim =(EditText)findViewById(R.id.texto_milimetro);
        ed_decim = (EditText)findViewById(R.id.texto_Decim);
        ed_mill = (EditText)findViewById(R.id.texto_milla);
        ed_yarda = (EditText) findViewById(R.id.texto_yarda);
        ed_pulg = (EditText) findViewById(R.id.texto_pulgada);
        ed_pie =(EditText)findViewById(R.id.texto_pie);
        edNumeros = (EditText) findViewById(R.id.numero);
        spinner1 = (Spinner) findViewById(R.id.spinner1);



        String[] opciones = {getString(R.string.lon_km),
                getString(R.string.lon_me),getString(R.string.lon_cen),getString(R.string.lon_milim),
                getString(R.string.lon_deci),getString(R.string.lon_milla),getString(R.string.lon_yarda),
                getString(R.string.lon_pulga),getString(R.string.lon_pie)};




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
                String seleccion = spinner1.getSelectedItem().toString();

                if(!charSequence.toString().isEmpty()) {


                    if (seleccion.equals(getString(R.string.lon_km))) {

                        limpiar();
                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 1;
                        ed1.setText("" + op);

                        double op2 = valor1 * 1000;//metro
                        ed_m.setText("" + op2);

                        double op3 = valor1 * 100000;//cm
                        ed_cm.setText("" + op3);

                        double op4 = valor1 * 1000000;//cm
                        ed_milim.setText("" + op4);

                        double op5 = valor1 * 10000;//cm
                        ed_decim.setText("" + op5);

                        double op6 = valor1 / 1.609;//milla
                        ed_mill.setText("" + op6);

                        double op7 = valor1 * 1093.613;//yarda
                        ed_yarda.setText("" + op7);

                        double op8 = valor1 * 39370.079;//pulgada
                        ed_pulg.setText("" + op8);

                        double op9 = valor1 *  3280.84;//pulgada
                        ed_pie.setText("" + op9);
                    }
                    else if (seleccion.equals(getString(R.string.lon_me))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 1000;
                        ed1.setText("" + op);

                        double op2 = valor1 * 1;//metro
                        ed_m.setText("" + op2);

                        double op3 = valor1 * 100;//cm
                        ed_cm.setText("" + op3);

                        double op4 = valor1 * 1000;//cm
                        ed_milim.setText("" + op4);

                        double op5 = valor1 * 10;//cm
                        ed_decim.setText("" + op5);

                        double op6 = valor1 / 1609.344;//milla
                        ed_mill.setText("" + op6);

                        double op7 = valor1 * 1.094;//yarda
                        ed_yarda.setText("" + op7);

                        double op8 = valor1 * 39.37;//pulgada
                        ed_pulg.setText("" + op8);

                        double op9 = valor1 *  3.281;//pulgada
                        ed_pie.setText("" + op9);

                    }
                    else if (seleccion.equals(getString(R.string.lon_cen))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 100000; //kilometro
                        ed1.setText("" + op);

                        double op2 = valor1 / 100;//metro
                        ed_m.setText("" + op2);

                        double op3 = valor1 * 1;//cm
                        ed_cm.setText("" + op3);

                        double op4 = valor1 * 10;//cm
                        ed_milim.setText("" + op4);

                        double op5 = valor1 / 10;//cm
                        ed_decim.setText("" + op5);

                        double op6 = valor1 / 160934.4;//milla
                        ed_mill.setText("" + op6);

                        double op7 = valor1 / 91.44;//yarda
                        ed_yarda.setText("" + op7);

                        double op8 = valor1 / 2.54;//pulgada
                        ed_pulg.setText("" + op8);

                        double op9 = valor1 /  30.48;//pulgada
                        ed_pie.setText("" + op9);

                    }
                    else if (seleccion.equals(getString(R.string.lon_milim))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 1000000; //kilometro
                        ed1.setText("" + op);

                        double op2 = valor1 / 1000;//metro
                        ed_m.setText("" + op2);

                        double op3 = valor1 / 10;//cm
                        ed_cm.setText("" + op3);

                        double op4 = valor1 * 1;//mili
                        ed_milim.setText("" + op4);

                        double op5 = valor1 / 100;//dec
                        ed_decim.setText("" + op5);

                        double op6 = valor1 / 1.609000000
                                ;//milla
                        ed_mill.setText("" + op6);

                        double op7 = valor1 / 914.4;//yarda
                        ed_yarda.setText("" + op7);

                        double op8 = valor1 / 25.4
                                ;//pulgada
                        ed_pulg.setText("" + op8);

                        double op9 = valor1 /  304.8;//pulgada
                        ed_pie.setText("" + op9);

                    }
                    else if (seleccion.equals(getString(R.string.lon_deci))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 10000; //kilometro
                        ed1.setText("" + op);

                        double op2 = valor1 / 10;//metro
                        ed_m.setText("" + op2);

                        double op3 = valor1 * 10;//cm
                        ed_cm.setText("" + op3);

                        double op4 = valor1 * 100;//mili
                        ed_milim.setText("" + op4);

                        double op5 = valor1 / 1;//dec
                        ed_decim.setText("" + op5);

                        double op6 = valor1 / 16093.44
                                ;//milla
                        ed_mill.setText("" + op6);

                        double op7 = valor1 / 9.144;//yarda
                        ed_yarda.setText("" + op7);

                        double op8 = valor1 / 3.937
                                ;//pulgada
                        ed_pulg.setText("" + op8);

                        double op9 = valor1 /  3.048;//pulgada
                        ed_pie.setText("" + op9);

                    }
                    else if (seleccion.equals(getString(R.string.lon_milla))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 1.609; //kilometro
                        ed1.setText("" + op);

                        double op2 = valor1 * 1609.344;//metro
                        ed_m.setText("" + op2);

                        double op3 = valor1 * 160934.4;//cm
                        ed_cm.setText("" + op3);

                        double op4 = valor1 * 1.609000000;//mili
                        ed_milim.setText("" + op4);

                        double op5 = valor1 * 16093.44;//dec
                        ed_decim.setText("" + op5);

                        double op6 = valor1 * 1 ;//milla
                        ed_mill.setText("" + op6);

                        double op7 = valor1 * 1760; //yarda
                        ed_yarda.setText("" + op7);

                        double op8 = valor1 * 63360 ; //pulgada
                        ed_pulg.setText("" + op8);

                        double op9 = valor1 * 5280; //pulgada
                        ed_pie.setText("" + op9);

                    }
                    else if (seleccion.equals(getString(R.string.lon_yarda))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 1093.613; //kilometro
                        ed1.setText("" + op);

                        double op2 = valor1 / 1.094;//metro
                        ed_m.setText("" + op2);

                        double op3 = valor1 * 91.44;//cm
                        ed_cm.setText("" + op3);

                        double op4 = valor1 * 914.4;//mili
                        ed_milim.setText("" + op4);

                        double op5 = valor1 * 9.144;//dec
                        ed_decim.setText("" + op5);

                        double op6 = valor1 / 1760 ;//milla
                        ed_mill.setText("" + op6);

                        double op7 = valor1 * 1; //yarda
                        ed_yarda.setText("" + op7);

                        double op8 = valor1 * 36 ; //pulgada
                        ed_pulg.setText("" + op8);

                        double op9 = valor1 * 3; //pie
                        ed_pie.setText("" + op9);

                    }
                    else if (seleccion.equals(getString(R.string.lon_pulga))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 39370.079  ; //kilometro
                        ed1.setText("" + op);

                        double op2 = valor1 / 39.37;//metro
                        ed_m.setText("" + op2);

                        double op3 = valor1 * 2.54  ;//cm
                        ed_cm.setText("" + op3);

                        double op4 = valor1 * 25.4
                                ;//mili
                        ed_milim.setText("" + op4);

                        double op5 = valor1 / 100;//dec
                        ed_decim.setText("" + op5);

                        double op6 = valor1 / 1.609000000
                                ;//milla
                        ed_mill.setText("" + op6);

                        double op7 = valor1 / 914.4; //yarda
                        ed_yarda.setText("" + op7);

                        double op8 = valor1 *1 ; //pulgada
                        ed_pulg.setText("" + op8);

                        double op9 = valor1 / 304.8; //pie
                        ed_pie.setText("" + op9);

                    }
                    else if (seleccion.equals(getString(R.string.lon_pie))) {

                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 3280.84  ; //kilometro
                        ed1.setText("" + op);

                        double op2 = valor1 / 3.281;//metro
                        ed_m.setText("" + op2);

                        double op3 = valor1 * 30.48  ;//cm
                        ed_cm.setText("" + op3);

                        double op4 = valor1 * 304.8
                                ;//mili
                        ed_milim.setText("" + op4);

                        double op5 = valor1 * 3.048;//dec
                        ed_decim.setText("" + op5);

                        double op6 = valor1 / 5280
                                ;//milla
                        ed_mill.setText("" + op6);

                        double op7 = valor1 / 3; //yarda
                        ed_yarda.setText("" + op7);

                        double op8 = valor1 * 12 ; //pulgada
                        ed_pulg.setText("" + op8);

                        double op9 = valor1 * 1; //pie
                        ed_pie.setText("" + op9);

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
        ed1.setText("0" );

        ed_m.setText("0" );

        ed_cm.setText("0" );

        ed_milim.setText("0" );

        ed_decim.setText("0" );

        ed_mill.setText("0" );

        ed_yarda.setText("0" );

        ed_pulg.setText("0" );

        ed_pie.setText("0" );
    }
}
