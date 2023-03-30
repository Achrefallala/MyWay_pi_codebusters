/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.MoyenTransport;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Slim
 */
public class ServiceMoyenTransport implements IServices<MoyenTransport> {

    Connection cnx;

    @Override
    public void add(MoyenTransport e) {
    }

    @Override
    public List<MoyenTransport> afficher() {
        List<MoyenTransport> MoyenTransports = new ArrayList<>();
        try {
            String qry = "SELECT * FROM Moyen_Transport ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {

                MoyenTransport e = new MoyenTransport();
                e.setId(rs.getInt("id_moyentp"));

                e.setMatricule(rs.getString("matricule"));
                e.setOrganisation(rs.getString("organisation"));
                e.setType(rs.getString("type"));
                e.setIcon(rs.getString("icon"));
                e.setNbr_places(rs.getInt("nbr_places"));
                e.setPrix(rs.getDouble("prix"));
                e.setHoraires(rs.getString("horaires"));
                e.setNom(rs.getString("nom"));

                MoyenTransports.add(e);
            }
            return MoyenTransports;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return MoyenTransports;

    }

    @Override
    public void supprimer(MoyenTransport m) {
    }

    @Override
    public void modifier(MoyenTransport m) {
    }

    public List<MoyenTransport> findByMatricule(String matricule) {
        List<MoyenTransport> MoyenTransports = new ArrayList<>();
        try {
            String qry = "SELECT * FROM Moyen_Transport WHERE matricule = '" + matricule + "'";
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
                e.setNom(rs.getString("nom"));

                MoyenTransports.add(e);
            }
            return MoyenTransports;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return MoyenTransports;

    }
/*
    public List<MoyenTransport> findByIdTrajet(int id_trajet) {

        List<MoyenTransport> MoyenTransports = new ArrayList<>();
        try {
            String qry = "SELECT m.nom m.matricule, m.organisation, m.type, m.icon, m.nbr_places, m.prix, m.horaires FROM moyen_transport m JOIN ligne_transport l ON m.matricule = l.matricule_moyentp JOIN trajet t ON l.id_trajet = t.id WHERE id = " + id_trajet;
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
                e.setNom(rs.getString("nom"));

                MoyenTransports.add(e);
            }
            return MoyenTransports;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return MoyenTransports;

    }*/
}
