/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myway.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import myway.Entities.Utilisateur;
import myway.Services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author baghd
 */
public class ProfilUserController implements Initializable {
    
    private TextField tfnom;
    private TextField tfprenom;
    private TextField tfnum_tel;
    private PasswordField tfmotdepasse;
    private Label lresultat;
     @FXML
    private Button logout;
     @FXML
    private Button modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         logout.setOnAction((event)->{
        
        try{
            FXMLLoader loader = new FXMLLoader (getClass().getResource("LoginFXML.fxml"));
            Parent root = loader.load();
            logout.getScene().setRoot(root);
        }
        catch (IOException ex){
            System.out.print(ex.getMessage());
            System.out.println("erreur");
        }
        
    });
        // TODO
    }   
     private void modifier(ActionEvent event) {
 ServiceUtilisateur su = new ServiceUtilisateur();
 Utilisateur p = new Utilisateur( tfnom.getText(), tfprenom.getText(),tfnum_tel.getText(), tfmotdepasse.getText());
        su.modifier(p);
    }
      private void afficher(ActionEvent event) {
        
        ServiceUtilisateur su= new ServiceUtilisateur();
        lresultat.setText(su.afficher().toString());
       
    }
}
