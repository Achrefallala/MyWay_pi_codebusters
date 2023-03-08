/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.gui;

import Entities.Reservation;
import Entities.ResultReservation;
import Services.ServiceReservation;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Slim
 */
public class ReservationspersonellesController implements Initializable {

    Reservation r = new Reservation();
    ServiceReservation res = new ServiceReservation();

    Connection cnx;
      @FXML
    private TableView<ResultReservation> tableRes;
    @FXML
    private TableColumn<ResultReservation, String> departCol;
    @FXML
    private TableColumn<ResultReservation, String> destinationCol;
    @FXML
    private TableColumn<ResultReservation, Double> prixCol;
    @FXML
    private TableColumn<ResultReservation, String> typeCol;
    @FXML
    private Button DeleteBtn;
    @FXML
    private Button AddNewRes;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void table() {
        List<Reservation> listRes = new ArrayList<>();
        try {

            listRes = res.afficherConnectedUser();
            ResultReservation r;
            List<ResultReservation> listResReservation = new ArrayList<>();

            for (Reservation res : listRes) {
                r = new ResultReservation();
                r.setId_reservation(res.getId_reservation());
                r.setDepart(res.getLigne().getTrajet().getDepart());
                r.setDestination(res.getLigne().getTrajet().getDestination());
                r.setNom(res.getUtilisateur().getNom());
                r.setType(res.getLigne().getMoyentransport().getType());

                listResReservation.add(r);

            }

            tableRes.setItems(FXCollections.observableArrayList(listResReservation));
            
            departCol.setCellValueFactory(new PropertyValueFactory<>("depart"));
            destinationCol.setCellValueFactory(new PropertyValueFactory<>("destination"));
            prixCol.setCellValueFactory(new PropertyValueFactory<>("prix"));
           typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

            tableRes.setRowFactory(tv -> {
                TableRow<ResultReservation> myRow = new TableRow<>();
                myRow.setOnMouseClicked((event) -> {
                    if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                        int myIndex = tableRes.getSelectionModel().getSelectedIndex();
                        // do something with the selected row
                    }
                });
                return myRow;
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void Delete(ActionEvent event) {
    }

}
