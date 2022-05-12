/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Guillermo
 */
public class InterfazControllerCientifica implements Initializable {

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
    protected Button Btn_potencia;

    @FXML
    protected Canvas Display;
    @FXML
    protected Button Btn_AC;

    @FXML
    protected Button Btn_DEL;
    
    @FXML
    protected Button Btn_Cientifico;
    
    @FXML
    protected TextField textoSalida;
    
    @FXML
    protected Button Btn_Panel;
    
    @FXML 
    protected TextArea textArea;

    @FXML
    protected ColorPicker colorNumeros;

    @FXML
    protected ColorPicker colorOperadores;

    @FXML
    protected Slider tamanoCaracteres;
    
    @FXML
    protected Button Btn_Sen;
    @FXML
    protected Button Btn_Cos;
    @FXML
    protected Button Btn_Tan;
    
    /*
    @FXML
    protected Button Btn_moverDer;
    
    @FXML
    protected Button Btn_moverIzq;
    
     */
    @FXML
    protected Button Btn_puntosControl;
    protected InterfazControllerCientifica controller;

    double pivot_x = 300;
    double pivot_y = 200;

    double espacio_acumulado = 0;

    GraphicsContext gc;
    
    ArrayList<Simbolo> lista_simbolos;

    FuncionesGraficadoras fg = new FuncionesGraficadoras();
    InterfazController context ;
    
    Interfaz_panelController panelContext;
    
    
    //Para los colores de los numeros y operadores
    Color colorNum = Color.GREEN;
    Color colorOp = Color.RED;
    
    //Para el movimiento de la ventana panel
    private double x, y = 0;
    
    //Para el cambio de basica a cientifica
    
    @FXML
    AnchorPane rootPane;

    @FXML
    protected void Boton0_presionado() {

        context.l.agregarSimbolo(gc, 0, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton1_presionado() {

        context.l.agregarSimbolo(gc, 1, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton2_presionado() {

        context.l.agregarSimbolo(gc, 2, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton3_presionado() {

        context.l.agregarSimbolo(gc, 3, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton4_presionado() {

        context.l.agregarSimbolo(gc, 4, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton5_presionado() {

        context.l.agregarSimbolo(gc, 5, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton6_presionado() {

        context.l.agregarSimbolo(gc, 6, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton7_presionado() {

        context.l.agregarSimbolo(gc, 7, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton8_presionado() {

        context.l.agregarSimbolo(gc, 8, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton9_presionado() {

        context.l.agregarSimbolo(gc, 9, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void BotonMas_presionado() {
        if (context.l.bloqueadorOperadorMultiple(lista_simbolos) == 0) {
            context.l.agregarSimbolo(gc, 10, lista_simbolos, pivot_x, pivot_y, Display);
        }
    }

    @FXML
    protected void BotonMenos_presionado() {
        if (context.l.bloqueadorSignoNegativo(lista_simbolos) == 1) {
            context.l.agregarSimbolo(gc, 11, lista_simbolos, pivot_x, pivot_y, Display);
        }
    }

    @FXML
    protected void BotonMultiplicar_presionado() {
        if (context.l.bloqueadorOperadorMultiple(lista_simbolos) == 0) {
            context.l.agregarSimbolo(gc, 12, lista_simbolos, pivot_x, pivot_y, Display);
        }

    }
    
    @FXML
    protected void BotonDivision_presionado() {
        if (/*l.divisionActiva != 1 && */ lista_simbolos.size() > 0) {
            if (lista_simbolos.get(lista_simbolos.size() - 1).getTipo() != 1) {
                //l.moverNumeradoresHaciaArriba(lista_simbolos);
                context.l.agregarSimbolo(gc, 13, lista_simbolos, pivot_x, pivot_y, Display);

            }
        }
    }
    
    @FXML
    protected void BtnOperador_presionado(){
        context.l.agregarSimbolo(gc, 16, lista_simbolos, pivot_x, pivot_y, Display);
    }
    
    @FXML
    protected void BotonSeno_presionado(){
        context.l.agregarSimbolo(gc, 14, lista_simbolos, pivot_x, pivot_y, Display);
    }
    @FXML
    protected void BotonCos_presionado(){
        context.l.agregarSimbolo(gc, 15, lista_simbolos, pivot_x, pivot_y, Display);
    }
    @FXML
    protected void BotonTan_presionado(){
        context.l.agregarSimbolo(gc, 16, lista_simbolos, pivot_x, pivot_y, Display);
    }

    @FXML
    protected void BotonDEL_presionado() {

        if (lista_simbolos.size() > 0) {
            context.l.borrarUltimo(gc, lista_simbolos, pivot_x, Display);
        }

    }
    
    

    @FXML
    protected void BotonAC_presionado() {

        if (lista_simbolos.size() > 0) {
            context.l.resetEstado();
            fg.borrarTodo(gc, Display, lista_simbolos, pivot_x);
            context.l.divisionActiva = 0;
        }

    }

    @FXML
    protected void BotonPuntosControl_presionado() {
        context.l.switchPuntosControl(lista_simbolos, gc, Display);
    }
    
    @FXML
    protected void BotonPanel_presionado() throws IOException {
        if(context.l.panelAgregado ==0){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Interfaz_panel.fxml"));
            Parent root = loader.load();
            
            
            Scene scene = new Scene(root);
            panelContext = loader.getController();
            panelContext.setControllerC(this);
            panelContext.setTextArea();
            
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            //Para el movimiento de el programa mediante el mouse
            root.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();
            });

            root.setOnMouseDragged(mouseEvent -> {
                stage.setX(mouseEvent.getScreenX() - x);
                stage.setY(mouseEvent.getScreenY() - y);
            });
            stage.show();
            context.l.panelAgregado = 1;
        }
    }
    
    @FXML
    protected void BotonColorNumeros_presionado(){
        colorNum= Color.valueOf(colorNumeros.getValue().toString());
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    @FXML
    protected void BotonColorOperadores_presionado(){
        colorOp= Color.valueOf(colorOperadores.getValue().toString());
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    @FXML
    protected void Slider_presionado(){
        System.out.println(tamanoCaracteres.getValue());
    }

    /*
    @FXML
    protected void BotonMovDer_presionado(){
      
            l.moverListaHaciaDerecha(lista_simbolos, 1);
            l.movimientosDeLista = l.movimientosDeLista -1;
            l.limpiarCanvas(gc, Display);
            l.dibujarTodosLosSimbolos(pivot_x, gc, lista_simbolos);

    
    }
    
    @FXML
    protected void BotonMovIzq_presionado(){
        if(l.movimientosDeLista != 0){
            l.moverListaHaciaIzquierda(lista_simbolos, 1);
            l.movimientosDeLista = l.movimientosDeLista +1;
            l.limpiarCanvas(gc, Display);
            l.dibujarTodosLosSimbolos(pivot_x, gc, lista_simbolos);
        }
    
    }
    
     */
    
    @FXML
    protected void BotonCientifico_presionado() throws IOException{
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Interfaz_basica.fxml"));
        Parent root = loader.load();
        InterfazController AC = loader.getController();
        AC.setController(context);
        rootPane.setVisible(false);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        //Para el movimiento de el programa mediante el mouse
            root.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();
            });

            root.setOnMouseDragged(mouseEvent -> {
                stage.setX(mouseEvent.getScreenX() - x);
                stage.setY(mouseEvent.getScreenY() - y);
            });
        stage.show();
        
        /*
        
        InterfazControllerCientifica contextCientifica = new InterfazControllerCientifica();
        contextCientifica.setContext(this);
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Interfaz_cientifica.fxml"));
        rootPane.getChildren().setAll(pane);
        */
    }
    
    protected void setContext(InterfazController context){
        this.context = context;
        this.lista_simbolos = context.lista_simbolos;
    }
    
    
    @FXML
    protected void Cerrar() {
        Platform.exit();
    }
    
    protected void setController(InterfazController ic){
        this.context = ic;
        this.lista_simbolos = context.lista_simbolos;
                fg.limpiarCanvas(gc, Display);
        System.out.println("Canvas");
        fg.dibujarTodosLosSimbolos(gc, context.lista_simbolos);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = Display.getGraphicsContext2D();

        
    }

}
