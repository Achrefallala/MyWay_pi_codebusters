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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import myway.Entities.Utilisateur;
import myway.Services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author baghd
 */
public class SigninController implements Initializable {
  private TextField tfnom;
    private TextField tfprenom;
     private TextField tfnum_tel;
    private PasswordField tfmotdepasse;
        private Label lresultat;

    @FXML
    private Button Singin;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
      @FXML
    private void ajouter(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signin.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
    }
    private void afficher(ActionEvent event) {
        
        ServiceUtilisateur su= new ServiceUtilisateur();
        lresultat.setText(su.afficher().toString());
       
    }
    
}
