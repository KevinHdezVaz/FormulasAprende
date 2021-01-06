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


public class Area extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,punto;
    private EditText editText;
    private Spinner spinner1 ;

    private TextView res;
    private EditText ed1, m2, mi2,yarda2, pie2,pulga2,hectarea, acre,edNumeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);



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

        mi2 = (EditText) findViewById(R.id.milla2);
        m2 = (EditText) findViewById(R.id.m2);

        ed1 = (EditText) findViewById(R.id.km2);
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

        yarda2 =(EditText)findViewById(R.id.yar2);
        pie2 = (EditText)findViewById(R.id.pi2);
        pulga2 = (EditText)findViewById(R.id.pulgada2);
        hectarea = (EditText) findViewById(R.id.hectarea2);
        acre = (EditText) findViewById(R.id.acre);
        edNumeros = (EditText) findViewById(R.id.numero);
        spinner1 = (Spinner) findViewById(R.id.spinner1);



        String[] opciones = {getString(R.string.area_km2),getString(R.string.area_mt2),
                getString(R.string.area_mill2),getString(R.string.area_ya2),getString(R.string.area_pie2),getString(R.string.area_pulg2),
                getString(R.string.area_ha),getString(R.string.area_acre)};




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



                    if (seleccion.equals(getString(R.string.area_km2))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        ed1.setText("" + valor1);//km

                        double op2 = valor1 * 1000000;//metro
                        m2.setText("" + op2);

                        double op3 = valor1 / 2.59;//milla
                        mi2.setText("" + op3);
                        double op4 = valor1 * 1.196000000;//yarda
                        yarda2.setText("" + op4);

                        double op5 = valor1 * 1.0760000000;//pie
                        pie2.setText("" + op5);

                        double op6 = valor1 * 1.55000000000;//pulgada
                        pulga2.setText("" + op6);

                        double op7 = valor1 * 100;//hecta
                        hectarea.setText("" + op7);

                        double op8 = valor1 * 247.105;//acre
                        acre.setText("" + op8);


                    }else if (seleccion.equals(getString(R.string.area_mt2))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 1000000;
                        ed1.setText("" + op);//km

                        m2.setText("" + valor1);

                        double op3 = valor1 / 2.59000000;//milla
                        mi2.setText("" + op3);
                        double op4 = valor1 * 1.196;//yarda
                        yarda2.setText("" + op4);

                        double op5 = valor1 * 10.764;//pie
                        pie2.setText("" + op5);

                        double op6 = valor1 * 1550.003;//pulgada
                        pulga2.setText("" + op6);

                        double op7 = valor1 / 10000 ;//hecta
                        hectarea.setText("" + op7);

                        double op8 = valor1 / 4046.856;//acre
                        acre.setText("" + op8);


                    }else if (seleccion.equals(getString(R.string.area_mill2))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 2.59;
                        ed1.setText("" + op);//km

                        double op2 = valor1 * 2.59000000;//metro
                        m2.setText("" + op2);

                        mi2.setText("" + valor1);
                        double op4 = valor1 * 3.098000000;//yarda
                        yarda2.setText("" + op4);

                        double op5 = valor1 * 2.7880000000;//pie
                        pie2.setText("" + op5);

                        double op6 = valor1 * 4.014000000000;//pulgada
                        pulga2.setText("" + op6);

                        double op7 = valor1 * 258.999 ;//hecta
                        hectarea.setText("" + op7);

                        double op8 = valor1 / 640;//acre
                        acre.setText("" + op8);


                    }else if (seleccion.equals(getString(R.string.area_ya2))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 * 1.196000000;
                        ed1.setText("" + op);//km

                        double op2 = valor1 * 1.196;//metro
                        m2.setText("" + op2);

                        double op3 = valor1 / 3.098000000;//milla
                        mi2.setText("" + op3);

                        yarda2.setText("" + valor1);

                        double op5 = valor1 * 9;//pie
                        pie2.setText("" + op5);

                        double op6 = valor1 * 1296;//pulgada
                        pulga2.setText("" + op6);

                        double op7 = valor1 * 11959.9 ;//hecta
                        hectarea.setText("" + op7);

                        double op8 = valor1 / 4840;//acre
                        acre.setText("" + op8);


                    }
                    else if (seleccion.equals(getString(R.string.area_pie2))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 1.0760000000;
                        ed1.setText("" + op);//km

                        double op2 = valor1 / 10.764;//metro
                        m2.setText("" + op2);

                        double op3 = valor1 / 2.7880000000;//milla
                        mi2.setText("" + op3);
                        double op4 = valor1 * 9;//yarda
                        yarda2.setText("" + op4);

                        pie2.setText("" + valor1);

                        double op6 = valor1 * 144;//pulgada
                        pulga2.setText("" + op6);

                        double op7 = valor1 / 107639.104 ;//hecta
                        hectarea.setText("" + op7);

                        double op8 = valor1 / 43560;//acre
                        acre.setText("" + op8);

                    }  else if (seleccion.equals(getString(R.string.area_pulg2))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 1.55000000000;
                        ed1.setText("" + op);//km

                        double op2 = valor1 / 1550.003;//metro
                        m2.setText("" + op2);

                        double op3 = valor1 / 4.014000000000;//milla
                        mi2.setText("" + op3);
                        double op4 = valor1 * 1296;//yarda
                        yarda2.setText("" + op4);

                        double op5 = valor1 / 144;//pie
                        pie2.setText("" + op5);

                        pulga2.setText("" + valor1);

                        double op7 = valor1 / 1.550000000 ;//hecta
                        hectarea.setText("" + op7);

                        double op8 = valor1 / 6.273000000;//acre
                        acre.setText("" + op8);


                    } else if (seleccion.equals(getString(R.string.area_ha))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 100;
                        ed1.setText("" + op);//km

                        double op2 = valor1 * 10000;//metro
                        m2.setText("" + op2);

                        double op3 = valor1 / 258.999;//milla
                        mi2.setText("" + op3);
                        double op4 = valor1 * 11959.9;//yarda
                        yarda2.setText("" + op4);

                        double op5 = valor1 * 107639.104;//pie
                        pie2.setText("" + op5);

                        double op6 = valor1 * 1.550000000;//pulgada
                        pulga2.setText("" + op6);

                        hectarea.setText("" + valor1);

                        double op8 = valor1 * 2.471;//acre
                        acre.setText("" + op8);


                    }
                    else if (seleccion.equals(getString(R.string.area_acre))) {


                        double valor1 = Double.parseDouble(edNumeros.getText().toString());//km
                        double op = valor1 / 247.105;
                        ed1.setText("" + op);//km

                        double op2 = valor1 * 4046.856;//metro
                        m2.setText("" + op2);

                        double op3 = valor1 / 640;//milla
                        mi2.setText("" + op3);
                        double op4 = valor1 * 4840;//yarda
                        yarda2.setText("" + op4);

                        double op5 = valor1 * 43560;//pie
                        pie2.setText("" + op5);

                        double op6 = valor1 * 6.273000000;//pulgada
                        pulga2.setText("" + op6);

                        double op7 = valor1 / 2.471 ;//hecta
                        hectarea.setText("" + op7);

                        acre.setText("" + valor1);


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
            ed1.setText("0" );

            m2.setText("0" );

            mi2.setText("0" );

            pulga2.setText("0" );

            pie2.setText("0" );

            hectarea.setText("0" );

            acre.setText("0" );

            yarda2.setText("0" );

        }
}
