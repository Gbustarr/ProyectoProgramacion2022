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
public class FuncionesAuxiliares {
    
    protected void moverPivotDerecha(Logica l,Simbolo s){
        
        if(s.getValor() > 13 && s.getValor() <17){ //seno coseno tangente
            l.pivot_x = l.pivot_x + (l.espacioEntreSimbolos*3);
            l.d.listaMovimientosHaciaDerecha.set(l.d.listaMovimientosHaciaDerecha.size()-1, 
            l.d.listaMovimientosHaciaDerecha.get(l.d.listaMovimientosHaciaDerecha.size()-1) + 3);
            l.d.movimientosDerecha = l.d.movimientosDerecha + 3;
        }else{
            l.pivot_x = l.pivot_x + l.espacioEntreSimbolos;
            l.d.listaMovimientosHaciaDerecha.set(l.d.listaMovimientosHaciaDerecha.size()-1, 
            l.d.listaMovimientosHaciaDerecha.get(l.d.listaMovimientosHaciaDerecha.size()-1) + 1);
            l.d.movimientosDerecha = l.d.movimientosDerecha + 1;
        }
    }
    
    protected void moverPivotDerechaPotencia(Logica l){
        l.pivot_x = l.pivot_x + (l.espacioEntreSimbolos/2);
            l.d.listaMovimientosHaciaDerecha.set(l.d.listaMovimientosHaciaDerecha.size()-1, 
                l.d.listaMovimientosHaciaDerecha.get(l.d.listaMovimientosHaciaDerecha.size()-1) + 0.5);
        
    
    }
    
    protected void alturaEnPotencia(Logica l){
        if(l.enPotencia){
            l.pivot_y = l.ultimoParentesisCerrado.forma[1]+40;
        }else{
            l.pivot_y = l.ultimoParentesisCerrado.Ypos;
        }
        
    }
    
    protected void moverPivotArriba(Logica l,double distancia){
        
        l.pivot_y = l.pivot_y -distancia;
    }
    
    protected void moverPivotAbajo(Logica l,double distancia){
        
        l.pivot_y = l.pivot_y +distancia;
    }
    
    protected void moverPivotADenominador(Logica l){
        Simbolo ultimoParentesis = l.context.lista_simbolos.get(l.context.lista_simbolos.size()-1);
        //Utiliza la ultima cantidad de movimientos a la derecha almacenado en la lista
        l.pivot_x = ultimoParentesis.enlace.forma[8] - 8;
    }
    
    
    protected void moverPivotIzquierda(Logica l, double distancia){
        l.pivot_x = l.pivot_x - distancia;
    }
    
    protected Simbolo conseguirUltimoSimbolo(ArrayList<Simbolo> lista_simbolos){
        
        if(!lista_simbolos.isEmpty()){
            return lista_simbolos.get(lista_simbolos.size()-1);
        }else{
            return null;
        }
    }
    
}
