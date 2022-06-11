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
                l.d.listaMovimientosHaciaDerecha.get(l.d.listaMovimientosHaciaDerecha.size()-1) + 0.7);
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
        
        if(!l.ParentesisAbiertos.isEmpty()){
            l.pivot_x = l.ParentesisAbiertos.get(l.ParentesisAbiertos.size()-1).Xpos;
        }else{
            l.pivot_x = l.context.lista_simbolos.get(0).Xpos-l.espacioEntreSimbolos;
        }
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
    
    protected int buscarNumero(ArrayList<Simbolo> lista_simbolos,int index){
        String numero = "";
        for(int i = index;i < lista_simbolos.size(); i++){
            if(lista_simbolos.get(i).tipo != 0){
                break;
            }else{
                numero = numero + lista_simbolos.get(i).getValorString();
            }
        }
        return Integer.parseInt(numero);
    
    } 

    
    protected void posicionarParentesisDeCierre(Logica l, Simbolo s) {
        int contador = 1;
        double coordenadaXmasLejana = l.pivot_x;
        
        for(int i = l.context.lista_simbolos.size()-1; i >= 0; i--){
            if(l.context.lista_simbolos.get(i).valor == 18){
                contador++;
            }
            if(l.context.lista_simbolos.get(i).valor == 17){
                contador--;
            }
            if(contador == 0){
                break;
            }else{
                if(l.context.lista_simbolos.get(i).Xpos > coordenadaXmasLejana){
                    coordenadaXmasLejana = l.context.lista_simbolos.get(i).Xpos;
                }
            }
            
        }
        
        s.Xpos = coordenadaXmasLejana;
        l.pivot_x = coordenadaXmasLejana;
        
    }
    
}
