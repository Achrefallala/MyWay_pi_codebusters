/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservation.GUI;

import Entities.Reservation;
import Services.ServiceReservation;
import Utils.MyDB;
import static Utils.MyDB.getConnect;
import java.awt.Label;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;


/**
 *
 * @author Slim
 */
public class HomeReservationController implements Initializable {


    @FXML
    private TableView<Reservation> reservationsTable;

    @FXML
    private TableColumn<Reservation,String> idreservationCol;

    @FXML
    private TableColumn<Reservation,String> idutilisateurCol;

    @FXML
    private TableColumn<Reservation,String> moyentransportCol;

    @FXML
    private TableColumn<Reservation,String> disponibiliteCol;

    @FXML
    private javafx.scene.control.TextField txtidutilisateur;


    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;
    @FXML
    private javafx.scene.control.TextField txtmoyen;
    @FXML
    private javafx.scene.control.TextField txtdispo;
        Connection cnx;
PreparedStatement pst;
    @FXML
    void Add(ActionEvent event) {

        
            String id_utilisateur,moyen_transport,disponibilite_r;
            id_utilisateur = txtidutilisateur.getText();
            moyen_transport = txtmoyen.getText();
            disponibilite_r = txtdispo.getText();
        try
        {
            PreparedStatement pst = cnx.prepareStatement("insert into registation(id_utilisateur,moyen_transport,disponibilite_r)values(?,?,?)");
            pst.setString(1, id_utilisateur);
            pst.setString(2, moyen_transport);
            pst.setString(3, disponibilite_r);
            pst.executeUpdate();
          
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Reservation Registation");
 
alert.setHeaderText("Reservation Registation");
alert.setContentText("Record Addedddd!");
 
alert.showAndWait();
 
           table();
            
            txtidutilisateur.setText("");
            txtmoyen.setText("");
            txtdispo.setText("");
            txtidutilisateur.requestFocus();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(HomeReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }

   public void table()
      {
          Connect();
          ObservableList<Reservation> reservations = FXCollections.observableArrayList();
       try
       {
           pst = con.prepareStatement("select id_reservation,id_utilisateur,moyen_transport,disponinilite_r from registation");  
           ResultSet rs = pst.executeQuery();
      {
        while (rs.next())
        {
            Reservation r = new Reservation();
            r.setId_reservation(rs.getInt("id_reservation"));
            r.setId_utilisateur(rs.getInt("id_utilisateur"));
            r.setMoyen_transport(rs.getString("moyen_transport"));
            r.setDisponibilite_r(rs.getString("disponibilite_r"));
           reservations.add(r);
       }
    }
                table.setItems(reservations);
                idreservationCol.setCellValueFactory(f -> f.getValue().idProperty());
                idutilisateurCol.setCellValueFactory(f -> f.getValue().nameProperty());
                moyentransportCol.setCellValueFactory(f -> f.getValue().mobileProperty());
                disponibiliteCol.setCellValueFactory(f -> f.getValue().courseProperty());
                
              
 
       }
      
       catch (SQLException ex)
       {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
 
                table.setRowFactory( tv -> {
     TableRow<Student> myRow = new TableRow<>();
     myRow.setOnMouseClicked (event ->
     {
        if (event.getClickCount() == 1 && (!myRow.isEmpty()))
        {
            myIndex =  table.getSelectionModel().getSelectedIndex();
           id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
           txtName.setText(table.getItems().get(myIndex).getName());
           txtMobile.setText(table.getItems().get(myIndex).getMobile());
                            txtCourse.setText(table.getItems().get(myIndex).getCourse());
                          
                        
                          
        }
     });
        return myRow;
                   });
    
    
      }
 
    @FXML
    void Delete(ActionEvent event) {
        myIndex = table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                    
 
        try
        {
            pst = con.prepareStatement("delete from registation where id = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Registationn");
 
alert.setHeaderText("Student Registation");
alert.setContentText("Deletedd!");
 
alert.showAndWait();
                  table();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    @FXML
    void Update(ActionEvent event) {
      
        String stname,mobile,course;
        
         myIndex = table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
          
            stname = txtName.getText();
            mobile = txtMobile.getText();
            course = txtCourse.getText();
        try
        {
            pst = con.prepareStatement("update registation set name = ?,mobile = ? ,course = ? where id = ? ");
            pst.setString(1, stname);
            pst.setString(2, mobile);
            pst.setString(3, course);
             pst.setInt(4, id);
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Student Registationn");
 
alert.setHeaderText("Student Registation");
alert.setContentText("Updateddd!");
 
alert.showAndWait();
                table();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;
    
    
    
     public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/studcruds","root","");
        } catch (ClassNotFoundException ex) {
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        table();
    }    
   

