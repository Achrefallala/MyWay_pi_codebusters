/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Reservation.Admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author 9naydel
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import myway.Entities.Reservation;
import myway.Entities.ResultTicket;
import myway.Entities.Ticket;
import myway.Services.ServiceTicket;
import myway.Utils.MyDB;

/**
 * FXML Controller class
 *
 * @author Slim
 */
public class HomeTicketController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table();
    }
    Ticket t = new Ticket();
    ServiceTicket tic = new ServiceTicket();
    Connection cnx;

    @FXML
    private TableView<ResultTicket> tableTic;
    @FXML
    private TableColumn<ResultTicket, String> nomutilisateurCol;
    @FXML
    private TableColumn<ResultTicket, Double> prixticketCol;
    @FXML
    private TableColumn<ResultTicket, String> departCol;
    @FXML
    private TableColumn<ResultTicket, String> destinationCol;
    @FXML
    private TableColumn<ResultTicket, Date> dateticketCol;
    @FXML
    private TableColumn<ResultTicket, String> typeCol;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txt_keyword;
    @FXML
    private Button btnGenPDF;

    /**
     * Initializes the controller class.
     */
    public void table() {

        List<Ticket> listTic = new ArrayList<>();
        try {

            listTic = tic.afficher();
            ResultTicket r;
            List<ResultTicket> listResTic = new ArrayList<>();

            for (Ticket tic : listTic) {
                r = new ResultTicket();

                r.setId(tic.getId());
                r.setNom(tic.getUtilisateur().getNom());
                r.setPrix(tic.getLigne().getMoyenTransport().getPrix());
                r.setDepart(tic.getLigne().getTrajet().getDepart());
                r.setDestination(tic.getLigne().getTrajet().getDestination());
                r.setDateticket((java.sql.Date) tic.getDateticket());
                r.setType(tic.getLigne().getMoyenTransport().getType());

                listResTic.add(r);

            }

            System.out.println("****************listtic********************" + listTic);

            tableTic.setItems(FXCollections.observableArrayList(listResTic));
            nomutilisateurCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prixticketCol.setCellValueFactory(new PropertyValueFactory<>("prix"));
            departCol.setCellValueFactory(new PropertyValueFactory<>("depart"));
            destinationCol.setCellValueFactory(new PropertyValueFactory<>("destination"));
            dateticketCol.setCellValueFactory(new PropertyValueFactory<>("dateticket"));
            typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

            tableTic.setRowFactory(tv -> {
                TableRow<ResultTicket> myRow = new TableRow<>();
                myRow.setOnMouseClicked((event) -> {
                    if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                        int myIndex = tableTic.getSelectionModel().getSelectedIndex();
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
        ResultTicket r = tableTic.getSelectionModel().getSelectedItem();
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
            PreparedStatement pst = cnx.prepareStatement("DELETE FROM ticket WHERE id = ?");

            System.out.println("r.getId()" + r.getId());
            pst.setInt(1, r.getId());
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ticket Registration");
            alert.setHeaderText("Ticket Registration");
            alert.setContentText("Deleted!");
            alert.showAndWait();

            // remove the deleted row from the TableView
            tableTic.getItems().remove(r);

        } catch (SQLException ex) {
            Logger.getLogger(HomeTicketController.class.getName()).log(Level.SEVERE, null, ex);
            // show an error message if the delete operation fails
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to delete the row.");
            alert.showAndWait();
        }

    }

    @FXML
    void btnGenPDF(ActionEvent event) throws DocumentException, FileNotFoundException, IOException {

        long millis = System.currentTimeMillis();
        java.sql.Date DateRapport = new java.sql.Date(millis);

        String DateLyoum = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(DateRapport);//yyyyMMddHHmmss
        System.out.println("Date d'aujourdhui : " + DateLyoum);

        com.itextpdf.text.Document document = new com.itextpdf.text.Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(String.valueOf(DateLyoum + ".pdf")));//yyyy-MM-dd
            document.open();
            Paragraph ph1 = new Paragraph("Rapport Pour les tickets :" + DateRapport);
            Paragraph ph2 = new Paragraph(".");
            PdfPTable table = new PdfPTable(6);

            //On créer l'objet cellule.
            PdfPCell cell;

            //contenu du tableau.
            table.addCell("NOM UTILISATEUR");
            table.addCell("PRIX TICKET");
            table.addCell("DEPART");
            table.addCell("DESTINATION");
            table.addCell("DATE TICKET");
            table.addCell("MOYEN TRANSPORT");
            Reservation r = new Reservation();
            Ticket t = new Ticket();
            tic.afficher().forEach(e
                    -> {
                table.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(String.valueOf(e.getUtilisateur().getNom()));
                table.addCell(String.valueOf(e.getLigne().getMoyenTransport().getPrix()));
                table.addCell(String.valueOf(e.getLigne().getTrajet().getDepart()));
                table.addCell(String.valueOf(e.getLigne().getTrajet().getDestination()));
                table.addCell(String.valueOf(e.getDateticket()));
                table.addCell(String.valueOf(e.getLigne().getMoyenTransport().getType()));

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
    private void searchBar(KeyEvent event) {
        ServiceTicket sr = new ServiceTicket();
        List<Ticket> l = sr.afficher();
        ObservableList<ResultTicket> newdata = l.stream()
                .filter(n -> n.getUtilisateur().getNom().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                || n.getLigne().getMoyenTransport().getType().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                || n.getLigne().getTrajet().getDepart().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                || n.getLigne().getTrajet().getDestination().toLowerCase().contains(txt_keyword.getText().toLowerCase()))
                .map(res -> {
                    ResultTicket r = new ResultTicket();
                    r.setDepart(res.getLigne().getTrajet().getDepart());
                    r.setDestination(res.getLigne().getTrajet().getDestination());
                    r.setNom(res.getUtilisateur().getNom());
                    r.setType(res.getLigne().getMoyenTransport().getType());
                    return r;
                })
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        tableTic.setItems(newdata);
    }

}  
    

