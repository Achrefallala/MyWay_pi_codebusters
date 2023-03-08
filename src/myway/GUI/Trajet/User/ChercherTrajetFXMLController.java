/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Trajet.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import myway.Entities.Trajet;
import myway.Services.ServiceTrajet;

/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class ChercherTrajetFXMLController implements Initializable {

    @FXML
    private TextField tfDepart;
    @FXML
    private TextField tfDestination;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void chercher(ActionEvent event) throws IOException {
        ServiceTrajet st = new ServiceTrajet();
        //Trajet t = st.findByDepartAndDestination(tfDepart.getText(), tfDestination.getText());
        Trajet t = st.findByDepartAndDestination("Bardo","Ariana");
        

        if ("".equals(tfDepart.getText()) || "".equals(tfDestination.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Les champs de texte ne doivent pas être vide");
            alert.showAndWait();

        } else if (tfDepart.getText().matches("^[a-zA-Z0-9]*$") == false || tfDestination.getText().matches("^[a-zA-Z0-9]*$") == false) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Les champs du départ et de la destination ne peuvent pas contenir des caractères spéciaux");
            alert.showAndWait();

        } else if (st.exist(t) == false) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Le trajet n'exist pas");
            alert.showAndWait();

        } else {
            

            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsTrajetFXML.fxml"));
            Parent detailsTrajet = loader.load();
            DetailsTrajetFXMLController detailsTrajetFXMLController = loader.getController();
            
            detailsTrajetFXMLController.setTrajet(t);

            Stage detailsTrajetStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene detailsTrajetScene = new Scene(detailsTrajet);

            detailsTrajetStage.setTitle("details Trajet: ");
            detailsTrajetStage.setScene(detailsTrajetScene);
            detailsTrajetStage.show();

        }

    }

}
