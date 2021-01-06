package app.wena.formulasaprende.Activitis;


import android.app.Dialog;
import android.content.Intent;
 import android.content.pm.ActivityInfo;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.wena.formulasaprende.R;
import app.wena.formulasaprende.juego.LauncherActivity2;

public class MainActivity extends AppCompatActivity {
     Button  vamos2,boton,boton22,boton33,botonPRO_Android,botonPRO_Huawi,mat,mathuawi;
    ImageView cerrar;
     LinearLayout layout;
    DatabaseReference databaseReference;
    FloatingActionButton fabEstrella;
     TextView titulo,titulo2,introText;
      Dialog epicDialog,epicDialog2,epicDialog3;
    LottieAnimationView animacion2;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Use an activity context to get the rewarded video instance.

        titulo = findViewById(R.id.titulo);
        introText = findViewById(R.id.introText);
        animacion2 = findViewById(R.id.Animacion);

        fabEstrella = (FloatingActionButton) findViewById(R.id.fabEstrella);


         boton = (Button) findViewById(R.id.botonvamo);


        vamos2 = (Button) findViewById(R.id.botonvamo2);
        //  botonMenu = (Button) findViewById(R.id.btnMenuPrincipal);
        // juego =(Button )findViewById(R.id.BtnJuegos);
         setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        LinearLayout root=findViewById(R.id.root);

         fabEstrella.startAnimation(AnimationUtils.loadAnimation(this,R.anim.flicker_animation));
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        titulo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_advanced));
        animacion2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_left_time_trials));

        introText.startAnimation(AnimationUtils.loadAnimation(this,R.anim.from_right_0));



        databaseReference = FirebaseDatabase.getInstance().getReference().child("person");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String name = dataSnapshot.child("titulo").getValue().toString();
                introText.setText(name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
         /*
         fabSticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.formula.kevin.vale");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                mostrarInfo();
            }
        });
*/


         fabEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mostrarinfor1();
            }
        });




    }
    public void loadSlides(View view) {


        startActivity(new Intent(this, LauncherActivity2.class));
        finish();
    }
    public void cargarInicio(View view) {

            startActivity(new Intent(this, Menu_principal.class));
            finish();
            // para versiones anteriores a android 6.0

    }




    public void playStore(View view) {
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.formula.kevin.vale");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
*/


            }
        });
    }







    public void mostrarinfor1(){

        epicDialog = new Dialog(this);
        epicDialog.setContentView(R.layout.custompopu4);
        cerrar = (ImageView) epicDialog.findViewById(R.id.cerrarVentana);
         botonPRO_Android = (Button) epicDialog.findViewById(R.id.botonPRO_Android);
        botonPRO_Huawi = (Button) epicDialog.findViewById(R.id.botonPRO_Huawei);
        mat = (Button) epicDialog.findViewById(R.id.matquizz);

        mathuawi = (Button) epicDialog.findViewById(R.id.matquizz_Huawei);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();


  

        botonPRO_Android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://play.google.com/store/apps/details?id=com.finals.kas.pro";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);


            }
        });
        mathuawi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://appgallery.huawei.com/#/app/C103448627";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);


            }
        });

        botonPRO_Huawi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://appgallery.cloud.huawei.com/ag/n/app/C103488475?locale=es_US&source=appshare&subsource=C103488475";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);


            }
        }); mat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://play.google.com/store/apps/details?id=app.tercer.juegofinal";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);


            }
        });
    }

    /*
    public void mostrarinfor2(){

        epicDialog2 = new Dialog(this);
        epicDialog2.setContentView(R.layout.custompopu4);
        cerrar = (ImageView) epicDialog2.findViewById(R.id.cerrarVentana);
        boton22 = (Button) epicDialog2.findViewById(R.id.botonPRO);


        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog2.dismiss();
            }
        });

        epicDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog2.show();

        boton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String url = "https://play.google.com/store/apps/details?id=com.finaw.event.pro";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });

    }

    public void mostrarinfor3(){

        epicDialog3 = new Dialog(this);
        epicDialog3.setContentView(R.layout.custompopu5);
        cerrar = (ImageView) epicDialog3.findViewById(R.id.cerrarVentana);
        boton33 = (Button) epicDialog3.findViewById(R.id.botonvamo2);


        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog3.dismiss();
            }
        });

        epicDialog3.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog3.show();

        boton33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://play.google.com/store/apps/details?id=com.math.mathquiz";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);



            }
        });



    } */

    /*
    estoy feliz de desarrollar mi app, los amo equipo de Google Play <3
     */
}

