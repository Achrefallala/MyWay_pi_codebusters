/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservation.GUI;

import Entities.LigneTransport;
import Entities.Reservation;
import Entities.Ticket;
import Entities.Trajet;
import Services.ServiceLigneTransport;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Slim
 */
public class HomeReservationUSERController implements Initializable {

    @FXML
    private Label tfdepart;
    @FXML
    private Label tfdestination;
    @FXML
    private Label tfmoyen;
    @FXML
    private Label tfprix;
    @FXML
    private Label tfprix1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServiceLigneTransport sl = new ServiceLigneTransport();
       LigneTransport l = sl.findByIdTrajetAndMatriculeMoyenTp(1,"88tun77");
       tfdepart.setText(l.getTrajet().getDepart());
        tfdestination.setText(l.getTrajet().getDestination());
        tfprix.setText(Double.toString(l.getMoyentransport().getPrix()));
        tfmoyen.setText(l.getMoyentransport().getType());

    }

}
