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
    
    double [] potencia(double x, double y){
        double [] potencia = {x-10,y-32.5,x-5,y-40,
                              x-5,y-40,x,y-32.5};
        return potencia;
    }
    
    double [] factorial(double x, double y){
        double [] factorial = {x-10,y-40,x-10,y-18,
                               x-10,y-10,x-10,y-10,
                               x-10,y-10,x-10,y-10,
                               x-10,y-10,x-10,y-10};
        return factorial;
    }
    
    double[] s(double x, double y){
        double [] s = {x,y-35,x,y-40,x,y-40,x-10,y-40,
                       x-10,y-40,x-10,y-30,x-10,y-30,x,y-30,
                       x,y-30,x,y-10,x,y-10,x-10,y-10,
                       x-10,y-10,x-10,y-15};
        return s;
    }
    
    double [] i(double x, double y){
        double [] i ={x-5,y-10,x-5,y-35,
                      x-5,y-40,x-5,y-40,
                      x-5,y-40,x-5,y-40};
        return i;
    }
    
    double [] n(double x, double y){
        double [] n={x-10,y-10,x-10,y-40,
                     x-10,y-40,x,y-10,x,y-10,
                     x,y-40};
        return n;
    }
    
    double [] c(double x, double y){
        double [] c = {x,y-35,x,y-40,
                       x,y-40,x-5,y-40,
                       x-5,y-40,x-10,y-32.5,
                       x-10,y-32.5,x-10,y-17.5,
                       x-10,y-17.5,x-5,y-10,
                       x-5,y-10,x,y-10,
                       x,y-10,x,y-15};
        return c;
    }
    
    double [] o(double x, double y){
        double[] o = {x-7.5,y-10,x-10,y-17.5,
                      x-10,y-17.5,x-10,y-32.5,
                      x-10,y-32.5,x-7.5,y-40,
                      x-7.5,y-40,x-2.5,y-40,
                      x-2.5,y-40,x,y-32.5,
                      x,y-32.5,x,y-17.5,
                      x,y-17.5,x-2.5,y-10,
                      x-2.5,y-10,x-7.5,y-10,
                      };
        return o;
    }
    
    double[] s2(double x, double y){
        double [] s2 = {x,y-40,x-5,y-40,x-5,y-40,
                       x-10,y-33.5,x-10,y-33.5,
                       x,y-17.5,x,y-17.5,x-5,y-10,
                       x-5,y-10,x-10,y-10};
        return s2;
    }
    
    
     
    
    double[] t(double x, double y){
        double [] t={x-5,y-10,x-5,y-40,
                     x-5,y-40,x,y-40,x,y-40,x-10,y-40};
        return t;
    }
    
    double [] a(double x, double y){
        double [] a={x-10,y-10,x-10,y-32.5,
                     x-10,y-32.5,x-7.5,y-40,
                     x-7.5,y-40,x-2.5,y-40,
                     x-2.5,y-40,x,y-32.5,
                     x,y-32.5,x,y-10,
                     x,y-10,x,y-25,
                     x,y-25,x-10,y-25}  ;
        return a;
    }
    double [] n2(double x, double y){
        double [] n2={x-10,y-10,x-10,y-40,
                     x-10,y-40,x,y-10,x,y-10,
                     x,y-40};
        return n2;
    }
    
   

    
}    
    
                
