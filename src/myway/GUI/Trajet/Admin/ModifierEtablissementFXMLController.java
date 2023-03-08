/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Trajet.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
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
    Trajet trajet = new Trajet();
    Etablissement etablissement;

    @FXML
    private TextField tfType;
    @FXML
    private TextField tfNom;
    @FXML
    private TextArea tfDescription;
    
    @FXML
    private Button btnSelectionner;
    @FXML
    private TextField tfTrajet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }  
    
    
    public void setEtablissement(Etablissement e){
        this.etablissement = e;
        tfNom.setText(e.getNom());
        tfType.setText(e.getType());
        tfDescription.setText(e.getDescription());
        trajet = etablissement.getTrajet();
        tfTrajet.setText(etablissement.getTrajet().getDepart() + "-->" + etablissement.getTrajet().getDestination());

    }
    
    public Etablissement getEtablissement(){
        etablissement.setNom(tfNom.getText());
        etablissement.setType(tfType.getText());
        etablissement.setDescription(tfDescription.getText());
        etablissement.setTrajet(trajet);
       return etablissement;
    }

    @FXML
    private void dialogSelectionnerTrajet(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectionnerTrajetFXML.fxml"));
        DialogPane paneModifierTrajet = loader.load();
        SelectionnerTrajetFXMLController selectionnerTrajetFXMLController = loader.getController();

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(paneModifierTrajet);
        dialog.setTitle("Selectionner un trajet");
        Optional<ButtonType> clickedButton = dialog.showAndWait();
        
        if (clickedButton.get() == ButtonType.OK) {
            trajet = selectionnerTrajetFXMLController.getTrajet();
            tfTrajet.setText(trajet.getDepart() + "-->" + trajet.getDestination());

        }
    }
}
