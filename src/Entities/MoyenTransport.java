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
    private String matricule, organisation, type, icon, horaires;
    private int nbr_places;
    private double prix;

    public MoyenTransport() {
    }

    public MoyenTransport(String organisation, String type, String icone, String horaires, int nbr_places, double prix) {
        this.organisation = organisation;
        this.type = type;
        this.icon = icone;
        this.horaires = horaires;
        this.nbr_places = nbr_places;
        this.prix = prix;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getOrganisation() {
        return organisation;
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

    public double getPrix() {
        return prix;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
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

    public void setPrix (double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "MoyenTransport{" + "matricule=" + matricule + ", organisation=" + organisation + ", type=" + type + ", icone=" + icon + ", horaires=" + horaires + ", nbr_places=" + nbr_places + ", prix_ticket=" + prix + '}';
    }
    
}