/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Reclamation.Admin;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import myway.Entities.Reclamation;
import myway.Entities.Reponse;
import myway.Services.ServiceReclamation;
import myway.Services.ServiceReponse;

/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class AfficherReclamationController implements Initializable {
    
    ServiceReclamation sp = new ServiceReclamation();
    
    

    @FXML
    private TableView<Reclamation> reclamationTable;
    @FXML
    private TableColumn<Reclamation, Integer> idCol;
    @FXML
    private TableColumn<Reclamation, String> messageCol;
    @FXML
    private TableColumn<Reclamation, String> nomCol;
    @FXML
    private TableColumn<Reclamation, String> prenomCol;
    @FXML
    private TableColumn<Reclamation, String> categorieCol;
   
    @FXML
    private TextField txtmessage;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtsearch;
    @FXML
    private Button reponses;
    @FXML
    private TextField txtreponse;
    @FXML
    private Button repondre;
   
 

    /**
     * Initializes the controller class.
     */
    //private final ObservableList<Reclamation> dataList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table();
        reponses.setOnAction((event) -> {

                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("RepondreReclamation.fxml"));
                            Parent root = loader.load();
                            reponses.getScene().setRoot(root);
                        } catch (IOException ex) {
                            System.out.print(ex.getMessage());
                            System.out.println("wrong!!");
                        }

                    })
                ;
     
    }    
    
     public void table() {
        reclamationTable.setItems(FXCollections.observableArrayList(sp.display()));
        
        idCol.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
        messageCol.setCellValueFactory(new PropertyValueFactory<>("message"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        categorieCol.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        
        reclamationTable.setRowFactory(tv -> {
            TableRow<Reclamation> myRow = new TableRow<>();
            myRow.setOnMouseClicked((event)
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    int myIndex = reclamationTable.getSelectionModel().getSelectedIndex();
                    int id_rec = Integer.parseInt(String.valueOf(reclamationTable.getItems().get(myIndex).getId_rec()));
                    txtmessage.setText(reclamationTable.getItems().get(myIndex).getMessage());
                    txtnom.setText(reclamationTable.getItems().get(myIndex).getNom());
                    txtprenom.setText(reclamationTable.getItems().get(myIndex).getPrenom());
                   
                }
            });
            return myRow;
        });

    }
      @FXML
    private void supprimer(ActionEvent event) {
        
        int myIndex = reclamationTable.getSelectionModel().getSelectedIndex();
        int id_rec = Integer.parseInt(String.valueOf(reclamationTable.getItems().get(myIndex).getId_rec()));
        
        if (null== reclamationTable.getSelectionModel().getSelectedItem() ){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
           alert.setContentText("Please select from table");
           alert.showAndWait();
        }else {
        
        sp.supprimerByid(id_rec);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("supprimer réclamation");
        table();
        alert.setHeaderText("reclamation");
        alert.setContentText("Deleted!");

        alert.showAndWait();
    }}
    
    @FXML
    private void filter(KeyEvent event) {
        ObservableList<Reclamation> filteredPeople = FXCollections.observableArrayList(sp.display());
        //    ObservableList<Person> filteredPeople = people.filtered(p -> p.getAge() >= 30 && p.getAge() < 40);  
        ObservableList<Reclamation> newdata = filteredPeople.stream().filter(n
                -> n.getMessage().toLowerCase().contains(txtsearch.getText())
                        || n.getNom().toLowerCase().contains(txtsearch.getText().toLowerCase())
                        || n.getPrenom().toLowerCase().equals(txtsearch.getText()) 
                        || n.getType().toLowerCase().equals(txtsearch.getText()) 
                        || n.getCategorie().toLowerCase().equals(txtsearch.getText())).collect(Collectors.toCollection(FXCollections::observableArrayList)
                );
        reclamationTable.setItems(newdata);

    }
   
    
   @FXML
     private void modifier(ActionEvent event) {
      
            int myIndex = reclamationTable.getSelectionModel().getSelectedIndex();
            int id_rec = Integer.parseInt(String.valueOf(reclamationTable.getItems().get(myIndex).getId_rec()));
             
            String message = txtmessage.getText();
            String nom = txtnom.getText();
            String type = (reclamationTable.getItems().get(myIndex).getType());
            String prenom = txtprenom.getText();
            
       
            
            Reclamation r = new Reclamation(id_rec,message,type,nom,prenom );
            sp.update(r);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reclamation update");

            alert.setHeaderText("complaint update");
            alert.setContentText("Updated!");

            alert.showAndWait();
            table();
        
    }
     @FXML
    private void ajouterRep(ActionEvent event) {
    
        int myIndex = reclamationTable.getSelectionModel().getSelectedIndex();
        int id_rec = Integer.parseInt(String.valueOf(reclamationTable.getItems().get(myIndex).getId_rec()));

        String reponse = txtreponse.getText();

        if (reponse.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
        ServiceReponse sr= new ServiceReponse();
        Reponse r = new Reponse(id_rec,reponse);
            
        sr.add(r);
          
        txtreponse.setText("");
     
        }}
    
    public static void writepdf(String path,List<Reclamation> m) throws Exception {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(path+".pdf"));
    document.open();
    
  
    List<Reclamation> pdf =m ;
    
    PdfPTable table = new PdfPTable(5); // 3 columns
    table.addCell("message");
    table.addCell("type");
    table.addCell("nom");
    table.addCell("prenom");
    table.addCell("categorie");

    
    for (Reclamation obj : pdf) {
        table.addCell(obj.getMessage());
        table.addCell(obj.getNom());
        table.addCell(obj.getPrenom());
        table.addCell(obj.getCategorie().toString());
        
    }
    
    document.add(table);
    document.close();
}
    
      @FXML
    private void filechosserpdf(ActionEvent event) {
            // Create a new file chooser
        FileChooser fileChooser = new FileChooser();

        // Set the initial directory (optional)
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        // Set the title of the file chooser dialog
        fileChooser.setTitle("Choose a directory to save the file");

        // Show the file chooser dialog and wait for the user to select a directory
        File selectedDirectory = fileChooser.showSaveDialog(new Stage());

        // If the user selected a directory, get the absolute path of the directory as a string
        if (selectedDirectory != null) {
            String directoryPath = selectedDirectory.getAbsolutePath();
            System.out.println("Selected directory: " + directoryPath);
            // Do something with the directory path...
        
           try {
         writepdf(directoryPath,sp.display());
        } catch (Exception e) {
        System.out.println("Error sending email: " + e.getMessage());

        }
           
    
    }  
        
    }   
}
