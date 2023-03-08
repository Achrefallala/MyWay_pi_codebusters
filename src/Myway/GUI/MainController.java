/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Myway.GUI;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;    
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

/**
 * FXML Controller class
 *
 * @author mbark
 */
public class MainController implements Initializable {


    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button ajouter;
    @FXML
    private Button afficher;

    public void switchToScene1(ActionEvent event) throws IOException {
     //   root = FXMLLoader.load(getClass().getResource("AjouterReclamation.fxml"));
       
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ajouter.setOnAction((event) -> {

                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterReclamation.fxml"));
                            Parent root = loader.load();
                            ajouter.getScene().setRoot(root);
                        } catch (IOException ex) {
                            System.out.print(ex.getMessage());
                            System.out.println("wrong!!");
                        }

                    })
                ;
        afficher.setOnAction((event) -> {

                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherReclamation.fxml"));
                            Parent root = loader.load();
                            afficher.getScene().setRoot(root);
                        } catch (IOException ex) {
                            System.out.print(ex.getMessage());
                            System.out.println("wrong!!");
                        }

                    })        
                ;
        

    }

}
