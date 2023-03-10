/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Services;



import java.sql.Statement;


import myway.Entities.LigneTransport1;
import myway.Entities.Moyentp;
import myway.Entities.Trajet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import myway.Utils.MyDB;

/**
 *
 * @author 9naydel
 */
public class ServiceLigneTransport1  {

   Connection cnx;

    public ServiceLigneTransport1 () {
        cnx = MyDB.getInstance().getCnx();
    }

    
    public void ajouter(LigneTransport1 t) {
        try {
            String sql;
            sql = "insert into ligne_transport (id_moyentp,id_trajet) values ('"+ t.getMoyenTransport().getId()+ "','"+t.getTrajet().getId()+"')";
            Statement ste = (Statement) cnx.createStatement();
            
           
            ste.executeUpdate(sql);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public List<LigneTransport1> getAll() {
        List <LigneTransport1> list =new ArrayList<>() ;
        
        try {
            String qry = "SELECT l.id, t.id, t.depart, t.destination, t.etat, t.directions, t.image, m.id, m.matricule, m.type, m.nbreplace, m.prix_ticket, m.horaire ,m.nom FROM moyentp m JOIN ligne_transport l ON m.id = l.id_moyentp JOIN trajet t ON l.id_trajet = t.id";
            
         
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                LigneTransport1 ligneTransport = new LigneTransport1();
                Moyentp e = new Moyentp();
                e.setId(rs.getInt("id"));
                e.setMatricule(rs.getString("matricule"));
               
                e.setType(rs.getString("type"));
                
                e.setNbreplace(rs.getInt("nbreplace"));
                e.setPrix_ticket(rs.getFloat("prix_ticket"));
                e.setHoraire(rs.getString("horaire"));
                e.setNom(rs.getString("nom"));
                
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
                
                
                list.add(ligneTransport);
                
            }
            return list;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
return list;
    }

    
    public List<LigneTransport1> findByMatricule(String matricule) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public List<LigneTransport1> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void supprimer(LigneTransport1 t) {
       try {
            String sql="delete from ligne_transport where id=?";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
    

     
  public LigneTransport1 findByIdTrajetAndMatriculeMoyenTp(int idTrajet, int idMoyenTp) {
        LigneTransport1 ligneTransport = new LigneTransport1();
        try {
            String qry = "SELECT l.id, t.id, t.depart, t.destination, t.etat, t.directions, t.image, m.id, m.matricule, m.type, m.nbreplace, m.prix_ticket, m.horaire ,m.nom FROM moyentp m JOIN ligne_transport l ON m.id = l.id_moyentp JOIN trajet t ON l.id_trajet = t.id WHERE id_trajet = " + idTrajet + " AND id_moyentp = " + idMoyenTp  ;
            
         
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                
                Moyentp e = new Moyentp();
                e.setId(rs.getInt("id"));
                e.setMatricule(rs.getString("matricule"));
               
                e.setType(rs.getString("type"));
                
                e.setNbreplace(rs.getInt("nbreplace"));
                e.setPrix_ticket(rs.getFloat("prix_ticket"));
                e.setHoraire(rs.getString("horaire"));
                e.setHoraire(rs.getString("nom"));
                
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
    
 public void modifier(LigneTransport1 p) {
       try {
            
            String qry = "UPDATE ligne SET " + "id_moyentp = '" + p.getMoyenTransport().getId() + "'" + ", id_trajet = '" + p.getTrajet().getId() + "'"+ "WHERE id = " + p.getId();
            
           

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    }
