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
import javafx.scene.input.MouseEvent;
import tn.esprit.entity.Moyentp;
import tn.esprit.services.MoyentpService;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class TransportAjoutController implements Initializable {

    @FXML
    private TextField TextMatricule;
    @FXML
    private TextField TextType;
    @FXML
    private TextField TextNombre;
    @FXML
    private TextField TextPrix;
    @FXML
    private TextField TextHoraire;
    @FXML
    private Button AjouterID;
    @FXML
    private Button ModifierID;
    @FXML
    private Button SupprimerID;
    @FXML
    private TableColumn<Moyentp,String> matriculeCol;
    @FXML
    private TableColumn<Moyentp,String> typeCol;
    @FXML
    private TableColumn<Moyentp,Integer> nombreCol;
    @FXML
    private TableColumn<Moyentp,Integer> prixCol;
    @FXML
    private TableColumn<Moyentp,String> horaireCol;
     MoyentpService ss = new MoyentpService();
    @FXML
    private TableView<Moyentp> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         List<Moyentp> stat;
        stat = ss.getAll();
        ObservableList<Moyentp> listStat = FXCollections.observableArrayList(stat);
        matriculeCol.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nbreplace"));
        prixCol.setCellValueFactory(new PropertyValueFactory<>("prix_ticket"));
        horaireCol.setCellValueFactory(new PropertyValueFactory<>("horaire"));
        table.setItems(listStat);
    }    

    @FXML
    private void AjouterAction(ActionEvent event) {
        if (TextMatricule.getText().isEmpty() || TextType.getText().isEmpty() || TextNombre.getText().isEmpty() || TextPrix.getText().isEmpty()|| TextHoraire.getText().isEmpty()){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("fill in all fields");
           alert.showAndWait();
        }else{
        Moyentp s= new Moyentp();
        //c.setIdCircuit((ifid.getText()));
        s.setMatricule(TextMatricule.getText());
        s.setType(TextType.getText());
         int x=Integer.parseInt(TextNombre.getText());
        s.setNbreplace(x);
         int y=Integer.parseInt(TextPrix.getText());
        s.setPrix_ticket(y);
        
          s.setHoraire(TextHoraire.getText());
          
        ss.ajouter(s);
        reset();
        
    }
    }
    
     private void reset() {
      
      TextMatricule.setText("");
      TextType.setText("");
      TextNombre.setText("");
      TextPrix.setText("");
      TextHoraire.setText("");
      
    }

    @FXML
    private void ModifierAction(ActionEvent event) {
        
         if (table.getSelectionModel().getSelectedItem()== null ){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("Please select a transport from the table");
           alert.showAndWait();
        }else{
             
            
             
         }
    }

    @FXML
    private void SupprimerAction(ActionEvent event) {
        List<Moyentp> List;
        
        
        
           if (null== table.getSelectionModel().getSelectedItem() ){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("Please select a transport from the table");
           alert.showAndWait();
           }else{
        Moyentp clicked = table.getSelectionModel().getSelectedItem();
        //System.out.println(clicked);
     ss.supprimer(clicked);
                //updating user data after closing popup
                List = FXCollections.observableList(ss.getAll());
                table.setItems((ObservableList<Moyentp>) List);
    
           }
    }
    
    
}
