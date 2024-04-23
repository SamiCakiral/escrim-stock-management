package com.webapp.mvc.materiel;

import java.util.Date;

public class Equipement extends MaterielMedical {
    private String maintenanceSchedule;
    private String operationalStatus;
    
    /**
     * Constructeur de la classe Equipement.
     * 
     * @param nom Le nom de l'équipement.
     * @param quantiteEnStock La quantité en stock de l'équipement.
     * @param description La description de l'équipement.
     * @param fournisseur Le fournisseur de l'équipement.
     * @param dateExpiration La date d'expiration de l'équipement.
     * @param maintenanceSchedule Le planning de maintenance de l'équipement.
     * @param operationalStatus Le statut opérationnel de l'équipement.
     * @param ColiId L'identifiant du colis de l'équipement.
     * @param poids Le poids de l'équipement.
     */
    public Equipement(String nom, int quantiteEnStock, String description, String fournisseur, Date dateExpiration,
         int ColiId, double poids) {
        super(nom, quantiteEnStock, description, fournisseur, dateExpiration, ColiId, poids);
        
    }

    /**
     * Effectue la maintenance de l'équipement.
     */
    public void maintenance() {
        System.out.println("Performing maintenance for equipment: " + this.getNom());
    }

    /**
     * Met à jour le statut de l'équipement.
     */
    public void mettreAJourStatut() {
        this.operationalStatus = "Updated status";
    }

    /**
     * Obtient le planning de maintenance de l'équipement.
     * 
     * @return Le planning de maintenance.
     */
    public String getMaintenanceSchedule() {
        return maintenanceSchedule;
    }

    /**
     * Définit le planning de maintenance de l'équipement.
     * 
     * @param maintenanceSchedule Le planning de maintenance.
     */
    public void setMaintenanceSchedule(String maintenanceSchedule) {
        this.maintenanceSchedule = maintenanceSchedule;
    }

    /**
     * Obtient le statut opérationnel de l'équipement.
     * 
     * @return Le statut opérationnel.
     */
    public String getOperationalStatus() {
        return operationalStatus;
    }

    /**
     * Définit le statut opérationnel de l'équipement.
     * 
     * @param operationalStatus Le statut opérationnel.
     */
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
