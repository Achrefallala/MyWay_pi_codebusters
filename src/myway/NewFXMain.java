/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myway;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import myway.Entities.Utilisateur;

/**
 *
 * @author baghd
 */
public class NewFXMain extends Application {

     @Override
    public void start(Stage primaryStage) {
        
        try {
            Parent root=FXMLLoader.load(getClass().getResource("../myway/GUI/ProfilUser.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Hello");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException ex) {
            System.out.println("Err"+ex.getMessage());
        }
       
    }

    public static void main(String[] args) {
        launch(args);
    }
}
