package app.wena.formulasaprende.juego.adivina_numero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

 import com.google.android.gms.ads.InterstitialAd;
import com.mrntlu.toastie.Toastie;

import app.wena.formulasaprende.R;
import app.wena.formulasaprende.juego.LauncherActivity2;

public class juegoPrincipal extends AppCompatActivity {
    EditText et_num_usuario;
    TextView tv_intentos;
    Button btn_comprobar;
    View v;
    Dialog epicDialog;
    ImageView cerrar;

     TextView mensajeResultado;
    TextView resultado,resultado2;
    private InterstitialAd mInterstitialAd;
    Button botonvamo;
     SharedPreferences sharedPref;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_principal);

        et_num_usuario=findViewById(R.id.et_num_usuario);
        tv_intentos=findViewById(R.id.tv_intentos);
        btn_comprobar=findViewById(R.id.btn_comprobar);

        //preferencias para mandar el puntaje a la clase score
         preferences = getSharedPreferences("highScore",MODE_PRIVATE);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);



    }
    public int obtenerAleatorio(){
        double d=Math.random();
        int n_maximo = principalAdivina.darNumMaximo();
        double aleatorio=d*n_maximo;
        int n_aleatorio=(int)aleatorio;
        return n_aleatorio;

    }


    int intentos = 0;
    int numero_aleatorio = obtenerAleatorio();

    public void comprobar(View v) {
        String numero = et_num_usuario.getText().toString();

        int n_maximo= principalAdivina.darNumMaximo();


        if (numero.equals(""))
        {
            Toastie.warning(this, "Introduzca un número, y luego pulse enviar.", Toast.LENGTH_LONG).show();
        }
        else
        {
            int numero_usuario = Integer.parseInt(numero);

            if (numero_usuario > n_maximo)
            {

                Toastie.topError(this, "Creo que te pasaste de número JAJAJA", Toast.LENGTH_SHORT).show();
            }
            else
            {

                if (numero_usuario == numero_aleatorio) {
                    mostrarInfo();




                }

                else if (numero_usuario < numero_aleatorio) {
                    intentos++;
                    tv_intentos.setText(String.valueOf(intentos));
                    Toastie.topError(this,"El número que estoy pensando ES MAYOR.",Toast.LENGTH_SHORT).show();

                }

                else if (numero_usuario > numero_aleatorio) {
                    intentos++;
                    tv_intentos.setText(String.valueOf(intentos));
                    Toastie.topInfo(this,"El número que estoy pensando ES MENOR.",Toast.LENGTH_SHORT).show();
                 }

            }
        }
        et_num_usuario.setText("");


    }

    public void mostrarInfo(){
        epicDialog = new Dialog(this);
        epicDialog.setContentView(R.layout.custom_resultado2);
        cerrar = (ImageView)epicDialog.findViewById(R.id.cerrarVentana2);
        resultado =(TextView)epicDialog.findViewById(R.id.txtResultado);
        mensajeResultado =(TextView)epicDialog.findViewById(R.id.msjResultado);
        resultado2 =(TextView)epicDialog.findViewById(R.id.txtResultado2);


        intentos++;
        tv_intentos.setText(String.valueOf(intentos));

       resultado.setText(""+intentos);

        preferences.edit().putString("highScore","Intentos: "+resultado.getText().toString()).apply();

        if(intentos >= 6){
            resultado2.setText("Sigue intentandolo, no todo se logra a la primera ;) ");
        }

        else if(intentos == 5){
            resultado2.setText("¡Animo, la paciencia y esfuerzo son las mejores virtudes!");
        }
        else if(intentos == 4){
            resultado2.setText("4 aciertos, casi le das... Como a tu crush.");
        }
        else if(intentos == 3){
            resultado2.setText("De seguro estudias ingeniería.");
        }
        else if(intentos == 1){
            resultado2.setText("Me asombra tu intelecto, ¿Acaso eres humano? :o");
        }


        botonvamo =(Button)epicDialog.findViewById(R.id.botonvamo);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   QuizContext.getInstance().resetContext();
                Intent intent = new Intent(juegoPrincipal.this, LauncherActivity2.class);
                startActivity(intent);
            finish();
                epicDialog.dismiss();

            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        epicDialog.setCancelable(false);
        epicDialog.setCanceledOnTouchOutside(false);
        epicDialog.show();
        botonvamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //QuizContext.getInstance().resetContext();
                Intent intent = new Intent(juegoPrincipal.this, principalAdivina.class);
                startActivity(intent);
                finish();




            }
        });
    }
    public void onClick1(View view) {
        et_num_usuario.setText(et_num_usuario.getText() + "1");
    }

    public void onClick2(View view) {
        et_num_usuario.setText(et_num_usuario.getText() + "2");
    }    public void onClick3(View view) {
        et_num_usuario.setText(et_num_usuario.getText() + "3");
    }    public void onClick4(View view) {
        et_num_usuario.setText(et_num_usuario.getText() + "4");
    }    public void onClick5(View view) {
        et_num_usuario.setText(et_num_usuario.getText() + "5");
    }    public void onClick6(View view) {
        et_num_usuario.setText(et_num_usuario.getText() + "6");
    }
    public void onClick7(View view) {
        et_num_usuario.setText(et_num_usuario.getText() + "7");
    }
    public void onClick8(View view) {
        et_num_usuario.setText(et_num_usuario.getText() + "8");
    }
    public void onClick9(View view) {
        et_num_usuario.setText(et_num_usuario.getText() + "9");
    }
    public void onClick0(View view) {
        et_num_usuario.setText(et_num_usuario.getText() + "0");
    }




}