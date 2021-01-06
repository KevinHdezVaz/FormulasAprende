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


public class Resistencia extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,punto;
    private EditText editText;
    private Spinner spinner1 ;

    private TextView res;
    private EditText edNumeros, milo,ohmio,kilooh,megaohm,abo,voltio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistencia);

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

        milo = (EditText) findViewById(R.id.milohmios);
        ohmio = (EditText) findViewById(R.id.ohmios);

        kilooh =(EditText)findViewById(R.id.kilooh);
        megaohm = (EditText)findViewById(R.id.megaoh);
        abo = (EditText)findViewById(R.id.abohmio);
        voltio = (EditText) findViewById(R.id.voltioxampe);

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

        edNumeros = (EditText) findViewById(R.id.numero);
        spinner1 = (Spinner) findViewById(R.id.spinner1);


        String[] opciones = {getString(R.string.res_milio),getString(R.string.res_ohmnio),
                getString(R.string.res_kilo),getString(R.string.res_mega),getString(R.string.res_abo),getString(R.string.res_voltio)};




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


                    if (seleccion.equals(getString(R.string.res_milio))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 1;
                        milo.setText("" + op);//tonelada

                        double op2 = valor1 /1000;
                        ohmio.setText("" + op2);

                        double op3 = valor1 / 1000000;//gr
                        kilooh.setText("" + op3);

                        double op4 = valor1 / 1000000000;//quilate
                        megaohm.setText("" + op4);

                        double op5 = valor1 * 1000000;//mg
                        abo.setText("" + op5);

                        double op6 = valor1 /  1000;//stone
                        voltio.setText("" + op6);


                    }
                    if (seleccion.equals(getString(R.string.res_ohmnio))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 1000;
                        milo.setText("" + op);//tonelada

                        double op2 = valor1 *1;
                        ohmio.setText("" + op2);

                        double op3 = valor1 / 1000;//gr
                        kilooh.setText("" + op3);

                        double op4 = valor1 / 1000000;//quilate
                        megaohm.setText("" + op4);

                        double op5 = valor1 * 1000000000;//mg
                        abo.setText("" + op5);

                        double op6 = valor1 * 1;//stone
                        voltio.setText("" + op6);


                    }
                    if (seleccion.equals(getString(R.string.res_kilo))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 1000000;
                        milo.setText("" + op);//tonelada

                        double op2 = valor1 *1000;
                        ohmio.setText("" + op2);

                        double op3 = valor1 * 1;//gr
                        kilooh.setText("" + op3);

                        double op4 = valor1 / 1000;//quilate
                        megaohm.setText("" + op4);

                        double op5 = valor1 * 1000000000;//mg
                        abo.setText("" + op5);

                        double op6 = valor1 * 1000;//stone
                        voltio.setText("" + op6);


                    }
                    if (seleccion.equals(getString(R.string.res_mega))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 1000000000;
                        milo.setText("" + op);//tonelada

                        double op2 = valor1 *1000000;
                        ohmio.setText("" + op2);

                        double op3 = valor1 * 1000;//gr
                        kilooh.setText("" + op3);

                        double op4 = valor1 * 1;//quilate
                        megaohm.setText("" + op4);

                        double op5 = valor1 * 1000000000;//mg
                        abo.setText("" + op5);

                        double op6 = valor1 * 1000000;//stone
                        voltio.setText("" + op6);


                    }
                    if (seleccion.equals(getString(R.string.res_abo))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 1000000;
                        milo.setText("" + op);//tonelada

                        double op2 = valor1 /1000000000;
                        ohmio.setText("" + op2);

                        double op3 = valor1 / 1000000000;//gr
                        kilooh.setText("" + op3);

                        double op4 = valor1 / 1000000000;//quilate
                        megaohm.setText("" + op4);

                        double op5 = valor1 * 1;//mg
                        abo.setText("" + op5);

                        double op6 = valor1 / 1000000000;//stone
                        voltio.setText("" + op6);


                    }
                    if (seleccion.equals(getString(R.string.res_voltio))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 1000;
                        milo.setText("" + op);//tonelada

                        double op2 = valor1 * 1;
                        ohmio.setText("" + op2);

                        double op3 = valor1 / 1000;//gr
                        kilooh.setText("" + op3);

                        double op4 = valor1 / 1000000;//quilate
                        megaohm.setText("" + op4);

                        double op5 = valor1 * 1000000;//mg
                        abo.setText("" + op5);

                        double op6 = valor1 * 1;//stone
                        voltio.setText("" + op6);


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
        milo.setText("0" );

        ohmio.setText("0" );

        kilooh.setText("0" );

        megaohm.setText("0" );

        abo.setText("0" );

        voltio.setText("0" );



    }
}