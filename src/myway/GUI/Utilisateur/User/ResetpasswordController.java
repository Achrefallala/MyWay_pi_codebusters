/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package myway.GUI.Utilisateur.User;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import myway.Services.ServiceUtilisateur;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author 9naydel
 */
public class ResetpasswordController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private Button btnenvoyer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    ServiceUtilisateur su = new ServiceUtilisateur();

    @FXML
    private void handleResetPassword(ActionEvent event) {

        // create a java mail session
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.mailtrap.io");
        props.put("mail.smtp.port", "2525");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.user", "4232778ae601de");
        props.put("mail.smtp.password", "61057953341fa3");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("4232778ae601de", "61057953341fa3");
            }
        });

        // generate a random password string
        String password = generateRandomPassword(8);

        // create the Mime type "email"
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("test@wale.sh"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getText()));
            message.setSubject("Reset Password");
            message.setContent(
                    "<p>Password has been reset. Please use the following password to login:</p>" +
                            "<p style=\"font-size: 1.2em; font-weight: bold; background-color: #F2F2F2; padding: 10px; border-radius: 5px;\">" +
                            password + "</p>", "text/html"
            );

            if(su.updatePassword(email.getText(), password)) {
                Transport.send(message);
                System.out.println("Password updated successfully");
            } else {
                System.out.println("Password update failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String generateRandomPassword(int len) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int index = (int) (chars.length() * Math.random());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }
    
}
