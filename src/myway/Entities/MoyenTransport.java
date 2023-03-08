/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Entities;

/**
 *
 * @author 9naydel
 */
public class MoyenTransport {
    private int id;
    private String matricule, organisation, nom, type, icon, horaires;
    private int nbr_places;
    private double prix;

    public MoyenTransport() {
    }

    public MoyenTransport(String matricule, String organisation, String nom, String type, String icon, String horaires, int nbr_places, double prix) {
        this.matricule = matricule;
        this.organisation = organisation;
        this.nom = nom;
        this.type = type;
        this.icon = icon;
        this.horaires = horaires;
        this.nbr_places = nbr_places;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String getIcon() {
        return icon;
    }

    public String getHoraires() {
        return horaires;
    }

    public int getNbr_places() {
        return nbr_places;
    }

    @Override
    public String toString() {
        return "MoyenTransport{" + "id=" + id + ", matricule=" + matricule + ", organisation=" + organisation + ", nom=" + nom + ", type=" + type + ", icon=" + icon + ", horaires=" + horaires + ", nbr_places=" + nbr_places + ", prix=" + prix + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    public void setNbr_places(int nbr_places) {
        this.nbr_places = nbr_places;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }

    

    
    
}
