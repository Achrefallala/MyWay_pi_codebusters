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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author mbark
 */
public class AjouterReclamationController implements Initializable {
    
    @FXML
    private TextField tfmessage;
    private TextField tfnom;
    private TextField tfprenom;
    @FXML
    private Button myButton;
    @FXML
    private TextField NomTXFLD;
    @FXML
    private TextField PrenomTXFLD;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    
}
     
    
     @FXML
    private void ajouterr(ActionEvent event) {
    
       
        String message = tfmessage.getText();
        
        String nom = NomTXFLD.getText();
        String prenom = NomTXFLD.getText();

        if (message.isEmpty() || nom.isEmpty() || prenom.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
        ServiceReclamation sp= new ServiceReclamation();
        Reclamation r = new Reclamation(message, nom, prenom);
           sp.add(r);
            

        }}}
    
      /*@FXML
        private void afficher(ActionEvent event) {
        
        ServiceReclamation s= new ServiceReclamation();
        lresultat.setText(s.afficher().toString());
       
    }*/

    /*@FXML
    private void ajouterr(ActionEvent event) {
         ServiceReclamation sp= new ServiceReclamation();
        Reclamation r = new Reclamation(tfmessage.getText(), NomTXFLD.getText(), PrenomTXFLD.getText());
        sp.add(r);
    }*/

       
       
