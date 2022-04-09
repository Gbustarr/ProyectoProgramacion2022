/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.Point;
import java.util.ArrayList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * FXML Controller class
 *
 * @author Guillermo
 */
public class InterfazController implements Initializable{
    
    @FXML
    protected Button Btn_1;

    @FXML
    protected Button Btn_2;

    @FXML
    protected Button Btn_3;

    @FXML
    protected Button Btn_4;

    @FXML
    protected Button Btn_5;

    @FXML
    protected Button Btn_6;

    @FXML
    protected Button Btn_7;

    @FXML
    protected Button Btn_8;

    @FXML
    protected Button Btn_resta;

    @FXML
    protected Button Btn_suma;

    @FXML
    protected Button Btn_0;

    @FXML
    protected Button Btn_multiplicar;

    @FXML
    protected Button Btn_dividir;

    @FXML
    protected Canvas Display;
    
    double pivot_x = 340;
    double pivot_y = 161;
    float espacio_entre_simbolos = 10;
    double ancho_de_caracteres = 20;
    double bloque = espacio_entre_simbolos + ancho_de_caracteres;
    float factor = 1;
    
    double espacio_acumulado = 0;
    ArrayList<Simbolo> lista_simbolos = new ArrayList();
    
    GraphicsContext gc;
    
    FuncionesGraficadoras fg = new FuncionesGraficadoras();
    CoordenadasSimbolos cs = new CoordenadasSimbolos();


    
    @FXML
    protected void Boton1_presionado(){
        
        Dibujar_simbolos(gc,1);

    }
    
    protected void Dibujar_simbolos(GraphicsContext gc,int nSimbolo){
        
        int n = lista_simbolos.size();
        System.out.println("Simbolos pre almacenados: "+n);
        
        //Iniciación y declaración de un simbolo general
        Simbolo s = new Simbolo();
        s.setFactor(factor);
        s.setXpos(pivot_x);
        s.setYpos(pivot_y);
        
        
        //Iniciación de una forma general
        double[] forma;
        
        
        switch(nSimbolo){
            case 0:
                forma = cs.cero(pivot_x, pivot_y);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 1:
                forma = cs.uno(pivot_x, pivot_y);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
        }
        // Funciones graficadoras
        //  Se borra el contenido del canvas para redibujar sobre ella.
        gc.clearRect(0, 0, Display.getWidth(), Display.getHeight());
        fg.dibujar_todos_los_simbolos(pivot_x, gc, lista_simbolos);
       
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = Display.getGraphicsContext2D();
    }    
    
}
