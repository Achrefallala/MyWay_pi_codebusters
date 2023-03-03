/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Trajet.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import myway.Entities.Trajet;


/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class AjouterTrajetFXMLController implements Initializable {

    Trajet trajet;
    
    @FXML
    private TextField tfDestination;
    @FXML
    private TextField tfDepart;
    @FXML
    private TextArea tfEtat;
    @FXML
    private TextArea tfDirections;
    @FXML
    private TextField tfImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public Trajet getTrajet(){
        trajet = new Trajet();
        
        trajet.setDepart(tfDepart.getText());
        trajet.setDestination(tfDestination.getText());
        trajet.setEtat(tfEtat.getText());
        trajet.setDirections(tfDirections.getText());
        trajet.setImage(tfImage.getText());
        
        
       return trajet;
    }
    
    public void setTrajet(Trajet trajet){
        
        
        tfDepart.setText(trajet.getDepart());
        tfDestination.setText(trajet.getDestination());
        tfEtat.setText(trajet.getEtat());
        tfDirections.setText(trajet.getDirections());
        tfImage.setText(trajet.getImage());
        
    }
    
}
