package app.wena.formulasaprende.Materias_Calculo;

import android.app.Dialog;
import android.content.Intent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;

 import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.integracion_partes;
import app.wena.formulasaprende.calculo_children.cambio_variable;
import app.wena.formulasaprende.calculo_children.derivada_children;
import app.wena.formulasaprende.calculo_children.derivada_funciones_childrne;
import app.wena.formulasaprende.calculo_children.derivada_hiperbolica_children;
import app.wena.formulasaprende.calculo_children.derivada_trigo_children;
import app.wena.formulasaprende.calculo_children.integrales_children;
import app.wena.formulasaprende.calculo_children.limite_producto_children;
import app.wena.formulasaprende.calculo_children.logaritmo_children;
import app.wena.formulasaprende.calculo_children.regla_basica_derivar;
import app.wena.formulasaprende.calculo_children.regla_basica_integrar;
import app.wena.formulasaprende.calculo_children.suma_producto_children;
import app.wena.formulasaprende.calculo_children.teorema_fundamental_children;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;
import app.wena.formulasaprende.resolver.calculo.calculo_integral;


public class Diferencial_Integral extends AppCompatActivity {
    ExpandableListView expandableListView;
    public AdView mAdView;
    ImageView cerrar;
    Button botonvam,btnvam2;
    Dialog epicDialog; private InterstitialAd mInterstitialAd;
    private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_diferencial__integral);
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
        mInterstitialAd.setAdUnitId("ca-app-pub-8882667917768463/3391564183");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        epicDialog = new Dialog(this);

        //ca-app-pub-3940256099942544/1033173712  prueba

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);




        list = (ListView) findViewById(R.id.item2_2);

        final ArrayList<lista2> listItems = new ArrayList<>();
        listItems.add(new lista2((R.drawable.diferencialicon),getString(R.string.logaritmo)));
        listItems.add(new lista2((R.drawable.diferencialicon),getString(R.string.suma_producto)));
        listItems.add(new lista2((R.drawable.diferencialicon),getString(R.string.regla_basica_derivar)));
        listItems.add(new lista2((R.drawable.diferencialicon),getString(R.string.regla_basica_integrar)));


        listItems.add(new lista2((R.drawable.diferencialicon),getString(R.string.teorema_fundamental)));
        listItems.add(new lista2((R.drawable.diferencialicon),getString(R.string.cambio_variable)));


        listItems.add(new lista2((R.drawable.diferencialicon),getString(R.string.suma_producto)));

        listItems.add(new lista2((R.drawable.diferencialicon), getString(R.string.limites)));
        listItems.add(new lista2((R.drawable.diferencialicon), getString(R.string.derivadas)));
        listItems.add(new lista2((R.drawable.diferencialicon), getString(R.string.derivada_funciones_log)));
        listItems.add(new lista2((R.drawable.diferencialicon), getString(R.string.derivada_trigono)));
        listItems.add(new lista2((R.drawable.diferencialicon), getString(R.string.derivada_hiperbolica)));
        listItems.add(new lista2((R.drawable.diferencialicon),"Integracion por partes"));

        listItems.add(new lista2((R.drawable.diferencialicon), getString(R.string.Integrales)));
        listItems.add(new lista2((R.drawable.seguridad), getString(R.string.integrales_funcionnes_log)));
        listItems.add(new lista2((R.drawable.seguridad), getString(R.string.integral_fracciones)));


        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Diferencial_Integral.this, logaritmo_children.class);
                    startActivity(intent);
                }
                else if (i == 1) {
                    Intent intent = new Intent(Diferencial_Integral.this, suma_producto_children.class);
                    startActivity(intent);
                }
                else if (i == 2) {
                    Intent intent = new Intent(Diferencial_Integral.this, regla_basica_derivar.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                    startActivity(intent);
                }
                else if (i == 3) {
                    Intent intent = new Intent(Diferencial_Integral.this, regla_basica_integrar.class);
                    startActivity(intent);
                }
                else if (i == 4) {
                    Intent intent = new Intent(Diferencial_Integral.this, teorema_fundamental_children.class);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }
                    startActivity(intent);
                }
                else if (i == 5) {
                    Intent intent = new Intent(Diferencial_Integral.this, cambio_variable.class);
                    startActivity(intent);
                }


                else if (i == 6) {
                    Intent intent = new Intent(Diferencial_Integral.this, suma_producto_children.class);
                    startActivity(intent);
                }

                else if (i == 7) {
                    Intent intent = new Intent(Diferencial_Integral.this, limite_producto_children.class);
                    startActivity(intent);
                }
                else
                 if (i == 8) {
                    Intent intent = new Intent(Diferencial_Integral.this, derivada_children.class);
                     if (mInterstitialAd.isLoaded()) {
                         mInterstitialAd.show();
                     }
                     else   {
                         Log.d("TAG", "The interstitial wasn't loaded yet.");

                     }
                    startActivity(intent);
                }
                else if (i == 9) {
                    Intent intent = new Intent(Diferencial_Integral.this, derivada_funciones_childrne.class);
                    startActivity(intent);
                } else if (i == 10) {
                    Intent intent = new Intent(Diferencial_Integral.this, derivada_trigo_children.class);
                    startActivity(intent);
                } else if (i == 11) {
                    Intent intent = new Intent(Diferencial_Integral.this, derivada_hiperbolica_children.class);
                     if (mInterstitialAd.isLoaded()) {
                         mInterstitialAd.show();
                     }
                     else   {
                         Log.d("TAG", "The interstitial wasn't loaded yet.");

                     }
                    startActivity(intent);
                }
                else if (i == 12) {
                    Intent intent = new Intent(Diferencial_Integral.this, integracion_partes.class);
                     if (mInterstitialAd.isLoaded()) {
                         mInterstitialAd.show();
                     }
                     else   {
                         Log.d("TAG", "The interstitial wasn't loaded yet.");

                     }
                    startActivity(intent);
                }
                else if (i == 13) {

                    Intent intent = new Intent(Diferencial_Integral.this, integrales_children.class);
                    startActivity(intent);
                } else if (i == 14) {
                     mostrarInfoPRO();
                }
                else if (i == 15) {
                     mostrarInfoPRO();
                }

            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Diferencial_Integral.this, calculo_integral.class);

                startActivity(intent);

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Diferencial_Integral.this, Menu_principal.class);

                startActivity(intent);
                finish();
            }
        });
    }


/*
    //ADAPTADOR DEL EXPANDABLE LISTVIEW
    public class ExpandableListViewAdapterCalculo extends BaseExpandableListAdapter {

        String[] gruponombres = {getString(R.string.logaritmo),getString(R.string.suma_producto),
                getString(R.string.limites),getString(R.string.derivadas)
                ,getString(R.string.derivada_funciones_log),
                getString(R.string.derivada_trigono),getString(R.string.derivada_hiperbolica),
                getString(R.string.Integrales),getString(R.string.integrales_funcionnes_log),
                getString(R.string.integral_fracciones),
                getString(R.string.integral_raiz),getString(R.string.integral_trigono)};

        int[][] childNames = {{R.drawable.logaritmos},{R.drawable.suma_productos},{R.drawable.limites},{R.drawable.derivada},{R.drawable.derivada_funciones_log},
                {R.drawable.deri_funcioes_trigo},{R.drawable.derivada_funciones_hiperbolicas},{R.drawable.integrales},{R.drawable.integrales_funcion_log},{R.drawable.integrales_fraccion},
                {R.drawable.integral_raiz},{R.drawable.integrales_trigonometricas}};
        Context context;



        public ExpandableListViewAdapterCalculo(Context context) { //aqui colocar el int [] imagenes
            this.context = context;
        }

        @Override
        public int getGroupCount() {
            return gruponombres.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return childNames[i].length;
        }

        @Override
        public Object getGroup(int i) {
            return gruponombres[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return childNames[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView( final int i, boolean b, View view, ViewGroup viewGroup) {
            TextView txtview = new TextView(context);
            txtview.setText(gruponombres[i]);
            txtview.setPadding(100, 25, 0, 25);
            txtview.setTextSize(20);
            txtview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(i==0){
                        Intent intent = new Intent(Diferencial_Integral.this,MainActivity.class );
                        startActivity(intent);
                    }
                }
            });
            return txtview;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            ImageView imag = new ImageView(context);
            imag.setImageResource(childNames[i][i1]);
            imag.setScaleType(ImageView.ScaleType.FIT_START);
            imag.setPadding(0, 75, 0, 0);

            return imag;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }

    }
    */

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

