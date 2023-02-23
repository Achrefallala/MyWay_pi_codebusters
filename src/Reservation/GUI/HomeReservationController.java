package Reservation.GUI;

import Utils.MyDB;
import Entities.Reservation;
import Entities.Ticket;
import Services.ServiceReservation;
import Services.ServiceTicket;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.control.TextField;

/**
 *
 * @author Slim
 */
public class HomeReservationController implements Initializable {

    ServiceReservation res = new ServiceReservation();

    @FXML
    private TableView<Reservation> tableRes;

    @FXML
    private TableColumn<Reservation, Integer> idreservationCol;

    @FXML
    private TableColumn<Reservation, Integer> idutilisateurCol;

    @FXML
    private TableColumn<Reservation, String> moyentransportCol;

    @FXML
    private TableColumn<Reservation, String> disponibiliteCol;

    @FXML
    private javafx.scene.control.TextField txtidutilisateur;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;
    @FXML
    private javafx.scene.control.TextField txtmoyen;
    @FXML
    private javafx.scene.control.TextField txtdispo;
    Connection cnx;

    ObservableList<Reservation> listRes;

    @FXML
    void Add(ActionEvent event) {

        int id_utilisateur;
        String moyen_transport;
        String disponibilite_r;
        id_utilisateur = Integer.parseInt(txtidutilisateur.getText());
        moyen_transport = txtmoyen.getText();
        disponibilite_r = txtdispo.getText();
        PreparedStatement pst;
        cnx = MyDB.getInstance().getCnx();
        try {
            pst = cnx.prepareStatement("insert into reservation(id_utilisateur,moyen_transport,disponibilite_r)values(?,?,?)");
            pst.setInt(1, id_utilisateur);
            pst.setString(2, moyen_transport);
            pst.setString(3, disponibilite_r);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reservation Registation");

            alert.setHeaderText("Reservation Registation");
            alert.setContentText("Record Addedddd!");

            alert.showAndWait();

            table();

            txtidutilisateur.requestFocus();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void table() {
        ServiceReservation res = new ServiceReservation();
        tableRes.setItems(FXCollections.observableArrayList(res.afficher()));

        idreservationCol.setCellValueFactory(new PropertyValueFactory<>("id_reservation"));
        idutilisateurCol.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        moyentransportCol.setCellValueFactory(new PropertyValueFactory<>("moyen_transport"));
        disponibiliteCol.setCellValueFactory(new PropertyValueFactory<>("disponibilite_r"));
        tableRes.setRowFactory(tv -> {
            TableRow<Reservation> myRow = new TableRow<>();
            myRow.setOnMouseClicked((event)
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    int myIndex = tableRes.getSelectionModel().getSelectedIndex();

                    int id = Integer.parseInt(String.valueOf(tableRes.getItems().get(myIndex).getId_reservation()));
                    txtidutilisateur.setText(String.valueOf(tableRes.getItems().get(myIndex).getId_utilisateur()));
                    txtmoyen.setText(tableRes.getItems().get(myIndex).getMoyen_transport());
                    txtdispo.setText(tableRes.getItems().get(myIndex).getDisponibilite_r());

                }
            });
            return myRow;
        });

        /* listRes = res.getDataRes();
        tableRes.setItems(listRes);*/
    }

    @FXML
    void Delete(ActionEvent event) {
        int myIndex = tableRes.getSelectionModel().getSelectedIndex();
        int id_reservation = Integer.parseInt(String.valueOf(tableRes.getItems().get(myIndex).getId_reservation()));
        PreparedStatement pst;
        cnx = MyDB.getInstance().getCnx();
        try {
            pst = cnx.prepareStatement("delete from reservation where id_reservation = ? ");
            pst.setInt(1, id_reservation);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("reservation Registationn");

            alert.setHeaderText("reservation Registation");
            alert.setContentText("Deletedd!");

            alert.showAndWait();
            table();
        } catch (SQLException ex) {
            Logger.getLogger(HomeReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void Update(ActionEvent event) {
        int myIndex = tableRes.getSelectionModel().getSelectedIndex();
        int id_reservation = Integer.parseInt(String.valueOf(tableRes.getItems().get(myIndex).getId_reservation()));
        System.out.println(id_reservation);
        int id_utilisateur = Integer.parseInt(txtidutilisateur.getText());
        String moyen_transport = txtmoyen.getText();
        String disponibilite_r = txtdispo.getText();

        Reservation r = new Reservation(id_reservation, id_utilisateur, moyen_transport, disponibilite_r);
        res.modifier(r);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("TICKET Registationn");

        alert.setHeaderText("TICKET Registation");
        alert.setContentText("UPDATED!");
        alert.showAndWait();
        table();

//        int id_utilisateur = Integer.parseInt(txtidutilisateur.getText());
//        String moyen_transport = txtmoyen.getText();
//        String disponibilite_r = txtdispo.getText();
//        PreparedStatement pst;
//        cnx = MyDB.getInstance().getCnx();
//        try {
//            pst = cnx.prepareStatement("update reservation set id_utilisateur = ?, moyen_transport = ? , disponibilite_r= ? where id_reservation= ? ");
//            pst.setInt(1, id_utilisateur);
//            pst.setString(2, moyen_transport);
//            pst.setString(3, disponibilite_r);
//
//            pst.executeUpdate();
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("reservation Registationn");
//
//            alert.setHeaderText("reservation Registation");
//            alert.setContentText("UPDATED!");
//
//            alert.showAndWait();
//            table();
//        } catch (SQLException ex) {
//            Logger.getLogger(HomeReservationController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table();
    }

}
