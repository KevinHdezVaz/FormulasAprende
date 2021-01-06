package app.wena.formulasaprende.ListView_primerFragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import app.wena.formulasaprende.R;
import java.util.ArrayList;

public class CustomAdapter2 extends BaseAdapter {

    private Context context;
    private ArrayList<lista> listItem;


    public CustomAdapter2(Context context, ArrayList<lista> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        lista Item =(lista)getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.model2,null);
        ImageView imagen = (ImageView)view.findViewById(R.id.imagen2);
        TextView titulo = (TextView)view.findViewById(R.id.titulo2);

        imagen.setImageResource(Item.getImgFoto());
        titulo.setText(Item.getTitulo());
        return view;
    }
}