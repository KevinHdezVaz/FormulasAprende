package app.wena.formulasaprende.buscador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

import app.wena.formulasaprende.R;

public class principal extends AppCompatActivity implements  UsersAdapter.SelectedUser{

    Toolbar toolbar;
    RecyclerView recyclerView;

    List<UserModel> userModelList = new ArrayList<>();

    String[] names = {"Alcanos, Alquenos y Alquinos",
            "Angulo opuesto","Angulo complementario",

            "Aplicacion - Crecimiento poblacional","Aplicacion - Mezclas",

            "Angulo suplementario","Binomio de Newton","Ley de Biot-Savart","Ley de Boyle-Mariotte"
    ,"Cadena Carbonada","Caida Libre","Calor","Cambio de Variable",
            "Campo Electrico","Capacidad Calorifica","Capacitor en Paralelo","Capacitor en Serie","Caudal","Centro de Gravedad","Circuito en Paralelo","Circuito en Serie","Circunferencia con centro en el origen",
    "Circunferencia con centro fuera del origen","Clasificación de Triangulos segun sus angulos","Conjugado de un numero complejo","Cosenos directores","Densidad","Derivadas","Derivada de funciones exponenciales",
    "Derivada de funciones hiperbolicas","Derivada de funciones trigonometricas","Descomposicion Rectangular","Desviacion Estandar","Dilatacion Lineal","Dilatacion de Liquidos","Dilatacion Superficial","Dilatacion Volumetrica","Disoluciones","Distancia entre dos puntos","Distancia de un punto a una recta","Distribucion Binomial",
    "Ecuacion de estado de los gases ideales",
            "Ecuacion diferencial separable","Ecuacion diferencial lineal",
            "Ecuacion diferencial homogenea","Ecuacion diferencial exacta",
            "Ecuacion diferencial tipo Bernoulli","Ecuacion diferencial de Ricatti",

            "Ecuacion general de las conicas","Energia del campo electrico","Energia Cinetica y Potencial","Energia Fotonica","Esperanza Matematica","Factor de Magnificacion","Formulas de Factorizacion","Formula General","Fuerza Centripeta","Trabajo,Energia y Potencia",
    "Ley de los Gases","Halogenuros de Alquilo","Hidrocarburos Aromaticos","Hidrocarburos Ciclicos","Hiperbola","Indice de Refraccion","Integracion por partes","Integrales de Funciones LOG y EXP","Integrales","Integrales de Fracciones","Interferencias","Integrales de Fracciones",

            "Interes simple","Interes compuesto","Capitalizacion simple","Capitalizacion compuesta",
            "Anualidad simple","Amortizacion","Producto interno bruto","Tasa de inflacion",

            "Ley de Laplace","Ley de Coulomb | Fuerza Electrica","Ley de los Exponentes",
    "Ley de la Gravitacion Universal","Ley de Hooke","Ley de Ohm","Ley de Reflexion","Ley de Signos","Ley de Snell o de Refraccion","Leyes de Newton","Limites","Logaritmos","Maquinas Termicas","Matriz Cuadrada","Matriz Diagonal y Escalar","Matriz Ortogonal","Matriz Simetrica y Antisimetrica","Matriz Transpuesta","Mediana","Moda","Modulo de un Vector","Movimiento de Cargas en el Interior de un Campo Electrico",
    "Movimiento Circular Uniforme","Movimiento Horizontal de Proyectiles","Movimiento Parabolico","Movimiento de Proyectiles en Angulo","Movimiento Rectilineo Uniforme","Movimiento Vertical de Proyectiles","Multiplicacion de Matrices","Norma de un Vector","Numero de Avogadro","Numero Mach","Numero de Reynolds","Numero Mixto","Numeros Complejos","Numeros Reales","Operaciones con Numeros Complejos","Operaciones con Conjuntos",
    "Potencia de Fracciones","Presion y Esfuerzos","Permutaciones","Ley de Presiones Parciales o de Dalton","Primer Principio de la Termodinamica","Principio de Arquimedes","Principio de Bernoulli","Principio de Pascal","Principio de Superposicion","Probabilidad Condicional","Procesos Termodinamicos e Isotermicos","Producto Punto o Producto Escalar","Producto Cruz o Producto Vectorial","Productos Notables","Media aritmetica o Promedio","Punto medio de la Recta",
    "Distancia de un punto Q a un Plano","Razones del angulo suma / diferencia","Regla para Derivar","Regla para Integrar","Regla de Cramer","Regla de Sarrus","Regla de tres directa","Relaciones de la Trigonometria","Resistividad Electrica","Razones Trigonometricas","Suma y Resta de Matrices","Suma y Productos","Sumatoria","Teorema Fundamental del Calculo","Teorema de Lamy","Teorema de Pitagoras","Teorema de Stokes","Clasificacion de Atomos de Carbono",
    "Traza de una Matriz",
             "Valor Absoluto","Varianza","Vector Unitario","Vectores","Volumen Especifico"};
    UsersAdapter usersAdapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            recyclerView = findViewById(R.id.recyclerviewxd);
            toolbar = findViewById(R.id.toolbarUser);

             setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            toolbar.setTitle("");
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //regresar...
                    finish();
                }
            });
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


            for(String s:names){
                UserModel userModel = new UserModel(s);

                userModelList.add(userModel);
            }


            usersAdapter = new UsersAdapter(userModelList,this);

            recyclerView.setAdapter(usersAdapter);


        }

        @Override
        public void selectedUser(UserModel userModel) {

            startActivity(new Intent(principal.this, SeleccionarUser.class).putExtra("data",userModel));



        }


//poruqe no la declare en el manifest

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu2, menu);

            MenuItem menuItem = menu.findItem(R.id.search_view2);

            SearchView searchView = (SearchView) menuItem.getActionView();

            searchView.setMaxWidth(Integer.MAX_VALUE);

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {

                    usersAdapter.getFilter().filter(newText);
                    return true;
                }
            });



            return  true;
        }
//
        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();

            if(id == R.id.search_view2){
                return  true;
            }

            return super.onOptionsItemSelected(item);
        }
    }
