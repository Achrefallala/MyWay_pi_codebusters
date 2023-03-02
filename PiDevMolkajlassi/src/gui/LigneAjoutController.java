/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Notifications;
import tn.esprit.entity.Linge;
import tn.esprit.entity.Moyentp;
import tn.esprit.services.LingeService;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class LigneAjoutController implements Initializable {

    @FXML
    private TextField TextId;
    @FXML
    private TextField TextMoyen;
    @FXML
    private TextField TextTrajet;
    @FXML
    private Button AjouterID;
    @FXML
    private Button ModifierID;
    @FXML
    private Button SupprimerID;
    @FXML
    private TableView<Linge> table;
    @FXML
    private TableColumn<Linge,Integer> idCol;
    @FXML
    private TableColumn<Linge,String> moyenCol;
    @FXML
    private TableColumn<Linge,Integer> trajetCol;
    LingeService ss = new LingeService();
    @FXML
    private TextField recherche;
    
     List<Linge> lig = ss.getAll();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // List<Linge> lig;
        //lig = ss.getAll();
        ObservableList<Linge> listLig = FXCollections.observableArrayList(lig);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        moyenCol.setCellValueFactory(new PropertyValueFactory<>("moyentpid"));
        trajetCol.setCellValueFactory(new PropertyValueFactory<>("trajetid"));
       
        table.setItems(listLig);
    }    

    @FXML
    private void AjouterAction(ActionEvent event) {
        
        List<Linge> List;
        
            if(isInputValid()){
        Linge s= new Linge();
       
       
       
         int x=Integer.parseInt(TextId.getText());
        s.setId(x);
          s.setMoyentpid(TextMoyen.getText());
         int y=Integer.parseInt(TextTrajet.getText());
        s.setTrajetid(y);
        
          
          
        ss.ajouter(s);
        reset();
         List = FXCollections.observableList(ss.getAll());
                table.setItems((ObservableList<Linge>) List);
                 Notifications.create()
            .title("New Linge Added")
            .text("A new Linge has been added successfully!")
            .showInformation();
        
    }
    }
    
      private void reset() {
      
      TextId.setText("");
      TextMoyen.setText("");
      TextTrajet.setText("");
      
      
    }

    @FXML
    private void ModifierAction(ActionEvent event) {
        List<Linge> List;
        
            if(isInputValid()){
            
        Linge s= new Linge();
        
          int x=Integer.parseInt(TextId.getText());
         s.setId(x);
         
            s.setMoyentpid(TextMoyen.getText());
             String moyentpid=s.getMoyentpid();
         
         
          int y=Integer.parseInt(TextTrajet.getText());
         s.setTrajetid(x);
         
         
         
          ss.modifier(y,s);
         reset();
          List = FXCollections.observableList(ss.getAll());
                table.setItems((ObservableList<Linge>) List);
        
    }
        
        
    }

    @FXML
    private void SupprimerAction(ActionEvent event) {
        
         List<Linge> List;
        
        
        
           if (null== table.getSelectionModel().getSelectedItem() ){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("choisir une ligne");
           alert.showAndWait();
           }else{
        Linge clicked = table.getSelectionModel().getSelectedItem();
        Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("supprimer?");
           alert.showAndWait();
       
        //System.out.println(clicked);
     ss.supprimer(clicked);
                //updating user data after closing popup
                List = FXCollections.observableList(ss.getAll());
                table.setItems((ObservableList<Linge>) List);
    
           }
    }
        @FXML
   private void recherche(KeyEvent event) {
     String searchText = recherche.getText() + event.getText();
    ObservableList<Linge> filteredAbonnements = FXCollections.observableArrayList();
    for (Linge ligne : lig) {
        if (String.valueOf(ligne.getId()).contains(searchText) || String.valueOf(ligne.getId()).contains(searchText)) {
            filteredAbonnements.add(ligne);
        }
    }
    table.setItems(filteredAbonnements);
    }
         @FXML
    public void getSelected(MouseEvent event){
        int index = -1;
        index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        TextId.setText(idCol.getCellData(index).toString());
        TextMoyen.setText(moyenCol.getCellData(index));
        TextTrajet.setText(trajetCol.getCellData(index).toString());
        
        
    }
    
     private boolean isInputValid() {
        String errorMessage = "";
        
        if (TextId.getText() == null || TextId.getText().isEmpty() || !TextId.getText().matches("\\d+") || Integer.parseInt(TextId.getText()) <= 0) {
    errorMessage += "Invalide id!\n";
}

        if (TextMoyen.getText() == null || TextMoyen.getText().length() == 0  || TextMoyen.getText().matches("[0-9]+") ) {
            errorMessage += "Invalide moyen!\n"; 
        }
      

      if (TextTrajet.getText() == null || TextTrajet.getText().isEmpty() || !TextTrajet.getText().matches("\\d+") || Integer.parseInt(TextTrajet.getText()) <= 0) {
    errorMessage += "Invalide Trajet!\n";
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
    }
    

