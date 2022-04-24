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
    int enDivision = 0;
    
    private static double espacio = 15;


    public Simbolo(double Xpos, double Ypos, double[] forma) {
        this.Xpos = Xpos;
        this.Ypos = Ypos;
        this.forma = forma;
    }
    
    public Simbolo(){
    }
   //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/canvas/GraphicsContext.html
    protected void dibujar_Simbolo(GraphicsContext gc){
        
        //System.out.println("Simbolo: " +this.valor);
        for(int i = 0;i<this.forma.length;i=i+4){
            gc.setStroke(this.color);
            gc.strokeLine((this.forma[i])*Xfactor, this.forma[i+1]*Yfactor, 
                (this.forma[i+2])*Xfactor, this.forma[i+3]*Yfactor);
            
            //Puntos de control
            gc.fillOval(((this.forma[i])*Xfactor), (this.forma[i+1]*Yfactor), 1, 1);
            gc.fillOval(((this.forma[i+2])*Xfactor), (this.forma[i+3]*Yfactor), 1, 1);
            
            /*
            System.out.print("Linea(("+(this.forma[i])*Xfactor);
            System.out.print(","+(this.forma[i+1]*Yfactor));
            System.out.print("),("+(this.forma[i+2])*Xfactor);
            System.out.print(","+(this.forma[i+3]*Yfactor)+")) ");
            */
        }
        //System.out.println();
    }
    
    protected void division(double xInicio,double xFinal){
        this.forma[0] = xInicio;
        this.forma[2] = xFinal;
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
        return this.tipo;
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
    
    protected void moverArriba(double factor){
        for(int i = 0;i<this.forma.length;i = i+2){
            this.forma[i+1] = this.forma[i+1]-(22*factor); // Coordenada Y
        }
    }
    
    protected void moverAbajo(int factor){
        for(int i = 0;i<this.forma.length;i = i+2){
            this.forma[i+1] = this.forma[i+1]+(22*factor); // Coordenada Y
        }
    }
    
    protected void moverIzquierda(int factor){
        for(int i = 0;i<this.forma.length;i = i+2){
            this.forma[i] = this.forma[i]-(espacio*factor);  // Coordenada X
        }
    }
    
    protected void moverDerecha(int factor){
        for(int i = 0;i<this.forma.length;i = i+2){
            this.forma[i] = this.forma[i]+(espacio*factor);  // Coordenada X
        }
    }
}
    

