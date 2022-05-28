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
 * @author guillermo
 */
public class Logica {
    
    double pivot_x = 50;
    double pivot_y = 150;

    double espacioEntreSimbolos = 15;
    CoordenadasSimbolos cs = new CoordenadasSimbolos();

    double movimientosDeLista = 0;
    int puntosControlActivo = 0;
    
    //Funciones auxiliares
    
    FuncionesAuxiliares fa = new FuncionesAuxiliares();

    //variable para el tamano 
    double factor = 1;
    //Variables para la division
    ArrayList<Simbolo> Numeradores = new ArrayList();
    ArrayList<Simbolo> Denominadores = new ArrayList();
    ArrayList<Simbolo> Bloque = new ArrayList();
    ArrayList<Integer> anchosDivision = new ArrayList();
    boolean enDivision;
    boolean divisionAgregada;
    boolean denominadorMenor = true;
    Simbolo divisor;
    double diferenciaNumeradorDenominador = 0;
    int subidasDivision;
    int contadorReset = 0;

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
        ArrayList<Simbolo> lista_simbolos,
        Canvas Display) {
        updateTags();
        //Iniciación y declaración de un simbolo general
        Simbolo s = new Simbolo();
        s.setXpos(pivot_x);
        s.setYpos(pivot_y);
        s.Xfactor = factor;
        s.Yfactor = factor;

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
                resetMovimientoLista();
                forma = cs.mas(pivot_x, pivot_y);
                s.setValor(10);
                s.setTipo(1);
                s.setColor(context.colorOp);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 11:
                resetMovimientoLista();
                forma = cs.menos(pivot_x, pivot_y);
                s.setValor(11);
                s.setTipo(1);
                s.setColor(context.colorOp);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 12:
                resetMovimientoLista();
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
                subidasDivision++;

                d.nuevaDivision(this, lista_simbolos, s, gc);
                divisor = s;
                d.modificarLineaDivision(this, pivot_x);
                lista_simbolos.add(s);
                break;
            case 14: //Seno
                s.setValor(14);
                s.setTipo(2);
                s.setColor(context.colorOp);
                formaOperadorCientifico(14, pivot_x, pivot_y, s);
                lista_simbolos.add(s);
                break;
            case 15: //Coseno
                s.setValor(15);
                s.setTipo(2);
                s.setColor(context.colorOp);
                formaOperadorCientifico(15, pivot_x, pivot_y, s);
                lista_simbolos.add(s);
                break;
            case 16: //Tangente
                s.setValor(16);
                s.setTipo(2);
                s.setColor(context.colorOp);
                formaOperadorCientifico(16, pivot_x, pivot_y, s);
                lista_simbolos.add(s);
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
                s.setAlturaParentesis(ParentesisAbiertos.get(ParentesisAbiertos.size() - 1).getAlturaParentesis());
                lista_simbolos.add(s);
                ParentesisAbiertos.remove(ParentesisAbiertos.size() - 1); //Elimina el ultimo parentesis abierto
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
        fa.moverPivot(this,s);
        
        
        
        //Para activar los puntos de control de los simbolos
        if (puntosControlActivo == 1) {
            s.switchPuntosControl();
        }

        
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

    protected void cambiarTamano(double factor) {
        for (int i = 0; i < context.lista_simbolos.size(); i++) {
            context.lista_simbolos.get(i).Xfactor = factor;
            context.lista_simbolos.get(i).Yfactor = factor;
        }
        fg.limpiarCanvas(context.gc, context.Display);
        fg.dibujarTodosLosSimbolos(context.gc, context.lista_simbolos);
    }

    protected void resetEstado() {
        enDivision = false;
        denominadorMenor = true;
        movimientosDeLista = 0;
        Numeradores.clear();
        Denominadores.clear();
        ParentesisAbiertos.clear();
        subidasDivision = 0;
        divisionAgregada = false;
        Bloque.clear();
        context.textoSalida.setText("");
        parentesisAgregadoANumerador = false;
        pivot_x = 50;
        pivot_y = 100;

    }

    protected void updateTags() {
        context.alturaDivision.setText("enDivision: " + enDivision);
        context.divisionActiva.setText("Subidas Division: " + subidasDivision);
        context.indiceUltimaDivision.setText("Division Agregada: " + divisionAgregada);
        //context.denominadorMenor.setText("Denominador Menor: " + denominadorMenor);
        context.indicesNumeradores.setText("Parentesis abiertos: " + ParentesisAbiertos.size());
        //context.indicesDenominadores.setText("Indices Denominadores: " + indicesDenominadores.size());
        //context.indicesDivisionCombinada.setText("Indices Division Combinada: " + indicesDivisionCombinada.size());
        //context.anchoDivision.setText("Ancho Division: " + anchoDivision);
        //context.anchoDivisionAnterior.setText("Ancho Division Anterior: " + anchoDivisionAnterior);
        //context.divisionEliminada.setText("Division eliminada: "+divisionEliminada);
        context.movimientosDeLista.setText("movimientosDeLista: " + movimientosDeLista);
    }

    protected void cambiarMovimientosListas() {
        if (ParentesisAbiertos.size() > 0) {
            movimientosDeLista++;
        }

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
                s.moverDerecha(2);
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
                s.moverDerecha(2);
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
                s.moverDerecha(2);
                break;
        }
    }

    protected void moverListaHaciaIzquierda(ArrayList<Simbolo> lista_simbolos, double espacios) {
        for (int i = 0; i < lista_simbolos.size() - 1; i++) {
            lista_simbolos.get(i).moverIzquierda(espacios);
        }

    }

    protected void moverListaHaciaDerecha(ArrayList<Simbolo> lista_simbolos, int espacios) {
        for (int i = 0; i < lista_simbolos.size(); i++) {
            lista_simbolos.get(i).moverDerecha(espacios);
        }

    }

    protected void moverNumeradoresHaciaArriba(double pos) {

        for (int i = 0; i < Numeradores.size(); i++) {
            Numeradores.get(i).moverArriba(pos);
        }

    }

    protected void moverBloqueHaciaArriba(double pos) {

        for (int i = 0; i < Bloque.size(); i++) {
            Bloque.get(i).moverArriba(pos);
        }

    }

    protected void resetMovimientoLista() {
        if (context.lista_simbolos.get(context.lista_simbolos.size() - 1).getValor() == 18) {
            movimientosDeLista = 0;
            divisionAgregada = false;
        }
    }

    protected void moverBloqueHaciaDerecha(double pos) {

        for (int i = 0; i < Bloque.size(); i++) {
            Bloque.get(i).moverDerecha(pos);
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

    protected void moverNumeradoresHaciaDerecha(double espacios) {
        for (int i = 0; i < Numeradores.size(); i++) {
            Numeradores.get(i).moverDerecha(espacios);
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

}
