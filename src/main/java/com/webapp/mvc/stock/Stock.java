package com.webapp.mvc.stock;
import com.webapp.mvc.materiel.MaterielMedical;
public class Stock {
    private int idMateriel;
    private int quantite;
    private String emplacement;

    public void ajouterAuStock(MaterielMedical materiel, int quantite) {
        // Add implementation here
    }

    public void retirerDuStock(MaterielMedical materiel, int quantite) {
        // Add implementation here
    }

    public void mettreAJourInventaire() {
        // Add implementation here
    }
    // Getters and Setters
    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }
}
