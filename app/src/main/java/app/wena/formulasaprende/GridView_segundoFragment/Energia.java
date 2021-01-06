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


public class Energia extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,punto;
    private EditText editText;
    private Spinner spinner1 ;

    private TextView res;
    private EditText juli, kilojoul, kilocalo,vatioHora, kilovatioHora,BTU,edNumeros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energia);



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

        juli = (EditText) findViewById(R.id.julio);
        kilojoul = (EditText) findViewById(R.id.kilojoule);
        kilovatioHora = (EditText) findViewById(R.id.kilovatio_hora);
        BTU = (EditText) findViewById(R.id.btu);

        kilocalo = (EditText) findViewById(R.id.kilocaloria);
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

        vatioHora=(EditText)findViewById(R.id.vatio_hora);

        edNumeros = (EditText) findViewById(R.id.numero);
        spinner1 = (Spinner) findViewById(R.id.spinner1);



        String[] opciones = {getString(R.string.ene_juli),getString(R.string.ene_kiloju),
                getString(R.string.ene_kiloca),getString(R.string.ene_vatioHora),
                getString(R.string.ene_kilovatio),getString(R.string.ene_btu)};



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


                    if (seleccion.equals(getString(R.string.ene_juli))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 * 1;//metro
                        juli.setText("" + op1);//km

                        double op2 = valor1 / 1000;//metro
                        kilojoul.setText("" + op2);

                        double op3 = valor1 / 4184;//milla
                        kilocalo.setText("" + op3);

                        double op4 = valor1 / 3600;//yarda
                        vatioHora.setText("" + op4);

                        double op5 = valor1 / 3.6000000;//yarda
                        kilovatioHora.setText("" + op5);


                        double op7 = valor1 / 1055.056;//yarda
                        BTU.setText("" + op7);
                    }
                        else if (seleccion.equals(getString(R.string.ene_kiloju))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 * 1000;//metro
                        juli.setText("" + op1);//km

                        double op2 = valor1 / 1;//metro
                        kilojoul.setText("" + op2);

                        double op3 = valor1 / 4.184;//milla
                        kilocalo.setText("" + op3);

                        double op4 = valor1 / 3.6;//yarda
                        vatioHora.setText("" + op4);

                        double op5 = valor1 / 3600;//yarda
                        kilovatioHora.setText("" + op5);


                        double op7 = valor1 / 1.055;//yarda
                        BTU.setText("" + op7);
                    }

                    else if (seleccion.equals(getString(R.string.ene_kiloca))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 * 4184;//metro
                        juli.setText("" + op1);//km

                        double op2 = valor1 * 4.184;//metro
                        kilojoul.setText("" + op2);

                        double op3 = valor1 * 1;//milla
                        kilocalo.setText("" + op3);

                        double op4 = valor1 * 1.162;//yarda
                        vatioHora.setText("" + op4);

                        double op5 = valor1 / 860.421;//yarda
                        kilovatioHora.setText("" + op5);


                        double op7 = valor1 * 3.966;//yarda
                        BTU.setText("" + op7);
                    }

                    else if (seleccion.equals(getString(R.string.ene_vatioHora))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 * 3.6000000;//metro
                        juli.setText("" + op1);//km

                        double op2 = valor1 * 3600;//metro
                        kilojoul.setText("" + op2);

                        double op3 = valor1 * 860.421;//milla
                        kilocalo.setText("" + op3);

                        double op4 = valor1 * 1000;//yarda
                        vatioHora.setText("" + op4);

                        double op5 = valor1 * 1;//yarda
                        kilovatioHora.setText("" + op5);


                        double op7 = valor1 * 3412.142;//yarda
                        BTU.setText("" + op7);
                    }
                    else if (seleccion.equals(getString(R.string.ene_kilovatio))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 * 3600;//metro
                        juli.setText("" + op1);//km

                        double op2 = valor1 * 3.6;//metro
                        kilojoul.setText("" + op2);

                        double op3 = valor1 / 1.162;//milla
                        kilocalo.setText("" + op3);

                        double op4 = valor1 * 1;//yarda
                        vatioHora.setText("" + op4);

                        double op5 = valor1 / 1000;//yarda
                        kilovatioHora.setText("" + op5);


                        double op7 = valor1 * 3.412;//yarda
                        BTU.setText("" + op7);
                    }
                    else if (seleccion.equals(getString(R.string.ene_btu))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op1 = valor1 * 1055.056;//metro
                        juli.setText("" + op1);//km

                        double op2 = valor1 * 1.055;//metro
                        kilojoul.setText("" + op2);

                        double op3 = valor1 / 3.966;//milla
                        kilocalo.setText("" + op3);

                        double op4 = valor1 / 3.412;//yarda
                        vatioHora.setText("" + op4);

                        double op5 = valor1 / 3412.142;//yarda
                        kilovatioHora.setText("" + op5);


                        double op7 = valor1 * 1;//yarda
                        BTU.setText("" + op7);
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
        juli.setText("0" );

        kilojoul.setText("0" );

        vatioHora.setText("0" );
        kilocalo.setText("0" );

        kilovatioHora.setText("0");
        BTU.setText("0" );



    }
}
