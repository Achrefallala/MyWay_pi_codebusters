/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import tests.NewFXMain;
import tn.esprit.entity.Linge;
import tn.esprit.entity.Moyentp;
import tn.esprit.entity.Trajet;
import tn.esprit.services.LingeService;
import tn.esprit.services.MoyentpService;
import tn.esprit.services.TrajetService;

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
     MoyentpService cc = new MoyentpService();
     TrajetService dd = new TrajetService();
    @FXML
    private TextField recherche;
    
     List<Linge> lig = ss.getAll();
     List<Moyentp>mp=cc.getAll();
       List<Trajet> taj= dd.getAll();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // List<Linge> lig;
        //lig = ss.getAll();
        ObservableList<Linge> listLig = FXCollections.observableArrayList(lig);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        moyenCol.setCellValueFactory(new PropertyValueFactory<>("id_moyentp"));

        trajetCol.setCellValueFactory(new PropertyValueFactory<>("id_trajet"));
        
       TableColumn<Linge, String> dureeColumn = new TableColumn<>("nom");
    dureeColumn.setCellValueFactory(cellData -> {
        Linge l = cellData.getValue();
        Moyentp moy = getMoyenBYId(l.getId_moyentp());
        if (moy != null) {
            return new SimpleStringProperty(moy.getNom());
        } else {
            return new SimpleStringProperty("");
        }
    });
    table.getColumns().add(dureeColumn);

    
    
     TableColumn<Linge, String> trajetColumn = new TableColumn<>("destination");
    trajetColumn.setCellValueFactory(cellData -> {
        Linge d = cellData.getValue();
        Trajet taj = getTrajetBYId(d.getId_trajet());
        if (taj != null) {
            return new SimpleStringProperty(taj.getDestination());
        } else {
            return new SimpleStringProperty("");
        }
    });
    table.getColumns().add(trajetColumn);
   

        table.setItems(listLig);
    }    
private Moyentp getMoyenBYId(String id){
    for (Moyentp m :mp ){
        if(m.getMatricule().equals(id)){
            return m;
        }
                }
    return null;
}
 

private Trajet getTrajetBYId(int id){
for (Trajet t:taj ){
    if(t.getId()==id){
        return t;
}
}
return null;
}
    @FXML
    private void AjouterAction(ActionEvent event) {
        
        List<Linge> List;
        
            if(isInputValid()){
        Linge s= new Linge();
       
       
       
        
          s.setId_moyentp(TextMoyen.getText());
         int y=Integer.parseInt(TextTrajet.getText());
        s.setId_trajet(y);
        
          
          
        ss.ajouter(s);
        reset();
         List = FXCollections.observableList(ss.getAll());
                table.setItems((ObservableList<Linge>) List);
                 Notifications.create()
            .title("New Ligne Added")
            .text("A new Ligne has been added successfully!")
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
         
            s.setId_moyentp(TextMoyen.getText());
             String moyentpid=s.getId_moyentp();
         
         
          int y=Integer.parseInt(TextTrajet.getText());
         s.setId_trajet(x);
         
         
         
          ss.modifier(y,s);
           Notifications.create()
            .title("New Ligne Updated")
            .text("A new Ligne has been updated successfully!")
            .showInformation();
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
      Notifications.create()
            .title("New Linge deleted")
            .text("A new Linge has been deleted successfully!")
            .showInformation();
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
    

