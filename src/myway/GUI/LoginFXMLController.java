package myway.GUI;

import java.awt.Button;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import myway.Utils.MyDB;


/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class LoginFXMLController implements Initializable {
    @FXML
    private AnchorPane labelG;
    @FXML
    private ImageView img;
    @FXML
    private javafx.scene.control.Label label;

    @FXML
    private javafx.scene.control.TextField textfield;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private javafx.scene.control.Button btnlogin;
     @FXML
    private javafx.scene.control.Button Sign;
    
     @FXML
    private Hyperlink hyperlink2;
    
       @FXML
    private Hyperlink hyperlink;
    
    Connection cnx = null;
    ResultSet rs = null;
    PreparedStatement pst = null ;
    
   
    
    
    @Override
       public void initialize(URL url, ResourceBundle rb) {
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
           
            hyperlink.setOnAction((event)->{
        
        try{
            FXMLLoader loader = new FXMLLoader (getClass().getResource("resetpassword.fxml"));
            Parent root = loader.load();
            hyperlink.getScene().setRoot(root);
        }
        catch (IOException ex){
            System.out.print(ex.getMessage());
            System.out.println("erreur");
        }// TODO
    } ); 
     
       }

      /* @FXML
private void login(MouseEvent event) throws IOException {
    cnx = (Connection) MyDB.getInstance().getCnx();
    String qry = "SELECT * FROM Utilisateur WHERE motdepasse = ? AND e_mail = ? AND isActive = ?";

        
    try{
         

        if (textfield.getText().isEmpty()  || passwordfield.getText().isEmpty()||!textfield.getText().contains("@")||!textfield.getText().contains(".")) {
        JOptionPane.showMessageDialog(null, "Veuillez verfier vos donnees");
        return;
        }
        //String userType = rs.getString("Type");
       pst = cnx.prepareStatement(qry);
       pst.setString(1, passwordfield.getText());
       pst.setString(2, textfield.getText());
       pst.setInt(3, 1);

        rs = pst.executeQuery();
        if(rs.next()) {
         String role = rs.getString("role");
        int isActive = rs.getInt("isActive");
        if(role.equals("user")) {
               btnlogin.getScene().getWindow().hide();
               Parent root = FXMLLoader.load(getClass().getResource("ProfilUser.fxml"));
               Stage mainStage = new Stage();
               Scene scene = new Scene(root);
               mainStage.setScene(scene);
               mainStage.show();
            }else if(role.equals("admin")){
                btnlogin.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("interfaceAdmin.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
            }else{
                JOptionPane.showMessageDialog(null, "user inconnu");
            }
            
        }else
            JOptionPane.showMessageDialog(null, "login failed");
                    
       
    }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }
}
*/

    @FXML
    private void login(MouseEvent event) throws IOException {
        cnx = (Connection) MyDB.getInstance().getCnx();
        String qry = "SELECT * FROM Utilisateur WHERE motdepasse = ? AND e_mail = ? AND isActive = ?";

            
        try{
             

            if (textfield.getText().isEmpty()  || passwordfield.getText().isEmpty()||!textfield.getText().contains("@")||!textfield.getText().contains(".")) {
            JOptionPane.showMessageDialog(null, "Veuillez verfier vos donnees");
            return;
            }
            //String userType = rs.getString("Type");
           pst = cnx.prepareStatement(qry);
           pst.setString(1, passwordfield.getText());
           pst.setString(2, textfield.getText());
        

            pst.setInt(3, 1);
            rs = pst.executeQuery();
            if(rs.next()) {
             String role = rs.getString("role");
            int isActive = rs.getInt("isActive");
            if(role.equals("user")) {
                   btnlogin.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                   Stage mainStage = new Stage();
                   Scene scene = new Scene(root);
                   mainStage.setScene(scene);
                   mainStage.show();
                }else if(role.equals("admin")){
                    btnlogin.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("interfaceAdmin.fxml"));
                    Stage mainStage = new Stage();
                    Scene scene = new Scene(root);
                    mainStage.setScene(scene);
                    mainStage.show();
                    
                }else{
                    JOptionPane.showMessageDialog(null, "user inconnu");
                }
                
            }else
                JOptionPane.showMessageDialog(null, "login failed");
                        
           
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    
    }
}