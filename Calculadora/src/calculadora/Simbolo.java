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
    
    double Xfactor = 1; //Tamaño
    double Yfactor = 1;
    double Xpos;
    double Ypos;
    double[] forma;
    int id;
    Color color = Color.GREEN;
    // Agregar Color

    public Simbolo(double Xpos, double Ypos, double[] forma) {
        this.Xpos = Xpos;
        this.Ypos = Ypos;
        this.forma = forma;
    }
    
    public Simbolo(){
    }
   //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/canvas/GraphicsContext.html
    protected void dibujar_Simbolo(GraphicsContext gc,double desplazarXpos){
        for(int i = 0;i<this.forma.length;i=i+4){
            gc.setStroke(this.color);
            gc.strokeLine((this.forma[i]-desplazarXpos)*Xfactor, this.forma[i+1]*Yfactor, 
                (this.forma[i+2]-desplazarXpos)*Xfactor, this.forma[i+3]*Yfactor);
        }
    }

    public double getXFactor() {
        return Xfactor;
    }
    
    public double getYFactor() {
        return Yfactor;
    }

    public void setXFactor(double factor) {
        this.Xfactor = factor;
    }
    public void setYFactor(double factor) {
        this.Yfactor = factor;
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
    
    public void setId(int id){
        this.id = id;
    }

    public void setColor(Color color){
        this.color = color;
    }
    
}
