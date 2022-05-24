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
 * @author Guillermo
 */
public class division {
    
    int altura;
    
    Logica l;
    
    protected void nuevaDivision(Logica l,ArrayList<Simbolo> lista_simbolos, Simbolo s,GraphicsContext gc){
        if (l.divisionActiva == 0) {
                    if (lista_simbolos.get(lista_simbolos.size() - 1).valor == 18) { // Si el ultimo simbolo agregado es un parentesis
                        if(lista_simbolos.get(lista_simbolos.size()-1).getBloqueParentesis()){
                            l.agregarBloqueParentesisANumerador(lista_simbolos);
                        }else{
                            l.agregarParentesisANumerador(lista_simbolos);
                            l.parentesisAgregadoANumerador = true;
                        }
                        //moverNumeradoresArriba(lista_simbolos);
                    } else {
                        l.agregarNumeradores(lista_simbolos);
                    }
                    l.moverNumeradoresArriba(lista_simbolos);
                    l.indicesNumeradores.add(lista_simbolos.size());
                    l.indiceUltimaDivision = lista_simbolos.size();
                    lista_simbolos.add(s);
                    //Cambio de la altura del parentesis
                    if (!l.ParentesisAbiertos.isEmpty()) {
                        l.ParentesisAbiertos.get(l.ParentesisAbiertos.size() - 1).dimensionarParentesis(gc, 1);
                        l.ParentesisAbiertos.get(l.ParentesisAbiertos.size() - 1).moverAbajo(1);
                        l.ParentesisAbiertos.get(l.ParentesisAbiertos.size() - 1).setParentesisDimensionado();
                    }

                }
    
    }
    
    protected void logica(Logica l,Simbolo s,ArrayList<Simbolo> lista_simbolos,GraphicsContext gc,double pivot_x){
        //System.out.println("Ancho division:"+anchoDivision);
        //Dependiendo si el denominador es menor que el numerador, el numero a agregar
        // y dibujar baja y se mueve hacia la izquierda
        if (l.divisionActiva == 1) {
            if (s.valor != 13) {
                //System.out.println(">Simbolo no 13 detectado.<");
                if (l.denominadorMenor == 1) {
                    //System.out.println("Denominador Menor");
                    s.moverAbajo(1);
                    if(l.parentesisAgregadoANumerador){
                        s.moverIzquierda((l.indicesNumeradores.size()-l.indicesDenominadores.size()-1));
                    }else{
                        s.moverIzquierda(l.posicionEnDenominador(lista_simbolos));
                    }
                    
                } else {
                    l.moverNumeradoresDerecha(lista_simbolos);
                    //System.out.println("Denominador Mayor");
                    s.moverAbajo(1);
                    l.moverListaHaciaIzquierda(lista_simbolos, 1);
                }
            } else if (l.alturaDivision == 0) { //Cuando hay division y se agrega otra division
                //System.out.println("----->Division existente, agregando otra division");
                l.anchoDivisionAnterior = l.anchoDivision;
                lista_simbolos.add(s);
                //Concatenacion de indices a un arreglo
                l.indicesDivisionCombinada.addAll(l.indicesNumeradores);
                l.indicesDenominadores.remove(l.indicesDenominadores.size() - 1);
                //this.indicesNumeradores.add(lista_simbolos.size());
                l.indicesDivisionCombinada.addAll(l.indicesDenominadores);
                l.indicesDenominadores.add(lista_simbolos.size() - 1);

                //this.indicesDivisionCombinada.remove(indicesDivisionCombinada.size()-1);
                l.indicesNumeradores.clear();
                l.indicesNumeradores.addAll(l.indicesDenominadores);
                l.indicesNumeradores.add(lista_simbolos.size() - 1);
                l.indicesDenominadores.clear();

                //Mueve la fraccion anterior hacia arriba
                l.moverFraccionArriba(lista_simbolos, 2);
                //Actualiza el indice de la ultima division
                l.indiceUltimaDivision = lista_simbolos.size() - 1;
                //Agrega el simbolo a la lista de simbolos
                ++l.alturaDivision;

                //Cambio de la altura del parentesis
                if (!l.ParentesisAbiertos.isEmpty()) {
                    l.ParentesisAbiertos.get(l.ParentesisAbiertos.size() - 1).dimensionarParentesis(gc, 1);

                }

            } else if (l.alturaDivision > 0) {
                l.anchoDivisionAnterior = l.anchoDivision;
                //System.out.println("----->Division existente, agregando division sobre division");
                lista_simbolos.add(s);
                //Concatenacion de indices a un arreglo
                l.indicesDenominadores.remove(l.indicesDenominadores.size() - 1);
                l.indicesDivisionCombinada.addAll(l.indicesDenominadores);
                l.indicesDivisionCombinada.add(lista_simbolos.size() - 1);

                //Los denominadores ahora son los numeradores en la nueva division
                l.indicesNumeradores.clear();
                l.indicesNumeradores.addAll(l.indicesDenominadores);
                l.indicesNumeradores.add(lista_simbolos.size() - 1);

                l.indicesDenominadores.clear();

                //Mueve la fraccion anterior hacia arriba
                l.moverFraccionArriba(lista_simbolos, 2);
                //Añade el simbolo como denominador

                //Actualiza el indice de la ultima division
                l.indiceUltimaDivision = lista_simbolos.size() - 1;
                //Agrega el simbolo a la lista de simbolos
                ++l.alturaDivision;
                //Cambio de la altura del parentesis
                if (!l.ParentesisAbiertos.isEmpty()) {
                    l.ParentesisAbiertos.get(l.ParentesisAbiertos.size() - 1).dimensionarParentesis(gc, 1);

                }

            }
        }

        //Verifica si el simbolo agregado no es una division
        //En caso de serlo, los demas numeros no se mueven hacia la izquierda
        if (s.getValor() != 13 && l.divisionActiva == 0) {
            l.moverListaHaciaIzquierda(lista_simbolos, 1);
        } else {

            l.divisionActiva = 1;
        }

        //Modifica la linea de la division si hay una division activa y el
        //numerador es menor que el denominador
        if (l.divisionActiva == 1) {
            l.modificarLineaDivision(lista_simbolos, pivot_x);
            //diferenciaNumeradorDenominador++;
        }
    
    }
    
    protected void verificarAnchoDivision(Logica l){
        this.l = l;
        
        if (l.alturaDivision == 0) {
            if(!l.parentesisAgregadoANumerador){
                if ((l.indicesNumeradores.size() - 3) - l.indicesDenominadores.size() >= 0) {
                l.denominadorMenor = 1;
                l.anchoDivision = l.indicesNumeradores.size() - 1;
            } else {
                l.denominadorMenor = 0;
                l.anchoDivision = l.indicesDenominadores.size();
            }
            
            }else{
                if ((l.indicesNumeradores.size() - 1) - l.indicesDenominadores.size() >= 0) {
                l.denominadorMenor = 1;
                l.anchoDivision = l.indicesNumeradores.size() - 1;
            } else {
                l.denominadorMenor = 0;
                l.anchoDivision = l.indicesDenominadores.size();
            }
            }
        }else{
            if(l.anchoDivisionAnterior >= l.indicesDenominadores.size()){
                l.denominadorMenor = 1;
            }else{
                l.denominadorMenor = 0;
                l.anchoDivision = l.indicesDenominadores.size()-1;
            }
        
        }
    }
}
