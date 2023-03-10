/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.GUI.Location.User;

import java.text.SimpleDateFormat;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import myway.Entities.Location;
import myway.Entities.contrat_location;
import myway.Services.ServiceContratLocation;
import myway.Services.ServiceLocation;

/**
 *
 * @author 9naydel
 */
public class MycardnewController extends Pane {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final String BACKGROUND_COLOR = "#ADD8E6";
    private static final String BORDER_COLOR = "#566588";
    private static final String TEXT_COLOR = "#235A87";
    private static final String TITLE_COLOR = "#F4F6F7";
    private static final String DATE_COLOR = "#2596be";
    private static final String TYPE_COLOR = "#2596be";

    private Location location;
    private contrat_location contrat_location;
    //Location location =new Location();

    // ServiceContratLocation sc = new ServiceContratLocation();
    ServiceLocation sl = new ServiceLocation();
    ServiceContratLocation s2 = new ServiceContratLocation();

    public MycardnewController(Location location) {

        this.location = location;
        List<contrat_location> l = s2.afficherBYIDLocation(location.getId());
         
        
        setPrefSize(WIDTH, HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.web(BACKGROUND_COLOR), new CornerRadii(10), Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.web(BORDER_COLOR), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
        //Creating a Button
        /*Button button = new Button();
      //Setting text to the button
      button.setText("envoie demande de participation");
      //Setting the location of the button
    button.setPrefWidth(250);
      button.setTranslateY(200);
      button.setTranslateX(50);*/

        Label titleLabel = new Label(location.getNom());
        titleLabel.setFont(Font.font("Arial", 18));

        titleLabel.setTextFill(Color.web(TITLE_COLOR));
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setPrefWidth(WIDTH - 20);
        titleLabel.setLayoutY(20); 

        titleLabel.setStyle("-fx-background-color: #256D7B;");
        Label descriptionLabel = new Label("Description: " + location.getDescription());
        descriptionLabel.setFont(Font.font("Arial", 14));
        descriptionLabel.setTextFill(Color.web(TEXT_COLOR));
        descriptionLabel.setWrapText(true);
        descriptionLabel.setPrefWidth(WIDTH - 40);
        descriptionLabel.setAlignment(Pos.CENTER);
        descriptionLabel.setLayoutY(50);
       
        Label paysLabel = new Label("disponibilite:     " + location.getDisponibilite() + "            Type:   " + location.getType());
        paysLabel.setFont(Font.font("Arial", 14));
        paysLabel.setTextFill(Color.web(TEXT_COLOR));
        paysLabel.setWrapText(true);
        paysLabel.setAlignment(Pos.CENTER);
        paysLabel.setPrefWidth(WIDTH - 40);
        paysLabel.setLayoutY(75);

  
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 0, 10));
        //     borderPane.setBorder(new Insets(10, 10, 0, 10));
             if(!l.isEmpty()){
         contrat_location contrat =l.get(0);
         
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String debutDateStr = dateFormat.format(contrat.getDebut());
        String finDateStr = dateFormat.format(contrat.getFin());
        Label dateLabel = new Label("Date de debut :" + debutDateStr + " -  Date de fin :" + finDateStr);
        dateLabel.setFont(Font.font("Arial", 14));
        dateLabel.setTextFill(Color.web(DATE_COLOR));
        dateLabel.setWrapText(true);
        dateLabel.setAlignment(Pos.CENTER);
        dateLabel.setPrefWidth(WIDTH - 40);
        dateLabel.setLayoutY(120);
        
         Label prixLabel = new Label("prix: " + contrat.getPrix() );
        prixLabel.setFont(Font.font("Arial", 20));
        prixLabel.setTextFill(Color.web(TEXT_COLOR));
        prixLabel.setWrapText(true);
        prixLabel.setAlignment(Pos.CENTER);
        prixLabel.setPrefWidth(WIDTH - 40);
        prixLabel.setLayoutY(140);

  
        borderPane.setTop(titleLabel);
        borderPane.setBottom(descriptionLabel);
        borderPane.setCenter(new Pane(dateLabel,paysLabel,prixLabel));
           }else{
             
                  
             
               borderPane.setTop(titleLabel);
        borderPane.setCenter(descriptionLabel);
         
        borderPane.setBottom(new Pane(paysLabel));
            }
             
        //typeLabel

        getChildren().addAll(borderPane);

    }
}
