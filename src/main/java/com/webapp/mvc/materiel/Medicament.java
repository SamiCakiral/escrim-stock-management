package com.webapp.mvc.materiel;

import java.util.Date;

/**
 * Cette classe représente un médicament qui est un type de matériel médical.
 * Elle hérite de la classe MaterielMedical.
 * 
 * @author CS
 */
public class Medicament extends MaterielMedical {
    private Date dateExpiration;
    private String indications;
    private String contreIndications;

    /**
     * Constructeur de la classe Medicament.
     * 
     * @param nom Le nom du médicament.
     * @param quantiteEnStock La quantité en stock du médicament.
     * @param description La description du médicament.
     * @param fournisseur Le fournisseur du médicament.
     * @param dateExpiration La date d'expiration du médicament.
     * @param indications Les indications du médicament.
     * @param contreIndications Les contre-indications du médicament.
     * @param ColiId L'identifiant du colis du médicament.
     * @param poids Le poids du médicament.
     */
    public Medicament(String nom, int quantiteEnStock, String description, String fournisseur,
            Date dateExpiration, String indications, String contreIndications, int ColiId, double poids) {
        super(nom, quantiteEnStock, description, fournisseur, dateExpiration, ColiId, poids);
        this.indications = indications;
        this.contreIndications = contreIndications;
    }

    /**
     * Vérifie si le médicament est expiré en comparant la date d'expiration avec la date actuelle.
     */
    public void verifierExpiration() {
        Date currentDate = new Date();
        if (currentDate.after(dateExpiration)) {
            System.out.println("Le médicament est expiré");
        } else {
            System.out.println("Le médicament est encore valide");
        }
    }

    /**
     * Affiche les indications du médicament.
     */
    public void afficherIndications() {
        System.out.println("Indications : " + indications);
    }

    /**
     * Affiche les contre-indications du médicament.
     */
    public void afficherContreIndications() {
        System.out.println("Contre-indications : " + contreIndications);
    }

    // Setters

    /**
     * Modifie les indications du médicament.
     * 
     * @param indications Les nouvelles indications du médicament.
     */
    public void setIndications(String indications) {
        this.indications = indications;
    }

    /**
     * Modifie les contre-indications du médicament.
     * 
     * @param contreIndications Les nouvelles contre-indications du médicament.
     */
    public void setContreIndications(String contreIndications) {
        this.contreIndications = contreIndications;
    }

    // Getters

    /**
     * Retourne les indications du médicament.
     * 
     * @return Les indications du médicament.
     */
    public String getIndications() {
        return indications;
    }

    /**
     * Retourne les contre-indications du médicament.
     * 
     * @return Les contre-indications du médicament.
     */
    public String getContreIndications() {
        return contreIndications;
    }
}