/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myway.GUI;


import java.io.IOException;
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
import javafx.scene.input.KeyEvent;
import myway.Entities.Utilisateur;
import myway.Services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author baghd
 */
public class InterfaceAdminController implements Initializable {

    @FXML
    private TableView<Utilisateur> table;
    @FXML
    private TableColumn<Utilisateur,Integer> idCol;
    @FXML
    private TableColumn<Utilisateur,String> nomCol;
    @FXML
    private TableColumn<Utilisateur,String> prenomCol;
    @FXML
    private TableColumn<Utilisateur,Integer> numCol;
    @FXML
    private TableColumn<Utilisateur,String> e_mailCol;
     @FXML
    private TableColumn<Utilisateur,Integer> isActiveCol;
    ServiceUtilisateur ss= new ServiceUtilisateur();
    @FXML
    private Button SupprimerID;
    @FXML
    private Button logout;
    @FXML
    private TextField recherche;
    
    List<Utilisateur> stat=ss.afficher();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         List<Utilisateur> stat;
        stat = ss.afficher();
        ObservableList<Utilisateur> listStat = FXCollections.observableArrayList(stat);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
       numCol.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
       e_mailCol.setCellValueFactory(new PropertyValueFactory<>("e_mail"));
       isActiveCol.setCellValueFactory(new PropertyValueFactory<>("isActive"));

       
        table.setItems(listStat);
        
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

    @FXML
    private void SupprimerAction(ActionEvent event) {
        
        
         List<Utilisateur> List;
        
        
        
           if (null== table.getSelectionModel().getSelectedItem() ){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("Please select from table");
           alert.showAndWait();
           }else{
       Utilisateur clicked = table.getSelectionModel().getSelectedItem();
        //System.out.println(clicked);
     ss.supprimer(clicked);
                //updating user data after closing popup
                List = FXCollections.observableList(ss.afficher());
                table.setItems((ObservableList<Utilisateur>) List);
    
           }
    
    }
    
      @FXML
    private void Supprimer2Action(ActionEvent event) {
        
        
         List<Utilisateur> List;
        
        
        
           if (null== table.getSelectionModel().getSelectedItem() ){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("Please select from table");
           alert.showAndWait();
           }else{
       Utilisateur clicked = table.getSelectionModel().getSelectedItem();
        //System.out.println(clicked);
     ss.supprimer2(clicked);
                //updating user data after closing popup
                List = FXCollections.observableList(ss.afficher());
                table.setItems((ObservableList<Utilisateur>) List);
    
           }
    
    }
    
        @FXML
    private void AfficherAction(ActionEvent event) {
        
        
         List<Utilisateur> List;
        
        
         List<Utilisateur> stat;
        stat = ss.afficher();
        ObservableList<Utilisateur> listStat = FXCollections.observableArrayList(stat);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
       numCol.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
       e_mailCol.setCellValueFactory(new PropertyValueFactory<>("e_mail"));
       isActiveCol.setCellValueFactory(new PropertyValueFactory<>("isActive"));

       
        table.setItems(listStat);
          
       Utilisateur clicked = table.getSelectionModel().getSelectedItem();
        //System.out.println(clicked);
     ss.afficher3();
                //updating user data after closing popup
                List = FXCollections.observableList(ss.afficher3());
                table.setItems((ObservableList<Utilisateur>) List);
    
           
    
    }
    
         @FXML
    private void Afficher2Action(ActionEvent event) {
        
        
         List<Utilisateur> List;
        
        
         List<Utilisateur> stat;
        stat = ss.afficher();
        ObservableList<Utilisateur> listStat = FXCollections.observableArrayList(stat);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
       numCol.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
       e_mailCol.setCellValueFactory(new PropertyValueFactory<>("e_mail"));
       isActiveCol.setCellValueFactory(new PropertyValueFactory<>("isActive"));

       
        table.setItems(listStat);
          
       Utilisateur clicked = table.getSelectionModel().getSelectedItem();
        //System.out.println(clicked);
     ss.afficher4();
                //updating user data after closing popup
                List = FXCollections.observableList(ss.afficher4());
                table.setItems((ObservableList<Utilisateur>) List);
    
           
    
    }
   @FXML
   private void recherche(KeyEvent event) {
   String searchText = recherche.getText()+ event.getText();
     //String searchText = recherche.getText() ;
     
    ObservableList<Utilisateur> filteredAbonnements = FXCollections.observableArrayList();
        
    for (Utilisateur utilisateur : stat) {
        if (String.valueOf(utilisateur.getNom()).contains(searchText) || String.valueOf(utilisateur.getNom()).contains(searchText)) {
            filteredAbonnements.add(utilisateur);
        }
    }
    table.setItems(filteredAbonnements);
    }
   
   
}
