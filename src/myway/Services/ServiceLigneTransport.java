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
    public List<LigneTransport> afficher() {
        List<LigneTransport> ligneTransports = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `ligne_transport` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                
                LigneTransport e = new LigneTransport();
                e.setId(rs.getInt("id"));
                e.setMatricule_moyentp(rs.getString("matricule"));
                e.setId_trajet(rs.getInt("nbr_places"));
                
                ligneTransports.add(e);
            }
            return ligneTransports;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ligneTransports;

    }

    @Override
    public void supprimer(LigneTransport m) {}

    @Override
    public void modifier(LigneTransport e, String colonne, String valeur) {}

    //public List<LigneTransport> afficher(){}
    
    
}
