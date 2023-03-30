/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.gui;

import Entities.MoyenTransport;
import Entities.Reservation;
import Entities.ResultReservation;
import Entities.Trajet;
import Entities.Utilisateur;
import Services.ServiceReservation;
import Utils.MyDB;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Slim
 */
public class HomeReservationController implements Initializable {

    @FXML
    private TableColumn<?, ?> nomCol;
    @FXML
    private TableColumn<?, ?> prenomCol;
    @FXML
    private TableColumn<?, ?> ageCol;
    @FXML
    private TableColumn<?, ?> langueCol;
    @FXML
    private TableColumn<?, ?> experienceCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table();
    }

    Reservation r = new Reservation();
    ServiceReservation res = new ServiceReservation();
Utilisateur u = new Utilisateur();
    Connection cnx;
    ObservableList<Reservation> listRes;
    @FXML
    private Button btnGenPDF;
    @FXML
    private TableView<ResultReservation> tableRes;
    private TableColumn<ResultReservation, String> nomutilisateurCol;
    private TableColumn<ResultReservation, String> moyentransportCol;
    private TableColumn<ResultReservation, String> departCol;
    private TableColumn<ResultReservation, String> destinationCol;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txt_keyword;

    public void table() {
        List<Reservation> listRes = new ArrayList<>();
        try {

            listRes = res.afficher();
            ResultReservation r;
            List<ResultReservation> listResReservation = new ArrayList<>();
            
            for (Reservation res : listRes) {

                String UserNom;
                UserNom="mehdi";
                    r = new ResultReservation();
                    if(res.getUtilisateur().getNom()!=UserNom){
                    r.setId(res.getId());
                    r.setDepart(res.getLigne().getTrajet().getDepart());
                    r.setDestination(res.getLigne().getTrajet().getDestination());
                    r.setNom(res.getUtilisateur().getNom());
                    r.setType(res.getLigne().getMoyentransport().getType());
                    listResReservation.add(r);}
                    
            
            }
                tableRes.setItems(FXCollections.observableArrayList(listResReservation));
                nomutilisateurCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
                moyentransportCol.setCellValueFactory(new PropertyValueFactory<>("type"));
                departCol.setCellValueFactory(new PropertyValueFactory<>("depart"));
                destinationCol.setCellValueFactory(new PropertyValueFactory<>("destination"));

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

            }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        }

        @FXML
        public void Delete
        (ActionEvent event
        
            ) {
        ResultReservation r = tableRes.getSelectionModel().getSelectedItem();
            if (r == null) {
                // no row is selected, show an error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please select a row to delete.");
                alert.showAndWait();
                return;
            }

            try {
                cnx = MyDB.getInstance().getCnx();
                PreparedStatement pst = cnx.prepareStatement("DELETE FROM reservation WHERE id = ?");
                pst.setInt(1, r.getId());
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Reservation Registration");
                alert.setHeaderText("Reservation Registration");
                alert.setContentText("Deleted!");
                alert.showAndWait();

                // remove the deleted row from the TableView
                tableRes.getItems().remove(r);

            } catch (SQLException ex) {
                Logger.getLogger(HomeReservationController.class.getName()).log(Level.SEVERE, null, ex);
                // show an error message if the delete operation fails
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to delete the row.");
                alert.showAndWait();
            }
        }

        /* @FXML
    void Delete(ActionEvent event) {
        Reservation r = new Reservation();
        int myIndex = tableRes.getSelectionModel().getSelectedIndex();
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
         */
        @FXML
        private void btnGenPDF
        (ActionEvent event) throws IOException {
            long millis = System.currentTimeMillis();
            java.sql.Date DateRapport = new java.sql.Date(millis);

            String DateLyoum = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(DateRapport);//yyyyMMddHHmmss
            System.out.println("Date d'aujourdhui : " + DateLyoum);

            com.itextpdf.text.Document document = new com.itextpdf.text.Document();

            try {
                PdfWriter.getInstance(document, new FileOutputStream(String.valueOf(DateLyoum + ".pdf")));//yyyy-MM-dd
                document.open();
                Paragraph ph1 = new Paragraph("Rapport Pour les reservations :" + DateRapport);
                Paragraph ph2 = new Paragraph(".");
                PdfPTable table = new PdfPTable(4);

                //On créer l'objet cellule.
                PdfPCell cell;

                //contenu du tableau.
                table.addCell("NOM D'UTILISATEUR");
                table.addCell("MOYEN TRANSPORT");
                table.addCell("DEPART");
                table.addCell("DESTINATION");
                Reservation r = new Reservation();
                res.afficher().forEach(e
                        -> {
                    table.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(String.valueOf(e.getUtilisateur().getNom()));
                    table.addCell(String.valueOf(e.getLigne().getMoyentransport().getType()));
                    table.addCell(String.valueOf(e.getLigne().getTrajet().getDepart()));
                    table.addCell(String.valueOf(e.getLigne().getTrajet().getDestination()));

                }
                );
                document.add(ph1);
                document.add(ph2);
                document.add(table);
                //  document.addAuthor("Bike");
                // AlertDialog.showNotification("Creation PDF ", "Votre fichier PDF a ete cree avec success", AlertDialog.image_checked);
            } catch (Exception e) {
                System.out.println(e);
            }
            document.close();

            ///Open FilePdf
            File file = new File(DateLyoum + ".pdf");
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) //checks file exists or not  
            {
                desktop.open(file); //opens the specified file   
            }
        }

        @FXML
        private void searchBar
        (KeyEvent event
        
            ) {
    ServiceReservation sr = new ServiceReservation();
            List<Reservation> l = sr.afficher();
            ObservableList<ResultReservation> newdata = l.stream()
                    .filter(n -> n.getUtilisateur().getNom().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                    || n.getLigne().getMoyentransport().getType().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                    || n.getLigne().getTrajet().getDepart().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                    || n.getLigne().getTrajet().getDestination().toLowerCase().contains(txt_keyword.getText().toLowerCase()))
                    .map(res -> {
                        ResultReservation r = new ResultReservation();
                        r.setDepart(res.getLigne().getTrajet().getDepart());
                        r.setDestination(res.getLigne().getTrajet().getDestination());
                        r.setNom(res.getUtilisateur().getNom());
                        r.setType(res.getLigne().getMoyentransport().getType());
                        return r;
                    })
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            tableRes.setItems(newdata);
        }

    }
