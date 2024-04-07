package com.webapp.mvc.model.medical;

public class Equipement extends MaterielMedical {
    private String maintenanceSchedule;
    private String operationalStatus;
    
    public Equipement(int id, String nom, int quantiteEnStock, String description, String fournisseur,
            String maintenanceSchedule, String operationalStatus) {
        super(id, nom, quantiteEnStock, description, fournisseur);
        this.maintenanceSchedule = maintenanceSchedule;
        this.operationalStatus = operationalStatus;
    }

    public void maintenance() {
        // Implement maintenance logic here
        // For example:
        System.out.println("Performing maintenance for equipment: " + this.getNom());
    }

    public void mettreAJourStatut() {
        // Implement status update logic here
        // For example:
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

}
