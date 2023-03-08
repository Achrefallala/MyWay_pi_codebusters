/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Trajet.Admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import myway.Entities.Trajet;
import myway.Services.ServiceTrajet;

/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class SelectionnerTrajetFXMLController implements Initializable {
    

    @FXML
    private TableView<Trajet> tableTrajet;
    @FXML
    private TableColumn<Trajet, String> columnDepart;
    @FXML
    private TableColumn<Trajet, String> columnDestination;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceTrajet st = new ServiceTrajet();
        ObservableList<Trajet> listeTrajet = FXCollections.observableArrayList(st.display());
        columnDepart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        columnDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        tableTrajet.setItems(listeTrajet);
    }

    public Trajet getTrajet(){
        if (tableTrajet.getSelectionModel().getSelectedItem() != null){
            Trajet t = tableTrajet.getSelectionModel().getSelectedItem();
        return t;
        }
        return new Trajet();
        
    }    
    
}
