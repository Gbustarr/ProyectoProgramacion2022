/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author oknmi
 */
public class FuncionesGraficadoras {
    
    int espacio = 15;
    
    public void dibujar_todos_los_simbolos(double pivot,GraphicsContext gc,ArrayList<Simbolo> lista_simbolos){
        double espacio_total = espacio*lista_simbolos.size();
        
        for(int i = 0; i< lista_simbolos.size();i++){
                Simbolo s = lista_simbolos.get(i);
                s.dibujar_Simbolo(gc,espacio_total);
                espacio_total = espacio_total - espacio;
                System.out.println(s.getXpos());
            }
    
    }
    
    
}
