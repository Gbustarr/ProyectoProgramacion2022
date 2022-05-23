/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.ArrayList;
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
public class InterfazController implements Initializable {

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
    
    /*
    @FXML
    protected Button Btn_moverDer;
    
    @FXML
    protected Button Btn_moverIzq;
    
     */
    @FXML
    protected Button Btn_puntosControl;
    protected InterfazController controller;
    
    @FXML
    protected Button Btn_Sen;
    @FXML
    protected Button Btn_Cos;
    @FXML
    protected Button Btn_Tan;
    
    @FXML
    protected Button Btn_Fact;

    double pivot_x = 300;
    double pivot_y = 200;

    double espacio_acumulado = 0;
    ArrayList<Simbolo> lista_simbolos = new ArrayList();

    GraphicsContext gc;

    Logica l = new Logica(this);
    FuncionesGraficadoras fg = new FuncionesGraficadoras();
    
    Interfaz_panelController panelContext;
    
    
    //Para los colores de los numeros y operadores
    Color colorNum = Color.GREEN;
    Color colorOp = Color.RED;
    
    //Para el movimiento de la ventana panel
    private double x, y = 0;
    
    //Para el cambio de fondo
    @FXML
    AnchorPane fondoInterfaz;

    @FXML
    protected void Boton0_presionado() {

        l.agregarSimbolo(gc, 0, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton1_presionado() {

        l.agregarSimbolo(gc, 1, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton2_presionado() {

        l.agregarSimbolo(gc, 2, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton3_presionado() {

        l.agregarSimbolo(gc, 3, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton4_presionado() {

        l.agregarSimbolo(gc, 4, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton5_presionado() {

        l.agregarSimbolo(gc, 5, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton6_presionado() {

        l.agregarSimbolo(gc, 6, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton7_presionado() {

        l.agregarSimbolo(gc, 7, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton8_presionado() {

        l.agregarSimbolo(gc, 8, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void Boton9_presionado() {

        l.agregarSimbolo(gc, 9, lista_simbolos, pivot_x, pivot_y, Display);

    }

    @FXML
    protected void BotonMas_presionado() {
        if (l.bloqueadorOperadorMultiple(lista_simbolos) == 0) {
            l.agregarSimbolo(gc, 10, lista_simbolos, pivot_x, pivot_y, Display);
        }
    }

    @FXML
    protected void BotonMenos_presionado() {
        if (l.bloqueadorSignoNegativo(lista_simbolos) == 1) {
            l.agregarSimbolo(gc, 11, lista_simbolos, pivot_x, pivot_y, Display);
        }
    }

    @FXML
    protected void BotonMultiplicar_presionado() {
        if (l.bloqueadorOperadorMultiple(lista_simbolos) == 0) {
            l.agregarSimbolo(gc, 12, lista_simbolos, pivot_x, pivot_y, Display);
        }

    }
    
    @FXML
    protected void BotonDivision_presionado() {
        if (/*l.divisionActiva != 1 && */ lista_simbolos.size() > 0) {
            if (lista_simbolos.get(lista_simbolos.size() - 1).getTipo() != 1) {
                //l.moverNumeradoresHaciaArriba(lista_simbolos);
                l.agregarSimbolo(gc, 13, lista_simbolos, pivot_x, pivot_y, Display);

            }
        }
    }
    
    @FXML
    protected void BotonColorNum_Azul(){
        colorNum = Color.web("#0D3C94");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    @FXML
    protected void BotonColorNum_Rojo(){
        colorNum = Color.web("#CC0000");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    @FXML
    protected void BotonColorNum_Verde(){
        colorNum = Color.web("#32940D");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    @FXML
    protected void BotonColorNum_Cafe(){
        colorNum = Color.web("#94550D");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    @FXML
    protected void BotonColorNum_Morado(){
        colorNum = Color.web("#540E64");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    @FXML
    protected void BotonColorNum_Naranjo(){
        colorNum = Color.web("#E56B20");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    
    @FXML
    protected void BotonColorOp_Azul(){
        colorOp = Color.web("#0D3C94");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    @FXML
    protected void BotonColorOp_Rojo(){
        colorOp = Color.web("#CC0000");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    @FXML
    protected void BotonColorOp_Verde(){
        colorOp = Color.web("#32940D");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    @FXML
    protected void BotonColorOp_Cafe(){
        colorOp = Color.web("#94550D");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    @FXML
    protected void BotonColorOp_Morado(){
        colorOp = Color.web("#540E64");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    @FXML
    protected void BotonColorOp_Naranjo(){
        colorOp = Color.web("#E56B20");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp,Display);
    }
    
    
    @FXML
    protected void BtnOperador_presionado(){
        l.agregarSimbolo(gc, 16, lista_simbolos, pivot_x, pivot_y, Display);
    }

    @FXML
    protected void BotonDEL_presionado() {

        if (lista_simbolos.size() > 0) {
            l.borrarUltimo(gc, lista_simbolos, pivot_x, Display);
        }

    }

    @FXML
    protected void BotonAC_presionado() {

        if (lista_simbolos.size() > 0) {
            l.resetEstado();
            fg.borrarTodo(gc, Display, lista_simbolos, pivot_x);
            l.divisionActiva = 0;
            if (l.panelAgregado == 1){
                l.context.panelContext.setTextArea();
            }
        }

    }

    @FXML
    protected void BotonPuntosControl_presionado() {
        l.switchPuntosControl(lista_simbolos, gc, Display);
    }
    
    @FXML
    protected void BotonPanel_presionado() throws IOException {
        if(l.panelAgregado ==0){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Interfaz_panel.fxml"));
            Parent root = loader.load();
            
            
            Scene scene = new Scene(root);
            panelContext = loader.getController();
            panelContext.setController(this);
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
            l.panelAgregado = 1;
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
    
    @FXML
    protected void BotonCientifico_presionado() {
       
        if(Btn_Sen.isVisible() == true){
            Btn_Sen.setVisible(false);
            Btn_Cos.setVisible(false);
            Btn_Tan.setVisible(false);
            Btn_Fact.setVisible(false);
            Btn_Cientifico.setText("Básico");
            fondoInterfaz.getStyleClass().clear();
            fondoInterfaz.getStyleClass().add("bodybg");
        }else{
            Btn_Sen.setVisible(true);
            Btn_Fact.setVisible(true);
            Btn_Cos.setVisible(true);
            Btn_Tan.setVisible(true);
            Btn_Cientifico.setText("Científico");
            fondoInterfaz.getStyleClass().clear();
            fondoInterfaz.getStyleClass().add("bodybgC");
        }

    }

    @FXML
    protected void Cerrar() {
        Platform.exit();
    }
    
    protected void setController(InterfazController ic){
        this.controller = ic;
        this.lista_simbolos = controller.lista_simbolos;
                fg.limpiarCanvas(gc, Display);
        fg.dibujarTodosLosSimbolos(gc, controller.lista_simbolos);
    }

    @FXML
    protected void BotonSeno_presionado(){
        l.agregarSimbolo(gc, 14, lista_simbolos, pivot_x, pivot_y, Display);
        l.agregarSimbolo(gc, 17, lista_simbolos, pivot_x, pivot_y, Display);
    }
    @FXML
    protected void BotonCos_presionado(){
        l.agregarSimbolo(gc, 15, lista_simbolos, pivot_x, pivot_y, Display);
        l.agregarSimbolo(gc, 17, lista_simbolos, pivot_x, pivot_y, Display);
    }
    @FXML
    protected void BotonTan_presionado(){
        l.agregarSimbolo(gc, 16, lista_simbolos, pivot_x, pivot_y, Display);
        l.agregarSimbolo(gc, 17, lista_simbolos, pivot_x, pivot_y, Display);
    }
    
    @FXML
    protected void BotonFact_presionado(){
        l.agregarSimbolo(gc, 19, lista_simbolos, pivot_x, pivot_y, Display);
    }
    
    @FXML
    protected void BotonParentesisAbierto_presionado(){
        l.agregarSimbolo(gc, 17, lista_simbolos, pivot_x, pivot_y, Display);
    }
    
    @FXML
    protected void BotonParentesisCerrado_presionado(){
        if(!lista_simbolos.isEmpty() || !l.indicesParentesisAbierto.isEmpty()){
            l.agregarSimbolo(gc, 18, lista_simbolos, pivot_x, pivot_y, Display);

        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = Display.getGraphicsContext2D();
        /*
        gc.beginPath();
        gc.moveTo(80,80);
        gc.bezierCurveTo(150, 20, 150, 150, 75, 150);
        gc.closePath();
        */
    }

}
