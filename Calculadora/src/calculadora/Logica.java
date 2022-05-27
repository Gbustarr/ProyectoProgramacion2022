/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author guillermo
 */
public class Logica {

    int espacio = 15;
    CoordenadasSimbolos cs = new CoordenadasSimbolos();

    double xInicioDivision;
    double xFinalDivision;
    int movimientosDeLista = 0;
    int puntosControlActivo = 0;
    int divisionEliminada = 0;

    //Variables para la division
    int divisionActiva = 0;
    boolean salidaDivision = false;
    int alturaDivision = 0;
    int indiceUltimaDivision;

    int denominadorMenor = 1; // 0 falso, 1 verdadero;
    ArrayList<Integer> indicesNumeradores = new ArrayList();
    ArrayList<Integer> indicesDenominadores = new ArrayList();
    ArrayList<Integer> indicesDivisionCombinada = new ArrayList();
    int anchoDivision;
    int anchoDivisionAnterior;

    InterfazController context;
    division d = new division();
    int panelAgregado = 0;

    //Variables para los parentesis
    ArrayList<Simbolo> ParentesisAbiertos = new ArrayList();
    boolean parentesisAgregadoANumerador = false;
    int alturaParentesis = 0;

    //FuncionesGraficadoras
    FuncionesGraficadoras fg = new FuncionesGraficadoras();

    public Logica(InterfazController context) {
        this.context = context;
    }

    protected void agregarSimbolo(GraphicsContext gc, int nSimbolo,
        ArrayList<Simbolo> lista_simbolos, double pivot_x, double pivot_y,
        Canvas Display) {
        updateTags();
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
                s.setColor(context.colorNum);
                s.setTipo(0);
                lista_simbolos.add(s);
                break;
            case 1:
                forma = cs.uno(pivot_x, pivot_y);
                s.setValor(1);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 2:
                forma = cs.dos(pivot_x, pivot_y);
                s.setValor(2);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 3:
                forma = cs.tres(pivot_x, pivot_y);
                s.setValor(3);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 4:
                forma = cs.cuatro(pivot_x, pivot_y);
                s.setValor(4);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 5:
                forma = cs.cinco(pivot_x, pivot_y);
                s.setValor(5);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 6:
                forma = cs.seis(pivot_x, pivot_y);
                s.setValor(6);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;

            case 7:
                forma = cs.siete(pivot_x, pivot_y);
                s.setValor(7);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 8:
                forma = cs.ocho(pivot_x, pivot_y);
                s.setValor(8);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 9:
                forma = cs.nueve(pivot_x, pivot_y);
                s.setValor(9);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 10:
                forma = cs.mas(pivot_x, pivot_y);
                s.setValor(10);
                s.setTipo(1);
                s.setColor(context.colorOp);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 11:
                forma = cs.menos(pivot_x, pivot_y);
                s.setValor(11);
                s.setTipo(1);
                s.setColor(context.colorOp);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 12:
                forma = cs.multiplicar(pivot_x, pivot_y);
                s.setValor(12);
                s.setTipo(1);
                s.setColor(context.colorOp);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 13:
                forma = cs.dividir(pivot_x, pivot_y);
                s.setValor(13);
                s.setTipo(1);
                s.setColor(context.colorOp);
                s.setForma(forma);
                xInicioDivision = coordenadaXDivision(lista_simbolos, pivot_x);
                s.division(xInicioDivision, pivot_x);

                d.nuevaDivision(this, lista_simbolos, s, gc);

                break;
            case 14: //Seno
                s.setValor(14);
                s.setTipo(2);
                s.setColor(context.colorOp);
                formaOperadorCientifico(14, pivot_x, pivot_y, s);
                lista_simbolos.add(s);
                moverListaHaciaIzquierda(lista_simbolos, 2);
                break;
            case 15: //Coseno
                s.setValor(15);
                s.setTipo(2);
                s.setColor(context.colorOp);
                formaOperadorCientifico(15, pivot_x, pivot_y, s);
                lista_simbolos.add(s);
                moverListaHaciaIzquierda(lista_simbolos, 2);
                break;
            case 16: //Tangente
                s.setValor(16);
                s.setTipo(2);
                s.setColor(context.colorOp);
                formaOperadorCientifico(16, pivot_x, pivot_y, s);
                lista_simbolos.add(s);
                moverListaHaciaIzquierda(lista_simbolos, 2);
                break;
            case 17: //Parentesis Abierto
                s.setValor(17);
                s.setTipo(2);
                s.setColor(context.colorOp);
                forma = cs.pAbierto(pivot_x, pivot_y);
                s.setForma(forma);
                lista_simbolos.add(s);
                ParentesisAbiertos.add(s);
                break;
            case 18: //Parentesis Cerrado
                s.setValor(18);
                s.setTipo(2);
                s.setColor(context.colorOp);
                forma = cs.pCerrado(pivot_x, pivot_y);
                s.setForma(forma);
                if (ParentesisAbiertos.get(ParentesisAbiertos.size() - 1).getParentesisDimensionado()) {
                    s.moverAbajo(1);
                    s.setAlturaParentesis(getAlturaParentesisAbierto());
                }
                if(salidaDivision){s.setBloqueParentesis();};
                
                lista_simbolos.add(s);

                if (!ParentesisAbiertos.isEmpty()) {
                    ParentesisAbiertos.remove(ParentesisAbiertos.size() - 1); //Elimina el parentesis abierto anterior
                }
                //resetEstado();
                break;
            case 19:
                forma = cs.factorial(pivot_x, pivot_y);
                s.setValor(19);
                s.setTipo(2);
                s.setColor(context.colorOp);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
        }

        //Para activar los puntos de control de los simbolos
        if (puntosControlActivo == 1) {
            s.switchPuntosControl();
        }

        //Si es un operador *,+ o -, los valores se reestablecen
        if (s.getValor() > 9 && s.getValor() < 13) {
            if(lista_simbolos.get(lista_simbolos.size()-2).getBloqueParentesis()){
                anchoDivision = 0;
            }
        }

        if (divisionActiva == 1) {
            this.indicesDenominadores.add(lista_simbolos.size() - 1);
        }

        //Verificando que el denominador sea menor que el numerador
        d.verificarAnchoDivision(this);

        d.logica(this, s, lista_simbolos, gc, pivot_x);

        // Funciones graficadoras
        //  Se borra el contenido del canvas para redibujar sobre ella.
        fg.limpiarCanvas(gc, Display);
        fg.dibujarTodosLosSimbolos(gc, lista_simbolos);

        context.textoSalida.setText(listaATexto(lista_simbolos));

        if (panelAgregado == 1) {
            context.panelContext.setTextArea();
        }

        updateTags();
    }

    protected double[] getAlturaParentesisAbierto() {

        return ParentesisAbiertos.get(ParentesisAbiertos.size() - 1).getAlturaParentesis();
    }

    protected double coordenadaXDivision(ArrayList<Simbolo> lista_simbolos, double pivot_x) {
        double contador = 0;
        double xInicial = pivot_x - 10;
        double espaciado = 15;
        double xFinal;
        for (int i = lista_simbolos.size() - 1; i >= 0; i--) {
            if (lista_simbolos.get(i).getTipo() == 0) {
                contador++;
            } else {
                break;
            }
        }
        xFinal = xInicial - (espaciado * (contador - 1));

        return xFinal;

    }

    protected void resetEstado() {
        divisionActiva = 0;
        denominadorMenor = 1;
        indicesNumeradores.clear();
        indicesDenominadores.clear();
        indicesDivisionCombinada.clear();
        alturaParentesis = alturaDivision;
        alturaDivision = 0;
        context.textoSalida.setText("");
        parentesisAgregadoANumerador = false;
        indiceUltimaDivision = 0;

    }

    protected void moverFraccionArriba(ArrayList<Simbolo> lista_simbolos, double posiciones) {
        //System.out.print("Movimiento de fracciones: ");
        for (int i = 0; i < indicesDivisionCombinada.size(); i++) {
            lista_simbolos.get(this.indicesDivisionCombinada.get(i)).moverArriba(posiciones);
            System.out.print(lista_simbolos.get(this.indicesDivisionCombinada.get(i)).getValor()
                + " ");
        }

    }
    
    protected void moverBloqueArriba(ArrayList<Simbolo> lista_simbolos, double posiciones) {
        //System.out.print("Movimiento de fracciones: ");
        for (int i = 0; i < indicesNumeradores.size(); i++) {
            lista_simbolos.get(this.indicesNumeradores.get(i)).moverArriba(posiciones);
            System.out.print(lista_simbolos.get(this.indicesNumeradores.get(i)).getValor()
                + " ");
        }

    }

    protected void moverNumeradoresArriba(ArrayList<Simbolo> lista_simbolos) {
        for (int i = 0; i < indicesNumeradores.size(); i++) {
            lista_simbolos.get(this.indicesNumeradores.get(i)).moverArriba(1);
        }

    }
    
    protected void updateTags(){
        context.alturaDivision.setText("Altura Division: " + alturaDivision);
        context.divisionActiva.setText("División activa: " + divisionActiva);
        context.indiceUltimaDivision.setText("Indice Ultima Division: " + indiceUltimaDivision);
        context.denominadorMenor.setText("Denominador Menor: " + denominadorMenor);
        context.indicesNumeradores.setText("Indices Numeradores: " + indicesNumeradores.size());
        context.indicesDenominadores.setText("Indices Denominadores: " + indicesDenominadores.size());
        context.indicesDivisionCombinada.setText("Indices Division Combinada: " + indicesDivisionCombinada.size());
        context.anchoDivision.setText("Ancho Division: " + anchoDivision);
        context.anchoDivisionAnterior.setText("Ancho Division Anterior: " + anchoDivisionAnterior);
        context.divisionEliminada.setText("Division eliminada: "+divisionEliminada);
        context.movimientosDeLista.setText("Salida division: "+salidaDivision);
    }

    protected void formaOperadorCientifico(int valor, double pivot_x, double pivot_y, Simbolo s) {

        double[] forma;

        switch (valor) {
            case 14: //Operador Seno
                forma = cs.s(pivot_x, pivot_y); //Agrega la S
                s.forma = forma;
                s.moverIzquierda(1);
                forma = cs.i(pivot_x, pivot_y); //Agregar I
                s.concatenarForma(forma);
                s.moverIzquierda(1);
                forma = cs.n(pivot_x, pivot_y); //Agregar N
                s.concatenarForma(forma);
                break;
            case 15: //Operador Coseno
                forma = cs.c(pivot_x, pivot_y); //Agrega la C
                s.forma = forma;
                s.moverIzquierda(1);
                forma = cs.o(pivot_x, pivot_y); //Agregar O
                s.concatenarForma(forma);
                s.moverIzquierda(1);
                forma = cs.s(pivot_x, pivot_y); //Agregar S
                s.concatenarForma(forma);
                break;
            case 16: //Operador Tangente
                forma = cs.t(pivot_x, pivot_y); //Agrega la T
                s.forma = forma;
                s.moverIzquierda(1);
                forma = cs.a(pivot_x, pivot_y); //Agregar A
                s.concatenarForma(forma);
                s.moverIzquierda(1);
                forma = cs.n(pivot_x, pivot_y); //Agregar N
                s.concatenarForma(forma);
                break;
        }
    }

    protected void moverNumeradoresDerecha(ArrayList<Simbolo> lista_simbolos) {
        for (int i = 0; i < indicesNumeradores.size(); i++) {
            lista_simbolos.get(this.indicesNumeradores.get(i)).moverDerecha(0.5);
        }
    }

    protected int posicionEnDenominador(ArrayList<Simbolo> lista_simbolos) {
        int nNumeradores = 0;
        int nDenominadores = 0;
        int pos;
        ////System.out.print("Denominadores: ");
        for (int i = lista_simbolos.size() - 1; i >= 0; i--) {
            if (lista_simbolos.get(i).getTipo() == 0) {
                nDenominadores++;
                ////System.out.print(lista_simbolos.get(i).getValor());
            } else {
                ////System.out.println("Numeradores: ");
                for (int j = i - 1; j >= 0; j--) {
                    if (lista_simbolos.get(j).getTipo() == 0) {
                        // //System.out.print(lista_simbolos.get(j).getValor());
                        nNumeradores++;
                    } else {
                        break;
                    }
                }
                break;
            }
        }

        pos = nNumeradores - nDenominadores;
        ////System.out.println(pos);
        return pos;
    }

    protected void agregarNumeradores(ArrayList<Simbolo> lista_simbolos) {
        ////System.out.print("Denominadores: ");
        for (int i = lista_simbolos.size() - 1; i >= 0; i--) {
            if (lista_simbolos.get(i).getTipo() == 0 || lista_simbolos.get(i).getValor() == 11) {
                this.indicesNumeradores.add(i);
            } else {
                break;
            }
        }
    }

    protected void agregarParentesisANumerador(ArrayList<Simbolo> lista_simbolos) {
        
        for (int i = lista_simbolos.size() - 1; i >= 0; i--) {
            if (lista_simbolos.get(i).valor == 17) { // 17 = parentesis abierto
                this.indicesNumeradores.add(i);
                break;
            } else {
                this.indicesNumeradores.add(i);
            }
        }

    }
    
    protected void agregarBloqueParentesisANumerador(ArrayList<Simbolo> lista_simbolos) {
        int contadorParentesis = 1;
        this.indicesNumeradores.add(lista_simbolos.size()-1);
        
        for (int i = lista_simbolos.size() - 2; i >= 0; i--) {
            if (contadorParentesis != 0) { 
                if(lista_simbolos.get(i).valor == 18){
                    contadorParentesis++;
                }else if(lista_simbolos.get(i).valor == 17){
                    contadorParentesis--;
                }
                this.indicesNumeradores.add(i);
                
            } else {
                this.indicesNumeradores.add(i);
                break;
            }
        }

    }

    protected void debugPrintNumeradores(ArrayList<Simbolo> lista_simbolos) {
        System.out.println();
        System.out.print("Valores de indices numeradores:");
        for (int i = 0; i < this.indicesNumeradores.size(); i++) {
            System.out.print(lista_simbolos.get(this.indicesNumeradores.get(i)).valor + " ");
        }
        System.out.println();
        System.out.print("Valores de indices denominadores:");
        for (int i = 0; i < this.indicesDenominadores.size(); i++) {
            System.out.print(lista_simbolos.get(this.indicesDenominadores.get(i)).valor + " ");
        }
        System.out.println();
        System.out.print("Division combinada:");
        if (indicesDivisionCombinada.size() > 0) {
            for (int i = 0; i < this.indicesDivisionCombinada.size(); i++) {
                System.out.print(lista_simbolos.get(this.indicesDivisionCombinada.get(i)).valor + " ");
            }
            System.out.println();
        } else {
            System.out.println("");
        }
    }

    protected void modificarLineaDivision(ArrayList<Simbolo> lista_simbolos, double pivot_x) {

        double xInicio = pivot_x - (this.anchoDivision * 15);
        //System.out.println("Indice Ultima Division: "+indiceUltimaDivision);
        if (alturaDivision == 0) {
            lista_simbolos.get(this.indiceUltimaDivision).division(xInicio, pivot_x);
        } else {
            //xInicio = xInicio +15;
            lista_simbolos.get(this.indiceUltimaDivision).division(xInicio, pivot_x);
        }

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

    protected int bloqueadorOperadorMultiple(ArrayList<Simbolo> lista_simbolos) {
        int index = lista_simbolos.size() - 1;
        if (!lista_simbolos.isEmpty()) {
            if (index != -1) {
                if (lista_simbolos.get(index).tipo == 0 || lista_simbolos.get(index).tipo == 2) {
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

    protected int bloqueadorSignoNegativo(ArrayList<Simbolo> lista_simbolos) {

        if (lista_simbolos.isEmpty()) {
            return 1;
        } else {
            if (lista_simbolos.size() > 0) {
                if (lista_simbolos.get(lista_simbolos.size() - 1).getTipo() == 0
                    || lista_simbolos.get(lista_simbolos.size() - 1).getTipo() == 2
                    || (lista_simbolos.get(lista_simbolos.size() - 1).getTipo() == 1
                    && lista_simbolos.get(lista_simbolos.size() - 2).getTipo() == 0)) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }

    protected void switchPuntosControl(ArrayList<Simbolo> lista_simbolos, GraphicsContext gc, Canvas Display) {

        for (int i = 0; i < lista_simbolos.size(); i++) {
            lista_simbolos.get(i).switchPuntosControl();
        }
        fg.limpiarCanvas(gc, Display);
        fg.dibujarTodosLosSimbolos(gc, lista_simbolos);

        if (puntosControlActivo == 0) {
            puntosControlActivo = 1;
        } else {
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
    }

    protected String listaATexto(ArrayList<Simbolo> lista_simbolos) {

        String string = "";

        for (int i = 0; i < lista_simbolos.size(); i++) {
            Simbolo s = lista_simbolos.get(i);
            if (s.valor > 9) {
                if (s.valor == 10) {
                    System.out.print(" + ");
                    string = string + " + ";
                }
                if (s.valor == 11) {
                    System.out.print(" - ");
                    string = string + " - ";
                }
                if (s.valor == 12) {
                    System.out.print(" * ");
                    string = string + " * ";
                }
                if (s.valor == 13) {
                    System.out.print(" / ");
                    string = string + " / ";
                }
                if (s.valor == 14) {
                    System.out.print(" Sin ");
                    string = string + " Sin ";
                }
                if (s.valor == 15) {
                    System.out.print(" Cos ");
                    string = string + " Cos ";
                }
                if (s.valor == 16) {
                    System.out.print(" Tan ");
                    string = string + " Tan ";
                }
                if (s.valor == 17) {
                    System.out.print("(");
                    string = string + "(";
                }
                if (s.valor == 18) {
                    System.out.print(")");
                    string = string + ")";
                }
                if (s.valor == 19) {
                    System.out.print("!");
                    string = string + "!";
                }

            } else {
                System.out.print(s.valor);
                string = string + s.valor;
            }

        }
        System.out.println();

        return string;
    }

    protected void borrarUltimo(GraphicsContext gc, ArrayList<Simbolo> lista_simbolos, double pivot_x, Canvas Display) {

        fg.limpiarCanvas(gc, Display);
        //Actualiza la variable divisionActiva si el numero a borrar pertenece a una division
        for (int i = lista_simbolos.size() - 1; i >= 0; i--) {

            if (lista_simbolos.get(i).getValor() == 13) { //13 es el valor de la division
                divisionActiva = 1;
                divisionEliminada = 0;
                break;
            } else if (lista_simbolos.get(i).getValor() > 9 && lista_simbolos.get(i).getValor() < 13) {
                divisionActiva = 0;
                //diferenciaNumeradorDenominador = 0;
                break;
            } else {
                divisionActiva = 0;
            }

        }

        if (divisionEliminada == 0) {
            if (posicionEnDenominador(lista_simbolos) <= -1) {
                moverListaHaciaDerecha(lista_simbolos, 1);
                modificarLineaDivision(lista_simbolos, pivot_x);
            }
        }

        //Si no hay division, la lista se mueve hacia la derecha
        if (divisionActiva == 0) {
            moverListaHaciaDerecha(lista_simbolos, 1);

        }

        //Si el simbolo eliminado es una division, los numeradores se mueven un 
        //espacio hacia abajo y a la derecha tantos espacios sea la diferencia de 
        //digitos entre el numerador y denominador
        if (lista_simbolos.get(lista_simbolos.size() - 1).getValor() == 13) {
            moverNumeradoresHaciaAbajo(lista_simbolos);
            divisionActiva = 0;
            divisionEliminada = 1;
        }
        //Borrado del simbolo
        lista_simbolos.remove(lista_simbolos.size() - 1);

        //Se vuelve a dibujar todos los simbolos en el canvas
        fg.dibujarTodosLosSimbolos(gc, lista_simbolos);
    }

}
