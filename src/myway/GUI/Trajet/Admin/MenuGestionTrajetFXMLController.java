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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
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
public class MenuGestionTrajetFXMLController implements Initializable {

    @FXML
    private TableView<Trajet> tableListeTrajet;
    @FXML
    private TableColumn<Trajet, Integer> columnId;
    @FXML
    private TableColumn<Trajet, String> columnDepart;
    @FXML
    private TableColumn<Trajet, String> columnDestination;
    @FXML
    private TableColumn<Trajet, String> columnEtat;
    @FXML
    private TableColumn<Trajet, String> columnDirections;
    @FXML
    private TableColumn<Trajet, String> columnImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceTrajet st = new ServiceTrajet();
        ObservableList<Trajet> listeTrajet = FXCollections.observableArrayList(st.display());
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnDepart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        columnDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        columnEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        columnDirections.setCellValueFactory(new PropertyValueFactory<>("directions"));
        columnImage.setCellValueFactory(new PropertyValueFactory<>("image"));
        tableListeTrajet.setItems(listeTrajet);
    }

    @FXML
    private void dialogAjouterTrajet(ActionEvent event) throws IOException {
        int etat = 0;
        Trajet t = new Trajet("", "", "", "", "");
        ServiceTrajet st = new ServiceTrajet();
        while (etat == 0) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterTrajetFXML.fxml"));
            DialogPane paneAjouterTrajet = loader.load();
            AjouterTrajetFXMLController ajouterTrajetFXMLController = loader.getController();
            ajouterTrajetFXMLController.setTrajet(t);

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(paneAjouterTrajet);
            dialog.setTitle("Ajouter un trajet");
            Optional<ButtonType> clickedButton = dialog.showAndWait();

            if (clickedButton.get() == ButtonType.OK) {

                t = ajouterTrajetFXMLController.getTrajet();
                if ("".equals(t.getDepart()) || "".equals(t.getDestination()) || "".equals(t.getEtat()) || "".equals(t.getDirections()) || "".equals(t.getImage())) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Les champs de texte ne doivent pas être vide");
                    alert.showAndWait();

                } else if (t.getDepart().matches("^[a-zA-Z0-9]*$") == false || t.getDestination().matches("^[a-zA-Z0-9]*$") == false) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Les champs du départ et de la destination ne peuvent pas contenir des caractères spéciaux");
                    //alert.setContentText("Vous devez selectionner un trajet");
                    alert.showAndWait();

                }else if (st.exist(t) == true) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Le trajet exist deja");
                    //alert.setContentText("Vous devez selectionner un trajet");
                    alert.showAndWait();

                } else {
                    etat = 1;
                }

            } else {
                etat = 2;
            }
        }
        if (etat == 1) {
            
            st.add(t);

            ObservableList<Trajet> listeTrajet = FXCollections.observableArrayList(st.display());
            columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            columnDepart.setCellValueFactory(new PropertyValueFactory<>("depart"));
            columnDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
            columnEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
            columnDirections.setCellValueFactory(new PropertyValueFactory<>("directions"));
            columnImage.setCellValueFactory(new PropertyValueFactory<>("image"));
            tableListeTrajet.setItems(listeTrajet);
        }

    }

    @FXML
    private void dialogModifierTrajet(ActionEvent event) throws IOException {

        if (tableListeTrajet.getSelectionModel().getSelectedItem() != null) {
            int etat = 0;
            Trajet t = tableListeTrajet.getSelectionModel().getSelectedItem();
            ServiceTrajet st = new ServiceTrajet();
            while (etat == 0) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierTrajetFXML.fxml"));
                DialogPane paneModifierTrajet = loader.load();
                ModifierTrajetFXMLController modifierTrajetFXMLController = loader.getController();

                modifierTrajetFXMLController.setTrajet(t);

                Dialog<ButtonType> dialog = new Dialog<>();
                dialog.setDialogPane(paneModifierTrajet);
                dialog.setTitle("Modifier un trajet");
                Optional<ButtonType> clickedButton = dialog.showAndWait();

                if (clickedButton.get() == ButtonType.OK) {
                    t = modifierTrajetFXMLController.getTrajet();
                    if ("".equals(t.getDepart()) || "".equals(t.getDestination()) || "".equals(t.getEtat()) || "".equals(t.getDirections()) || "".equals(t.getImage())) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setHeaderText("L'un des champs est vide");
                        alert.showAndWait();

                    } else if (t.getDepart().matches("^[a-zA-Z0-9]*$") == false || t.getDestination().matches("^[a-zA-Z0-9]*$") == false) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setHeaderText("Les champs du départ et de la destination ne peuvent pas contenir des caractères spéciaux");
                        alert.showAndWait();

                    } else {
                        etat = 1;
                    }
                } else {
                    etat = 2;
                    ObservableList<Trajet> listeTrajet = FXCollections.observableArrayList(st.display());
                    columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
                    columnDepart.setCellValueFactory(new PropertyValueFactory<>("depart"));
                    columnDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
                    columnEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
                    columnDirections.setCellValueFactory(new PropertyValueFactory<>("directions"));
                    columnImage.setCellValueFactory(new PropertyValueFactory<>("image"));
                    tableListeTrajet.setItems(listeTrajet);
                }
            }
            if (etat == 1) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("CONFIRMATION");
                alert.setHeaderText("Voulez-vous vraiment modifier le trajet n° " + t.getId() + " ?");
                Optional<ButtonType> clickedButtonConfirmation = alert.showAndWait();

                if (clickedButtonConfirmation.get() == ButtonType.OK) {

                    st.update(t);
                    ObservableList<Trajet> listeTrajet = FXCollections.observableArrayList(st.display());
                    columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
                    columnDepart.setCellValueFactory(new PropertyValueFactory<>("depart"));
                    columnDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
                    columnEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
                    columnDirections.setCellValueFactory(new PropertyValueFactory<>("directions"));
                    columnImage.setCellValueFactory(new PropertyValueFactory<>("image"));
                    tableListeTrajet.setItems(listeTrajet);

                }

            }

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Vous devez selectionner un trajet");
            //alert.setContentText("Vous devez selectionner un trajet");
            alert.showAndWait();
        }

    }

    @FXML
    private void dialogSupprimerTrajet(ActionEvent event) {

        if (tableListeTrajet.getSelectionModel().getSelectedItem() != null) {

            ServiceTrajet st = new ServiceTrajet();
            Trajet t = tableListeTrajet.getSelectionModel().getSelectedItem();

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("CONFIRMATION");
            alert.setHeaderText("Voulez-vous vraiment supprimer le trajet n° " + t.getId() + " ?");
            //alert.setContentText("Vous devez selectionner un trajet");
            Optional<ButtonType> clickedButton = alert.showAndWait();

            if (clickedButton.get() == ButtonType.OK) {

                st.delete(t);

                ObservableList<Trajet> listeTrajet = FXCollections.observableArrayList(st.display());
                columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
                columnDepart.setCellValueFactory(new PropertyValueFactory<>("depart"));
                columnDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
                columnEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
                columnDirections.setCellValueFactory(new PropertyValueFactory<>("directions"));
                columnImage.setCellValueFactory(new PropertyValueFactory<>("image"));
                tableListeTrajet.setItems(listeTrajet);

            }

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Vous devez selectionner un trajet");
            //alert.setContentText("Vous devez selectionner un trajet");
            alert.showAndWait();
        }
    }

}
