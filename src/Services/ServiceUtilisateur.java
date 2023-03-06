
package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entities.Utilisateur;
import Utils.MyDB;

/**
 *

 */
public class ServiceUtilisateur implements IServices<Utilisateur>{
    Connection cnx;
    @Override
    public void add(Utilisateur t) {
         try {
             /*    public Utilisateur(int id_utilisateur, String nom, String prenom, int num_tel) {
*/
        String qry ="INSERT INTO `utilisateur`(`nom`, `prenom`, `num_tel`) VALUES ('"+t.getNom()+"','"+t.getPrenom()+"','"+t.getNum_tel()+"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }

    @Override
    public List<Utilisateur> afficher() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `utilisateur` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Utilisateur p =new Utilisateur();
                p.setId_utilisateur(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString(3));
                p.setNum_tel(rs.getInt("num_tel"));
                utilisateurs.add(p);
            }
            return utilisateurs;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return utilisateurs;
       
    }

    public int searchUserbyNom(String n) {
            int idUser = 0;
        try {  
            String qry = "SELECT `id_utilisateur` FROM `utilisateur`" + "WHERE nom='"+n+"'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
            
                idUser = rs.getInt(1);
            }
            return idUser;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return idUser;
       
    }
    
        public String searchUserbyId(int id) {
            String nom = "";
        try {  
            String qry = "SELECT `nom` FROM `utilisateur`" + "WHERE id_utilisateur='"+id+"'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
            
                nom = rs.getString(1);
            }
            return nom;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nom;
       
    }
  @Override
    public void modifier(Utilisateur t) {
         try {
        String qry ="UPDATE `utilisateur` SET `nom`='"+t.getNom()+"',`prenom`='"+t.getPrenom()+"',`num_tel`='"+t.getNum_tel()+"' WHERE `id`='"+t.getId_utilisateur()+"'";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }
   

      @Override
    public void supprimer(Utilisateur t) {
       String qry = "DELETE FROM `utilisateur` WHERE `id`='"+t.getId_utilisateur()+"'";
        try {
            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

   
    
   
   
}
