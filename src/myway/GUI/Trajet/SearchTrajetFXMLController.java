/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Trajet;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import myway.Entities.Trajet;
import myway.Services.ServiceTrajet;

/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class SearchTrajetFXMLController implements Initializable {

    @FXML
    private TextField tfDepart;
    @FXML
    private TextField tfDest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void chercher(ActionEvent event) {
        ServiceTrajet se = new ServiceTrajet();
        Trajet t = se.findByDepartAndDestination(tfDepart.getText(), tfDest.getText());
        System.out.println(t.toString());
        
        
    }
    
}
