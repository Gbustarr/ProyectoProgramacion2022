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
    private Button Btn_1;

    @FXML
    private Button Btn_2;

    @FXML
    private Button Btn_3;

    @FXML
    private Button Btn_4;

    @FXML
    private Button Btn_5;

    @FXML
    private Button Btn_6;

    @FXML
    private Button Btn_7;

    @FXML
    private Button Btn_8;

    @FXML
    private Button Btn_resta;

    @FXML
    private Button Btn_suma;

    @FXML
    private Button Btn_0;

    @FXML
    private Button Btn_multiplicar;

    @FXML
    private Button Btn_dividir;

    @FXML
    private Canvas Display;
    
    double pivot_x = 340;
    double pivot_y = 161;
    float espacio_entre_simbolos = 10;
    double ancho_de_caracteres = 20;
    double bloque = espacio_entre_simbolos + ancho_de_caracteres;
    float factor = 1;
    ArrayList<Simbolo> lista_simbolos = new ArrayList();
    
    GraphicsContext gc;
    


    
    @FXML
    protected void Boton1_presionado(){
        
        Dibujar_simbolos(gc,1);

    }
    
    protected void Dibujar_simbolos(GraphicsContext gc,int nSimbolo){
        
        int n = lista_simbolos.size();
        System.out.println("Simbolos pre almacenados: "+n);
        
        double[] uno = {pivot_x-10,pivot_y-20,pivot_x-5,pivot_y-30,
            pivot_x-5,pivot_y-30,pivot_x-5,pivot_y-10};
        
        
        switch(nSimbolo){
            case 1:
                Simbolo s = new Simbolo(factor,pivot_x,pivot_y,uno);
                lista_simbolos.add(s);
                break;
        }
       
        
        if (n>0){
            double espacio_acumulado = bloque * -n;
            for(int i = 0; i< lista_simbolos.size();i++){

                Simbolo s = lista_simbolos.get(i);

                s.setXpos(espacio_acumulado);
                s.dibujar_Simbolo(gc);
                
                espacio_acumulado = espacio_acumulado + bloque;
            }

            n = lista_simbolos.size();
            System.out.println("Simbolos post almacenados: "+n);

            if (n>4){
                for(int i = 0; i< lista_simbolos.size();i++){
                lista_simbolos.get(i).setFactor(0.5);
                }
            }
            
        }else{
            Simbolo s = lista_simbolos.get(0);
            s.dibujar_Simbolo(gc);
        }
        
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = Display.getGraphicsContext2D();
    }    
    
}
