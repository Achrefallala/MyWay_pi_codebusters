/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservation.GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//import Reservation.GUI.HomeReservationController.java
/**
 *
 * @author Slim
 */
public class HomeReservationFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException  {
       
        try{
       Parent p = new Parent() {};
        p=FXMLLoader.load(getClass().getResource("HomeReservation.fxml")); //lparent taatih lpath taa fichier fxml
        Scene scene = new Scene(p); //bech tnajjem taffichih thotou fel scene
        primaryStage.setTitle("Gestion Reservation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    catch(IOException e){System.out.println(e.getMessage());}
    }
    /**"
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
