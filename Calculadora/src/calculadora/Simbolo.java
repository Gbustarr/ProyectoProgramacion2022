/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import javafx.scene.canvas.GraphicsContext;


/**
 *
 * @author Guillermo
 */
public class Simbolo {
    
    double factor; //Tamaño
    double Xpos;
    double Ypos;
    double[] forma;

    public Simbolo(float factor, double Xpos, double Ypos, double[] forma) {
        this.factor = factor;
        this.Xpos = Xpos;
        this.Ypos = Ypos;
        this.forma = forma;
    }
    
    protected void dibujar_Simbolo(GraphicsContext gc){
        for(int i = 0;i<this.forma.length;i=i+4){
            
            gc.strokeLine(this.forma[i]*factor, this.forma[i+1]*factor, 
                this.forma[i+2]*factor, this.forma[i+3]*factor);
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
        this.Xpos = Xpos;
    }

    public double getYpos() {
        return Ypos;
    }

    public void setYpos(double Ypos) {
        this.Ypos = Ypos;
    }

    
    
    
    protected void Simbolo_uno(){
        System.out.println("1 presionado");
    };
    
    protected void Simbolo_dos(){
    
    };
    protected void Simbolo_tres(){
    
    };
    protected void Simbolo_cuatro(){
    
    };
    
}
