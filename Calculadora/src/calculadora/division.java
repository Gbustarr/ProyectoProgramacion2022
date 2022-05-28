/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Guillermo
 */
public class division {

    int altura;
    ArrayList<Simbolo> Numeradores = new ArrayList();
    ArrayList<Simbolo> Denominadores = new ArrayList();
    ArrayList<Simbolo> Bloque = new ArrayList();
    ArrayList<Integer> anchosDivision = new ArrayList();
    FuncionesAuxiliares fa = new FuncionesAuxiliares();
    
    ArrayList<Integer> listaMovimientosHaciaDerecha = new ArrayList();
    

    protected void nuevaDivision(Logica l, ArrayList<Simbolo> lista_simbolos, Simbolo s, GraphicsContext gc) {
        
        l.fa.moverPivotArriba(l,22);
        
    }
    
    public division(){
        listaMovimientosHaciaDerecha.add(0);
    }
    protected ArrayList<Simbolo> conseguirNumeradores(ArrayList<Simbolo> lista_simbolos){
        int contador = 0;
        ArrayList<Simbolo> numeradores = new ArrayList();
        
        for(int i = lista_simbolos.size()-1;i >= 0; i++){
            if(lista_simbolos.get(i).valor == 18){
                contador++;
                
            }else if (lista_simbolos.get(i).valor == 17){
                contador--;
            }
            
            numeradores.add(lista_simbolos.get(i));
            
            if(contador == 0){
                break;
            }
        }
        return numeradores;
            
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

    protected void modificarLineaDivision(Logica l, double pivot_x) {
        double inicio = pivot_x - ((l.movimientosDeLista - 1) * (l.espacioEntreSimbolos + 15));
        l.divisor.division(inicio, pivot_x);

    }
;

}
