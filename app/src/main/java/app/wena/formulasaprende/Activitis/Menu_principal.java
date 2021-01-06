package app.wena.formulasaprende.Activitis;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;

import com.google.android.material.tabs.TabLayout;

 import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import app.wena.formulasaprende.PageAdapter;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.buscador.principal;


public class Menu_principal extends AppCompatActivity {

    Dialog epicDialog,epicDialog2;
    Button botonface;
    ImageView cerrar,cerrar2;
String link;
    Boolean calificacion = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradiente));
        setSupportActionBar(toolbar);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);


        TabLayout tabs = (TabLayout) findViewById(R.id.my_Tablayout);
        tabs.addTab(tabs.newTab().setText(getString(R.string.Menu)));
        tabs.addTab(tabs.newTab().setText(getString(R.string.conve)));
        tabs.addTab(tabs.newTab().setText(getString(R.string.herra)));
        tabs.setBackground(getResources().getDrawable(R.drawable.gradiente));
        PagerAdapter adapter = new PageAdapter(getSupportFragmentManager(), 3);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));






        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item1) {
            mostrarFace();

        }  else if(item.getItemId() == R.id.search_view) {

            Intent intent2 = new Intent(Menu_principal.this, principal.class);
            startActivity(intent2);
        }
        return super.onOptionsItemSelected(item);
    }

    public void play(){
        String url = "https://play.google.com/store/apps/details?id=com.formula.kevin.formulas";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }





    public void mostrarFace() {
        epicDialog2 = new Dialog(this);
        epicDialog2.setContentView(R.layout.custom_popup);
        cerrar2 =  epicDialog2.findViewById(R.id.cerrarVentana2);
        botonface =   epicDialog2.findViewById(R.id.botonface);

        cerrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog2.dismiss();
            }
        });

        epicDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog2.show();


        botonface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String facebookId = "fb://page/2182902815353778";
                String urlPage = "http://www.facebook.com/iFormulas";

                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookId )));
                } catch (Exception e) {
                    Toast.makeText(Menu_principal.this, "Aplicacion FACEBOOK No instalada", Toast.LENGTH_SHORT).show();
                    //Abre url de pagina.
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlPage)));
                }   /*
                String url = "https://www.facebook.com/iFormulas/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                2182902815353778


                 */
            }
        });

    }




    }

