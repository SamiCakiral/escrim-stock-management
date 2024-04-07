package com.webapp.mvc.model.medical;

import java.util.Date;

public class Medicament extends MaterielMedical {
    private Date dateExpiration;
    private String indications;
    private String contreIndications;

    public Medicament(int id, String nom, int quantiteEnStock, String description, String fournisseur,
            Date dateExpiration, String indications, String contreIndications) {
        super(id, nom, quantiteEnStock, description, fournisseur);
        this.dateExpiration = dateExpiration;
        this.indications = indications;
        this.contreIndications = contreIndications;
    }

    public void verifierExpiration() {
        Date currentDate = new Date();
        if (currentDate.after(dateExpiration)) {
            System.out.println("Medicament has expired");
        } else {
            System.out.println("Medicament is still valid");
        }
    }

    public void afficherIndications() {
        System.out.println("Indications: " + indications);
    }

    public void afficherContreIndications() {
        System.out.println("Contre-indications: " + contreIndications);
    }

    // Setters
    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public void setContreIndications(String contreIndications) {
        this.contreIndications = contreIndications;
    }

    // Getters
    public Date getDateExpiration() {
        return dateExpiration;
    }

    public String getIndications() {
        return indications;
    }

    public String getContreIndications() {
        return contreIndications;
    }
}