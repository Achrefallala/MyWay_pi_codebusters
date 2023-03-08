/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Myway.GUI;

import javafx.event.ActionEvent;

import Myway.Entities.Reclamation;
import Myway.Services.ServiceReclamation;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author mbark
 */
public class AjouterReclamationController implements Initializable {
    
 
    
    @FXML
    private TextField tfmessage;
    @FXML
    private TextField NomTXFLD;
    @FXML
    private TextField PrenomTXFLD;
    @FXML
    private TextField categorieTXFLD;
    
    @FXML
    private Button myButton;
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    
}
     
   /* @FXML
    private void ajouterr(ActionEvent event) {
    
        
        String message = tfmessage.getText();
        
        String nom = NomTXFLD.getText();
        String prenom = PrenomTXFLD.getText();
        String categorie = categorieTXFLD.getText();

        if (message.isEmpty() || nom.isEmpty() || prenom.isEmpty()|| categorie.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
        ServiceReclamation sp= new ServiceReclamation();
        Reclamation r = new Reclamation(message, nom, prenom,categorie);
           sp.add(r);
           
          tfmessage.setText("");
          NomTXFLD.setText("");
          PrenomTXFLD.setText("");
          categorieTXFLD.setText ("");
          
         
          
            

        }}*/
  
    @FXML
    private void ajouterReclamation(ActionEvent event) {

        if (isInputValid()) {
            
            
          String message = tfmessage.getText();
        
        String nom = NomTXFLD.getText();
        String prenom = PrenomTXFLD.getText();
        String categorie = categorieTXFLD.getText();

            //User u =new User(User.currenUserId, "sou");
           ServiceReclamation sp= new ServiceReclamation();
           Reclamation r = new Reclamation(message, nom, prenom,categorie);
           sp.add(r);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout d'une reclamation");
            alert.setHeaderText("Creation de la reclamation");
            alert.setContentText("reclamation crée!");
            alert.showAndWait();

          tfmessage.setText("");
          NomTXFLD.setText("");
          PrenomTXFLD.setText("");
          categorieTXFLD.setText ("");
          
           Notifications.create()
          .title("Notification")
          .text("Your complaint will soon be treated")
          .position(Pos.BOTTOM_RIGHT)
          .hideAfter(Duration.seconds(5))
          .showInformation();
           
            
        }

    }
    
    
    private boolean isInputValid() {
        String errorMessage = "";
       
        

        if (NomTXFLD.getText() == null || NomTXFLD.getText().length() == 0 ) {
            errorMessage += "Invalide nom!\n";
        }
        if (PrenomTXFLD.getText() == null || PrenomTXFLD.getText().length() == 0 ) {
            errorMessage += "Invalide prenom!\n";
        }
        if (categorieTXFLD.getText() == null || categorieTXFLD.getText().length() == 0 ) {
            errorMessage += "Invalide categorie!\n";
        }
        if (tfmessage.getText() == null || tfmessage.getText().length() == 0 ) {
            errorMessage += "Invalide message!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            
           
             
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);

            alert.setTitle("Invalide champs");
            alert.setHeaderText("***Please correct your items **");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            
            return false;
        }
    }
    
}
    
   
     /*@FXML
    private void ajouterr(ActionEvent event) {
         ServiceReclamation sp= new ServiceReclamation();
        Reclamation r = new Reclamation(tfmessage.getText(), NomTXFLD.getText(), PrenomTXFLD.getText(), categorieTXFLD.getText());
        sp.add(r);
    }*/
    
  
    

   

       
       
