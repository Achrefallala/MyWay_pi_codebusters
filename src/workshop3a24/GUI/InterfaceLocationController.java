/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.awt.Insets;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import workshop3a24.Entities.Location;
import workshop3a24.Services.ServiceLocation;

/**
 * FXML Controller class
 *
 * @author DELL
 */

public class InterfaceLocationController implements Initializable {


    /**
     * Initializes the controller class.
     */
   // public class InterfacelocationController implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private FlowPane flowPane;
    ServiceLocation sl=new ServiceLocation(); 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<Location> l = sl.afficher(); 
        
        setLocations(l);
        // TODO
    }

    public void setLocations(List<Location> locations) {
        flowPane.getChildren().clear();
        for (Location location : locations
             
                ) {
            MycardnewController mycardnewController = new MycardnewController(location);
            flowPane.getChildren().add(mycardnewController);

        }
    }

    } 
