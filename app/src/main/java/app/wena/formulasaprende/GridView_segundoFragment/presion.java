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


public class presion extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,punto;
    private EditText editText;
    private Spinner spinner1 ;

    private TextView res;
    private EditText atmosfera, edNumeros, bar,megapasc, pasca,kilopasc,milibar, torr,psi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presion);

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

        bar = (EditText) findViewById(R.id.bar);
        megapasc = (EditText) findViewById(R.id.megapasca);

        atmosfera = (EditText) findViewById(R.id.atmosfera);
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

        pasca =(EditText)findViewById(R.id.pascal);
        kilopasc = (EditText)findViewById(R.id.kiopascal);
        milibar = (EditText)findViewById(R.id.milibar);
        torr = (EditText) findViewById(R.id.toor);
        edNumeros = (EditText) findViewById(R.id.numero);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        psi = (EditText)findViewById(R.id.psi);



        String[] opciones = {getString(R.string.pres_atmos),getString(R.string.pres_bar),
                getString(R.string.pres_megapas)
                ,getString(R.string.pres_pasc),getString(R.string.pres_kilo),getString(R.string.pres_mili),getString(R.string.pres_torr),getString(R.string.psi)};




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


                    if (seleccion.equals(getString(R.string.pres_atmos))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 1;
                        atmosfera.setText("" + op);//tonelada

                        double op2 = valor1 * 1.013;//kg
                        bar.setText("" + op2);

                        double op3 = valor1 / 9.869;//gr
                        megapasc.setText("" + op3);

                        double op4 = valor1 * 101325;//quilate
                        pasca.setText("" + op4);

                        double op5 = valor1 * 101.325    ;//mg
                        kilopasc.setText("" + op5);

                        double op6 = valor1 * 1013.25;//stone
                        milibar.setText("" + op6);

                        double op7 = valor1 * 760   ;//libra
                        torr.setText("" + op7);

                        double op8 = valor1 * 14.696   ;//libra
                        psi.setText("" + op8);




                    }        else if (seleccion.equals(getString(R.string.pres_bar))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 1.013;
                        atmosfera.setText("" + op);//tonelada

                        double op2 = valor1 * 1;//kg
                        bar.setText("" + op2);

                        double op3 = valor1 / 10;//gr
                        megapasc.setText("" + op3);

                        double op4 = valor1 * 100000;//quilate
                        pasca.setText("" + op4);

                        double op5 = valor1 * 100;//mg
                        kilopasc.setText("" + op5);

                        double op6 = valor1 * 1000;//stone
                        milibar.setText("" + op6);

                        double op7 = valor1 * 750.062;//libra
                        torr.setText("" + op7);

                        double op8 = valor1 * 14.504   ;//libra
                        psi.setText("" + op8);
                    }
                    else if (seleccion.equals(getString(R.string.pres_megapas))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 9.869;
                        atmosfera.setText("" + op);//tonelada

                        double op2 = valor1 * 10;//kg
                        bar.setText("" + op2);

                        double op3 = valor1 * 1;//gr
                        megapasc.setText("" + op3);

                        double op4 = valor1 * 1000000;//quilate
                        pasca.setText("" + op4);

                        double op5 = valor1 * 1000;//mg
                        kilopasc.setText("" + op5);

                        double op6 = valor1 * 10000;//stone
                        milibar.setText("" + op6);

                        double op7 = valor1 * 7500.617;//libra
                        torr.setText("" + op7);

                        double op8 = valor1 * 145   ;//libra
                        psi.setText("" + op8);

                    }    else if (seleccion.equals(getString(R.string.pres_pasc))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 101325;
                        atmosfera.setText("" + op);//tonelada

                        double op2 = valor1 / 100000;//kg
                        bar.setText("" + op2);

                        double op3 = valor1 / 1000000;//gr
                        megapasc.setText("" + op3);

                        double op4 = valor1 * 1;//quilate
                        pasca.setText("" + op4);

                        double op5 = valor1 / 1000;//mg
                        kilopasc.setText("" + op5);

                        double op6 = valor1 / 100;//stone
                        milibar.setText("" + op6);

                        double op7 = valor1 / 133.322;//libra
                        torr.setText("" + op7);

                        double op8 = valor1 / 6895   ;//libra
                        psi.setText("" + op8);
                    }
                    else if (seleccion.equals(getString(R.string.pres_kilo))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 101.325;
                        atmosfera.setText("" + op);//tonelada

                        double op2 = valor1 / 100;//kg
                        bar.setText("" + op2);

                        double op3 = valor1 / 1000;//gr
                        megapasc.setText("" + op3);

                        double op4 = valor1 * 1000;//quilate
                        pasca.setText("" + op4);

                        double op5 = valor1 * 1;//mg
                        kilopasc.setText("" + op5);

                        double op6 = valor1 * 10;//stone
                        milibar.setText("" + op6);

                        double op7 = valor1 * 7.501;//libra
                        torr.setText("" + op7);

                        double op8 = valor1 / 6.895   ;//libra
                        psi.setText("" + op8);
                    }
                    else if (seleccion.equals(getString(R.string.pres_mili))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1/ 1013.25;
                        atmosfera.setText("" + op);//tonelada

                        double op2 = valor1 /1000;//kg
                        bar.setText("" + op2);

                        double op3 = valor1 / 10000;//gr
                        megapasc.setText("" + op3);

                        double op4 = valor1 * 100;//quilate
                        pasca.setText("" + op4);

                        double op5 = valor1 /10 ;//mg
                        kilopasc.setText("" + op5);

                        double op6 = valor1 * 1;//stone
                        milibar.setText("" + op6);

                        double op7 = valor1 / 1.333;//libra
                        torr.setText("" + op7);

                        double op8 = valor1 / 68.948   ;//libra
                        psi.setText("" + op8);

                    }
                    else if (seleccion.equals(getString(R.string.pres_torr))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1/ 760;
                        atmosfera.setText("" + op);//tonelada

                        double op2 = valor1 /750.062;//kg
                        bar.setText("" + op2);

                        double op3 = valor1 / 7500.617;//gr
                        megapasc.setText("" + op3);

                        double op4 = valor1 * 133.322;//quilate
                        pasca.setText("" + op4);

                        double op5 = valor1 /7.501 ;//mg
                        kilopasc.setText("" + op5);

                        double op6 = valor1 * 1.333;//stone
                        milibar.setText("" + op6);

                        double op7 = valor1 *1 ;//libra
                        torr.setText("" + op7);
                        double op8 = valor1 / 51.715   ;//libra
                        psi.setText("" + op8);
                    }

                    else if (seleccion.equals(getString(R.string.psi))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1/ 14.696;
                        atmosfera.setText("" + op);//tonelada

                        double op2 = valor1 / 14.504;//kg
                        bar.setText("" + op2);

                        double op3 = valor1 / 145;//gr
                        megapasc.setText("" + op3);

                        double op4 = valor1 * 6895;//quilate
                        pasca.setText("" + op4);

                        double op5 = valor1 * 6.895 ;//mg
                        kilopasc.setText("" + op5);

                        double op6 = valor1 * 68.948;//stone
                        milibar.setText("" + op6);

                        double op7 = valor1 / 51.715 ;//libra
                        torr.setText("" + op7);
                        double op8 = valor1 * 1   ;//libra
                        psi.setText("" + op8);
                    }

                    //para mañana pasar los temas de matematicas financieras y ese otro
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

    public void limpiar(){ //unidades de masa
        atmosfera.setText("0" );

        bar.setText("0" );

        kilopasc.setText("0" );

        pasca.setText("0" );

        torr.setText("0" );

        megapasc.setText("0" );

        milibar.setText("0" );


    }
}