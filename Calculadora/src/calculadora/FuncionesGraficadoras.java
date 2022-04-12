/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author oknmi
 */
public class FuncionesGraficadoras {
    
    int espacio = 15;
    CoordenadasSimbolos cs = new CoordenadasSimbolos();
    
    public void dibujar_todos_los_simbolos(double pivot,GraphicsContext gc,ArrayList<Simbolo> lista_simbolos){
        double espacio_total = espacio*lista_simbolos.size();
        
        for(int i = 0; i< lista_simbolos.size();i++){
                System.out.println("----------------");
                Simbolo s = lista_simbolos.get(i);
                
                if(s.valor == 13){
                    
                    double espacio_interno = 0;
                    for(int j = i-1; j>=0;j--){
                        if(lista_simbolos.get(j).tipo == 1){
                            break;
                        }else{
                            espacio_interno = espacio_interno + espacio; 
                        }
                    }
                    s.dibujar_division(gc, espacio_total, espacio_interno);
                }else{
                    s.dibujar_Simbolo(gc,espacio_total);
                }
                
                espacio_total = espacio_total - espacio;

                
            }
    
    }
    
    protected void Dibujar_simbolos(GraphicsContext gc,int nSimbolo,
        ArrayList<Simbolo> lista_simbolos, double pivot_x,double pivot_y,
        Canvas Display){
        
        int n = lista_simbolos.size();
        System.out.println("Simbolos pre almacenados: "+n);
        
        //Iniciación y declaración de un simbolo general
        Simbolo s = new Simbolo();
        s.setXpos(pivot_x);
        s.setYpos(pivot_y);
        
        
        //Iniciación de una forma general
        double[] forma;
        
        
        switch(nSimbolo){
            case 0:
                forma = cs.cero(pivot_x, pivot_y);
                s.setForma(forma);
                s.setValor(0);
                s.setTipo(0);
                lista_simbolos.add(s);
                break;
            case 1:
                forma = cs.uno(pivot_x, pivot_y);
                s.setValor(1);
                s.setTipo(0);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 2:
                forma = cs.dos(pivot_x, pivot_y);
                s.setValor(2);
                s.setTipo(0);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 3:
                forma = cs.tres(pivot_x, pivot_y);
                s.setValor(3);
                s.setTipo(0);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 4:
                forma = cs.cuatro(pivot_x, pivot_y);
                s.setValor(4);
                s.setTipo(0);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 5:
                forma = cs.cinco(pivot_x, pivot_y);
                s.setValor(5);
                s.setTipo(0);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 6:
                forma = cs.seis(pivot_x, pivot_y);
                s.setValor(6);
                s.setTipo(0);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
                
            case 7:
                forma = cs.siete(pivot_x, pivot_y);
                s.setValor(7);
                s.setTipo(0);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 8:
                forma = cs.ocho(pivot_x, pivot_y);
                s.setValor(8);
                s.setTipo(0);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 9:
                forma = cs.nueve(pivot_x, pivot_y);
                s.setValor(9);
                s.setTipo(0);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 10:
                forma = cs.mas(pivot_x, pivot_y);
                s.setValor(10);
                s.setTipo(1);
                s.setForma(forma);
                s.setColor(Color.RED);
                lista_simbolos.add(s);
                break;
            case 11:
                forma = cs.menos(pivot_x, pivot_y);
                s.setValor(11);
                s.setTipo(1);
                s.setForma(forma);
                s.setColor(Color.RED);
                lista_simbolos.add(s);
                break;
            case 12:
                forma = cs.multiplicar(pivot_x, pivot_y);
                s.setValor(12);
                s.setTipo(1);
                s.setForma(forma);
                s.setColor(Color.RED);
                lista_simbolos.add(s);
                break;
            case 13:
                forma = cs.dividir(pivot_x, pivot_y);
                s.setValor(13);
                s.setTipo(1);
                s.setForma(forma);
                s.setColor(Color.RED);
                lista_simbolos.add(s);
                break;
        }
        
        // Funciones graficadoras
        //  Se borra el contenido del canvas para redibujar sobre ella.
        gc.clearRect(0, 0, Display.getWidth(), Display.getHeight());
        dibujar_todos_los_simbolos(pivot_x, gc, lista_simbolos);
    }
    
    protected void numerador(ArrayList<Simbolo> lista_simbolos,int posicion){
        int index = posicion-1;
        
        for(int i= index;i>=0;i--){
            if(lista_simbolos.get(i).tipo != 0){
                System.out.println("Se ha encontrado un operador");
                index = i;
                i = -1; //Para romper el bucle
            }else{
                System.out.println("Se ha encontrado un numero");
                System.out.println("Redimensionando.");
                lista_simbolos.get(i).moverArriba();
                System.out.println("Redimensionado.");
            
            }
            
        }
        
        //return lista_simbolos.get(index).forma[0];
    }
    

        
    
    
}
