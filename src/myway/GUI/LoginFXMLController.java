/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myway.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import myway.Entities.Utilisateur;
import myway.Services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author baghd
 */
public class LoginFXMLController implements Initializable {
    
    private TextField tfnom;
    private TextField tfprenom;
    private PasswordField tfmotdepasse;
    private Label lresultat;
    @FXML
    private Button Login;
    @FXML
    private Button Sign;
    @FXML
    private Button profil;
     @FXML
    private Hyperlink mo;
     
    /* private Connection connect;
     private PreparedStatement statement;
     private ResultSet result;*/
   Connection con;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Initializes the controller class.
     * 
     */
    
     
   public void login (ActionEvent event){
        String nom= tfnom.getText();
        String prenom= tfprenom.getText();
        String motdepasse= tfmotdepasse.getText();
        
        if(nom.equals("")&& prenom.equals("")&& motdepasse.equals(""))
        {
            JOptionPane.showMessageDialog(null, "nom ou prenom ou mot de passe introuvable");
        }
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con= DriverManager.getConnection("jdbc:mysql://localhost/myway", "root","");
                pst= con.prepareStatement("select * from `utilisateur` where nom=? And prenom=? and motdepasse=?");
                pst.setString(1, nom);
                pst.setString(2, prenom);
                pst.setString(7, motdepasse);
                
                rs= pst.executeQuery();
                
                if(rs.next()){
                    
                    JOptionPane.showMessageDialog(null, "connexion réussie", "fatma", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    
                    JOptionPane.showMessageDialog(null, "echec d'authentification", "bgh", JOptionPane.ERROR_MESSAGE);
                    tfnom.setText("");
                    tfprenom.setText("");
                    tfmotdepasse.setText("");
                    tfnom.requestFocus();
                }
                        } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Login.setOnAction((event)->{
        
        try{
            FXMLLoader loader = new FXMLLoader (getClass().getResource("Home.fxml"));
            Parent root = loader.load();
            Login.getScene().setRoot(root);
        }
        catch (IOException ex){
            System.out.print(ex.getMessage());
            System.out.println("erreur");
        }
        
    });
         Sign.setOnAction((event)->{
        
        try{
            FXMLLoader loader = new FXMLLoader (getClass().getResource("Signin.fxml"));
            Parent root = loader.load();
            Sign.getScene().setRoot(root);
        }
        catch (IOException ex){
            System.out.print(ex.getMessage());
            System.out.println("erreur");
        }// TODO
    } );  
        
    }
  private void ajouter(ActionEvent event) {
 ServiceUtilisateur su = new ServiceUtilisateur();
 Utilisateur p = new Utilisateur( tfnom.getText(), tfprenom.getText(), tfmotdepasse.getText());
        su.add(p);
    }
    private void afficher(ActionEvent event) {
        
        ServiceUtilisateur su= new ServiceUtilisateur();
        lresultat.setText(su.afficher().toString());
       
    }
}
