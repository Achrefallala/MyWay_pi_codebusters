/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

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
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import workshop3a24.Entities.Location;
import workshop3a24.Services.ServiceLocation;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class HomeLocationFxmlController implements Initializable {
 ServiceLocation locations=new ServiceLocation() ;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtDispo;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtType;
    @FXML
    private TableColumn<Location, String> nomColmn;
    @FXML
    private TableColumn<Location, String> dispoColmn;
    @FXML
    private TableColumn<Location,String> typeColmn;
      @FXML
    private TableView<Location> tableLocation;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private TableColumn<Location,String> DescriptionColmn;
    @FXML
    private TableColumn<Location, Integer> ID;
    @FXML
    private TextField search;
    @FXML
    private Button btnGenPDF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize (URL url, ResourceBundle rb) {
        table();
        // TODO
    }    
   
    
    public void table(){
    tableLocation.setItems(FXCollections.observableArrayList(locations.afficher()));
        System.out.println(locations.afficher());
        ID.setCellValueFactory(new PropertyValueFactory<>("id_location"));
        nomColmn.setCellValueFactory (new PropertyValueFactory<> ("nom"));
        dispoColmn.setCellValueFactory (new PropertyValueFactory<> ("disponibilite"));
        typeColmn.setCellValueFactory (new PropertyValueFactory<> ("type"));
        DescriptionColmn.setCellValueFactory (new PropertyValueFactory<> ("description"));
    
        
        
    tableLocation.setRowFactory(tv -> {
		     TableRow<Location> myRow = new TableRow<>();
		     myRow.setOnMouseClicked ((event) -> 
		     {
		        if (event.getClickCount() == 1 && (!myRow.isEmpty()))
		        {
		            int myIndex =  tableLocation.getSelectionModel().getSelectedIndex();
		           int id_location = Integer.parseInt(String.valueOf(tableLocation.getItems().get(myIndex).getId()));
		            txtNom.setText(tableLocation.getItems().get(myIndex).getNom());
                             txtDispo.setText(tableLocation.getItems().get(myIndex).getDisponibilite());
                              txtType.setText(tableLocation.getItems().get(myIndex).getType());
                            txtDescription.setText(tableLocation.getItems().get(myIndex).getDescription());
                           
//                            fxChoiceBox.
                         
                           
		        }
		     });
		        return myRow;
                  });    
    
    }
    
    
    
 @FXML
   private void supprimer (ActionEvent event) {
       int myIndex =  tableLocation.getSelectionModel().getSelectedIndex();
        int id_location = Integer.parseInt(String.valueOf(tableLocation.getItems().get(myIndex).getId()));
        locations.supprimerBYid(id_location);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Location supprime");
             table();
            
            alert.setHeaderText("Location Registration");
            alert.setContentText("Deleted!");

            alert.showAndWait();
    }

    @FXML
    private void ajouter(ActionEvent event) {
        
       if(isInputValid()){
            String nom=txtNom.getText();
             String disponibilite=txtDispo.getText();
              String type=txtType.getText();
        String description=txtDescription.getText();
     
        //User u =new User(User.currenUserId, "sou");
            
        
          Location l = new Location(nom,disponibilite,type,description);
            locations.add(l);
            tableLocation.setItems(FXCollections.observableArrayList(locations.afficher()));
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);  
            alert.setTitle("Creation de location"); 
            alert.setHeaderText("Creation de la location"); 
            alert.setContentText("Location crée!");         
            alert.showAndWait(); 


            txtNom.setText("");
            txtDispo.setText("");
            txtType.setText("");
            txtDescription.setText("");
        }
        
        
        
    }

   @FXML
    private void modifier(ActionEvent event) {
        if(isInputValid()){
        int myIndex = tableLocation.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(tableLocation.getItems().get(myIndex).getId()));
            String nom = txtNom.getText();
            String disponibilite = txtDispo.getText();
           String type = txtType.getText();
           String description = txtDescription.getText();
          
            
             Location l = new Location(id,nom,disponibilite,type,description);
                locations.modifier(l);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("location modification");

                alert.setHeaderText("location modif");
                
                alert.setContentText("Updateddd!");

                alert.showAndWait();
                                table();
        }
    }
    
    
    
    
    @FXML
    private void filter(KeyEvent event) {
        ObservableList<Location> filteredLocation = FXCollections.observableArrayList(locations.afficher());
        //    ObservableList<Person> filteredPeople = people.filtered(p -> p.getAge() >= 30 && p.getAge() < 40);  

        ObservableList<Location> newdata = filteredLocation.stream()
                .filter(n -> n.getDisponibilite().toLowerCase().contains(search.getText().toLowerCase())
                || n.getDisponibilite().toLowerCase().equals(search.getText())
                || n.getDescription().toLowerCase().contains(search.getText())
                || n.getNom().toLowerCase().contains(search.getText().toLowerCase())
                || n.getNom().toLowerCase().equals(search.getText())
                || n.getType().toLowerCase().contains(search.getText().toLowerCase())
                || n.getType().toLowerCase().equals(search.getText()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        tableLocation.setItems(newdata);   

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
            Paragraph ph1 = new Paragraph("Rapport Pour les ocations :" + DateRapport);
            Paragraph ph2 = new Paragraph(".");
            PdfPTable table = new PdfPTable(5);

            //On créer l'objet cellule.
            PdfPCell cell;

            //contenu du tableau.
            table.addCell("ID Location");
            table.addCell("NOM");
            table.addCell("DISPONIBILITE");
            table.addCell("TYPE");
                        table.addCell("DESCRIPTION");

            Location r = new Location();
            locations.afficher().forEach(e
                    -> {
                table.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(String.valueOf(e.getId()));
                table.addCell(String.valueOf(e.getNom()));
                table.addCell(String.valueOf(e.getDisponibilite()));
                table.addCell(String.valueOf(e.getType()));
                                table.addCell(String.valueOf(e.getDescription()));


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
    
    
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (txtNom.getText() == null || txtNom.getText().length() == 0  || txtNom.getText().matches("[0-9]+") ) {
            errorMessage += "Invalide Nom!\n"; 
        }
        if (txtDispo.getText() == null || txtDispo.getText().length() == 0 || txtDispo.getText().matches("[0-9]+")) {
            errorMessage += "Invalide !\n"; 
        }
        if (txtType.getText() == null || txtType.getText().length() == 0 || txtType.getText().matches("[0-9]+")) {
            errorMessage += "Invalide Type!\n"; 
        }
         if (txtDescription.getText() == null || txtDescription.getText().length() == 0 || txtDescription.getText().matches("[0-9]+")) {
            errorMessage += "Invalide Description!\n"; 
        }
    
     if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            
            alert.setTitle("Invalide champs");
            alert.setHeaderText("***Please correct champs **");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }

    


    
    
}
