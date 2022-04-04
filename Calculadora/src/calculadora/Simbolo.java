/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 *
 * @author Guillermo
 */
public class Simbolo {
    
    double factor; //Tamaño
    double Xpos;
    double Ypos;
    double[] forma;
    // Agregar Color

    public Simbolo(float factor, double Xpos, double Ypos, double[] forma) {
        this.factor = factor;
        this.Xpos = Xpos;
        this.Ypos = Ypos;
        this.forma = forma;
    }
    
    public Simbolo(){
    }
   //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/canvas/GraphicsContext.html
    protected void dibujar_Simbolo(GraphicsContext gc,double desplazarXpos){
        for(int i = 0;i<this.forma.length;i=i+4){
            gc.setStroke(Color.RED);
            gc.strokeLine((this.forma[i]-desplazarXpos)*factor, this.forma[i+1]*factor, 
                (this.forma[i+2]-desplazarXpos)*factor, this.forma[i+3]*factor);
            System.out.println("Simbolo Dibujado en ("+this.Xpos+","+this.Ypos+")");
        }
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public double getXpos() {
        return Xpos;
    }

    public void setXpos(double Xpos) {
        this.Xpos = this.Xpos - Xpos;
    }

    public double getYpos() {
        return Ypos;
    }

    public void setYpos(double Ypos) {
        this.Ypos = Ypos;
    }
    
    public void setForma(double[] forma){
        this.forma = forma;
    }

    
}
