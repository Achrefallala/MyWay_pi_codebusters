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

    public LigneTransport findByIdTrajetAndMatriculeMoyenTp(int idTrajet, String matriculeMoyenTp) {
        LigneTransport l = new LigneTransport();
        try {
            String qry = "SELECT l.id_ligne, t.id_trajet, t.depart, t.destination, t.etat, t.directions, t.image,  m.matricule, m.organisation, m.type, m.icon, m.nbr_places, m.prix, m.horaires FROM moyen_transport m JOIN ligne_transport l ON m.matricule = l.matricule JOIN trajet t ON l.id_trajet = t.id_trajet WHERE t.id_trajet = " + idTrajet + " AND m.matricule = '" + matriculeMoyenTp +"'";
            System.out.println(qry);

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
