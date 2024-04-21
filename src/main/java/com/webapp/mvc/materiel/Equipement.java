package com.webapp.mvc.materiel;

import java.util.Date;

public class Equipement extends MaterielMedical {
    private String maintenanceSchedule;
    private String operationalStatus;
    
    public Equipement(String nom, int quantiteEnStock, String description, String fournisseur, Date dateExpiration,
            String maintenanceSchedule, String operationalStatus, int ColiId, double poids) {
        super(nom, quantiteEnStock, description, fournisseur, dateExpiration, ColiId, poids);
        this.maintenanceSchedule = maintenanceSchedule;
        this.operationalStatus = operationalStatus;
    }

    public void maintenance() {
        
        System.out.println("Performing maintenance for equipment: " + this.getNom());
    }

    public void mettreAJourStatut() {
        
        this.operationalStatus = "Updated status";
    }

    public String getMaintenanceSchedule() {
        return maintenanceSchedule;
    }

    public void setMaintenanceSchedule(String maintenanceSchedule) {
        this.maintenanceSchedule = maintenanceSchedule;
    }

    public String getOperationalStatus() {
        return operationalStatus;
    }

    public void setOperationalStatus(String operationalStatus) {
        this.operationalStatus = operationalStatus;
    }

    // public Date getDateExpiration() {
    //     return dateExpiration;
    // }

    // public void setDateExpiration(Date dateExpiration) {
    //     this.dateExpiration = dateExpiration;
    // }

}
