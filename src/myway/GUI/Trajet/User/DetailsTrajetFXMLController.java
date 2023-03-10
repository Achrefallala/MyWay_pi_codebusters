/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Trajet.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import myway.Entities.Etablissement;
import myway.Entities.LigneTransport;
import myway.Entities.MoyenTransport;
import myway.Entities.Trajet;
import myway.Services.ServiceEtablissement;
import myway.Services.ServiceLigneTransport;
import myway.Services.ServiceMoyenTransport;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class DetailsTrajetFXMLController implements Initializable {

    ServiceMoyenTransport seMoyen = new ServiceMoyenTransport();
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
    private TableColumn<MoyenTransport, String> columnMoyenIcon;
    @FXML
    private TableColumn<MoyenTransport, Integer> columnMoyenNbrPlaces;
    @FXML
    private TableColumn<MoyenTransport, Double> columnMoyenPrix;
    @FXML
    private TableColumn<MoyenTransport, String> columnMoyenHoraires;
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

    @FXML
    private WebView webView;
    @FXML
    private TableColumn<MoyenTransport, String> columnMoyenNom;
    @FXML
    private Button btnRetourner;

    @FXML
    private TextField weatherText;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setTrajet(Trajet t) {

        this.t = t;
        tfDepart.setText(t.getDepart());
        tfDest.setText(t.getDestination());

        //ImageMap.setImage(new Image("Assets/ariana.png"));
        ObservableList<MoyenTransport> listMoyenTransport = FXCollections.observableArrayList(seMoyen.findByIdTrajet(t.getId()));

        columnMoyenOrganisation.setCellValueFactory(new PropertyValueFactory<>("organisation"));
        columnMoyenNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ImageColumn imageColumn = new ImageColumn("", "icon");
        tableMoyenTransport.getColumns().add(3, imageColumn);
        columnMoyenIcon.setCellValueFactory(new PropertyValueFactory<>("icon"));
        columnMoyenNbrPlaces.setCellValueFactory(new PropertyValueFactory<>("nbr_places"));
        columnMoyenPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        columnMoyenHoraires.setCellValueFactory(new PropertyValueFactory<>("horaires"));

        tableMoyenTransport.setItems(listMoyenTransport);

        WebEngine engine = webView.getEngine();
        engine.load(t.getImage());

        tfDirections.setText(t.getDirections());
        tfEtat.setText(t.getEtat());

        ObservableList<Etablissement> listEtablissement = FXCollections.observableArrayList(seEtab.findByTrajet(t));
        columnEtabNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnEtabType.setCellValueFactory(new PropertyValueFactory<>("type"));
        columnEtabDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tableEtablissement.setItems(listEtablissement);
        

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://weather1395.p.rapidapi.com/temperature?url="+ t.getDepart()))
                .header("X-RapidAPI-Key", "ab1eae2ac1msh139cbfaa7fa3fbdp1688ecjsne35b49dc8a1d")
                .header("X-RapidAPI-Host", "weather1395.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            //weatherText.setText(response.body());
            weatherText.setText("32°");
            
        } catch (IOException ex) {
            Logger.getLogger(DetailsTrajetFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(DetailsTrajetFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private LigneTransport reserver(MouseEvent event) throws IOException {
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../Reservation/User/HomeReservationUSER.fxml"));
                System.out.println("vous avez reservez ce " + lt);
                Parent parent = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setTitle("Mes Reservations ");
                stage.setScene(scene);
                stage.show();
                
                System.out.println("vous avez reservez ce " + lt);
                 CurrentLigneTransportId.id=lt.getId();

                return lt;
            } else {
                tableMoyenTransport.getSelectionModel().clearSelection();
            }

        }
        return null;
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChercherTrajetFXML.fxml"));
        Parent chercherTrajet = loader.load();

        Stage chercherTrajetStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene chercherTrajetScene = new Scene(chercherTrajet);

        chercherTrajetStage.setTitle("chercher Trajet: ");
        chercherTrajetStage.setScene(chercherTrajetScene);
        chercherTrajetStage.show();
    }

    public class ImageColumn extends TableColumn<MoyenTransport, String> {

        public ImageColumn(String title, String imageUrlProperty) {
            super(title);
            setCellValueFactory(new PropertyValueFactory<>("icon"));
            setCellFactory(column -> new ImageCell());
        }

        private class ImageCell extends TableCell<MoyenTransport, String> {

            private ImageView imageView = new ImageView();

            @Override
            protected void updateItem(String imageUrl, boolean empty) {
                super.updateItem(imageUrl, empty);

                if (empty || imageUrl == null) {
                    setGraphic(null);
                } else {
                    Image image = new Image("C:\\Users\\kandi\\OneDrive\\Documents\\NetBeansProjects\\myWay\\src\\myway\\Assets/" + imageUrl);
                    imageView.setImage(image);
                    imageView.setFitWidth(30);
                    imageView.setFitHeight(35);
                    setGraphic(imageView);
                }
            }
        }
    }

    //zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
    void getWeatherData(ActionEvent event) throws MalformedURLException {

    }

}
