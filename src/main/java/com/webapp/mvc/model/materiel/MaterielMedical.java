package com.webapp.mvc.model.materiel;

public abstract class MaterielMedical {
    private int id;
    private String nom;
    private int quantiteEnStock;
    private String description;
    private String fournisseur;
    

    public MaterielMedical(int id, String nom, int quantiteEnStock, String description, String fournisseur) {
        this.id = id;
        this.nom = nom;
        this.quantiteEnStock = quantiteEnStock;
        this.description = description;
        this.fournisseur = fournisseur;
    }

    public void ajouterStock(int quantite) {
        quantiteEnStock += quantite;
    }
    
    public void retirerStock(int quantite) {
        quantiteEnStock -= quantite;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
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
}
