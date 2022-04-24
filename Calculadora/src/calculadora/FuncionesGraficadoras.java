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
    int divisionActiva = 0;
    int denominadorMenor = 1; // 0 falso, 1 verdadero;
    double xInicioDivision;
    double xFinalDivision;
    int diferenciaNumeradorDenominador;
    int movimientosDeLista= 0;
    int puntosControlActivo = 0;

    public void dibujarTodosLosSimbolos(GraphicsContext gc, ArrayList<Simbolo> lista_simbolos) {
        for (int i = 0; i < lista_simbolos.size(); i++) {
            //System.out.println("----------------");

            Simbolo s = lista_simbolos.get(i);
            s.dibujar_Simbolo(gc);

        }
        
        //System.out.println("Division activa: "+divisionActiva);
        //text_debugger(lista_simbolos);

    }

    protected void agregarSimbolo(GraphicsContext gc, int nSimbolo,
        ArrayList<Simbolo> lista_simbolos, double pivot_x, double pivot_y,
        Canvas Display) {

        int n = lista_simbolos.size();
        //System.out.println("Simbolos pre almacenados: " + n);

        //Iniciación y declaración de un simbolo general
        Simbolo s = new Simbolo();
        s.setXpos(pivot_x);
        s.setYpos(pivot_y);

        //Iniciación de una forma general
        double[] forma;

        switch (nSimbolo) {
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
                xInicioDivision = coordenadaXDivision(lista_simbolos,pivot_x);
                s.division(xInicioDivision, pivot_x);
                s.setColor(Color.RED);
                lista_simbolos.add(s);
                break;
        }
        
        if(puntosControlActivo == 1){
            s.switchPuntosControl();
        }
        
        
        //Si es un operador *,+ o -, los valores se reestablecen
        if (s.getValor() > 9 && s.getValor() < 13) {
            divisionActiva = 0;
            denominadorMenor = 1;
            diferenciaNumeradorDenominador = 0;
        }

        //Verificando que el denominador sea menor que el numerador
        if (posicionEnDenominador(lista_simbolos) < 0) {
            denominadorMenor = 0;
        } else {
            denominadorMenor = 1;
        }

        //Dependiendo si el denominador es menor que el numerador, el numero a agregar
        // y dibujar baja y se mueve hacia la izquierda
        if (divisionActiva == 1) {
            if (denominadorMenor == 1) {
                s.moverAbajo(1);
                s.moverIzquierda(posicionEnDenominador(lista_simbolos));
                //System.out.println("Posicion: " + posicionEnDenominador(lista_simbolos));
            } else {
                s.moverAbajo(1);
                moverListaHaciaIzquierda(lista_simbolos,1);
            }
        }

        //Verifica si el simbolo agregado no es una division
        //En caso de serlo, los demas numeros no se mueven hacia la izquierda
        if (s.getValor() != 13 && divisionActiva == 0) {
            moverListaHaciaIzquierda(lista_simbolos,1);

        } else {
            divisionActiva = 1;
        }

        //Modifica la linea de la division si hay una division activa y el
        //numerador es menor que el denominador
        if (divisionActiva == 1 && denominadorMenor == 0) {
            modificarLineaDivision(lista_simbolos, pivot_x);
            diferenciaNumeradorDenominador++;
        }

        // Funciones graficadoras
        //  Se borra el contenido del canvas para redibujar sobre ella.
        limpiarCanvas(gc, Display);
        dibujarTodosLosSimbolos(gc, lista_simbolos);

        //text_debugger(lista_simbolos);
    }
    
    protected double coordenadaXDivision(ArrayList<Simbolo> lista_simbolos, double pivot_x){
        double contador= 0;
        double xInicial = pivot_x -10;
        double espaciado = 15;
        double xFinal;
        for(int i = lista_simbolos.size()-1;i >= 0;i--){
            if(lista_simbolos.get(i).getTipo() == 0){
                contador++;
            }else{
                break;
            }
        }
        xFinal = xInicial -(espaciado * (contador-1));
        
        return xFinal;
    
    }

    protected int posicionEnDenominador(ArrayList<Simbolo> lista_simbolos) {
        int nNumeradores = 0;
        int nDenominadores = 0;
        int pos;
        //System.out.print("Denominadores: ");
        for (int i = lista_simbolos.size() - 1; i >= 0; i--) {
            if (lista_simbolos.get(i).getTipo() == 0) {
                nDenominadores++;
                //System.out.print(lista_simbolos.get(i).getValor());
            } else {
                //System.out.println("Numeradores: ");
                for (int j = i - 1; j >= 0; j--) {
                    if (lista_simbolos.get(j).getTipo() == 0) {
                       // System.out.print(lista_simbolos.get(j).getValor());
                        nNumeradores++;
                    } else {
                        break;
                    }
                }
                break;
            }
        }

        pos = nNumeradores - nDenominadores;
        //System.out.println(pos);
        return pos;
    }

    protected void modificarLineaDivision(ArrayList<Simbolo> lista_simbolos, double pivot_x) {
        int index = -1;

        for (int i = lista_simbolos.size() - 1; i >= 0; i--) {
            if (lista_simbolos.get(i).getValor() == 13) {
                index = i;
                break;
                //System.out.print(lista_simbolos.get(i));
            }
        }

        Simbolo s = lista_simbolos.get(index);

        s.division(s.forma[0], pivot_x);
    }

    protected void moverListaHaciaIzquierda(ArrayList<Simbolo> lista_simbolos, int espacios) {
        for (int i = 0; i < lista_simbolos.size() - 1; i++) {
            lista_simbolos.get(i).moverIzquierda(espacios);
        }

    }

    protected void moverListaHaciaDerecha(ArrayList<Simbolo> lista_simbolos, int espacios) {
        for (int i = 0; i < lista_simbolos.size(); i++) {
            lista_simbolos.get(i).moverDerecha(espacios);
        }

    }

    protected void moverNumeradoresHaciaArriba(ArrayList<Simbolo> lista_simbolos) {

        for (int i = lista_simbolos.size() - 1; i >= 0; i--) {
            if (lista_simbolos.get(i).getTipo() == 0) {
                lista_simbolos.get(i).moverArriba(1);
            } else {
                break;
            }

        }

    }
    
    protected void moverNumeradoresHaciaAbajo(ArrayList<Simbolo> lista_simbolos) {

        for (int i = lista_simbolos.size() - 2; i >= 0; i--) {
            if (lista_simbolos.get(i).getTipo() == 0) {
                lista_simbolos.get(i).moverArriba(-1);
            } else {
                break;
            }

        }

    }

    protected void borrarTodo(GraphicsContext gc, Canvas Display, ArrayList<Simbolo> lista_simbolos, double pivot_x) {
        limpiarCanvas(gc, Display);
        lista_simbolos.clear();
        dibujarTodosLosSimbolos(gc, lista_simbolos);
        divisionActiva = 0;
    }

    protected void borrarUltimo(GraphicsContext gc, ArrayList<Simbolo> lista_simbolos, double pivot_x, Canvas Display) {
        int divisionEliminada = 0;
        limpiarCanvas(gc, Display);
        //Actualiza la variable divisionActiva si el numero a borrar pertenece a una division
        //if (lista_simbolos.get(lista_simbolos.size() - 1).getTipo() == 0) {
            for (int i = lista_simbolos.size() - 1; i >= 0; i--) {

                if (lista_simbolos.get(i).getValor() == 13) { //13 es el valor de la division
                    divisionActiva = 1;
                    break;
                } else if (lista_simbolos.get(i).getValor()>9 && lista_simbolos.get(i).getValor() <13){
                    divisionActiva = 0;
                    break;
                }else {
                    divisionActiva = 0;
                }

            }
        //}
        
        System.out.println("Denominador menor: "+denominadorMenor);
        

        //Si no hay division, la lista se mueve hacia la derecha
        if (divisionActiva == 0) {
            moverListaHaciaDerecha(lista_simbolos,1);
          
        }
        
        //Si el simbolo eliminado es una division, los numeradores se mueven un 
        //espacio hacia abajo y a la derecha tantos espacios sea la diferencia de 
        //digitos entre el numerador y denominador
        if(lista_simbolos.get(lista_simbolos.size() - 1).getValor() == 13){
            moverNumeradoresHaciaAbajo(lista_simbolos);
            divisionActiva = 0;
            moverListaHaciaDerecha(lista_simbolos,diferenciaNumeradorDenominador);
            diferenciaNumeradorDenominador = 0;
            System.out.println("Division Eliminada");
        }
        
        
        //Borrado del simbolo
        lista_simbolos.remove(lista_simbolos.size() - 1);

        //Se vuelve a dibujar todos los simbolos en el canvas
        dibujarTodosLosSimbolos(gc, lista_simbolos);
    }

    protected void limpiarCanvas(GraphicsContext gc, Canvas Display) {

        gc.clearRect(0, 0, Display.getWidth(), Display.getHeight());
    }

    protected int bloqueador_operador_multiple(ArrayList<Simbolo> lista_simbolos) {
        int index = lista_simbolos.size() - 1;
        if (!lista_simbolos.isEmpty()) {
            if (index != -1) {
                if (lista_simbolos.get(index).tipo == 0) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }

        } else {
            return 1;
        }

    }
    
    protected void switchPuntosControl(ArrayList<Simbolo> lista_simbolos,GraphicsContext gc, Canvas Display){
        
        for(int i = 0; i< lista_simbolos.size();i++){
            lista_simbolos.get(i).switchPuntosControl();
        }
        limpiarCanvas(gc,Display);
        dibujarTodosLosSimbolos(gc,lista_simbolos);
        
        if(puntosControlActivo == 0){
            puntosControlActivo = 1;
        }else{
            puntosControlActivo = 0;
        }
        
        
        
    }

    protected void text_debugger(ArrayList<Simbolo> lista_simbolos) {
        for (int i = 0; i < lista_simbolos.size(); i++) {
            Simbolo s = lista_simbolos.get(i);
            if (s.valor > 9) {
                if (s.valor == 10) {
                    System.out.print(" + ");
                }
                if (s.valor == 11) {
                    System.out.print(" - ");
                }
                if (s.valor == 12) {
                    System.out.print(" * ");
                }
                if (s.valor == 13) {
                    System.out.print(" / ");
                }
            } else {
                System.out.print(s.valor);
            }

        }
        System.out.println();
        System.out.println(divisionActiva);
    }


}
