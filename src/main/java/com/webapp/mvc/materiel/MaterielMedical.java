package com.webapp.mvc.materiel;

import java.util.Date; 


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
    

    public void ajouterStock(int quantite) {
        quantiteEnStock += quantite;
    }
    
    public void retirerStock(int quantite) {
        quantiteEnStock -= quantite;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getNomComplet() {
        return this.nom + " - " + this.id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public int getColi() {
        return Coli;
    }

    public void setColi(int Coli) {
        this.Coli = Coli;
    }

    public String getType() {
        return (this instanceof Equipement) ? "Equipement" : "Medicament";
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    } 
}
