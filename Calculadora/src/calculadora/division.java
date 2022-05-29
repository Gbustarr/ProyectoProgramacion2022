/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;
/**
 *
 * @author Guillermo
 */
public class division {

    int altura;
    ArrayList<Simbolo> Numeradores = new ArrayList();
    ArrayList<Simbolo> Denominadores = new ArrayList();
    ArrayList<Simbolo> Bloque = new ArrayList();
    ArrayList<Simbolo> lineasDivision = new ArrayList();

    ArrayList<Integer> anchosDivision = new ArrayList();
    FuncionesAuxiliares fa = new FuncionesAuxiliares();

    boolean enDenominador = false;

    int nivelBajadaFraccion = 0;

    ArrayList<Double> listaMovimientosHaciaDerecha = new ArrayList();
    double anchoAnterior = 0;

    ArrayList<Double> nivelYPivot = new ArrayList();
    
    double movimientosDerechaAnterior = 0;
    double movimientosDerecha =0;
    
    double diferenciaLineaDivision = 0;

    int contadorDeBajadas = 0;

    protected void nuevaDivision(Logica l) {
        movimientosDerechaAnterior = movimientosDerecha;
        movimientosDerecha = 0;
        conseguirNumeradores(l);
        if(l.enPotencia){
            moverNumeradoresHaciaArriba(1);
            fa.moverPivotADenominador(l);
            fa.moverPivotDerechaPotencia(l);
            fa.moverPivotDerechaPotencia(l);

        
        }else{
            moverNumeradoresHaciaArriba(2);
            fa.moverPivotADenominador(l);

        }
        
    }
    
    protected void crearLineaDivision(Logica l,Simbolo s){
        s.forma[0] = l.context.lista_simbolos.get(l.context.lista_simbolos.size()-1).enlace.forma[8];
        s.forma[2] = l.context.lista_simbolos.get(l.context.lista_simbolos.size()-1).forma[8];
        s.moverArriba(1);
    }

    protected void moverNumeradoresHaciaArriba(double pos) {

        for (int i = 0; i < Numeradores.size(); i++) {
            Numeradores.get(i).moverArriba(pos);
        }
    }

    protected void guardarNivelPivot(Logica l) {
        nivelYPivot.add(l.pivot_y);
    }

    public division() {
        listaMovimientosHaciaDerecha.add((double) 0);
    }

    protected void conseguirNumeradores(Logica l) {
        int contador = 0;
        int movimientosDer = 0;
        

        for (int i = l.context.lista_simbolos.size() - 1; i >= 0; i--) {
            if (l.context.lista_simbolos.get(i).valor == 18) {
                contador++;

            } else if (l.context.lista_simbolos.get(i).valor == 17) {
                contador--;
            }
            if(!Numeradores.contains(l.context.lista_simbolos.get(i))){
                Numeradores.add(l.context.lista_simbolos.get(i));
                movimientosDer++;
            }
            
            if (contador == 0) {
                break;
            }
            
        }
        
        movimientosDerecha = movimientosDer;
        
        if(movimientosDerecha > movimientosDerechaAnterior){
            modificarLineaDivision(l);
        }
         
        System.out.println("MovDer: "+movimientosDerecha);

    }

    protected void dimensionarParentesisAbiertosHaciaAbajo(Logica l, int max, int subida) {
        for (int i = 0; i < max; i++) {
            l.ParentesisAbiertos.get(i).moverArriba(subida);
            l.ParentesisAbiertos.get(i).dimensionarParentesisHaciaAbajo(1);
        }
    }

    protected void verificarTamanoNumeradorDenominador(Logica l) {

        double diferencia;
        diferencia = (l.movimientosDeLista - 2) - l.Denominadores.size();

        if (diferencia >= 0) {
            l.denominadorMenor = true;
            l.diferenciaNumeradorDenominador = diferencia;
        } else {
            l.denominadorMenor = false;
        }

    }

    protected void modificarLineaDivision(Logica l) {

        if (l.enDivision) {
            if (!l.ParentesisAbiertos.isEmpty()) {
                if (anchoAnterior > (listaMovimientosHaciaDerecha.get(listaMovimientosHaciaDerecha.size() - 1))) {
                    double fin = l.divisor.forma[0] + (anchoAnterior * (l.espacioEntreSimbolos));
                    l.divisor.divisionFinal(fin);
                } else {
                    double fin = l.divisor.forma[0] + ((listaMovimientosHaciaDerecha.get(listaMovimientosHaciaDerecha.size() - 1) - 1) * (l.espacioEntreSimbolos));
                    l.divisor.divisionFinal(fin);
                }
            }
        } else {
            //double fin = l.divisor.forma[0] + ((listaMovimientosHaciaDerecha.get(listaMovimientosHaciaDerecha.size()-1)) * (l.espacioEntreSimbolos));
            //l.divisor.divisionFinal(fin);
        }

    }
;

}
