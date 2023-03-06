/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.gui;

import Entities.Reservation;
import Utils.MyDB;
import Entities.Ticket;
import Services.ServiceReservation;
import Services.ServiceTicket;
import Utils.MyDB;
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
    private TableColumn<Ticket, Integer> prixticketCol;
    @FXML
    private TableColumn<Ticket, String> lieudepartCol;
    @FXML
    private TableColumn<Ticket, String> lieuarriveCol;
    private TextField txtidreservation;
    private TextField txtprixticket;
    private TextField txtlieudepart;
    private TextField txtlieuarrive;
    private TextField txtheuredep;
    private TextField txtheurearr;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnGenPDF;
    @FXML
    private TextField txt_keyword;
    ObservableList<Ticket> listTic;
    Connection cnx;
    @FXML
    private TableColumn<?, ?> prixticketCol1;
    @FXML
    private TableColumn<?, ?> lieuarriveCol1;
    @FXML
    private TableColumn<?, ?> lieuarriveCol11;

    /**
     * Initializes the controller class.
     */
    private void Add(ActionEvent event) {
        int id_reservation;
        int prix_ticket;
        String lieu_depart;
        String lieu_arrive;
        String heure_depart;
        String heure_arrive;
        int id_ticket;

        prix_ticket = Integer.parseInt(txtprixticket.getText());
        lieu_depart = txtlieudepart.getText();
        lieu_arrive = txtlieuarrive.getText();
        heure_depart = txtheuredep.getText();
        heure_arrive = txtheurearr.getText();
        PreparedStatement pst;
        cnx = MyDB.getInstance().getCnx();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        boolean ok = true;

        {
            if (txtprixticket.getText().isEmpty() || txtlieudepart.getText().isEmpty() || txtlieuarrive.getText().isEmpty() || txtheuredep.getText().isEmpty() || txtheurearr.getText().isEmpty()) {
                alert.setTitle("Error Message");
            }
            alert.setHeaderText(null);
            alert.setContentText("Fields are required!");
            alert.showAndWait();

            ok = false;
        }

        if (ok == true) {

            try {
                pst = cnx.prepareStatement("insert into ticket(id_reservation,prix_ticket,lieu_depart,lieu_arrive,heure_depart,heure_arrive)values(?,?,?,?,?,?)");
               // pst.setInt(1, id_reservation);
                pst.setInt(2, prix_ticket);
                pst.setString(3, lieu_depart);
                pst.setString(4, lieu_arrive);
                pst.setString(5, heure_depart);
                pst.setString(6, heure_arrive);
                pst.executeUpdate();

                Alert a = new Alert(Alert.AlertType.INFORMATION);
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
    }

    public void table() {

//        tableTic.setItems(FXCollections.observableArrayList(tic.afficher()));
//        idreservationCol.setCellValueFactory(new PropertyValueFactory<>("id_reservation"));
//        idticketCol.setCellValueFactory(new PropertyValueFactory<>("id_ticket"));
//        prixticketCol.setCellValueFactory(new PropertyValueFactory<>("prix_ticket"));
//        lieudepartCol.setCellValueFactory(new PropertyValueFactory<>("lieu_depart"));
//        lieuarriveCol.setCellValueFactory(new PropertyValueFactory<>("lieu_arrive"));
//        heuredepartCol.setCellValueFactory(new PropertyValueFactory<>("heure_depart"));
//        heurearriveCol.setCellValueFactory(new PropertyValueFactory<>("heure_arrive"));
//        tableTic.setRowFactory(tv -> {
//            TableRow<Ticket> myRow = new TableRow<>();
//            myRow.setOnMouseClicked((event)
//                    -> {
//                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
//                    int myIndex = tableTic.getSelectionModel().getSelectedIndex();
//
//                    int id = Integer.parseInt(String.valueOf(tableTic.getItems().get(myIndex).getId_ticket()));
//                    txtprixticket.setText(String.valueOf((Float) tableTic.getItems().get(myIndex).getPrix_ticket()));
//                    txtlieudepart.setText(tableTic.getItems().get(myIndex).getLieu_depart());
//                    txtlieuarrive.setText(tableTic.getItems().get(myIndex).getLieu_arrive());
//                    txtheuredep.setText(tableTic.getItems().get(myIndex).getHeure_depart());
//                    txtheurearr.setText(tableTic.getItems().get(myIndex).getHeure_arrive());
//
//                }
//            });
//            return myRow;
//        });

    }


    @FXML
    private void Delete(ActionEvent event) {
//        int myIndex = tableTic.getSelectionModel().getSelectedIndex();
//        int id_ticket = Integer.parseInt(String.valueOf(tableTic.getItems().get(myIndex).getId_ticket()));
//        tic.supprimer(id_ticket);
//
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("TICKET Registationn");
//
//        alert.setHeaderText("TICKET Registation");
//        alert.setContentText("Deletedd!");
//
//        alert.showAndWait();
//        table();

    }

    @FXML
    void btnGenPDF(ActionEvent event) throws DocumentException, FileNotFoundException, IOException {

//        long millis = System.currentTimeMillis();
//        java.sql.Date DateRapport = new java.sql.Date(millis);
//
//        String DateLyoum = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(DateRapport);//yyyyMMddHHmmss
//        System.out.println("Date d'aujourdhui : " + DateLyoum);
//
//        com.itextpdf.text.Document document = new com.itextpdf.text.Document();
//
//        try {
//            PdfWriter.getInstance(document, new FileOutputStream(String.valueOf(DateLyoum + ".pdf")));//yyyy-MM-dd
//            document.open();
//            Paragraph ph1 = new Paragraph("Rapport Pour les tickets :" + DateRapport);
//            Paragraph ph2 = new Paragraph(".");
//            PdfPTable table = new PdfPTable(6);
//
//            //On créer l'objet cellule.
//            PdfPCell cell;
//
//            //contenu du tableau.
//            table.addCell("ID RESERVATION");
//            table.addCell("PRIX TICKET");
//            table.addCell("LIEU DEPART");
//            table.addCell("LIEU ARRIVE");
//            table.addCell("HEURE DEPART");
//            table.addCell("HEURE ARRIVE");
//            Reservation r = new Reservation();
//            tic.afficher().forEach(e
//                    -> {
//                table.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table.addCell(String.valueOf(e.getId_reservation()));
//                table.addCell(String.valueOf(e.getPrix_ticket()));
//                table.addCell(String.valueOf(e.getLieu_depart()));
//                table.addCell(String.valueOf(e.getLieu_arrive()));
//                table.addCell(String.valueOf(e.getHeure_depart()));
//                table.addCell(String.valueOf(e.getHeure_arrive()));
//
//            }
//            );
//            document.add(ph1);
//            document.add(ph2);
//            document.add(table);
//            //  document.addAuthor("Bike");
//            // AlertDialog.showNotification("Creation PDF ", "Votre fichier PDF a ete cree avec success", AlertDialog.image_checked);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        document.close();
//
//        ///Open FilePdf
//        File file = new File(DateLyoum + ".pdf");
//        Desktop desktop = Desktop.getDesktop();
//        if (file.exists()) //checks file exists or not  
//        {
//            desktop.open(file); //opens the specified file   
//        }
    }

    @FXML
    private void searchBar() {
//        ServiceTicket sr = new ServiceTicket();
//        List<Ticket> l = sr.afficher();
//        ObservableList<Ticket> newdata = l.stream().filter(n -> n.getHeure_arrive().toLowerCase().contains(txt_keyword.getText().toLowerCase())
//                || n.getHeure_depart().toLowerCase().contains(txt_keyword.getText().toLowerCase()))
//                .collect(Collectors.toCollection(FXCollections::observableArrayList));
//        tableTic.setItems(newdata);
    }

    private void comboboxList() {
//        ServiceTicket st = new ServiceTicket();
//        List<Integer> Tickets = st.afficherIDRESERVATION();
//        ObservableList<Integer> observableTicket = FXCollections.observableArrayList(Tickets);
//        //    idreservationcombo.setItems(observableTicket);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table();
    }

}
