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


public class Masa extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,punto;
    private EditText editText;
    private Spinner spinner1 ;

    private TextView res;
    private EditText ed1, edNumeros, kilo,gramo, quilate,miligramo,stone, libra,onza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa);

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

        gramo = (EditText) findViewById(R.id.gramo);
        kilo = (EditText) findViewById(R.id.kiloframo);

        ed1 = (EditText) findViewById(R.id.tonelada);
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

        quilate =(EditText)findViewById(R.id.quilate);
        miligramo = (EditText)findViewById(R.id.miligramo);
        stone = (EditText)findViewById(R.id.stone);
        libra = (EditText) findViewById(R.id.libra);
        onza = (EditText) findViewById(R.id.onza);
        edNumeros = (EditText) findViewById(R.id.numero);
        spinner1 = (Spinner) findViewById(R.id.spinner1);



        String[] opciones = {getString(R.string.masa_ton),getString(R.string.masa_kg),
                getString(R.string.masa_gra),getString(R.string.masa_quila),
                getString(R.string.masa_milig),getString(R.string.masa_stone),getString(R.string.masa_libra),getString(R.string.masa_onza)};




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


                    if (seleccion.equals(getString(R.string.masa_ton))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 1;
                        ed1.setText("" + op);//tonelada

                        double op2 = valor1 * 1000;//kg
                        kilo.setText("" + op2);

                        double op3 = valor1 * 1000000;//gr
                        gramo.setText("" + op3);
                        double op4 = valor1 * 5000000;//quilate
                        quilate.setText("" + op4);

                        double op5 = valor1 * 1000000000    ;//mg
                        miligramo.setText("" + op5);

                        double op6 = valor1 * 157.473;//stone
                        stone.setText("" + op6);

                        double op7 = valor1 * 2204.623;//libra
                        libra.setText("" + op7);

                        double op8 = valor1 * 35273.962;//onza
                        onza.setText("" + op8);


                    }     else if (seleccion.equals(getString(R.string.masa_kg))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 1000;
                        ed1.setText("" + op);//tonelada

                        double op2 = valor1 * 1;//kg
                        kilo.setText("" + op2);

                        double op3 = valor1 * 1000;//gr
                        gramo.setText("" + op3);
                        double op4 = valor1 * 5000;//quilate
                        quilate.setText("" + op4);

                        double op5 = valor1 * 1000000    ;//mg
                        miligramo.setText("" + op5);

                        double op6 = valor1 / 6.35;//stone
                        stone.setText("" + op6);

                        double op7 = valor1 * 2.205;//libra
                        libra.setText("" + op7);

                        double op8 = valor1 * 35.274;//onza
                        onza.setText("" + op8);


                    } else if (seleccion.equals(getString(R.string.masa_gra))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 1000000;
                        ed1.setText("" + op);//tonelada

                        double op2 = valor1 / 1000;//kg
                        kilo.setText("" + op2);

                        double op3 = valor1 * 1;//gr
                        gramo.setText("" + op3);
                        double op4 = valor1 * 5;//quilate
                        quilate.setText("" + op4);

                        double op5 = valor1 * 1000    ;//mg
                        miligramo.setText("" + op5);

                        double op6 = valor1 / 6350.293;//stone
                        stone.setText("" + op6);

                        double op7 = valor1 / 453.592;//libra
                        libra.setText("" + op7);

                        double op8 = valor1 / 28.35;//onza
                        onza.setText("" + op8);


                    }else if (seleccion.equals(getString(R.string.masa_quila))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 5000000;
                        ed1.setText("" + op);//tonelada

                        double op2 = valor1 / 5000;//kg
                        kilo.setText("" + op2);

                        double op3 = valor1 * 5;//gr
                        gramo.setText("" + op3);
                        double op4 = valor1 * 1;//quilate
                        quilate.setText("" + op4);

                        double op5 = valor1 * 200    ;//mg
                        miligramo.setText("" + op5);

                        double op6 = valor1 / 31751.466;//stone
                        stone.setText("" + op6);

                        double op7 = valor1 / 2267.962;//libra
                        libra.setText("" + op7);

                        double op8 = valor1 / 141.748;//onza
                        onza.setText("" + op8);


                    }else if (seleccion.equals(getString(R.string.masa_milig))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 1000000000;
                        ed1.setText("" + op);//tonelada

                        double op2 = valor1 /1000000;//kg
                        kilo.setText("" + op2);

                        double op3 = valor1 / 1000;//gr
                        gramo.setText("" + op3);
                        double op4 = valor1 / 200;//quilate
                        quilate.setText("" + op4);

                        double op5 = valor1 * 1    ;//mg
                        miligramo.setText("" + op5);

                        double op6 = valor1 / 6.35000000;//stone
                        stone.setText("" + op6);

                        double op7 = valor1 / 453592.37;//libra
                        libra.setText("" + op7);

                        double op8 = valor1 / 28349.523;//onza
                        onza.setText("" + op8);


                    }else if (seleccion.equals(getString(R.string.masa_stone))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 157.473;
                        ed1.setText("" + op);//tonelada

                        double op2 = valor1 * 6.35;//kg
                        kilo.setText("" + op2);

                        double op3 = valor1 * 6350.293;//gr
                        gramo.setText("" + op3);
                        double op4 = valor1 * 31751.466;//quilate
                        quilate.setText("" + op4);

                        double op5 = valor1 * 6.35000000    ;//mg
                        miligramo.setText("" + op5);

                        double op6 = valor1 / 1;//stone
                        stone.setText("" + op6);

                        double op7 = valor1 / 14;//libra
                        libra.setText("" + op7);

                        double op8 = valor1 / 224;//onza
                        onza.setText("" + op8);


                    }
                    else if (seleccion.equals(getString(R.string.masa_onza))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 35273.962;
                        ed1.setText("" + op);//tonelada

                        double op2 = valor1 / 35.274;//kg
                        kilo.setText("" + op2);

                        double op3 = valor1 * 28.35;//gr
                        gramo.setText("" + op3);
                        double op4 = valor1 * 141.748;//quilate
                        quilate.setText("" + op4);

                        double op5 = valor1 * 28349.523    ;//mg
                        miligramo.setText("" + op5);

                        double op6 = valor1 / 224;//stone
                        stone.setText("" + op6);

                        double op7 = valor1 / 16;//libra
                        libra.setText("" + op7);

                        double op8 = valor1 * 1;//onza
                        onza.setText("" + op8);


                    }else if (seleccion.equals(getString(R.string.masa_libra))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 2204.623;
                        ed1.setText("" + op);//tonelada

                        double op2 = valor1 / 2.205;//kg
                        kilo.setText("" + op2);

                        double op3 = valor1 * 453.592;//gr
                        gramo.setText("" + op3);
                        double op4 = valor1 * 2267.962;//quilate
                        quilate.setText("" + op4);

                        double op5 = valor1 * 453592.37    ;//mg
                        miligramo.setText("" + op5);

                        double op6 = valor1 / 14;//stone
                        stone.setText("" + op6);

                        double op7 = valor1 / 1;//libra
                        libra.setText("" + op7);

                        double op8 = valor1 / 16;//onza
                        onza.setText("" + op8);


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

    public void limpiar(){ //unidades de masa
        ed1.setText("0" );

        miligramo.setText("0" );

        gramo.setText("0" );

        stone.setText("0" );

        libra.setText("0" );

        onza.setText("0" );

        kilo.setText("0" );

        quilate.setText("0" );

    }
}
