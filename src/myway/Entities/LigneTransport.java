/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Entities;

/**
 *
 * @author 9naydel
 */
public class LigneTransport {
    private int id, id_trajet;
    private String matricule_moyentp;

    public LigneTransport() {
    }

    public LigneTransport(int id_trajet, String matricule_moyentp) {
        this.id_trajet = id_trajet;
        this.matricule_moyentp = matricule_moyentp;
    }

    public int getId() {
        return id;
    }

    public int getId_trajet() {
        return id_trajet;
    }

    public String getMatricule_moyentp() {
        return matricule_moyentp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_trajet(int id_trajet) {
        this.id_trajet = id_trajet;
    }

    public void setMatricule_moyentp(String matricule_moyentp) {
        this.matricule_moyentp = matricule_moyentp;
    }

    @Override
    public String toString() {
        return "LigneTransport{" + "id=" + id + ", id_trajet=" + id_trajet + ", matricule_moyentp=" + matricule_moyentp + '}';
    }
    
    
}
