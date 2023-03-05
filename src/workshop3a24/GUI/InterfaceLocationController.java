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

    @FXML
    private ScrollPane scrollpane;
    @FXML
    private FlowPane Flow;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceLocation sl =new ServiceLocation();
       

         List <Location> l= sl.afficher();
      //  ObservableList<Node> children = Flow.getChildren()
                
                for (Location m :l ){
             
       
            BorderPane borderpane = new BorderPane();
            

            borderpane.setPadding(new javafx.geometry.Insets(10, 10, 0, 10));
            Label labelN = new Label(m.getNom());
             Label labelDIS = new Label(m.getDisponibilite());
              Label labelT = new Label(m.getType());
            borderpane.setTop(labelN);
            borderpane.setCenter(labelDIS);
            borderpane.setBottom(labelT);
            Flow.getChildren().addAll(borderpane);
            
            
            
                }
                // TODO
;
    }  
    
    
}
