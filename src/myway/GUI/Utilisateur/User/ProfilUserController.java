/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Utilisateur.User;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import myway.Entities.Utilisateur;
import myway.Services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class ProfilUserController implements Initializable {

    @FXML
    private Button ModifierID;
    @FXML
    private Button logout;
    @FXML
    private Button btnOpenimgFile;
    @FXML
    private ImageView ivFiles;
    @FXML
    private TextField numText;
    @FXML
    private TextField motText;
    @FXML
    private TextField mailText;
    @FXML
    private TableView<Utilisateur> table;
    @FXML
    private TableColumn<Utilisateur, Integer> numCol;
    @FXML
    private TableColumn<Utilisateur, String> motCol;
    @FXML
    private TableColumn<Utilisateur, String> e_mailCol;

    final FileChooser fc = new FileChooser();
    ServiceUtilisateur ss = new ServiceUtilisateur();
    List<Utilisateur> stat = ss.afficher2();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        table2();

        logout.setOnAction((event) -> {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginFXML.fxml"));
                Parent root = loader.load();
                logout.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.print(ex.getMessage());
                System.out.println("erreur");
            }// TODO
        });

    }

    public void table2() {
        List<Utilisateur> stat;
        
        stat = ss.afficher();
        ObservableList<Utilisateur> listStat = FXCollections.observableArrayList(stat);
        numCol.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
        motCol.setCellValueFactory(new PropertyValueFactory<>("motdepasse"));
        e_mailCol.setCellValueFactory(new PropertyValueFactory<>("e_mail"));

        table.setItems(listStat);
        // TODO

    }

    @FXML
    private void modifier(ActionEvent event) {

        int myIndex = table.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));

        int num_tel = Integer.parseInt(String.valueOf(numText.getText()));
        String motdepasse = motText.getText();
        String e_mail = mailText.getText();

        Utilisateur r = new Utilisateur(id, num_tel, motdepasse, e_mail);
        ss.modifier2(r);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("profil update");

        alert.setHeaderText("complaint update");
        alert.setContentText("Updated!");

        alert.showAndWait();
        table2();

    }

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
        int index = -1;
        index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        numText.setText(numCol.getCellData(index).toString());
        motText.setText(motCol.getCellData(index));
        mailText.setText(e_mailCol.getCellData(index));

    }

    @FXML
    private void handleOpenimgFile(ActionEvent event) {
        fc.setTitle("my file chooser");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = fc.showOpenDialog(null);
        if (file != null) {
            ivFiles.setImage(new Image(file.toURI().toString()));
        } else {
            System.out.println("A file is invalid!");
        }
    }

}
