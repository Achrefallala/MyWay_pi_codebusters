/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import static com.oracle.webservices.internal.api.databinding.DatabindingModeFeature.ID;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import workshop3a24.Entities.contrat_location;
import workshop3a24.Services.ServiceContratLocation;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ContratLocationController implements Initializable {

    ServiceContratLocation sc = new ServiceContratLocation();

    @FXML
    private TableColumn<contrat_location, Integer> IDColumn;

    @FXML
    private Button btnDelete;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;

    @FXML
    private TextField txtPrix;
    @FXML
    private DatePicker txtDebut;
    @FXML
    private DatePicker txtFin;
    @FXML
    private TableView<contrat_location> contable;
    @FXML
    private TableColumn<contrat_location, Float> prixColmn;
    @FXML
    private TableColumn<contrat_location, Date> debutColmn;
    @FXML
    private TableColumn<contrat_location, Date> finColmn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table();
    }

    public void table() {
        contable.setItems(FXCollections.observableArrayList(sc.afficher()));
        //System.out.println(locations.afficher());
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("id_location"));
        prixColmn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        debutColmn.setCellValueFactory(new PropertyValueFactory<>("debut"));
        finColmn.setCellValueFactory(new PropertyValueFactory<>("fin"));

        contable.setRowFactory(tv -> {
            TableRow<contrat_location> myRow = new TableRow<>();
            myRow.setOnMouseClicked((event)
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    int myIndex = contable.getSelectionModel().getSelectedIndex();
                    int id_location = Integer.parseInt(String.valueOf(contable.getItems().get(myIndex).getId_location()));
                     txtPrix.setText(String.valueOf((Float)contable.getItems().get(myIndex).getPrix()));
                   // txtPrix.setText(contable.getItems().get(myIndex).;
                    // txtDebut.setValue(contable.getItems().get(myIndex).getDebut());
                    // txtDebut.setValue(tableLocation.getItems().get(myIndex).getFin());
                    Date debutttttttt = (Date) contable.getItems().get(myIndex).getDebut();
                    LocalDate localDate = debutttttttt.toLocalDate();
                    Date finnnnnnn = (Date) contable.getItems().get(myIndex).getFin();
                    LocalDate localDate1 = finnnnnnn.toLocalDate();
                    txtDebut.setValue(localDate);
                    txtFin.setValue(localDate1);
                                     
                         
                           
                }
            });
            return myRow;
        });

    }

    @FXML
    private void supprimer(ActionEvent event) {
        int myIndex = contable.getSelectionModel().getSelectedIndex();
        int id_location = Integer.parseInt(String.valueOf(contable.getItems().get(myIndex).getId_location()));
        sc.supprimerByid(id_location);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("location suiprrmer");
        table();

        alert.setHeaderText("location Registation");
        alert.setContentText("Deleted!");

        alert.showAndWait();
    }

    @FXML
    private void ajouter(ActionEvent event) {

        if (isInputValid()) {
            
            
           float prix=Float.parseFloat(txtPrix.getText());
            LocalDate localDate = txtDebut.getValue();
            Date sqlDate = Date.valueOf(localDate);
            LocalDate localDate1 = txtFin.getValue();
            Date sqlDate1 = Date.valueOf(localDate1);

            //User u =new User(User.currenUserId, "sou");
            contrat_location cl = new contrat_location(prix,sqlDate,sqlDate1);
            sc.add(cl);
            table();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Creation de location");
            alert.setHeaderText("Creation de la location");
            alert.setContentText("Location crée!");
            alert.showAndWait();

            txtPrix.setText("");
            txtDebut.setValue(null);
            txtFin.setValue(null);
           
            
        }

    }

    @FXML
    private void modifier(ActionEvent event) {
        boolean ok = true;
        if (isInputValid()) {
            int myIndex = contable.getSelectionModel().getSelectedIndex();
            int id = Integer.parseInt(String.valueOf(contable.getItems().get(myIndex).getId_location()));
             float prix=Float.parseFloat(txtPrix.getText());
            LocalDate localDate = txtDebut.getValue();
            Date sqlDate = Date.valueOf(localDate);
            LocalDate localDate1 = txtFin.getValue();
            Date sqlDate1 = Date.valueOf(localDate1);
            contrat_location l = new contrat_location(id, prix,sqlDate,sqlDate1 );
            
             if(!sqlDate.before(sqlDate1)){
                      Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Date Debut > Date Fin");
                alert.showAndWait();
             ok = false;
                 return;
            }
            
             if (ok==true){
            sc.modifier(l);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("location modification");

            alert.setHeaderText("location modif");
            alert.setContentText("Updateddd!");

            alert.showAndWait();
            table();}
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";
       
        

        if (txtPrix.getText() == null || txtPrix.getText().length() == 0 ) {
            errorMessage += "Invalide prix!\n";
        }
        if (txtDebut.getValue()== null) {
            errorMessage += "Invalide date de debut!\n";
        }
        if (txtFin.getValue()== null ) {
            errorMessage += "Invalide date de fin!\n";
        }
       
        if (errorMessage.length() == 0) {
            return true;
        } else {
            
           
             
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);

            alert.setTitle("Invalide champs");
            alert.setHeaderText("***Please correct your items **");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            
            return false;
        }
    }

}
