/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Guide;
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
 
public class ServiceGuide {
       Connection cnx;
    public List<Guide> afficher() {
        List<Guide> Guide = new ArrayList<>();
        try {
            String qry = "SELECT * FROM Guide ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {

                Guide e = new Guide();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setAge(rs.getInt("age"));
                e.setLangues(rs.getString("langues"));
                e.setExperiences(rs.getString("experiences"));
//                e.setEtoiles(rs.getInt("etoiles"));


                Guide.add(e);
            }
            return Guide;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Guide;

    }
     public void add(Guide cl) {
         try {
        String qry ="INSERT INTO `guide`( `nom`, `prenom`, `age`, `langues`,`experiences`) VALUES ('"+cl.getNom()+"','"+cl.getPrenom()+"','"+cl.getAge()+"','"+cl.getLangues()+"','"+cl.getExperiences()+"')";   
      cnx = MyDB.getInstance().getCnx();

            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }
    public void modifier(Guide cl) {
        
       try {
String qry = "UPDATE guide SET nom='" + cl.getNom() + "',prenom='" + cl.getPrenom() + "',age='" + cl.getAge() + "',langues='" + cl.getLangues() + "',experiences='" + cl.getExperiences() + "' WHERE id='" + cl.getId() + "'";
cnx = MyDB.getInstance().getCnx();
Statement stm = cnx.createStatement();
stm.executeUpdate(qry);
} catch (SQLException ex) {
System.out.println(ex.getMessage());
}
      }

    public void supprimer(int id) {
      try {
String qry = "DELETE FROM guide WHERE id='" + id + "'";
cnx = MyDB.getInstance().getCnx();
Statement stm = cnx.createStatement();
stm.executeUpdate(qry);
} catch (SQLException ex) {
System.out.println(ex.getMessage());
}
         }
    
    
    
//     public void supprimerByid(int cl) {
//        try {
//        String qry ="DELETE FROM `contrat_location` WHERE id_location='" + cl+ "'";
//        cnx = MyDB.getInstance().getCnx();
//      
//            Statement stm =cnx.createStatement();
//            
//            stm.executeUpdate(qry);
//            
//        } catch (SQLException ex) {
//             System.out.println(ex.getMessage());
//        } 
//         }
}
