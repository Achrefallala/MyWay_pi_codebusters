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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import myway.Entities.Etablissement;
import myway.Entities.Trajet;
import myway.Services.ServiceTrajet;

/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class ModifierEtablissementFXMLController implements Initializable {
    
    Etablissement etablissement;

    @FXML
    private TextField tfType;
    @FXML
    private TextField tfNom;
    @FXML
    private TextArea tfDescription;
    @FXML
    private ChoiceBox<Trajet> cbSelectTrajet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceTrajet st = new ServiceTrajet();
        ObservableList<Trajet> listeTrajet = FXCollections.observableArrayList(st.display());
        cbSelectTrajet.setItems(listeTrajet);
    }  
    
    
    public void setEtablissement(Etablissement e){
        this.etablissement = e;
        tfNom.setText(e.getNom());
        tfType.setText(e.getType());
        tfDescription.setText(e.getDescription());
        cbSelectTrajet.setValue((e.getTrajet()));
  
    }
    
    public Etablissement getEtablissement(){
        etablissement.setNom(tfNom.getText());
        etablissement.setType(tfType.getText());
        etablissement.setDescription(tfDescription.getText());
        etablissement.setTrajet(cbSelectTrajet.getValue());
       return etablissement;
    }
}
