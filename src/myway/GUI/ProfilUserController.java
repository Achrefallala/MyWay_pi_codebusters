/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myway.GUI;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import myway.Entities.Utilisateur;
import myway.Services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author baghd
 */
public class ProfilUserController implements Initializable {

    @FXML
    private Button ModifierID;
    @FXML
    private Button logout;
     @FXML
    private Button btnOpenimgFile;
      @FXML
    private ImageView ivFiles;
    @FXML
    private TextField numText;
    @FXML
    private TextField motText;
    @FXML
    private TextField mailText;
    @FXML
    private TableView<Utilisateur> table;
    @FXML
    private TableColumn<Utilisateur,Integer> numCol;
    @FXML
    private TableColumn<Utilisateur,String> motCol;
    @FXML
    private TableColumn<Utilisateur,String> e_mailCol;
    
    final FileChooser fc = new FileChooser();
    ServiceUtilisateur ss= new ServiceUtilisateur();
    List<Utilisateur> stat=ss.afficher2();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        table2();
       
        logout.setOnAction((event)->{
        
        try{
            FXMLLoader loader = new FXMLLoader (getClass().getResource("LoginFXML.fxml"));
            Parent root = loader.load();
            logout.getScene().setRoot(root);
        }
        catch (IOException ex){
            System.out.print(ex.getMessage());
            System.out.println("erreur");
        }// TODO
    });
        
       
    }   
    
    
    public void table2 (){
          List<Utilisateur> stat;
        stat = ss.afficher();
        ObservableList<Utilisateur> listStat = FXCollections.observableArrayList(stat);
        numCol.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
       motCol.setCellValueFactory(new PropertyValueFactory<>("motdepasse"));
       e_mailCol.setCellValueFactory(new PropertyValueFactory<>("e_mail"));
       
        table.setItems(listStat);
        // TODO
        
    
}
   /* @FXML
     private void modifier(ActionEvent event) {
      
            int myIndex = Utilisateur.getSelectionModel.getSelectedIndex();
            int id = Integer.parseInt(String.valueOf(Utilisateur.getItems.get(myIndex).getId()));
             
            String num_tel = numCol.getText();
            String motdepasse = motCol.getText();
           
       
            
            Utilisateur r = new Utilisateur(id,num_tel,motdepasse );
            ss.modifier(r);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reclamation update");

            alert.setHeaderText("complaint update");
            alert.setContentText("Updated!");

            alert.showAndWait();
            table();
        
    }*/

    /*@FXML
    private void ModifierAction(ActionEvent event) {
       if (table.getSelectionModel().getSelectedItem()== null ){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("Please select from the table");
           alert.showAndWait();
        }else{
            Utilisateur s = new Utilisateur();
            
             int x=Integer.parseInt(numText.getText());
              s.setNum_tel(x);
             
             //s.setMotdepasse(motText.getText());
            // String motdepasse=s.getMotdepasse();
              
              
              
            
             ss.modifier2(s);
         
             
       }
        
        
    }
*/
    
@FXML
     private void modifier(ActionEvent event) {
      
            int myIndex = table.getSelectionModel().getSelectedIndex();
            int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
             
            int num_tel = Integer.parseInt(String.valueOf(numText.getText()));
            String motdepasse = motText.getText();
            String e_mail = mailText.getText();

            
            Utilisateur r = new Utilisateur(id,num_tel,motdepasse, e_mail);
            ss.modifier2(r);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("profil update");

            alert.setHeaderText("complaint update");
            alert.setContentText("Updated!");

            alert.showAndWait();
            table2();
        
    }
     
    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
        int index = -1;
        index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        numText.setText(numCol.getCellData(index).toString());
       motText.setText(motCol.getCellData(index));
        mailText.setText(e_mailCol.getCellData(index));
        
    }
    
   @FXML
    private void handleOpenimgFile(ActionEvent event){
        fc.setTitle("my file chooser");
        fc.setInitialDirectory(new File (System.getProperty("user.home")));
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png","*.jpg","*.gif"));
        File file =fc.showOpenDialog(null);
        if (file!= null){
            ivFiles.setImage(new Image(file.toURI().toString()));
        }
        else {
            System.out.println("A file is invalid!");
        }
    }
    
 
}
/*package myway.GUI;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import myway.Entities.SingleMail;
import myway.Entities.Utilisateur;
import myway.Services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author baghd
 */
/*public class ProfilUserController implements Initializable {

    @FXML
    private Button ModifierID;
    @FXML
    private Button logout;
     @FXML
    private Button btnOpenimgFile;
      @FXML
    private ImageView ivFiles;
    @FXML
    private TextField numText;
    @FXML
    private TextField motText;
    @FXML
    private TextField mailText;
    @FXML
    private TableView<Utilisateur> table;
    @FXML
    private TableColumn<Utilisateur,Integer> numCol;
    @FXML
    private TableColumn<Utilisateur,String> motCol;
    @FXML
    private TableColumn<Utilisateur,String> e_mailCol;
    
    
    ServiceUtilisateur sf = new ServiceUtilisateur();
    SingleMail smail = SingleMail.getInstance();
    
    String mial =  smail.getMail();
    Utilisateur fr =new Utilisateur();


    final FileChooser fc = new FileChooser();
    ServiceUtilisateur ss= new ServiceUtilisateur();
    List<Utilisateur> stat=ss.afficher2();

    /**
     * Initializes the controller class.
     */
   /* @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        fr = sf.getUserByEmail(mial);
        initCol();
        System.out.println(" show me  "+  mial);
        
        */
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        table2();
       
        logout.setOnAction((event)->{
        
        try{
            FXMLLoader loader = new FXMLLoader (getClass().getResource("LoginFXML.fxml"));
            Parent root = loader.load();
            logout.getScene().setRoot(root);
        }
        catch (IOException ex){
            System.out.print(ex.getMessage());
            System.out.println("erreur");
        }// TODO
    });
        
        
 
       
    }   
    private void initCol() {
        
mailText.setText(fr.getE_mail());

numText.setText(String.valueOf(fr.getNum_tel()));

motText.setText(fr.getMotdepasse());
    }
    
     //private Stage getStage() {
       // return (Stage) mdp.getScene().getWindow();
   // }
    
    public void table2 (){
          List<Utilisateur> stat;
        //stat = ss.afficher1();
        stat = ss.afficher();
        ObservableList<Utilisateur> listStat = FXCollections.observableArrayList(stat);
        numCol.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
       motCol.setCellValueFactory(new PropertyValueFactory<>("motdepasse"));
       e_mailCol.setCellValueFactory(new PropertyValueFactory<>("e_mail"));
       
        table.setItems(listStat);
        // TODO
        
    
}
   /* @FXML
     private void modifier(ActionEvent event) {
      
            int myIndex = Utilisateur.getSelectionModel.getSelectedIndex();
            int id = Integer.parseInt(String.valueOf(Utilisateur.getItems.get(myIndex).getId()));
             
            String num_tel = numCol.getText();
            String motdepasse = motCol.getText();
           
       
            
            Utilisateur r = new Utilisateur(id,num_tel,motdepasse );
            ss.modifier(r);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reclamation update");

            alert.setHeaderText("complaint update");
            alert.setContentText("Updated!");

            alert.showAndWait();
            table();
        
    }*/

    /*@FXML
    private void ModifierAction(ActionEvent event) {
       if (table.getSelectionModel().getSelectedItem()== null ){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("Please select from the table");
           alert.showAndWait();
        }else{
            Utilisateur s = new Utilisateur();
            
             int x=Integer.parseInt(numText.getText());
              s.setNum_tel(x);
             
             //s.setMotdepasse(motText.getText());
            // String motdepasse=s.getMotdepasse();
              
              
              
            
             ss.modifier2(s);
         
             
       }
        
        
    }
*/
    /*
@FXML
     private void modifier(ActionEvent event) {
      
            int myIndex = table.getSelectionModel().getSelectedIndex();
            int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
             
            int num_tel = Integer.parseInt(String.valueOf(numText.getText()));
            String motdepasse = motText.getText();
            String e_mail = mailText.getText();

            
            Utilisateur r = new Utilisateur(id,num_tel,motdepasse, e_mail);
            ss.modifier2(r);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("profil update");

            alert.setHeaderText("complaint update");
            alert.setContentText("Updated!");

            alert.showAndWait();
            table2();
        
    }
     
   /* @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
        int index = -1;
        index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        numText.setText(numCol.getCellData(index).toString());
       motText.setText(motCol.getCellData(index));
        mailText.setText(e_mailCol.getCellData(index));
        
    }
    */
   /*@FXML
    private void handleOpenimgFile(ActionEvent event){
        fc.setTitle("my file chooser");
        fc.setInitialDirectory(new File (System.getProperty("user.home")));
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png","*.jpg","*.gif"));
        File file =fc.showOpenDialog(null);
        if (file!= null){
            ivFiles.setImage(new Image(file.toURI().toString()));
        }
        else {
            System.out.println("A file is invalid!");
        }
    }
    
    /*@FXML
     public void uploadImage(ActionEvent event) throws FileNotFoundException, IOException {
        FileChooser fc = new FileChooser();
        //fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", listFichier));
        File f = fc.showOpenDialog(null);
        if (f != null) {

            //Commentaire.setText("Image selectionnée" + f.getAbsolutePath());
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(new File(f.getAbsolutePath()));
//             
                os = new FileOutputStream(new File("C:\\Users\\baghd\\Downloads\\myway\\myway\\src\\images" + f.getName()));
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                System.out.println("Malek");

            } finally {
                is.close();
                os.close();

            }

            File file = new File("C:\\Users\\baghd\\Downloads\\myway\\myway\\src\\images" + f.getName());
//            System.out.println(file.toURI().toString());
            ivFiles.setImage(new Image(file.toURI().toString()));
           //Imguser = f.getName();
            System.out.println(btnOpenimgFile);
           // ImageName.setText(Imguser);
        } else if (f == null) {
            //Commentaire.setText("Erreur chargement de l'image");
            System.out.println("Erreur !");
        }

    }*/
    
    
    
   /* @FXML
    private void handleEdit(ActionEvent event) {

String ma=  mailText.getText();

 int te = Integer.parseInt( numText.getText());
 
 String md = motText.getText();
 Utilisateur us = new Utilisateur(fr.getId() , ma, md,te);
        System.out.println( "the name we put  "+ us.toString() + " the Original Name  " + fr.toString());
    try {
            sf.modifier(us);

       initCol(); 
    }catch(Exception e){ System.out.println(e.getMessage()); }
    JOptionPane.showMessageDialog(null, " Success");
    
    
    }
}
*/