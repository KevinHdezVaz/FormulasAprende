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


public class Tiempo extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,punto;
    private EditText editText;
    private Spinner spinner1 ;

    private TextView res;
    private EditText deca , año, mes,dia, hora,minuto,segundo,semana,edNumeros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo);

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

        deca = (EditText) findViewById(R.id.decada);
        año = (EditText) findViewById(R.id.año);
        mes = (EditText) findViewById(R.id.mes);
        dia = (EditText) findViewById(R.id.dia);

        hora = (EditText) findViewById(R.id.hora);
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

        minuto=(EditText)findViewById(R.id.minuto);
        segundo=(EditText)findViewById(R.id.segundo);
        semana=(EditText)findViewById(R.id.semana);

        edNumeros = (EditText) findViewById(R.id.numero);
        spinner1 = (Spinner) findViewById(R.id.spinner1);



        String[] opciones = {getString(R.string.tiemp_deca),getString(R.string.tiemp_año)
                ,getString(R.string.tiemp_mes),getString(R.string.tiemp_semana),getString(R.string.tiemp_dia),
                getString(R.string.tiemp_hora),getString(R.string.tiemp_minu),getString(R.string.tiemp_seg)};



        // Ocultar teclado virtual
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edNumeros.getWindowToken(), 0);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.spinner_item,opciones);




        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                edNumeros.setText("");
                limpiar();              }

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

                if (!charSequence.toString().isEmpty()) {


                    if (seleccion.equals(getString(R.string.tiemp_deca))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 * 1;//metro
                        deca.setText("" + op1);//km

                        double op2 = valor1 * 10;//metro
                        año.setText("" + op2);

                        double op3 = valor1 * 120;//milla
                        mes.setText("" + op3);

                        double op4 = valor1 * 521.429;//yarda
                        semana.setText("" + op4);

                        double op5 = valor1 * 3650;//yarda
                        dia.setText("" + op5);


                        double op7 = valor1 * 87600;//yarda
                        hora.setText("" + op7);

                        double op8 = valor1 * 525600000;//yarda
                        minuto.setText("" + op8);

                        double op9 = valor1 * 315400000;//yarda
                        segundo.setText("" + op9);
                    }

                   else if (seleccion.equals(getString(R.string.tiemp_año))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 / 10;//metro
                        deca.setText("" + op1);//km

                        double op2 = valor1 * 1;//metro
                        año.setText("" + op2);

                        double op3 = valor1 * 12;//milla
                        mes.setText("" + op3);

                        double op4 = valor1 * 52.143;//yarda
                        semana.setText("" + op4);

                        double op5 = valor1 * 365;//yarda
                        dia.setText("" + op5);


                        double op7 = valor1 * 8760;//yarda
                        hora.setText("" + op7);

                        double op8 = valor1 * 525600;//yarda
                        minuto.setText("" + op8);

                        double op9 = valor1 * 3.1540000000;//yarda
                        segundo.setText("" + op9);
                    }
                   else if (seleccion.equals(getString(R.string.tiemp_mes))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 / 120;//metro
                        deca.setText("" + op1);//km

                        double op2 = valor1 / 12;//metro
                        año.setText("" + op2);

                        double op3 = valor1 * 1;//milla
                        mes.setText("" + op3);

                        double op4 = valor1 * 4.345;//yarda
                        semana.setText("" + op4);

                        double op5 = valor1 * 30.417;//yarda
                        dia.setText("" + op5);


                        double op7 = valor1 * 730.001;//yarda
                        hora.setText("" + op7);

                        double op8 = valor1 * 43800.048;//yarda
                        minuto.setText("" + op8);

                        double op9 = valor1 * 2.628000000;//yarda
                        segundo.setText("" + op9);
                    }
                    else if (seleccion.equals(getString(R.string.tiemp_dia))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 / 3650;//metro
                        deca.setText("" + op1);//km

                        double op2 = valor1 / 365;//metro
                        año.setText("" + op2);

                        double op3 = valor1 / 30.417;//milla
                        mes.setText("" + op3);

                        double op4 = valor1 / 7;//yarda
                        semana.setText("" + op4);

                        double op5 = valor1 * 1;//yarda
                        dia.setText("" + op5);


                        double op7 = valor1 * 24;//yarda
                        hora.setText("" + op7);

                        double op8 = valor1 * 1440;//yarda
                        minuto.setText("" + op8);

                        double op9 = valor1 * 86400;//yarda
                        segundo.setText("" + op9);
                    }
                    else if (seleccion.equals(getString(R.string.tiemp_semana))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 / 521.429;//metro
                        deca.setText("" + op1);//km

                        double op2 = valor1 / 52.143;//metro
                        año.setText("" + op2);

                        double op3 = valor1 / 4.345;//milla
                        mes.setText("" + op3);

                        double op4 = valor1 *1 ;//yarda
                        semana.setText("" + op4);

                        double op5 = valor1 * 7;//yarda
                        dia.setText("" + op5);


                        double op7 = valor1 * 168;//yarda
                        hora.setText("" + op7);

                        double op8 = valor1 * 10080;//yarda
                        minuto.setText("" + op8);

                        double op9 = valor1 * 604800;//yarda
                        segundo.setText("" + op9);
                    }
                    else if (seleccion.equals(getString(R.string.tiemp_hora))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 / 87600;//metro
                        deca.setText("" + op1);//km

                        double op2 = valor1 / 8760;//metro
                        año.setText("" + op2);

                        double op3 = valor1 / 730.001;//milla
                        mes.setText("" + op3);

                        double op4 = valor1 /168 ;//yarda
                        semana.setText("" + op4);

                        double op5 = valor1 / 24;//yarda
                        dia.setText("" + op5);


                        double op7 = valor1 * 1;//yarda
                        hora.setText("" + op7);

                        double op8 = valor1 * 60;//yarda
                        minuto.setText("" + op8);

                        double op9 = valor1 * 3600;//yarda
                        segundo.setText("" + op9);
                    }
                    else if (seleccion.equals(getString(R.string.tiemp_minu))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 / 5.256000000;//metro
                        deca.setText("" + op1);//km

                        double op2 = valor1 / 525600;//metro
                        año.setText("" + op2);

                        double op3 = valor1 / 43800.048;//milla
                        mes.setText("" + op3);

                        double op4 = valor1 /10080 ;//yarda
                        semana.setText("" + op4);

                        double op5 = valor1 / 1440;//yarda
                        dia.setText("" + op5);


                        double op7 = valor1 / 60;//yarda
                        hora.setText("" + op7);

                        double op8 = valor1 * 1;//yarda
                        minuto.setText("" + op8);

                        double op9 = valor1 * 60;//yarda
                        segundo.setText("" + op9);
                    }
                    else if (seleccion.equals(getString(R.string.tiemp_seg))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 / 3.15400000000;//metro
                        deca.setText("" + op1);//km

                        double op2 = valor1 / 3.1540000000;//metro   %e

                        año.setText(""+op2 );

                        double op3 = valor1 / 2.628000000;//milla
                        mes.setText("" + op3);

                        double op4 = valor1 /604800 ;//yarda
                        semana.setText("" + op4);

                        double op5 = valor1 / 86400;//yarda
                        dia.setText("" + op5);


                        double op7 = valor1 / 3600;//yarda
                        hora.setText("" + op7);

                        double op8 = valor1 / 60;//yarda
                        minuto.setText("" + op8);

                        double op9 = valor1 * 1;//yarda
                        segundo.setText("" + op9);
                    }
                }


            } @Override
            public void afterTextChanged (Editable editable){

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
       deca.setText("0" );

        año.setText("0" );

        mes.setText("0" );
        dia.setText("0" );

        hora.setText("0");
        minuto.setText("0" );
        segundo.setText("0" );
semana.setText("0");


    }
}
