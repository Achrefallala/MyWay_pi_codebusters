/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Reservation.User;


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
import myway.Entities.LigneTransport;
import myway.Entities.Reservation;
import myway.Entities.ResultReservation;
import myway.Services.ServiceLigneTransport;
import myway.Services.ServiceReservation;


/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class ReservationspersonellesController implements Initializable {

    Reservation r = new Reservation();
    ServiceReservation res = new ServiceReservation();
    ServiceLigneTransport sl = new ServiceLigneTransport();
    ResultReservation rr = new ResultReservation();

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
        List<LigneTransport> listRes = new ArrayList<>();
        try {
            
            listRes = sl.findByIdLigneList(4);
            ResultReservation r;
            List<ResultReservation> listResReservation = new ArrayList<>();

            for (LigneTransport res : listRes) {
                r = new ResultReservation();
                r.setId(res.getId());
                r.setDepart(res.getTrajet().getDepart());
                r.setDestination(res.getTrajet().getDestination());
                r.setType(res.getMoyenTransport().getType());
                r.setPrix(res.getMoyenTransport().getPrix());

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
