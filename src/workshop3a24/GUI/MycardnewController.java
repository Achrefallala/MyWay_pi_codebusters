/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import workshop3a24.Entities.Location;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class MycardnewController extends Pane implements Initializable {

    @FXML
    private TextField txtN;
    @FXML
    private TextField txtD;
    @FXML
    private TextField txtT;
    @FXML
    private TextField txtDesc;
    @FXML
    private TextField txtP;
   private Location location ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtN.setText(location.getNom());
        txtD.setText(location.getDisponibilite());
        txtT.setText(location.getType());
        txtDesc.setText(location.getDescription());
        
        
        
        // TODO
    }    
    BorderPane borderpane=new BorderPane();
   // borderpane.setBottom(txtN,txtD,txtT,txtDesc);
    
   // tableLocation.setItems(FXCollections.observableArrayList(locations.afficher()));
    
}
