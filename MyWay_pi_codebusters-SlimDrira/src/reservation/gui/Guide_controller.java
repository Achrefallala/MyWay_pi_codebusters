package reservation.gui;

import Entities.Guide;
import Entities.Reservation;
import Entities.ResultReservation;
import Entities.Ticket;
import Services.ServiceGuide;
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
import java.text.SimpleDateFormat;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.collections.FXCollections;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class Guide_controller implements Initializable {
    
       public void initialize(URL url, ResourceBundle rb) {
        table();
    }


    ServiceGuide gui = new ServiceGuide();
    List<Guide> listRes = new ArrayList<>();
    ObservableList<Guide> listGui;
//            listGui = gui.afficher();
    @FXML
    private AnchorPane AnchorPane;

 
    @FXML
    private TableView<Guide> tableRes;

    @FXML
    private TableColumn<Guide, String> nomCol;

    @FXML
    private TableColumn<Guide, String> prenomCol;

    @FXML
    private TableColumn<Guide, Integer> ageCol;

    @FXML
    private TableColumn<Guide, String> langueCol;

    @FXML
    private TableColumn<Guide, String> experienceCol;

    @FXML
    private Button btnGenPDF;

    @FXML
    private TextField txt_keyword;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtprenom;

    @FXML
    private TextField txtage;

    @FXML
    private TextField txtlangues;

    @FXML
    private TextField txtexperiences;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    void ajouter(ActionEvent event) {
        try {
            // Create a new Guide object with the input values
            String nom = txtnom.getText();
            String prenom = txtprenom.getText();
            int age = Integer.parseInt(txtage.getText());
            String langues = txtlangues.getText();
            String experiences = txtexperiences.getText();
            Guide newGuide = new Guide(nom, prenom, age, langues, experiences);

            // Add the new Guide to the list and update the TableView
            if (listGui == null) {
                listGui = FXCollections.observableArrayList();
            }
            gui.add(newGuide);
            listGui.add(newGuide);
            tableRes.setItems(listGui);

            // Clear the input fields
            txtnom.clear();
            txtprenom.clear();
            txtage.clear();
            txtlangues.clear();
            txtexperiences.clear();
        } catch (NumberFormatException e) {
            // Handle invalid input for age field
            Alert alert = new Alert(AlertType.ERROR, "Invalid age value!");
            alert.showAndWait();
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions
            Alert alert = new Alert(AlertType.ERROR, "Failed to add guide!");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    void btnGenPDF(ActionEvent event) throws IOException {

        long millis = System.currentTimeMillis();
        java.sql.Date DateRapport = new java.sql.Date(millis);

        String DateLyoum = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(DateRapport);//yyyyMMddHHmmss
        System.out.println("Date d'aujourdhui : " + DateLyoum);

        com.itextpdf.text.Document document = new com.itextpdf.text.Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(String.valueOf(DateLyoum + ".pdf")));//yyyy-MM-dd
            document.open();
            Paragraph ph1 = new Paragraph("Liste des guides touristiques :" + DateRapport);
            Paragraph ph2 = new Paragraph(".");
            PdfPTable table = new PdfPTable(5);

            //On créer l'objet cellule.
            PdfPCell cell;

            //contenu du tableau.
            table.addCell("NOM ");
            table.addCell("PRENOM");
            table.addCell("AGE");
            table.addCell("LANGUES");
            table.addCell("EXPERIENCES");

            Guide g = new Guide();
            gui.afficher().forEach(e
                    -> {
                table.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(String.valueOf(e.getNom()));
                table.addCell(String.valueOf(e.getPrenom()));
                table.addCell(String.valueOf(e.getAge()));
                table.addCell(String.valueOf(e.getLangues()));
                table.addCell(String.valueOf(e.getExperiences()));

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
    void modifier(ActionEvent event) {
        // Get the selected Guide from the TableView
        Guide selectedGuide = tableRes.getSelectionModel().getSelectedItem();
        if (selectedGuide == null) {
            // If no Guide is selected, show an error message
            Alert alert = new Alert(AlertType.ERROR, "Please select a guide to update!");
            alert.showAndWait();
            return;
        }

        try {
            // Update the selected Guide with the input values
            String nom = txtnom.getText();
            String prenom = txtprenom.getText();
            int age = Integer.parseInt(txtage.getText());
            String langues = txtlangues.getText();
            String experiences = txtexperiences.getText();
            selectedGuide.setNom(nom);
            selectedGuide.setPrenom(prenom);
            selectedGuide.setAge(age);
            selectedGuide.setLangues(langues);
            selectedGuide.setExperiences(experiences);

            // Update the Guide in the list and update the TableView
            gui.modifier(selectedGuide);
            tableRes.refresh();

            // Clear the input fields
            txtnom.clear();
            txtprenom.clear();
            txtage.clear();
            txtlangues.clear();
            txtexperiences.clear();
        } catch (NumberFormatException e) {
            // Handle invalid input for age field
            Alert alert = new Alert(AlertType.ERROR, "Invalid age value!");
            alert.showAndWait();
        } catch (Exception e) {
            // Handle other exceptions
            Alert alert = new Alert(AlertType.ERROR, "Failed to update guide!");
            alert.showAndWait();
        }
    }

    @FXML
    void searchBar(KeyEvent event) {
        ServiceGuide sr = new ServiceGuide();
        List<Guide> l = sr.afficher();
        ObservableList<Guide> newdata = l.stream()
                .filter(n -> n.getNom().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                || n.getLangues().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                || n.getPrenom().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                || n.getExperiences().toLowerCase().contains(txt_keyword.getText().toLowerCase())).collect(Collectors.toCollection(FXCollections::observableArrayList));
        tableRes.setItems(newdata);
    }

    @FXML
    void supprimer(ActionEvent event) {
        // Get the selected Guide from the TableView
        Guide selectedGuide = tableRes.getSelectionModel().getSelectedItem();
        if (selectedGuide == null) {
            // If no Guide is selected, show an error message
            Alert alert = new Alert(AlertType.ERROR, "Please select a guide to delete!");
            alert.showAndWait();
            return;
        }

        // Remove the selected Guide from the list and update the TableView
        gui.supprimer(selectedGuide.getId());
        listGui.remove(selectedGuide);
        tableRes.setItems(listGui);
    }
/*
    public void table() {

        try {

            Guide r = new Guide();
            List<Guide> listRes = new ArrayList<>();
               listRes = gui.afficher();


            for (Guide gui : listRes) {

                r = new Guide();

                r.getId();
                r.getNom();
                r.getPrenom();
                r.getAge();
                r.getLangues();
                r.getExperiences();
//                     r.getEtoiles();

                listGui.add(r);
            }

            tableRes.setItems(FXCollections.observableArrayList(listGui));
            nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
            langueCol.setCellValueFactory(new PropertyValueFactory<>("langues"));
            experienceCol.setCellValueFactory(new PropertyValueFactory<>("experiences"));

            tableRes.setRowFactory(tv -> {
                TableRow<Guide> myRow = new TableRow<>();
                myRow.setOnMouseClicked((event) -> {
                    if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                        int myIndex = tableRes.getSelectionModel().getSelectedIndex();
                        // do something with the selected row
                    }
                });
                return myRow;
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
*/
    public void table() {
    nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
    prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
    langueCol.setCellValueFactory(new PropertyValueFactory<>("langues"));
    experienceCol.setCellValueFactory(new PropertyValueFactory<>("experiences"));
    listGui = FXCollections.observableArrayList();
listGui.addAll(gui.afficher());
tableRes.setItems(listGui);


    
    // Allow selecting a row from the table
    tableRes.setRowFactory(tv -> {
        TableRow<Guide> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && !row.isEmpty()) {
                Guide guide = row.getItem();
                txtnom.setText(guide.getNom());
                txtprenom.setText(guide.getPrenom());
                txtage.setText(String.valueOf(guide.getAge()));
                txtlangues.setText(guide.getLangues());
                txtexperiences.setText(guide.getExperiences());
            }
        });
        return row;
    });
}
}
