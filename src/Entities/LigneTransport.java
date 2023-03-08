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
public class LigneTransport {
    private int id_ligne;
private Trajet trajet;
private MoyenTransport moyentransport;

    public LigneTransport() {
    }

    public LigneTransport(Trajet trajet, MoyenTransport moyentransport) {
        this.trajet = trajet;
        this.moyentransport = moyentransport;
    }

  

    public int getId_ligne() {
        return id_ligne;
    }

    public void setId_ligne(int id_ligne) {
        this.id_ligne = id_ligne;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public MoyenTransport getMoyentransport() {
        return moyentransport;
    }

    public void setMoyentransport(MoyenTransport moyentransport) {
        this.moyentransport = moyentransport;
    }

    @Override
    public String toString() {
        return "LigneTransport{" + "id_ligne=" + id_ligne + ", trajet=" + trajet + ", moyentransport=" + moyentransport + '}';
    }

   

   

}
