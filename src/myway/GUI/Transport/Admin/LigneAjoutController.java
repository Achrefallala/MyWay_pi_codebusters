/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Transport.Admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
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
import myway.Entities.LigneTransport1;
import myway.Entities.Moyentp;
import myway.Entities.Trajet;
import myway.Services.MoyentpService;
import myway.Services.ServiceLigneTransport1;
import org.controlsfx.control.Notifications;



/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class LigneAjoutController implements Initializable {

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
    private TableView<LigneTransport1> table;
    @FXML
    private TableColumn<LigneTransport1, Integer> idCol;
    @FXML
    private TableColumn<LigneTransport1, String> moyenCol;
    private TableColumn<LigneTransport1, String> trajetCol;
    ServiceLigneTransport1 ss = new ServiceLigneTransport1();
    MoyentpService cc = new MoyentpService();

    @FXML
    private TextField recherche;

    List<LigneTransport1> lig = ss.getAll();
    List<Moyentp> mp = cc.getAll();
    @FXML
    private TableColumn<LigneTransport1,String> trajetce;
    @FXML
    private TableColumn<LigneTransport1,Integer > transportid;
    @FXML
    private TableColumn<LigneTransport1,Integer > trajetid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<LigneTransport1> listLig = FXCollections.observableArrayList(lig);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        moyenCol.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getMoyenTransport().getNom()));
        trajetce.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTrajet().getDestination()));
       trajetid.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTrajet().getId()));
       transportid.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getMoyenTransport().getId()));
       

        table.setItems(listLig);
    }
    @FXML
    private void AjouterAction(ActionEvent event) {

        List<LigneTransport1> List;

        if (isInputValid()) {
            LigneTransport1 s = new LigneTransport1();

            Moyentp m = new Moyentp();
            m.setId(Integer.parseInt(TextMoyen.getText()));
            s.setMoyenTransport(m);

            Trajet t = new Trajet();
            t.setId(Integer.parseInt(TextTrajet.getText()));
            s.setTrajet(t);

            ss.ajouter(s);
            reset();

            List<LigneTransport1> list = ss.getAll();
            table.setItems(FXCollections.observableList(list));

            Notifications.create()
                    .title("New Ligne Added")
                    .text("A new Ligne has been added successfully!")
                    .showInformation();
        }

    }

    private void reset() {

        TextMoyen.setText("");
        TextTrajet.setText("");

    }

    @FXML
    private void ModifierAction(ActionEvent event) {
        List<LigneTransport1> List;

        if (isInputValid()) {

            LigneTransport1 s = new LigneTransport1();

            //s.setId_moyentp(TextMoyen.getText());
            //String moyentpid = s.getId_moyentp();
            int x = Integer.parseInt(TextMoyen.getText());
            s.getTrajet().setId(x);

            int y = Integer.parseInt(TextTrajet.getText());
            s.getMoyenTransport().setId(y);

            ss.modifier(s);
            Notifications.create()
                    .title("New Ligne Updated")
                    .text("A new Ligne has been updated successfully!")
                    .showInformation();
            reset();
            List = FXCollections.observableList(ss.getAll());
            table.setItems((ObservableList<LigneTransport1>) List);

        }

    }

    @FXML
    private void SupprimerAction(ActionEvent event) {

        List<LigneTransport1> List;

        if (null == table.getSelectionModel().getSelectedItem()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("choisir une ligne");
            alert.showAndWait();
        } else {
            LigneTransport1 clicked = table.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.ERROR);
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
            table.setItems((ObservableList<LigneTransport1>) List);

        }
    }

    @FXML
    private void recherche(KeyEvent event) {
        String searchText = recherche.getText() + event.getText();
        ObservableList<LigneTransport1> filteredAbonnements = FXCollections.observableArrayList();
        for (LigneTransport1 ligneTransport : lig) {
            if (String.valueOf(ligneTransport.getId()).contains(searchText)) {
                filteredAbonnements.add(ligneTransport);
            }
        }
        table.setItems(filteredAbonnements);
    }

    @FXML
    public void getSelected(MouseEvent event) {
        int index = -1;
        index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
      
        TextMoyen.setText(trajetid.getCellData(index).toString());
        TextTrajet.setText(transportid.getCellData(index).toString());

    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (TextTrajet.getText() == null || TextTrajet.getText().isEmpty() || !TextTrajet.getText().matches("\\d+") || Integer.parseInt(TextTrajet.getText()) <= 0) {
            errorMessage += "Invalide Trajet!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Invalide champs");
            alert.setHeaderText("**Please correct champs *");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
