/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Slim
 */
public class MoyenTransport {

    private int id_moyentp, nbr_places;
    private String matricule, organisation, type, icon, horaires;
    private double prix;

    public MoyenTransport() {
    }

    public MoyenTransport(int nbr_places, String matricule, String organisation, String type, String icon, String horaires, double prix) {
        this.nbr_places = nbr_places;
        this.matricule = matricule;
        this.organisation = organisation;
        this.type = type;
        this.icon = icon;
        this.horaires = horaires;
        this.prix = prix;
    }

    public int getId_moyentp() {
        return id_moyentp;
    }

    public void setId_moyentp(int id_moyentp) {
        this.id_moyentp = id_moyentp;
    }

    public int getNbr_places() {
        return nbr_places;
    }

    public void setNbr_places(int nbr_places) {
        this.nbr_places = nbr_places;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHoraires() {
        return horaires;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "MoyenTransport{" + "id_moyentp=" + id_moyentp + ", nbr_places=" + nbr_places + ", matricule=" + matricule + ", organisation=" + organisation + ", type=" + type + ", icon=" + icon + ", horaires=" + horaires + ", prix=" + prix + '}';
    }
    

}
