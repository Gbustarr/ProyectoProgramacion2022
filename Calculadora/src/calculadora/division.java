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

    ArrayList<Simbolo> Numeradores = new ArrayList();
    FuncionesAuxiliares fa = new FuncionesAuxiliares();
    ArrayList<Double> listaMovimientosHaciaDerecha = new ArrayList();
    double anchoAnterior = 0;
    double movimientosDerechaAnterior = 0;
    double movimientosDerecha =0;
    double diferenciaLineaDivision = 0;

    protected void nuevaDivision(Logica l) {
        movimientosDerechaAnterior = movimientosDerecha;
        movimientosDerecha = 0;
        conseguirNumeradores(l);
        if(l.enPotencia){
            moverNumeradoresHaciaArriba(1);
            fa.moverPivotADenominador(l);
            fa.moverPivotDerechaPotencia(l);
            //fa.moverPivotDerechaPotencia(l);

        
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

    public division() {
        listaMovimientosHaciaDerecha.add((double) 0);
    }

    protected void conseguirNumeradores(Logica l) {
        int contador = 0;
        int movimientosDer = 0;
        
        if(!l.enDivision){
            l.alturaAntesDeDivision = l.context.lista_simbolos.get(l.context.lista_simbolos.size()-1);
        }
        

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
        

         
        System.out.println("MovDer: "+movimientosDerecha);

    }

}
