/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

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

/**
 *
 * @author DELL
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      Parent root;
        
                try {
                    
                    root=FXMLLoader.load(getClass().getResource("HomeLocationFxml.fxml"));
                    Scene scene = new Scene(root);
                    primaryStage.setTitle("");
                    primaryStage.setScene(scene);
                    primaryStage.setFullScreen(false);
                    primaryStage.show();
                    

                }
                 catch (IOException e) {
                     System.out.println(e.getMessage());
                     e.printStackTrace();
                 }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
