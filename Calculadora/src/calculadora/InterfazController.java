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
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


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
    double pivot_y = 200;
    float espacio_entre_simbolos = 10;
    double ancho_de_caracteres = 20;
    double bloque = espacio_entre_simbolos + ancho_de_caracteres;
    
    double espacio_acumulado = 0;
    ArrayList<Simbolo> lista_simbolos = new ArrayList();
    
    GraphicsContext gc;
    
    FuncionesGraficadoras fg = new FuncionesGraficadoras();
    

    @FXML
    protected void Boton0_presionado(){
        
        fg.Dibujar_simbolos(gc,0,lista_simbolos,pivot_x,pivot_y,Display);

    }
    
    @FXML
    protected void Boton1_presionado(){
        
        fg.Dibujar_simbolos(gc,1,lista_simbolos,pivot_x,pivot_y,Display);

    }
    
    @FXML
    protected void Boton2_presionado(){
        
        fg.Dibujar_simbolos(gc,2,lista_simbolos,pivot_x,pivot_y,Display);

    }
    
    @FXML
    protected void Boton3_presionado(){
        
        fg.Dibujar_simbolos(gc,3,lista_simbolos,pivot_x,pivot_y,Display);

    }

    @FXML
    protected void Boton4_presionado(){
        
        fg.Dibujar_simbolos(gc,4,lista_simbolos,pivot_x,pivot_y,Display);

    }
    @FXML
    protected void Boton5_presionado(){
        
        fg.Dibujar_simbolos(gc,5,lista_simbolos,pivot_x,pivot_y,Display);

    }
    @FXML
    protected void Boton6_presionado(){
        
        fg.Dibujar_simbolos(gc,6,lista_simbolos,pivot_x,pivot_y,Display);

    }
    @FXML
    protected void Boton7_presionado(){
        
        fg.Dibujar_simbolos(gc,7,lista_simbolos,pivot_x,pivot_y,Display);

    }
    @FXML
    protected void Boton8_presionado(){
        
        fg.Dibujar_simbolos(gc,8,lista_simbolos,pivot_x,pivot_y,Display);

    }
    @FXML
    protected void Boton9_presionado(){
        
        fg.Dibujar_simbolos(gc,9,lista_simbolos,pivot_x,pivot_y,Display);

    }
    @FXML
    protected void BotonMas_presionado(){
        if(fg.bloqueador_operador_multiple(lista_simbolos) == 0){
        fg.Dibujar_simbolos(gc,10,lista_simbolos,pivot_x,pivot_y,Display);
        }
    }

    @FXML
    protected void BotonMenos_presionado(){
        if(fg.bloqueador_operador_multiple(lista_simbolos) == 0){
        fg.Dibujar_simbolos(gc,11,lista_simbolos,pivot_x,pivot_y,Display);
        }
    }
    @FXML
    protected void BotonMultiplicar_presionado(){
        if(fg.bloqueador_operador_multiple(lista_simbolos) == 0){
            fg.Dibujar_simbolos(gc,12,lista_simbolos,pivot_x,pivot_y,Display);
        }
        

    }
    
    @FXML
    protected void BotonDividir_presionado(){
        if (fg.bloqueador_operador_multiple(lista_simbolos) == 0){
            System.out.println("N° Simbolos: "+lista_simbolos.size());
            fg.numerador(lista_simbolos, lista_simbolos.size());
            fg.Dibujar_simbolos(gc,13,lista_simbolos,pivot_x,pivot_y,Display);
        }
        
        

    }
    
    @FXML
    protected void Cerrar(){
        Platform.exit();
    }

    

       
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = Display.getGraphicsContext2D();
    }    
    
}
