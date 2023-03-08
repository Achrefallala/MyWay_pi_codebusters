/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entities.LigneTransport;
import Entities.MoyenTransport;
import Entities.Trajet;
import Utils.MyDB;

/**
 *
 * @author Slim
 */
public class ServiceLigneTransport implements IServices<LigneTransport> {

    Connection cnx;

    @Override
    public void add(LigneTransport l) {
    }

    @Override
    public List<LigneTransport> afficher() {
        List<LigneTransport> ligneTransports = new ArrayList<>();

        return ligneTransports;

    }

    public void supprimer(LigneTransport l) {
    }

    public void modifier(LigneTransport l) {
    }

    public LigneTransport findByIdTrajetAndId_MoyenTp(int id_trajet, int id_moyentp) {
        LigneTransport l = new LigneTransport();
        try {
            String qry = "SELECT ligne_transport.id_ligne, trajet.id_trajet, trajet.depart, trajet.destination, trajet.etat, trajet.directions, trajet.image,  moyen_transport.id_moyentp, moyen_transport.organisation, moyen_transport.type, moyen_transport.icon, moyen_transport.nbr_places, moyen_transport.prix, moyen_transport.horaires FROM moyen_transport JOIN ligne_transport  ON moyen_transport.id_moyentp = ligne_transport.id_moyentp JOIN trajet  ON ligne_transport.id_trajet = trajet.id_trajet WHERE trajet.id_trajet = " + id_trajet + " AND moyen_transport.id_moyentp = '" + id_moyentp +"'";
            System.out.println(qry);

            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {

                MoyenTransport e = new MoyenTransport();
                e.setId_moyentp(rs.getInt("id_moyentp"));
                e.setOrganisation(rs.getString("organisation"));
                e.setType(rs.getString("type"));
                e.setIcon(rs.getString("icon"));
                e.setNbr_places(rs.getInt("nbr_places"));
                e.setPrix(rs.getDouble("prix"));
                e.setHoraires(rs.getString("horaires"));

                Trajet t = new Trajet();
                t.setId(rs.getInt("id_trajet"));
                t.setDepart(rs.getString("depart"));
                t.setDestination(rs.getString("destination"));
                t.setEtat(rs.getString("etat"));
                t.setDirections(rs.getString("directions"));
                t.setImage(rs.getString("image"));

                l.setId_ligne(rs.getInt("id_ligne"));
                l.setMoyentransport(e);
                l.setTrajet(t);
            }
            return l;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return l;

    }

}
