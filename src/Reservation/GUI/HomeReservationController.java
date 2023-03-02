package Reservation.GUI;

import Utils.MyDB;
import Entities.Reservation;
import Entities.Ticket;
import Entities.Utilisateur;
import Services.ServiceReservation;
import Services.ServiceTicket;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import static java.awt.SystemColor.desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javax.swing.JFileChooser;
import javax.swing.text.Document;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private TextField txt_keyword;

    @FXML
    private javafx.scene.control.TextField txtmoyen;
    @FXML
    private javafx.scene.control.TextField txtdispo;
    Connection cnx;
    @FXML
    private ComboBox<String> combo_nom;
    ObservableList<Reservation> listRes;
    @FXML
    private Button btnGenPDF;
    Reservation r = new Reservation();
    @FXML
    private TableColumn<?, ?> nomutilisateurCol;

    @FXML
    void Add(ActionEvent event) {
        Utilisateur u = new Utilisateur();
        /*String u
        .getNom();*/
        int id_utilisateur;
        String moyen_transport;
        String disponibilite_r;
        id_utilisateur = Integer.parseInt(txtidutilisateur.getText());
        moyen_transport = txtmoyen.getText();
        disponibilite_r = txtdispo.getText();
        PreparedStatement pst;
        cnx = MyDB.getInstance().getCnx();
        Alert alert = new Alert(AlertType.ERROR);
        boolean ok = true;

        {
            if (txtidutilisateur.getText().isEmpty() || txtmoyen.getText().isEmpty() || txtdispo.getText().isEmpty()) {
                alert.setTitle("Error Message");
            }
            alert.setHeaderText(null);
            alert.setContentText("Fields are required!");
            alert.showAndWait();

            ok = false;
        }

        if (ok == true) {

            try {
                pst = cnx.prepareStatement("insert into reservation(id_utilisateur,moyen_transport,disponibilite_r)values(?,?,?)");
                pst.setInt(1, id_utilisateur);
                pst.setString(2, moyen_transport);
                pst.setString(3, disponibilite_r);
                pst.executeUpdate();

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
    }

    public void table() {
//        ImageView imageView = new ImageView();
//imageView.setImage(image);
        ServiceReservation res = new ServiceReservation();
        tableRes.setItems(FXCollections.observableArrayList(res.afficher()));
        nomutilisateurCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
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
                    //  combo_nom.setText(String.valueOf(tableRes.getItems().get(myIndex).getId_utilisateur()));

                    int id = Integer.parseInt(String.valueOf(tableRes.getItems().get(myIndex).getId_reservation()));
                    txtidutilisateur.setText(String.valueOf(tableRes.getItems().get(myIndex).getId_utilisateur()));
                    txtmoyen.setText(tableRes.getItems().get(myIndex).getMoyen_transport());
                    txtdispo.setText(tableRes.getItems().get(myIndex).getDisponibilite_r());

                    String val = combo_nom.getValue();
                    
                    List<String> listres = res.afficherNOM();
                    ObservableList<String> listRes = FXCollections.observableArrayList(listres);
                    nomutilisateurCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

                }
            });
            return myRow;

        });

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
        alert.setTitle("RESERVATION Registationn");

        alert.setHeaderText("RESERVATION Registation");
        alert.setContentText("UPDATED!");
        alert.showAndWait();
        table();
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
            Paragraph ph1 = new Paragraph("Rapport Pour les reservations :" + DateRapport);
            Paragraph ph2 = new Paragraph(".");
            PdfPTable table = new PdfPTable(4);

            //On créer l'objet cellule.
            PdfPCell cell;

            //contenu du tableau.
            table.addCell("ID RESERVATION");
            table.addCell("ID UTILISATEUR");
            table.addCell("MOYEN TRANSPORT");
            table.addCell("DISPONIBILITE");
            Reservation r = new Reservation();
            res.afficher().forEach(e
                    -> {
                table.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(String.valueOf(e.getId_reservation()));
                table.addCell(String.valueOf(e.getId_utilisateur()));
                table.addCell(String.valueOf(e.getMoyen_transport()));
                table.addCell(String.valueOf(e.getDisponibilite_r()));

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
    private void searchBar() {
        ServiceReservation sr = new ServiceReservation();
        List<Reservation> l = sr.afficher();
        ObservableList<Reservation> newdata = l.stream().filter(n -> n.getMoyen_transport().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                || n.getDisponibilite_r().toLowerCase().contains(txt_keyword.getText().toLowerCase()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        tableRes.setItems(newdata);
    }

    private void comboboxList() {
        ServiceReservation sr = new ServiceReservation();
        List<String> reservations = sr.afficherNOM();
        ObservableList<String> observableReservation = FXCollections.observableArrayList(reservations);
        combo_nom.setItems(observableReservation);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table();
        comboboxList();
    }

}
