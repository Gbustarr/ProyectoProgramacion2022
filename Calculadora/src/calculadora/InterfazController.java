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
    @FXML
    protected Button Btn_AC;

    @FXML
    protected Button Btn_DEL;
    
    /*
    @FXML
    protected Button Btn_moverDer;
    
    @FXML
    protected Button Btn_moverIzq;
    
    */
    
    double pivot_x = 330;
    double pivot_y = 200;
    
    double espacio_acumulado = 0;
    ArrayList<Simbolo> lista_simbolos = new ArrayList();
    
    GraphicsContext gc;
    
    FuncionesGraficadoras fg = new FuncionesGraficadoras();
    

    @FXML
    protected void Boton0_presionado(){
        
        fg.agregarSimbolo(gc,0,lista_simbolos,pivot_x,pivot_y,Display);

    }
    
    @FXML
    protected void Boton1_presionado(){
        
        fg.agregarSimbolo(gc,1,lista_simbolos,pivot_x,pivot_y,Display);

    }
    
    @FXML
    protected void Boton2_presionado(){
        
        fg.agregarSimbolo(gc,2,lista_simbolos,pivot_x,pivot_y,Display);

    }
    
    @FXML
    protected void Boton3_presionado(){
        
        fg.agregarSimbolo(gc,3,lista_simbolos,pivot_x,pivot_y,Display);

    }

    @FXML
    protected void Boton4_presionado(){
        
        fg.agregarSimbolo(gc,4,lista_simbolos,pivot_x,pivot_y,Display);

    }
    @FXML
    protected void Boton5_presionado(){
        
        fg.agregarSimbolo(gc,5,lista_simbolos,pivot_x,pivot_y,Display);

    }
    @FXML
    protected void Boton6_presionado(){
        
        fg.agregarSimbolo(gc,6,lista_simbolos,pivot_x,pivot_y,Display);

    }
    @FXML
    protected void Boton7_presionado(){
        
        fg.agregarSimbolo(gc,7,lista_simbolos,pivot_x,pivot_y,Display);

    }
    @FXML
    protected void Boton8_presionado(){
        
        fg.agregarSimbolo(gc,8,lista_simbolos,pivot_x,pivot_y,Display);

    }
    @FXML
    protected void Boton9_presionado(){
        
        fg.agregarSimbolo(gc,9,lista_simbolos,pivot_x,pivot_y,Display);

    }
    @FXML
    protected void BotonMas_presionado(){
        if(fg.bloqueador_operador_multiple(lista_simbolos) == 0){
        fg.agregarSimbolo(gc,10,lista_simbolos,pivot_x,pivot_y,Display);
        }
    }

    @FXML
    protected void BotonMenos_presionado(){
        if(fg.bloqueador_operador_multiple(lista_simbolos) == 0){
        fg.agregarSimbolo(gc,11,lista_simbolos,pivot_x,pivot_y,Display);
        }
    }
    @FXML
    protected void BotonMultiplicar_presionado(){
        if(fg.bloqueador_operador_multiple(lista_simbolos) == 0){
            fg.agregarSimbolo(gc,12,lista_simbolos,pivot_x,pivot_y,Display);
        }
        
    }
    
    @FXML
    protected void BotonDivision_presionado(){
        if(fg.divisionActiva != 1){
            fg.moverNumeradoresHaciaArriba(lista_simbolos);
            fg.agregarSimbolo(gc,13,lista_simbolos,pivot_x,pivot_y,Display);
        }
        
        

    }
    
    
    
    @FXML
    protected void BotonDEL_presionado(){
    
        if(lista_simbolos.size() > 0){
            fg.borrarUltimo(gc,lista_simbolos,pivot_x,Display);
        }

    }
    
    @FXML
    protected void BotonAC_presionado(){
    
        if(lista_simbolos.size() > 0){
            fg.borrarTodo(gc,Display,lista_simbolos,pivot_x);
        }

    }
    
    /*
    @FXML
    protected void BotonMovDer_presionado(){
      
            fg.moverListaHaciaDerecha(lista_simbolos, 1);
            fg.movimientosDeLista = fg.movimientosDeLista -1;
            fg.limpiarCanvas(gc, Display);
            fg.dibujarTodosLosSimbolos(pivot_x, gc, lista_simbolos);

    
    }
    
    @FXML
    protected void BotonMovIzq_presionado(){
        if(fg.movimientosDeLista != 0){
            fg.moverListaHaciaIzquierda(lista_simbolos, 1);
            fg.movimientosDeLista = fg.movimientosDeLista +1;
            fg.limpiarCanvas(gc, Display);
            fg.dibujarTodosLosSimbolos(pivot_x, gc, lista_simbolos);
        }
    
    }
    
    */
    
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
