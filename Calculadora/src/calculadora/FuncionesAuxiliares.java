/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author Guillermo
 */
public class FuncionesAuxiliares {
    
    protected void moverPivot(Logica l,Simbolo s){
        
        if(s.getValor() > 13 && s.getValor() <17){
            l.pivot_x = l.pivot_x + (l.espacioEntreSimbolos*3);
        }else{
            l.pivot_x = l.pivot_x + l.espacioEntreSimbolos;
        }
    }
    
}
