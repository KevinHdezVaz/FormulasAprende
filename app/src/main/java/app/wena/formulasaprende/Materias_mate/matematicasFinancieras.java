package app.wena.formulasaprende.Materias_mate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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

import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.InteresSimple;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.Interes_compuesto;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.MatFinancieras_Ejerc;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.amortizacion;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.anualidad_simple;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.capitalizacion_compuesta;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.capitalizacion_simple;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.inflacion;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.pib;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;

public class matematicasFinancieras extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    Button botonvam,btnvam2;
    ImageView cerrar;
    Dialog epicDialog; private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematicas_financieras);


        epicDialog = new Dialog(this);


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

        listItems.add(new lista2((R.drawable.calculadora),"Interes Simple"));
        listItems.add(new lista2((R.drawable.calculadora),"Interes Compuesto"));
        listItems.add(new lista2((R.drawable.calculadora),"Capitalización Simple"));
        listItems.add(new lista2((R.drawable.calculadora),"Capitalización Compuesta"));
        listItems.add(new lista2((R.drawable.calculadora),"Anualidad Simple"));
        listItems.add(new lista2((R.drawable.calculadora),"Amortización"));
        listItems.add(new lista2((R.drawable.calculadora),"Producto Interno Bruto"));
        listItems.add(new lista2((R.drawable.calculadora),"Tasa de inflación"));
        listItems.add(new lista2((R.drawable.seguridad),"Tasa de Interes Nominal"));

        listItems.add(new lista2((R.drawable.seguridad),"Prima de Riesgo"));

        listItems.add(new lista2((R.drawable.seguridad),"Resumen"));










        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            if(i==0){
                startActivity(new Intent(matematicasFinancieras.this, InteresSimple.class));
            }

               else if(i==1){
                            startActivity(new Intent(matematicasFinancieras.this, Interes_compuesto.class));
                }

            else if(i==2){
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                else   {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");

                }    startActivity(new Intent(matematicasFinancieras.this, capitalizacion_simple.class));
            }
            else if(i==3){
                startActivity(new Intent(matematicasFinancieras.this, capitalizacion_compuesta.class));
            }
            else if(i==4){
                startActivity(new Intent(matematicasFinancieras.this, anualidad_simple.class));
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                else   {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");

                }}
            else if(i==5){
                startActivity(new Intent(matematicasFinancieras.this, amortizacion.class));
            }
            else if(i==6){
                startActivity(new Intent(matematicasFinancieras.this, pib.class));
            }
            else if(i==7){
                startActivity(new Intent(matematicasFinancieras.this, inflacion.class));
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                else   {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");

                }}
            else if(i==8){
                mostrarInfoPRO();
            }else if(i==9){
                mostrarInfoPRO();
            }else if(i==10){
                mostrarInfoPRO();
            }
            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(matematicasFinancieras.this, MatFinancieras_Ejerc.class);

                startActivity(intent);
                finish();

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(matematicasFinancieras.this, Menu_principal.class);

                startActivity(intent);
                finish();

            }
        });
    } public void mostrarInfoPRO() {


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
