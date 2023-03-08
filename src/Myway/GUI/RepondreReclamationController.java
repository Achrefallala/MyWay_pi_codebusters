/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Myway.GUI;

import Myway.Entities.Reclamation;
import Myway.Entities.Reponse;
import Myway.Services.ServiceReponse;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author mbark
 */
public class RepondreReclamationController implements Initializable {

    /*@FXML
    private TextArea tfReponse;*/
    ServiceReponse sr = new ServiceReponse();
    @FXML
    private TableView<Reponse> reponseTable;
    @FXML
    private TableColumn<Reponse, Integer> idRepCol;
    @FXML
    private TableColumn<Reponse, Integer> idRecCol;
    @FXML
    private TableColumn<Reponse, String> reponseCol;
   
  
    @FXML
    private TextField txtreponse;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         back.setOnAction((event) -> {

                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherReclamation.fxml"));
                            Parent root = loader.load();
                            back.getScene().setRoot(root);
                        } catch (IOException ex) {
                            System.out.print(ex.getMessage());
                            System.out.println("wrong!!");
                        }

                    })
                ;
        // TODO
        table2();
    }    
    public void table2() {
        reponseTable.setItems(FXCollections.observableArrayList(sr.afficher()));
        
        idRepCol.setCellValueFactory(new PropertyValueFactory<>("id_reponse"));
        idRecCol.setCellValueFactory(new PropertyValueFactory<>("Id_rec"));
        reponseCol.setCellValueFactory(new PropertyValueFactory<>("reponse"));
      
        

        reponseTable.setRowFactory(tv -> {
            TableRow<Reponse> myRow = new TableRow<>();
            myRow.setOnMouseClicked((event)
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    int myIndex = reponseTable.getSelectionModel().getSelectedIndex();                                       
                    int id_rep = Integer.parseInt(String.valueOf(reponseTable.getItems().get(myIndex).getId_reponse()));
                    int Id_rec = Integer.parseInt(String.valueOf(reponseTable.getItems().get(myIndex).getId_rec()));

                    txtreponse.setText(reponseTable.getItems().get(myIndex).getReponse());
                    
                    
                   
                }
            });
            return myRow;
        });

    }
    
    @FXML
    private void supprimer(ActionEvent event) {
        
        int myIndex = reponseTable.getSelectionModel().getSelectedIndex();
        int id_rep = Integer.parseInt(String.valueOf(reponseTable.getItems().get(myIndex).getId_reponse()));
        
        if (null== reponseTable.getSelectionModel().getSelectedItem() ){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("Please select from table");
           alert.showAndWait();
        }else {
        
        sr.supprimerByid(id_rep);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("supprimer réclamation");
        table2();
        alert.setHeaderText("reclamation");
        alert.setContentText("Deleted!");

        alert.showAndWait();
    }}
    
     @FXML
     private void modifier(ActionEvent event) {
      
            int myIndex = reponseTable.getSelectionModel().getSelectedIndex();
            int id_rep = Integer.parseInt(String.valueOf(reponseTable.getItems().get(myIndex).getId_reponse()));
             
            String reponse = txtreponse.getText();
    
             Reponse r = new Reponse(id_rep,reponse);
            sr.modifier(r);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reponse update");

            alert.setHeaderText("response update");
            alert.setContentText("Updated!");

            alert.showAndWait();
            table2();
        
    }
    
    
}
