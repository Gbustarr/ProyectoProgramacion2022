/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author Guillermo
 */
public class division {

    ArrayList<Simbolo> Numeradores = new ArrayList();

    FuncionesAuxiliares fa = new FuncionesAuxiliares();
    ArrayList<Double> listaMovimientosHaciaDerecha = new ArrayList();
    double anchoAnterior = 0;
    double movimientosDerechaAnterior = 0;
    double movimientosDerecha = 0;
    double diferenciaLineaDivision = 0;
    double coordenadaXParentesisdeCierre;
    double coordenadaUltimoSimboloNumerador;
    Simbolo parentesisDeDivisionActivo;
    Simbolo lineaDivisionActiva;
    boolean modLineaDivision = true;


    protected void nuevaDivision(Logica l) {
        movimientosDerechaAnterior = movimientosDerecha;
        movimientosDerecha = 0;
        conseguirNumeradores(l);
        if (l.enPotencia) {
            moverNumeradoresHaciaArriba(1);
            fa.moverPivotADenominador(l);
            //fa.moverPivotDerechaPotencia(l);
            //fa.moverPivotDerechaPotencia(l);

        } else {
            moverNumeradoresHaciaArriba(2);
            fa.moverPivotADenominador(l);
        }
    }


    protected void crearLineaDivision(Logica l, Simbolo s) {
        if (!l.ParentesisAbiertos.isEmpty()) { //Si hay parentesis de apertura
            if (l.enPotencia) {
                s.forma[0] = l.pivot_x - 5;
            } else {
                s.forma[0] = l.pivot_x;
            }

        } else {
            s.forma[0] = l.context.lista_simbolos.get(0).Xpos - l.espacioEntreSimbolos;

        }
        //Consigue el segundo punto de la linea de la division el cual es un punto x del ultimo simbolo del numerador
        if (l.enPotencia) {
            s.forma[2] = coordenadaUltimoSimboloNumerador - 5; //punto derecho de la division
        } else {
            s.forma[2] = coordenadaUltimoSimboloNumerador; //punto derecho de la division
        }
        if (l.enPotencia) {
            s.moverArriba(0.8); //Linea de division sube para posicionarse por debajo de los numeradores
        } else {
            s.moverArriba(1); //Linea de division sube para posicionarse por debajo de los numeradores
        }
        lineaDivisionActiva = s;
    }

    protected void moverNumeradoresHaciaArriba(double pos) {

        for (int i = 0; i < Numeradores.size(); i++) {
            Numeradores.get(i).moverArriba(pos);
        }
    }


    public division() {
        listaMovimientosHaciaDerecha.add((double) 0);
    }

    protected void borrarSimbolosDeNumeradoresParaPotencia(Logica l) {
        int contador = 0;

        //Recorre la lista de simbolos desde el final hacia el principio
        for (int i = l.context.lista_simbolos.size() - 1; i >= 0; i--) {
            if (l.context.lista_simbolos.get(i).valor == 18) {//encuentra un parentesis de cierre
                contador++;

            } else if (l.context.lista_simbolos.get(i).valor == 17) { //encuentra un parentesis de apertura
                contador--;
            }

            if (contador == 0) {
                break;
            } else {
                if (Numeradores.contains(l.context.lista_simbolos.get(i))) {
                    //l.context.lista_simbolos.get(i).color = Color.BLACK; // Para marcar los numeradores
                    Numeradores.remove(l.context.lista_simbolos.get(i));

                }

            }

        }

    }


    protected void conseguirNumeradores(Logica l) {
        int contador = 0;
        int movimientosDer = 0;


        coordenadaUltimoSimboloNumerador = l.context.lista_simbolos.get(l.context.lista_simbolos.size() - 1).Xpos;

        //Recorre la lista de simbolos desde el final hacia el principio
        for (int i = l.context.lista_simbolos.size() - 1; i >= 0; i--) {
            if (l.context.lista_simbolos.get(i).valor == 18) {//encuentra un parentesis de cierre
                contador++;

            } else if (l.context.lista_simbolos.get(i).valor == 17) { //encuentra un parentesis de apertura
                contador--;
            }

            if (contador == -1) {
                if (parentesisDeDivisionActivo != null) {
                    //parentesisDeDivisionActivo.color = Color.GOLD;
                }
                parentesisDeDivisionActivo = l.context.lista_simbolos.get(i);
                //parentesisDeDivisionActivo.color = Color.AQUA;
                break;
            } else {
                if (!Numeradores.contains(l.context.lista_simbolos.get(i))) {
                    //l.context.lista_simbolos.get(i).color = Color.rgb(128, 0, 128); // Para marcar los numeradores
                    Numeradores.add(l.context.lista_simbolos.get(i));
                    movimientosDer++;
                }

            }

        }

        movimientosDerecha = movimientosDer;

        //System.out.println("MovDer: " + movimientosDerecha);
    }



    protected void centrarNumeradores(Logica l) {
        //Agregue el + l.espacioEntreSimbolos ya que el pivot se mueve al final de ingresar un numero
        // por lo tanto para subsanar agregue un espacio adiciona a la coordenada que se está comparando 
        // para que al momento de hacer el corrimiento de los numeradores, estos quedaran justo en el medio
        if (l.pivot_x > coordenadaUltimoSimboloNumerador && l.context.lista_simbolos.get(l.context.lista_simbolos.size() - 1).valor != 18) {
            if (l.enDivision) {
                //System.out.println("Moviendo numeradores");
                for (int i = 0; i < Numeradores.size(); i++) {
                    Numeradores.get(i).moverDerecha(0.5);
                }
                if (modLineaDivision) {
                    if (!l.ParentesisAbiertos.isEmpty()) {
                        
                        if(parentesisDeDivisionActivo != null){
                            lineaDivisionActiva.setDimensionLineaDivision(
                            parentesisDeDivisionActivo.Xpos, l.pivot_x);
                        }else{
                            lineaDivisionActiva.setDimensionLineaDivision(
                             l.context.lista_simbolos.get(0).Xpos - l.espacioEntreSimbolos, l.pivot_x);
                        }
                        
                    } else {
                        lineaDivisionActiva.setDimensionLineaDivision(
                            l.context.lista_simbolos.get(0).Xpos - l.espacioEntreSimbolos, l.pivot_x);
                    }
                }
            }
        }

    }



    

}
