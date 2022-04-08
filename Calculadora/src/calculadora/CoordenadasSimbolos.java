/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author oknmi
 */
public class CoordenadasSimbolos {
    
    double[] cero(double x,double y){
        double[] cero =     {x-10,y-40,x,y-40,
                            x,y-40,x,y-10,
                            x,y-10,x-10,y-10,
                            x-10,y-10,x-10,y-40
                            };
        return cero;
    }
    
    double[] uno(double x,double y){
        double[] uno =      {x-10,y-35,x-5,y-40,
                            x-5,y-40,x-5,y-10,
                            x-10,y-10,x,y-10};
        return uno;
    }
    double[] dos(double x,double y){
        double[] dos =      {x-10,y-40,x,y-40,
                            x,y-40,x,y-25,
                            x,y-25,x-10,y-25,
                            x-10,y-25,x-10,y-10,
                            x-10,y-10,x,y-10};
        return dos;
    }
    double[] tres(double x,double y){
        double[] tres =     {x-10,y-40,x,y-40,
                            x,y-40,x,y-25,
                            x,y-25,x-10,y-25,
                            x,y-25,x,y-10,
                            x-10,y-10,x,y-10};
        return tres;
    }
    
    double[] cuatro(double x, double y){
        double[] cuatro =   {x-10,y-40,x-10,y-25,
                            x-10,y-25,x,y-25,
                            x,y-40,x,y-10};
        return cuatro;
    }
    
    double[] cinco(double x, double y){
        double[] cinco =    {x-10,y-40,x,y-40,
                            x-10,y-40,x-10,y-25,
                            x-10,y-25,x,y-25,
                            x,y-25,x,y-10,
                            x,y-10,x-10,y-10};
        
        return cinco;
    }
    
    double[] seis(double x, double y){
        double[] seis =     {x-10,y-40,x,y-40,
                            x-10,y-40,x-10,y-10,
                            x-10,y-10,x,y-10,
                            x,y-10,x,y-25,
                            x,y-25,x-10,y-25};
        return seis;
    }
    
    double[] siete(double x, double y){
        double[] siete =    {x-10,y-40,x,y-40,
                            x,y-40,x,y-10};
        return siete;
    }
    
    double[] ocho(double x, double y){
        double[] ocho =     {x-10,y-40,x,y-40,
                            x-10,y-40,x-10,y-10,
                            x-10,y-10,x,y-10,
                            x,y-10,x,y-40,
                            x-10,y-25,x,y-25};
        return ocho;
    }
    
    double[] nueve(double x, double y){
        double[] nueve =    {x-10,y-40,x,y-40,
                            x-10,y-40,x-10,y-25,
                            x-10,y-25,x,y-25,
                            x,y-40,x,y-10
                            };
        return nueve;
    }
    
    double[] mas(double x, double y){
        double[] mas =      {x-5,y-32.5,x-5,y-17.5,
                            x-10,y-25,x,y-25};
        return mas;
    }
    
    double[] menos(double x, double y){
        double[] menos =    {x-10,y-25,x,y-25};
        return menos;
    }
    
    double[] multiplicar(double x, double y){
        double[] multiplicar =  {x-10,y-32.5,x,y-17.5,
                                x-10,y-17.5,x,y-32.5
                                };
        return multiplicar;
    }
    double[] dividir(double x, double y){
        double[] dividir =      {x-10,y-25,x,y-25};
        return dividir;
    }
}
