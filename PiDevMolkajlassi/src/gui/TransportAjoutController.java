/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
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
    @FXML
    private TextField recherche;
      List<Moyentp> stat = ss.getAll();
    @FXML
    private TableColumn<Moyentp, String> nomCol;
    @FXML
    private TextField TextNom;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // List<Moyentp> stat;
        //stat = ss.getAll();
        ObservableList<Moyentp> listStat = FXCollections.observableArrayList(stat);
        matriculeCol.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nbreplace"));
        prixCol.setCellValueFactory(new PropertyValueFactory<>("prix_ticket"));
        horaireCol.setCellValueFactory(new PropertyValueFactory<>("horaire"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        table.setItems(listStat);
    }    

    @FXML
    private void AjouterAction(ActionEvent event) {
        List<Moyentp> List;
       if (isInputValid()) {
        Moyentp s= new Moyentp();
       
        s.setMatricule(TextMatricule.getText());
        s.setType(TextType.getText());
         int x=Integer.parseInt(TextNombre.getText());
        s.setNbreplace(x);
         int y=Integer.parseInt(TextPrix.getText());
        s.setPrix_ticket(y);
        
          s.setHoraire(TextHoraire.getText());
          s.setNom(TextNom.getText());
          
        ss.ajouter(s);
        
        reset();
         List = FXCollections.observableList(ss.getAll());
                table.setItems((ObservableList<Moyentp>) List);
        
    }
    }
    
     private void reset() {
      
      TextMatricule.setText("");
      TextType.setText("");
      TextNombre.setText("");
      TextPrix.setText("");
      TextHoraire.setText("");
      TextNom.setText("");
      
    }

    @FXML
    private void ModifierAction(ActionEvent event) {
        List<Moyentp> List;
        
        if(isInputValid()){
              Moyentp s = new Moyentp();
             s.setMatricule(TextMatricule.getText());
             String matricule=s.getMatricule();
             
             
              s.setType(TextType.getText());
             String type=s.getType();
              
              int x=Integer.parseInt(TextNombre.getText());
              s.setNbreplace(x);
              
              
              int y=Integer.parseInt(TextPrix.getText());
              s.setPrix_ticket(y);
              
              
             
             s.setHoraire(TextHoraire.getText());
             String horaire=s.getHoraire();
             
             
             s.setNom(TextNom.getText());
             String nom=s.getNom();
             
            
             ss.modifier(type,x,y,horaire,nom,s);
             
             
         reset();
         List = FXCollections.observableList(ss.getAll());
                table.setItems((ObservableList<Moyentp>) List);
             
             
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
        Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("supprimer?");
           alert.showAndWait();
        //System.out.println(clicked);
     ss.supprimer(clicked);
                //updating user data after closing popup
                List = FXCollections.observableList(ss.getAll());
                table.setItems((ObservableList<Moyentp>) List);
    
           }
    }
    @FXML
   private void recherche(KeyEvent event) {
     String searchText = recherche.getText() + event.getText();
    ObservableList<Moyentp> filteredAbonnements = FXCollections.observableArrayList();
    for (Moyentp moyentp : stat) {
        if (String.valueOf(moyentp.getMatricule()).contains(searchText) || String.valueOf(moyentp.getMatricule()).contains(searchText)) {
            filteredAbonnements.add(moyentp);
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
        TextMatricule.setText(matriculeCol.getCellData(index));
        TextType.setText(typeCol.getCellData(index));
        TextNombre.setText(nombreCol.getCellData(index).toString());
        TextPrix.setText(prixCol.getCellData(index).toString());
        TextHoraire.setText(horaireCol.getCellData(index));
        TextNom.setText(horaireCol.getCellData(index));
        
    }
    
     private boolean isInputValid() {
        String errorMessage = "";

        if (TextMatricule.getText() == null || TextMatricule.getText().length() == 0  || TextMatricule.getText().matches("[0-9]+") ) {
            errorMessage += "Invalide Matricule!\n"; 
        }
       if (TextType.getText() == null || TextType.getText().isEmpty() || !TextType.getText().matches("metro|train|bus")) {
    errorMessage += "Invalide type!\n"; 
}

      if (TextNombre.getText() == null || TextNombre.getText().isEmpty() || !TextNombre.getText().matches("\\d+") || Integer.parseInt(TextNombre.getText()) <= 0) {
    errorMessage += "Invalide nombre de place!\n";
}

          if (TextPrix.getText() == null || TextPrix.getText().isEmpty() || !TextPrix.getText().matches("\\d+") || Integer.parseInt(TextPrix.getText()) <= 0) {
    errorMessage += "Invalide prix!\n";
}
        if (TextHoraire.getText() == null || TextHoraire.getText().length() == 0 || TextHoraire.getText().matches("[0-9]+")) {
            errorMessage += "Invalide horaire!\n"; 
        }
         if (TextNom.getText() == null || TextNom.getText().length() == 0 || TextNom.getText().matches("[0-9]+")) {
            errorMessage += "Invalide nom!\n"; 
        }
    
     if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            
            alert.setTitle("Invalide champs");
            alert.setHeaderText("***Please correct champs **");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
    
}
