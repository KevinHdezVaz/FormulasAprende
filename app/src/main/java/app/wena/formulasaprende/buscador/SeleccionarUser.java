package app.wena.formulasaprende.buscador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import app.wena.formulasaprende.R;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.caida_libre_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.energia_cinetica_potencial_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.fuerza_centripeta_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.fuerza_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.ley_gravitacion_universal_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.movimiento_circular_uniforme_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.movimiento_horizontal_proyectiles_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.movimiento_parabolico_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.movimiento_proyectiles_angulo_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.movimiento_rectilineo_uniforme_children;
import app.wena.formulasaprende.Fisica_children.Mecanica_children.movimiento_vertical_proyectiles_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.centro_gravedad_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.descomposicion_regular_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.ley_hooke_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.leyes_newton_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.principio_bernoulli_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.teorema_lamy_children;
import app.wena.formulasaprende.Fisica_children.dinamica_children.vectores_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.biot_savart_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.campo_electrico_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.capacitor_paralelo_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.capacitor_serie_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.circuito_paralelo_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.circuito_serie_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.energia_campo_electrico_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.ley_coulomb_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.ley_ohm_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.movimiento_cargainterior_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.principio_superposicion_children;
import app.wena.formulasaprende.Fisica_children.electricidad_magnetimos_children.resistividad_electrica_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.caudal_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.densidad_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.numero_mach_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.numero_reynolds_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.presion_esfuerzo_childrne;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.principio_arquimedes_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.principio_pascal_children;
import app.wena.formulasaprende.Fisica_children.mecanica_fluidos_children.volumen_especifico_children;
import app.wena.formulasaprende.Fisica_children.optica_children.energia_fotonica_children;
import app.wena.formulasaprende.Fisica_children.optica_children.espectro_electromag_children;
import app.wena.formulasaprende.Fisica_children.optica_children.factor_magnificacion_children;
import app.wena.formulasaprende.Fisica_children.optica_children.indice_refraccion_children;
import app.wena.formulasaprende.Fisica_children.optica_children.interferencias_children;
import app.wena.formulasaprende.Fisica_children.optica_children.ley_reflexion_children;
import app.wena.formulasaprende.Fisica_children.optica_children.ley_snell_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.boyle_mariotte_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.calor_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.capacidad_calorifica_childrne;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.dilatacion_lineal_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.dilatacion_liquidos_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.dilatacion_superficial_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.dilatacion_volumetrica_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.ecuacion_estado_gases_ideales_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.maquina_termica_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.presiones_parciales_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.primer_principio_termodinamica_children;
import app.wena.formulasaprende.Fisica_children.termodinamica_children.procesos_termodinamicos_isotermico_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.matrizCuadrada_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.matrizDiagonal_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.matrizOrtogonal_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.matrizSimetrica_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.matrizTranspuesta_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.multiplicacion_matrices;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.reglaCramer_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.reglaSarrus_children;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.suma_matrices;
import app.wena.formulasaprende.Matematicas_children.AlgebraLineal_children.traza_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.binomioNewton_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.conjugadoComplejo_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.factorizacion_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.formulaGeneral_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.leyExponentes_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.leySignos_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.numerosComplejos_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.numerosReales_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.operacionesComplejos_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.productosnotables_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.sumatoria_children;
import app.wena.formulasaprende.Matematicas_children.Algebra_children.valorAbsoluto_children;
import app.wena.formulasaprende.Matematicas_children.Aritmetica_children.numeromixto_children;
import app.wena.formulasaprende.Matematicas_children.Aritmetica_children.potenciaFracciones_children;
import app.wena.formulasaprende.Matematicas_children.Aritmetica_children.reglaTres_children;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.EcuacionVariablesSeparadas;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.aplicacion_crecimiento_poblacional;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.aplicacion_mezclas;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.ecuacion_diferencial_bernoulli_children;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.ecuacion_diferencial_exacta;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.ecuacion_diferencial_lineal_children;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.ecuacion_diferencial_ricatti;
import app.wena.formulasaprende.Matematicas_children.EcuacionesDiferenciales.ecuacion_homogenea_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.circunferenciaCentroOrigen_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.circunferenciaFueraOrigen_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.distanciaDosPuntos_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.distanciaPuntorec_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.ecuacionGralConi_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.formaPuntoPendiente_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.hiperbola_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.modulo_vector_children;
import app.wena.formulasaprende.Matematicas_children.Geometria_children.puntoMedio_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.Mediana;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.desviacion_estandar;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.distribucionBinomial_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.esperanzaMatematica_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.laplace_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.modaDatosAgrupados_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.operacionesConjuntos_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.permutaciones_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.probabilidadCondicional_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.promedio_children;
import app.wena.formulasaprende.Matematicas_children.Probabilidad_children.varianza_children;
import app.wena.formulasaprende.Matematicas_children.Trigonometria_children.anguloOpuesto_children;
import app.wena.formulasaprende.Matematicas_children.Trigonometria_children.angulosComplementarios_children;
import app.wena.formulasaprende.Matematicas_children.Trigonometria_children.angulosSuplementarios_children;
import app.wena.formulasaprende.Matematicas_children.Trigonometria_children.clasificacionSegunAngulo_children;
import app.wena.formulasaprende.Matematicas_children.Trigonometria_children.razonesSumaDif_children;
import app.wena.formulasaprende.Matematicas_children.Trigonometria_children.relacionTrigonometria_children;
import app.wena.formulasaprende.Matematicas_children.Trigonometria_children.senoCosenoTan_children;
import app.wena.formulasaprende.Matematicas_children.Trigonometria_children.teoremaPitagoras_children;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.InteresSimple;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.Interes_compuesto;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.amortizacion;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.anualidad_simple;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.capitalizacion_compuesta;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.capitalizacion_simple;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.inflacion;
import app.wena.formulasaprende.Matematicas_children.matematicas_financieras.pib;
import app.wena.formulasaprende.Materias_Quimica.quimicaOrganica.Tipos_carbonos;
import app.wena.formulasaprende.Materias_Quimica.quimicaOrganica.alcano_alqueno_alquino;
import app.wena.formulasaprende.Materias_Quimica.quimicaOrganica.cadenaCarbonada_children;
import app.wena.formulasaprende.Materias_Quimica.quimicaOrganica.halogenos;
import app.wena.formulasaprende.Materias_Quimica.quimicaOrganica.hidrocarburo_aroman;
import app.wena.formulasaprende.Materias_Quimica.quimicaOrganica.hidrocarburos_cicli;
import app.wena.formulasaprende.Quimica_children.Estequiometria_children.disoluciones_children;
import app.wena.formulasaprende.Quimica_children.Estequiometria_children.numAvogadro_children;
import app.wena.formulasaprende.Quimica_children.Gases_children.gases_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.angulo_dos_vectores_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.cosenos_directores_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.integracion_partes;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.norma_vector_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.producto_escalar_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.producto_vectorial_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.q_plano_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.teorema_stokes_children;
import app.wena.formulasaprende.calculo_children.calculo_vectorial_children.vector_unitario_children;
import app.wena.formulasaprende.calculo_children.cambio_variable;
import app.wena.formulasaprende.calculo_children.derivada_children;
import app.wena.formulasaprende.calculo_children.derivada_funciones_childrne;
import app.wena.formulasaprende.calculo_children.derivada_hiperbolica_children;
import app.wena.formulasaprende.calculo_children.derivada_trigo_children;
import app.wena.formulasaprende.calculo_children.integrales_Log_children;
import app.wena.formulasaprende.calculo_children.integrales_children;
import app.wena.formulasaprende.calculo_children.integrales_fracciones_children;
import app.wena.formulasaprende.calculo_children.limite_producto_children;
import app.wena.formulasaprende.calculo_children.logaritmo_children;
import app.wena.formulasaprende.calculo_children.regla_basica_derivar;
import app.wena.formulasaprende.calculo_children.regla_basica_integrar;
import app.wena.formulasaprende.calculo_children.suma_producto_children;
import app.wena.formulasaprende.calculo_children.teorema_fundamental_children;

public class SeleccionarUser extends AppCompatActivity {
    TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_user);


        tvUser = findViewById(R.id.selectedUser);


        Intent intent = getIntent();


        if (intent.getExtras() != null) {
            UserModel userModel = (UserModel) intent.getSerializableExtra("data");

            tvUser.setText(userModel.getUserName());


            if (tvUser.getText().equals("Alcanos, Alquenos y Alquinos")) {
                startActivity(new Intent(SeleccionarUser.this, alcano_alqueno_alquino.class));
                finish();

            }
            else if (tvUser.getText().equals("Aplicacion - Crecimiento poblacional")) {
                startActivity(new Intent(SeleccionarUser.this, aplicacion_crecimiento_poblacional.class));
                finish();
            }
            else if (tvUser.getText().equals("Aplicacion - Mezclas")) {
                startActivity(new Intent(SeleccionarUser.this, aplicacion_mezclas.class));
                finish();
            }
            else if (tvUser.getText().equals("Permutaciones")) {
                startActivity(new Intent(SeleccionarUser.this, permutaciones_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Ecuacion diferencial separable")) {
                startActivity(new Intent(SeleccionarUser.this, EcuacionVariablesSeparadas.class));
                finish();
            }else if (tvUser.getText().equals("Interes simple")) {
                startActivity(new Intent(SeleccionarUser.this, InteresSimple.class));
                finish();
            }else if (tvUser.getText().equals("Interes compuesto")) {
                startActivity(new Intent(SeleccionarUser.this, Interes_compuesto.class));
                finish();
            }else if (tvUser.getText().equals("Capitalizacion simple")) {
                startActivity(new Intent(SeleccionarUser.this, capitalizacion_simple.class));
                finish();
            }else if (tvUser.getText().equals("Capitalizacion compuesta")) {
                startActivity(new Intent(SeleccionarUser.this, capitalizacion_compuesta.class));
                finish();
            }else if (tvUser.getText().equals("Anualidad simple")) {
                startActivity(new Intent(SeleccionarUser.this, anualidad_simple.class));
                finish();
            }
            else if (tvUser.getText().equals("Amortizacion")) {
                startActivity(new Intent(SeleccionarUser.this, amortizacion.class));
                finish();
            }
            else if (tvUser.getText().equals("Producto interno bruto")) {
                startActivity(new Intent(SeleccionarUser.this, pib.class));
                finish();
            }
            else if (tvUser.getText().equals("Tasa de inflacion")) {
                startActivity(new Intent(SeleccionarUser.this, inflacion.class));
                finish();
            }

            //CHANGE

            else if (tvUser.getText().equals("Ecuacion diferencial lineal")) {
                startActivity(new Intent(SeleccionarUser.this, ecuacion_diferencial_lineal_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Ecuacion diferencial homogenea")) {
                startActivity(new Intent(SeleccionarUser.this, ecuacion_homogenea_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Ecuacion diferencial exacta")) {
                startActivity(new Intent(SeleccionarUser.this, ecuacion_diferencial_exacta.class));
                finish();
            }
            else if (tvUser.getText().equals("Ecuacion diferencial tipo Bernoulli")) {
                startActivity(new Intent(SeleccionarUser.this, ecuacion_diferencial_bernoulli_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Ecuacion diferencial de Ricatti")) {
                startActivity(new Intent(SeleccionarUser.this, ecuacion_diferencial_ricatti.class));
                finish();
            }
            else if (tvUser.getText().equals("Angulo opuesto")) {
                startActivity(new Intent(SeleccionarUser.this, anguloOpuesto_children.class));
                finish();
            } else if (tvUser.getText().equals("Angulo complementario")) {
                startActivity(new Intent(SeleccionarUser.this, angulosComplementarios_children.class));
                finish();
            } else if (tvUser.getText().equals("Angulo suplementario")) {
                startActivity(new Intent(SeleccionarUser.this, angulosSuplementarios_children.class));
                finish();
            } else if (tvUser.getText().equals("Angulo suplementario")) {
                startActivity(new Intent(SeleccionarUser.this, angulo_dos_vectores_children.class));
                finish();
            } else if (tvUser.getText().equals("Binomio de Newton")) {
                startActivity(new Intent(SeleccionarUser.this, binomioNewton_children.class));
                finish();
            } else if (tvUser.getText().equals("Ley de Biot-Savart")) {
                startActivity(new Intent(SeleccionarUser.this, biot_savart_children.class));
                finish();
            } else if (tvUser.getText().equals("Ley de Boyle-Mariotte")) {
                startActivity(new Intent(SeleccionarUser.this, boyle_mariotte_children.class));
                finish();
            } else if (tvUser.getText().equals("Cadena Carbonada")) {
                startActivity(new Intent(SeleccionarUser.this, cadenaCarbonada_children.class));
                finish();
            } else if (tvUser.getText().equals("Caida Libre")) {
                startActivity(new Intent(SeleccionarUser.this, caida_libre_children.class));
                finish();
            } else if (tvUser.getText().equals("Calor")) {
                startActivity(new Intent(SeleccionarUser.this, calor_children.class));
                finish();
            } else if (tvUser.getText().equals("Cambio de Variable")) {
                startActivity(new Intent(SeleccionarUser.this, cambio_variable.class));
                finish();
            } else if (tvUser.getText().equals("Campo Electrico")) {
                startActivity(new Intent(SeleccionarUser.this, campo_electrico_children.class));
                finish();
            }
            //
            else if (tvUser.getText().equals("Capacidad Calorifica")) {
                startActivity(new Intent(SeleccionarUser.this, capacidad_calorifica_childrne.class));
                finish();
            } else if (tvUser.getText().equals("Capacitor en Paralelo")) {
                startActivity(new Intent(SeleccionarUser.this, capacitor_paralelo_children.class));
                finish();
            } else if (tvUser.getText().equals("Capacitor en Serie")) {
                startActivity(new Intent(SeleccionarUser.this, capacitor_serie_children.class));
                finish();
            } else if (tvUser.getText().equals("Caudal")) {
                startActivity(new Intent(SeleccionarUser.this, caudal_children.class));
                finish();
            }
            //
            else if (tvUser.getText().equals("Centro de Gravedad")) {
                startActivity(new Intent(SeleccionarUser.this, centro_gravedad_children.class));
                finish();
            } else if (tvUser.getText().equals("Circuito en Paralelo")) {
                startActivity(new Intent(SeleccionarUser.this, circuito_paralelo_children.class));
                finish();
            } else if (tvUser.getText().equals("Circuito en Serie")) {
                startActivity(new Intent(SeleccionarUser.this, circuito_serie_children.class));
                finish();
            }
            //
            else if (tvUser.getText().equals("Circunferencia con centro en el origen")) {
                startActivity(new Intent(SeleccionarUser.this, circunferenciaCentroOrigen_children.class));
                finish();
            }else if (tvUser.getText().equals("Circunferencia con centro fuera del origen")) {
                startActivity(new Intent(SeleccionarUser.this, circunferenciaFueraOrigen_children.class));
                finish();
            }else if (tvUser.getText().equals("Clasificación de Triangulos segun sus angulos")) {
                startActivity(new Intent(SeleccionarUser.this, clasificacionSegunAngulo_children.class));
                finish();
            }else if (tvUser.getText().equals("Conjugado de un numero complejo")) {
                startActivity(new Intent(SeleccionarUser.this, conjugadoComplejo_children.class));
                finish();
            }else if (tvUser.getText().equals("Cosenos directores")) {
                startActivity(new Intent(SeleccionarUser.this, cosenos_directores_children.class));
                finish();
            }
            //
            else if (tvUser.getText().equals("Densidad")) {
                startActivity(new Intent(SeleccionarUser.this, densidad_children.class));
                finish();
            }else if (tvUser.getText().equals("Derivadas")) {
                startActivity(new Intent(SeleccionarUser.this, derivada_children.class));
                finish();
            }else if (tvUser.getText().equals("Derivada de funciones exponenciales")) {
                startActivity(new Intent(SeleccionarUser.this, derivada_funciones_childrne.class));
                finish();
            }else if (tvUser.getText().equals("Derivada de funciones hiperbolicas")) {
                startActivity(new Intent(SeleccionarUser.this, derivada_hiperbolica_children.class));
                finish();
            }else if (tvUser.getText().equals("Derivada de funciones trigonometricas")) {
                startActivity(new Intent(SeleccionarUser.this, derivada_trigo_children.class));
                finish();
            }else if (tvUser.getText().equals("Descomposicion Rectangular")) {
                startActivity(new Intent(SeleccionarUser.this, descomposicion_regular_children.class));
                finish();
            }else if (tvUser.getText().equals("Desviacion Estandar")) {
                startActivity(new Intent(SeleccionarUser.this, desviacion_estandar.class));
                finish();
            }else if (tvUser.getText().equals("Dilatacion Lineal")) {
                startActivity(new Intent(SeleccionarUser.this, dilatacion_lineal_children.class));
                finish();
            }else if (tvUser.getText().equals("Dilatacion de Liquidos")) {
                startActivity(new Intent(SeleccionarUser.this, dilatacion_liquidos_children.class));
                finish();
            }
            //

            else if (tvUser.getText().equals("Dilatacion Superficial")) {
                startActivity(new Intent(SeleccionarUser.this, dilatacion_superficial_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Dilatacion Volumetrica")) {
                startActivity(new Intent(SeleccionarUser.this, dilatacion_volumetrica_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Disoluciones")) {
                startActivity(new Intent(SeleccionarUser.this, disoluciones_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Distancia entre dos puntos")) {
                startActivity(new Intent(SeleccionarUser.this, distanciaDosPuntos_children.class));
                finish();
            }else if (tvUser.getText().equals("Distancia de un punto a una recta")) {
                startActivity(new Intent(SeleccionarUser.this, distanciaPuntorec_children.class));
                finish();
            }else if (tvUser.getText().equals("Distribucion Binomial")) {
                startActivity(new Intent(SeleccionarUser.this, distribucionBinomial_children.class));
                finish();
            }else if (tvUser.getText().equals("Ecuacion de estado de los gases ideales")) {
                startActivity(new Intent(SeleccionarUser.this, ecuacion_estado_gases_ideales_children.class));
                finish();
            }else if (tvUser.getText().equals("Ecuacion general de las conicas")) {
                startActivity(new Intent(SeleccionarUser.this, ecuacionGralConi_children.class));
                finish();
            }else if (tvUser.getText().equals("Energia del campo electrico")) {
                startActivity(new Intent(SeleccionarUser.this, energia_campo_electrico_children.class));
                finish();
            }else if (tvUser.getText().equals("Energia Cinetica y Potencial")) {
                startActivity(new Intent(SeleccionarUser.this, energia_cinetica_potencial_children.class));
                finish();
            }else if (tvUser.getText().equals("Energia Fotonica")) {
                startActivity(new Intent(SeleccionarUser.this, energia_fotonica_children.class));
                finish();
            }
            //
            else if (tvUser.getText().equals("Espectro Electromagnetico")) {
                startActivity(new Intent(SeleccionarUser.this, espectro_electromag_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Esperanza Matematica")) {
                startActivity(new Intent(SeleccionarUser.this, esperanzaMatematica_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Factor de Magnificacion")) {
                startActivity(new Intent(SeleccionarUser.this, factor_magnificacion_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Formulas de Factorizacion")) {
                startActivity(new Intent(SeleccionarUser.this, factorizacion_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Forma Punto/Pendiente")) {
                startActivity(new Intent(SeleccionarUser.this, formaPuntoPendiente_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Formula General")) {
                startActivity(new Intent(SeleccionarUser.this, formulaGeneral_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Fuerza Centripeta")) {
                startActivity(new Intent(SeleccionarUser.this, fuerza_centripeta_children.class));
                finish();
            }
            //
            else if (tvUser.getText().equals("Trabajo,Energia y Potencia")) {
                startActivity(new Intent(SeleccionarUser.this, fuerza_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Ley de los Gases")) {
                startActivity(new Intent(SeleccionarUser.this, gases_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Halogenuros de Alquilo")) {
                startActivity(new Intent(SeleccionarUser.this, halogenos.class));
                finish();
            }
            else if (tvUser.getText().equals("Hidrocarburos Aromaticos")) {
                startActivity(new Intent(SeleccionarUser.this, hidrocarburo_aroman.class));
                finish();
            }
            else if (tvUser.getText().equals("Hidrocarburos Ciclicos")) {
                startActivity(new Intent(SeleccionarUser.this, hidrocarburos_cicli.class));
                finish();
            }
            else if (tvUser.getText().equals("Hiperbola")) {
                startActivity(new Intent(SeleccionarUser.this, hiperbola_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Indice de Refraccion")) {
                startActivity(new Intent(SeleccionarUser.this, indice_refraccion_children.class));
                finish();
            }
//
            else if (tvUser.getText().equals("Integracion por partes")) {
                startActivity(new Intent(SeleccionarUser.this, integracion_partes.class));
                finish();
            }

            else if (tvUser.getText().equals("Integrales de Funciones LOG y EXP")) {
                startActivity(new Intent(SeleccionarUser.this, integrales_Log_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Integrales")) {
                startActivity(new Intent(SeleccionarUser.this, integrales_children.class));
                finish();
            }
            //

            else if (tvUser.getText().equals("Integrales de Fracciones")) {
                startActivity(new Intent(SeleccionarUser.this, integrales_fracciones_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Interferencias")) {
                startActivity(new Intent(SeleccionarUser.this, interferencias_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Ley de Laplace")) {
                startActivity(new Intent(SeleccionarUser.this, laplace_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Ley de Coulomb | Fuerza Electrica")) {
                startActivity(new Intent(SeleccionarUser.this, ley_coulomb_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Ley de los Exponentes")) {
                startActivity(new Intent(SeleccionarUser.this, leyExponentes_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Ley de la Gravitacion Universal")) {
                startActivity(new Intent(SeleccionarUser.this, ley_gravitacion_universal_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Ley de Hooke")) {
                startActivity(new Intent(SeleccionarUser.this, ley_hooke_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Ley de Ohm")) {
                startActivity(new Intent(SeleccionarUser.this, ley_ohm_children.class));
                finish();
            }

            //
            else if (tvUser.getText().equals("Leyes de Newton")) {
                startActivity(new Intent(SeleccionarUser.this, leyes_newton_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Ley de Reflexion")) {
                startActivity(new Intent(SeleccionarUser.this, ley_reflexion_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Ley de Signos")) {
                startActivity(new Intent(SeleccionarUser.this, leySignos_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Ley de Snell o de Refraccion")) {
                startActivity(new Intent(SeleccionarUser.this, ley_snell_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Limites")) {
                startActivity(new Intent(SeleccionarUser.this, limite_producto_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Logaritmos")) {
                startActivity(new Intent(SeleccionarUser.this, logaritmo_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Maquinas Termicas")) {
                startActivity(new Intent(SeleccionarUser.this, maquina_termica_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Matriz Cuadrada")) {
                startActivity(new Intent(SeleccionarUser.this, matrizCuadrada_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Matriz Diagonal y Escalar")) {
                startActivity(new Intent(SeleccionarUser.this, matrizDiagonal_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Matriz Ortogonal")) {
                startActivity(new Intent(SeleccionarUser.this, matrizOrtogonal_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Matriz Simetrica y Antisimetrica")) {
                startActivity(new Intent(SeleccionarUser.this, matrizSimetrica_children.class));
                finish();
            }

            //
            else if (tvUser.getText().equals("Matriz Transpuesta")) {
                startActivity(new Intent(SeleccionarUser.this, matrizTranspuesta_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Mediana")) {
                startActivity(new Intent(SeleccionarUser.this, Mediana.class));
                finish();
            }
            else if (tvUser.getText().equals("Moda")) {
                startActivity(new Intent(SeleccionarUser.this, modaDatosAgrupados_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Modulo de un Vector")) {
                startActivity(new Intent(SeleccionarUser.this, modulo_vector_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Movimiento de Cargas en el Interior de un Campo Electrico")) {
                startActivity(new Intent(SeleccionarUser.this, movimiento_cargainterior_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Movimiento Circular Uniforme")) {
                startActivity(new Intent(SeleccionarUser.this, movimiento_circular_uniforme_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Movimiento Horizontal de Proyectiles")) {
                startActivity(new Intent(SeleccionarUser.this, movimiento_horizontal_proyectiles_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Movimiento Parabolico")) {
                startActivity(new Intent(SeleccionarUser.this, movimiento_parabolico_children.class));
                finish();
            }
            //
            else if (tvUser.getText().equals("Movimiento de Proyectiles en Angulo")) {
                startActivity(new Intent(SeleccionarUser.this, movimiento_proyectiles_angulo_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Movimiento Rectilineo Uniforme")) {
                startActivity(new Intent(SeleccionarUser.this, movimiento_rectilineo_uniforme_children.class));
                finish();
            } else if (tvUser.getText().equals("Movimiento Vertical de Proyectiles")) {
                startActivity(new Intent(SeleccionarUser.this, movimiento_vertical_proyectiles_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Multiplicacion de Matrices")) {
                startActivity(new Intent(SeleccionarUser.this, multiplicacion_matrices.class));
                finish();
            }
            else if (tvUser.getText().equals("Norma de un Vector")) {
                startActivity(new Intent(SeleccionarUser.this, norma_vector_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Numero de Avogadro")) {
                startActivity(new Intent(SeleccionarUser.this, numAvogadro_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Numero Mach")) {
                startActivity(new Intent(SeleccionarUser.this, numero_mach_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Numero de Reynolds")) {
                startActivity(new Intent(SeleccionarUser.this, numero_reynolds_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Numero Mixto")) {
                startActivity(new Intent(SeleccionarUser.this, numeromixto_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Numeros Complejos")) {
                startActivity(new Intent(SeleccionarUser.this, numerosComplejos_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Numeros Reales")) {
                startActivity(new Intent(SeleccionarUser.this, numerosReales_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Operaciones con Numeros Complejos")) {
                startActivity(new Intent(SeleccionarUser.this, operacionesComplejos_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Operaciones con Conjuntos")) {
                startActivity(new Intent(SeleccionarUser.this, operacionesConjuntos_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Potencia de Fracciones")) {
                startActivity(new Intent(SeleccionarUser.this, potenciaFracciones_children.class));
                finish();
            }
            //

            else if (tvUser.getText().equals("Presion y Esfuerzos")) {
                startActivity(new Intent(SeleccionarUser.this, presion_esfuerzo_childrne.class));
                finish();
            }
            else if (tvUser.getText().equals("Ley de Presiones Parciales o de Dalton")) {
                startActivity(new Intent(SeleccionarUser.this, presiones_parciales_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Primer Principio de la Termodinamica")) {
                startActivity(new Intent(SeleccionarUser.this, primer_principio_termodinamica_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Principio de Arquimedes")) {
                startActivity(new Intent(SeleccionarUser.this, principio_arquimedes_children.class));
                finish();
            } else if (tvUser.getText().equals("Principio de Bernoulli")) {
                startActivity(new Intent(SeleccionarUser.this, principio_bernoulli_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Principio de Pascal")) {
                startActivity(new Intent(SeleccionarUser.this, principio_pascal_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Principio de Superposicion")) {
                startActivity(new Intent(SeleccionarUser.this, principio_superposicion_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Probabilidad Condicional")) {
                startActivity(new Intent(SeleccionarUser.this, probabilidadCondicional_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Procesos Termodinamicos e Isotermicos")) {
                startActivity(new Intent(SeleccionarUser.this, procesos_termodinamicos_isotermico_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Producto Punto o Producto Escalar")) {
                startActivity(new Intent(SeleccionarUser.this, producto_escalar_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Producto Cruz o Producto Vectorial")) {
                startActivity(new Intent(SeleccionarUser.this, producto_vectorial_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Productos Notables")) {
                startActivity(new Intent(SeleccionarUser.this, productosnotables_children.class));
                finish();
            }
            //

            else if (tvUser.getText().equals("Media aritmetica o Promedio")) {
                startActivity(new Intent(SeleccionarUser.this, promedio_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Punto medio de la Recta")) {
                startActivity(new Intent(SeleccionarUser.this, puntoMedio_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Distancia de un punto Q a un Plano")) {
                startActivity(new Intent(SeleccionarUser.this, q_plano_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Razones del angulo suma / diferencia")) {
                startActivity(new Intent(SeleccionarUser.this, razonesSumaDif_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Regla para Derivar")) {
                startActivity(new Intent(SeleccionarUser.this, regla_basica_derivar.class));
                finish();
            }
            else if (tvUser.getText().equals("Regla para Integrar")) {
                startActivity(new Intent(SeleccionarUser.this, regla_basica_integrar.class));
                finish();
            }
            else if (tvUser.getText().equals("Regla de Cramer")) {
                startActivity(new Intent(SeleccionarUser.this, reglaCramer_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Regla de Sarrus")) {
                startActivity(new Intent(SeleccionarUser.this, reglaSarrus_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Regla de tres directa")) {
                startActivity(new Intent(SeleccionarUser.this, reglaTres_children.class));
                finish();
            }

            //
            else if (tvUser.getText().equals("Relaciones de la Trigonometria")) {
                startActivity(new Intent(SeleccionarUser.this, relacionTrigonometria_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Resistividad Electrica")) {
                startActivity(new Intent(SeleccionarUser.this, resistividad_electrica_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Razones Trigonometricas")) {
                startActivity(new Intent(SeleccionarUser.this, senoCosenoTan_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Suma y Resta de Matrices")) {
                startActivity(new Intent(SeleccionarUser.this, suma_matrices.class));
                finish();
            }

            else if (tvUser.getText().equals("Suma y Productos")) {
                startActivity(new Intent(SeleccionarUser.this, suma_producto_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Sumatoria")) {
                startActivity(new Intent(SeleccionarUser.this, sumatoria_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Teorema Fundamental del Calculo")) {
                startActivity(new Intent(SeleccionarUser.this, teorema_fundamental_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Teorema de Lamy")) {
                startActivity(new Intent(SeleccionarUser.this, teorema_lamy_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Teorema de Pitagoras")) {
                startActivity(new Intent(SeleccionarUser.this, teoremaPitagoras_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Teorema de Stokes")) {
                startActivity(new Intent(SeleccionarUser.this, teorema_stokes_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Clasificacion de Atomos de Carbono")) {
                startActivity(new Intent(SeleccionarUser.this, Tipos_carbonos.class));
                finish();
            }


            else if (tvUser.getText().equals("Traza de una Matriz")) {
                startActivity(new Intent(SeleccionarUser.this, traza_children.class));
                finish();
            }

            else if (tvUser.getText().equals("Valor Absoluto")) {
                startActivity(new Intent(SeleccionarUser.this, valorAbsoluto_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Varianza")) {
                startActivity(new Intent(SeleccionarUser.this, varianza_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Vector Unitario")) {
                startActivity(new Intent(SeleccionarUser.this, vector_unitario_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Vectores")) {
                startActivity(new Intent(SeleccionarUser.this, vectores_children.class));
                finish();
            }
            else if (tvUser.getText().equals("Volumen Especifico")) {
                startActivity(new Intent(SeleccionarUser.this, volumen_especifico_children.class));
                finish();
            }
        }



    }
}
