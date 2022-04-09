/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.ArrayList;
import javafx.application.Platform;
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
    double Xfactor = 0.625;
    double Yfactor = 0.41875;
    
    double espacio_acumulado = 0;
    ArrayList<Simbolo> lista_simbolos = new ArrayList();
    
    GraphicsContext gc;
    
    FuncionesGraficadoras fg = new FuncionesGraficadoras();
    CoordenadasSimbolos cs = new CoordenadasSimbolos();

    @FXML
    protected void Boton0_presionado(){
        
        Dibujar_simbolos(gc,0);

    }
    
    @FXML
    protected void Boton1_presionado(){
        
        Dibujar_simbolos(gc,1);

    }
    
    @FXML
    protected void Boton2_presionado(){
        
        Dibujar_simbolos(gc,2);

    }
    
    @FXML
    protected void Boton3_presionado(){
        
        Dibujar_simbolos(gc,3);

    }

    @FXML
    protected void Boton4_presionado(){
        
        Dibujar_simbolos(gc,4);

    }
    @FXML
    protected void Boton5_presionado(){
        
        Dibujar_simbolos(gc,5);

    }
    @FXML
    protected void Boton6_presionado(){
        
        Dibujar_simbolos(gc,6);

    }
    @FXML
    protected void Boton7_presionado(){
        
        Dibujar_simbolos(gc,7);

    }
    @FXML
    protected void Boton8_presionado(){
        
        Dibujar_simbolos(gc,8);

    }
    @FXML
    protected void Boton9_presionado(){
        
        Dibujar_simbolos(gc,9);

    }
    @FXML
    protected void BotonMas_presionado(){
        
        Dibujar_simbolos(gc,10);

    }

    @FXML
    protected void BotonMenos_presionado(){
        
        Dibujar_simbolos(gc,11);

    }
    @FXML
    protected void BotonMultiplicar_presionado(){
        
        Dibujar_simbolos(gc,12);

    }
    
    @FXML
    protected void BotonDividir_presionado(){
        
        Dibujar_simbolos(gc,13);

    }
    
    @FXML
    protected void Cerrar(){
        Platform.exit();
    }
    
    protected void Dibujar_simbolos(GraphicsContext gc,int nSimbolo){
        
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
                s.setId(0);
                lista_simbolos.add(s);
                break;
            case 1:
                forma = cs.uno(pivot_x, pivot_y);
                s.setId(1);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 2:
                forma = cs.dos(pivot_x, pivot_y);
                s.setId(2);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 3:
                forma = cs.tres(pivot_x, pivot_y);
                s.setId(3);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 4:
                forma = cs.cuatro(pivot_x, pivot_y);
                s.setId(4);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 5:
                forma = cs.cinco(pivot_x, pivot_y);
                s.setId(5);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 6:
                forma = cs.seis(pivot_x, pivot_y);
                s.setId(6);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
                
            case 7:
                forma = cs.siete(pivot_x, pivot_y);
                s.setId(7);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 8:
                forma = cs.ocho(pivot_x, pivot_y);
                s.setId(8);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 9:
                forma = cs.nueve(pivot_x, pivot_y);
                s.setId(9);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 10:
                forma = cs.mas(pivot_x, pivot_y);
                s.setId(10);
                s.setForma(forma);
                s.setColor(Color.RED);
                lista_simbolos.add(s);
                break;
            case 11:
                forma = cs.menos(pivot_x, pivot_y);
                s.setId(11);
                s.setForma(forma);
                s.setColor(Color.RED);
                lista_simbolos.add(s);
                break;
            case 12:
                forma = cs.multiplicar(pivot_x, pivot_y);
                s.setId(12);
                s.setForma(forma);
                s.setColor(Color.RED);
                lista_simbolos.add(s);
                break;
            case 13:
                forma = cs.dividir(pivot_x, pivot_y);
                s.setId(13);
                s.setForma(forma);
                s.setColor(Color.RED);
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
