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


public class Velocidad extends AppCompatActivity {
    private Spinner spinner1 ;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,punto;
     private EditText  edNumeros, ed_mi,pie,metro,kilometro,nudo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocidad);

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

        ed_mi = (EditText) findViewById(R.id.milla);
        pie = (EditText) findViewById(R.id.pie);

        metro = (EditText) findViewById(R.id.metro);
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

        kilometro =(EditText)findViewById(R.id.kilometro);
        nudo = (EditText)findViewById(R.id.nudo);

        edNumeros = (EditText) findViewById(R.id.numero);
        spinner1 = (Spinner) findViewById(R.id.spinner1);



        String[] opciones = {getString(R.string.velo_millaxh),
                getString(R.string.velo_piexseg),getString(R.string.velo_metroxseg),
                getString(R.string.velo_kiloxhora),getString(R.string.velo_nudo)};




        // Ocultar teclado virtual
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edNumeros.getWindowToken(), 0);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.spinner_item,opciones);




        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                edNumeros.setText("");
                limpiar();
            }

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


                    if (seleccion.equals(getString(R.string.velo_millaxh))) {
                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 *1;
                        ed_mi.setText("" + op);

                        double op2 = valor1 * 1.467;//mililitro
                        pie.setText("" + op2);

                        double op3 = valor1 / 2.237;//galon
                        metro.setText("" + op3);

                        double op4 = valor1 * 1.609;//metro c
                        kilometro.setText("" + op4);

                        double op5 = valor1 / 1.151;//pie c
                        nudo.setText("" + op5);

                    } else if (seleccion.equals(getString(R.string.velo_piexseg))) {
                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1/1.467;
                        ed_mi.setText("" + op);

                        double op2 = valor1 * 1;//mililitro
                        pie.setText("" + op2);

                        double op3 = valor1 / 3.281;//galon
                        metro.setText("" + op3);

                        double op4 = valor1 * 1.097;//metro c
                        kilometro.setText("" + op4);

                        double op5 = valor1 / 1.688;//pie c
                        nudo.setText("" + op5);
                    }else if (seleccion.equals(getString(R.string.velo_metroxseg))) {
                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1*2.237;
                        ed_mi.setText("" + op);

                        double op2 = valor1 * 3.281;//mililitro
                        pie.setText("" + op2);

                        double op3 = valor1 / 1;//galon
                        metro.setText("" + op3);

                        double op4 = valor1 * 3.6;//metro c
                        kilometro.setText("" + op4);

                        double op5 = valor1 * 1.944;//pie c
                        nudo.setText("" + op5);
                    }
                    else if (seleccion.equals(getString(R.string.velo_kiloxhora))) {
                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1/1.609;
                        ed_mi.setText("" + op);

                        double op2 = valor1 * 1.097;//mililitro
                        pie.setText("" + op2);

                        double op3 = valor1 / 3.6;//galon
                        metro.setText("" + op3);

                        double op4 = valor1 * 1;//metro c
                        kilometro.setText("" + op4);

                        double op5 = valor1 * 1.852;//pie c
                        nudo.setText("" + op5);
                    }  else if (seleccion.equals(getString(R.string.velo_nudo))) {
                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1*1.151;
                        ed_mi.setText("" + op);

                        double op2 = valor1 * 1.688;//mililitro
                        pie.setText("" + op2);

                        double op3 = valor1 / 1.944;//galon
                        metro.setText("" + op3);

                        double op4 = valor1 * 1.852;//metro c
                        kilometro.setText("" + op4);

                        double op5 = valor1 * 1;//pie c
                        nudo.setText("" + op5);
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
        ed_mi.setText("0" );

        kilometro.setText("0" );

        metro.setText("0" );

        pie.setText("0" );

        nudo.setText("0" );

    }

                    }

