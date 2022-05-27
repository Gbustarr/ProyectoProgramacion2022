/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Guillermo
 */
public class division {

    int altura;

    protected void nuevaDivision(Logica l, ArrayList<Simbolo> lista_simbolos, Simbolo s, GraphicsContext gc) {

        if (l.enDivision) {
            l.ParentesisAbiertos.get(0).moverArriba(2);
            l.ParentesisAbiertos.get(0).dimensionarParentesisHaciaAbajo(altura);
            dimensionarParentesisAbiertosHaciaAbajo(l, l.ParentesisAbiertos.size(), 0);
            l.moverListaHaciaIzquierda(lista_simbolos, 1);
            l.Bloque.addAll(l.Numeradores);
            for (int i = 0; i < l.Bloque.size(); i++) {
                l.Bloque.get(i).color = Color.BLACK;
            }
            l.Numeradores.clear();
            l.Numeradores.addAll(l.Denominadores);
            l.Numeradores.get(0).moverArriba(2);
            l.Numeradores.remove(0);
            for (int i = 0; i < l.Numeradores.size(); i++) {
                l.Numeradores.get(i).color = Color.GOLD;
            }
            l.moverNumeradoresHaciaArriba(2);
            l.Denominadores.clear();
            l.Bloque.add(l.divisor);
            l.moverBloqueHaciaArriba(2);
        } else if (l.divisionAgregada) {
            int contador = 0;
            for (int i = lista_simbolos.size() - 1; i >= 0; i--) {
                if (lista_simbolos.get(i).getValor() == 18) { //si es parentesis de cierre
                    contador++;
                } else if (lista_simbolos.get(i).getValor() == 17) { // si es parentesis de apertura
                    contador--;
                }
                if (contador == 0) {
                    lista_simbolos.get(i).color = Color.BLACK;
                    l.Bloque.add(lista_simbolos.get(i));
                    break;
                } else {
                    lista_simbolos.get(i).color = Color.BLACK;
                    l.Bloque.add(lista_simbolos.get(i));
                }
            }
            l.moverBloqueHaciaArriba(2);
            l.enDivision = true;

        } else {
            dimensionarParentesisAbiertosHaciaAbajo(l, 1, 1);
            int contador = 0;
            for (int i = lista_simbolos.size() - 1; i > 0; i--) {
                if (lista_simbolos.get(i).getValor() == 18) {
                    contador++;
                } else if (lista_simbolos.get(i).getValor() == 17) {
                    contador--;
                }
                if (contador == 0) {
                    lista_simbolos.get(i).color = Color.GOLD;
                    l.Numeradores.add(lista_simbolos.get(i));
                    break;
                } else {
                    lista_simbolos.get(i).color = Color.GOLD;
                    l.Numeradores.add(lista_simbolos.get(i));
                }
            }
            l.moverNumeradoresHaciaArriba(1);

            l.enDivision = true;
        }

    }

    protected void dimensionarParentesisAbiertosHaciaAbajo(Logica l, int max, int subida) {
        for (int i = 0; i < max; i++) {
            l.ParentesisAbiertos.get(i).moverArriba(subida);
            l.ParentesisAbiertos.get(i).dimensionarParentesisHaciaAbajo(1);
        }
    }

    protected void verificarTamanoNumeradorDenominador(Logica l) {

        double diferencia;
        diferencia = (l.movimientosDeLista - 2) - l.Denominadores.size();

        if (diferencia >= 0) {
            l.denominadorMenor = true;
            l.diferenciaNumeradorDenominador = diferencia;
        } else {
            l.denominadorMenor = false;
        }

    }

    protected void modificarLineaDivision(Logica l, double pivot_x) {
        double inicio = pivot_x - ((l.movimientosDeLista - 1) * (l.espacioEntreSimbolos + 15));
        l.divisor.division(inicio, pivot_x);

    }
;

}
