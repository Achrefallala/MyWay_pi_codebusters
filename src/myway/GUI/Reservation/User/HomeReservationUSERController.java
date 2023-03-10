/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Reservation.User;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author 9naydel
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.google.zxing.common.ByteMatrix;

//import com.google.zxing.common.ByteMatrix;
import java.util.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.stage.FileChooser;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.Image;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import myway.Entities.LigneTransport;
import myway.Entities.Reservation;
import myway.Entities.ResultReservation;
import myway.Entities.ResultTicket;
import myway.Entities.Ticket;
import myway.Entities.Utilisateur;
import myway.Services.ServiceLigneTransport;
import myway.Services.ServiceReservation;
import myway.Services.ServiceTicket;
import myway.Services.ServiceUtilisateur;


import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.google.zxing.common.ByteMatrix;

//import com.google.zxing.common.ByteMatrix;
import java.util.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.stage.FileChooser;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.Image;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import myway.GUI.Trajet.User.CurrentLigneTransportId;

   public class HomeReservationUSERController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceLigneTransport sl = new ServiceLigneTransport();
       // ResultReservation rr = new ResultReservation();
        LigneTransport l = sl.findByIdLigne(CurrentLigneTransportId.id);
        int id = l.getId();
        System.out.println(id+"aaaaaaa");
                System.out.println(l+"test");

        tfdepart.setText(sl.findByIdLigne(74).getTrajet().getDepart());
        tfdestination.setText(l.getTrajet().getDestination());
        tfprix.setText(Double.toString(l.getMoyenTransport().getPrix()));
        tfmoyen.setText(l.getMoyenTransport().getType());
       

        
      /*  try {/
            generateQR("drira", 15);

        } catch (WriterException ex) {
            Logger.getLogger(HomeReservationUSERController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    Ticket t = new Ticket();
    ServiceTicket tic = new ServiceTicket();
    Connection cnx;

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
    private Button btnGenPDF;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void btnGenPDF(ActionEvent event) throws IOException, WriterException {
        long millis = System.currentTimeMillis();
        java.sql.Date DateRapport = new java.sql.Date(millis);

        String DateLyoum = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(DateRapport);
        System.out.println("Date d'aujourd'hui : " + DateLyoum);

        com.itextpdf.text.Document document = new com.itextpdf.text.Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(String.valueOf(DateLyoum + ".pdf")));
            document.open();
            Paragraph ph1 = new Paragraph("Votre ticket a été créé avec succès! :" + DateRapport);
            Paragraph ph2 = new Paragraph(".");
            PdfPTable table = new PdfPTable(6);

            PdfPCell cell;

            table.addCell("NOM UTILISATEUR");
            table.addCell("PRIX TICKET");
            table.addCell("DEPART");
            table.addCell("DESTINATION");
            table.addCell("DATE TICKET");
            table.addCell("MOYEN TRANSPORT");

            Reservation r = new Reservation();
            LigneTransport l = new LigneTransport();
            Utilisateur u = new Utilisateur();
            Ticket t = new Ticket();
            t.setReservation(r);
            t.setLigne(l);
            t.setUtilisateur(u);
            List<Ticket> tickets = new ArrayList<Ticket>();
            tickets = tic.afficher();
  
            tickets.forEach(e -> {
                
                
                System.out.println("TTTTTTTTTTTTTTTTTT"+e);
          
                table.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(String.valueOf(e.getUtilisateur().getNom()));
                table.addCell(String.valueOf(e.getLigne().getMoyenTransport().getPrix()));
                table.addCell(String.valueOf(e.getLigne().getTrajet().getDepart()));
                table.addCell(String.valueOf(e.getLigne().getTrajet().getDestination()));
                table.addCell(String.valueOf(e.getDateticket()));
                table.addCell(String.valueOf(e.getLigne().getMoyenTransport().getType()));
            });

            // Ajout du tableau au document
            document.add(ph1);
            document.add(ph2);
            document.add(table);

            // Ajout du code QR en dessous du tableau
                      
    ServiceReservation res = new ServiceReservation();
ServiceUtilisateur uService = new ServiceUtilisateur();
ResultTicket rt = new ResultTicket();
            ResultReservation rr=new ResultReservation();

            int id_ticket = 15; // id du ticket à utiliser
            String nom = "drira"; // nom du titulaire du ticket à utiliser
            generateQR(nom, id_ticket);
            Image img = Image.getInstance("codeqr.png");
            document.add(img);
 
            // Fermeture du document
            document.close();

            // Ouverture du fichier PDF généré
            File file = new File(DateLyoum + ".pdf");
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
            }
        } catch (Exception e) {
            System.out.println("Exception&&&&&&&&&&&&&&&&&&&&");
            System.out.println(e);
        }
    }

    private void generateQR(String nom, int id_ticket) throws WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        int width = 300;
        int height = 300;
        Map<EncodeHintType, Object> hintMap = new HashMap<>();
        hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        try {
            ByteMatrix matrix = null;
            String data = nom + " " + id_ticket;
            matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height, new Hashtable<EncodeHintType, Object>(hintMap));
            BufferedImage image = MatrixToImageWriter.toBufferedImage(matrix);
            String fileName = "codeqr.png";
            ImageIO.write(image, "png", new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


