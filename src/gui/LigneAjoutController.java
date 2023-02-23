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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          List<Linge> lig;
        lig = ss.getAll();
        ObservableList<Linge> listLig = FXCollections.observableArrayList(lig);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        moyenCol.setCellValueFactory(new PropertyValueFactory<>("moyentpid"));
        trajetCol.setCellValueFactory(new PropertyValueFactory<>("trajetid"));
       
        table.setItems(listLig);
    }    

    @FXML
    private void AjouterAction(ActionEvent event) {
        
        
         if (TextId.getText().isEmpty() || TextMoyen.getText().isEmpty() || TextTrajet.getText().isEmpty()){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("fill in all fields");
           alert.showAndWait();
        }else{
        Linge s= new Linge();
        //c.setIdCircuit((ifid.getText()));
       
         int x=Integer.parseInt(TextId.getText());
        s.setId(x);
          s.setMoyentpid(TextMoyen.getText());
         int y=Integer.parseInt(TextTrajet.getText());
        s.setTrajetid(y);
        
          
          
        ss.ajouter(s);
        reset();
        
    }
    }
    
      private void reset() {
      
      TextId.setText("");
      TextMoyen.setText("");
      TextTrajet.setText("");
      
    }

    @FXML
    private void ModifierAction(ActionEvent event) {
        
        if (table.getSelectionModel().getSelectedItem()== null ){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("Please select a ligne from the table");
           alert.showAndWait();
        }else{
        
    }
        
        
    }

    @FXML
    private void SupprimerAction(ActionEvent event) {
        
         List<Linge> List;
        
        
        
           if (null== table.getSelectionModel().getSelectedItem() ){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("Please select a Ligne from the table");
           alert.showAndWait();
           }else{
        Linge clicked = table.getSelectionModel().getSelectedItem();
        //System.out.println(clicked);
     ss.supprimer(clicked);
                //updating user data after closing popup
                List = FXCollections.observableList(ss.getAll());
                table.setItems((ObservableList<Linge>) List);
    
           }
    }
        
        
    }
    

