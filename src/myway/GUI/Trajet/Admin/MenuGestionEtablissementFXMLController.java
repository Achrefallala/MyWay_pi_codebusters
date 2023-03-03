/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Trajet.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import myway.Entities.Etablissement;
import myway.Entities.Trajet;
import myway.Services.ServiceEtablissement;
import myway.Services.ServiceTrajet;

/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class MenuGestionEtablissementFXMLController implements Initializable {

    @FXML
    private TableColumn<Etablissement, Integer> columnId;
    @FXML
    private TableColumn<Etablissement, String> columnNom;
    @FXML
    private TableColumn<Etablissement, String> columnType;
    @FXML
    private TableColumn<Etablissement, String> columnDescription;
    @FXML
    private TableColumn<?, ?> columnTrajet;
    @FXML
    private TableColumn<Etablissement, String> columnDepart;
    @FXML
    private TableColumn<Etablissement, String> columnDestination;
    @FXML
    private TableView<Etablissement> tableListeEtablissement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceEtablissement se = new ServiceEtablissement();
        ObservableList<Etablissement> listeEtablissement = FXCollections.observableArrayList(se.display());

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        columnDepart.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTrajet().getDepart()));
        columnDestination.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTrajet().getDestination()));

        tableListeEtablissement.setItems(listeEtablissement);
    }

    @FXML
    private void dialogAjouterEtablissement(ActionEvent event) throws IOException {
        int etat = 0;
        Trajet trajet = new Trajet();
        Etablissement etablissement = new Etablissement("", "", "", trajet);
        ServiceEtablissement se = new ServiceEtablissement();
        while (etat == 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterEtablissementFXML.fxml"));
            DialogPane paneAjouterTrajet = loader.load();
            AjouterEtablissementFXMLController ajouterEtablissementFXMLController = loader.getController();
            ajouterEtablissementFXMLController.setEtablissement(etablissement);

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(paneAjouterTrajet);
            dialog.setTitle("Ajouter un etablissement");
            Optional<ButtonType> clickedButton = dialog.showAndWait();

            if (clickedButton.get() == ButtonType.OK) {

                etablissement = ajouterEtablissementFXMLController.getEtablissement();
                if ("".equals(etablissement.getNom()) || "".equals(etablissement.getType()) || "".equals(etablissement.getDescription()) || etablissement.getTrajet().getDepart() == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Les champs ne doivent pas être vide");
                    alert.showAndWait();

                } else if (etablissement.getNom().matches("^[a-zA-Z0-9]*$") == false) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Le nom ne peut pas contenir des caractères spéciaux");
                    alert.showAndWait();

                } else if (se.exist(etablissement) == true) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("L'etablissement exist deja");
                    alert.showAndWait();

                } else {
                    etat = 1;
                }

            } else {
                etat = 2;
            }
        }
        if (etat == 1) {

            se.add(etablissement);

            ObservableList<Etablissement> listeEtablissement = FXCollections.observableArrayList(se.display());
            columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
            columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            columnDepart.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTrajet().getDepart()));
            columnDestination.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTrajet().getDestination()));
            tableListeEtablissement.setItems(listeEtablissement);
        }
    }

    @FXML
    private void dialogModifierEtablissement(ActionEvent event) throws IOException {
        if (tableListeEtablissement.getSelectionModel().getSelectedItem() != null) {
            int etat = 0;
            Etablissement etablissement = tableListeEtablissement.getSelectionModel().getSelectedItem();
            ServiceEtablissement se = new ServiceEtablissement();
            while (etat == 0) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierEtablissementFXML.fxml"));
                DialogPane paneModifierEtablissement = loader.load();
                ModifierEtablissementFXMLController modifierEtablissementFXMLController = loader.getController();

                modifierEtablissementFXMLController.setEtablissement(etablissement);

                Dialog<ButtonType> dialog = new Dialog<>();
                dialog.setDialogPane(paneModifierEtablissement);
                dialog.setTitle("Modifier un etablissement");
                Optional<ButtonType> clickedButton = dialog.showAndWait();

                if (clickedButton.get() == ButtonType.OK) {
                    etablissement = modifierEtablissementFXMLController.getEtablissement();
                    if ("".equals(etablissement.getNom()) || "".equals(etablissement.getType()) || "".equals(etablissement.getDescription()) || etablissement.getTrajet().getDepart() == null) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setHeaderText("L'un des champs est vide");
                        alert.showAndWait();

                    } else if (etablissement.getNom().matches("^[a-zA-Z0-9]*$") == false) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setHeaderText("Le nom ne peut pas contenir des caractères spéciaux");
                        alert.showAndWait();

                    } else {
                        etat = 1;
                    }
                } else {
                    etat = 2;
                    ObservableList<Etablissement> listeEtablissement = FXCollections.observableArrayList(se.display());
            columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
            columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            columnDepart.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTrajet().getDepart()));
            columnDestination.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTrajet().getDestination()));
            tableListeEtablissement.setItems(listeEtablissement);
                }
            }
            if (etat == 1) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRMATION");
                alert.setHeaderText("Voulez-vous vraiment modifier l'etablissement n° " + etablissement.getId() + " ?");
                Optional<ButtonType> clickedButtonConfirmation = alert.showAndWait();

                if (clickedButtonConfirmation.get() == ButtonType.OK) {

                    se.update(etablissement);
                    ObservableList<Etablissement> listeEtablissement = FXCollections.observableArrayList(se.display());
            columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
            columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            columnDepart.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTrajet().getDepart()));
            columnDestination.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTrajet().getDestination()));
            tableListeEtablissement.setItems(listeEtablissement);

                }

            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Vous devez selectionner un etablisement");
            alert.showAndWait();
        }
    }

    @FXML
    private void dialogSupprimerEtablissement(ActionEvent event) {
        if (tableListeEtablissement.getSelectionModel().getSelectedItem() != null) {

            ServiceEtablissement se = new ServiceEtablissement();
            Etablissement etablissement = tableListeEtablissement.getSelectionModel().getSelectedItem();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFIRMATION");
            alert.setHeaderText("Voulez-vous vraiment supprimer l'etablissement n° " + etablissement.getId() + " ?");
            //alert.setContentText("Vous devez selectionner un trajet");
            Optional<ButtonType> clickedButton = alert.showAndWait();

            if (clickedButton.get() == ButtonType.OK) {
                se.delete(etablissement);
                
                ObservableList<Etablissement> listeEtablissement = FXCollections.observableArrayList(se.display());
                columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
                columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
                columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
                columnDepart.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTrajet().getDepart()));
                columnDestination.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTrajet().getDestination()));
                tableListeEtablissement.setItems(listeEtablissement);

            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Vous devez selectionner un etablissement");
            //alert.setContentText("Vous devez selectionner un trajet");
            alert.showAndWait();
        }
    }

}
