/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Location.User;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
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
import myway.Entities.Location;
import myway.Services.ServiceLocation;
/**
 * FXML Controller class
 *
 * @author 9naydel
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
