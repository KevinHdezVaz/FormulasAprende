package app.wena.formulasaprende.Materias_mate;


import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.GridView_segundoFragment.SegundoFragment;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.EcuacionVariablesSeparadas;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.aplicacion_crecimiento_poblacional;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.aplicacion_mezclas;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.ecuacion_diferencial_bernoulli_children;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.ecuacion_diferencial_exacta;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.ecuacion_diferencial_lineal_children;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.ecuacion_diferencial_ricatti;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.ecuacion_homogenea_children;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class EcuacionesDiferenciales extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private ListView list;
    ImageView cerrar;
    Button botonvam,btnvam2;
    Dialog epicDialog;
    private CustomAdapter3 adaptador;
    SegundoFragment segundoFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuaciones_diferenciales);



        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradiente));
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar...
                finish();
            }
        });
        epicDialog = new Dialog(this);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstic_ori));
        //original  ca-app-pub-8882667917768463/3391564183

        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        list = (ListView) findViewById(R.id.item2_2);

        final ArrayList<lista2> listItems = new ArrayList<>();

        listItems.add(new lista2((R.drawable.ecuaciondf),"Ecuación diferencial separable"));
        listItems.add(new lista2((R.drawable.ecuaciondf),"Ecuación diferencial lineal"));
        listItems.add(new lista2((R.drawable.ecuaciondf),"Ecuaciones diferenciales homogéneas"));
        listItems.add(new lista2((R.drawable.ecuaciondf),"Ecuaciones diferenciales exactas"));
        listItems.add(new lista2((R.drawable.ecuaciondf),"Ecuación diferencial tipo Bernoulli"));
        listItems.add(new lista2((R.drawable.ecuaciondf),"Ecuación diferencial de Ricatti"));
        listItems.add(new lista2((R.drawable.ecuaciondf),"Aplicación - Crecimiento poblacional"));
        listItems.add(new lista2((R.drawable.ecuaciondf),"Aplicación - Mezclas"));

        listItems.add(new lista2((R.drawable.seguridad),"Aplicación - Ley de Enfriamiento de Newton"));
        listItems.add(new lista2((R.drawable.seguridad),"Aplicación - Circuitos Electricos"));





         segundoFragment = new SegundoFragment();
         adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0){
                   startActivity(new Intent(EcuacionesDiferenciales.this, EcuacionVariablesSeparadas.class));
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                }

                else if(i==1){
                    startActivity(new Intent(EcuacionesDiferenciales.this, ecuacion_diferencial_lineal_children.class));

                }
                else if(i==2){
                    startActivity(new Intent(EcuacionesDiferenciales.this, ecuacion_homogenea_children.class));
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                }
                else if(i==3){
                    startActivity(new Intent(EcuacionesDiferenciales.this, ecuacion_diferencial_exacta.class));

                }
                else if(i==4){
                    startActivity(new Intent(EcuacionesDiferenciales.this, ecuacion_diferencial_bernoulli_children.class));
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                }
                else if(i==5){
                    startActivity(new Intent(EcuacionesDiferenciales.this, ecuacion_diferencial_ricatti.class));
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                }
                else if(i==6){
                    startActivity(new Intent(EcuacionesDiferenciales.this, aplicacion_crecimiento_poblacional.class));

                }
                else if(i==7){
                    startActivity(new Intent(EcuacionesDiferenciales.this, aplicacion_mezclas.class));
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                }
                else if(i==8){
                  mostrarInfoPRO();

                }
                else if(i==9){
                    mostrarInfoPRO();

                }

            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EcuacionesDiferenciales.this,  Menu_principal.class);

                startActivity(intent);
                finish();

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(EcuacionesDiferenciales.this, Menu_principal.class);

                startActivity(intent);
                finish();

            }
        });

    }
    public void mostrarInfoPRO() {


        epicDialog.setContentView(R.layout.custompro);
        cerrar = (ImageView) epicDialog.findViewById(R.id.cerrarVentana);
        botonvam = (Button) epicDialog.findViewById(R.id.botonvamo2);
        btnvam2 = (Button) epicDialog.findViewById(R.id.botonvamo3);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();

        botonvam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://play.google.com/store/apps/details?id=com.finals.kas.pro";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        btnvam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://appgallery.huawei.com/#/app/C103488475";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
    }

