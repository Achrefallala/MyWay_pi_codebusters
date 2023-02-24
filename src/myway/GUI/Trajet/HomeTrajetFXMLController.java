/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Trajet;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import myway.Entities.Etablissement;
import myway.Entities.MoyenTransport;
import myway.Entities.Trajet;
import myway.Services.ServiceEtablissement;
import myway.Services.ServiceMoyenTransport;
import myway.Services.ServiceTrajet;

/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class HomeTrajetFXMLController implements Initializable {
    
    ServiceTrajet seTrajet = new ServiceTrajet();
    ServiceMoyenTransport  seMoyen = new ServiceMoyenTransport();
    ServiceEtablissement seEtab = new ServiceEtablissement();
    
    

    @FXML
    private TextField tfDepart;
    @FXML
    private TextField tfDest;
    @FXML
    private TableView<MoyenTransport> tableMoyenTransport;
    @FXML
    private TableColumn<MoyenTransport, String> organisation;
    @FXML
    private TableColumn<MoyenTransport, String> type;
    @FXML
    private TableColumn<MoyenTransport, String> icon;
    @FXML
    private TableColumn<MoyenTransport, Integer> nbr_places;
    @FXML
    private TableColumn<MoyenTransport, Double> prix_ticket;
    @FXML
    private TableColumn<MoyenTransport, String> horaires;
    @FXML
    private ImageView ImageMap;
    @FXML
    private TextArea tfDirections;
    @FXML
    private TextArea tfEtat;
    @FXML
    private TableView<Etablissement> tableEtablissement;
    @FXML
    private TableColumn<Etablissement, String> nom;
    @FXML
    private TableColumn<Etablissement, String> type_etab;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Trajet t = seTrajet.findByDepartAndDestination("Manouba", "ariana");
        tfDepart.setText(t.getDepart());
        tfDest.setText(t.getDestination());
        
        //ImageMap.setImage(new Image("ariana.png"));
        
        ObservableList<MoyenTransport> data = FXCollections.observableArrayList(seMoyen.findByIdTrajet(t.getId()));
        
        organisation.setCellValueFactory(new PropertyValueFactory<MoyenTransport,String>("organisation"));
        type.setCellValueFactory(new PropertyValueFactory<MoyenTransport,String>("type"));
        icon.setCellValueFactory(new PropertyValueFactory<MoyenTransport,String>("icon"));
        nbr_places.setCellValueFactory(new PropertyValueFactory<MoyenTransport,Integer>("nbr_places"));
        prix_ticket.setCellValueFactory(new PropertyValueFactory<MoyenTransport,Double>("prix_ticket"));
        horaires.setCellValueFactory(new PropertyValueFactory<MoyenTransport,String>("horaires"));
        tableMoyenTransport.setItems(data);
        
        
        
        tfDirections.setText(t.getDirections());
        tfEtat.setText(t.getEtat());
        
        ObservableList<Etablissement> data_etablissement = FXCollections.observableArrayList(seEtab.findById_trajet(t.getId()));
        
        nom.setCellValueFactory(new PropertyValueFactory<Etablissement,String>("nom"));
        type_etab.setCellValueFactory(new PropertyValueFactory<Etablissement,String>("type"));
        
        tableEtablissement.setItems(data_etablissement);
        
        
    }    
    
}
