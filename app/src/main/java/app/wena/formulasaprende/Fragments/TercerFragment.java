package app.wena.formulasaprende.Fragments;

import app.wena.formulasaprende.AreayVolumen.Principales;
import app.wena.formulasaprende.ListView_primerFragment.CustomAdapter2;
import app.wena.formulasaprende.ListView_primerFragment.lista;
import app.wena.formulasaprende.R;
import app.wena.formulasaprende.TercerFragmento.Prefijos;
import app.wena.formulasaprende.TercerFragmento.calculadora.calculadora_cientifica;
import app.wena.formulasaprende.TercerFragmento.constantes;
import app.wena.formulasaprende.TercerFragmento.glosario_matematico;
import app.wena.formulasaprende.TercerFragmento.tablaPeriodica;
import app.wena.formulasaprende.TercerFragmento.tabla_equivalencia;
import app.wena.formulasaprende.TercerFragmento.toxicidad;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TercerFragment extends Fragment {
    private ListView list;
    private CustomAdapter2 adaptador;
    private InterstitialAd mInterstitialAd;

    public TercerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tercer, container, false);

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.interstic_ori));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        //ca-app-pub-3940256099942544/1033173712  prueba
        list = (ListView) view.findViewById(R.id.listaHerramientas);

        final ArrayList<lista> listItems = new ArrayList<>();
        listItems.add(new lista((R.drawable.presentation), getString(R.string.tabla_peri)));
        listItems.add(new lista((R.drawable.note), getString(R.string.alfabeto_griego)));
        listItems.add(new lista((R.drawable.notes), getString(R.string.prefijos)));


        listItems.add(new lista((R.drawable.artboard), getString(R.string.constantes_universale)));
        listItems.add(new lista((R.drawable.cuboo), getString(R.string.calcular_area)));
        listItems.add(new lista((R.drawable.note), getString(R.string.terminos_matematicos)));
        listItems.add(new lista((R.drawable.presentation), "Tabla de Equivalencias"));
        listItems.add(new lista((R.drawable.calcu), "Calculadora Cientifica"));

        adaptador = new CustomAdapter2(getActivity(), listItems);

        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
         if(i == 0){
            Intent k = new Intent(getActivity(), tablaPeriodica.class);
                startActivity(k);

        }
        else if(i == 7){
            Intent k = new Intent(getActivity(), calculadora_cientifica.class);
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }

            else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }            startActivity(k);

        }
    else if(i == 1){
            Intent k = new Intent(getActivity(), toxicidad.class);
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }

            else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }            startActivity(k);

        }
        else if(i == 6) {
            Intent k = new Intent(getActivity(), tabla_equivalencia.class);
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }

            else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
            startActivity(k);
        }
        else if(i == 4) {
            Intent k = new Intent(getActivity(), Principales.class);
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }

            else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
            startActivity(k);
        }
        else if(i == 5){
            Intent k = new Intent(getActivity(), glosario_matematico.class);
            startActivity(k);

        }

        else if(i == 3){
            Intent k = new Intent(getActivity(), constantes.class);
            startActivity(k);

        }

        else if(i == 2){

            Intent k = new Intent(getActivity(), Prefijos.class);
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }

            else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
            startActivity(k);

        }

            }
});



        return view;
    }

}
