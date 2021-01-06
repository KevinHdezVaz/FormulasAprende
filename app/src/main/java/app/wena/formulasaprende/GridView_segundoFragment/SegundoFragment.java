package app.wena.formulasaprende.GridView_segundoFragment;
import app.wena.formulasaprende.R;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

  import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


import java.util.ArrayList;

public class SegundoFragment extends Fragment {
    private CustomAdapter adaptador;
    private InterstitialAd mInterstitialAd2;
    Dialog epicDialog;
    ImageView cerrar;
Button botonvam,btnvam2;
    private GridView grid;

    public SegundoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_segundo, container, false);

        epicDialog = new Dialog(getContext());

        mInterstitialAd2 = new InterstitialAd(getActivity());
        mInterstitialAd2.setAdUnitId(getString(R.string.interstic_ori));
        mInterstitialAd2.loadAd(new AdRequest.Builder().build());
        mInterstitialAd2.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd2.loadAd(new AdRequest.Builder().build());
            }

        });
        grid = (GridView) view.findViewById(R.id.item);

        final ArrayList<Spacecraft> listItems = new ArrayList<>();
        listItems.add(new Spacecraft((R.drawable.longitud), getString(R.string.lon_titu)));
        listItems.add(new Spacecraft((R.drawable.volumen), getString(R.string.vol_titu)));
        listItems.add(new Spacecraft((R.drawable.balanza), getString(R.string.masa_titu)));
        listItems.add(new Spacecraft((R.drawable.area), getString(R.string.area)));
        listItems.add(new Spacecraft((R.drawable.corredor_en_silueta_corriendo_rapido), getString(R.string.velo_titu)));
        listItems.add(new Spacecraft((R.drawable.velocidad), getString(R.string.pres_titu)));
        listItems.add(new Spacecraft((R.drawable.frec), getString(R.string.fre_titu)));
        listItems.add(new Spacecraft((R.drawable.termometro), getString(R.string.Tempera)));
        listItems.add(new Spacecraft((R.drawable.innovacion), getString(R.string.ene_titu)));
        listItems.add(new Spacecraft((R.drawable.angulo), getString(R.string.ang_titul)));

        listItems.add(new Spacecraft((R.drawable.tiemp), getString(R.string.tiempo_titu)));
        listItems.add(new Spacecraft((R.drawable.resistencia), getString(R.string.res_titu)));


        listItems.add(new Spacecraft((R.drawable.fruta2), getString(R.string.aceleracion)));
        listItems.add(new Spacecraft((R.drawable.matraz2), getString(R.string.densidad2)));

        listItems.add(new Spacecraft((R.drawable.fuerza2), getString(R.string.fuerza)));
        listItems.add(new Spacecraft((R.drawable.gas2), getString(R.string.cons_titu)));


        adaptador = new CustomAdapter(getActivity(), listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(getActivity(), Longitud_activity.class);
                      startActivity(intent);
                }
                else if(position ==1){
                    Intent intent = new Intent(getActivity(), Volumen_activity.class);
                    startActivity(intent);
                }

                else if (position == 2){
                    Intent intent = new Intent(getActivity(), Masa.class);
                    startActivity(intent);
                }
                else if (position == 3){
                    Intent intent = new Intent(getActivity(), Area.class);
                    if (mInterstitialAd2.isLoaded()) {
                        mInterstitialAd2.show();
                    }

                    else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }    startActivity(intent);
                }
                else if (position == 4){
                    Intent intent = new Intent(getActivity(), Velocidad.class);
                    if (mInterstitialAd2.isLoaded()) {
                        mInterstitialAd2.show();
                    }

                    else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }   startActivity(intent);
                }
                else if (position == 5){
                    Intent intent = new Intent(getActivity(), presion.class);
                    if (mInterstitialAd2.isLoaded()) {
                        mInterstitialAd2.show();
                    }

                    else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }    startActivity(intent);
                }
                else if (position == 6){
                    Intent intent = new Intent(getActivity(), Frecuencia.class);
                    startActivity(intent);
                }
                else if (position == 7){
                    Intent intent = new Intent(getActivity(), Temperatura.class);

                     startActivity(intent);
                }
                else if (position == 8){
                    Intent intent = new Intent(getActivity(), Energia.class);
                    if (mInterstitialAd2.isLoaded()) {
                        mInterstitialAd2.show();
                    }

                    else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }   startActivity(intent);
                }
                else if (position == 9){
                    Intent intent = new Intent(getActivity(), potencia.class);
                    startActivity(intent);
                }

                else if (position == 10){
                    Intent intent = new Intent(getActivity(), Tiempo.class);
                    startActivity(intent);
                }
                else if (position == 11){
                    Intent intent = new Intent(getActivity(), Resistencia.class);
                    if (mInterstitialAd2.isLoaded()) {
                        mInterstitialAd2.show();
                    }

                    else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }       startActivity(intent);
                }

                ///aqui ya es de paga brother
                else if (position == 12){
                    mostrarInfoPRO();
                }
                else if (position == 13){
                    mostrarInfoPRO();
                }
                else if (position == 14){
                    mostrarInfoPRO();
                }
                else if (position == 15){
                    mostrarInfoPRO();
                }
            }
        });
        return view;



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

