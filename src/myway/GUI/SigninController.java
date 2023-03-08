/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myway.GUI;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import myway.Entities.Utilisateur;
import myway.Services.ServiceUtilisateur;
import myway.Utils.MyDB;

/**
 * FXML Controller class
 *
 * @author baghd
 */
public class SigninController implements Initializable {
 /* private TextField tfnom;
    private TextField tfprenom;
     private TextField tfnum_tel;
    private PasswordField tfmotdepasse;
        private Label lresultat;*/
  
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
     ServiceUtilisateur ss= new ServiceUtilisateur();
    Connection   cnx = null ;
    PreparedStatement preparedStatement ;
    String query = null ;
    @FXML
    private Button Signin;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
     /* @FXML
    private void ajouter(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signin.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
    }*/
          @FXML
    void ajouter(ActionEvent event) throws IOException {
        
            if(isInputValid()){
        Utilisateur s=new  Utilisateur();
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
        
    }}
    private boolean isInputValid() {
        String errorMessage = "";
        
        if (nom.getText() == null || nom.getText().isEmpty()) {
    errorMessage += "Invalide !\n";
}

        if (prenom.getText() == null || prenom.getText().isEmpty() ) {
            errorMessage += "Invalide !\n"; 
        }
      

      if (e_mail.getText() == null || e_mail.getText().isEmpty() || !e_mail.getText().contains("@")||!e_mail.getText().contains(".")) {
    errorMessage += "Invalide !\n";
}

       if (num_tel.getText() == null || num_tel.getText().isEmpty() || num_tel.getText().length()!=8) {
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
            alert.setHeaderText("***Please correct champs **");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
 
    /*void ajouter(MouseEvent event) {
             Connection   cnx = MyDB.getInstance().getCnx();

        String name = nom.getText();
        String prenome = prenom.getText();
        String num_tell = num_tel.getText();

        String motdepassee = motdepasse.getText();
            JOptionPane.showMessageDialog(null, "added");

        if (name.isEmpty() || prenome.isEmpty() || num_tell.isEmpty() || motdepassee.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
       ServiceUtilisateur su= new ServiceUtilisateur();
        Utilisateur p = new Utilisateur( name, prenome,num_tell, motdepassee);
           su.add(p);
      insert();
      getQuery();
    }

    }*/
    
   /* private void getQuery() {
                 
 
            
         String   query = "INSERT INTO `utilisateur`( `nom`, `prenom`, `num_tel`, `motdepasse`) VALUES(?,?,?,?)";

        }    

    private void insert() {
             try {

            preparedStatement = cnx.prepareStatement(query);
            preparedStatement.setString(1, nom.getText());
                        preparedStatement.setString(1, prenom.getText());
                                    preparedStatement.setString(1, num_tel.getText());
                                       preparedStatement.setString(1, motdepasse.getText());



                    
          
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(SigninController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    */
    
   /* void setTextField(int id, String name) {

        id = id;
        nom.setText(name);
        prenom.setText(prenome);
       

    }*/

  
   
 


}

    
   /* @FXML
       
       private void ajouter(ActionEvent event) {
    
       
        
        
        String nom = NomTXFLD.getText();
        String prenom = PrenomTXFLD.getText();
        String num_tel = num_telTXFLD.getText();

        String motdepasse = motdepasseTXFLD.getText();

        if (nom.isEmpty() || prenom.isEmpty() || num_tel.isEmpty() || motdepasse.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
        ServiceUtilisateur su= new ServiceUtilisateur();
        Utilisateur p = new Utilisateur( nom, prenom,num_tel, motdepasse);
           su.add(p);
            

        }}}*/
/*@FXML
    private void afficher(ActionEvent event) {
        
        ServiceUtilisateur su= new ServiceUtilisateur();
        lresultat.setText(su.afficher().toString());
       
    }*/
    

