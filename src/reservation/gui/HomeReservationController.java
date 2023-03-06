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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table();
    }    

        Reservation r = new Reservation();
    ServiceReservation res = new ServiceReservation();

    Connection cnx;
    ObservableList<Reservation> listRes;
    @FXML
    private Button btnGenPDF;
    @FXML
    private TableView<ResultReservation> tableRes;
    @FXML
    private TableColumn<ResultReservation, String> nomutilisateurCol;
    @FXML
    private TableColumn<ResultReservation, String> moyentransportCol;
    @FXML
    private TableColumn<ResultReservation, String> departCol;
    @FXML
    private TableColumn<ResultReservation, String> destinationCol;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txt_keyword;

    public void table() {
List<Reservation> listRes = new ArrayList<>();
    try{
        
        
        listRes=res.afficher();
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

    }catch(Exception e){
        System.out.println(e.getMessage());
    }
        
    


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

}