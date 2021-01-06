package app.wena.formulasaprende.Materias_Quimica;

import android.content.Intent;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

 import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import app.wena.formulasaprende.Activitis.Menu_principal;
import app.wena.formulasaprende.Quimica_children.Estequiometria_children.disoluciones_children;
import app.wena.formulasaprende.Quimica_children.Estequiometria_children.numAvogadro_children;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.listview_children.CustomAdapter3;
import app.wena.formulasaprende.listview_children.lista2;
import app.wena.formulasaprende.resolver.quimica.analitica;

public class Estequiometria extends AppCompatActivity {
    ExpandableListView expandableListView;
    private AdView mAdView;
    private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estequiometria);
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
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        list = (ListView) findViewById(R.id.item2_2);

        final ArrayList<lista2> listItems = new ArrayList<>();
        listItems.add(new lista2((R.drawable.chemistry),getString(R.string.numero_avogadro)));
        listItems.add(new lista2((R.drawable.chemistry),getString(R.string.disoluciones)));



        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Estequiometria.this, numAvogadro_children.class);
                    startActivity(intent);
                }
                else if (i == 1) {
                    Intent intent = new Intent(Estequiometria.this, disoluciones_children.class);
                    startActivity(intent);
                }


            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Estequiometria.this, analitica.class);

                startActivity(intent);

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Estequiometria.this, Menu_principal.class);

                startActivity(intent);
                finish();
            }
        });
    }


    /*
    public class ExpandableListViewAdaptereste extends BaseExpandableListAdapter {

        String[] gruponombres = {getString(R.string.numero_avogadro),getString(R.string.disoluciones)};

        int[][] childNames = {{R.drawable.num_avogado},{R.drawable.disoluciones}};
        Context context;

        public ExpandableListViewAdaptereste(Context context) { //aqui colocar el int [] imagenes
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
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            TextView txtview = new TextView(context);
            txtview.setText(gruponombres[i]);
            txtview.setPadding(100, 25, 0, 25);
            txtview.setTextSize(20);

            return txtview;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            ImageView imag = new ImageView(context);
            imag.setImageResource(childNames[i][i1]);
            imag.setScaleType(ImageView.ScaleType.FIT_START);
            imag.setPadding(0, 75, 0, 30);

            return imag;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }
    }


     */
}