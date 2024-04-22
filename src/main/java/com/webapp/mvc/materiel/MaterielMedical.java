package com.webapp.mvc.materiel;

import java.util.Date; 


/**
 * Cette classe abstraite représente un matériel médical.
 * 
 * @Author CS
 */
public abstract class MaterielMedical {
    private int id;
    private String nom;
    private int quantiteEnStock;
    private String description;
    private String fournisseur;
    private double poids;
    Date dateExpiration; 
    private int Coli;
    
    private static int idCounter = 0;

    /**
     * Constructeur de la classe MaterielMedical.
     * 
     * @param nom Le nom du matériel médical.
     * @param quantiteEnStock La quantité en stock du matériel médical.
     * @param description La description du matériel médical.
     * @param fournisseur Le fournisseur du matériel médical.
     * @param dateExpiration La date d'expiration du matériel médical.
     * @param ColiId L'identifiant du Coli du matériel médical.
     * @param poids Le poids du matériel médical.
     */
    public MaterielMedical(String nom, int quantiteEnStock, String description, String fournisseur, Date dateExpiration, int ColiId, double poids) {
        this.id = idCounter++;
        this.nom = nom;
        this.quantiteEnStock = quantiteEnStock;
        this.description = description;
        this.fournisseur = fournisseur;
        this.dateExpiration = dateExpiration; 
        this.poids = poids;
        this.Coli = ColiId; 
    }
    
    /**
     * Ajoute une quantité spécifiée au stock du matériel médical.
     * 
     * @param quantite La quantité à ajouter.
     */
    public void ajouterStock(int quantite) {
        quantiteEnStock += quantite;
    }
    
    /**
     * Retire une quantité spécifiée du stock du matériel médical.
     * 
     * @param quantite La quantité à retirer.
     */
    public void retirerStock(int quantite) {
        quantiteEnStock -= quantite;
    }

    /**
     * Retourne le poids du matériel médical.
     * 
     * @return Le poids du matériel médical.
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Modifie le poids du matériel médical.
     * 
     * @param poids Le nouveau poids du matériel médical.
     */
    public void setPoids(double poids) {
        this.poids = poids;
    }

    /**
     * Retourne l'identifiant du matériel médical.
     * 
     * @return L'identifiant du matériel médical.
     */
    public int getId() {
        return id;
    }

    /**
     * Modifie l'identifiant du matériel médical.
     * 
     * @param id Le nouvel identifiant du matériel médical.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retourne le nom du matériel médical.
     * 
     * @return Le nom du matériel médical.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Retourne le nom complet du matériel médical, incluant l'identifiant.
     * 
     * @return Le nom complet du matériel médical.
     */
    public String getNomComplet() {
        return this.nom + " - " + this.id;
    }

    /**
     * Modifie le nom du matériel médical.
     * 
     * @param nom Le nouveau nom du matériel médical.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la quantité en stock du matériel médical.
     * 
     * @return La quantité en stock du matériel médical.
     */
    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    /**
     * Modifie la quantité en stock du matériel médical.
     * 
     * @param quantiteEnStock La nouvelle quantité en stock du matériel médical.
     */
    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    /**
     * Retourne la description du matériel médical.
     * 
     * @return La description du matériel médical.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifie la description du matériel médical.
     * 
     * @param description La nouvelle description du matériel médical.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne le fournisseur du matériel médical.
     * 
     * @return Le fournisseur du matériel médical.
     */
    public String getFournisseur() {
        return fournisseur;
    }

    /**
     * Modifie le fournisseur du matériel médical.
     * 
     * @param fournisseur Le nouveau fournisseur du matériel médical.
     */
    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    /**
     * Retourne l'identifiant du Coli du matériel médical.
     * 
     * @return L'identifiant du Coli du matériel médical.
     */
    public int getColi() {
        return Coli;
    }

    /**
     * Modifie l'identifiant du Coli du matériel médical.
     * 
     * @param Coli L'identifiant du Coli du matériel médical.
     */
    public void setColi(int Coli) {
        this.Coli = Coli;
    }

    /**
     * Retourne le type du matériel médical (Equipement ou Medicament).
     * 
     * @return Le type du matériel médical.
     */
    public String getType() {
        return (this instanceof Equipement) ? "Equipement" : "Medicament";
    }

    /**
     * Retourne la date d'expiration du matériel médical.
     * 
     * @return La date d'expiration du matériel médical.
     */
    public Date getDateExpiration() {
        return dateExpiration;
    }

    /**
     * Modifie la date d'expiration du matériel médical.
     * 
     * @param dateExpiration La nouvelle date d'expiration du matériel médical.
     */
    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    } 
}
