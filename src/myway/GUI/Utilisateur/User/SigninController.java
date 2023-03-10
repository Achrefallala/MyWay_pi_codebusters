/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Utilisateur.User;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import myway.Entities.Utilisateur;
import myway.Services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class SigninController implements Initializable {

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;
    @FXML
    private TextField e_mail;

    @FXML
    private TextField num_tel;

    @FXML
    private PasswordField motdepasse;
    ServiceUtilisateur ss = new ServiceUtilisateur();
    Connection cnx = null;
    PreparedStatement preparedStatement;
    String query = null;
    @FXML
    private Button Signin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    void ajouter(ActionEvent event) throws IOException {

        if (isInputValid()) {
            
            Utilisateur s = new Utilisateur();
            s.setNom(nom.getText());
            s.setPrenom(prenom.getText());
            s.setE_mail(e_mail.getText());
            int x = Integer.parseInt(num_tel.getText());
            s.setNum_tel(x);
            s.setMotdepasse(motdepasse.getText());
            Signin.getScene().getWindow().hide();
            
            Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();

            ss.add(s);

        }
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (nom.getText() == null || nom.getText().isEmpty()) {
            errorMessage += "Invalide !\n";
        }

        if (prenom.getText() == null || prenom.getText().isEmpty()) {
            errorMessage += "Invalide !\n";
        }

        if (e_mail.getText() == null || e_mail.getText().isEmpty() || !e_mail.getText().contains("@") || !e_mail.getText().contains(".")) {
            errorMessage += "Invalide !\n";
        }

        if (num_tel.getText() == null || num_tel.getText().isEmpty() || num_tel.getText().length() != 8) {
            errorMessage += "Invalide !\n";
        }

        if (motdepasse.getText() == null || motdepasse.getText().isEmpty()) {
            errorMessage += "Invalide !\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Invalide champs");
            alert.setHeaderText("**Please correct champs *");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
