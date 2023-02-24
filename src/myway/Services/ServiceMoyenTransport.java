/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import myway.Entities.MoyenTransport;
import myway.Utils.MyDB;

/**
 *
 * @author 9naydel
 */
public class ServiceMoyenTransport implements IServices<MoyenTransport> {
    Connection cnx;


    @Override
    public void add(MoyenTransport e) {}

    @Override
    public List<MoyenTransport> afficher() {
        List<MoyenTransport> MoyenTransports = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `Moyen_Transport` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                
                MoyenTransport e = new MoyenTransport();
                e.setMatricule(rs.getString("matricule"));
                e.setOrganisation(rs.getString("organisation"));
                e.setType(rs.getString("type"));
                e.setIcon(rs.getString("icon"));
                e.setNbr_places(rs.getInt("nbr_places"));
                e.setPrix_ticket(rs.getDouble("prix_ticket"));
                e.setHoraires(rs.getString("horaires"));

                MoyenTransports.add(e);
            }
            return MoyenTransports;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return MoyenTransports;

    }

    @Override
    public void supprimer(MoyenTransport m) {}

    @Override
    public void modifier(MoyenTransport e, String colonne, String valeur) {}

    public List<MoyenTransport> findByMatricule(String matricule) {
        List<MoyenTransport> MoyenTransports = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `Moyen_Transport` WHERE matricule = '" + matricule + "'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                
                MoyenTransport e = new MoyenTransport();
                e.setMatricule(rs.getString("matricule"));
                e.setOrganisation(rs.getString("organisation"));
                e.setType(rs.getString("type"));
                e.setIcon(rs.getString("icon"));
                e.setNbr_places(rs.getInt("nbr_places"));
                e.setPrix_ticket(rs.getDouble("prix_ticket"));
                e.setHoraires(rs.getString("horaires"));

                MoyenTransports.add(e);
            }
            return MoyenTransports;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return MoyenTransports;

    }

    public List<MoyenTransport> findByIdTrajet(int id_trajet){
        
        
        List<MoyenTransport> MoyenTransports = new ArrayList<>();
        try {
            String qry = "SELECT m.matricule, m.organisation, m.type, m.icon, m.nbr_places, m.prix_ticket, m.horaires FROM `moyen_transport` m JOIN `ligne_transport` l ON m.matricule = l.matricule_moyentp JOIN `trajet` t ON l.id_trajet = t.id WHERE id_trajet = " + id_trajet ;
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                
                MoyenTransport e = new MoyenTransport();
                e.setMatricule(rs.getString("matricule"));
                e.setOrganisation(rs.getString("organisation"));
                e.setType(rs.getString("type"));
                e.setIcon(rs.getString("icon"));
                e.setNbr_places(rs.getInt("nbr_places"));
                e.setPrix_ticket(rs.getDouble("prix_ticket"));
                e.setHoraires(rs.getString("horaires"));

                MoyenTransports.add(e);
            }
            return MoyenTransports;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return MoyenTransports;
        
    }
}
