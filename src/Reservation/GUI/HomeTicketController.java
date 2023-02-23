/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservation.GUI;

import Utils.MyDB;
import Entities.Ticket;
import Services.ServiceTicket;
import Utils.MyDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Slim
 */
public class HomeTicketController implements Initializable {

    ServiceTicket tic = new ServiceTicket();
    @FXML
    private TableView<Ticket> tableTic;
    @FXML
    private TableColumn<Ticket, Integer> idreservationCol;
    @FXML
    private TableColumn<Ticket, Integer> idticketCol;
    @FXML
    private TableColumn<Ticket, Integer> prixticketCol;
    @FXML
    private TableColumn<Ticket, String> lieudepartCol;
    @FXML
    private TableColumn<Ticket, String> lieuarriveCol;
    @FXML
    private TableColumn<Ticket, String> heuredepartCol;
    @FXML
    private TableColumn<Ticket, String> heurearriveCol;
    @FXML
    private TextField txtidreservation;
    @FXML
    private TextField txtprixticket;
    @FXML
    private TextField txtlieudepart;
    @FXML
    private TextField txtlieuarrive;
    @FXML
    private TextField txtheuredep;
    @FXML
    private TextField txtheurearr;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    ObservableList<Ticket> listTic;
    Connection cnx;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void Add(ActionEvent event) {
        int id_reservation;
        int prix_ticket;
        String lieu_depart;
        String lieu_arrive;
        String heure_depart;
        String heure_arrive;
        int id_ticket;
        id_reservation = Integer.parseInt(txtidreservation.getText());
        prix_ticket = Integer.parseInt(txtprixticket.getText());
        lieu_depart = txtlieudepart.getText();
        lieu_arrive = txtlieuarrive.getText();
        heure_depart = txtheuredep.getText();
        heure_arrive = txtheurearr.getText();
        PreparedStatement pst;
        cnx = MyDB.getInstance().getCnx();
        try {
            pst = cnx.prepareStatement("insert into ticket(id_reservation,prix_ticket,lieu_depart,lieu_arrive,heure_depart,heure_arrive)values(?,?,?,?,?,?)");
            pst.setInt(1, id_reservation);
            pst.setInt(2, prix_ticket);
            pst.setString(3, lieu_depart);
            pst.setString(4, lieu_arrive);
            pst.setString(5, heure_depart);
            pst.setString(6, heure_arrive);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("TICKET Registation");

            alert.setHeaderText("TICKET Registation");
            alert.setContentText("Record Addedddd!");

            alert.showAndWait();

            table();

            txtidreservation.requestFocus();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void table() {

        tableTic.setItems(FXCollections.observableArrayList(tic.afficher()));
        idreservationCol.setCellValueFactory(new PropertyValueFactory<>("id_reservation"));
        idticketCol.setCellValueFactory(new PropertyValueFactory<>("id_ticket"));
        prixticketCol.setCellValueFactory(new PropertyValueFactory<>("prix_ticket"));
        lieudepartCol.setCellValueFactory(new PropertyValueFactory<>("lieu_depart"));
        lieuarriveCol.setCellValueFactory(new PropertyValueFactory<>("lieu_arrive"));
        heuredepartCol.setCellValueFactory(new PropertyValueFactory<>("heure_depart"));
        heurearriveCol.setCellValueFactory(new PropertyValueFactory<>("heure_arrive"));
        tableTic.setRowFactory(tv -> {
            TableRow<Ticket> myRow = new TableRow<>();
            myRow.setOnMouseClicked((event)
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    int myIndex = tableTic.getSelectionModel().getSelectedIndex();

                    int id = Integer.parseInt(String.valueOf(tableTic.getItems().get(myIndex).getId_ticket()));
                    txtprixticket.setText(String.valueOf((Float) tableTic.getItems().get(myIndex).getPrix_ticket()));
                    txtlieudepart.setText(tableTic.getItems().get(myIndex).getLieu_depart());
                    txtlieuarrive.setText(tableTic.getItems().get(myIndex).getLieu_arrive());
                    txtheuredep.setText(tableTic.getItems().get(myIndex).getHeure_depart());
                    txtheurearr.setText(tableTic.getItems().get(myIndex).getHeure_arrive());

                }
            });
            return myRow;
        });

    }

    @FXML
    private void Update(ActionEvent event) {
        int myIndex = tableTic.getSelectionModel().getSelectedIndex();
        int id_ticket = Integer.parseInt(String.valueOf(tableTic.getItems().get(myIndex).getId_ticket()));
        System.out.println(id_ticket);
        int prix_ticket = Integer.parseInt(txtprixticket.getText());
        String lieu_depart = txtlieudepart.getText();
        String lieu_arrive = txtlieuarrive.getText();
        String heure_depart = txtheuredep.getText();
        String heure_arrive = txtheurearr.getText();

        Ticket t = new Ticket(prix_ticket, lieu_depart, lieu_arrive, heure_depart, heure_arrive, id_ticket);
        tic.modifier(t);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("TICKET Registationn");

        alert.setHeaderText("TICKET Registation");
        alert.setContentText("UPDATED!");
        alert.showAndWait();
        table();

    }

    @FXML
    private void Delete(ActionEvent event) {
        int myIndex = tableTic.getSelectionModel().getSelectedIndex();
        int id_ticket = Integer.parseInt(String.valueOf(tableTic.getItems().get(myIndex).getId_ticket()));
        tic.supprimer(id_ticket);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("TICKET Registationn");

        alert.setHeaderText("TICKET Registation");
        alert.setContentText("Deletedd!");

        alert.showAndWait();
        table();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table();
    }

}
