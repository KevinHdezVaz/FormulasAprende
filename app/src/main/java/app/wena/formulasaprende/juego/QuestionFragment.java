package app.wena.formulasaprende.juego;

import app.wena.formulasaprende.R;
import android.os.Bundle;
import androidx.annotation.Nullable;
 import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class QuestionFragment extends Fragment {


    public QuestionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.question,container,false);
        return view;
    }

}
