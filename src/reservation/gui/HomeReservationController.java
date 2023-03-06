package reservation.gui;

import Entities.MoyenTransport;
import Entities.Reservation;
import Entities.Ticket;
import Entities.Trajet;
import Entities.Utilisateur;
import Services.ServiceReservation;
import Services.ServiceTicket;
import Services.ServiceUtilisateur;
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
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Slim
 */
public class HomeReservationController implements Initializable {

    Reservation r = new Reservation();
    ServiceReservation res = new ServiceReservation();

    Connection cnx;
    ObservableList<Reservation> listRes;
    @FXML
    private Button btnGenPDF;
    @FXML
    private TableView<Reservation> tableRes;
    @FXML
    private TableColumn<Utilisateur, String> nomutilisateurCol;
    @FXML
    private TableColumn<MoyenTransport, String> moyentransportCol;
    @FXML
    private TableColumn<Trajet, String> departCol;
    @FXML
    private TableColumn<Trajet, String> destinationCol;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txt_keyword;

    public void table() {

        tableRes.setItems(FXCollections.observableArrayList(res.afficher()));
        nomutilisateurCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        moyentransportCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        departCol.setCellValueFactory(new PropertyValueFactory<>("depart"));
        destinationCol.setCellValueFactory(new PropertyValueFactory<>("destination"));

        tableRes.setRowFactory(tv -> {
            TableRow<Reservation> myRow = new TableRow<>();
            myRow.setOnMouseClicked((event)
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    int myIndex = tableRes.getSelectionModel().getSelectedIndex();

                }
            });
            return myRow;
        });

    


    /*
    @FXML
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
   
     
 /*@FXML
    private void searchBar() {
        ServiceReservation sr = new ServiceReservation();
        List<Reservation> l = sr.afficher();
        ObservableList<Reservation> newdata = l.stream().filter(n -> n.getMoyen_transport().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                || n.getDisponibilite_r().toLowerCase().contains(txt_keyword.getText().toLowerCase()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        tableRes.setItems(newdata);
}*/


   
}

 

    @FXML
    private void btnGenPDF(ActionEvent event) throws IOException {
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
    private void Add(ActionEvent event) {
    }

    @FXML
    private void searchBar(KeyEvent event) {
        ServiceReservation sr = new ServiceReservation();
        List<Reservation> l = sr.afficher();
        ObservableList<Reservation> newdata = l.stream().filter(n -> n.getUtilisateur().getNom().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                || n.getLigne().getMoyentransport().getType().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                || n.getLigne().getMoyentransport().getType().toLowerCase().contains(txt_keyword.getText().toLowerCase()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        tableRes.setItems(newdata);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table();
    }
    
    
}