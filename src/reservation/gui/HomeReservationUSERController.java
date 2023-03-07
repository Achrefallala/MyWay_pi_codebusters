/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.gui;

import Entities.LigneTransport;
import Entities.Reservation;
import Entities.Ticket;
import Entities.Trajet;
import Services.ServiceLigneTransport;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Slim
 */
public class HomeReservationUSERController implements Initializable {

    @FXML
    private Label tfdepart;
    @FXML
    private Label tfdestination;
    @FXML
    private Label tfmoyen;
    @FXML
    private Label tfprix;
    @FXML
    private Label tfprix1;
    @FXML
    private Button addreservation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServiceLigneTransport sl = new ServiceLigneTransport();
       LigneTransport l = sl.findByIdTrajetAndMatriculeMoyenTp(1,"88tun77");
       tfdepart.setText(l.getTrajet().getDepart());
        tfdestination.setText(l.getTrajet().getDestination());
        tfprix.setText(Double.toString(l.getMoyentransport().getPrix()));
        tfmoyen.setText(l.getMoyentransport().getType());

    }
    
    
    /*
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
    */

}
