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
import myway.Entities.LigneTransport;
import myway.Entities.MoyenTransport;
import myway.Entities.Trajet;
import myway.Utils.MyDB;

/**
 *
 * @author 9naydel
 */
public class ServiceLigneTransport implements IServices<LigneTransport> {
    Connection cnx;

    @Override
    public void add(LigneTransport l) {}

    @Override
    public List<LigneTransport> display() {
        List<LigneTransport> ligneTransports = new ArrayList<>();
        
        return ligneTransports;

    }

    @Override
    public void delete(LigneTransport l) {}

    @Override
    public void update(LigneTransport l) {}

    public LigneTransport findByIdTrajetAndMatriculeMoyenTp(int idTrajet, int idMoyenTp) {
        LigneTransport ligneTransport = new LigneTransport();
        try {
            String qry = "SELECT l.id, t.id, t.depart, t.destination, t.etat, t.directions, t.image, m.id, m.matricule, m.organisation, m.type, m.icon, m.nbr_places, m.prix, m.horaires FROM `moyen_transport` m JOIN `ligne_transport` l ON m.id = l.id_moyentp JOIN `trajet` t ON l.id_trajet = t.id WHERE id_trajet = " + idTrajet + " AND id_moyentp = " + idMoyenTp  ;
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                
                MoyenTransport e = new MoyenTransport();
                e.setId(rs.getInt("id"));
                e.setMatricule(rs.getString("matricule"));
                e.setOrganisation(rs.getString("organisation"));
                e.setType(rs.getString("type"));
                e.setIcon(rs.getString("icon"));
                e.setNbr_places(rs.getInt("nbr_places"));
                e.setPrix(rs.getDouble("prix"));
                e.setHoraires(rs.getString("horaires"));
                
                Trajet t = new Trajet();
                t.setId(rs.getInt("id"));
                t.setDepart(rs.getString("depart"));
                t.setDestination(rs.getString("destination"));
                t.setEtat(rs.getString("etat"));
                t.setDirections(rs.getString("directions"));
                t.setImage(rs.getString("image"));

                ligneTransport.setId(rs.getInt("id"));
                ligneTransport.setMoyenTransport(e);
                ligneTransport.setTrajet(t);
            }
            return ligneTransport;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ligneTransport;

    }

    
}
