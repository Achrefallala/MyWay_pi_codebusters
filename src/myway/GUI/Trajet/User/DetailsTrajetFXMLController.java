/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Trajet.User;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import myway.Entities.Etablissement;
import myway.Entities.LigneTransport;
import myway.Entities.MoyenTransport;
import myway.Entities.Trajet;
import myway.Services.ServiceEtablissement;
import myway.Services.ServiceLigneTransport;
import myway.Services.ServiceMoyenTransport;

/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class DetailsTrajetFXMLController implements Initializable {
    
    ServiceMoyenTransport  seMoyen = new ServiceMoyenTransport();
    ServiceEtablissement seEtab = new ServiceEtablissement();
    private Trajet t;

    @FXML
    private TextField tfDepart;
    @FXML
    private TextField tfDest;
    @FXML
    private TableView<MoyenTransport> tableMoyenTransport;
    @FXML
    private TableColumn<MoyenTransport, String> columnMoyenOrganisation;
    @FXML
    private TableColumn<MoyenTransport, String> columnMoyenType;
    @FXML
    private TableColumn<MoyenTransport, String> columnMoyenIcon;
    @FXML
    private TableColumn<MoyenTransport, Integer> columnMoyenNbrPlaces;
    @FXML
    private TableColumn<MoyenTransport, Double> columnMoyenPrix;
    @FXML
    private TableColumn<MoyenTransport, String> columnMoyenHoraires;
    @FXML
    private ImageView ImageMap;
    @FXML
    private TextArea tfDirections;
    @FXML
    private TextArea tfEtat;
    @FXML
    private TableView<Etablissement> tableEtablissement;
    @FXML
    private TableColumn<Etablissement, String> columnEtabNom;
    @FXML
    private TableColumn<Etablissement, String> columnEtabType;
    @FXML
    private TableColumn<Etablissement, String> columnEtabDescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setTrajet(Trajet t){
        
        this.t = t;
        tfDepart.setText(t.getDepart());
        tfDest.setText(t.getDestination());
        
        //ImageMap.setImage(new Image("Assets/ariana.png"));
        
        ObservableList<MoyenTransport> listMoyenTransport = FXCollections.observableArrayList(seMoyen.findByIdTrajet(t.getId()));
        
        columnMoyenOrganisation.setCellValueFactory(new PropertyValueFactory<>("organisation"));
        columnMoyenType.setCellValueFactory(new PropertyValueFactory<>("type"));
        columnMoyenIcon.setCellValueFactory(new PropertyValueFactory<>("icon"));
        columnMoyenNbrPlaces.setCellValueFactory(new PropertyValueFactory<>("nbr_places"));
        columnMoyenPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        columnMoyenHoraires.setCellValueFactory(new PropertyValueFactory<>("horaires"));
        tableMoyenTransport.setItems(listMoyenTransport);
        
        tfDirections.setText(t.getDirections());
        tfEtat.setText(t.getEtat());
        
        ObservableList<Etablissement> listEtablissement = FXCollections.observableArrayList(seEtab.findByTrajet(t));   
        columnEtabNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnEtabType.setCellValueFactory(new PropertyValueFactory<>("type"));
        columnEtabDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tableEtablissement.setItems(listEtablissement);
    }    

    

    @FXML
    private LigneTransport reserver(MouseEvent event) {
        if (tableMoyenTransport.getSelectionModel().getSelectedItem() != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRMATION");
                alert.setHeaderText("Voulez-vous vraiment réserver ce " + tableMoyenTransport.getSelectionModel().getSelectedItem().getType() + " ?");
                Optional<ButtonType> clickedButtonConfirmation = alert.showAndWait();

                if (clickedButtonConfirmation.get() == ButtonType.OK) {
                    LigneTransport lt;
    
                    ServiceLigneTransport slt = new ServiceLigneTransport();
                    lt = slt.findByIdTrajetAndMatriculeMoyenTp(t.getId(), tableMoyenTransport.getSelectionModel().getSelectedItem().getId());
                    tableMoyenTransport.getSelectionModel().clearSelection();
                    System.out.println("vous avez reservez ce " + lt);
                    return lt;

                }else{
                    tableMoyenTransport.getSelectionModel().clearSelection();
                }
               
        }
        return null;
    }
    
}
