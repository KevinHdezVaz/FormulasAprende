package app.wena.formulasaprende.GridView_segundoFragment;
import app.wena.formulasaprende.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
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


public class Aceleracion extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,punto;
    private EditText editText;
    private Spinner spinner1 ;

    private TextView res;
    private EditText  mps2,ps2,gal,miligal,gravedadEstandar,fuerzag,edNumeros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceleracion);


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

        mps2 = (EditText) findViewById(R.id.mps2);
        ps2 = (EditText) findViewById(R.id.ps2);

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

        gal =(EditText)findViewById(R.id.gal);
        miligal = (EditText)findViewById(R.id.miligal);
        gravedadEstandar = (EditText)findViewById(R.id.gravedadEstandar);
        fuerzag = (EditText) findViewById(R.id.fuerzag);
         edNumeros = (EditText) findViewById(R.id.numero);
        spinner1 = (Spinner) findViewById(R.id.spinner1);



        String[] opciones = {getString(R.string.mps2),getString(R.string.pps2),
                getString(R.string.gal),getString(R.string.miligal),getString(R.string.gravedadEstandar),getString(R.string.fuerzag),
                };




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



                    if (seleccion.equals(getString(R.string.mps2))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km




                        double op2 = valor1 * 1;//metro
                        mps2.setText("" + op2);

                        double op3 = valor1 * 3.28083;//milla
                        ps2.setText("" + op3);
                        double op4 = valor1 * 100;//yarda
                        gal.setText("" + op4);

                        double op5 = valor1 * 100000;//pie
                        miligal.setText("" + op5);

                        double op6 = valor1 * 0.10197;//pulgada
                        gravedadEstandar.setText("" + op6);

                        double op7 = valor1 * 0.10197;//hecta
                        fuerzag.setText("" + op7);




                    }else if (seleccion.equals(getString(R.string.pps2))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km


                        double op2 = valor1 * 0.3048;//metro
                        mps2.setText("" + op2);

                        double op3 = valor1 * 1;//milla
                        ps2.setText("" + op3);

                        double op4 = valor1 * 30.4800 ;//yarda
                        gal.setText("" + op4);

                        double op5 = valor1 * 30480.06;//pie
                        miligal.setText("" + op5);

                        double op6 = valor1 * 0.03108 ;//pulgada
                        gravedadEstandar.setText("" + op6);

                        double op7 = valor1 * 0.03108 ;//hecta
                        fuerzag.setText("" + op7);


                    }else if (seleccion.equals(getString(R.string.gal))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km


                        double op2 = valor1 * 0.01 ;//metro
                        mps2.setText("" + op2);

                        double op3 = valor1 * 0.03281;//milla
                        ps2.setText("" + op3);

                        double op4 = valor1 * 1 ;//yarda
                        gal.setText("" + op4);

                        double op5 = valor1 * 1000;//pie
                        miligal.setText("" + op5);

                        double op6 = valor1 * 0.00102 ;//pulgada
                        gravedadEstandar.setText("" + op6);

                        double op7 = valor1 * 0.00102 ;//hecta
                        fuerzag.setText("" + op7);


                    }else if (seleccion.equals(getString(R.string.miligal))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km

                        double op2 = valor1 * 0.00001 ;//metro
                        mps2.setText("" + op2);

                        double op3 = valor1 * 0.00003;//milla
                        ps2.setText("" + op3);

                        double op4 = valor1 * 0.001 ;//yarda
                        gal.setText("" + op4);

                        double op5 = valor1 * 1;//pie
                        miligal.setText("" + op5);

                        double op6 = valor1 * 0.00000101971;//pulgada
                        gravedadEstandar.setText("" + op6);

                        double op7 = valor1 * 0.00000101971 ;//hecta
                        fuerzag.setText("" + op7);


                    }
                    else if (seleccion.equals(getString(R.string.gravedadEstandar))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km


                        double op2 = valor1 * 9.8066 ;//metro
                        mps2.setText("" + op2);

                        double op3 = valor1 * 32.1739;//milla
                        ps2.setText("" + op3);

                        double op4 = valor1 * 980.665 ;//yarda
                        gal.setText("" + op4);

                        double op5 = valor1 * 980665;//pie
                        miligal.setText("" + op5);

                        double op6 = valor1 * 1;//pulgada
                        gravedadEstandar.setText("" + op6);

                        double op7 = valor1 * 1 ;//hecta
                        fuerzag.setText("" + op7);


                    }  else if (seleccion.equals(getString(R.string.fuerzag))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op2 = valor1 * 9.8066 ;//metro
                        mps2.setText("" + op2);

                        double op3 = valor1 * 32.1739;//milla
                        ps2.setText("" + op3);

                        double op4 = valor1 * 980.665 ;//yarda
                        gal.setText("" + op4);

                        double op5 = valor1 * 980665;//pie
                        miligal.setText("" + op5);

                        double op6 = valor1 * 1;//pulgada
                        gravedadEstandar.setText("" + op6);

                        double op7 = valor1 * 1 ;//hecta
                        fuerzag.setText("" + op7);


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

        mps2.setText("0" );

        ps2.setText("0" );

        gal.setText("0" );

        miligal.setText("0" );

        gravedadEstandar.setText("0" );

        fuerzag.setText("0" );


    }
    }

