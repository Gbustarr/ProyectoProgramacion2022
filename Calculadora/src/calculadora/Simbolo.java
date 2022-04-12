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
    Color color = Color.GREEN;
    int tipo; //0 = numero, 1= operador
    int valor;


    public Simbolo(double Xpos, double Ypos, double[] forma) {
        this.Xpos = Xpos;
        this.Ypos = Ypos;
        this.forma = forma;
    }
    
    public Simbolo(){
    }
   //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/canvas/GraphicsContext.html
    protected void dibujar_Simbolo(GraphicsContext gc,double desplazarXpos){
        
        System.out.println("Simbolo: " +this.valor);
        for(int i = 0;i<this.forma.length;i=i+4){
            gc.setStroke(this.color);
            gc.strokeLine((this.forma[i]-desplazarXpos)*Xfactor, this.forma[i+1]*Yfactor, 
                (this.forma[i+2]-desplazarXpos)*Xfactor, this.forma[i+3]*Yfactor);
            
            //Puntos de control
            gc.fillOval(((this.forma[i]-desplazarXpos)*Xfactor), (this.forma[i+1]*Yfactor), 1, 1);
            gc.fillOval(((this.forma[i+2]-desplazarXpos)*Xfactor), (this.forma[i+3]*Yfactor), 1, 1);
            
            
            System.out.print("(X1= "+(this.forma[i]-desplazarXpos)*Xfactor);
            System.out.print(" Y1= "+(this.forma[i+1]*Yfactor)+") ");
            System.out.print("(X2= "+(this.forma[i+2]-desplazarXpos)*Xfactor);
            System.out.print(" Y2= "+(this.forma[i+3]*Yfactor)+") ");
            
        }
        System.out.println();
    }
    
    protected void dibujar_division(GraphicsContext gc,double desplazarXpos,double desplazarXinterno){
        for(int i = 0;i<this.forma.length;i=i+4){
            gc.setStroke(this.color);
            gc.strokeLine((this.forma[i]-desplazarXpos-desplazarXinterno)*Xfactor, this.forma[i+1]*Yfactor, 
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
    

    public void setColor(Color color){
        this.color = color;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void moverArriba(){
        for(int i = 0;i<this.forma.length;i = i+2){
            this.forma[i] = this.forma[i]+5;  // Coordenada X
            this.forma[i+1] = this.forma[i+1]-22; // Coordenada Y
        }
    }
}
    

